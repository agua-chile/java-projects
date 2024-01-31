package SudokuGenerator;
import java.util.Scanner;

public class SudokuGeneratorDriver 
   {
    public static void SudokuGeneratorMain( Scanner scanner ) 
       {
        // initialize variables
        SudokuGeneratorClass sudoku = null;
        int numEmpties = 0;

        // display program
        System.out.println( "\n\n\nWelcome to my Sudoku Generator!" );
        System.out.println( "--------------------------------------------------" );

        // input menu
        int choice = 0;
        while( choice != 3 ) 
           {
            System.out.println("\nMenu:");
            System.out.println("1. Generate Sudoku");
            System.out.println("2. Display Grid");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch( choice ) 
               {
                case 1:
                    // get number of empty cells
                    System.out.print( "Enter number of empty cells: " );
                    numEmpties = scanner.nextInt();
                    sudoku = new SudokuGeneratorClass();
                    sudoku.createSudoku​( numEmpties, true );
                    break;
                case 2:
                    sudoku.displayGrid();
                    break;
                case 3:
                    System.out.println( "Exiting..." );
                    break;
                default:
                    System.out.println( "Invalid choice. Please try again." );
                    break;
               }
           }
       }
   }