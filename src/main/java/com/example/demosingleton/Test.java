package com.example.demosingleton;

public class Test {

	
	public static void main(String[] args) {
		
		
//		System.out.println(StaticInnerSingleton.getInstance());
//		System.out.println(StaticInnerSingleton.getInstance());
		
		for (int i = 0; i < 2000; i++) {
			
			Runnable r = new  Runnable() {
				public void run() {
					EnumSingleton.INSTANCE.getInstance();
				}
			};
			Thread t = new Thread(r);
			t.start();
			System.out.println("线程：" + i);
		}
		
		
	}
}
