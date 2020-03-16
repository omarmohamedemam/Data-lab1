package eg.edu.alexu.csd.filestructure.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;

import eg.edu.alexu.csd.filestructure.sort.Node;
import eg.edu.alexu.csd.filestructure.sort.Heap;
import eg.edu.alexu.csd.filestructure.sort.Sort;
public class Main {

	public static void main(String[] args)  {
		ArrayList test1 = new ArrayList<Integer>();
		test1.add(10);
		test1.add(5);
		test1.add(20);
		test1.add(7);
		test1.add(2);
		test1.add(-1);
		ArrayList test2 = new ArrayList<Integer>();
		ArrayList test3 = new ArrayList<Integer>();
		test3 = test2 = test1;
		Sort s = new Sort();
		 long startTime = System.nanoTime();
		s.sortSlow(test1);
		long endTime = System.nanoTime();
		long duration1 = (endTime - startTime);  
	    for (int i = 0; i < test1.size(); i++) {
			System.out.println(test1.get(i));
		}
	    System.out.println("Slow Sort time is " + duration1 + " ns");
	    long startTime2 = System.nanoTime();
		s.sortFast(test2);
		long endTime2 = System.nanoTime();
		long duration2 = (endTime2 - startTime2);
	    System.out.println("fast Sort time is "+duration2 + "  ns");
	    long startTime3 = System.nanoTime();
		s.heapSort(test3);
		long endTime3 = System.nanoTime();
		long duration3 = (endTime3 - startTime3);  
	    System.out.println("Heap Sort time is "+ duration3+"  ns");
		
		
		
		
	}

}
