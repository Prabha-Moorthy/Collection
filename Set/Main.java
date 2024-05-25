import java.util.*;
class Main
{
	public static void main(String args[])
	{
		TreeSet t=new TreeSet();
		t.add(10);
		t.add(0);
		t.add(15);
		t.add(5);
		t.add(20);
		t.add(20);
		System.out.println(t);
	}
}
class MyComparator implements Comparator
{
	public int compare(Object o1,Object o2)
	{
		Integer I1=(Integer)o1;
		Integer I2=(Integer)o2;
		
		if(I1 < I2)
			return 1;
		else if(I1 > I2)
			return -1;
		else
			return 0;
	}
}
