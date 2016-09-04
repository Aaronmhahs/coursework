import java.util.*;

public class BST<T extends Comparable<? super T>>
{
	private class BSTNode
	{
		public T element;
		public BSTNode childL;
		public BSTNode childR;
	}
	
	private BSTNode root;
	
	private class PreIter implements Iterator<T>
	{
		public MyStack<BSTNode> stack;
		
		public PreIter()
		{
			stack = new MyStack<BSTNode>();
			if(root != null)
			{
				stack.push(root);
			}
		}		

		public boolean hasNext()
		{
			return(!stack.isEmpty());
		}
		
		public T next()
		{
			if(!hasNext())
			{
				throw new NoSuchElementException();
			}
			BSTNode popped = stack.pop();
			if(popped.childR != null)
			{
				stack.push(popped.childR);
			}
			if(popped.childL != null)
			{
				stack.push(popped.childL);
			}
			return popped.element;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	private class InIter implements Iterator<T>
	{
		public MyStack<BSTNode> stack;		

		public InIter()
		{
			stack = new MyStack<BSTNode>();
			if(root != null)
			{
				stack.push(root);
				stackUpLefts(root);
			}
		}

		private void stackUpLefts(BSTNode x)
		{
			while(x.childL != null)
			{
				stack.push(x.childL);
				x = x.childL;
			}
		}		
	
		public boolean hasNext()
		{
			return(!stack.isEmpty());
		}
		
		public T next()
		{
			if(stack.isEmpty())
			{
				throw new NoSuchElementException();
			}
			BSTNode popped = stack.pop();
			if(popped.childR != null)
			{
				stack.push(popped.childR);
				stackUpLefts(popped.childR);
			}
			return popped.element;
			
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	private class LevelIter implements Iterator<T>
	{
		public LQueue<BSTNode> queue;

		public LevelIter()
		{
			queue = new LQueue<BSTNode>();
			if(root != null)
			{
				queue.enqueue(root);
			}	
		}

		public boolean hasNext()
		{
			return(!queue.isEmpty());	
		}
		
		public T next()
		{
			if(queue.isEmpty())
			{
				throw new NoSuchElementException();
			}
			BSTNode ref = queue.dequeue();
			if(ref.childL != null)
			{
				queue.enqueue(ref.childL);
			}
			if(ref.childR != null)
			{
				queue.enqueue(ref.childR);
			}
			return ref.element;
		}
		
		public void remove()
		{
			throw new UnsupportedOperationException();
		}
	}
	
	public static class MyException extends RuntimeException
	{
		public MyException()
		{
			super();
		}

		public MyException(String message)
		{
			super(message);
		}
	}
	
	public BST()
	{
		root = null;
	}
	
	public void insert (T item)
	{
		root = insert(item, root);	
	}
	
	private BSTNode insert(T item, BSTNode theRoot)
	{
		if(theRoot == null)
		{
			theRoot = new BSTNode();
			theRoot.element = item;
		}
		else
		{
			if(item.compareTo(theRoot.element) < 0)
			{
				theRoot.childL = insert(item, theRoot.childL);
			}
			else
			{
				theRoot.childR = insert(item, theRoot.childR);
			}
		}
		return theRoot;
	}
		
	public void delete (T item)
	{
		root = delete(item, root);
	}
	
	private BSTNode delete(T item, BSTNode theRoot)
	{
		if(theRoot != null)
		{
			if(item.compareTo(theRoot.element) < 0)
			{
				theRoot.childL = delete(item, theRoot.childL);
			}
			else if(item.compareTo(theRoot.element) > 0)
			{
				theRoot.childR = delete(item, theRoot.childR);
			}
			else
			{
				theRoot = deleteNode(theRoot);
			}				
		}
		return theRoot;
	}
	
	private BSTNode deleteNode(BSTNode theRoot)
	{
		BSTNode newRoot = new BSTNode();
		if(theRoot.childL != null && theRoot.childR != null)//two children
		{
			T nextVal = successor(theRoot);
			theRoot.element = nextVal;
			theRoot.childR = delete(nextVal, theRoot.childR);
			newRoot = theRoot;
		}
		else
		{
			if(theRoot.childL != null && theRoot.childR == null)//only left child
			{
				newRoot = theRoot.childL;
			}
			else
			{
				if(theRoot.childR != null)//only right child
				{
					newRoot = theRoot.childR;
				}
				else//no children
				{
					newRoot = null;
				}
			}
		}
		return newRoot;
	}
	
	private T successor(BSTNode theRoot)
	{
		BSTNode current = theRoot.childR;
		while(current.childL != null)
		{
			current = current.childL;
		}
		return current.element;
	}
	
	public boolean find (T item)
	{
		BSTNode compare = root;
		while(!item.equals(compare.element))
		{
			if(compare == null)
			{
				return false;
			}
			else if(item.compareTo(compare.element) < 0)//if item is smaller than the Node's element
			{
				compare = compare.childL; //Set compare to point to the left (smaller) child
			}
			else if(item.compareTo(compare.element) > 0)//if item is larger than the Node's element
			{
				compare = compare.childR; //Set compare to point to the right (larger) child
			}
		}
		return true;
	}
	
	public boolean isEmpty()
	{
		if(root == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void makeEmpty()
	{
		root = null;
	}
	
	public int size()
	{
		return size(root);
	}
	
	private int size(BSTNode theRoot)
	{
		if(theRoot == null)
		{
			return 0;
		}
		else if(theRoot.childL == null && theRoot.childR == null)
		{
			return 1;
		}
		else
		{
				return size(theRoot.childL) + 1 + size(theRoot.childR);
		}
	}
	
	public T findMinimum()
	{
		if(root == null)
		{
			throw new MyException();
		}
		else
		{
			BSTNode smallest = root;
			while(smallest.childL != null)
			{
				smallest = smallest.childL;
			}
			return smallest.element;
		}
	}
	
	public T findMaximum()
	{
		if(root == null)
		{
			throw new MyException();
		}
		else
		{
			BSTNode largest = root;
			while(largest.childR != null)
			{
				largest = largest.childR;
			}
			return largest.element;
		}
	}
	
	public Iterator<T> iteratorPre()
	{
		return new PreIter();
	}
	
	public Iterator<T> iteratorIn()
	{
		return new InIter();
	}
	
	public Iterator<T> iteratorLevel()
	{
		return new LevelIter();
	}
	
	public void printTree()
	{
		printTree(root, "");
	}
	
	private void printTree(BSTNode theRoot, String indent)
	{
		if(theRoot == null)
		{
			return;
		}
		else
		{
			System.out.println(indent + theRoot.element);
			indent = indent + "    ";
			printTree(theRoot.childL, indent);
			printTree(theRoot.childR, indent);
		}
	}
	
	public String toString()
	{
		return toString(root, "");
	}
	
	private String toString(BSTNode theRoot, String result)
	{
		if(theRoot == null)
		{
			return result;
		}
		else
		{
			result = result + theRoot.element;
			result = result + toString(theRoot.childL, result);
			result = result + toString(theRoot.childR,result);
			return result;

		}
	}
}
