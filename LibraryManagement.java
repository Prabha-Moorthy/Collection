import java.util.*;
public class LibraryManagement
{
	public static void main(String args[])
	{
		Library library = new Library();
		Scanner sc = new Scanner(System.in);
		
		//Adding Bookes 
		library.addBook(new Book(1, "PS", "Kalki"));
		library.addBook(new Book(2, "Kavithai", "Barathi"));
		library.addBook(new Book(3, "Thirukural", "Thiruvaluvar"));
		
		//Adding Member
		library.addMember(new Member(1, "Ravi"));
		library.addMember(new Member(2, "Abi"));
		library.addMember(new Member(3, "Kavi"));
		
		//Borrow Book
		library.borrowBook(1,1);
		library.borrowBook(2,2);
		library.borrowBook(3,3);
		
				
		//Return Book
		library.returnBook(1,1);
		library.returnBook(1,2);
		
		while(true)
		{
			System.out.println("\n----------Mainmenu----------\n");
			System.out.println("1.Available Books");
			System.out.println("2.Borrow Books");
			System.out.println("3.Member with most Books");
			System.out.println("4.Most Borrowed Books");
			System.out.println("5.Exit");
			System.out.println("-------------------------");
			
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			
			switch(choice)
			{
			    case 1:
			        library.listAvailableBooks();
			        break;
			        
			    case 2:
			        library.listBorrowedBooks();
			        break;
			        
			    case 3:
			        library.findMemberWithMostBooks();
			        break;
			        
			    case 4:
			        library.findMostBorrowedBook();
			        break;
			        
			    case 5:
			    	System.exit(0);
			    
			    default:
			        System.out.println("Worng choice : ) Please select a vaild choice! Thank You");
			}
		}
		
		/*library.listAvailableBooks();
		library.listBorrowedBooks();
		library.findMemberWithMostBooks();
		library.findMostBorrowedBook();*/
	}
}
