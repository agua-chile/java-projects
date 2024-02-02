package SudokuGenerator;

/* CellNode Class
    * Description:
    *   Private cell class to identify fixed (locked) cells and data (number)
*/
public class CellNode
   {
    // Boolean value indicating a fixed cell which may not be changed once it 
    // has beena set
    boolean fixedCell;
    
    // cell value for Sudoku game
    int value;
    
    /* CellNode
    * Description:
    *   Default donstructor for cell node
    */
    public CellNode()
       {  
        // set default values
        fixedCell = false;
        value = 0;
       }
    
    /* CellNode
    * Description:
    *   Copy constructor for cell node
    * Parameters:
    *   copied - CellNode object to be copied
    */
    public CellNode( CellNode copied )
       {
        // set copy variables
        fixedCell = copied.fixedCell;
        value = copied.value;
       }
   }
