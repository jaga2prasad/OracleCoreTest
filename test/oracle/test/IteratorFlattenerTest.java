package oracle.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.Assert;


/**
 * Provides sufficient test coverage for oracle.test.IteratorFlattener class.
 */
public class IteratorFlattenerTest {
	@Test
	public void testIteratorFlatSting(){
		List<String> list1 = Arrays.asList("a","b","c");
		List<String> list2 = Arrays.asList("d","e","f");
		List<String> list3 = Arrays.asList("g","h","i");
		
		List<Iterator<String>> listStringIte = Arrays.asList(list1.iterator(),list2.iterator(),list3.iterator());
		List<String> finalList = Arrays.asList("a","b","c","d","e","f","g","h","i");
		IteratorFlattener<String> itFlat = new IteratorFlattener<>(listStringIte.iterator());
		List<String> listFlat = new ArrayList<>();
		while(itFlat.hasNext()){
			listFlat.add(itFlat.next());
		}
		
	    Assert.assertEquals(finalList, listFlat);
	}
	
	@Test
	public void testIteratorFlatInteger(){
		List<Integer> list1 = Arrays.asList(1,2,3,4);
		List<Integer> list2 = Arrays.asList(1,2,3,4);
		List<Integer> list3 = Arrays.asList(1,2,3,4);
		
		List<Iterator<Integer>> listIte = Arrays.asList(list1.iterator(),list2.iterator(),list3.iterator());
		List<Integer> finalList = Arrays.asList(1,2,3,4,1,2,3,4,1,2,3,4);
		
		IteratorFlattener<Integer> flatIte = new IteratorFlattener<>(listIte.iterator());
		List<Integer> stageList = new ArrayList<>();
		while(flatIte.hasNext()) {
			stageList.add(flatIte.next());
		}
		
		Assert.assertEquals(finalList, stageList);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorFlatIntegerException(){
		List<Integer> list1 = Arrays.asList(1,2,3,4);
		List<Integer> list2 = Arrays.asList(1,2,3,4);
		List<Integer> list3 = Arrays.asList(1,2,3,4);
		
		List<Iterator<Integer>> listIte = Arrays.asList(list1.iterator(),list2.iterator(),list3.iterator());
		
		IteratorFlattener<Integer> flatIte = new IteratorFlattener<>(listIte.iterator());
		List<Integer> stageList = new ArrayList<>();
		while(flatIte.hasNext()) {
			stageList.add(flatIte.next());
		}
		flatIte.next();
		
		//Assert.assertEquals(finalList, stageList);
	}
}
