package MultiThread;

public class Main extends Thread implements Runnable {
	public static Thread thread1;
	public static Main obj;

	public static void main(String[] args) {

		MultiDemo m1 = new MultiDemo("Cool");
		MultiDemo m2 = new MultiDemo("Weird");
		MultiDemo m3 = new MultiDemo("Fine");

		m1.setPriority(9);
		m2.setPriority(2);
		m3.setPriority(5);

		m1.start();
		try {
			m1.interrupt();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		m2.start();
//		m3.start();

		try {
			sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// MultiDemo md1 = new MultiDemo();
//		MultiDemo md2 = new MultiDemo();
//		MultiDemo md3 = new MultiDemo();
//		MultiDemo md4 = new MultiDemo();

//		System.out.println("BEFORE");
//		for (int i = 0; i < 12; i++) {
////			MultiDemo md1 = new MultiDemo();
////			md1.start();
//
//		}

//		
//		obj = new Main();
//		thread1 = new Thread(obj);
//
//		// thread1 is created and is currently in the new state
//		System.out.println("Thread 1: State after creating: " + thread1.getState());
//
//		// thread1 is in Runnable State
//		thread1.start();
//		System.out.println("Thread 1: State after calling start on it: " + thread1.getState());

//below does not matter
//		Thread t2 = new Thread(new RunningTest());
//		System.out.println(t1.getState());
//		try {
//			t1.start();
//			t1.sleep(1000);
//			System.out.println(t1.getState());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("ayy");
//		}
//
//		System.out.println(t2.getState());
//
//		System.out.println(t1.getState());

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		RunningTest myThread = new RunningTest();
		Thread thread2 = new Thread(myThread);

		// thread2 created and currently in new state
		System.out.println("Thread 2: State after creating: " + thread2.getState());

		// thread1 is in Runnable State
		thread2.start();
		System.out.println("Thread 2: State after calling start on it: " + thread2.getState());

		// moving thread2 to timed waiting state
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("Thread 2: State after calling sleep on it: " + thread2.getState());

		try {
			thread2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("State of thread2 when it has finished it's execution -  " + thread2.getState());
	}

}