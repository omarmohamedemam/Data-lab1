package eg.edu.alexu.csd.filestructure.sort;

import java.util.Collection;
@SuppressWarnings("unchecked")
public class Heap <T extends Comparable<T>>implements IHeap<T> {
	// Initialize 
	private static int heap_size = 0;
	private  static INode[] heap_array = (INode[]) new INode[10000000];
	// constructors
	
	Heap() {
		 heap_array = (INode<T>[]) new INode[100000000];
		 heap_size = 0;
	}
	Heap(int x){}
	 // extra functions 
		public INode<T>[] getHeap(){
			return (INode<T>[]) heap_array;
		}
		
		//---------------
		public void add(T element) {
			Node<T> n=new Node<T>(element,heap_size+1);
			if(heap_size==heap_array.length) {
				return;
			}
			heap_array[heap_size+1]=(INode<T>) n;
			heap_size++;
		}
		
	// interface methods 
	 //------------------------

	@Override
	public INode<T> getRoot() {
		if(heap_size == 0) {
			return null;
		}
		else {
			return (INode<T>) heap_array[1];
		}	
	}
	//------------------------------

	@Override
	public int size() {
		return heap_size;
	}
	//--------------------------------

	@Override
	public void heapify(INode<T> node) {
		
		if(node == null) {
			return;
		}
		
		INode<T> left = node.getLeftChild();
		INode<T> right = node.getRightChild();
		INode<T> Biggest = node;
		
		
		
		if(left!=null &&( left.getValue().compareTo(Biggest.getValue())>0)) {
			Biggest=left;
		}
		
		if(right!=null && ( right.getValue().compareTo(Biggest.getValue())>0)) {
			Biggest=right;
		}
		
		if(Biggest!=node) {
			T temp = node.getValue();
			node.setValue(Biggest.getValue());
			Biggest.setValue(temp);
			heapify(Biggest);
		}
		
	}
	
	//---------------------------------------------


	@Override
	public T extract() {
		if(heap_size == 0) {
			return null;
		}
		T extracted = (T) heap_array[1].getValue();
		
		heap_array[1].setValue(heap_array[heap_size].getValue());
		
		heap_size--;
		heapify(heap_array[1]);
		return extracted;
	}
	//-----------------------------------------------

	@Override
	public void insert(T element) {
		if(element == null) {
			return;
		}
		
		Node<T> insert =new Node<T>(element,heap_size+1);
		
		if(heap_size == heap_array.length) {
			return;
		}
		
		heap_array[heap_size+1] = (INode<T>) insert;
		heap_size++;
		int i = heap_size
				;
		while(i>1 && (heap_array[i].getValue().compareTo(heap_array[i/2].getValue()))>0) {
			Comparable<T> temp=heap_array[i].getValue();
			heap_array[i].setValue(heap_array[i/2].getValue());
			heap_array[i/2].setValue(temp);
			i=i/2;
		}
		
	}
	//--------------------------------------------------

	@Override
	public void build(Collection<T> unordered) {
		if(unordered==null) {
			heap_size=0;
			return;
		}
		heap_array=new INode[100000000];
		heap_size=0;
		for(T o:unordered) {
			Node<T> added=new Node<T>(o,heap_size+1);
			heap_array[heap_size+1]= added;
			heap_size++;
		}
		int last = heap_size/2+1;
		for(int i=last ; i>0 ; i--) {
			heapify( heap_array[i]);
		}
		
	}
	//---------------------------

		
	}

