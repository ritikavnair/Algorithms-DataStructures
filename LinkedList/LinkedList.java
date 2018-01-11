package LinkedList;

public class LinkedList {

	Node head;
	
	
	public void append(Node newNode) {
		
		//For an empty linked list
		if(head==null) {
			head = newNode;
			return;
		}
		Node current = head;
		while(current.next!= null) {
			current = current.next;
		}
		current.next=newNode;
	}
	
	public void prepend(Node newNode) {
		if(head==null) {
			head = newNode;
			return;
		}
		newNode.next=head;
		head=newNode;
	}
	
	public void deleteNodeWithValue(int value)
	{
		if(head==null) return;
		if(head.value==value) {
			head = head.next;
		}
		else {
			Node current = head;
			while(current!=null && current.next!=null) {
				if(current.next.value == value) {
					current.next = current.next.next;
				}
				current = current.next;
				
					
			}
		}
	}
	
	public String toString() {
		String outString = "->";
		Node current = head;
		while(current!=null) {
			outString += (current.toString() + "->");
			current = current.next;
		}
		outString+="null";
		return outString;
	}
	
}




