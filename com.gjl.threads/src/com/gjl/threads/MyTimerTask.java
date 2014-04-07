package com.gjl.threads;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ����һ��ÿ10�����е�Timer���������̵߳�ִ��ʱ�仨��20�룬Timer���󽫳�����������ӵ����У�һ����������������ͻ�֪ͨ���У�
 * ��������һ���߳̽�����ִ�С�
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
		timer.cancel();// �����ʱ������ִ���ػ��̣߳������Ƿ�ȡ������������ȴ������û��߳̽�������ֹ��
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
	 * 20�������
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
