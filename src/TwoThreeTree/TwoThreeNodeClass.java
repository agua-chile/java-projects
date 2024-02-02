package TwoThreeTree;

public class TwoThreeNodeClass 
   {
    // constants
    public static final int LEFT_CHILD_SELECT = 1, RIGHT_CHILD_SELECT = 2;

    // initialize variables
    TwoThreeNodeClass leftChildRef, centerChildRef, rightChildRef, 
                      parentRef, tempLeftRef, tempRightRef;
    int numItems;
    String itemStr, leftData, centerData, rightData; 

    // default constructor
    public TwoThreeNodeClass()
       {
        this.leftChildRef = null;
        this.centerChildRef = null;
        this.rightChildRef = null;
        this.parentRef = null;
        this.numItems = 0;
        this.itemStr = "";
        this.leftData = "";
        this.centerData = "";
        this.rightData = "";
       }

    // initialization constructor
    public TwoThreeNodeClass( String itemStr )
       {
        this.leftChildRef = null;
        this.centerChildRef = null;
        this.rightChildRef = null;
        this.parentRef = null;
        this.numItems = 0;
        this.itemStr = itemStr;
        this.leftData = "";
        this.centerData = "";
        this.rightData = "";
       }

    // special constructor
    public TwoThreeNodeClass( int childSelect, TwoThreeNodeClass localRef )
       {

       }

    // copy constructor
    public TwoThreeNodeClass( TwoThreeNodeClass copied )
       {
        this.leftChildRef = copied.leftChildRef;
        this.centerChildRef = copied.centerChildRef;
        this.rightChildRef = copied.rightChildRef;
        this.parentRef = copied.parentRef;
        this.numItems = copied.numItems;
        this.itemStr = copied.itemStr;
        this.leftData = copied.leftData;
        this.centerData = copied.centerData;
        this.rightData = copied.rightData;
       }
   }
