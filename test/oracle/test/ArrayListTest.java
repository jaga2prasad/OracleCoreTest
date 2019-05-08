package oracle.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.Assert;

public class ArrayListTest {
	static List<String> list;
	static List<String> list1;
	static List<String> list3;
	static List<Integer> intList;
	static List<Integer> intList1;
	
	@BeforeClass
	public static void setup(){
		list = Arrays.asList("a","b","c","d","e");
		list1 = Arrays.asList("a","b");
		list3 = Arrays.asList("a");
		intList = Arrays.asList(1,2,3,4,5,6);
		intList1 = Arrays.asList(1,2,3);
	}
	@Test
	public void testSubList(){
		Assert.assertEquals(list1, list.subList(0, 2));
		Assert.assertEquals(intList1, intList.subList(0, 3));
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testSubListException(){
		list.subList(0, 6);
		list.subList(-1, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSubListExcpetion1(){
		list.subList(3, 2);
	}
	
	@Test
	public void testListIterator(){
		List<Integer> finalList = new ArrayList<>();
		Iterator<Integer> it = intList1.iterator();
		while(it.hasNext()){
			finalList.add(it.next());
		}
		Assert.assertEquals(intList1, finalList);
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testListIteratorExc(){
		List<Integer> finalList = new ArrayList<>();
		Iterator<Integer> it = intList1.iterator();
		while(it.hasNext()){
			finalList.add(it.next());
		}
		it.next();
	}
	
	 @Test(expected=ConcurrentModificationException.class)
	 public void testListIteratorExc1(){
		 List<String> intList3 = new ArrayList<>();
		 intList3.add("1");intList3.add("2");intList3.add("3");
		 Iterator<String> it = intList3.iterator();
		while(it.hasNext()){
			if(it.next().equals("1"))
			   intList3.remove(0);
		}			
	 }
	 
	 @Test
	 public void testListIteratorRemove(){
		 List<Integer> list4 = new ArrayList<>();
		 list4.add(1);list4.add(2);list4.add(3);list4.add(4);
		 Iterator<Integer> it = list4.iterator();
		 while(it.hasNext()){
			 if(it.next() == 4)
				 it.remove();
		 }
		 Assert.assertEquals(intList1, list4);
	 }
	 
	 @Test
	 public void testIsEmpty(){
		 List<Integer> emptyList = new ArrayList<>();
		 Assert.assertFalse(list1.isEmpty());
		 Assert.assertTrue(emptyList.isEmpty());
	 }
	 
	 
}
