public class BasicAVL
{
	private class AVLNode
	{
		int element;
		int height;
		AVLNode left;
		AVLNode right;
	}
	
	private AVLNode root;

	public BasicAVL()
	{
		root = null;
	}

	public void insert(int element)
	{
		root = insert(element,root);		
	}
	
	private AVLNode insert(int element, AVLNode treeRoot)
	{
		if(treeRoot == null)
		{
			treeRoot = new AVLNode();
			treeRoot.element = element;
		}
		else
		{
			if(element < treeRoot.element)
			{
				treeRoot.left = insert(element,treeRoot.left);
				if(treeRoot.left.height - height(treeRoot.right) == 2)
				{
					if(element < treeRoot.left.element)
					{
						treeRoot = rotateWithLeft(treeRoot);
					}
					else
					{
						treeRoot = doubleLeftRight(treeRoot);
					}
				}
			}
			else if(element > treeRoot.element)
			{
				treeRoot.right = insert(element,treeRoot.right);
				if(treeRoot.right.height - height(treeRoot.left) ==2)
				{
					if(element > treeRoot.right.element)
					{
						treeRoot = rotateWithRight(treeRoot);
					}
					else
					{
						treeRoot = doubleRightLeft(treeRoot);
					}
				}
			}
		}
		treeRoot.height = Math.max(height(treeRoot.left),height(treeRoot.right))+1;
		return treeRoot;
	}

	private AVLNode rotateWithLeft(AVLNode x)
	{
		AVLNode y = x.left;
		x.left = y.right;
		y.right = x;
		x.height = Math.max(height(x.left),height(x.right))+1;
		y.height = Math.max(height(y.left),height(y.right))+1;
		return y;
	}

	private AVLNode rotateWithRight(AVLNode x)
	{
		AVLNode y = x.right;
                x.right = y.left;
                y.left = x;
                x.height = Math.max(height(x.left),height(x.right))+1;
                y.height = Math.max(height(y.left),height(y.right))+1;
                return y;
	}

	private AVLNode doubleLeftRight(AVLNode x)
	{
		x.left = rotateWithRight(x.left);
		return rotateWithLeft(x);
	}

	private AVLNode doubleRightLeft(AVLNode x)
	{
		x.right = rotateWithLeft(x.right);
		return rotateWithRight(x);
	}

	private int height(AVLNode x)
	{
		int answer;
		if(x!=null)
		{
			answer = x.height;
		}
		else
		{
			answer = -1;
		}
		return answer;
	}

	public void print()
	{
		print(root,"");
	}

	private void print(AVLNode theRoot, String indent)
	{
		if(theRoot == null)
		{
			return;
		}
		else
		{
			System.out.println(indent + theRoot.element);
			indent = indent + "    ";
			print(theRoot.left, indent);
			print(theRoot.right, indent);
		}
	}	
}
