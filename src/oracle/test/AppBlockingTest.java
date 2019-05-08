package oracle.test;

import java.util.LinkedList;
import java.util.Queue;

public class AppBlockingTest {
	static int count  = 1;
	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new BlockingQueue<>(new LinkedList<>());
		//int count  = 1;
		Thread t = new Thread(()->{
			while(true){
				System.out.println("Added count" +count);
				bq.push(count);
				count = count+1;
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t1 = new Thread(()->{
			while(true){
				System.out.println(bq.pull());
			}
		});
		
		t.start();t1.start();
	}
}
