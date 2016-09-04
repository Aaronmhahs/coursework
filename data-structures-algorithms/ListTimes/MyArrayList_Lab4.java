
public class MyArrayList_Lab4<AnyType> implements Iterable<AnyType>
{
    /**
     * Construct an empty ArrayList.
     */
    public MyArrayList_Lab4( )
    {
        doClear( );
    }
    
    /**
     * Returns the number of items in this collection.
     */
    public int size( )
    {
        return theSize;
    }
    
    /**
     * Returns true if this collection is empty.
     */ 
    public boolean isEmpty( )
    {
        return size( ) == 0;
    }
    
    /**
     * Returns the item at position idx.
     * if it is out of range throw an exception
     */
    public AnyType get( int idx )
    {
    	if(idx < theItems.length)
	{
		return theItems[idx];
	}
	else
	{
		throw new ArrayIndexOutOfBoundsException();
	}
    }
        
    /**
     * Changes the item at position idx,
     * return the old value, and 
     * throw an exception if index is out of range.
     */
    public AnyType set( int idx, AnyType newVal )
    {
    	if(idx < theItems.length)
	{
		AnyType temp = theItems[idx];
		theItems[idx] = newVal;
		return temp;
	}
	else
	{
		throw new ArrayIndexOutOfBoundsException();
	}
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity( int newCapacity )
    {
        if( newCapacity < theSize )
            return;

        AnyType [ ] old = theItems;
        theItems = (AnyType []) new Object[ newCapacity ];
        for( int i = 0; i < size( ); i++ )
            theItems[ i ] = old[ i ];
    }
    
    /**
     * Adds an item to this collection, at the end.
     * return true.
     */
    public boolean add( AnyType x )
    {
	if(theSize < theItems.length)
    	{
		theItems[theSize] = x;
		theSize++;
		return true;
	}
	return false;
    }
    
    /**
     * Adds an item to this collection, at the specified index.
     */
    public void add( int idx, AnyType x )
    {
	if(idx >= theItems.length)
	{
		ensureCapacity(idx);
	}
	theItems[idx] = x;
	theSize++;
    }
      
    /**
     * Removes an item from this collection.
     * return the item was removed from the collection.
     */
    public AnyType remove( int idx )
    {
    	if(idx >= 0 && idx < theSize)
	{
		AnyType temp = theItems[idx];
		theItems[idx] = null;
		for(int i = idx; i < theSize-1; i++)
		{
			theItems[i] = theItems[i+1];
		}
		theSize--;
		return temp;
	}
	else
	{
		throw new ArrayIndexOutOfBoundsException();
	}
    }
    
    /**
     * Change the size of this collection to zero.
     */
    public void clear( )
    {
        doClear( );
    }
    
    private void doClear( )
    {
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }
    
    /**
     * Obtains an Iterator object used to traverse the collection.
     * return an iterator positioned prior to the first element.
     */
    public java.util.Iterator<AnyType> iterator( )
    {
        return new ArrayListIterator( );
    }

    /**
     * Returns a String representation of this collection.
     */
    public String toString( )
    {
            StringBuilder sb = new StringBuilder( "[ " );

            for( AnyType x : this )
                sb.append( x + " " );
            sb.append( "]" );

            return new String( sb );
    }
    
    /**
     * This is the implementation of the ArrayListIterator.
     * It maintains a notion of a current position and
     * of course the implicit reference to the MyArrayList.
     */
    private class ArrayListIterator implements java.util.Iterator<AnyType>
    {
        private int current = 0;
        private boolean okToRemove = false;
        
        public boolean hasNext( )
        {
            return current < size( );
        }
        
        
        public AnyType next( )
        {
            if( !hasNext( ) ) 
                throw new java.util.NoSuchElementException( ); 
                  
            okToRemove = true;    
            return theItems[ current++ ];
        }
        
        public void remove( )
        {
            if( !okToRemove )
                throw new IllegalStateException( );
                
            MyArrayList_Lab4.this.remove( --current );
            okToRemove = false;
        }
    }
    
    private static final int DEFAULT_CAPACITY = 10;
    
    private AnyType [ ] theItems;
    private int theSize;
}

