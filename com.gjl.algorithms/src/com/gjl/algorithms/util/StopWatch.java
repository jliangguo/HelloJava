package com.gjl.algorithms.util;

/**
 * 计时器。参考Apache实现。
 * 
 * @author Administrator
 * 
 */
public class StopWatch {
	private static final long NANO_2_MILLIS = 1000000L;

	/**
	 * StopWatch状态枚举
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
		 * 是否开始计时
		 * 
		 * @return
		 */
		abstract boolean isStarted();

		/**
		 * 是否停止计时
		 * 
		 * @return
		 */
		abstract boolean isStopped();

		/**
		 * 是否暂停计时
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
	 * 当前状态
	 */
	private State runningState = State.UNSTARTED;

	/**
	 * 是否记录
	 */
	private SplitState splitState = SplitState.UNSPLIT;

	/**
	 * 开始时间（默认纳秒）
	 */
	private long startTime;

	/**
	 * 开始时间（毫秒）
	 */
	private long startTimeMillis;

	/**
	 * 结束时间（默认纳秒）
	 */
	private long stopTime;

	public StopWatch() {
		super();
	}

	/**
	 * 开始新的计时会话任务，清空计时器状态。
	 * 
	 * @throws IllegalStateException
	 *             如果计时器已开始计时
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
	 * 结束新的计时会话任务，允许读取时间。
	 * 
	 * @throws IllegalStateException
	 *             如果计时器已暂停或停止
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
	 * 重置计时器。清空间隔时间，允许对象重用。
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
	 *             如果计时器不在计时
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
	 *             如果计时器已split
	 */
	public void unsplit() {
		if (this.splitState != SplitState.SPLIT) {
			throw new IllegalStateException("Stopwatch has not been split. ");
		}
		this.splitState = SplitState.UNSPLIT;
	}

	/**
	 * 暂停计时器
	 * 
	 * @throws IllegalStateException
	 *             如果计时器不在计时
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
	 * 继续开始计时。
	 * 
	 * @throws IllegalStateException
	 *             如果计数器不在暂停状态
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
	 * 获取计时结果时间（默认毫秒）
	 * 
	 * @return 毫秒时间
	 */
	public long getTime() {
		return getNanoTime() / NANO_2_MILLIS;
	}

	/**
	 * 获取计时结果时间（默认纳秒）
	 * 
	 * @return 纳秒时间
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

	// ============= 查询当前计时器状态 ===============
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
