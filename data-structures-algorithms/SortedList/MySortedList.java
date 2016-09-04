public class MySortedList
{
	private class Node
	{
		public int element;
		public Node next;
	}

	private Node head;
	
	public MySortedList()
	{
		head = null;
	}

	public void add(int item)
	{
		if(head == null)
		{
			head = new Node();
			head.element = item;
			return;
		}
		else if(item < head.element)
		{
			Node newNode = new Node();
			newNode.element = item;
			newNode.next = head;
			head = newNode;
			return;
		}

		boolean inPlace = false;
		Node current = head;
		while(!inPlace)
		{
			if(current.next == null)
			{
				inPlace = true;
			}
			else if(item > current.next.element)
			{
				current = current.next;
			}
			else
			{
				inPlace = true;
			}
						
		}
		Node newNode = new Node();
		newNode.element = item;
		newNode.next = current.next;
		current.next = newNode;
	}
	

	public void delete(int item)
	{
		if(head == null)
		{
			return;
		}
		else if(head.element == item)
		{
			head = head.next;
			return;
		}
		boolean done = false;
		Node current = head;
		while(!done)
		{
			if(current.next == null)
			{
				done = true;
			}
			else if(current.next.element == item)
			{
				current.next = current.next.next;
				done = true;
			}
			current = current.next;
		}
		return;
	}

	public int max()
	{
		Node current = head;
		int biggest = head.element;
		while(current.next != null)
		{
			if(current.next.element > biggest)
			{
				biggest = current.next.element;
			}
			current = current.next;	
		}
		return biggest;
	}

	public int min()
	{
		Node current = head;
                int smallest = head.element;
                while(current.next != null)
                {
                        if(current.next.element < smallest)
                        {
                                smallest = current.next.element;
                        }
			current = current.next;
                }
                return smallest;
	}

	public void print()
	{
		Node current = head;
		if(isEmpty())
		{
			return;
		}
		while(current.next != null)
		{
			System.out.print(current.element + " ");
			current = current.next;
		}
		System.out.println(current.element);
	}

	public boolean isEmpty()
	{
		if(head == null)
		{
			return true;
		}
		return false;
	}
}

