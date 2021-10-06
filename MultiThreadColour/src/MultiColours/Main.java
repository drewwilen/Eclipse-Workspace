package MultiColours;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(ThreadColor.ANSI_CYAN + "HEY");
//		System.out.println(ThreadColor.ANSI_RESET + "HEY");

		Countdown countdown = new Countdown();

		CountdownThread t1 = new CountdownThread(countdown);

		t1.setName("Thread 1");

		CountdownThread t2 = new CountdownThread(countdown);

		t2.setName("Thread 2");

		CountdownThread t3 = new CountdownThread(countdown);

		t3.setName("Thread 3");
//
//		CountdownThread t4 = new CountdownThread(countdown);
//
//		t4.setName("Thread 4");

		t1.start();
		t2.start();
		t3.start();
		// t4.start();
		// t1.setName("PSYCH");

	}
}

class Countdown {

	public void doCountdown() {
		String color;

		switch (Thread.currentThread().getName()) {// different if statement
		case "Thread 1":
			color = ThreadColor.ANSI_CYAN;
			break;
		case "Thread 2":
			color = ThreadColor.ANSI_PURPLE;
			break;
		default:
			color = ThreadColor.ANSI_GREEN;
		}

		for (int i = 10; i > 0; i--) {
			System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
		}
	}
}

class CountdownThread extends Thread {
	private Countdown threadCountdown;

	public CountdownThread(Countdown countdown) {
		threadCountdown = countdown;
	}

	public void run() {
		threadCountdown.doCountdown();
	}
}
