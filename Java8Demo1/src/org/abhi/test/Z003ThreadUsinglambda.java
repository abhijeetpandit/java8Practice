package org.abhi.test;

public class Z003ThreadUsinglambda {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			for (;;) {
				System.out.println("Hello");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t.start();
	}
}
