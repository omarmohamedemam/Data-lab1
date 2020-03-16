package eg.edu.alexu.csd.filestructure.sort;


import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Collections;

public class Sort<T extends Comparable<T>> implements ISort<T>{

	@Override
	public IHeap<T> heapSort(ArrayList<T> unordered) {
		if(unordered==null) {
			IHeap<T> h=new Heap<T>();
			return h;
		}
		int s=unordered.size();
		for (int i = (unordered.size() / 2) - 1; i >= 0; i--) 
	        heapify(unordered, unordered.size(), i); 
	  
	    for (int i=unordered.size()-1; i>=0; i--) 
	    { 
	        
	    	Collections.swap(unordered, 0, i);
	        heapify(unordered, i, 0); 
	    } 
	    IHeap<T> h=new Heap<T>();
	    for(int i=0;i<s;i++) {
	    	h.add( unordered.get(i));
	    }
	    
		return h;
	}
	//------------------------

	@Override
	public void sortSlow(ArrayList<T> unordered) {
		if(unordered==null) {
			return;
		}
		for(int i=0 ; i<unordered.size()-1 ; i++)
		{
			for(int j=i+1 ; j<unordered.size() ; j++)
			{
				if((unordered.get(i).compareTo(unordered.get(j))) >= 1)
				{
					Collections.swap(unordered, i, j);
				}
			}
		}
		
	}

	@Override
	public void sortFast(ArrayList<T> unordered) {
		if(unordered==null) {
			return;
		}
		if(unordered.size()<=100000) {
			sort1(unordered, 0, unordered.size()-1);
		}
		else {
			sort2(unordered, 0, unordered.size()-1);
		}
		
		
	}
	//--------------------------
	int divide(ArrayList<T> unorderd, int low, int high) 
    { 
        T pivot = unorderd.get(high);  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (unorderd.get(j).compareTo(pivot) <0) 
            { 
                i++; 
 
               T temp = unorderd.get(i);
               unorderd.remove(i);
                unorderd.add(i, unorderd.get(j)); 
                unorderd.remove(j);
                unorderd.add(j, temp);
            } 
        } 
  
        T temp = unorderd.get(i+1); 
        unorderd.remove(i+1);
        unorderd.add(null);
        unorderd.add(null);
        unorderd.add(i+1, unorderd.get(high)); 
        unorderd.remove(high);
        unorderd.add(high, temp);
  
        return i+1; 
    }
  
   void sort2(ArrayList<T> unorderd, int low, int high) 
    { 
        if (low < high) 
        { 
            int p = divide(unorderd, low, high); 
            sort1(unorderd, low, p-1); 
            sort1(unorderd, p+1, high); 
        } 
    }

 public void sort1(ArrayList<T> unorderd, int l, int r) 
    { 
        if (l < r) 
        { 
            
            int m = (l+r)/2; 
            sort1(unorderd, l, m); 
            sort1(unorderd , m+1, r); 
  
          
            merge(unorderd, l, m, r); 
        } 
    } 
public void merge(ArrayList<T> unorderd, int l, int m, int r) 
{ 
    int n1 = m - l + 1; 
    int n2 = r - m; 

    
   Comparable<T> L[] = new Comparable [n1]; 
   Comparable<T> R[]=  new Comparable[n2]; 


    for (int i=0; i<n1; ++i) 
        L[i] =  unorderd.get(l + i); 
    for (int j=0; j<n2; ++j) 
        R[j] =  unorderd.get(m + 1+ j); 

    int i = 0, j = 0; 

    int k = l; 
    while (i < n1 && j < n2) 
    { 
        if ((((T) L[i]).compareTo( (T) R[j]))<=0 ) 
        { 
        	unorderd.remove(k);
            unorderd.add(k,  (T) L[i]); 
            i++; 
        } 
        else
        { 
        	unorderd.remove(k);
            unorderd.add(k, (T) R[j]);
            j++; 
        } 
        k++; 
    } 

    while (i < n1) 
    { 
    	unorderd.remove(k);
       unorderd.add(k,  (T) L[i]); 
        i++; 
        k++; 
    } 


    while (j < n2) 
    { 
    	unorderd.remove(k);
        unorderd.add(k,  (T) R[j]);
        j++; 
        k++; 
    } 
}
	//---------------------------------
	public void heapify(ArrayList<T> unordered,int n,int i)
	{
		int largest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<n&&(unordered.get(l).compareTo(unordered.get(largest)))>=1)
		{
			largest=l;
			
		}
		
		if(r<n&&(unordered.get(r).compareTo(unordered.get(largest)))>=1)
		{
			largest=r;
		}
	if(largest!=i)
	{
		Collections.swap(unordered, i, largest);
		heapify(unordered, n, largest);
		
	}
	
		
	}
}
