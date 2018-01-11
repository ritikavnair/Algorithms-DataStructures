package LinkedList;

public class Node{
	int value;
	Node next;
	
	public Node(int data){
		this.value = data;
		this.next=null;
	}
	
	public String toString() {
		return this.value + "";
	}
}
