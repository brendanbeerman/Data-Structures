import java.util.*;
public class BinarySearchTree<T extends Comparable<T>> 
{
	private BinaryTree<T> tree;
	int size;
	
	
	public BinarySearchTree()
	{
		tree = new BinaryTree<T>();
		size = 0;
	}
	public BinaryTree<T> getTree()
	{
		return tree;
	}
	
	public boolean isEmpty()
	{
		return tree.isEmpty();
	}
	
	public int size()
	{
		return size;
	}
	
	public BinaryTree<T> search(T key)
	{
		BinaryTree<T> t = tree;
		boolean found = false;
		while(!found&&t!=null)
		{
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else
				found = true;
		}
		if (found)
			return t;
		else
			return null;
	}
	
	
	public void insert(T item)
	{
		if (tree.isEmpty())
		{
			tree.makeRoot(item);
			size++;
			return;
		}
		BinaryTree<T> t = tree;
		boolean done = false;
		//BinaryTree<T> newNode = null;
		while (!done)
		{
			int c = item.compareTo(t.getData());
			if (c==0)
			{
				System.out.println("Duplicate item. Can't insert");
				done=true;
			}
			else if (c<0)
			{
				if (t.getLeft()==null)
				{
					BinaryTree<T> newNode = new BinaryTree<T>();
					t.setLeft(newNode);
					newNode.setParent(t);
					newNode.setData(item);
					done = true;
					size++;
				}
				else
					t = t.getLeft();
			}
			else if (c>0)
			{
				if (t.getRight()==null)
				{
					BinaryTree<T> newNode = new BinaryTree<T>();
					t.setRight(newNode);
					newNode.setParent(t);
					newNode.setData(item);
					done = true;
					size++;
				}
				else
					t = t.getRight();
			}
				
		}

	}
	
	public BinaryTree<T> findPredecessor(BinaryTree<T> node)
	{
		//if (node==null)
			//return null;
		if (node.getLeft()==null)
			return null;
		BinaryTree<T> pred = node.getLeft();
		while (pred.getRight()!=null)
			pred = pred.getRight();
			
		return pred;
		
	}
	
	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach)
	{
		BinaryTree<T> parent = deleteNode.getParent();
		deleteNode.clear();
		if (parent == null)
			return;
		if (attach == null){ 
				if (parent.getLeft()==deleteNode)
					parent.setLeft(null);
				else
					parent.setRight(null);
				
				deleteNode.setParent(null);
				return;
		}
		
		if (deleteNode==parent.getLeft())
		{
			parent.detachLeft();
			attach.setParent(null);
			parent.attachLeft(attach);
		}
		else
		{
			parent.detachRight();
			attach.setParent(null);
			parent.attachRight(attach);
		}
	}
	
	public void delete(T key)
	{
		
		if (tree.isEmpty()){System.out.println("Can't delete. Empty tree"); return;}
		
		BinaryTree<T> deleteNode = search(key);
		
		if (deleteNode == null){System.out.println("Can't delete. Key not found"); return;}
		
		BinaryTree<T> hold = null;
		
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null)
		{
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null)
		{
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
		else if (deleteNode.getRight()==null)
		{
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else
		{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode = hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
		size--;
	}  
   //exercise 1
   public T findMax()
   {
      BinaryTree<T> t = tree;
      while(t.getRight()!=null)
         t=t.detachRight();
         
      return t.getData();                  
   }
   //exercise 2
   public T findMin()
   {
      BinaryTree<T> t = tree;
      while(t.getLeft()!=null)
         t=t.detachLeft();
         
      return t.getData();                  
   }   
   //exercise 3
   //driver method
   public BinaryTree<T> recursiveSearch(T key) 
   { 
      if (tree.isEmpty()) 
         return null; 
      else 
         return recursiveSearch(tree, key); 
   } 
   //recursive search method 
   public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key) 
   { 
         if (key.compareTo(t.getData())<0)
				recursiveSearch(t.getLeft(), key);
			else if (key.compareTo(t.getData())>0)
				recursiveSearch(t.getRight(), key);
            
		return t;
   }
   //exercise 4
   //driver method
   public boolean isSearch(BinaryTree<T> t) 
   { 
      ArrayList<T> l = new ArrayList<T>(), r = new ArrayList<T>();
      BinaryTree<T> left, right;
      T rd = t.getData();
      if(t.getLeft()!=null)
         l = dataList(left = t.detachLeft());
            
      if(t.getRight()!=null)
         r = dataList(right = t.detachRight());
      
      if(minMax(rd, l)==true&&minMax(rd, r)==true)        
         return true; 
         
      else         
         return false;
   } 
   public boolean minMax(T rd, ArrayList<T> l)
   {
      int a=0, b=0, c=0;
      for(int i=0;i<l.size();i++)
      {
         if(rd.compareTo(l.get(i))>0)
            a++;
            
         else if(rd.compareTo(l.get(i))==0)
            b++;
             
         else
            c++;                       
      }
      
      if(b>0)
         return false;
         
      else if(a>0&&c==0&&b==0)
         return true;
         
      else if(c>0&&a==0&&b==0)
         return true;
         
      else
         return false;                  
   }
   //method to makes arrays of the nodes
   public ArrayList<T> dataList(BinaryTree<T> t)
   {
      ArrayList<BinaryTree<T>> tree = new ArrayList<BinaryTree<T>>();
      ArrayList<T> list = new ArrayList<T>();
      
      while(!(t.isEmpty()))
      {
         BinaryTree<T> temp = tree.remove(0);
         list.add(temp.getData());
         if(t.getLeft()!=null)
            tree.add(t.detachLeft());
            
         if(t.getRight()!=null)
            tree.add(t.detachRight());          
      }
      return list;
   }
   
   //exercise 5
   //driver method
   public BinarySearchTree<T> combineTrees(BinarySearchTree<T> f, BinaryTree<T> s) 
   { 
      BinarySearchTree<T> third = combined(f, s); 
      return third; 
   } 
   //method to find out if it is a binary search tree
   public BinarySearchTree<T> combined(BinarySearchTree<T> f, BinaryTree<T> s)
   {
      List<BinaryTree<T>> list = new ArrayList<BinaryTree<T>>();
      list.add(s);
      while(!(list.isEmpty()))
      {
         BinaryTree<T> temp = list.remove(0);
         if(temp.getLeft()!=null)
            list.add(temp.detachLeft());
            
         if(temp.getRight()!=null)
            list.add(temp.detachRight()); 
            
         f.insert(temp.getData());                       
      }
      return f;
   }   
}