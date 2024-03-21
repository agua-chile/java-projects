package OpCode;

import java.util.Scanner;

public class OpCodeDriver 
   {
    // main method to be called by app
    public static void OpCodeMain( Scanner scanner ) 
       {
        // initialize variables
        int choice = 0, priorityIn, numCyclesIn, queueEntryIn;

        // display program
        System.out.println( "OpCode Stuff" );
        System.out.println( "--------------------------------------------------" );
        System.out.println( "This program will allow you to add and remove " + 
                            "OpCodeClass objects to an OpCodeHeapClass object." );
        System.out.println( "--------------------------------------------------" );

        // create OpCodeHeapClass object
        OpCodeHeapClass opCodeHeap = new OpCodeHeapClass( true );

        // input menu
        while( choice != 3 ) 
           {
            System.out.println( "\nMenu:" );
            System.out.println( "1. Add OpCodeClass object" );
            System.out.println( "2. Display OpCodeHeapClass" );
            System.out.println( "3. Exit" );
            System.out.print( "Enter your choice: " );
            choice = scanner.nextInt();

            switch( choice )
               {
                case 1:
                    // Add OpCodeClass object
                    System.out.print( "Enter the priority: " );
                    priorityIn = scanner.nextInt();
                    System.out.print( "Enter the number of cycles: " );
                    numCyclesIn = scanner.nextInt();
                    System.out.print( "Enter the queue entry value: " );
                    queueEntryIn = scanner.nextInt();
                    OpCodeClass newOpCode = new OpCodeClass( priorityIn, numCyclesIn, queueEntryIn );
                    opCodeHeap.addItem( newOpCode );
                    break;
                case 2:
                    // Display OpCodeHeapClass
                    opCodeHeap.showArray();
                    break;
                case 3:
                    // Exit
                    System.out.println( "Exiting OpCodes..." );
                    break;
                default:
                    System.out.println( "Invalid choice. Please try again." );
                    break;
               }
           }
       }
   }
