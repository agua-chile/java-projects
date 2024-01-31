package TwoThreeTree;

public class TwoThreeTreeClass
   {
    // initialize class variables
    private int ONE_DATA_ITEM = 1, TWO_DATA_ITEMS = 2, THREE_DATA_ITEMS = 3;    
    private String outputString;
    private TwoThreeNodeClass root;
    
    
    /* default constructor    
     * Description:
     *   Default 2-3 tree constructor
     */
    public TwoThreeTreeClass()
       {
        // initialize vals
        outputString = "";
        root = null;
       }
    
    
    /* copy constructor 
     * Description:
     *   Copy 2-3 tree constructor
     * Parameters:
     *   @param copied - TwoThreeTreeClass object to be duplicated; data is copied, but new 
                         nodes and references must be created
     */
    public TwoThreeTreeClass( TwoThreeTreeClass copied )
       {
        // initialize copied vals
        outputString = "";
        root = copyConstructorHelper​( copied.root );
       }
    
    
    /* copy constructor helper    
     * Description:
     *   Implements tree duplication effort with recursive method; copies data 
     *   into newly created nodes and creates all new references to child nodes
     * Parameters:
     *   @param workingCopiedRef - TwoThreeNodeClass reference that is updated 
     *                             to lower level children with each recursive 
     *                             call
     * Returns:
     *   @return TwoThreeNodeClass reference to next higher level node; last 
     *           return is to root node of THIS object
     */
    private TwoThreeNodeClass copyConstructorHelper​( TwoThreeNodeClass 
                                                     workingCopiedRef )
       {
        // initialize variables
        TwoThreeNodeClass wkgRef = null;
        
        // check for copied reference not null
        if( workingCopiedRef != null )
           {
            // create a new node to copy current node
            wkgRef = new TwoThreeNodeClass();

            // call recursion to the left,
            // assigning result to the left child of the new node
            wkgRef.leftChildRef = copyConstructorHelper​( 
                                                workingCopiedRef.leftChildRef );
            
            // set the parent if not null
            if( workingCopiedRef.leftChildRef != null )
               {
                wkgRef.leftChildRef.parentRef = wkgRef;
               }
           
            // check for if it has two nodes
            if( workingCopiedRef.numItems == TWO_DATA_ITEMS )
               {
                // set wkg ref numItems
                wkgRef.numItems = workingCopiedRef.numItems;
                  
                // set left and right data
                wkgRef.leftData = workingCopiedRef.leftData;
                wkgRef.rightData = workingCopiedRef.rightData;
                  
                // call recursion to the middle,
                // assigning result to the middle child of the new node
                wkgRef.centerChildRef = copyConstructorHelper​( 
                                              workingCopiedRef.centerChildRef );
               
            
                // set the parent if not null
                if( workingCopiedRef.centerChildRef != null )
                   {
                    wkgRef.centerChildRef.parentRef = wkgRef;
                   }
               }

            // call recursion to the right,
            // assigning result to the right child of the new node
            wkgRef.rightChildRef = copyConstructorHelper​( 
                                               workingCopiedRef.rightChildRef );
            
            // set the parent if not null
            if( workingCopiedRef.rightChildRef != null )
               {
                workingCopiedRef.rightChildRef.parentRef = workingCopiedRef;
               }
           }
        // return the new local reference, either null or with node
        return wkgRef;
       }
    
    
    /* addAndOrganizeData    
     * Description:
     *   Method is called when addItemHelper arrives at the bottom of the 2-3 
     *   search tree (i.e., all node's children are null);
     * Note:
     *   Assumes one- or two- value nodes and adds one more to the appropriate 
     *   one resulting in a two- or three- value node
     * Parameters:
     *   @param localRef - TwoThreeNodeClass reference has original node data 
     *                     and contains added value when method completes; 
     *                     method does not manage any node links
     *   @param itemStr - String value to be added to 2-3 node
     */
    private void addAndOrganizeData​(  TwoThreeNodeClass localRef, 
                                      String itemStr )
       {
            // if there is only one val already in node
            if( localRef.numItems == ONE_DATA_ITEM )
               {
                // if it is greater than the center val
                if( compareStrings​( localRef.centerData, itemStr ) < 0 )
                   {
                    // add it to the right
                    localRef.rightData = itemStr;
                    
                    localRef.leftData = localRef.centerData;

                   }
                
                // else, assume it it less than
                else
                   {
                    // add it to the left
                    localRef.leftData = itemStr;
                    
                    localRef.rightData = localRef.centerData;
                   }
                localRef.centerData = null;
               }
            
            // else, assume two vals in the node
            else
               {
                // if left < itemStr < right
                if( compareStrings​( localRef.leftData, itemStr ) < 0 && 
                    compareStrings​( localRef.rightData, itemStr ) > 0 )
                   {
                    // put itemStr in the middle
                    localRef.centerData = itemStr;
                   }
                  
                // else if right < itemStr
                else if( compareStrings​( localRef.rightData, itemStr ) < 0 ) 
                   {
                    // put right in the middle
                    localRef.centerData = localRef.rightData;
                  
                    // put item to the right
                    localRef.rightData = itemStr;
                   }
                  
                // else, assume left > item
                else
                   {
                    // put left in middle
                    localRef.centerData = localRef.leftData;
                  
                    // put item in left
                    localRef.leftData = itemStr;
                   }
               }
            // call fixUpInsert to fix the three data items in one node issue 
            fixUpInsert​( localRef );
       }
    
    
    /* addItem    
     * Description:
     *   Adds item to 2-3 tree using addItemHelper as needed
     * Parameters:
     *   @param itemStr - String value to be added to the tree
     */
    public void addItem​( String itemStr )
       {
        // call helper to add item
        addItemHelper​( root, itemStr );
       }
    
    
    /* addItemHelper    
     * Description:
     *   Helper method searches from top of tree to bottom using divide and 
     *   conquer strategy to find correct location (node) for new added value; 
     *   once location is found, item is added to node using addAndOrganizeData 
     *   and then fixUpInsert is called in case the updated node has become a 
     *   three-value node
     * Parameters:
     *   @param localRef - TwoThreeNodeClass reference to the current item at 
     *                     the same given point in the recursion process
     *   @param itemStr - String value to be added to the tree
     */
    private void addItemHelper​( TwoThreeNodeClass localRef, String itemStr ) 
       {
        // if it is empty
        if( root == null )
           {
            // set new val to tree root
            root = new TwoThreeNodeClass( itemStr );
           }
        
        // else, assume not empty
        else
           {
            // check if there are any children
            if( localRef.leftChildRef != null || localRef.centerChildRef != null
                || localRef.rightChildRef != null )
               {
                // check if one data items
                if( localRef.numItems == ONE_DATA_ITEM )
                   {
                    // check if search str < center data
                    if( compareStrings​( localRef.centerData, itemStr ) > 0 )
                       {
                        // if left child is null
                        if( localRef.leftChildRef == null )
                           {
                            // call addAndOrganize
                            addAndOrganizeData​( localRef, itemStr );
                           }
                        // else, assume not null
                        else
                           {
                            // call recursion to the left
                            addItemHelper​( localRef.leftChildRef, itemStr );
                           }
                       }
                    // else, assume str is > center data
                    else
                       {
                        // if right child is null
                        if( localRef.rightChildRef == null )
                           {
                            // call addAndOrganize
                            addAndOrganizeData​( localRef, itemStr );
                           }
                        // else, assume not empty
                        else
                           {
                            // call recursion to the right
                            addItemHelper​( localRef.rightChildRef, itemStr );
                           }
                       }
                   }
                // else, assume two data items
                else
                   {
                    // if str < leftData
                    if( compareStrings​( localRef.leftData, itemStr ) > 0 )
                       {
                        // if left child is null
                        if( localRef.leftChildRef == null )
                           {
                            // call addAndOrganize
                            addAndOrganizeData​( localRef, itemStr );
                           }
                        // else, assume not null
                        else
                           {
                            // call recursion to the left
                            addItemHelper​( localRef.leftChildRef, itemStr );
                           }
                       }
                    // else if str > rightData
                    else if( compareStrings​( localRef.rightData, itemStr ) < 0 )
                       {
                        // if right child is null
                        if( localRef.rightChildRef == null )
                           {
                            // call addAndOrganize
                            addAndOrganizeData​( localRef, itemStr );
                           }
                        // else, assume not empty
                        else
                           {
                            // call recursion to the right
                            addItemHelper​( localRef.rightChildRef, itemStr );
                           }
                       }
                    // else, assume center
                    else
                       {
                        // if center child is null
                        if( localRef.centerChildRef == null )
                           {
                            // call addAndOrganize
                            addAndOrganizeData​( localRef, itemStr );
                           }
                        // else, assume not empty
                        else
                           {
                            // call recursion to the middle
                            addItemHelper​( localRef.centerChildRef, itemStr );
                           }
                       }
                   }
               }
            // else, assume no children
            else
               {
                // call addAndOrganizeData
                addAndOrganizeData​( localRef, itemStr );
               }
           }
       }
    
    
    /* clear    
     * Description:
     *   Method clears tree so that new items can be added again
     */
    public void clear()
       {
        // clears tree
        root = null;
       }
    
    
    /* compareStrings
     * Description:
     *   Compares two strings
     * Note:
     *   Returns value greater than zero if left string greater than right
     *   Returns value less than zero if left string less than right string
     *   Returns zero if strings are equal
     * Parameters:
     *   @param leftStr - String to be compared
     *   @param rightStr - String to be compared
     * Returns:
     *   @returm integer result of test as specified
     */
    public int compareStrings​( String leftStr, String rightStr ) 
       {
        // initialize variables
        int difference, index = 0;
        
        // tests if one of the strings is null, returns the other as greator
        if( leftStr == null )
           {
            return -1;
           }
        if( rightStr == null )
           {
            return 1;
           }
        
        // loop across string
        while( index < leftStr.length() && index < rightStr.length() )
           {
            // set the difference
            difference = leftStr.charAt( index ) - rightStr.charAt( index );
            
            // if difference is not 0
            if( difference != 0 )
               {
                // return it
                return difference;
               }
            // increment index
            index++;
           }
        // return result
        return leftStr.length() - rightStr.length();
       }
    
    
    /* fixUpInsert   
     * Description:
     *   Method used to fix tree any time a three-value node has been added to 
     *   the bottom of the tree; it is always called but decides to act only if 
     *   it finds a three-value node
     *   
     *   Resolves current three-value node which may add a value to the node 
     *   above; if the node above becomes a three-value node, then this is 
     *   resolved with the next recursive call
     *   
     *   Recursively climbs from bottom to top of tree resolving any three-value 
     *   nodes found
     * Parameters:
     *   @param localRef - TwoThreeNodeClas reference initially given the 
     *                     currently updated node, then is given parent node 
     *                     recursively each time a three-value node was resolved
     */
    private void fixUpInsert​( TwoThreeNodeClass localRef )
       {  
        // check for three item node
        if( localRef.numItems == THREE_DATA_ITEMS )
           {
            // check for at root ref
            if( localRef == root )
               { 
                // set the left child to special constructor with select left
                localRef.leftChildRef = new TwoThreeNodeClass( 
                                  TwoThreeNodeClass.LEFT_CHILD_SELECT, 
                                  localRef );
                  
                // set the right child to special constructor with select right
                localRef.rightChildRef = new TwoThreeNodeClass(
                                 TwoThreeNodeClass.RIGHT_CHILD_SELECT, 
                                 localRef );
               }
            
            // else if check for one node
            else if( localRef.parentRef.numItems == ONE_DATA_ITEM )
               {
                // make it a two node
                localRef.parentRef.numItems = TWO_DATA_ITEMS;
                  
                // check if it is a left child
                if( localRef == localRef.parentRef.leftChildRef )
                   {
                    // call addAndOrganizeData with centerData and parentRef
                    addAndOrganizeData​( localRef.parentRef, 
                                        localRef.centerData );
                   }
                  
                // else, assume it is a right child
                else
                   {
                    // call addAndOrganizeData with centerData and parentRef
                    addAndOrganizeData​( localRef.parentRef, 
                                        localRef.centerData );
                   }
               }
            
            // else, assume two node
            else
               {
                // check if it is a left child
                if( localRef == localRef.parentRef.leftChildRef )
                   {
                    // call addAndOrganizeData with centerData and parentRef
                   }
                  
                // else if check for being a center child
                else if( localRef == localRef.parentRef.centerChildRef )
                   {
                    // call addAndOrganizeData with centerData and parentRef
                    addAndOrganizeData​( localRef.parentRef, localRef.centerData );
                   }
                  
                // else, assume it is a right child
                else
                   {
                    // call addAndOrganizeData with centerData and parentRef
                    addAndOrganizeData​( localRef.parentRef, localRef.centerData );
                   }
               }
           }
       }

    
    
    /* foundInNode    
     * Description:
     *   Tests center value if single node, tests left and right values if 
     *   two-value node; returns true if specified data is found in any given 
     *   node
     * Note: 
     *   Method does not use any branching operations such as if/else/etc.
     * Parameters:
     *   @param localRef - TwoThreeNodeClass reference to node with one or two 
     *                     data items in it
     *   @param searchStr - String value to be found in given node
     * Returns:
     *   @return boolean result of test
     */
    private boolean foundInNode​( TwoThreeNodeClass localRef, String searchStr )
       {
        // returns if string is in a node
        return searchStr == localRef.leftData ||
               searchStr == localRef.centerData || 
               searchStr == localRef.rightData;
       }

    
    
    /* inOrderTraversal   
     * Description:
     *   Public method called by user to display data in order
     * Returns:
     *   String result to be displayed and/or analyzed
     */
    public String inOrderTraversal()
       {
        // set outputString to empty
        outputString = "";
        
        // call helper to set outputString
        inOrderTraversalHelper​( root );
        
        // return outputString
        return outputString;
       }
    
    
    /* inOrderTraversalHelper    
     * Description:
     *   Helper method conducts in order traversal with 2-3 tree
     * Note:
     *   Shows location of each value in a node: "C" at center of single node
     *   "L" or "R" at left or right of two-value node
     * Parameters:
     *   @param localRef - TwoThreeNodeClass reference to current location at 
     *                     any given point in the recursion process
     */
    private void inOrderTraversalHelper​( TwoThreeNodeClass localRef )
       {
        // check for one data item
        if( localRef.numItems == ONE_DATA_ITEM )
           {
            // if left is not null
            if( localRef.leftChildRef != null)
               {
                // call recursion left
                inOrderTraversalHelper​( localRef.leftChildRef );
               }
            // add centerData to output
            outputString += localRef.centerData;
            
            // if right not null
            if( localRef.rightChildRef != null )
               {
                // call recursion to the right
                inOrderTraversalHelper​( localRef.rightChildRef );
               }
           }
        // else if two data items
        else if( localRef.numItems == TWO_DATA_ITEMS )
           {
            // if left not null
            if( localRef.leftChildRef != null )
               {
                // call recursion to the left
                inOrderTraversalHelper​( localRef.leftChildRef );
               }
          
            // add leftData to output
            outputString += localRef.leftData;
          
            // if center not null
            if( localRef.centerChildRef != null )
               {
                // call recursion to the center
                inOrderTraversalHelper​( localRef.centerChildRef );
               }
            
            // add rightData to output
            outputString += localRef.rightData;
          
            // if right not null
            if( localRef.rightChildRef != null )
               {
                // call recursion to the right
                inOrderTraversalHelper​( localRef.rightChildRef );
               }
           }
       }
    
    
    /* search    
     * Description:
     *   Search method used by programmer to find specified item in 2-3 tree
     * Parameters:
     *   @param searchStr - String value to be found in tree
     * Returns:
     *   @return boolean result of search effort
     */
    public boolean search​( String searchStr )
       {
        // return search result
        return searchHelper​( root, searchStr );
       }
    
    
    /* searchHelper
     * Description:
     *   Search helper method that traverses through tree in a recursive divide 
     *   and conquer search fashion to find given integer in 2-3 tree
     * Parameters:
     *   @param localRef - TwoThreeNodeClass reference to given node at any 
     *                     point during the recursive process
     *   @param searchStr - String value to be found in tree
     * Returns:
     *   @return boolean result of search effort
     */
    private boolean searchHelper​( TwoThreeNodeClass localRef, String searchStr )
       {
        // if not empty
        if( root != null )
           {
            // check if the search val is one of the two vals
            if( foundInNode​( localRef, searchStr ) )
               {
                // return found
                return true;
               }
            // is search < center
            if( compareStrings​( localRef.centerData, searchStr ) > 0 && 
                localRef.rightChildRef != null )
               {
                // recurse left
                return searchHelper​( localRef.leftChildRef, searchStr );
               }
            // else if there is a center ref
            if( localRef.leftChildRef != null && 
                compareStrings​( localRef.leftChildRef.centerData, 
                                searchStr ) > 0 && 
                localRef.rightChildRef != null &&
                compareStrings​( localRef.rightChildRef.centerData,
                                searchStr ) < 0)
               {
                // recurse center
                return searchHelper​( localRef.centerChildRef, searchStr );
               }
            // else if search > center
            else if( compareStrings​( localRef.centerData, searchStr ) < 0 && 
                     localRef.rightChildRef != null )
               {
                // recurse right
                return searchHelper​( localRef.rightChildRef, searchStr );
               }
            // else, assume search = local
            else
               {
                // return found
                return true;
               }
           }
        // return not found
        return false;
       }
   }
