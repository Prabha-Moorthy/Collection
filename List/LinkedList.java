import java.util.*;
public class LinkedList
{
	Node head;
	
	class Node
	{
		Object data;
		Node next;
		
		Node(Object value)
		{
			data = value;
			next = null;
		}
	}
	
	LinkedList()
	{
		head = null;
	}
	
	public void insertAtBeginning(Object value)
	{
		Node newNode = new Node(value);
		
		if(head == null)
			head = newNode;
		else
		{
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void display()
	{
		Node temp = head;
		
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public void insertAtPos(Object value,int pos)
	{
		if(pos == 0)
		{
			insertAtBeginning(value);
			return;
		}
		
		Node newNode = new Node(value);
		Node temp = head;
		
		for(int i=1;i<pos;i++)
		{
			temp = temp.next;
			if(temp == null)
			{
				throw new IndexOutOfBoundsException("Invalid Position: "+pos);
			}
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}
	
	public void deleteAtPos(int pos)
	{
		if(pos == 0)
		{
			deleteAtBeginning();
			return;
		}

		Node temp = head;
		Node prev = null;
		
		for(int i=1;i<=pos;i++)
		{
			prev = temp;
			temp =	temp.next;
		}
		prev.next = temp.next;
	}
	
	public void deleteAtBeginning()
	{
		if(head == null)
		{
			throw new IndexOutOfBoundsException("Delete cannot possible empty list");
		}
		
		head =head.next;
	}
	
	public Object getIndexValue(int pos)
	{
		Node temp = head;
		
		for(int i=1;i<=pos;i++)
		{
			temp = temp.next;
		}
		return temp.data;
	}
	
	public void updateValue(Object value,int pos)
	{
		Node temp = head;
		
		for(int i=1;i<=pos;i++)
		{
			temp = temp.next;
		}
		temp.data = value;
	}
	
	public Object searchElement(Object value)
	{
		Node temp = head;
		int pos=0;
		
		while(temp != null)
		{
			if(temp.data == value)
			{
				return pos;
			}
			temp = temp.next;
			pos++;
		}
		return -1;
	}
	
	public boolean containsValue(Object value)
	{
		Node temp = head;
		
		while(temp != null)
		{
			if(temp.data == value)
			{
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public int lengthOfList()
	{
		Node temp = head;
		int count=0;
		
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
}
