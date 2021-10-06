package MultiThread;

public class RunningTest implements Runnable {

	@Override
	public void run() {
		// moving thread2 to timed waiting state
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

		}
		// TODO Auto-generated method stub
		// System.out.println("Thread " + Thread.currentThread().getName() + " is
		// running.");

		// after thread2 sleeping, thread1 is waiting because of the join()/ //after
		// thread2 sleeping, thread1 is waiting because of join()
		System.out.println("State of thread1 while it called join() method on thread2 - " + Main.thread1.getState());
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
