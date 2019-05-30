package com.example.demosingleton;


public enum EnumSingleton {

    INSTANCE;
	
	private Singleton singleton;

	private EnumSingleton() {		
		singleton = new Singleton();		
	}
	
	public Singleton getInstance() {		
		return singleton;
	}
	

}

