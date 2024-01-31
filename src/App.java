// local imports
import OpCode.OpCodeDriver;
import SudokuGenerator.SudokuGeneratorDriver;

// library imports
import java.util.Scanner;


// main class
public class App 
   {
    public static void main(String[] args) throws Exception 
       {
        // display program
        System.out.println( "=======================================" );
        System.out.println( "| Welcome to my random Java projects! |" );
        System.out.println( "=======================================" );

        // main menu
        Scanner scanner = new Scanner( System.in );
        int choice = 0;
        while( choice != 8 ) 
           {
            // display menu
            System.out.println( "\nMenu:" );
            System.out.println( "1. Binary Search Tree" );
            System.out.println( "2. Generic Queue, Stack, and Iterator" );
            System.out.println( "3. Linked List Queue, Stack, and Iterator" );
            System.out.println( "4. OpCodes" );
            System.out.println( "5. Registrar" );
            System.out.println( "6. Sudoku Generator" );
            System.out.println( "7. Two Three Tree" );
            System.out.println( "8. Exit" );
            System.out.print( "Enter your choice: " );
            
            // get user input and process choice
            choice = scanner.nextInt();
            switch( choice ) 
               {
                case 1:
                    // TODO: implement binary search tree
                    System.out.println( "Binary Search Tree" );
                    break;
                case 2:
                    //  TODO: implement generic queue, stack, and iterator
                    System.out.println( "Generic Queue, Stack, and Iterator" );
                    break;
                case 3:
                    // TODO: implement linked list queue, stack, and iterator
                    System.out.println( "Linked List Queue, Stack, and Iterator" );
                    break;
                case 4:
                    // TODO: opcodes not organizing correctly
                    OpCodeDriver.OpCodeMain( scanner );
                    break;
                case 5:
                    // TODO: implement registrar
                    System.out.println( "Registrar" );
                    break;
                case 6:
                    // TODO: sudoku generator does not generate correctly
                    SudokuGeneratorDriver.SudokuGeneratorMain( scanner );
                    break;
                case 7:
                    // TODO: implement two three tree
                    System.out.println( "Two Three Tree" );
                    break;
                case 8:
                    System.out.println( "Exiting Main Menu..." );
                    break;
                default:
                    System.out.println( "Invalid choice. Please try again." );
                    break;
               }
           }
        // close scanner and exit program
        scanner.close();
        System.out.println( "\nGoodbye!" );
       }
   }