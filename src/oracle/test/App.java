package oracle.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App {
	public static void main(String[] args) {
		
		String jaga = "%121#";
		System.out.println(jaga.replaceAll("[\\W]", "").toLowerCase());
		System.out.println(PalindromeUtil.isPalindrome(jaga));
		List<List<Integer>> list= new ArrayList<>();
		
		List<Integer> list1 = new ArrayList<>();
		list1.add(1); list1.add(2); list1.add(3); list1.add(4);
		
		list.add(list1);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1); list2.add(2); list2.add(3); list2.add(4);
		
		list.add(list2);
		
		Iterator<List<Integer>> a = list.iterator();
		
		
		System.out.println(list);
		System.out.println(a);
		
		List<Iterator<Integer>> numListItr = Arrays.asList(list1.iterator(),list2.iterator());
		
		IteratorFlattener<Integer> flat = new IteratorFlattener<>(numListItr.iterator());
		List<Integer> flatList = new ArrayList<Integer>();
		while (flat.hasNext()) {
			int value = flat.next();
			flatList.add(value);
			if(value==4)
				flat.remove();
			//flat.remove();
		}
		//flat.next();
		
		System.out.println(flatList);
		
		
		
		List<String> intList3 = new ArrayList<>();
		 intList3.add("1");intList3.add("2");intList3.add("3");
		 Iterator<String> it = intList3.iterator();
		while(it.hasNext()){
			if(it.next().equals("1"))
			intList3.remove(0);
		}
	}
}
