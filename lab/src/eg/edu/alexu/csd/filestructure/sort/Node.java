package eg.edu.alexu.csd.filestructure.sort;
import eg.edu.alexu.csd.filestructure.sort.Heap;

public class Node <T extends Comparable<T>>implements INode<T> {
	//Parameters 
	private T value;
	private int index;
	Heap<T> HP=new Heap<T>(3);
	 
	// constructors
	Node( ){
		value=null;
		index=HP.size()+1;
	}
	
	Node(T value,int index){
		value=this.value;
		index=this.index;
	}
//--------------------
	@Override
	public INode<T> getLeftChild() {
		return (INode<T>) HP.getHeap()[index*2];
	}
//---------------------------
	@Override
	public INode<T> getRightChild() {
		return (INode<T>) HP.getHeap()[index*2+1];
	}
	//------------------

	@Override
	public INode<T> getParent() {
		int n=(int) Math.floor(index/2);
		return (INode<T>) HP.getHeap()[n];
	}
	//-------------------------

	
	@Override
	public  void setValue(T value) {
		value= this.value;
	}
//-----------
	@Override
	public T getValue() {
		return value;
	}
// extra function
	public  void setindex(int index) {
		index= this.index;
	}


}
