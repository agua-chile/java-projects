package LL;

public class LL_StackClass
   {
    // initialize class variables
    LL_IteratorClass stackData = new LL_IteratorClass();
    
    /* default constructor   
     * Description:
     *   Default constructor
     */
    public LL_StackClass()
       {
        // set default variables
        stackData.headRef = null;
        stackData.currentRef = null;
       }
    
    
    /* initialization constructor   
     * Description:
     *   Copy constructor
     * Parameters:
     *   @param copied - LL_StackClass object to be copied
     */
    public LL_StackClass( LL_StackClass copied )
       {
        // set copied vals
        stackData = new LL_IteratorClass( copied.stackData );
       }
    
    
    /* clear   
     * Description:
     *   Clears all data
     */
    public void clear()
       {
        // clear stack
        stackData.clear();
       }
    
    
    /* isEmpty   
     * Description:
     *   checks for empty stack
     * Returns:
     *   @return Boolean result of test
     */
    public boolean isEmpty()
       {
        // returns whether empty or not
        return stackData.isEmpty();
       }
    
    
    /* peekTop   
     * Description:
     *   Returns data from top of stack without removing
     * Returns:
     *   @return integer value at top of stack
     */
    public int peekTop()
       {
        // returns top val
        return stackData.headRef.data;
       }
    
    
    /* pop   
     * Description:
     *   Removes data from top of stack
     * Returns:
     *   @return integer value at top of stack
     */
    public int pop() // pop head or after head?
       {
        // initialize variables
        int returnVal = stackData.NOT_FOUND;
        
        // if not empty
        if( !isEmpty() )
           {
            // set return val
            returnVal = stackData.headRef.data;
            
            // pop top val
            stackData.headRef = stackData.headRef.nextRef;
           }
        // return returnVal
        return returnVal;
       }
    
    
    /* push   
     * Description:
     *   Places data at top of stack
     * Parameters:
     *   @param value - integer value to be pushed onto stack
     */
    public void push​( int value )
       {
        // push new data
        stackData.insertAtFront​( value );
       }
   }
