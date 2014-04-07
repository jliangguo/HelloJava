package com.gjl.algorithms.util;

/**
 * ��ʱ�����ο�Apacheʵ�֡�
 * 
 * @author Administrator
 * 
 */
public class StopWatch {
	private static final long NANO_2_MILLIS = 1000000L;

	/**
	 * StopWatch״̬ö��
	 */
	private enum State {
		UNSTARTED {

			@Override
			boolean isStarted() {
				return false;
			}

			@Override
			boolean isStopped() {
				return true;
			}

			@Override
			boolean isSuspended() {
				return false;
			}

		},
		RUNNING {

			@Override
			boolean isStarted() {
				return true;
			}

			@Override
			boolean isStopped() {
				return false;
			}

			@Override
			boolean isSuspended() {
				return false;
			}

		},
		STOPPED {
			@Override
			boolean isStarted() {
				return false;
			}

			@Override
			boolean isStopped() {
				return true;
			}

			@Override
			boolean isSuspended() {
				return false;
			}
		},
		SUSPENDED {

			@Override
			boolean isStarted() {
				return true;
			}

			@Override
			boolean isStopped() {
				return false;
			}

			@Override
			boolean isSuspended() {
				return true;
			}

		};

		/**
		 * �Ƿ�ʼ��ʱ
		 * 
		 * @return
		 */
		abstract boolean isStarted();

		/**
		 * �Ƿ�ֹͣ��ʱ
		 * 
		 * @return
		 */
		abstract boolean isStopped();

		/**
		 * �Ƿ���ͣ��ʱ
		 * 
		 * @return
		 */
		abstract boolean isSuspended();
	}

	/**
	 * Enumeration type which indicates the split status of stopwatch.
	 */
	private enum SplitState {
		SPLIT, UNSPLIT
	}

	/**
	 * ��ǰ״̬
	 */
	private State runningState = State.UNSTARTED;

	/**
	 * �Ƿ��¼
	 */
	private SplitState splitState = SplitState.UNSPLIT;

	/**
	 * ��ʼʱ�䣨Ĭ�����룩
	 */
	private long startTime;

	/**
	 * ��ʼʱ�䣨���룩
	 */
	private long startTimeMillis;

	/**
	 * ����ʱ�䣨Ĭ�����룩
	 */
	private long stopTime;

	public StopWatch() {
		super();
	}

	/**
	 * ��ʼ�µļ�ʱ�Ự������ռ�ʱ��״̬��
	 * 
	 * @throws IllegalStateException
	 *             �����ʱ���ѿ�ʼ��ʱ
	 */
	public void start() {
		if (this.runningState == State.STOPPED) {
			throw new IllegalStateException(
					"Stopwatch must be reset before being restarted. ");
		}
		if (this.runningState != State.UNSTARTED) {
			throw new IllegalStateException("Stopwatch already started. ");
		}
		this.startTime = System.nanoTime();
		this.startTimeMillis = System.currentTimeMillis();
		this.runningState = State.RUNNING;
	}

	/**
	 * �����µļ�ʱ�Ự���������ȡʱ�䡣
	 * 
	 * @throws IllegalStateException
	 *             �����ʱ������ͣ��ֹͣ
	 */
	public void stop() {
		if (this.runningState != State.RUNNING
				&& this.runningState != State.SUSPENDED) {
			throw new IllegalStateException("Stopwatch is not running. ");
		}
		if (this.runningState == State.RUNNING) {
			this.stopTime = System.nanoTime();
		}
		this.runningState = State.STOPPED;
	}

	/**
	 * ���ü�ʱ������ռ��ʱ�䣬����������á�
	 */
	public void reset() {
		this.runningState = State.UNSTARTED;
		this.splitState = SplitState.UNSPLIT;
	}

	/**
	 * This method sets the stop time of the watch to allow a time to be
	 * extracted.
	 * 
	 * @throws IllegalStateException
	 *             �����ʱ�����ڼ�ʱ
	 */
	public void split() {
		if (this.runningState != State.RUNNING) {
			throw new IllegalStateException("Stopwatch is not running. ");
		}
		this.stopTime = System.nanoTime();
		this.splitState = SplitState.SPLIT;
	}

	/**
	 * This method clears the stop time. The start time is unaffected, enabling
	 * timing from the original start point to continue.
	 * 
	 * @throws IllegalStateException
	 *             �����ʱ����split
	 */
	public void unsplit() {
		if (this.splitState != SplitState.SPLIT) {
			throw new IllegalStateException("Stopwatch has not been split. ");
		}
		this.splitState = SplitState.UNSPLIT;
	}

	/**
	 * ��ͣ��ʱ��
	 * 
	 * @throws IllegalStateException
	 *             �����ʱ�����ڼ�ʱ
	 */
	public void suspend() {
		if (this.runningState != State.RUNNING) {
			throw new IllegalStateException(
					"Stopwatch must be running to suspend. ");
		}
		this.stopTime = System.nanoTime();
		this.runningState = State.SUSPENDED;
	}

	/**
	 * ������ʼ��ʱ��
	 * 
	 * @throws IllegalStateException
	 *             ���������������ͣ״̬
	 */
	public void resume() {
		if (this.runningState != State.SUSPENDED) {
			throw new IllegalStateException(
					"Stopwatch must be suspended to resume. ");
		}
		this.startTime += System.nanoTime() - this.stopTime;
		this.runningState = State.RUNNING;
	}

	/**
	 * ��ȡ��ʱ���ʱ�䣨Ĭ�Ϻ��룩
	 * 
	 * @return ����ʱ��
	 */
	public long getTime() {
		return getNanoTime() / NANO_2_MILLIS;
	}

	/**
	 * ��ȡ��ʱ���ʱ�䣨Ĭ�����룩
	 * 
	 * @return ����ʱ��
	 */
	public long getNanoTime() {
		if (this.runningState == State.STOPPED
				|| this.runningState == State.SUSPENDED) {
			return this.stopTime - this.startTime;
		} else if (this.runningState == State.UNSTARTED) {
			return 0;
		} else if (this.runningState == State.RUNNING) {
			return System.nanoTime() - this.startTime;
		}
		throw new RuntimeException("Illegal running state has occurred.");
	}

	/**
	 * <p>
	 * Get the split time on the stopwatch.
	 * </p>
	 * 
	 * <p>
	 * This is the time between start and latest split.
	 * </p>
	 * 
	 * @return the split time in milliseconds
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch has not yet been split.
	 */
	public long getSplitTime() {
		return getSplitNanoTime() / NANO_2_MILLIS;
	}

	/**
	 * <p>
	 * Get the split time on the stopwatch in nanoseconds.
	 * </p>
	 * 
	 * <p>
	 * This is the time between start and latest split.
	 * </p>
	 * 
	 * @return the split time in nanoseconds
	 * 
	 * @throws IllegalStateException
	 *             if the StopWatch has not yet been split.
	 */
	public long getSplitNanoTime() {
		if (this.splitState != SplitState.SPLIT) {
			throw new IllegalStateException(
					"Stopwatch must be split to get the split time. ");
		}
		return this.stopTime - this.startTime;
	}

	/**
	 * Returns the time this stopwatch was started.
	 * 
	 * @return
	 */
	@Deprecated
	public long getStartTime() {
		if (this.runningState == State.UNSTARTED) {
			throw new IllegalStateException("Stopwatch has not been started");
		}
		// System.nanoTime is for elapsed time
		return this.startTimeMillis;
	}

	// @Override
	// public String toString() {
	// //return DurationFormatUtils.formatDurationHMS(getTime());
	// }

	// ============= ��ѯ��ǰ��ʱ��״̬ ===============
	public boolean isStarted() {
		return runningState.isStarted();
	}

	public boolean isSuspended() {
		return runningState.isSuspended();
	}

	public boolean isStopped() {
		return runningState.isStopped();
	}
}
