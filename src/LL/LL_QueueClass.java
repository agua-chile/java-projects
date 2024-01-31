package LL;

public class LL_QueueClass extends LL_IteratorClass
   {
    /* default constructor   
     * Description:
     *   Default constructor
     */
    public LL_QueueClass()
       {
        // set default variables
        headRef = null;
        currentRef = null;
       }
    
    
    /* initialization constructor   
     * Description:
     *   Copy constructor
     * Parameters:
     *   @param copied - LL_QueueClass object to be copied
     */
    public LL_QueueClass( LL_QueueClass copied )
       {
        // initialize copied variables
        headRef = new NodeClass( copied.headRef );
        currentRef = new NodeClass( copied.currentRef );
        
        // initialize variables
        NodeClass wkgRef = new NodeClass( copied.headRef ), 
                  copiedWkgRef = copied.headRef; 
        
        while( copiedWkgRef.nextRef != null )
           {
            wkgRef.nextRef = new NodeClass( copiedWkgRef.nextRef );
            wkgRef = wkgRef.nextRef;
            copiedWkgRef = copiedWkgRef.nextRef;
           }
       }
    
    
    /* clear   
     * Description:
     *   Clears queue
     * Overrides:
     *   clear in class LL_IteratorClass
     */
    @Override
    public void clear()
       {
        // clear queue
        headRef = null;
       }
    
    
    /* dequeue   
     * Description:
     *   Dequeues data, returns
     * Returns:
     *   @return integer value from queue
     */
    public int dequeue()
       {
        // initialize variables
        int returnVal = NOT_FOUND;
        
        if( !isEmpty() )
           {
            // set return val
            returnVal = headRef.data;
           
            // dequeues first item
            headRef = headRef.nextRef;
           }
        // return not found
        return returnVal;
       }
    
    
    /* enqueue   
     * Description:
     *   Enqueues data
     * Parameters:
     *   value - integer value to enqueued
     */
    public void enqueue​( int value )
       {
        // insert val at end
        insertAtEnd​( value );
       }
    
    
    /* isEmpty   
     * Description:
     *   Checks for empty
     * Overrides:
     *   isEmpty in class LL_IteratorClass
     * Returns:
     *   @return Boolean result of test
     */
    @Override
    public boolean isEmpty()
       {
        // return if empty or not
        return headRef == null;
       }
    
    
    /* peekFront   
     * Description:
     *   Views value at front of queue
     * Returns:
     *   integer value at front of queue
     */
    public int peekFront()
       {
        // if not empty
        if( !isEmpty()  )
           {
            // return front
            return headRef.data;
           }
        // return not found
        return NOT_FOUND;
       }
   }
