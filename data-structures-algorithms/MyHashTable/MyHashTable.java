import java.util.*;

public class MyHashTable<T>
{
	LinkedList<T>[] arr;
	
	public MyHashTable(int size)
	{
		arr = (LinkedList<T>[]) new LinkedList[size];
		
		for (int i = 0; i < size; i++)
		{
			arr[i] = new LinkedList<T>();
		}	
	}

	private int hash(T item)
	{
		return Math.abs(item.hashCode())%arr.length;
	}

	public void insert(T item)
	{
		int hash = hash(item);
		arr[hash].addFirst(item);
	}

	public void delete(T item)
	{
		int hash = hash(item);
		arr[hash].remove(item);
	}
	
	public boolean find(T item)
	{
		int hash = hash(item);
		return arr[hash].contains(item);
	}

	public boolean isEmpty()
	{
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i].size() > 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public void makeEmpty()
	{
	        for(int i = 0; i < arr.length; i++)
	        {
	                arr[i].clear();
	        }
	}
	
	public int size()
	{
	        int result = 0;
	        for(int i = 0; i < arr.length; i++)
	        {
	                result = result + arr[i].size();
	        }
	        return result;
	}

	public void print()
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(i + ": ");
			for(int j = 0; j < arr[i].size(); j++)
			{
				System.out.print(arr[i].get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public Iterator<T> iterator()
        {
                return new Iter();
        }
	
	private class Iter implements Iterator<T>
	{
	        public int i;
	        public int j;
	        
	        public Iter()
	        {
	                i = arr.length;
	                for(int c = 0; c < arr.length; c++)
	                {
	                        if(arr[c].size() >= 1)
	                        {
	                                i = c;
	                                c = arr.length;
	                        }
	              
	                }

	                j = 0;
	        }
	        
	        public boolean hasNext()
                {
                        return i < arr.length;
                }
                public T next()
                {                       
                        if(!hasNext())
                        {
                                throw new NoSuchElementException();
                        }            
                        T answer = arr[i].get(j);               
                        j++;                        
                        if(j >= arr[i].size())
                        {
                                j=0;
                                i++;
                                while(i < arr.length && arr[i].size() == 0)
                                {
                                        i++;
                                }
                        }                        
                        return answer;
                }
                public void remove()
                {
                        throw new UnsupportedOperationException();
                }
	        
	        
	}	
}
