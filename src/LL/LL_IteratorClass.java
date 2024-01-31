package LL;

public class LL_IteratorClass
   {
    class NodeClass
       {
        int data;
        
        NodeClass nextRef;
        
        /* default constructor
         * Description:
         *   NodeClass default constructor
         */
        public NodeClass()
           {
            // set default vals
            data = 0;
            nextRef = null;
           }
        
        /* initialization constructor
         * Description:
         *   NodeClass initialization constructor
         * Parameters:
         *   @param value - integer value for initialization
         */
        public NodeClass( int value )
           {
            // set initialized vals
            data = value;
            nextRef = null;
           }
        
        /* copy constructor
         * Description:
         *   NodeClass copy constructor
         * Parameters:
         *   @param copied - NodeClass object to be copied
         */
        public NodeClass( NodeClass copied )
           {
            // set copied vals
            data = copied.data;
            nextRef = null; // ask if i should set to copied.headRef
           }
       }
    
    // initialize class variables
    public final int NOT_FOUND = -1;
    public static final char LEFT_BRACKET = 91, RIGHT_BRACKET = 93, SPACE = 32;
    public NodeClass headRef;
    public NodeClass currentRef;
    
    /* default constructor
     * Description:
     *   Default constructor, initializes references to null
     */
    public LL_IteratorClass()
       {
        // initialize default variables
        headRef = null;
        currentRef = null;
       }
    
    
    /* copy constructor
     * Description:
     *   Copy constructor
     * Parameters:
     *   @param copied - LL_IteratorClass object to be copied
     */
    public LL_IteratorClass( LL_IteratorClass copied )
       {
        // initialize copied variables
        headRef = new NodeClass( copied.headRef );
        currentRef = new NodeClass( copied.currentRef );
        
        // initialize variables
        NodeClass wkgRef = new NodeClass( copied.headRef ), 
                  copiedWkgRef = copied.headRef; 
        
        while( copiedWkgRef.nextRef != null )
           {
            wkgRef.nextRef = new NodeClass( copiedWkgRef.nextRef );
            wkgRef = wkgRef.nextRef;
            copiedWkgRef = copiedWkgRef.nextRef;
           }
       }
    
    
    /* clear   
     * Description:
     *   Clears iterator of all valid values by setting head reference to null
     */
    public void clear()
       {
        // set refs to null
        headRef = null;
        currentRef = null;
       }
    
    
    /* displayIterator
     * Description:
     *   shows iterator from beginning to end with brackets around current index
     * Note:
     *   Displays "Empty" if list is empty
     */
    public void displayIterator() // add else for empty list
       {
        // initialize variables
        NodeClass wkgRef = headRef;
        
        // check if not empty
        if( !isEmpty() )
           {
            // while each item is not empty
            while( wkgRef != null )
               {
                // if current ref print with brackets
                if( wkgRef.data == currentRef.data )
                   {
                    System.out.print( LEFT_BRACKET );
                    System.out.print( wkgRef.data );
                    System.out.print( RIGHT_BRACKET );
                    System.out.print( SPACE );
                    wkgRef = wkgRef.nextRef;
                   }
                // else, just print them
                else
                   {
                    System.out.print( wkgRef.data );
                    System.out.print( SPACE );
                    wkgRef = wkgRef.nextRef;
                   }
               }
            // send the line
            System.out.println();
           }
       }
    
    
    /* getCurrentPriorRef  
     * Description:
     *   returns reference prior to current reference
     * Note:
     *   Returns null if current reference is at head
     * Returns:
     *   @return NodeClass object found at current
     */
    public NodeClass getCurrentPriorRef()
       {
        // initialize variables
        NodeClass wkgRef = headRef;
        
        // if not empty
        if( !isEmpty() )
           {
            // loop until nextRef is currentRef
            while( wkgRef.nextRef != currentRef )
               {
                // move wkgRef up
                wkgRef = wkgRef.nextRef;
               }
            // return ref behind current
            return wkgRef;
           }
        // return not found
        return null;
       }
    
    
    /* getValueAtCurrent   
     * Description: 
     *   returns value at current location
     * Returns:
     *   @return integer value at current location
     */
    public int getValueAtCurrent()
       {
        // return val at current
        return currentRef.data;
       }
    
    
    /* hasNext
     * Description:
     *   checks for next element available in iterator
     * Note:
     *    Uses one line of code
     *  Returns:
     *    @return Boolean result of test
     */
    public boolean hasNext()
       {
        // return if current ref has a next
        return currentRef.nextRef != null;
       }
    
    
    /* hasPrev   
     * Description:
     *   checks for previous element available in iterator
     * Note: 
     *   Uses one line of code
     * Returns:
     *   @return Boolean result of test
     */
    public boolean hasPrev() 
       {
        return currentRef != headRef;
       }
    
    
    /* insertAtCurrent
     * Description:   
     *   inserts item into iterator at current location
     * Note: 
     *   Does not affect current location
     * Parameters:
     *   @param newVal - integer value to be inserted 
     */
    public void insertAtCurrent​( int newVal ) // pushes current back
       {
        // initialize variables
        NodeClass wkgRef = getCurrentPriorRef(), temp = currentRef;
        
        // set new ref where current was
        wkgRef.nextRef = new NodeClass( newVal );
        
        // set current after new
        wkgRef.nextRef.nextRef = temp;
       }
    
    
    /* insertAtEnd
     * Description: 
     *   inserts item into iterator at end of iterator
     * Note: 
     *   Does not affect current location
     * Parameters:
     *   @param newVal - integer value to be inserted
     */
    public void insertAtEnd​( int newVal )
       {
        // initialize variables
        NodeClass wkgRef = headRef;
        
        if( headRef == null )
           {
            headRef = new NodeClass( newVal );
            currentRef = headRef;
           }
        
        else
           {
            // loop to end of list
            while( wkgRef.nextRef != null )
               {
                wkgRef = wkgRef.nextRef;
               }
        
            // add new val
            wkgRef.nextRef = new NodeClass( newVal );
           }
       }
    
    
    /* insertAtFront   
     * Description: 
     *   inserts item into iterator at beginning of iterator
     * Note:
     *   Does not affect current location
     * Parameters:
     *   @param newVal - integer value to be inserted
     */
    public void insertAtFront​( int newVal )
       {
        // initialize variables
        NodeClass newRef = new NodeClass( newVal );
        
        if( headRef == null )
           {
            headRef = new NodeClass( newVal );
            currentRef = headRef;
           }
        
        else
           {
            // set newVal.next to head
            newRef.nextRef = headRef;
          
            // set head to newVal
            headRef = newRef;
        
            if( headRef.nextRef == null )
               {
                currentRef = headRef;
               }
           }
       }
   
    
    /* moveNext   
     * Description:
     *   moves current location to the right, if not at end
     * Returns:
     *   @return Boolean result of action
     */
    public boolean moveNext()
       {
        // if there is a next val
        if( currentRef != null && currentRef.nextRef != null && 
            headRef != null )
           {
            // move current next
            currentRef = currentRef.nextRef;
            
            // return success
            return true;
           }
        // return failure
        return false;
       }
    
    
    /* movePrev   
     * Description:
     *   moves current location to the left, if not at beginning
     * Returns:
     *   @return Boolean result of action
     */
    public boolean movePrev()
       {
        // initialize variables
        NodeClass wkgRef = headRef;
        
        // if there is a prev val
        if( headRef!= null && currentRef != headRef )
           {
            // set wkgRef to prev ref
            while( wkgRef.nextRef != currentRef )
               {
                wkgRef = wkgRef.nextRef;
               }
            // move backwards
            currentRef = wkgRef;
          
            // return success
            return true;
           }
        // return failure
        return false;
       }
    
    
    /* isEmpty   
     * Description:
     *   tests for empty linked list
     * Returns:
     *   @return Boolean result of test for empty
     */
    public boolean isEmpty()
       {
        // returns if empty or not
        return headRef == null;
       }
    
    
    /* removeAtCurrent   
     * Description:
     *  removes item from iterator at current location
     * Note: 
     *   Must reset current location if last item removed
     *   Must set current reference to null if last item removed
     * Returns:
     *   @return integer value if successful, NOT_FOUND if not
     */
    public int removeAtCurrent()
       {
        // initialize variables
        int returnVal = NOT_FOUND;
        
        // if not empty
        if( !isEmpty() )
           {
            // set return val
            returnVal = currentRef.data; 
             
            // if current.next is null
            if( !hasNext() )
               {
                // move current back
                movePrev();
                
                // set current.next to null
                currentRef.nextRef = null;
               }
            // else if current is first in list
            else if( !hasPrev() && !hasNext() )
               {
                // set current to next
                currentRef = null;
               }
            // else if only item in list
            else if( !hasPrev() && hasNext() )
               {
                currentRef = currentRef.nextRef;
               }
            // else
            else
               {
                // move current back
                movePrev();
                
                // set current.next to null
                currentRef.nextRef = currentRef.nextRef.nextRef;
                
                // move ref forward
                moveNext();
               }
           }
        // return returnVal
        return returnVal;
       }
    
    
    /* setToFirst   
     * Description:
     *  sets current location to beginning
     * Returns:
     *   @return Boolean true if list is not empty, false otherwise
     */
    public boolean setToFirst()
       {
        // if not empty
        if( !isEmpty() )
           {
            // set current to first ref
            currentRef = headRef;
          
            // return success
            return true;
           }
        // return failure
        return false;
       }
    
    
    
    /* setToLast
     * Description:
     *   sets current index to end
     * Returns:
     *   @return Boolean true if list is not empty, false otherwise
     */
    public boolean setToLast()
       {
        // initialize variables
        NodeClass wkgRef = headRef;
        
        // if not empty
        if( !isEmpty() )
           {
            // loop until at end
            while( wkgRef.nextRef != null )
               {
                wkgRef = wkgRef.nextRef;
               }
            // set current to end
            currentRef = wkgRef;
          
            // return success
            return true;
           }
        // return failure
        return false;
       }
   }
