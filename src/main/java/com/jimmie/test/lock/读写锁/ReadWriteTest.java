package com.jimmie.test.lock.读写锁;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {
	ReadWriteLock lock = new ReentrantReadWriteLock(true);
	final Lock readLock = lock.readLock();
	final Lock writeLock = lock.writeLock();
	final Resource resource = new Resource();
	final Random random = new Random();

	public class Read extends Thread {
		public void run() {
			for (int i = 0; i < 100; ++i) {// 读线程
				new Thread() {
					public void run() {
						readLock.lock();
						try {
							/*
							 * System.out.println(Thread.currentThread().getName(
							 * )); Thread.sleep(2000);
							 */
							System.out.println(new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss.SSS")
									.format(new Date())
									+ " - "
									+ Thread.currentThread()
									+ "获取了读锁，读取的数据为：" + resource.getValue());
							Thread.sleep(random.nextInt(1000));// 随机休眠
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							readLock.unlock();
						}
					};
				}.start();
			}
		}
	}

	public class Write extends Thread {
		public void run() {
			for (int i = 0; i < 10; ++i) {// 写线程
				new Thread() {
					public void run() {
						writeLock.lock();
						try {
							resource.setValue(resource.getValue() + 1);
							System.out.println(new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss.SSS")
									.format(new Date())
									+ " - "
									+ Thread.currentThread()
									+ "获取了写锁，修正数据为：" + resource.getValue());
							Thread.sleep(random.nextInt(1000));// 随机休眠
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							writeLock.unlock();
						}
					};
				}.start();
			}
		}
	}

	public static void main(String[] args) {
		
		ReadWriteTest test  = new ReadWriteTest();
		test.new Write().start();
		test.new Read().start();
		


		
	}

}
