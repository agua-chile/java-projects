package SudokuGenerator;

public class SudokuGeneratorClass
   {
    // Constant for side of grid
    private final int GRID_SIDE = 9;
    
    // Constant for side of sub grid
    private final int SUB_GRID_SIDE = 3;
    
    // Constant for range of numbers in Sudoku
    private final int SUDOKU_RANGE = 9;
    
    // Two dimensional array for holding cell nodes with fixed/locked code and 
    // number
    private CellNode[][] sudokuArray;
    
    /* default constructor
     * Description:
     *   Default generator class array sets up and initializes the Sudoku array
     */
    public SudokuGeneratorClass()
    {
     // initialize variables
     int rowIndex, colIndex;
     
     // initialize array
     sudokuArray = new CellNode[ GRID_SIDE ][ GRID_SIDE ]; 
     
     // set each item in array to default cell item
     for( rowIndex = 0; rowIndex < GRID_SIDE; rowIndex++ )
        {
         for( colIndex = 0; colIndex < GRID_SIDE; colIndex++ )
            {
             sudokuArray[ rowIndex ][ colIndex ] = new CellNode();
            }
        }
    }
    
    
    /* copy constructor
     * Description:
     *   Generator class copy constructor
     * Note:
     *   Must create new CellNode for each copied element to eliminate aliasing
     * Paramaters:
     *   copied - SudokuGeneratorClass object to be copied
     */
    public SudokuGeneratorClass( SudokuGeneratorClass copied )
    {
     // initialize variables
     int rowIndex, colIndex;
     
     // initialize array
     sudokuArray = new CellNode[ GRID_SIDE ][ GRID_SIDE ]; 
     
     // loop across rows
     for( rowIndex = 0; rowIndex < GRID_SIDE; rowIndex++ )
        {
         // loop across cols
         for( colIndex = 0; colIndex < GRID_SIDE; colIndex++ )
            {
             // copy each item 
             sudokuArray[ rowIndex ][ colIndex ] = new
             CellNode( copied.sudokuArray[ rowIndex ][ colIndex ] );
            }
        }
    }
    
    
    /* createSudoku
     * Description:
     *   Method must only set the diagonal subgrids, call the recursive helper 
     *   method, remove the specified number of elements once the board has been 
     *   completed, and display the playing board solution. It must not conduct 
     *   any other actions
     * Note: 
     *   Sets up sub diagonal grids and calls helper
     * Parameters:
     *   numEmpties - integer value indicating how many Sudoku cells to leave 
     *                for the game player to fill in
     *   showGrid - Boolean value that supports display of the transactions and 
     *              the grids as the program runs
     */
    public void createSudoku​( int numEmpties, boolean showGrid )
    {
     // initialize variables
       
     // set diagonal subgrids
     setDiagonalSubGrids();
     System.out.println( "Starting Grid:" );
     displayGrid();

     // call recursive method to fill out rest of sudoku
     createSudokuHelper​( 0, 0, showGrid );
       
     // removes the specified number of values to remove
     removeNumbers​( numEmpties );
       
     // check if grid should be shown
     if( showGrid )
        {
         // display the solution
         System.out.println( "Solution Found:" );
         displayGrid();
        }
    }
    
    
    /* createSudokuHelper
     * Description:
     *   Starts in the upper left corner of the playing board and recursively 
     *   travels across the board in row major fashion (i.e., start at a row, 
     *   exhaust the columns, and then go to the next row, etc.), setting and 
     *   testing each element for conflict (e.g., same number in the same row, 
     *   same column, or same subgrid), and backtracking if all possible values 
     *   at that element location have been exhausted
     * Note:
     *   As part of this process, it must not attempt to modify the values set 
     *     in the original three subgrids; these items' fixed flags will be set 
     *     to true
     *   When the recursive process reaches the bottom of the playing board with 
     *     correct values (i.e., no disqualifying conflicts), the method returns 
     *     true, and as stated above, the number of values requested by the user 
     *     are randomly removed (in the createSudoku method) to complete the 
     *     game creation
     *   If the user sets the "showGrid" parameter to true, the method must 
     *     display the grid at the end of each completed row in addition to each 
     *     time a new conflict-free number is being tested
     * Parameters:
     *   rowPos - integer row location of current element
     *   colPos - integer column location of current element
     *   showGrid - Boolean indicator that shows grids and transactions as the 
     *              method progresses if true
     * Returns:
     *   Boolean value to indicate success or failure of the recursive process
     */
    private boolean createSudokuHelper​( int rowPos, int colPos, 
                                        boolean showGrid )
    {
     // initialize variables
     int testVal;
     
     // test if not fixed
     if( !sudokuArray[ rowPos ][ colPos ].fixedCell )
        {
         // test 1-9 - loop
         for( testVal = 1; testVal <= SUDOKU_RANGE; testVal++ )
            {
               
             // if no conflict
             if( !hasConflict​( rowPos, colPos, testVal ) )
                {
                 // display testing 
                 if( showGrid )
                      {
                       System.out.format( "          Trying " + testVal + 
                                          " at row: " + rowPos + " and column: " 
                                          + colPos + "\n" );
                      }
                 
                 // set the value
                 sudokuArray[ rowPos ][ colPos ].value = testVal;
               
                 // if not at the end of rows and cols
                 if( colPos < SUDOKU_RANGE - 1 && rowPos < SUDOKU_RANGE - 1 )
                    {
                     // call recursion at col + 1
                     createSudokuHelper​( rowPos, colPos + 1, showGrid );
                    }
               
                 // else if at end of cols but not rows
                 else if( colPos == SUDOKU_RANGE - 1 && 
                          rowPos < SUDOKU_RANGE - 1 )
                    {
                     // display grid
                     if( showGrid )
                        {
                         displayGrid();
                        }
                     
                     // call recursion at row + 1, col = 0
                     createSudokuHelper​( rowPos + 1, 0, showGrid );
                    }
                }
             // end if no conflict test
             
             // if there is conflict and its the last val print backtracking
             if( hasConflict​( rowPos, colPos, testVal ) 
                 & testVal == SUDOKU_RANGE )
                {
                 if( showGrid )
                    {
                     System.out.println( "     Backtracking from row: " + rowPos 
                                         + " and comlumn: " + colPos );
                     
                     // if it is at the first item and tries to backtrack
                     if( rowPos == 0 && colPos == 3 )
                        {
                         // print failure
                         System.out.println( "\nRECURSION FAILED" );
                        }
                    }
                }
             
            }
         // end test val loop
        }
     // end not fixed test
     
     // otherwise, if it is fixed
     else
        {
         // if not at the end of rows and cols
         if( colPos < SUDOKU_RANGE - 1 && rowPos < SUDOKU_RANGE - 1 )
            {
             // call recursion at col + 1
             createSudokuHelper​( rowPos, colPos + 1, showGrid );
            }
     
         // else if, it is at the end of cols but not end of rows
         else if( colPos == SUDOKU_RANGE - 1 && rowPos < SUDOKU_RANGE - 1 )
            {
             // display grid
             if( showGrid )
                {
                 displayGrid();
                }
             // call recursion at row + 1, col = 0
             createSudokuHelper​( rowPos + 1, 0, showGrid );
            }
         // otherwise, its at the very end and its finished - success
         return true;
        }
     // return failure
     return false;
    }
    
    
    /* displayGrid
     * Description:
     *   Displays grid as it is currently set up
     * Note:
     *   Uses character formatting for grid display
     */
    public void displayGrid()
    {
     // initialize variables
     int rowIndex, colIndex;
     String doubleLine = "#===|===|===#===|===|===#===|===|===#",
            singleLine = "#---|---|---#---|---|---#---|---|---#";
     String space = " ", hash = "#", pipe = "|", gridSpace = "     ";
     
     // print initial line
     System.out.print( "\n" );
       
     // loop across rows
     for( rowIndex = 0; rowIndex < GRID_SIDE; rowIndex++ )
        {
         // if row index % 3 == 0
         if( rowIndex % 3 == 0 )
            {
             // print double line
               System.out.println( gridSpace + doubleLine );
            }
     
         // otherwise
         else
            {
             // print single line
             System.out.println( gridSpace + singleLine );
            }
     
         // loop across cols
         for( colIndex = 0; colIndex < GRID_SIDE; colIndex++ )
            {
             if( colIndex == 0 )
                {
                 System.out.print( gridSpace );
                }
             // if col index % 3 == 0
             if( colIndex % 3 == 0 )
                {
                 // print hash
                 System.out.print( hash );
                }
     
             // otherwise
             else
                {
                 // print pipe
                   System.out.print( pipe );
                }
     
             // print each value with spacing
             System.out.print( space + sudokuArray[ rowIndex ][ colIndex ].value 
                               + space );
            }
     
         // println hash
         System.out.println( hash );
        }
     System.out.println( gridSpace + doubleLine + "\n" );
    }
    
    
    /* genRandSudokuValue
     * Description:
     *   Generates random value between 1 and 9
     * Note:
     *   Uses double stage process. Calls random to get number between 1 and 9, 
     *   then loops that many times generating random values. Finally takes the 
     *   last value generated. Uses Math.random
     * Returns:
     *   integer random value generated
     */
    private int genRandSudokuValue()
    {
     // return random int
     return ( int )( ( Math.random() * SUDOKU_RANGE ) + 1 );
    }
    
    
    /* hasConflict
     * Description:
     *   Checks for conflict of a given number in a given element
     * Note:
     *   Uses isInRow, isInCol, and isInSubGrid in one line of code to indicate 
     *   if the number has already been used in the same row, the same column, 
     *   or the same sub grid
     * Parameters:
     *   rowLocIndex - integer row index of element
     *   colLocIndex - integer column index of element
     *   value - integer value to be tested for conflict
     * Returns:
     *   Boolean result of test
     */
    private boolean hasConflict​( int rowLocIndex, int colLocIndex, int value )
    {
     if( isInCol​( colLocIndex, value ) || isInRow​( rowLocIndex, value ) ||
         isInSubGrid​( rowLocIndex, colLocIndex, value ) )
        {
         // return if found
         return true;
        }
     // return not found
     return false; 
    }
    
    
    /* isInCol
     * Description:
     *   Checks for conflict of value in the same column
     * Parameters:
     *   colIndex - integer column index
     *   value - integer value to be tested
     * Returns:
     *   Boolean result of test
     */
    private boolean isInCol​( int colIndex, int value )
    {
     // initialize variables
     int index;
     
     // loop across col
     for( index = 0; index < GRID_SIDE; index++ )
        {
         // test each item for test val
         if( sudokuArray[ index ][ colIndex ].value == value ) 
            {
             // return in col
             return true;
            }
        }
     // return not in col
     return false;
    }
    
    
    /*isInRow
     * Description:
     *   Checks for conflict of value in the same row
     * Parameters:
     *   rowIndex - integer row index
     *   value - integer value to be tested
     * Returns:
     *   Boolean result of test
     */
    private boolean isInRow​( int rowIndex, int value )
    {
     // initialize variables
     int index;
     
     // loop across row
     for( index = 0; index < GRID_SIDE; index++ )
        {
         // test each item for test val
         if( sudokuArray[ rowIndex ][ index ].value == value )
            {
             // return in row
             return true;
            }
        }
     // return not in row
     return false;
    }
    
    
    /*isInSubGrid
     * Description:
     *   Checks for conflict of value in sub grid
     * Note: 
     *   Must find upper left corner of sub grid from the row and column 
     *   indices, then search the sub grid
     * Parameters:
     *   rowLocIndex - integer row index of test item
     *   colLocIndex - integer column index of test item
     *   value - integer value to be tested
     * Returns:
     *   Boolean result of test
     */
    private boolean isInSubGrid​( int rowLocIndex, int colLocIndex, int value )
    {
     // initialize variables
     int colIndex, rowIndex, 
         rowStart = rowLocIndex - rowLocIndex % SUB_GRID_SIDE, 
         colStart = colLocIndex - colLocIndex % SUB_GRID_SIDE;
     
     // loop across rows
     for( rowIndex = rowStart; rowIndex < SUB_GRID_SIDE + rowStart; 
          rowIndex++ )
        {
         // loop across cols
         for( colIndex = colStart; colIndex < SUB_GRID_SIDE + colStart; 
              colIndex++ )
            {
             // test each val for test val
             if( sudokuArray[ rowIndex ][ colIndex ].value == value )
                {
                 // return found
                 return true;
                }
            }
        }
     // return not found
     return false;
    }
    
    /*removeNumbers 
     * Description:
     *   Randomly removes the specified number of items from the Sudoku array 
     *   for preparing the game
     * Parameters:
     *   numbersToBeRemoved - integer number of elements to be cleared
     */
    private void removeNumbers​( int numbersToBeRemoved )
    {
     // initialize variables
     int rowIndex = genRandSudokuValue(), colIndex = genRandSudokuValue(), 
         index = 0;
       
     // loop for specified amount of numbers
     while( index != numbersToBeRemoved )
        {
         // check if less then 9
         if( rowIndex < GRID_SIDE && colIndex < GRID_SIDE )
            {
             // check if item has not been removed
             if( sudokuArray[ rowIndex ][ colIndex ].value != 0 )
                {
                 // remove it
                 sudokuArray[ rowIndex ][ colIndex ].value = 0;
       
                 // increment numbers removed index
                 index++;
                }
            }
        }
    }
    
    
    /*setDiagonalSubGrids 
     * Description:
     *   Sets all three diagonal sub grids in preparation for setting other 
     *   values
     * Note:
     *   Calls setInitialSubGrid for each grid to be set up
     */
    private void setDiagonalSubGrids()
    {
     // initialze variables
     int rowIndex = 0, colIndex = 0;
       
     // loop until sub grids are finished
     while( rowIndex != GRID_SIDE || colIndex != GRID_SIDE )
        {
         // set each sub grid
         setInitialSubGrid​( rowIndex, colIndex );
         
         // increment indices
         rowIndex += SUB_GRID_SIDE;
         colIndex += SUB_GRID_SIDE;
        }
    }
    
    
    /*setInitialSubGrid 
     * Description:
     *   Sets one sub grid with non-repeating values
     * Parameters:
     *   startRow - integer row of upper left corner of sub grid to set up 
     *   startCol - integer column of upper left corner of sub grid to set up
     */
    private void setInitialSubGrid​( int startRow, int startCol )
    {
     // initialize variables
     int rowIndex, colIndex = startCol, testVal; 
     
     // loop across rows
     for( rowIndex = startRow; rowIndex < SUB_GRID_SIDE + startRow; rowIndex++ )
        {
         // loop across cols
         for( colIndex = startCol; colIndex < SUB_GRID_SIDE + startCol; 
              colIndex++ )
            {
             // set testVal to random int
             testVal = genRandSudokuValue();
             
             // get conflict free value
             while( hasConflict​( rowIndex, colIndex, testVal ) )
                {
                 testVal = genRandSudokuValue();
                }

             // set value
             sudokuArray[ rowIndex ][ colIndex ].value = testVal;
                 
             // set value to fixed
             sudokuArray[ rowIndex  ][ colIndex ].fixedCell = true;
            }
        }
    }
   }
