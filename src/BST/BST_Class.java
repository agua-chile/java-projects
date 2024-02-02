package BST;

public class BST_Class
   {
    private StudentClassNode BST_Root;
    private String outputString;
    
    /* default constructor 
     * Description:
     *   Default class constructor, initializes BST
     */
    public BST_Class()
       {
        // initialize default vals
        BST_Root = null;
        outputString = "";
       }
    
    
    /* copy constructor  
     * Description:
     *   Copy constructor
     * Note: 
     *   Uses copyConstHelper
     * Parameters:
     *   @param copied - BST_Class object to be copied
     */
    public BST_Class( BST_Class copied ) // is this right?
       {
        // initialize copied vals
        BST_Root = copyConstHelper​( copied.BST_Root );
       }
    
    
    /* copyConstHelper
     * Description:
     *   Copy constructor helper, recursively adds nodes to duplicate tree
     * Parameters:
     *   @param copiedRef - StudentClassNode reference for accessing copied 
     *                      object data
     * Returns:
     *   @return StudentClassNode reference to node added at current level of 
     *   recursion
     */
    private StudentClassNode copyConstHelper​( StudentClassNode copiedRef ) // TODO:
       {
        // initialize variables
        StudentClassNode wkgRef = null;
        
        // check for copied reference not null
        if( copiedRef != null )
           {
            // create a new node to copy current node
            wkgRef = new StudentClassNode( copiedRef );

            // call recursion to the left,
            // assigning result to the left child of the new node
            wkgRef.leftChildRef = copyConstHelper​( copiedRef.leftChildRef );

            // call recursion to the right,
            // assigning result to the right child of the new node
            wkgRef.rightChildRef = copyConstHelper​( copiedRef.rightChildRef );
           }
        // return the new local reference, either null or with node
        return wkgRef;
       }
    
    
    /* clearTree   
     * Description:
     *   Clears tree
     */
    public void clearTree()
       {
        // clears the tree
        BST_Root = null;
       }
    
    
    /* insert
     * Description:
     *   Insert method for BST
     * Note: 
     *   uses insert helper method to insert by student ID key
     * Parameters:
     *   @param inData - StudentClassNode data to be added to BST
     */
    public void insert​( StudentClassNode inData )
       {
        // calls helper
        insertHelper​( BST_Root, inData );
       }
    
    
    /* insertHelper
     * Description:
     *   Insert helper method for BST insert action
     * Note: 
     *   Inserts by student ID key
     *   Uses look-down strategy and links to current node; handles special case 
     *   of empty tree
     * Parameters:
     *   localRoot - StudentClassNode tree root reference at the current 
     *               recursion level
     *   inData - StudentClassNode item to be added to BST
     */
    private void insertHelper​( StudentClassNode localRoot, 
                               StudentClassNode inData )
       {
        // check for if empty
        if( isEmpty() )
           {
            // set root to newData
            BST_Root = inData;
           }
        // else, assume not empty
        else
           {
            // check if search val < localRoot
            if( inData.studentID < localRoot.studentID )
               {
                // check if leftChild is null
                if( localRoot.leftChildRef == null )
                   {
                    // assign localRoot leftChild to inData
                    localRoot.leftChildRef = inData;
                   }
                // else, assume leftChild is not null
                else
                   {
                    // call method recursively to the left
                    insertHelper​( localRoot.leftChildRef, inData );
                   }
               }
            // else, assume searchVal > localRoot
            else
               {
                // check if rightChild is null
                if( localRoot.rightChildRef == null )
                   {
                    // assign rightChild to inData
                    localRoot.rightChildRef = inData;
                   }
                // else, assume rightChild is not null
                else
                   {
                    // call method recursivley to the right
                    insertHelper​( localRoot.rightChildRef, inData );
                   }
               }
           }
       }
    
    
    /* isEmpty
     * Description:
     *   Test for empty tree
     */
    public boolean isEmpty()
       {
        // returns whether empty or not
        return BST_Root == null;
       }
    
    
    
    /* outputInOrder  
     * Description:
     *   Provides inOrder traversal for user as a string
     *   left - parent - right
     * Returns:
     *   @return String containing in order output
     */
    public String outputInOrder()
       {
        // if not empty
        if( !isEmpty() )
           {
            // reset string
            outputString = "";
            
            // call helper
            outputInOrderHelper​( BST_Root );
           }
        
        // return result
        return outputString;
       }
    
    
    /* outputInOrderHelper
     * Description:
     *   Provides inOrder traversal action helper
     * Note: 
     *   Updates string with each call
     * Parameters:
     *   @param localRoot - StudentClassNode tree root reference at the current 
     *                      recursion level
     */
    private void outputInOrderHelper​( StudentClassNode localRoot )
       {
        // if left not null
        if( localRoot.leftChildRef != null  )
           {
            // call recursion left
            outputInOrderHelper​( localRoot.leftChildRef );
           }
        
        // display parent  
        outputString += localRoot.toString() + "\n";
        
        // if right not null
        if( localRoot.rightChildRef != null  )
           {
            // call recursion right
            outputInOrderHelper​( localRoot.rightChildRef );
           }
       }
    
    
    /* outputPostOrder
     * Description:
     *   Provides postOrder traversal for use as a string
     *   parents - left - right
     * Returns:
     *   @return String containing post order output
     */
    public String outputPostOrder()
       {
        // if not empty
        if( !isEmpty() )
           {
            // reset string
            outputString = "";
              
            // call helper
            outputPostOrderHelper( BST_Root );
           }
        
        // return result
        return outputString;
       }
    
    
    /* outputPostOrderHelper 
     * Description:
     *   Provides postOrder traversal action helper
     * Note:
     *   Updates string with each call
     * Parameters:
     *   @param localRoot - StudentClassNode tree root reference at the current 
     *                      recursion level
     */
    private void outputPostOrderHelper( StudentClassNode localRoot )
       {
        // display parent  
        outputString += localRoot.toString() + "\n";
        
        // if left not null
        if( localRoot.leftChildRef != null )
           {
            // call recursion left
            outputPostOrderHelper( localRoot.leftChildRef );
           }
        
        // if right not null
        if( localRoot.rightChildRef != null )
           {
            // call recursion right
            outputPostOrderHelper( localRoot.rightChildRef );
           }
       }
    
    
    /* outputPreOrder
     * Description:
     *   Provides preOrder traversal for user as a string
     *   left - right - parent
     * Returns:
     *   @return String containing pre order output
     */
    public String outputPreOrder()
       {
        // if not empty
        if( !isEmpty() )
           {
            // reset string
            outputString = "";
            
            // call helper
            outputPreOrderHelper( BST_Root );
           }
        
        // return result
        return outputString;
       }
    
    
    /* outputPreOrderHelper 
     * Description:
     *   Provides preOrder traversal action helper
     * Note:
     *   Updates string with each call
     * Parameters:
     *   @param localRoot - StudentClassNode tree root reference at the current 
     *                      recursion level
     */
    private void outputPreOrderHelper( StudentClassNode localRoot )
       {
        // if left not null
        if( localRoot.leftChildRef != null )
           {
            // call recursion left
            outputPreOrderHelper( localRoot.leftChildRef );
           }
        
        // if right not null
        if( localRoot.rightChildRef != null )
           {
            // call recursion right
            outputPreOrderHelper( localRoot.rightChildRef );
           }
        
        // display parent  
        outputString += localRoot.toString() + "\n";
       }
    
    
    /* removeFromMax
     * Description:
     *   Searches tree from given node to maximum value node below it, unlinks 
     *   and returns found node
     * Parameters:
     *   @param parent - StudentClassNode reference to current node
     *   @param child - StudentClassNode reference to child node to be tested
     * Returns:
     *   @return StudentClassNode reference containing removed node
     */
   private StudentClassNode removeFromMax​( StudentClassNode parent,
                                            StudentClassNode child )
       {
        // initialize variables
        StudentClassNode returnNode;
        
        // checks if not empty
        if( !isEmpty() )
           {
            // checks if parent has right child
            if( child.rightChildRef != null )
               {
                // calls recursion at right child
                return removeFromMax​( parent.rightChildRef, 
                                      child.rightChildRef );
               }
            // set returnNode
            returnNode = parent;
            
            // set parents right child to right childs left child
            parent.rightChildRef = child.leftChildRef;
            
            // return removed node
            return returnNode;
           }
        // otherwise, assume empty
        return null;
       }
    
    /* removeNode   
     * Description:
     *   Removes data node from tree using student ID key
     * Note: 
     *   uses remove helper method
     *   Verifies if data is available with search method, then if found, calls 
     *   remove
     * Parameters:
     *   @param inData - StudentClassNode that includes the student ID key
     * Returns:
     *   @return StudentClassNode result of remove action
     */
    public StudentClassNode removeNode( StudentClassNode inData )
       {
         // check for BST_Root not null and if it is even there
        if( !isEmpty() && search​( inData ) == inData )
           {
            // return removed val
            return removeNodeHelper​( BST_Root, inData );
           }
        // return item not found
        return null;
       }
     
    
    /* removeNodeHelper  
     * Description:
     *   Remove helper for BST remove action for removing by student ID key
     * Note: 
     *   uses removeFromMax method
     *   Assumes removed node is available since it was previously found by 
     *   search in removeNode
     * Parameters:
     *   @param localRoot - StudentClassNode tree root reference at the current 
     *                      recursion level
     *   @param outData - StudentClassNode item that includes the student ID key
     * Returns:
     *   @return StudentClassNode reference result of remove helper action
     */
    private StudentClassNode removeNodeHelper​( StudentClassNode localRoot,
                                               StudentClassNode outData )
       {
        // initialize variables
        StudentClassNode removeVal;
        
        // Check for the search value to be less than the current node, and 
        // recurse left if so
        if( outData.studentID < localRoot.studentID )
           {
            removeNodeHelper​( localRoot.leftChildRef, outData );
           }
        // Check for the search value to be greater than the current 
        // node, and recurse right if so
        else if( outData.studentID > localRoot.studentID )
           {
            removeNodeHelper​( localRoot.rightChildRef, outData );
           }
        // Check for the current node's left child to be null, and set the local
        // to right child's reference if so, return remove val
        if( localRoot.leftChildRef == null )
           {
            removeVal = localRoot;
            localRoot = localRoot.rightChildRef;
            return removeVal;
           }
        // Check for the current node's right child to be null, and set the
        // local to left child's reference if so, return removed val
        if( localRoot.rightChildRef == null )
           {
            removeVal = localRoot;
            localRoot = localRoot.rightChildRef;
            return localRoot;
           }
        // Check that the left child has a right child
        if( localRoot.leftChildRef.rightChildRef != null )
           {
            // if so, call removeFromMax, and transfer the data from the removed
            // node to the current node, return removed val
            removeVal = localRoot;
            
            localRoot = removeFromMax​( localRoot.leftChildRef, 
                                 localRoot.leftChildRef.rightChildRef  );
            return removeVal;
           }

        // If the left child does not have a right child
        else
           {
            // copy the left child's data into the current node and link around 
            // the left child to remove the node, return removed val
            removeVal = localRoot;
            localRoot = localRoot.leftChildRef;
            return removeVal;
           }
       }
    
    
    /* search   
     * Description:
     *   Searches for data in BST given StudentClassNode with necessary key
     * Parameters:
     *   @param searchData - StudentClassNode item containing key
     * Returns:
     *   @return StudentClassNode reference to found data
     */
    public StudentClassNode search​( StudentClassNode searchData )
       {
        // return search
        return searchHelper​( BST_Root, searchData );
       }
    
    
    /* searchHelper   
     * Description:
     *   Helper method for BST search action
     * Parameters:
     *   @param localRoot - StudentClassNode tree root reference at the current 
     *                      recursion level
     *   @param searchData - StudentClassNode item containing key
     * Returns:
     *   @return StudentClassNode item found
     */
    private StudentClassNode searchHelper​( StudentClassNode localRoot, 
                                           StudentClassNode searchData )
       {
        // if not empty
        if( !isEmpty() )
           {
            // is search < local
            if( searchData.studentID < localRoot.studentID && 
                localRoot.rightChildRef != null )
               {
                // recurse left
                return searchHelper​( localRoot.leftChildRef, searchData );
               }
            // else if search > local
            else if( searchData.studentID > localRoot.studentID && 
                     localRoot.rightChildRef != null )
               {
                // recurse right
                return searchHelper​( localRoot.rightChildRef, searchData );
               }
            // else if search = local
            else if( searchData.studentID == localRoot.studentID )
               {
                // return found
                return localRoot;
               }
           }
        // return not found
        return null;
       }
   }
