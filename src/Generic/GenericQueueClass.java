package Generic;

public class GenericQueueClass<GenericData extends 
                               java.lang.Comparable<GenericData>>

   {
    private static int DEFAULT_CAPACITY = 10;
    
    private final static char SPACE = ' ';
    
    private Object[] queueArray;
    private int queueCapacity, queueSize, rearIndex, frontIndex;
    
    /* default constructor
     * Definition:
     *   Default constructor, initializes queue to default capacity (10)
     */
    public GenericQueueClass()
       {
        // initialize default capacity, array, size and rear index
        queueCapacity = DEFAULT_CAPACITY;
        queueArray = new Object[ queueCapacity ];
        queueSize = 0;
        frontIndex = 0;
        rearIndex = -1;
       }
      
      
    /* initialization constructor
     * Definition:
     *   Initializing constructor, initializes queue to specified capacity
     * Parameters:
     *   @param capacity - maximum capacity specification for the queue
     */
    public GenericQueueClass( int capacity )
       {
        // initialize capacity, rear index, size and array
        queueCapacity = capacity;
        queueArray = new Object[ queueCapacity ];
        queueSize = 0;
        frontIndex = 0;
        rearIndex = -1;
       }
    
    
    /* clear
     * Description:
     *   Clears queue of all valid values by setting array size to zero, values 
     *   remain in array but are not accessible
     */
    public void clear()
       {
        // set queue size to 0 and rear index to -1
        queueSize = 0;
        frontIndex = 0;
        rearIndex = 0;
       }
    
    
    /* dequeue
     * Description:
     *   dequeues item from queue
     * Returns:
     *   @return dequeued value if successful, null if not
     */
    @SuppressWarnings("unchecked")
   public GenericData dequeue()
       {
        // initialize variables
        int index;
        GenericData returnVal;
        
        // if not empty, decrement size and rear index and return deleted val
        if( !isEmpty() )
           {
            // sets dequeue item to be returned
            returnVal = (GenericData)queueArray[ frontIndex ];
            
            // loop across array, moving each item up
            for( index = frontIndex; index < queueSize; index++ )
               {
                queueArray[ index ] = queueArray[ index + 1 ];
               }
            rearIndex--;
            queueSize--; 
            return returnVal;
           }
        // return failure
        return null;
       }
    
    
    /* dequeue
     * Description:
     *   dequeues item from queue
     * Returns:
     *   @return dequeued value if successful, null if not
     */
    public void displayQueue()
       {
        // initialize variables
        int index, spaceIndex = 0, defaultSpace = 13;
        
        // print each item
        for( index = frontIndex; index < queueSize; index++, spaceIndex++ )
           {
            if( !isEmpty() )
               {
                // if its the first item, print queue top
                if( index == 0 )
                   {
                    System.out.print( "Queue Top: " );
                   }
                
                // if its at the last item print queue rear
                else if( index == rearIndex && rearIndex != frontIndex )
                   {
                    printChars​( defaultSpace, SPACE );
                    printChars​( spaceIndex, SPACE );
                    System.out.print( "Queue Rear: " );
                   }
                
                // otherwise, print correct amount of spaces
                else
                   {
                    printChars​( defaultSpace, SPACE );
                    printChars​( spaceIndex, SPACE );
                   }
                
                // print each queue item
                System.out.println( queueArray[ index ].toString() );
               }
           }
       }
    
    
    /* enqueue
     * Description:
     *   Enqueues item into array
     *   Checks for full queue and resizes as needed prior to data enqueue
     * Parameters:
     *   @param newValue - GenericData value to be inserted into queue
     */
    public void enqueue​( GenericData newValue )
       {
        // check for resize
        resize();
        
        // increment size and rear index
        queueSize++;
        rearIndex++;
          
        // add item
        queueArray[ rearIndex ] = newValue;
       }
      
      
    /* isEmpty
     * Description:
     *   Tests for size of queue equal to zero, no valid values stored in array
     * Returns:
     *   @return Boolean result of test for empty
     */
    public boolean isEmpty()
       {
        // if size is 0 return is empty
        if( queueSize == 0 )
           {
            return true;
           }
        
        // return not empty
        return false;
       }
      
      
    /* peekFront
     * Description:
     *   returns value at front of queue without dequeuing
     * Returns:
     *   @return GenericData front value if successful, null if not
     */
    @SuppressWarnings("unchecked")
   public GenericData peekFront()
       {
        // if not empty, return first item
        if( !isEmpty() )
           {
            return (GenericData)queueArray[ frontIndex ];
           }
        // return failure
        return null;
       }
      
      
    /* printChars
     * Description:
     *   prints specified number of characters recursively
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
      
      
    /* resize
     * Description:
     *   Resets array capacity to twice the current capacity
     */
    public void resize() // actually copy over array
       {
        // initialize variables
        int index;
        Object[] tempArr = new Object[ queueCapacity * 2 ];
        
        // check if needs to be resized
        if( queueSize >= queueCapacity )
           {
            // double size of capacity
            queueCapacity *= 2;
            
            // make new array and copy over items
            for( index = 0; index < queueSize; index++ )
               {
                tempArr[ index ] = queueArray[ index ];
               }
            
            // reset queue array with greater capacity
            queueArray = new Object[ queueCapacity ];
            
            // move copy items to actual array
            for( index = 0; index < queueSize; index++ )
               {
                queueArray[ index ] = tempArr[ index ];
               }
           }
       }     
   }
