import java.util.*;
public class DemoLinkedList
{
	public static void main(String args[])
	{
		int value,pos;
		LinkedList list = new LinkedList();
		Scanner sc = new Scanner(System.in);
	    
	    	while(true)
	    	{
			System.out.println("\n----------MainMenu----------\n");
			System.out.println("1.Insert at Beginning");
			System.out.println("2.Display the List");
			System.out.println("3.Insert at Specific position");
			System.out.println("4.Delete from Specific position");
			System.out.println("5.Delete from Beginning");
			System.out.println("6.Getting Index");
			System.out.println("7.Update the value");
			System.out.println("8.Search the value");
			System.out.println("9.Contains the value");
			System.out.println("10.Length of the List");
			System.out.println("11.Exit");
			System.out.println("---------------------------");
			
			System.out.println("Enter your choice: ");
			int choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter the value");
					value = sc.nextInt();
					list.insertAtBeginning(value);
					break;
				case 2:
					list.display();
					break;
					
				case 3:
					System.out.println("Enter the value");
					value = sc.nextInt();
					System.out.println("Enter the position");
					pos = sc.nextInt();
					list.insertAtPos(value,pos);
					break;
				case 4:
					System.out.println("Enter the position want to delete");
					pos = sc.nextInt();
					list.deleteAtPos(pos);
					break;
				
				case 5:
					list.deleteAtBeginning();
					break;
				
				case 6:
					System.out.println("Enter the Position");
					pos = sc.nextInt();
					System.out.println("The Element in the position: "+list.getIndexValue(pos));
					break;
					
				case 7:
					System.out.println("Enter the element to update");
					value = sc.nextInt();
					System.out.println("Enter the position");
					pos = sc.nextInt();
					list.updateValue(value,pos);
					break;
				
				case 8:
					System.out.println("Enter the element to search");
					value =sc.nextInt();
					System.out.println("The Element is: "+list.searchElement(value));
					break;
					
				case 9:
					System.out.println("Enter the element");
					value = sc.nextInt();
					System.out.println("The element in the list is "+list.containsValue(value));
					break;
					
				case 10:
					System.out.println("The Length of the list is "+list.lengthOfList());
					break;
					
				case 11:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice!!");
					break;
			}
		}
	}
}
