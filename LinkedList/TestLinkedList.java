package LinkedList;
import java.util.Scanner;

public class TestLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList llist = new LinkedList();
		System.out.println(llist.toString());	
		System.out.println("Enter number to add to linked list, or q to quit : ");
		while(true) {


			if(sc.hasNextInt()) {
				llist.prepend(new Node(sc.nextInt()));
				System.out.println(llist.toString());	
			}
			else {
				
				if( sc.next().equals("quit")) {
					break;
				}
			}
			System.out.println("Enter number to add to linked list, or q to quit : ");
		}
		
		//delete
		System.out.println("Enter number to delete from linked list, or q to quit : ");
		while(true) {


			if(sc.hasNextInt()) {
				llist.deleteNodeWithValue(sc.nextInt());
				System.out.println(llist.toString());	
			}
			else {
				
				if( sc.next().equals("quit")) {
					break;
				}
			}
			System.out.println("Enter number to delete from linked list, or q to quit : ");
		}
		
		sc.close();

	}

}
