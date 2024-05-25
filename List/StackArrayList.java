import java.util.*;
public class StackArrayList
{
	public static void main(String args[])
	{
		int value;
		ArrayStack stack = new ArrayStack();
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
					System.out.println(stack.pop());
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
					System.out.println(stack.isEmpty());
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
class ArrayStack
{
	static final int InitialCapacity = 3;
	Object arr[] = new Object[InitialCapacity];
	int capacity = InitialCapacity;
	int top;
	
	ArrayStack()
	{
		top = -1;
	}
	
	public void push(Object value)
	{
		if(top == InitialCapacity-1)
		{
			//throw new IndexOutOfBoundsException("Stack over flow");
			expandArray();
		}
		arr[++top] = value;
	}
	
	private void expandArray()
	{
		capacity*= 2;
		arr = Arrays.copyOf(arr,capacity);
	}
	
	public Object pop()
	{
		return arr[top--];
	}
	
	public Object peek()
	{
		return arr[top];
	}
		
	public void display()
	{
		System.out.println("Elements in the Array: ");
		for(int i=0;i<=top;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public boolean search(Object value)
	{
		for(int i=0;i<=top;i++)
		{
			if(arr[i] == value)
			{
				return true;
			}
		}
		return false;	
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	public int length()
	{
		int count = 0;
		for(int i=0;i<=top;i++)
		{
			count++;
		}
		return count;
	}
}
