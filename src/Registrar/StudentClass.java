package Registrar;

public class StudentClass 
   {
    // initialize variables
    int studentID;
    String name;
    char gender;
    double GPA;


    // default constructor
    public StudentClass()
       {
        this.name = "";
        this.studentID = 0;
        this.gender = ' ';
        this.GPA = 0.0;
       }

    // initialization constructor
    public StudentClass( String inName, int inStudentID, char inGender, double inGPA )
       {
        this.name = inName;
        this.studentID = inStudentID;
        this.gender = inGender;
        this.GPA = inGPA;
       }

    // copy constructor
    public StudentClass( StudentClass copied )
       {
        this.name = copied.name;
        this.studentID = copied.studentID;
        this.gender = copied.gender;
        this.GPA = copied.GPA;
       }


    // compare to another student
    public int compareTo( StudentClass other ) 
       {
        if( this.studentID == other.studentID ) 
           {
            return 0;
           }
        else if( this.studentID < other.studentID ) 
           {
            return -1;
           }
        else 
           {
            return 1;
           }
       }
   }
