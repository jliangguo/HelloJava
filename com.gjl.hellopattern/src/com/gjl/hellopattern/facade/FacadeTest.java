package com.gjl.hellopattern.facade;

//the components of a computer

class CPU {
	public void processData() {
		System.out.println("CPU is processing data...");
	}
}

class Memory {
	public void load() {
		System.out.println("Memory is loading data...");
	}
}

class HardDrive {
	public void readdata() {
		System.out.println("HardDrive is reading data...");
	}
}

class Computer {
	private final CPU cpu;
	private final Memory memory;
	private final HardDrive hardDrive;

	public Computer() {
		cpu = new CPU();
		memory = new Memory();
		hardDrive = new HardDrive();
	}

	public void run() {
		cpu.processData();
		memory.load();
		hardDrive.readdata();
	}
}

class User {
	public void useComputer() {
		Computer computer = new Computer();
		computer.run();
	}
}

public class FacadeTest {
	/**
	 * Facade design pattern hides complexity of a task and provides a simple
	 * interface. A very good example is the startup of a computer. When a
	 * computer starts up, it involves the work of cpu, memory, hard drive, etc.
	 * To make it easy to use for users, we can add a facade which wrap the
	 * complexity of the task, and provide one simple interface instead.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.useComputer();
	}

}
