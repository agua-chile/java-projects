package OpCode;

public class OpCodeHeapClass
   {
    // formula for finding where the index's children is in the array is:
    // index * 2 + 1 = left child
    // index * 2 + 2 = right child
      
    // initialize class variables
    public final int DEFAULT_ARRAY_CAPACITY = 10;
    private int arrayCapacity, arraySize;
    private boolean displayFlag;
    private OpCodeClass[] heapArray;
    
    /* default constructor
     * Description:
     *   Default constructor sets up array management conditions and default 
     *   display flag setting
     */
    public OpCodeHeapClass()
       {
        // initialize default class variables
        arrayCapacity = DEFAULT_ARRAY_CAPACITY;
        arraySize = 0;
        heapArray = new OpCodeClass[ arrayCapacity ];
        displayFlag = false;
       }

   // initialization constructor
   public OpCodeHeapClass( boolean setState )
      {
       // initialize default class variables
       arrayCapacity = DEFAULT_ARRAY_CAPACITY;
       arraySize = 0;
       heapArray = new OpCodeClass[ arrayCapacity ];
       displayFlag = setState;
      }
    
    /* copy constructor
     * Description:
     *   Copy constructor copies array and array management conditions and 
     *   default display flag setting
     * @param copied - OpCodeHeapClass object to be copied
     */
    public OpCodeHeapClass( OpCodeHeapClass copied )
       {
        // initialize variables
        int index;
        
        // initialize default class variables
        arrayCapacity = copied.arrayCapacity;
        arraySize = copied.arraySize;
        heapArray = new OpCodeClass[ arrayCapacity ];
        displayFlag = false;
        
        for( index = 0; index < arrayCapacity; index++ )
           {
            heapArray[ index ] = new OpCodeClass( copied.heapArray[ index ] );
           }
       }
    
    /* addItem
     * Description:
     *   Accepts OpCodeData item and adds it to heap
     * Note: 
     *   uses bubbleUpArrayHeap to resolve unbalanced heap after data 
     *   addition
     *   must check for resize before attempting to add an item
     * Paramaters:
     *   @param newItem - OpCodeClass data item to be added
     */
    public void addItem( OpCodeClass newItem )
       {
        // check for resize
        checkForResize();
        
        // display action
        if( displayFlag )
           {
            System.out.print( "\nAdding new process: " + newItem.toString() );
           }
        
        // add value to array
        heapArray[ arraySize ] = newItem;
        
        // increment size
        arraySize++;
        
        // fix unbalanced heap
        bubbleUpArrayHeap( arraySize - 1 );
       }
    
    /* bubbleUpArrayHeap
     * Description:
     *   Recursive operation to reset data in the correct order for the min heap 
     *   after new data addition
     * Parameters:
     *   @param currentIndex - index of current item being assessed, and moved 
     *                         up as needed
     */
    private void bubbleUpArrayHeap( int currentIndex )
       {
        // inititalize variables
        int parentIndex;
        OpCodeClass temp;
        
        // check for current index > 0
        if( currentIndex > 0 )
           {
            // calculate parent index
            parentIndex = ( currentIndex - 1 ) / 2;
          
            // check if current child's value is less than parent value
            if( heapArray[ currentIndex ].compareTo( heapArray[ parentIndex ] ) < 0 ) 
               {
                // display action
                if( displayFlag )
                   {
                    System.out.println( " - Bubble up:\n  - Swapping parent: " +
                                         heapArray[ parentIndex ].toString() + 
                                         " with child: " + 
                                         heapArray[ currentIndex ].toString() );
                   }
                
                // swap the parebt's and child's values
                temp = heapArray[ parentIndex ];
                heapArray[ parentIndex ] = heapArray[ currentIndex ];
                heapArray[ currentIndex ] = temp;
          
                // call the method recursivley with the parent's index
                bubbleUpArrayHeap( parentIndex );
               }
           }
       }
    
    /* checkForResize
     * Description:
     *   Automatic resize operation used prior to any new data addition in the 
     *   heap
     *   Tests for full heap array, and resizes to twice the current capacity as 
     *   required
     */
    private void checkForResize()
       {
        // initialize variables
        OpCodeClass[] temp = new OpCodeClass[ arrayCapacity ];
        int index;
        
        // copy over array
        for( index = 0; index < arraySize; index ++ )
           {
            temp[ index ] = new OpCodeClass( heapArray[ index ] );
           }
        
        // check if it needs to be resized
        if( arraySize == arrayCapacity - 1 )
           {
            // double capacity
            arrayCapacity *= 2;
            
            // re initialize array
            heapArray = new OpCodeClass[ arrayCapacity ];
            
            // copy over array
            for( index = 0; index < arraySize; index++ )
               {
                heapArray[ index ] = new OpCodeClass( temp[ index ] );
               }
           }
       }
    
    /* isEmpty
     * Description:
     *   Tests for empty heap
     * Returns:
     *   @return boolean result of test
     */
    public boolean isEmpty()
       {
        // return is empty result
        return arraySize == 0;
       }
    
    /* removeItem
     * Description:
     *   Removes OpCodeClass data item from top of min heap, thus being the 
     *   operation with the lowest priority value
     * Note: 
     *   Uses trickleDownArrayHeap to resolve unbalanced heap after data removal
     * Returns:
     *   @return OpCodeClass item removed
     */
    public OpCodeClass removeItem()
       {
        // initialize variables
        OpCodeClass removeVal;
        
        // display action
        if( displayFlag )
           {
            System.out.println( "\nRemoving process: " + 
                              heapArray[ 0 ].toString() );
           }
          
        // if not empty
        if( !isEmpty() )
           {
            // set remove val
            removeVal = heapArray[ 0 ];
            
            // set last val to first val
            heapArray[ 0 ] = heapArray[ arraySize - 1 ];
          
            // decrement size
            arraySize--;
          
            // trickle down to fix array
            trickleDownArrayHeap( 0 );
            
            // return val removed
            return removeVal;
           }
        // return not found
        return null;
       }
    
    /* setDisplayFlag
     * Description:
     *   Utility method to set the display flag for displaying internal 
     *   operations of the heap bubble and trickle operations
     * Parameters:
     *   @param setState - flag used to set the state to display, or not
     */
    public void setDisplayFlag( boolean setState )
       {
        // set display flag
        displayFlag = setState;
       }
    
    /* showArray
     * Description:
     *   Dumps array to screen as is, no filtering or management
     */
    public void showArray()
       {
        // initialize variables
        int index;
        
        // print array
        System.out.println();
        for( index = 0; index < arraySize; index++ )
           {
            System.out.print( heapArray[ index ].toString() + " " );
           }
         System.out.println();
       }
    
    /* trickleDownArrayHeap
     * Description:
     *   Recursive operation to reset data in the correct order for the min heap 
     *   after data removal
     * Parameters:
     *   @param currentIndex - index of current item being assessed, and moved 
     *                         down as required
     */
    private void trickleDownArrayHeap( int currentIndex )
       {
        // initialize variables
        int leftChildIndex, rightChildIndex, smallestIndex;
        OpCodeClass temp;
        
        // find the children's indices from the current one
        leftChildIndex = currentIndex * 2 + 1;
        rightChildIndex = currentIndex * 2 + 2;

        // check for both child indices less than the array size
        if( leftChildIndex < arraySize && rightChildIndex < arraySize )
           {
            // check for either of the children to be smaller than the parent
            if( heapArray[ leftChildIndex ].compareTo( heapArray[currentIndex]) 
                < 0 ||
                heapArray[ rightChildIndex ].compareTo( heapArray[currentIndex]) 
                < 0 )
              {
               // swap the parent with the smallest of the two children
               if( heapArray[ leftChildIndex ]
                   .compareTo( heapArray[ rightChildIndex ] ) < 0 )
                  {
                   smallestIndex = leftChildIndex;
                  }
               else
                  {
                   smallestIndex = rightChildIndex;
                  }
               temp = heapArray[ currentIndex ];
               heapArray[ currentIndex ] = heapArray[ smallestIndex ];
               heapArray[ smallestIndex ] = temp;
              
               
               // display action
               if( displayFlag )
                  {
                   System.out.println( " - Trickle down:\n  - Swapping Parent " 
                                       + heapArray[ currentIndex ].toString() + 
                                     " with child: " +
                                     heapArray[ smallestIndex ].toString() );
                  }

               // call the method recursively with that child's index
               trickleDownArrayHeap( smallestIndex );
              }
           }
        // check for only the left child index less than the array size
        if( leftChildIndex < arraySize && rightChildIndex == arraySize )
           {
            // check for the left child to be smaller than the parent
            if( heapArray[ leftChildIndex ]
                .compareTo( heapArray[ currentIndex ] ) < 0 )
               {
                // swap the left child's value with the parent's value
                temp = heapArray[ currentIndex ];
                heapArray[ currentIndex ] = heapArray[ leftChildIndex ];
                heapArray[ leftChildIndex ] = temp;
                
                // display action
                if( displayFlag )
                   {
                    System.out.println( " - Trickle down:\n  - Swapping Parent " +
                                      heapArray[ currentIndex ].toString() + 
                                      " with child: " +
                                      heapArray[ leftChildIndex ].toString() );
                   }
                
                // call the method recursively with the left child's index
                trickleDownArrayHeap( leftChildIndex );
               }
           }
       }
   }
