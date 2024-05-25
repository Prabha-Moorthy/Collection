import java.util.*;
public class StackLinkedList
{
	public static void main(String args[])
	{
		int value;
		LinkedListStack stack = new LinkedListStack();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("\n----------MainMenu----------\n");
			System.out.println("1.Push the Element");
			System.out.println("2.Pop the Element");
			System.out.println("3.Peek the Element");
			System.out.println("4.Display the Elements");
			System.out.println("5.Search the Element");
			System.out.println("6.The are is Empty or Not");
			System.out.println("7.Length of the Array");
			System.out.println("8.Exit");
			System.out.println("-----------------------------");
			
			System.out.println("Enter the choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter the value");
					value = sc.nextInt();
					stack.push(value);
					break;
				
				case 2:
					System.out.println("The Poped value: "+stack.pop());
					break;
					
				case 3:
					System.out.println("The value: "+stack.peek());
					break;
					
				case 4:
					stack.display();
					break;
					
				case 5:
					System.out.println("Enter the element for search");
					value = sc.nextInt();
					System.out.println(stack.search(value));
					break;
					
				case 6:
					System.out.println("The List is Empty "+stack.isEmpty());
					break;
					
				case 7: 
					System.out.println("Length of the array: "+stack.length());
					break;
					
				case 8:
					System.exit(0);
					break;
					
				default:
					System.out.println("Invalid choice");
					break;
			}
		}
	}
}

class LinkedListStack
{
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
	
	Node top;
	LinkedListStack()
	{
		top = null;
	}
	
	public void push(Object value)
	{
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
	}
	
	public Object pop()
	{
		if(top == null)
		{
			throw new IndexOutOfBoundsException("Stack is empty");
		}
		Object temp = top.data;
		top = top.next;
		return temp;
	}
	
	public Object peek()
	{
		return top.data;
	}
	
	public void display()
	{
		Node temp = top;
		
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public Object search(Object value)
	{
		Node temp = top;
		int pos = 0;
		
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
	
	public boolean isEmpty()
	{
		return top == null;
	}
	
	public Object length()
	{
		Node temp = top;
		int count = 0;
		
		while(temp != null)
		{	
			count++;
			temp = temp.next;
		}
		return count;
	}
}
