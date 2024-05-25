import java.util.*;
public class DynamicArrayList
{
	public static void main(String[] args) 
	{
	    int val,pos;
	    DynamicArray list = new DynamicArray();
	    Scanner sc = new Scanner(System.in);
	    
	    while(true)
	    {
	        System.out.println("\n----------MainMenu----------\n");
	        System.out.println("1.Insert at End");
	        System.out.println("2.Display the List");
	        System.out.println("3.Insert at Specific position");
	        System.out.println("4.Delete from Specific position");
	        System.out.println("5.Delete at End");
	        System.out.println("6.Delete from Beginning");
	        System.out.println("7.Insert at Beginning");
	        System.out.println("8.Getting Index");
	        System.out.println("9.Update the value");
	        System.out.println("10.Search the value");
	        System.out.println("11.Exit");
	        System.out.println("---------------------------");
	        
	        System.out.println("Enter your choice: ");
	        int choice=sc.nextInt();
	        
	        switch(choice)
	        {
	            case 1:
	                System.out.println("Enter the Data: ");
	                val = sc.nextInt();
	                list.add(val);
	                break;
	               
	           case 2:
	               list.display();
	               break;
	           
	           case 3:
	               System.out.println("Enter the position(starts at 0): ");
	               pos = sc.nextInt();
	               
	               if(pos < 0)
	               {
	                   System.out.println("Invalid Position");
	                   break;
	               }
	               
	               System.out.println("Enter the data: ");
	               val = sc.nextInt();
	               list.insertAtPos(pos,val);
	               break;
	               
	           case 4:
	               System.out.println("Enter the Position(starts at 0): ");
	               pos = sc.nextInt();
	               
	               if(pos < 0)
	               {
	                   System.out.println("Invalid Position");
	                   break;
	               }
	               
	               list.deleteAtPos(pos);
	               break;
	               
	           case 5:
	               list.deleteAtEnd();
	               break;
	               
	           case 6:
	               list.deleteAtStarting();
	               break;
	               
	           case 7:
	               System.out.println("Enter the value");
	               val = sc.nextInt();
	               list.insertAtStarting(val);
	               break;
	               
	           case 8:
	               System.out.println("Enter the value");
	               pos = sc.nextInt();
	               list.gettingIndex(pos);
	               break;
	               
	           case 9:
	               System.out.println("Enter the Element to insert in Specific Position");
	               val=sc.nextInt();
	               System.out.println("Enter the index");
	               pos=sc.nextInt();
	               list.updateValue(pos,val);
	               break;
	           
	           case 10:
	               System.out.println("Enter the Element to Search");
	               val = sc.nextInt();
	               if(list.searchElement(val))
	                   System.out.println("The Element is found in the List");
	               
	               else
	                   System.out.println("The Element is not found in the List");
	               break;
	               
	               
	           case 11:
	               System.exit(0);
	               break;
	               
	           default:
	               System.out.println("Invalid choice");
	       }
	   }
	}
}

class DynamicArray
{
    private static final int initialCapacity = 16;
    private int arr[];
    private int size;
    private int capacity;
    
    DynamicArray()
    {
        size = 0;
        arr = new int[initialCapacity];
        capacity = initialCapacity;
    }
    
    public void add(int val)
    {
        if(size == capacity)
        expandArray();
        
        arr[size++] = val;
    }
    
    private void expandArray()
    {
        capacity*= 2;
        arr = Arrays.copyOf(arr,capacity);
    }
    
    public void display()
    {
        System.out.println("Elements in the list: ");
        for(int i=0;i<size;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
    
    public void insertAtPos(int pos,int val)
    {
        if(pos < 0)
        expandArray();
        for(int i=size-1;i>=pos;i--)
        {
            arr[i+1] = arr[i];
        }
        arr[pos] = val;
        size++;
    }
    
    public void deleteAtPos(int pos)
    {
        for(int i=pos+1;i<size;i++)
        {
            arr[i-1] = arr[i];
        }
        size--;
        
        if(capacity > initialCapacity && capacity > 3*size)
        shrinkArray();
    }
    
    private void shrinkArray()
    {
        capacity/= 2;
        arr = Arrays.copyOf(arr,capacity);
    }
    
    public void deleteAtEnd()
    {
        size--;
    }
    
    public void deleteAtStarting()
    {
        size--;
        for(int i=1;i<=size;i++)
        {
            arr[i-1] = arr[i];
        }
    }
    
    public void  insertAtStarting(int val)
    {
        for(int i=size-1;i>=0;i--)
        {
            arr[i+1] = arr[i];
        }
        arr[0] = val;
        size++;
    }
    
    public void gettingIndex(int pos)
    {
        for(int i=0;i<=size;i++)
        {
            if(i == pos)
                System.out.println(arr[i]);
        }
    }
    
    public void updateValue(int pos,int val)
    {
        arr[pos] = val;
    }
    
    public boolean searchElement(int val)
    {
        for(int i=0;i<=size;i++)
        {
            if(arr[i] == val)
            {
                return true;
            }
        }
        return false;
    }
}
