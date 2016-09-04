import java.util.*;

public class AVLTree
{
	private class AVLNode
	{
		int data;
		int height;
		AVLNode left;
		AVLNode right;

		public AVLNode()
		{
			left = null;
			right = null;
			data = 0;
			height = 0;
		}

		public AVLNode(int n)
		{
			left = null;
			right = null;
			data = n;
			height = 0;
		}
	}

	private AVLNode root;

	public AVLTree()
	{
		root = null;
	}

	public boolean isEmpty()
	{
		return root == null;
	}

	public void makeEmpty()
	{
		root = null;	
	}

	public void insert(int data)
	{
		root = insert(data, root);
	}

	private AVLNode insert(int data, AVLNode t)
	{
		if (t == null)
		{
			t = new AVLNode(data);
		}
		else if (data < t.data)
		{
			t.left = insert(data, t.left);
			if(height(t.left) - height(t.right) == 2)
				if(data < t.left.data)
				{
					t = rotatewithLeft(t);
				}	
				else
				{
					t = doubleRotateWithLeft(t);
				}	
		}
		else if(data > t.data)
		{
			t.right = insert(data, t.right);
			if(height(t.right) - height(t.left) == 2)
				if(data > t.right.data)
				{
					t = rotatewithRight(t);
				}	
				else
				{
					t = doubleRotateWithRight(t);
				}
		}		
		else
		{
			t.height = Math.max(height(t.left), height(t.right)) + 1;
		}	
		return t;
	}

	public boolean search(int key)
	{
		return search(key, root);
	}

	private boolean search(int key, AVLNode t)
	{
		boolean found = false;
		while ((t != null) && !found)
		{
			int tkey = t.data;
			if (key < tkey)
			{
				t = t.left;
			}
			else if (key > tkey)
			{
				t = t.right;
			}	
			else
			{
				found = true;
				break;
			}
			found = search(key, t);
		}
		return found;
	}

	public void delete(int data)
	{	
		root = delete(data, root);

	}

	public AVLNode delete(int data, AVLNode t)
	{
		return root;
	
	}

	public int height(AVLNode t)
	{
		int answer;
		if(t!=null)
		{
			answer = t.height;
		}
		else
		{
			answer = -1;
		}
		return answer;
	}

	public AVLNode rotatewithLeft(AVLNode t)
	{
		AVLNode y = t.left;
		t.left = y.right;
		y.right = t;
		t.height = Math.max(height(t.left),height(t.right))+1;
		y.height = Math.max(height(y.left),height(y.right))+1;
		return y;
	}

	public AVLNode rotatewithRight(AVLNode t)
	{
		AVLNode y = t.right;
		t.right = y.left;
		y.left = t;
		t.height = Math.max(height(t.left),height(t.right))+1;
		y.height = Math.max(height(y.left),height(y.right))+1;
		return y;
	}

	public AVLNode doubleRotateWithLeft(AVLNode t)
	{
		t.left = rotatewithRight(t.left);
		return rotatewithLeft(t);
	}

	public AVLNode doubleRotateWithRight(AVLNode t)
	{
		t.right = rotatewithLeft(t.right);
		return rotatewithRight(t);
	}

	public void print_tree()
	{
		print_tree(root, "");
	}

	private void print_tree(AVLNode root, String indent)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			System.out.println(indent + root.data);
			indent = indent + "    ";
			print_tree(root.left, indent);
			print_tree(root.right, indent);
		}
	}																												        




}

