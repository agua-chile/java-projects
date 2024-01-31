package Registrar;

public class RegistrarClass
   {
    // initialize class variables

    private final int DEFAULT_CAPACITY = 10;
      
    private final int NOT_FOUND = -1;
      
    private StudentClass[] studentArr;
      
    private int capacity, size;
    
    
    // default constructor
    public RegistrarClass()
    {
     // set size to 0
     size = 0;
     
     // set capacity
     capacity = DEFAULT_CAPACITY;
     
     // initialize student array
     studentArr = new StudentClass[ capacity ];
    }
    
    
    /* initialization constructor
     * Parameters: 
     *   initialCapacity - integer value to set class initial capacity
     */
    public RegistrarClass( int initialCapacity )
    {
     // set size to 0
     size = 0;
     
     // set capacity
     capacity = initialCapacity;
     
     // initialize student array
     studentArr = new StudentClass[ capacity ];
    }
    
    
    /* copy constructor 
     * Parameters:
     *   copied - RegistrarClass object to be copied
     */
    public RegistrarClass( RegistrarClass copied )
    {
     // initialize variables
     int index; 
     
     // initialize copied variables
     capacity = copied.capacity;
     size = copied.size;
     
     // initialize student array
     studentArr = new StudentClass[ capacity ];
     
     // set values from student array input to the copied one
     for( index = 0; index < size; index++ )
        {
         // set copied array values to values from array to be copied
         studentArr[ index ] = copied.studentArr[ index ];
        }
    }
    
    
    /* addStudent( class )
     * Description:
     *   Adds a StudentClass item to list
     * Parameters:
     *   newStudent - StudentClass object to be added to array
     * Returns:
     *   Boolean result of item addition to array    
     * Note:
     *   Overloaded method
     */
    public boolean addStudent( StudentClass newStudent )
    {
     // test if it will be successful
     if( size < capacity )
        {
         // add student
         studentArr[ size ] = newStudent;
         
         // increment size
         size++;
     
         // return success
         return true;
        }
     // end test
     
     // return failure
     return false;
    }
    
    /* addStudent( data ) 
     * Description:
     *   Creates a StudentClass item, then adds to list using other method
     * Parameters:
     *   stdName - String name of student
     *   stdID - integer student ID of student
     *   stdGender - character gender of student
     *   stdGPA - double GPA of student
     * Returns:
     *   Boolean result of adding student
     * Note:
     *   Uses anonymous StudentClass instantiation in call to other method; 
     *   one line of code
     *   Overloaded method
     */
    public boolean addStudent( String stdName, int stdID,
                               char stdGender, double stdGPA )
    {
     // initialize new student class 
     StudentClass newStudent = new StudentClass( stdName, stdID, stdGender, 
                                                 stdGPA );
       
     // test if it will be successful
     if( size < capacity )
        {
         // add student
         studentArr[ size ] = newStudent;
         
         // increment size
         size++;
     
         // return success
         return true;
        }
     // end test
     
     // return failure
     return false;
    }

    
    /* copyArrayData 
     * Description:
     *   Copies student list from one array to other
     * Note:
     *   Must create new StudentClass object to assign to each element to 
     *   destination array to eliminate aliasing
     * Paremeters:
     *   dest - StudentClass array to which data is copied
     *   source - StudentClass array from which data is copied
     * Returns:
       * none
     */
    public void copyArrayData( StudentClass[] dest, StudentClass[] source )
    {
     // intialize variables
     int index;
     
     // loop across source array
     for( index = 0; index < size; index++ )
        {
         // dest array @ index = new student class  
         dest[ index ] = source [ index ];
        }
     // end loop
    }
    
    /* diagnosticArrayDump
     * Description:
     *   Optional method, local array dump for diagnostics
     */
    public void diagnosticArrayDump()
    {
     // initialize variables
     int index;
     
     // loop across array
     for( index = 0; index < size; index++ )
        {
         // print each item
         System.out.println( studentArr[ index ].toString() );
        }
    }
    
    
    /* findStudent 
     * Description:
     *   Finds student in array, returns data
     * Note:
     *   Uses findStudentIndex
     * Parameters:
     *   student - StudentClass object to be found
     * Returns:
     *   StudentClass object found, or null if not found
     */
    public StudentClass findStudent( StudentClass student )
    {
     // initialize variables
     int index;
       
     // loop across student array
     for( index = 0; index < size; index++ )
        {
         // test if each value of the student array @ index value is the same
            // use compareTo in StudentClass
         if( studentArr[ index ].compareTo( student ) == 0 )
            {
             // return success - found student class object
             return student;
            }
         // end test
        }
     // end loop
       
     // return failure
     return null;
    }
    
    
    /* findStudentIndex 
     * Description:
     *   Finds student's index in array, returns index, or returns 
     *   NOT_FOUND if item is not in the array
     * Note:
     *   Must use appropriate comparison method for class
     * Parameters:
     *   student - StudentClass object to be found
     * Returns:
     *   index of StudentClass object, or NOT_FOUND
     */
    public int findStudentIndex( StudentClass student )
    {
     // initialize variables
     int index;
       
     // loop across student array
     for( index = 0; index < size; index++ )
        {
         // test if each value of the student array @ index value is the same
            // use comparteTo in StudentClass
         if( studentArr[ index ].compareTo( student ) == 0 )
            {
             // return success - student index
             return index;
            }
         // end test
        }
     // end loop
     
     // return failure
     return NOT_FOUND;
    }
    
    
    /* removeStudent 
     * Description:
     *   Removes student from array, shifts elements down to keep array 
     *   contiguous
     * Note:
     *   Uses findStudentIndex
     * Parameters:
     *   student - StudentClass object to be removed
     * Returns:
     *   StudentClass object that was removed, or null if not found
     */
    public StudentClass removeStudent( StudentClass student )
    {
     // initialize variables
     int index;
     
     // initialize return student class object
     StudentClass returnVal = null;
       
     // loop across student array
     for( index = 0; index < size && returnVal == null; index++ )
        {
         // test if each value of the student array @ index value is the same
            // use CompareTo in StudentClass
         if( studentArr[ index ].compareTo( student ) == 0 )
            {
             // set return val to val
             returnVal = studentArr[ index ];
            }
         // end test
        }
     // end loop
     
     // loop across the rest of the array
     for( index = 0; index < size; index++ )
        {
         // if val is not the last val
         if( studentArr[ index + 1 ] != null )
            {
             // set the val to the next val
             studentArr[ index ] = studentArr[ index + 1 ];
            }         
         // end test       
        }
     // end loop
     
     // set last item to null
     studentArr[ index - 1 ] = null; 
     
     // decrement size
     size--;
         
     // return return val
     return returnVal;
    }
    
    
    /* runBubbleSort 
     * Description:
     *   Sorts elements using the bubble sort algorithm
     * Note:
     *   Creates new StudentClass array, sorts contents of array, and returns 
     *   the sorted result; does not modify (this) object student array
     * Parameters:
     *   none
     * Returns:
     *   new StudentClass array with sorted items
     */
    public StudentClass[] runBubbleSort()
    {
     // initialize variables
     boolean swapped = true;
     int index;
       
     // initialize new student class array
     StudentClass[] bubbleSortArray = new StudentClass[ capacity ];
     
     // copy student array to bubble sort array
     copyArrayData( bubbleSortArray, studentArr );
       
     // loop until no more swaps
     while( swapped )
        {
         // set swapped to false
         swapped = false;
         
         // loop until next to last item
         for( index = 0; index < size - 1; index++ )
            {
             // check if items need to be swapped
             if( bubbleSortArray[ index ].compareTo( bubbleSortArray[ 
                                                             index + 1 ] ) > 0 )
                {
                 // swap values
                 swapValues( bubbleSortArray, index, index + 1 );
                 
                 // set swapped to true
                 swapped = true;
                }
             // end test
            }
         // end inner loop
        }
     // end outter loop
     
     // return new array
     return bubbleSortArray;
    }
    
    
    /* runInsertionSort 
     * Description:
     *   Sorts character elements using the insertion sort algorithm
     * Note:
     *   Creates new StudentClass array, sorts contents of array, and returns 
     *   the sorted result; does not modify (this) object student array
     * Parameters:
     *   none
     * Returns:
     *   new StudentClass array with sorted items
     */
    public StudentClass[] runInsertionSort() // not done
    {
     // initialize variables
     int searchIndex, listIndex;
     
     // initialize temp val
     StudentClass tempVal;
       
     // initialize new student class
     StudentClass[] insertionSortArray = new StudentClass[ capacity ];
     
     // copy student array to bubble sort array
     copyArrayData( insertionSortArray, studentArr );
       
     // loop across entire array starting at element 2
     for( listIndex = 1; listIndex < size; listIndex++ )
        {
         // set search index to list index
         searchIndex = listIndex;  
           
         // set temp val to array @ index
         tempVal = insertionSortArray[ listIndex ];
       
         // loop while not at bottom and while temp val needs to be swapped with
         // item below  
         while( searchIndex > 0 && 
                tempVal.compareTo( insertionSortArray[ searchIndex - 1 ] ) < 0 )
            {
             // set array @ index to array @ index - 1
             insertionSortArray[ searchIndex ] = 
             insertionSortArray[ searchIndex - 1 ];
       
             // decrement search index
             searchIndex--;
            }
         // end inner loop
       
         // set array @ search index to temp val
         insertionSortArray[ searchIndex ] = tempVal;
        }
     // end outer loop
       
     // return new array
     return insertionSortArray;
    }
    
    
    /* runSelectionSort
     * Description:
     *   Sorts character elements using the selection sort algorithm
     * Note:
     *   Creates new StudentClass array, sorts contents of array, and returns 
     *     the sorted result; does not modify (this) object student array
     * Parameters:
     *   none
     * Returns:
     *   new StudentClass array with sorted items
     */
    public StudentClass[] runSelectionSort()
       {
        // initialize variables
        int listIndex, lowestIndex, currentSearchIndex;
        
        // initialize new student array class
        StudentClass[] selectionSortArray = new StudentClass[ capacity ];
        
        // copy student array to bubble sort array
        copyArrayData( selectionSortArray, studentArr );
        
        // loop across list
        for( listIndex = 0; listIndex < size - 1; listIndex++ )
           {
            // set initial lowestIndex at first element to be searched
            lowestIndex = listIndex;
            
            // loop across list from current element to end
            for( currentSearchIndex = listIndex + 1; currentSearchIndex < size; 
                 currentSearchIndex++ )
               {
                // check for current element needing to be swapped with lowest 
                if( selectionSortArray[ currentSearchIndex ].compareTo( 
                                   selectionSortArray[ lowestIndex ] ) < 0 ) 
                   {
                    // set lowest index to current index
                    lowestIndex = currentSearchIndex;
                   }
                // end test
               }
            // end inner loop
            
            // swap 
            swapValues( selectionSortArray, lowestIndex, listIndex );
           }
        // end outer loop
        
        // return new array
        return selectionSortArray;
       }
    
    
    /* runShellSort
     * Description:
     *   Uses Shell's sorting algorithm to sort an array of integers
     *   Shell's sorting algorithm is an optimized insertion algorithm
     * Note: 
     *   Creates new StudentClass array, sorts contents of array, and returns 
     *   the sorted result; does not modify (this) object student array
     * Returns:
     *   new StudentClass array with sorted items
     */
    public StudentClass[] runShellSort() // what are we supposed to do with this?
    {
     // initialize variables
     int gap, gapPassIndex, insertionIndex;
     StudentClass tempItem;
     
     // initialize new array
     StudentClass[] stdArr = new StudentClass[ capacity ];
     
     // copy data from class aray to method
     copyArrayData( stdArr, studentArr );

     for( gap = size / 2; gap > 0; gap /= 2 )
        {
         for( gapPassIndex = gap; gapPassIndex < size; gapPassIndex++ )
            {
             tempItem = stdArr[ gapPassIndex ];

             insertionIndex = gapPassIndex;

             while( insertionIndex >= gap 
             && stdArr[ insertionIndex - gap].compareTo( tempItem ) > 0 ) 
                {
                 stdArr[ insertionIndex ] 
                                        = stdArr[ insertionIndex - gap ];
                
                 insertionIndex -= gap;
                }  // end search loop

             stdArr[ insertionIndex ] = tempItem;
            }  // end list loop
        
        }  // end gap size setting loop   
    
     // return new array
     return stdArr;
    }
    
    
    /* swapValues
     * Description:
     *   Swaps values within given array
     * Parameters:
     *   stdArray - StudentClass array used for swapping
     *   indexOne - integer index for one of the two items to be swapped
     *   indexOther - integer index for the other of the two items to be swapped
     * Returns:
     *   none
     */
    public void swapValues( StudentClass[] stdArray, int indexOne, 
                            int indexOther )
    {
     // initialize new student class val
     StudentClass temp;
       
     // set student array @ index one to temp val
     temp = stdArray[ indexOne ];
       
     // set student array @ index one to index other
     stdArray[ indexOne ] = stdArray[ indexOther ];
       
     // set student array @ index other to temp
     stdArray[ indexOther ] = temp;
    }
   }
