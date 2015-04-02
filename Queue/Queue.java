public class Queue<T>
{
   //attributes
   private LinkedList<T> list;
   int cursor;
   
   //constructor to create an empty list   
   public Queue()
   {
      list = new LinkedList<T>();
   }
   
   //adds an item to the end
   public void enqueue(T item)
   {
      if(list!=null)
         list.addToEnd(item);
      else
         list.add(item);         
   }
   
   //removes the front
   public T dequeue()
   {  
      T data = list.getAt(0);
      list.removeAt(0);
      return data;
   }
   
   //gets the size
   public int size()
   {
      return list.size();
   }
   
   //checks if queue is empty
   public boolean isEmpty()
   {
      return (list.size()==0);
   }
   
   //empties the list
   public void clear()
   {
      list.clear();
   }
   
   //gets the data of the first item
   public T peek()
   {
      return list.getAt(0);
   }
   
   //returns the index of an item, -1 if not found
   public int positionOf(T item)
   {
      return list.indexOf(item);
   }
   
   //removes the first occurence of a specific item
   public void remove(T item)
   {
      list.remove(item);
   }
   
   //returns the first item, if null returns null
   public T first()
   {  
      if(list.size()==0)
         return null;       
      
      cursor=0;
      return list.getAt(cursor);   
   }
   
   public T next()
   {
      if(cursor<0 || cursor>=list.size()-1)
         return null;
      
      cursor++;
      return list.getAt(cursor);                 
   }   

   public void enumerate()
   {
      list.enumerate();
   }
   
}