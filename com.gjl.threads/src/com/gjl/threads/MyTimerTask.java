package com.gjl.threads;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 创建一个每10秒运行的Timer，但单个线程的执行时间花费20秒，Timer对象将持续将任务添加到队列，一旦有任务结束，它就会通知队列，
 * 并且另外一个线程将启动执行。
 * 
 * @author Administrator
 * 
 */
public class MyTimerTask extends TimerTask {

	private static final int BREAKOUT_TIME_SECONDS = 120;
	private static final int TASK_PERIOD_SECONDS = 10;

	public static void main(String[] args) {
		TimerTask timerTask = new MyTimerTask();
		// running timer task as daemon thread
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, TASK_PERIOD_SECONDS * 1000);
		System.out.println("TimerTask started");
		// cancel after sometime
		try {
			Thread.sleep(BREAKOUT_TIME_SECONDS * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();// 如果计时器用于执行守护线程，无论是否取消它，它都会等待所有用户线程结束后终止。
		System.out.println("TimerTask canceled");
		try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("Timer task started at: " + new Date());
		completeTask();
		System.out.println("Timer task finished at: " + new Date());
	}

	/**
	 * 20秒的任务
	 */
	private void completeTask() {
		try {
			// assuming it takes 20 secs to complete the task
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
