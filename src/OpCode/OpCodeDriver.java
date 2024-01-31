package OpCode;

import java.util.Scanner;

public class OpCodeDriver {
    // main method to be called by app
    public static void OpCodeMain( Scanner scanner ) {
        // display program
        System.out.println( "\n\n\nOpCodeClass and OpCodeHeapClass" );
        System.out.println( "--------------------------------------------------" );

        // create OpCodeHeapClass object
        OpCodeHeapClass opCodeHeap = new OpCodeHeapClass( true );

        // input menu
        int choice = 0;
        while (choice != 3) {
            System.out.println("\nMenu:");
            System.out.println("1. Add OpCodeClass object");
            System.out.println("2. Display OpCodeHeapClass");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add OpCodeClass object
                    System.out.print( "Enter the value for OpCodeClass: " );
                    int value = scanner.nextInt();
                    OpCodeClass newOpCode = new OpCodeClass( value );
                    opCodeHeap.addItem( newOpCode );
                    break;
                case 2:
                    // Display OpCodeHeapClass
                    opCodeHeap.showArray();
                    break;
                case 3:
                    // Exit
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
