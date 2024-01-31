package Generic;

public class GenericIteratorClass
   {
    // initialize constant variables
    private static final int DEFAULT_CAPACITY = 10, NOT_FOUND = -1;
    private static final char LEFT_BRACKET = 91, RIGHT_BRACKET = 93, SPACE = 32;
      
    // initialize class variables
    private int[] iteratorArray;
    private int iteratorSize, iteratorCapacity, currentIndex;
      
    
    /* default constructor   
     * Description:
     *   Default constructor, initializes iterator to default capacity (10)
     */
    public GenericIteratorClass()
       {
        // initialize default class variables
        this.iteratorCapacity = DEFAULT_CAPACITY;
        this.currentIndex = 0;
        this.iteratorSize = 0;
        this.iteratorArray = new int[ iteratorCapacity ];
       }
      
      
    /* initialization constructor  
     * Description:
     *   Initializing constructor, initializes iterator to specified capacity
     * Parameters:
     *   @param capacity - initial capacity specification for the iterator
     */
    public GenericIteratorClass( int capacity )
       {
        // initialize given class variables 
        iteratorCapacity = capacity;
        currentIndex = 0;
        iteratorSize = 0;
        iteratorArray = new int[ iteratorCapacity ];
       }
      
      
    /* clear 
     * Description: 
     *   Clears iterator of all valid values by setting array size and current 
     *   index to zero, values remain in array but are not accessible
     */
    public void clear()
       {
        // set size and index to 0
        iteratorSize = 0;
        currentIndex = 0;
       }
      
      
    /* displayIterator  
     * Description: 
     *   Description: 
     *   shows iterator from beginning to end with brackets around current index
     * Note:
     *   No display if stack is empty
     */ 
    public void displayIterator()
       {
        // initialize variables
        int index;
        
        // loop across array
        for( index = 0; index < iteratorSize; index++ )
           {
            // if index is at current index
            if( index == currentIndex )
               {
                // print bracket, space, value, space, end bracket
                System.out.print( LEFT_BRACKET );
                System.out.print( iteratorArray[ index ] );
                System.out.print( RIGHT_BRACKET );
                System.out.print( SPACE );
               }
        
            // else
            else
               {
                // print value, space
                System.out.print( iteratorArray[ index ] );
                System.out.print( SPACE );
               }
           }
        // end the line
        System.out.println();
       }
      
      
    /* getValueAtCurrent   
     * Description:
     *   returns value at current index
     * Returns:
     *   @return integer value at current index
     */
    public int getValueAtCurrent()
       {
        // makes sure index is in array
        if( currentIndex < iteratorSize && currentIndex >= 0 )
           {
            // return val
            return iteratorArray[ currentIndex ];
           }
        // otherwise return not found
        return NOT_FOUND;
       }
    
    
    /* hasNext
     * Description:
     *   checks for next element available in iterator
     * Note: 
     *   Uses one line of code
     * Returns:
     *   @return Boolean result of test
     */
    public boolean hasNext()
       {
        // checks if next val is at the end of array
        if( currentIndex + 1 < iteratorSize )
           {
            // return has next
            return true; 
           }
        // return none next
        return false;
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
        // check if next val is at beginning of array
        if( currentIndex - 1 > NOT_FOUND )
           { 
            // return has prev
            return true;
           }
        // return none prev
        return false;
       }
    
    
    /* insertAtCurrent
     * Description:
     *   inserts item into iterator at current index
     * Note: 
     *   Must check for resize after operation
     * Parameters:
     *   @param newVal - integer value to be inserted
     */
    public void insertAtCurrent​( int newVal )
       {
        // initialize variables
        int index;
          
        // check if it needs to be resized
        resize();
          
        // loop across array moving every item back until the current index
        for( index = iteratorSize - 1; index >= currentIndex; index-- )
           {
            // push every item in front of location to be inserted back
            iteratorArray[ index + 1 ] = iteratorArray[ index ];
           }
          
        // insert item at index
        iteratorArray[ currentIndex ] = newVal;
          
        // increment size
        iteratorSize++;
       }
      
      
    /* insertAtEnd  
     * Description: 
     *   inserts item into iterator at end of iterator
     * Note: 
     *   Does not affect current index
     *   Must check for resize after operation
     * Parameters:
     *   @param newVal - integer value to be inserted
     */
    public void insertAtEnd​( int newVal )
       {
        // check if it needs to be resized
        resize();
        
        // add item to the back
        iteratorArray[ iteratorSize ] = newVal;
        
        // increment size
        iteratorSize++;
       }
      
      
    /* insertAtFront 
     * Description:
     *   inserts item into iterator at beginning of iterator
     * Note: 
     *   Does not affect current index
     *   Must check for resize after operation
     * Parameters:
     *   @param newVal - integer value to be inserted
     *   @param moveNext
     */
    public void insertAtFront​( int newVal )
       {
        // initialize variables
        int index; 
        
        // check if it needs to be resized
        resize();
          
        // loop across array moving every item back one
        for( index = iteratorSize - 1; index > NOT_FOUND; index-- )
           {
            iteratorArray[ index + 1 ] = iteratorArray[ index ];
           }
          
        // add new val to the front
        iteratorArray[ 0 ] = newVal;
        
        // increment size
        iteratorSize++;
       }
      
      
    /* moveNext   
     * Description:
     *   moves current index to the right, if not at beginning
     * Returns:
     *   @return Boolean result of action
     */
    public boolean moveNext()
       {
        // if not empty, there is a next item and not at beginning, 
        // set current index to 0
        if( hasNext() )
           {
            currentIndex++;
            
            // return success
            return true;
           }
        // return failure
        return false;
       }
      
      
    /* movePrev  
     * Description: 
     *   moves current index to the left, if not at beginning
     * Returns:
     *   @return Boolean result of action
     */
    public boolean movePrev()
       {
        // if not empty and not the first item, 
        // set current index to 0
        if( hasPrev() )
           {
            currentIndex--;
            
            // return success
            return true;
           }
        // return failure
        return false;
       }
      
      
    /* isEmpty  
     * Description: 
     *   Tests for size of array equal to zero, no valid values stored in array
     * Returns:
     *   @return Boolean result of test for empty
     */
    public boolean isEmpty()
       {
        // tests if size is 0 or not, returns true or false depending
        if( iteratorSize == 0 )
           {
            return true;
           }
        return false;
       }
      
      
    /* removeAtCurrent
     * Description:   
     *   removes item from iterator at current index
     * Note:
     *   Must resolve condition if last item removed
     * Returns:
     *   @return integer value if successful, NOT_FOUND if not
     */
    public int removeAtCurrent()
       {
        // initialize variables
        int index, returnVal;
        
        // if not empty
        if( !isEmpty() )
           {
            // set return val
            returnVal = iteratorArray[ currentIndex ];
            // loop across array starting at current moving each item back
            for( index = currentIndex; index < iteratorSize - 1; index++ )
               {
                iteratorArray[ index ] = iteratorArray[ index + 1 ];
               }
            // decrement size
            iteratorSize--;
            
            // if at end of the list, decrement current index
            if( iteratorSize == currentIndex )
               {
                currentIndex--;
               }
        
            // return success
            return returnVal;
           }
        
        // return failure
        return NOT_FOUND;
       }
      
      
    /* resize 
     * Description:  
     *   Resets array capacity to twice the current capacity only as needed
     */
    public void resize()
       {
        // initialize variables
        int index = 0;
        int[] tempArr = new int[ iteratorCapacity * 2 ];
        
        // check if needs to be resized
        if( iteratorSize >= iteratorCapacity )
           {
            // double size of capacity
            iteratorCapacity *= 2;
            
            // make new array and copy over items
            for( index = 0; index < iteratorSize; index++ )
               {
                tempArr[ index ] = iteratorArray[ index ];
               }
            
            // reset iterator array with greater capacity
            iteratorArray = new int[ iteratorCapacity ];
            
            // move copy items to actual array
            for( index = 0; index < iteratorSize; index++ )
               {
                iteratorArray[ index ] = tempArr[ index ];
               }
           }
       }
    
      
      
    /* setToFirst  
     * Description: 
     *   sets current index to beginning
     * Returns:
     *   @return Boolean result of action
     */
    public boolean setToFirst()
       {
        // if not empty, set current index to first item
        if( !isEmpty() )
           {
            currentIndex = 0;
            
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
     *   @return Boolean result of action
     */
    public boolean setToLast()
       {
        // if not empty, set current index to last item
        if( !isEmpty() )
           {
            currentIndex = iteratorSize - 1;
            
            // return success
            return true;
           }
        // return failure
        return false;
       }
   }
