package LogN_Sort;

// Basic class that supports Log2N sorting operations
public class LogN_SortDriverClass
   {
    /* - Default constructor:
     * Description:
     *   Default constructor, takes no action for this static tool class
     */
    public LogN_SortDriverClass()
    { 
    }
    
    
    /* - compareStrings:
     * Description:
     *   Compares two strings character by character set to lower case to see 
     *   which is alphabetically greater than the other; if all tested letters 
     *   if a name are equal, then compares string lengths
     *   Results are as follows:
     *     Alphabetically, if strOne is greater than strTwo, returns value 
     *     greater than zero (e.g., Susan is greater than Bill);
     *     if strOne is less than strTwo, returns value less than zero 
     *     (e.g., Roger is less than Zelda);
     *     if strOne is equal to strTwo alphabetically but is different length, 
     *     returns difference in length (e.g., Will is less than William)
     *     if strOne is equal to strTwo both alphabetically and in length, 
     *     returns zero (e.g., Susan is equal to Susan)
     * Note:
     *   .length utility method may used in this method
     * Parameters:
     *   strOne - first String value to be compared
     *   strTwo - second String value to be compared
     * Returns:
     *   integer difference as specified
     */
    public static int compareStrings​( String strOne, String strTwo )
    {
     // initialize variables
     int sizeOne = strOne.length(), sizeTwo = strTwo.length(), difference, 
         index = 0;
    
     // loop whike index is less then size 1 & 2
     for( index = 0; index < sizeOne && index < sizeTwo; index++ )
        {
         // set the difference
         difference = strOne.charAt( index )  - strTwo.charAt( index );
       
         // if difference is not 0
         if( difference != 0 )
            {
             // return difference
             return difference;
            }
        }
     // return result
     return sizeOne - sizeTwo;
    }
    
    
    /* - runMerge:
     * Description:
     *   Merges String values brought in between a low and high index segment 
     *   (inclusive) of an array
     * Note: 
     *   uses locally sized single array for temporary storage
     * Parameters:
     *   localArray - String array holding unsorted values
     *   lowIndex - lowest index of array segment to be managed
     *   middleIndex - middle index of array segment to be managed
     *   highIndex - high index of array segment to be managed
     * Returns:
     *   void
     */
   private static void runMerge​( String[] localArray, int lowIndex, 
                                  int middleIndex, int highIndex )
    {
     // initialize variables
     int index, leftIndex, rightIndex, sourceIndex = 0, 
         capacity = highIndex - lowIndex + 1;
       
     // find capacity using index parameters and creates array 
     String[] mergeArray = new String[ capacity ];
     
     // load data from source array into newly created array
     for( index = 0, sourceIndex = lowIndex; sourceIndex <= highIndex; index++, 
          sourceIndex++ )
        {
         mergeArray[ index ] = localArray[ sourceIndex ];
        }
     
     // calculate indices necessary to start and end at the left and right side
     leftIndex = lowIndex;
     rightIndex = middleIndex + 1;
     
     
     // loop until left or right side is out of values
     while( leftIndex <= middleIndex && rightIndex <= highIndex )
        {
         // check if first available val in left is < first available val in 
         // right
         if( compareStrings​( mergeArray[ leftIndex ], mergeArray[ rightIndex ] ) 
                            < 0 )
            {
             // set first val left to source array first available element
             localArray[ index ] = mergeArray[ leftIndex ];
     
             // increment indices
             leftIndex++;
            }
         // else assume right group first available val is less
         else
            {
             // set first available right val to source array first element
             localArray[ index ] = mergeArray[ rightIndex ];
     
             // increment indices
             rightIndex++;
            }
     
         // increment index for source array
         index++;
        }
     // end comparison loop
     
     // loop until left side is out of vals
     while( leftIndex <= middleIndex )
        {
         // set first val left to source array first available element
         localArray[ index ] = mergeArray[ leftIndex ];
     
         // increment left index
         leftIndex++;
     
         // increment array index
         index++;
        }
     // end left side loop
     
     // loop until right side is out of vals
     while( rightIndex <= highIndex )
        {
         // set first val right to source array first available element
         localArray[ index ] = mergeArray[ rightIndex ];
 
         // increment right index
         rightIndex++;
 
         // increment array index
         index++;
        }
     // end right side loop
    }
    
    
    /* - runMergeSort:
     * Description:
     *   String data sorted using merge sort algorithm
     * Note:
     *   Calls runMergeSortHelper with lower and upper indices of array to be 
     *   sorted
     * Parameters:
     *   localArray - String array holding unsorted values
     *   size - integer value holding number of values in array
     * Returns:
     *   void
     */
    public static void runMergeSort​( String[] localArray, int size )
    {
     // run the helper to merge sort array
     runMergeSortHelper​( localArray, 0, size - 1 );
    }
    
    
    /* - runMergeSortHelper:
     * Description:
     *   Merge sort helper, recursively breaks given array segment down to 
     *   smaller segments between lowIndex and highIndex (inclusive), then sorts 
     *   data using merge sort method
     * Parameters:
     *   localArray - String array holding unsorted values
     *   lowIndex - lowest index of array segment to be managed; this varies as 
     *              the segments are broken down recursively
     *   highIndex - highest index of array segment to be managed; this varies 
     *               as the segments are broken down recursively
     * Returns:
     *   void
     */
    private static void runMergeSortHelper​( String[] localArray, int lowIndex,
                                            int highIndex )
    {
     // initialize variables
     int midPoint;
     
     // make sure lower index < upper index
     if( lowIndex < highIndex )
        {
         // find the mid point
         midPoint = ( lowIndex + highIndex ) / 2;

         // call merge sort helper process for the left side
         runMergeSortHelper​( localArray, lowIndex, midPoint );

         // call merge support for right side
         runMergeSortHelper​( localArray, midPoint + 1, highIndex );

         // merge left and right sides
         runMerge​( localArray, lowIndex, midPoint, highIndex );
        }
    }
    
    
    /* - runPartition:
     * Description:
     *   Partitions array using the first value as the partition; when this 
     *   method is complete the partition value is in the correct location in 
     *   the array
     * Parameters:
     *   localArray - String array holding unsorted values
     *   lowIndex - low index of array segment to be partitioned
     *   highIndex - high index of array segment to be partitioned
     * Returns:
     *   integer index of partition pivot
     */
    private static int runPartition​( String[] localArray, int lowIndex,
                                     int highIndex )
    {
     // intialize variables
     int pivotIndex, workingIndex;
     
     // set pivot index to low index
     workingIndex = lowIndex;
     pivotIndex = lowIndex;
     
     // loop across array from low to high index using working index
     for( workingIndex = lowIndex; workingIndex < highIndex; workingIndex++ )
        {
         // check if val at current working index < pivot val
         if( compareStrings​( localArray[ workingIndex ], 
             localArray[ pivotIndex ] ) < 0 )
            {    
             // increment pivot index
             pivotIndex++;
     
             // swap val at working index with pivot index
             swapValues( localArray, workingIndex, pivotIndex );
            }
        }
     // end working loop
     
     // swap original pivot val at low index with val at current pivot index
     swapValues( localArray, lowIndex, pivotIndex );
     
     // return pivot index
     return pivotIndex;
    }
    
    
    /* - runQuickSort:
     * Description:
     *   Data sorted using quick sort algorithm
     * Note: 
     *   Call runQuickSortHelper with lower and upper indices of array to be 
     *   sorted
     * Parameters:
     *   localArray - String array holding unsorted values
     *   size - integer value holding the number of values in the array
     * Returns:
     *   void
     */
    public static void runQuickSort​( String[] localArray, int size )
    {
     // call helper to quick sort array
     runQuickSortHelper​( localArray, 0, size - 1 );
    }
    
    
    /* - runQuickSortHelper:
     * Description:
     *   Helper method run with parameters that support recursive access
     * Parameters:
     *   localArray - String array holding unsorted values
     *   lowIndex - low index of the segment of the array to be processed
     *   highIndex - high index of the segment of the array to be processed
     * Returns:
     *   void
     */
    private static void runQuickSortHelper​( String[] localArray, int lowIndex, 
                                            int highIndex )
    {
     // initialize variable
     int partitionIndex;
     
     // make sure lower index < upper index
     if( lowIndex < highIndex )
        {
         // call partition to set pivot value & get index
         partitionIndex = runPartition​( localArray, lowIndex, highIndex );
   
         // call quicksort helper for left side of pivot
         runQuickSortHelper​( localArray, lowIndex, partitionIndex );
   
         // call quicksort helper for right side of pivot
         runQuickSortHelper​( localArray, partitionIndex + 1, highIndex );
        }
    } 
    
    
    /*  - swapValues:
     * Description:
     *   Swaps values within given array
     * Parameters:
     *   localArray - array of Strings used for swapping
     *   indexOne - integer index for one of the two items to be swapped
     *   indexOther - integer index for the other of the two items to be swapped
     * Returns:
     *   void
     */
    public static void swapValues( String[] stdArray, int indexOne, int indexOther )
    {
     // initialize new student class val
     String temp;
       
     // set student array @ index one to temp val
     temp = stdArray[ indexOne ];
       
     // set student array @ index one to index other
     stdArray[ indexOne ] = stdArray[ indexOther ];
       
     // set student array @ index other to temp
     stdArray[ indexOther ] = temp;
    }
    
    
    /* - toLowerCase:
     * Description:
     *   If character is upper case letter (i.e., 'A' - 'Z'), changes letter to 
     *   lower case (i.e., 'a' - 'z'); otherwise, returns character unchanged
     * Parameters:
     *   testChar - character value to be tested and possibly modified
     * Returns:
     *   character value modified as specified
     */
    @SuppressWarnings("unused") // temp to get rid of warning
    private static char toLowerCase​(char testChar)
    {
     // test if val is uppercase
     if( testChar >= 'A' && testChar <= 'Z' )
        {
         // return it lowercase
         return ( char )( testChar - 'A' + 'a' );
        }
     // otherwise return characyer unchanged
     return testChar;
    }
    
    
   }
