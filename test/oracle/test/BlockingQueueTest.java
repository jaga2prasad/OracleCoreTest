package oracle.test;

import java.util.LinkedList;

import org.junit.Test;

import org.junit.Assert;

/**
 * Provides sufficient test coverage for oracle.test.BlockingQueue class.
 */
public class BlockingQueueTest {
    static int count = 1;
	@Test
	public void testBlockingQueue(){
		BlockingQueue<Integer> bq = new BlockingQueue<>(new LinkedList<>());
		bq.push(1);
		Assert.assertEquals(1, bq.pull().intValue());
		bq.push(2);
		bq.push(3);
		bq.push(4);
		Assert.assertEquals(2, bq.pull().intValue());
		Assert.assertEquals(3, bq.pull().intValue());
		Assert.assertNotEquals(5, bq.pull().intValue());
	}
	
	@Test
	public void testBlockingQueueString(){
		BlockingQueue<String> bq = new BlockingQueue<>(new LinkedList<>());
		bq.push("a");
		Assert.assertEquals("a", bq.pull());
		bq.push("b");
		bq.push("c");
		bq.push("d");
		Assert.assertEquals("b", bq.pull());
		Assert.assertEquals("c", bq.pull());
		Assert.assertEquals("d", bq.pull());
	}
	
}
