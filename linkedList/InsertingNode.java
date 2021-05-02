package linkedList;

import java.util.Scanner;

public class InsertingNode {
	
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

	public static Node<Integer> insertItretive(Node<Integer> head , int data , int pos) {
		Node<Integer> newNode = new Node<Integer>(data);
		if(pos == 0) {
			newNode.next = head;
			return newNode;
		}
		int i = 0;
		Node<Integer> temp = head;
		while(i < pos-1){
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	
	public static Node<Integer> insertRecursive(Node<Integer> head ,  int data , int pos){
		if (pos == 0) {
			Node<Integer> newNode = new Node<Integer>(data);
			newNode.next = head;
			return newNode;
		}
		head.next = insertRecursive(head.next , data , pos -1);
		return head;
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		head = insertRecursive(head , 8 , 1);
		print(head);		

	}

}
