import java.util.*;

public class BST<AnyType extends Comparable<? super AnyType>>
{
	private class BSTNode<AnyType>
	{
		AnyType element;
		BSTNode<AnyType> left;
		BSTNode<AnyType> right;
	
		BSTNode(AnyType element)
		{
			this.element = element;
		}

		BSTNode(AnyType element, BSTNode<AnyType> left, BSTNode<AnyType> right)
		{
			this.element = element;
			this.left = left;
			this.right = right;
		}
	
	
	}

	private BSTNode<AnyType> root;

	public BST()
	{
		root = null;
	}

	
	public boolean isEmpty()
	{
		return root == null;
	}

	public boolean find(AnyType value) // Runtime: 13340 ns
	{
		return find(value, root);
	}

	private boolean find(AnyType value, BSTNode<AnyType> t)
	{
		if(t == null)
		{
			return false;
		}
		int compared = value.compareTo(t.element);
		if(compared<0)
		{
			return find(value, t.left);
		}
		if(compared>0)
		{
			return find(value, t.right);
		}
		else
		{
			return true;
		}
	}

	public void insert(AnyType value) // 1340484 ns
	{
		root = insert(value, root);
	}

	private BSTNode insert(AnyType value, BSTNode<AnyType> t)
	{
		if (t == null)
		{
			return new BSTNode<>(value, null, null);
		}
		
		int compared = value.compareTo(t.element);
		
		if(compared<0)
		{
			t.left = insert(value, t.left);
		}
		else if(compared>0)
		{
			t.right = insert(value, t.right);
		}
		else
		{
			;
		}
		return t;
			
	}

	public AnyType findMin()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty");
		}
		return findMin(root).element;
	}

	private BSTNode<AnyType> findMin(BSTNode<AnyType> t)
	{
		if(t == null)
		{
			return null;
		}
		else if(t.left == null)
		{
			return t;
		}
		return findMin(t.left);
	}


	public void delete(AnyType value) // 4679 ns
	{
		root = delete(value, root);
	}

	private BSTNode<AnyType> delete(AnyType value, BSTNode<AnyType> t)
	{
		if(t == null)
		{
			return t;
		}

		int compared = value.compareTo(t.element);

		if(compared<0)
		{
			t.left = delete(value, t.left);
		}
		else if(compared>0)
		{
			t.right = delete(value, t.right);
		}
		else if(t.left != null && t.right != null)
		{
			t.element = findMin(t.right).element;
			t.right = delete(t.element, t.right);
		}
		else
		{
			t = (t.left != null) ? t.left : t.right;
		}
		return t;
	}

	public int height() // 6146 ns
	{
		return height(root);
	}

	private int height(BSTNode root)
	{
		if(root == null)
		{
			return -1;
		}
		else if(height(root.left) >= height(root.right))
		{
			return height(root.left) + 1;
		}
		else
		{
			return height(root.right) + 1;
		}

	}

	public void printTree()
	{
		printTree(root, "");
	}

	private void printTree(BSTNode<AnyType> root, String indent)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			System.out.println(indent + root.element);
			indent = indent + "    ";
			printTree(root.left, indent);
			printTree(root.right, indent);
		}
	}
	
}






















