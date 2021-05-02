package doubleLinkList;

import linkedList.Node;

public class Node2<T> {
	
	T data;
	Node2<T> next;
	Node2<T> prev;
	
	Node2(T  data){
		this.data = data;
		next = null;
		prev = null;
	
	}
}
