package MultiThread;

public class MultiDemo extends Thread {

	public MultiDemo(String name) {
		super.setName(name);

	}

	public void run() {
		System.out.println("Thread " + super.getName() + " (Priority: " + getPriority() + ") is running.");
		try {
			Thread.sleep(1000);
			System.out.println("Ayy");
		} catch (InterruptedException I) {
			// throw new RuntimeException("Thread Interrupted!");
			System.out.println("Exception Handled");
		}
		System.out.println("Reached last line");
	}
}
