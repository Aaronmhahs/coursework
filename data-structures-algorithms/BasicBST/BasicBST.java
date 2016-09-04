public class BasicBST
{
	private class BSTNode
	{
		private int element;
		private BSTNode left;
		private BSTNode right;
	}

	private BSTNode root;
	
	public BasicBST()
	{
		root = null;
	}

	public void insert(int element)
	{
		root = insert(element, root);
	}

	private BSTNode insert(int element, BSTNode root)
	{
		if (root == null)
		{
			root = new BSTNode();
			root.element = element;
		}	
		else
		{
			if(element < root.element)
			{
				root.left = insert(element, root.left); 
			}
			else
			{
				root.right = insert(element, root.right);
			}
		}
		return root;
	}


	public int countOdds()
	{
		return countOdds(root);
	}

	private int countOdds(BSTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else if(root.element%2 != 0)
		{
			return countOdds(root.left) + 1 + countOdds(root.right);
		}
		else
		{
			return countOdds(root.left) + countOdds(root.right);
		}
	}
	
	public int height()
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

	public int countLeaves()
	{
		return countLeaves(root);
	}

	private int countLeaves(BSTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		if(root.left == null && root.right == null)
		{
			return 1;
		}		
		return countLeaves(root.left) + countLeaves(root.right);
	}

	public int countOneChildParents()
	{
		return countOneChildParents(root);
	}

	private int countOneChildParents(BSTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		if(root.left == null && root.right == null)
		{
			return 0;
		}
		if(root.left == null && root.right != null)
                {
                        return 1 + countOneChildParents(root.right);
                }
		else if(root.left != null && root.right == null)
		{
			return 1 + countOneChildParents(root.left);	
		}
                return countOneChildParents(root.left) + countOneChildParents(root.right);
	}
}	
