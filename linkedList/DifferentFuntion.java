package linkedList;

import java.util.Scanner;

public class DifferentFuntion {
	
	
	public static void noOfTimesGivenNode(Node<Integer> head , int elem) {
		
		int i = 0 ;
		while(head != null) {
			if (elem == head.data) {
				i++;
			}
			head = head.next;
		}
		System.out.println(i);
	}
	
	public static Node<Integer> swapNode(Node<Integer> head , int pos1 , int pos2) {
		
		if (pos2 < pos1 ) {
			int temp = pos1;
			pos1 = pos2;
			pos2 = temp;
		}
		
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;                    
		
		if (pos1 == 0) {
			
			if (pos1-pos2 == 0) {
				return head;
			
			} else if (pos2-pos1 == 1){
				Node<Integer> c2 = p2.next;
				p1.next = c2.next;
				c2.next = p2;
				head = c2;
			
			} else {
				int j = 0;
				while (j < pos2-1 ) {
					p2 = p2.next;
					j++;
				}
				Node<Integer> c2 = p2.next;
				Node<Integer> temp = c2.next;
				c2.next = p1.next;
				p1.next = temp;
				p2.next = p1;
				head = c2;
			}
		
		} else {
			
			int i=0;
			while (i < pos1 -1 ) {
				p1 = p1.next;
				i++;
			}
			
			int j = 0;
			while (j < pos2-1 ) {
				p2 = p2.next;
				j++;
			}
			
			Node<Integer> c1 = p1.next;
			Node<Integer> c2 = p2.next;
	     	Node<Integer> temp = c2.next;
			
			p1.next = c2;
			p2.next = c1;
			c2.next = c1.next;
			c1.next = temp;
		}
		
		return head;
	}
	
	public static Node<Integer> swapNodeData(Node <Integer> head , int pos1 , int pos2 ){
		
		Node<Integer> p1 = head;
		Node<Integer> p2 = head;
		
		int i=0;
		while (i < pos1) {
			p1 = p1.next;
			i++;
		}
		
		int j = 0;
		while (j < pos2) {
			p2 = p2.next;
			j++;
		}
		
		int temp = p1.data;
		p1.data = p2.data;
		p2.data = temp ;
		
		return head;
		
	} 
	
	public static Node<Integer> takeInput(){
		Node <Integer> head = null , tail = null;
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			} else {
				
				tail.next = newNode;
				tail = newNode;
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head) {


		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	

	public static int  size(Node<Integer> head) {
		int i = 0;
		while(head != null) {
			head = head.next;
			i++;
		}
		return i;
	}
	
	
	public static Node<Integer> appendLastNToFirst(Node<Integer> head){
		if(size(head) <= 1) {
			return head;
		}
		Node<Integer> temp = head ;
		int i = 0;
		while(i < size(head)-2) {
			temp = temp.next;
			i++;
		}
		
		temp.next.next = head;
		head = temp.next;
		temp.next = null;
		
		return head;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node<Integer> head = takeInput();
//		head = swapNodeData(head , 0 , 1);
//		print(head);
//		noOfTimesGivenNode(head , 5 );
		head = appendLastNToFirst(head);
		print(head);

	}

}
