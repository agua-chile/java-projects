package BST;

public class BST_HashClass
   {
    // initialize class variables
    private static int DEFAULT_TABLE_SIZE = 11;
    private int tableSize;
    private BST_Class[] tableArray;
    
    /* default constructor
     */
    public BST_HashClass()
       {
        tableSize = DEFAULT_TABLE_SIZE;
        tableArray = new BST_Class[ tableSize ];
       }
    
    /* initialization constructor
     * Descripton:
     *   initializes array to specified table size; initializes all BST elements
     * Parameters:
     *   @param inTableSize - sets table size
     */
    public BST_HashClass( int inTableSize )
       {
        tableSize = inTableSize;
        tableArray = new BST_Class[ tableSize ];
       }
    
    /* copy constructor
     * Parameters:
     *   @param copied - BST_HashClass object to be copied
     */
    public BST_HashClass( BST_HashClass copied )
       {
        int index;
        tableSize = copied.tableSize;
        tableArray = new BST_Class[ tableSize ];
        
        for( index = 0; index < tableSize; index++ )
           {
            tableArray[ index ] = new BST_Class( copied.tableArray[ index ] );
           }
       }
    
    /* addItem
     * Description:
     *   Adds item to hash table
     *   Uses overloaded addItem with object
     * Parameters:
     *   @param inName - name of student
     *   @param inStudentID - student ID
     *   @param inGender - gender of student
     *   @param inGPA - gpa of student
     */
    public void addItem( String inName, int inStudentID, char inGender, 
                         double inGPA )
       {
        // initialize variables
        StudentClassNode newStudent = new StudentClassNode( inName, inStudentID, inGender, inGPA ); 
        int hash = generateHash( newStudent ), hashIndex = hash % tableSize;;
        
        // if the hash index is an empty bin
        if( tableArray[ hashIndex ] == null )
           {
            // create new data
            tableArray[ hashIndex ] = new BST_Class();
           }
        
        // add item
        tableArray[ hashIndex ].insert​( newStudent );
       }
    
    /* clearHashTable
     * Description:
     *   Clears hash table by clearing all BST elements
     */
    public void clearHashTable()
       {
        int index;
        
        for( index = 0; index < tableSize; index++ )
           {
            if( tableArray[ index ] != null )
               {
                tableArray[ index ].clearTree();
               }
           }
       }
    
    /* findItem
     * Description:
     *   Searches for item in hash table using student ID as key
     * Parameters:
     *   @param studentID - used for requesting data
     * Returns:
     *   @return StudentClassNode object removed, or null if not found
     */
    public StudentClassNode findItem( int studentID )
       {
        // initialize variables
        StudentClassNode tempStudent = new StudentClassNode( "", studentID, '0', 
                                                             0.0 );
        int hash = generateHash( tempStudent ), hashIndex = hash % tableSize;;
        
        // return if or if not found
        return tableArray[ hashIndex ].search​( tempStudent );
       }
    
    /* generateHash
     * Description:
     *   Method uses student ID to generate hash value for use as index in hash 
     *   table
     *   Process sums the Unicode values of each of the student ID digits 
     *   converted to characters, and then creates a hash index
     * Parameters:
     *   @param studentData - StudentClassNode object from which hash value will 
     *                        be generated
     * Returns:
     *   @return integer hash value to be used as array index
     */
    public int generateHash( StudentClassNode studentData )
       {
        // initialize variables
        int hash = 0, data = studentData.studentID, num;
        char charNum;
        
        // set hash val
        while( data > 0 )
           {
            num = data % 10;
            charNum = (char)num;      
            hash += charNum + '0';
            data /= 10;
           }
        
        // return hash
        return hash;
       }
    
    /* removeItem
     * Description:
     *   Removes item from hash table, using student ID as key
     * Parameters:
     *   @param studentID - used for requesting data
     * Returns:
     *   @return StudentClassNode object removed, or null if not found
     */
    public StudentClassNode removeItem( int studentID )
       {
        // initialize variables
        StudentClassNode tempStudent = new StudentClassNode( "", studentID, '0',
                                                             0.0 );
        int hash = generateHash( tempStudent ), hashIndex = hash % tableSize;
        
        // return if or if not found
        return tableArray[ hashIndex ].removeNode( tempStudent );
       }
    
    /* showHashTableStatus
     * Description:
     *   traverses through all array bins, finds counts from each BST, then 
     *   displays as table
     *   Shows table of list lengths, then shows table size, then shows the 
     *   number of empty bins and the longest linked list of the set; adapts to 
     *   any size array
     */
    public void showHashTableStatus()
       {
        // initialize variables
        int index, emptyBins = 0, numNodes,
            largestNumNodes = tableArray[ 0 ].countNodes(), 
            smallestNumNodes = tableArray[ 0 ].countNodes();
        
        // print initial statement
        System.out.print( "\nArray mode report:\n             " );
        
        // print number of nodes in each bin
        for( index = 0; index < tableSize; index++ )
           {
            // if array at index is not null
            if( tableArray[ index ] != null )
               {
                // set numNodes
                numNodes = tableArray[ index ].countNodes();
               }
     
            // otherwise, assume it is null
            else
               {
                // set numNodes to 0
                numNodes = 0;
               }
            
            // print correct amount of spaces before numNodes
            if( numNodes < 10 )
               {
                System.out.print( "     " );
               }
            else
               {
                System.out.print( "    " );
               }
            
            // print each node count
            System.out.print( numNodes );
            
            // set emptyBins, smallest and largest
            if( numNodes == 0 )
               {
                emptyBins++;
               }
            if( numNodes > largestNumNodes )
               {
                largestNumNodes = numNodes;
               }
            if( numNodes < smallestNumNodes )
               {
                smallestNumNodes = numNodes;
               }
           }
        
        // print spacing
        System.out.print( "\n               " );
        
        // print the "bin casing"
        for( index = 0; index < tableSize; index++ )
           {
            System.out.print( "----- " );
           }
        
        // print statement
        System.out.print( "\n Index:      " );
        
        // print each bin number
        for( index = 0; index < tableSize; index++ )
           {
            // print correct amount of spaces before numNodes
            if( index < 10 )
               {
                System.out.print( "     " );
               }
            else
               {
                System.out.print( "    " );
               }
            
            System.out.print( index );
           }
        System.out.println();
        
        // print table info
        System.out.println( "\nWith a table size of " + tableSize + ",\n"
                          + "The number of empty bins was " + emptyBins + ".\n"
                          + "The largest BST count was " 
                          + largestNumNodes
                          + " node(s).\nThe smallest BST count was " 
                          + smallestNumNodes
                          + " node(s).\n");
       }
   }
