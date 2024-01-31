package Misc;

public class DL_NodeClass
{
 int data;

 DL_NodeClass prevRef, nextRef;

 public DL_NodeClass( int value )
    {
     data = value;
 
     prevRef = nextRef = null;
    }
}
