package Misc;

public class practice_problems
   {
    // declare final variables
    private static final int VALUE_NOT_FOUND = 7777; 
    private static final int PRECISION = 1;
    
    // testing for if test problems work
    public static void main(String[] args)
    {
//     int[][] anArray;
//     int index = 0, answerIndex, rowIndex, colIndex;
//     anArray = new int[10][10];
//     for( rowIndex = 0; rowIndex < 10; rowIndex++ )
//        {
//         for( colIndex = 0; colIndex < 10; colIndex++ )
//            {
//             anArray[ rowIndex ][ colIndex ] = index;
//             index++;
//            }
//        }
//     
//     for( int i = 0; i < 10; i++ )
//        {
//           for( int ii = 0; ii < 10; ii++ )
//              {
//                 System.out.print( anArray[ i ][ ii ] );
//                 System.out.print( ' ' );
//              }
//           System.out.print( '\n' );
//        }
//     System.out.print( '\n' );
//     transposeArray_whileLoop(anArray, 10);
//       
//     for( int i = 0; i < 10; i++ )
//        {
//           for( int ii = 0; ii < 10; ii++ )
//              {
//                 System.out.print( anArray[ i ][ ii ] );
//                 System.out.print( ' ' );
//              }
//           System.out.print( '\n' );
//        }
//     
//     for( int i = 0; i < 50; i++ )
//        {
//         int[] arr = listOdds_WhileLoops( anArray, 10, 10 );
//         System.out.print( arr[i]);
//         System.out.print( ' ' );
//        }
//       
//       String str = "abcdefg";
//       char[] charArray = str.toCharArray();
//       reverseChars_alternate( charArray, charArray.length );
//       
//       for( int i = 0; i < 7; i++ )
//          {
//             System.out.print( charArray[ i ]);
//             System.out.print( ' ' );
//          }
       System.out.print( translateToDecimal( 20, 5 ));
    }
    
    
    // 1
    // findValueIndexForward
    // sees whether or not a specified value is in a specified array by search 
       // from front to back and returns the index of the item if its found, 
       // and if not it returns the VALUE_NOT_FOUND int
    public static int findValueIndexForward( int [] array, int size, 
                                             int searchValue )
    {
     // declare variables as needed
     int index;
       
     // loop across array, forward
     for( index = 0; index < size; index++ )
        {
         // test for value in specified element
         if( array[ index ] == searchValue )
             // return index of found value
            {
             return index;
            }
         // end test 
        }
     // end loop
     
     // return VALUE_NOT_FOUND
     return VALUE_NOT_FOUND;
    }
    
    
    // 2
    // findValueIndexBackward
    // sees whether or not a specified value is in a specified array by search 
       // from back to front and returns the index of the item if its found, 
       // and if not it returns the VALUE_NOT_FOUND int    
    public static int findValueIndexBackward( int [] array, int size, 
                                             int searchValue )
    {
     // declare variables as needed
     int index;

     // loop across array, backward
     for( index = size - 1; index >=0; index-- )  
        {
         // test for value in specified element
         if( array [ index ] == searchValue )
            {
             // return index of found value
             return index;
            }
         // end test
         } 
      // end loop

     // return VALUE_NOT_FOUND
     return VALUE_NOT_FOUND;
   } 
    
    
    // 3
    // isEven
    // takes in a value and returns whether or not it is even 
    public static boolean isEven( int value )
    {
     // test for if value is even, return result
     return value % 2 == 0;
    }
    
    
    // 3a
    // isOdd
    // takes in a value and returns whether or not it is odd 
    public static boolean isOdd( int value )
    {
     // test for if value is odd, return result
     return !isEven( value );
    }
    
    
    // 4
    // listEvens_ForLoops
    // takes in a 2d array and returns a 1d array of all of the evens using
       // only for loops
    public static int [] listEvens_ForLoops( int [][] twoDArr, int numRows, 
                                             int numCols )
    {
     // declare, initialize variables as needed
     int rowIndex, colIndex, listIndex = 0, maxValues = numRows * numCols;
     int [] resultList = new int [ maxValues ];
       
     // loop across rows
     for( rowIndex = 0; rowIndex < numRows; rowIndex++ )
        {
         // loop across cols
         for( colIndex = 0; colIndex < numCols; colIndex++ )
            {
             // test for even value
             if( isEven( twoDArr[ rowIndex ][ colIndex ] ) )
                {
                 // assign 2d element to 1d array
                 resultList[ listIndex ] = twoDArr[ rowIndex ][ colIndex ];
                 // increment list index
                 listIndex++;
                }
             // end test
            }
         // end cols loop
        }
     // end rows loop
       
     // return the 1d array
     return resultList;
    }
    
    
    // 5
    // listEvens_WhileLoops
    // takes in a 2d array and returns a 1d array of all of the evens using
       // only while loops
    public static int [] listEvens_WhileLoops( int [][] twoDArr, int numRows, 
                                               int numCols )
    {
     // declare, initialize variables as needed
     int rowIndex = 0, colIndex, listIndex = 0, 
         maxValues = numRows * numCols;
     int [] resultList = new int [ maxValues ];
       
     // loop across rows
     while( rowIndex < numRows )
        {
         // initialize col index
         colIndex = 0;
         
         // loop across cols
         while( colIndex < numCols )
            {
             // test for even value
             if( isEven( twoDArr[ rowIndex ][ colIndex ] ) )
                {
                 // assign 2d elements to 1d array
                 resultList[ listIndex ] = twoDArr[ rowIndex ][ colIndex ];
                 
                 // increment the list index
                 listIndex++;     
             // end test
                }
             // increment collumn index
             colIndex++;
            }
         // end col loop
         
         // increment row index
         rowIndex++;
           }
     // end row loop
       
     // return 1d array
     return resultList;
    }
    
    
    // 6
    // listOdds
    // takes in a 2d array and returns a 1d array of all of the odds using
       // only for loops
    public static int [] listOdds_ForLoops( int [][] twoDArr, int numRows, 
                                            int numCols )
    {
       // declare, initialize variables as needed
       int rowIndex, colIndex, listIndex = 0, maxValues = numRows * numCols;
       int [] resultList = new int [ maxValues ];
         
       // loop across rows
       for( rowIndex = 0; rowIndex < numRows; rowIndex++ )
          {
           // loop across cols
           for( colIndex = 0; colIndex < numCols; colIndex++ )
              {
               // test for even value
               if( !isEven( twoDArr[ rowIndex ][ colIndex ] ) )
                  {
                   // assign 2d element to 1d array
                   resultList[ listIndex ] = twoDArr[ rowIndex ][ colIndex ];
                   // increment list index
                   listIndex++;
                  }
               // end test
              }
           // end cols loop
          }
       // end rows loop
         
       // return the 1d array
       return resultList;
    }
    
    
    // 7
    // listOdds_WhileLoops
    // takes in a 2d array and returns a 1d array of all of the evens using
       // only while loops
    public static int [] listOdds_WhileLoops( int [][] twoDArr, int numRows, 
                                               int numCols )
    {
     // declare, initialize variables as needed
     int rowIndex = 0, colIndex, listIndex = 0, 
         maxValues = numRows * numCols;
     int [] resultList = new int [ maxValues ];
       
     // loop across rows
     while( rowIndex < numRows )
        {
         // initialize col index
         colIndex = 0;
         
         // loop across cols
         while( colIndex < numCols )
            {
             // test for even value
             if( !isEven( twoDArr[ rowIndex ][ colIndex ] ) )
                {
                 // assign 2d elements to 1d array
                 resultList[ listIndex ] = twoDArr[ rowIndex ][ colIndex ];
                 
                 // increment the list index
                 listIndex++;     
             // end test
                }
             // increment collumn index
             colIndex++;
            }
         // end col loop
         
         // increment row index
         rowIndex++;
           }
     // end row loop
       
     // return 1d array
     return resultList;
    }
    
    
    // 8
    // reverseChar
    // takes in a 1d array of chars and reverses it
    public static void reverseChars( char [] array, int size )
    {
     // declare variables as needed
     int lowIndex = 0, highIndex = size - 1;
     char temp;
       
     // loop until all letters swapped
     while( lowIndex < highIndex )
        {
         // assign temp value to low index element
         temp = array[ lowIndex ];
       
         // assign low index element to high index element
         array[ lowIndex ] = array[ highIndex ];
       
         // assign high index element to temp value
         array[ highIndex ] = temp;
       
         // increment low index value
         lowIndex++;
       
         // decrement high index value
         highIndex--;
        }
     // end loop
    }
    
    
    // 8a
    // reverseChar
    // takes in a 1d array of chars and reverses it
    public static void reverseChars_alternate( char [] array, int size )
    {
     // declare variables as needed
     int index = 0;
     char temp;
       
     // loop until all letters swapped
     while( index < size / 2 )
        {
         // assign temp value to low index element
         temp = array[ index ];
       
         // assign low index element to high index element
         array[ index ] = array[ size - 1 - index ];
       
         // assign high index element to temp value
         array[ size - 1 - index ] = temp;
       
         // increment index
         index++;
        }
     // end loop
    }
    
    
    // 9
    // transposeArray_forLoop
    // takes in a 2d array and transposes it ( switches col and row numbers )
       // using only for loops
    public static void transposeArray_forLoop( int [][] twoDArr, 
                                               int sideLength )
    {
     // declare, initialize variables
     int rowIndex, colIndex, temp;
       
     // loop across array rows
     for( rowIndex = 0; rowIndex < sideLength; rowIndex++ )
        {
         // loop across array columns
         for( colIndex = rowIndex + 1; colIndex < sideLength; colIndex++ )
            {
             // assign temp value to current row element
             temp = twoDArr[ rowIndex ][ colIndex ];
       
             // assign row element to column element
             twoDArr[ rowIndex ][ colIndex ] = twoDArr[ colIndex ][rowIndex ];
       
             // assign column element to row element ( temp value )
             twoDArr[ colIndex ][ rowIndex ] = temp;
            }
         // end loop across columns
        }
     // end loop across rows
    }
    
    
    // 9a
    // transposeArray_whileLoop
    // takes in a 2d array and transposes it ( switches col and row numbers )
       // using only while loops
    public static void transposeArray_whileLoop( int [][] twoDArr, 
                                                 int sideLength ) 
    {
     // declare, initialize variables
     int rowIndex = 0, colIndex, temp;
       
     // loop across array rows
     while( rowIndex < sideLength )
        {
         // initialize col index
         colIndex = rowIndex + 1;
       
         // loop across array columns
         while( colIndex < sideLength )
            {
             // assign temp to current row element
             temp = twoDArr[ rowIndex ][ colIndex ];
       
             // assign row element to column element
             twoDArr[ rowIndex ][ colIndex] = twoDArr[ colIndex ][ rowIndex ];
       
             // assign column element to row element ( temp )
             twoDArr[ colIndex ][ rowIndex ] = temp;
       
             // increment col index
             colIndex++;
            }
         // end col loop
       
         // increment row index
         rowIndex++;
        }
     // end row loop
    }
    
    
    // 10
    // findQuotient
    // finds the quotient through repeated subtraction
    public static int findQuotient( int dividend, int divisor )
    {
     // declare, define variables
     int quotient = 0;
       
     // loop while dividend is greater than or equal to divisor
     while( dividend >= divisor )
        {
         // subtract divisor from dividend
         dividend -= divisor;
       
         // increment quotient
         quotient++;
        }
     // end loop
       
     // return quotient
     return quotient;
    }
    
    
    // 11
    // findRemainder
    // finds the remainder through repeated subtraction
    public static int findRemainder( int dividend, int divisor )
    {
     // declare, define variables
       
     // loop while dividend is greater than or equal to divisor
     while( dividend >= divisor )
        {
         // subtract divisor from dividend
         dividend -= divisor;

        }
     // end loop
       
     // return remainder ( left over of the dividend )
     return dividend;
    }
    
    
    // 12
    // findProduct
    // finds the product through repeated addition
    public static int findProduct( int multiplicand, int multiplier )
    {
     // declare, define variables
     int product = 0;
       
     // loop while multiplier is greater than 0
     while( multiplier > 0 )
        {
         // add multiplicand to product
         product += multiplicand;
       
         // decrement multiplier
         multiplier--;
        }
     // end loop
       
     // return product
     return product;
    }
    
    
    // 12a
    // findProduct
    // finds the product through repeated addition
    public static int findProduct_doubles( double multiplicand, 
                                           double multiplier )
    {
     // declare, define variables
     int product = 0;
       
     // loop while multiplier is greater than 0
     while( multiplier > 0 )
        {
         // add multiplicand to product
         product += multiplicand;
       
         // decrement multiplier
         multiplier--;
        }
     // end loop
       
     // return product
     return product;
    }
    
    
    // 13
    // findPower
    // takes in base and exponent and finds the power by repeated multiplication
       // using findProduct
    public static int findPower( int base, int exponent )
    {
     // declare, define variables
     int result = 1;
       
     // loop up to exponent
     while( exponent > 0 )
        {
         // multiply result by base
         result = findProduct( result, base );
       
         // decrement exponent
         exponent--;
        }
     // end loop
       
     // return result
     return result;
    }
    
    
    // 14
    // findSquareRoot
    // works its way up from 0 multiplying values until square root is found
    public static double findSquareRoot( int value )
    {
     // declare, define variables as needed
       
         // set lower value to zero, upper value to original value, middle value 
            // between the lower and upper values and initial temp value
         double lowerValue = 0, upperValue = value, 
                middleValue = ( lowerValue + upperValue ) / 2.0, 
                tempResult = middleValue * middleValue;
       
     // loop while absolute difference beyween test value and original value
        // is greater than the specified precision
     while( Math.abs( tempResult - value ) > PRECISION )
        {
         // test for the temporary result to be greater than the original value
         if( tempResult > value )
            {
             // set the upper va;ue tp the middle value
             upperValue = middleValue;
            }
         
         // otherwise, assume temp value is less than the original value
         else
            {
             // set the lower value to the middle value
             lowerValue = middleValue;
            }
         // end test
       
         // recalculate middle value
         middleValue = ( lowerValue + upperValue ) / 2.0;
       
         // recaculate the temporary result
         tempResult = middleValue * middleValue;
        }
     // end loop
       
     // return middle value
     return middleValue;
    }
    
    
// ___________________________Get Traigh's help_________________________________    
    
    
    // 15
    // findGCD
    // finds greatest common divisor by - not too sure about this one
    public static int findGCD( int oneValue, int otherValue )
    {
     // declare, define variables as needed
     int testGCD;
       
         // set test GCD to first value
         testGCD = oneValue;
       
     // test for second value less than the first
     if( oneValue < testGCD )
        {
         // set test GCD to second value
         testGCD = otherValue;
        }
     // end test
       
     // loop while one or both values do not divide by the test GCD
     while( oneValue % testGCD != 0 || otherValue % testGCD != 0 )
        {
         // decrement the test GCD
         testGCD--;
        }
     // end loop
       
     // return test GCD
     return testGCD;
    } 
    
    // 16
    // translateBases
    // - not sure how this one works
    public static long translateBases( int baseTenNum, int newBase )
    {
     // declare, define variables as needed
       
         // set multiplier to 1 and new/output value to 0
         long multiplier = 1, newVal = 0;
       
         // declare other variables
         int tempDigit;
       
     // loop while the base ten number is greater than 0
     while( baseTenNum > 0 )
        {
         // set temp digit to remainder of division by the base
         tempDigit = baseTenNum % newBase;
       
         // add the newest digit multiplied by the multiplier to the new value
         newVal += tempDigit * multiplier;
       
         // increase the multiplier by a factor of 10
         multiplier*= 10;
       
         // divide the base ten number by the base
         baseTenNum /= newBase;
        }
     // end loop
       
     // return new value
     return newVal;
    }
    
    // 17
    // translateToDecimal
    // - not sure how this one works
    public static int translateToDecimal( long number, int base )
    {
     // declare, define variables
       
         // set exponent and new value to 0 and create temp digit
         int exponent = 0, newVal = 0, tempDigit;
       
     // loop while given number is greater than 0
     while( number > 0 )
        {
         // get last digit in number
         tempDigit = (int)( number % 10 );
       
         // multiply digit by its value and add to new value
         newVal += tempDigit * findPower( base, exponent );
       
         // increment exponent
         exponent++;
       
         // divide the given number by 10
         number /= 10;
        }
     // end loop
       
     // return new val
     return newVal;
    }
    
    
    // 18
    // appendToLL
    // - really not sure what this is
    public static void appendToLL( int value )
    {
     // initialize working reference to the root node  
     SL_NodeClass workingRef = RootNode;
     // initialize new node reference to a constructed node
     SL_NodeClass newNode = new SL_NodeClass( value );
       
     // test for working reference to be null ( empty list )
     if( workingRef == null )
        {
         // set root node to new node
         RootNode = newNode;
        }
       
     // otherwise, assume list is not empty
     else
        {
         // loop to end of linked list
         while( workingRef.nextRef != null )
             {
             // update working reference to nest node
             workingRef = workingRef.nextRef;
             }
         // end loop to end of linked list
       
         // set new node to working reference's next reference
         workingRef.nextRef = newNode;
        }
     // end empty list test
    }
    
    
    // 19
    // printList_SL
    // takes in a linked list and prints each item from  the list - don't get
    public static void printList_SL()
    {
     // initialize working reference to root node
     SL_NodeClass workingRef = RootNode;
       
     // loop to end of linked list
     while( workingRef != null )
        {
         // print one node data item
         System.out.print( workingRef.data );
       
         // test for not at end of list
         if( workingRef.nextRef != null )      
            {
             // print comma and space
             System.out.print( ", " );
            }
         // end test for not at end of list
       
         // update working reference to next node
         workingRef = workingRef.nextRef;
        }
     // end loop to end of linked list
       
     // print end of line
     System.out.println();
    }
    
    
    // 20
    // removeFromLL
    // removes given value from linked list don't get
    public static boolean removeFromLL( int value )
    {
     // initialize working reference to root node
     SL_NodeClass workingRef = RootNode;
       
     // test for empty list
     if( workingRef != null )
        {
         // test for first node to hold data
         if( workingRef.data == value )
            {
             // set root node to next node
             RootNode = RootNode.nextRef;
       
             // return true
             return true;
            }
         // end test for first node
       
         // loop until end of list or data found at woorking reference's next 
            // reference
         while( workingRef.nextRef != null && workingRef.nextRef.data != value )
            {
             // update working reference to next node
             workingRef = workingRef.nextRef;
            }
         // end loop to end of list or data found
       
         // test for working reference's next reference to be at end of list
         if( workingRef.nextRef == null )
            {
             // return false
             return false;
            }
         // end test for working reference's next reference
       
         // set working reference's next reference to node after next reference,
            // unlink node
         workingRef.nextRef = workingRef.nextRef.nextRef;
       
         // return true
         return true;
        }
     // end test for empty list
       
     // reurn false
     return false;
    }
    
    
    // 21
    // SearchForItem
    // searches a linked list for a specified value - don't get
    public static boolean searchForItem( int value )
    {
     // initialize working reference to root node
     SL_NodeClass workingRef = RootNode;
       
     // loop across list
     while( workingRef != null )
        {
         // test for data found
         if( workingRef.data == value )
            {
             // return true
             return true;
            }
             // end test
       
         // update working reference to next node
         workingRef = workingRef.nextRef;
        }
     // end loop across list
       
     // return false
     return false;
    }
    
    
    // 22
    // appendToEnd
    // appends a value to then end of a linked list - don't get
    public static void appendToEnd( int value )
    {
     // initialize new node reference to constructed node
     DL_NodeClass newNode = new DL_NodeClass( value );
     // initialize working reference to root node
     DL_NodeClass workingRef = RootNode;
       
     // test for empty list
     if( workingRef == null )
        {
         // set root node to new node
         RootNode = newNode;
        }
     // otherwise, assume list not empty
     else
        {
         // loop across list
         while( workingRef.nextRef != null )
            {
             // update working reference to next node
             workingRef = workingRef.nextRef;
            }
         // end empty list test
       
         // assign new node to working reference/last node
         workingRef.nextRef = newNode;
       
         // set new node's previous reference to the working reference/last node
         workingRef.nextRef.prevRef = workingRef;
        }
     // end empty list test
    }
    
    
    // 23
    // insertAfterValue
    // inserts given value after specified value - don't understand this
    public static boolean insertAfterValue( int locationVal, int insertVal )
    {
     // initialize new node reference for later use
     //initialize working reference to root node
     DL_NodeClass newNode, workingRef = RootNode;
       
     // loop across list looking for location value
     while( workingRef != null && workingRef.data != locationVal )  
        {
         // update working reference to next node
         workingRef = workingRef.nextRef;
        }
     // end loop across list
       
     // test for working reference not at end of list
     if( workingRef != null )
        {
         // set new node to constructed node
         newNode = new DL_NodeClass( insertVal );
       
         // set new node's previous reference to te working reference
         newNode.prevRef = workingRef;
       
         // set new node's next reference to the working reference's next node
         newNode.nextRef = workingRef.nextRef;
       
         // set the working reference's next reference to the new node
         workingRef.nextRef = newNode;
       
         // test for new node's next reference not at end of list
         if( newNode.nextRef != null )
            {
             // set new node's next reference's previous reference to the new 
                // node
             newNode.nextRef.prevRef = newNode;
            }
         // end test for new node's next reference
       
         // return true
         return true;
        }
     // end test for working reference not at end
       
     // return false
     return false;
    }
    
    
    // 24 
    // insertAtBeginning
    // inserts given value at beginning of linked list - don't get
    public static void insertAtBeginning( int value )
    {
     // initialize new node reference to constructed node
     DL_NodeClass newNode = new DL_NodeClass( value );
       
     // test for empty list
     if( RootNode == null )
        {
         // set root node to new node
         RootNode = newNode;
        }
     // otherwise, assume list not empty
     else
        {
         // set new node's next reference to the root node
         newNode.nextRef = RootNode;
       
         // set the root node's previous reference to the new node
         RootNode.prevRef = newNode;
       
         // set the root node to the new node
         RootNode = newNode;
        }
     // end test for empty list
    }
    
    
    // 25
    // insertBeforeValue
    // inserts given value before specified item in linked list - don't get
    public static boolean insertBeforeValue( int locationVal, int insertVal )
    {
     // initialize new node for later use
     // initialize working reference to root node
     DL_NodeClass newNode, workingRef = RootNode;
       
     // test for list not empty
     if( workingRef != null )
        {
         // test for location item at beginning of list
         if( workingRef.data == locationVal )
            {
             // call insertAtBeginning method
             insertAtBeginning( insertVal );
       
             // return true
             return true;
            }
         // end test for item at beginning of list
             
         // loop across list until working reference's next reference data is 
            // the location value
         while( workingRef.nextRef != null && 
                workingRef.nextRef.data != locationVal )
            {
             // update working reference to next node
             workingRef = workingRef.nextRef;
            }
         // end loop to find location value
             
         // test for working reference not at end of list
         if( workingRef.nextRef != null )
            {
             // set new node reference to constructed node
             newNode = new DL_NodeClass( insertVal );
             
             // set new node's next reference to the working reference's next 
                // reference
             newNode.nextRef = workingRef.nextRef;
             
             // set new node's previous reference to the working reference
             newNode.prevRef = workingRef;
             
             // set the working references next reference to the new node
             workingRef.nextRef = newNode;
             
             // set the working reference's next reference's previous reference 
                // to the new node
             newNode.nextRef.prevRef = newNode;
             
             // return true
             return true;
            }
         // end test for working reference not at end of list
        }
     // end test for list not empty
          
     // return false
     return false;
    }
    
    
    // 26
    // printList_DL
    // prints out linked list items - not sure how this works
    public static void printList_DL()
    {
     // initialize working reference to root node
       DL_NodeClass workingRef = RootNode;
       
     // loop across list
     while( workingRef != null )
        {
         // print one node data item
         System.out.print( workingRef.data );
       
         // test for working reference not at last item
         if( workingRef.nextRef != null );
            {
             // print comma and space
             System.out.print( ", " );
            }       
         // end test for working reference not at last item
       
         // update working reference to next node
         workingRef = workingRef.nextRef;
        }
     // end loop across list
       
     // print end of line
     System.out.println();
    }
    
    
    // 27
    // removeValue
    // removes value from doubly linked list - don't understand this
    public static boolean removeValue( int value )
    {
     // initialize working reference to root node
     DL_NodeClass workingRef = RootNode;
       
     // loop across list to find value
     while( workingRef != null && workingRef.data != value )
        {
         // update working reference to next node 
         workingRef = workingRef.nextRef;
        }
     // end loop across list
       
     // test for working reference not at end of list
     if( workingRef != null )
        {
         // test for not first node
         if( workingRef.prevRef != null )
            {
             // set working reference's previous reference's next reference to 
                // working reference;s next reference
             workingRef.prevRef.nextRef = workingRef.nextRef;
            }
         // otherwise, assume first node found
         else
            {
             // set root node to working node's next reference
             RootNode = workingRef.nextRef;
            }
         // end test for first node
       
         // test if working reference not at last node
         if( workingRef.nextRef != null )
            {
             // set working reference's next reference's orecous reference to 
                // working reference's previous reference
             workingRef.nextRef.prevRef = workingRef.prevRef;
            }
         // end test for working reference not at last node
       
         // return true
         return true;
        }
     // end test for working reference not at end of list
       
     // return false;
     return false;
    }
   }
