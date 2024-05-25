import java.util.*;
class Book
{
	private int id;
	private String title;
	private String author;
	private boolean isAvailable;
	
	public Book(int id,String title,String author)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public boolean isAvailable()
	{
		return isAvailable;
	}
	
	public void setAvailable(boolean available)
	{
		isAvailable = available;
	}
	
	public String toString()
	{
		return "Book {"+" Book Id = "+id+", Book Title = "+title+", Author of Book = "+author+", Book Avalability Status = "+isAvailable+ " } ";
	}
}

class Member
{
	private int id;
	private String name;
	
	public Member(int id,String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return "Member {"+"Member Id = "+id+", Member name = "+name+ " } ";
	}
}

class Transaction
{
	private Member member;
	private Book book;
	private Date date;
	private String type;
	
	public Transaction(Member member,Book book,Date date,String type)
	{
		this.member = member;
		this.book = book;
		this.date = date;
		this.type = type;
	}
	
	public Member getMember()
	{
		return member;
	}
	
	public Book getBook()
	{
		return book;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String toString()
	{
		return "Transaction {"+"Member = "+member+", Book = "+book+", Date = "+date+", Type = "+type+" } ";
	}
}

public class Library
{
	private Map<Integer,Book> books = new HashMap<>();
	private Map<Integer,Member> members = new HashMap<>();
	private List<Transaction> transactions = new ArrayList<>();
	 
	public void addBook(Book book)
	{
		books.put(book.getId(),book);
	}
	 
	public void addMember(Member member)
	{
		members.put(member.getId(),member);
	}
	 
	public void borrowBook(int memberId, int bookId)
	{
		Book book = books.get(bookId);
		Member member = members.get(memberId);
	     
		if(book != null && member != null && book.isAvailable())
		{
			book.setAvailable(false);
			transactions.add(new Transaction(member, book, new Date(),"borrow"));
		}
		else
		{
			System.out.println("Book is not Available or member/book does not exits.");
		}
	}
	 
	public void returnBook(int memberId,int bookId)
	{
		Book book = books.get(bookId);
		Member member = members.get(memberId);
     
		if(book != null && member != null && !book.isAvailable())
		{
			book.setAvailable(true);
			transactions.add(new Transaction(member, book, new Date(),"return"));
		}
		else 
		{
			System.out.println(("Book is not Borrowed or member/book does not exits."));
		}
	}
	 
	public void listAvailableBooks()
	{
		System.out.println("Available Books:");
	     
		for(Book book : books.values())
		{
			if(book.isAvailable())
			{
				System.out.println(book);
			}
		}
	}
	 
	public void listBorrowedBooks()
	{
		System.out.println("Borrowed Books");
	     
		for(Transaction transaction : transactions)
		{
			if(transaction.getType().equals("borrow"))
			{
				System.out.println("Book: "+transaction.getBook()+"Borrowed by: "+transaction.getMember());
			}
		}ZzsXAa
	}
	 
	public void findMemberWithMostBooks()
	{
		Map<Integer, Integer> borrowCount = new HashMap<>();
	     
		for(Transaction transaction : transactions)
		{
			if(transaction.getType().equals("borrow"))
			{
				borrowCount.put(transaction.getMember().getId(),borrowCount.getOrDefault(transaction.getMember().getId(), 0) + 1);
			}
		}
	     
		int maxBorrows = 0;
		Member topMember = null;
	     
		for(Map.Entry<Integer,Integer> entry : borrowCount.entrySet())
		{
			if(entry.getValue() > maxBorrows)
			{
				maxBorrows = entry.getValue();
				topMember = members.get(entry.getKey());
			}
		}
		System.out.println("Member who borrowed the most books: "+topMember);
	}
	       
	public void findMostBorrowedBook()
	{
		Map<Integer, Integer> borrowCount = new HashMap<>();
	     
		for(Transaction transaction : transactions)
		{
			if(transaction.getType().equals("borrow"))
			{
				borrowCount.put(transaction.getBook().getId(),borrowCount.getOrDefault(transaction.getBook().getId(), 0) + 1);
			}
		}
	     
		int maxBorrows = 0;
		Book topBook = null;
	     
		for(Map.Entry<Integer, Integer> entry : borrowCount.entrySet())
		{
			if(entry.getValue() > maxBorrows)
			{
				maxBorrows = entry.getValue();
				topBook = books.get(entry.getKey());
			}
		}
		System.out.println("Most borrowed book: "+topBook);
	}
}
