package BST;

public class StudentClassNode 
   {
    // initialize variables
    int studentID;
    String name;
    char gender;
    double GPA;
    StudentClassNode leftChildRef, rightChildRef;


    // default constructor
    public StudentClassNode()
       {
        this.name = "";
        this.studentID = 0;
        this.gender = ' ';
        this.GPA = 0.0;
        this.leftChildRef = null;
        this.rightChildRef = null;
       }

    // initialization constructor
    public StudentClassNode( String inName, int inStudentID, char inGender, double inGPA )
       {
        this.name = inName;
        this.studentID = inStudentID;
        this.gender = inGender;
        this.GPA = inGPA;
        this.leftChildRef = null;
        this.rightChildRef = null;
       }

    // copy constructor
    public StudentClassNode( StudentClassNode copied )
       {
        this.name = copied.name;
        this.studentID = copied.studentID;
        this.gender = copied.gender;
        this.GPA = copied.GPA;
        this.leftChildRef = copied.leftChildRef;
        this.rightChildRef = copied.rightChildRef;
       }
   }
