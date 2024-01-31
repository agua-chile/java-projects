package OpCode;

// OpCodeClass is a basic class that holds an integer value.
public class OpCodeClass 
   {
    // class variable
    private int value;


    // default constructor
    public OpCodeClass() 
       {
        this.value = 0;
       }

    // constructor
    public OpCodeClass( int value ) 
       {
        this.value = value;
       }

    // copy constructor
    public OpCodeClass( OpCodeClass other ) 
       {
        this.value = other.value;
       }


    // getter
    public int getValue() 
       {
        return value;
       }

    // setter
    public void setValue( int value ) 
       {
        this.value = value;
       }

    // compare to another OpCodeClass object
    public int compareTo( OpCodeClass other ) 
       {
        if( this.value == other.value ) 
           {
            return 0;
           }
        else if( this.value < other.value ) 
           {
            return -1;
           }
        else 
           {
            return 1;
           }
       }

    // to string
    public String toString() 
       {
        return "" + value;
       }
   }
