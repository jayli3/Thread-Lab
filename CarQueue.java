import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	private Queue<Integer> queue;
	
	public CarQueue() {
		queue = new LinkedList<>();
		for (int i = 0; i < 6; i ++) {
			queue.add(new Random().nextInt(4));
		}
	}
	
	public void addToQueue() {
		class QueueRunnable implements Runnable {
			@Override
			public void run() {
				try {
					while (true) {
						queue.add(new Random().nextInt(4));
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		Runnable r = new QueueRunnable();
		Thread t = new Thread(r);
		t.start();
	}
	
	public Integer deleteQueue() { 
		return queue.poll();
	}
}
