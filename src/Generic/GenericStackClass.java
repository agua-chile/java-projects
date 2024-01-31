package Generic;

public class GenericStackClass<GenericData extends java.lang.Comparable<GenericData>>
   {
    private static int DEFAULT_CAPACITY = 10;
    private final static char SPACE = ' ';
    private Object[] stackArray;
    private int stackSize;
    private int stackCapacity;
    
    
    /* default constructor
     * Description:
     *   Default constructor, initializes stack to default capacity (10)
     */
    public GenericStackClass()
       {
        // initialize default capacity, size and array
        stackCapacity = DEFAULT_CAPACITY;
        stackArray = new Object[ stackCapacity ];
        stackSize = 0;
       }
      
      
    /* initialization constructor
     * Description:
     *   Initializing constructor, initializes stack to specified capacity
     * Parameters:
     *   @param capacity - maximum capacity specification for the stack
     */
    public GenericStackClass( int capacity )
       {
        // initialize capacity, size and array
        stackCapacity = capacity;
        stackArray = new Object[ stackCapacity ];
        stackSize = 0;
       }
      
      
    /* clear 
     * Description:
     *   Clears stack of all valid values by setting array size to zero, values 
     *   remain in array but are not accessible
     */
    public void clear()
       {
        // set stack size to 0
        stackSize = 0;
       }
      
      
    /* displayStack
     *  Description:
     *    Description: shows stack from top to bottom
     *    No display if stack is empty
     */
    public void displayStack()
       {
        // initialize variables
        int index, spaceIndex = 0, defaultSpace = 13;
        
        // print each item
        for( index = 0; index < stackSize; index++, spaceIndex++ )
           {
            if( !isEmpty() )
               {
                // if its the first item, print stack top
                if( index == 0 )
                   {
                    System.out.print( "Stack Top: " );
                   }
                
                // if its at the last item print stack rear
                else if( index == stackSize - 1 && stackSize - 1 != 0 )
                   {
                    printChars​( defaultSpace, SPACE );
                    printChars​( spaceIndex, SPACE );
                    System.out.print( "Stack Rear: " );
                   }
                
                // otherwise, print correct amount of spaces
                else
                   {
                    printChars​( defaultSpace, SPACE );
                    printChars​( spaceIndex, SPACE );
                   }
                
                // print each stack item
                System.out.println( stackArray[ index ].toString() );
               }
           }
       }
      
      
    /* isEmpty
     * Description:
     *   Tests for size of stack equal to zero, no valid values stored in array
     * Returns:
     *   @return Boolean result of test for empty
     */
    public boolean isEmpty()
       {
        // test if empty or not
        if( stackSize == 0 )
           {
            return true;
           }
        return false;
       }
      
      
    /* peakTop
     * Description:
     *   returns value at top of stack without popping
     * Returns:
     *   @return GenericData front value if successful, null if not
     */
    @SuppressWarnings("unchecked")
   public GenericData peekTop()
       {
        // return the top if not empty
        if( !isEmpty() )
           {
            return ( GenericData )stackArray[ 0 ];
           }
        // return failure
        return null;
       }
      
      
    /* pop
     * Description:
     *   pops item from stack
     * Returns:
     *   @return GenericData popped value if successful, null if not
     */
    @SuppressWarnings("unchecked")
   public GenericData pop()
       {
        // initialize variables
        int index;
        Object returnVal;
        
        // if stack is not empty, pop item and return it
        if( !isEmpty() )
           {
            returnVal = stackArray[ 0 ];
            for( index = 0; index < stackSize - 1; index++ )
               {
                stackArray[ index ] = stackArray[ index + 1 ];
               }
            stackSize--;
            return ( GenericData )returnVal;
           }
        
        // return failure
        return null;
       }
      
      
    /* printChars
     * Description:
     *   Description: prints specified number of characters recursively
     * Parameters:
     *   @param numChars - integer value specifying number of characters
     *   @param outChar - character to be output
     */
    public void printChars​( int numChars, char outChar )
       {
        // print each char recursively
        if( numChars > 0 )
           {
            System.out.print( outChar );
            printChars​( numChars - 1, outChar );
           }
       }
      
      
    /* push
     * Description:
     *   pushes item onto array
     *   Checks for full stack and resizes as needed prior to data push
     * Parameters:
     *   @param newValue - GenericData value to be pushed onto stack
     */
    public void push​( GenericData newValue )
       {
        // initialize variables
        int index;
        
        // check for resize
        resize();
        
        // move every item down
        for( index = stackSize - 1; index >= 0; index-- )
           {
            stackArray[ index + 1 ] = stackArray[ index ];
           }
        
        // set first item to item to push
        stackArray[ 0 ] = newValue;
        
        // increment size
        stackSize++;
       }
      
      
    /* resize
     * Description:
     *   Resets array capacity to twice the current capacity
     */
    public void resize()
       {
        // initialize variables
        int index;
        Object[] tempArr = new Object[ stackCapacity * 2 ];
        
        // check if needs to be resized
        if( stackSize >= stackCapacity )
           {
            // double size of capacity
            stackCapacity *= 2;
            
            // make new array and copy over items
            for( index = 0; index < stackSize; index++ )
               {
                tempArr[ index ] = stackArray[ index ];
               }
            
            // reset stack array with greater capacity
            stackArray = new Object[ stackCapacity ];
            
            // move copy items to actual array
            for( index = 0; index < stackSize; index++ )
               {
                stackArray[ index ] = tempArr[ index ];
               }
           }
       }
      
      
   }
