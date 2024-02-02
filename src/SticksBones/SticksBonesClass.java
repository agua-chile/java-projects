package p1_package;

/**
 * Class manages two dimensional array of sticks or bones; 
 * includes one dimensional array of sticks
 * and one dimensional array of bones
 * <p>
 * The limit on number of sticks is 25 per cent of array height
 * and the limit on number of bones is 25 per cent of array width
 * 
 * @author Michael Leverington
 *
 */
public class SticksBonesClass
   {
    /**
     * Constant, default two dimensional array sides
     */
    private static final int TWO_DIM_ARRAY_SIDE = 50;
       
    /**
     * constant, stick and bone percentage of side length
     */
    private static final double STICK_BONE_PERCENTAGE = 0.25;

    /**
     * constant, horizontal line character
     */
    private static final char HORIZ_LINE = '-';
    
    /**
     * constant, vertical line character
     */
    private static final char VERTICAL_LINE = '|';
    
    /**
     * Master array of sticks and bones
     */
    public CellClass[][] fieldArray;
    
    /**
     * Array of sticks
     */
    private ArtifactClass[] stickArray;
    
    /**
     * height of cell array
     */
    public int fieldArrayHeight;
    
    /**
     * width of cell array
     */
    public int fieldArrayWidth;
    
    /**
     * Number of sticks
     */
    private int numSticks;
    
    /**
     * Array of bones
     */
    private ArtifactClass[] boneArray;
    
    /**
     * Number of bones
     */
    private int numBones;
    
    /**
     * Default constructor
     * <p>
     * Initializes class with random sticks and bones in square array;
     * arrays use default capacities
     */
    public SticksBonesClass()
       {
        this( TWO_DIM_ARRAY_SIDE, TWO_DIM_ARRAY_SIDE );
       }
    
    /**
     * Initialization constructor
     * <p>
     * Initializes class with random sticks and bones;
     * arrays use parameter capacities
     * 
     * @param height integer number of rows in two dimensional array
     * 
     * @param width integer number of columns in two dimensional array
     */
    public SticksBonesClass( int height, int width )
       {
        fieldArrayHeight = height;
        
        fieldArrayWidth = width;
        
        // generate random array
        createRandomStickBoneArray( height, width );
        
        // find sticks, store in array
        findAllSticks();
        
        // find bones, store in array
        findAllBones();
       }
    
    /**
     * Creates a random stick/bone array
     * <p>
     * Random x, y location, with random length of stick or bone
     * between 3 and 6
     * 
     * @param height integer value representing number of rows in array
     * 
     * @param width integer value representing number of columns in array
     */
    // create random stick/bone array
    private void createRandomStickBoneArray( int height, int width )
       {
        int rowIndex, colIndex, locIndex, index = 0;
        int yLoc, xLoc, startLoc = 0;
        int itemLength;
        int minItemLength = 3;
        int maxItemLength = 6;
        int stickCount, boneCount;
        
        fieldArrayHeight = height;
        fieldArrayWidth = width;
        
        // create array of cells
        fieldArray = new CellClass[ fieldArrayHeight ][ fieldArrayWidth ];
        
        for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ )
           {
            for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
               {
                fieldArray[ rowIndex ][ colIndex ] = new CellClass();
               }
           }
        
        // generate between 1/3 of height and full height sticks and bones
        stickCount = generateRandBetween( height / 3, height );
        boneCount = generateRandBetween( height / 3, height );

        boolean createItemSuccess;
        
        while( index < stickCount )
           {
            yLoc = generateRandBetween( startLoc, height - 1 );
            xLoc = generateRandBetween( startLoc, width - 1 );
            itemLength = generateRandBetween( minItemLength, maxItemLength );

            createItemSuccess = true;
            
            for( locIndex = 0; 
                  locIndex < itemLength && createItemSuccess; locIndex++ )
               {
                if( yLoc + locIndex >= height
                      || xLoc >= width
                           || fieldArray[ yLoc + locIndex ][ xLoc ].isUsed() )
                   {
                    createItemSuccess = false;
                   }
               }
            
            if( createItemSuccess )
               {
                for( locIndex = 0; locIndex < itemLength; locIndex++ )
                   {
                    fieldArray[ yLoc + locIndex ][ xLoc ]
                                .setCellCharacter( CellClass.STICK_BONE_CHAR );
                   }

                index++;
               }
           }
        
        index = 0;
        
        while( index < boneCount )
           {
            yLoc = generateRandBetween( startLoc, height - 1 );
            xLoc = generateRandBetween( startLoc, width - 1 );
            itemLength = generateRandBetween( minItemLength, maxItemLength );
            
            createItemSuccess = true;
            
            for( locIndex = 0; 
                  locIndex < itemLength && createItemSuccess; locIndex++ )
               {
                if( xLoc + locIndex >= width
                    || yLoc >= height
                          || fieldArray[ yLoc ][ xLoc + locIndex ].isUsed() )

                   {
                    createItemSuccess = false;
                   }
               }
            
            if( createItemSuccess )
               {
                for( locIndex = 0; locIndex < itemLength; locIndex++ )
                   {
                    fieldArray[ yLoc ][ xLoc + locIndex ]
                                .setCellCharacter( CellClass.STICK_BONE_CHAR );
                   }

                index++;
               }
           }

       }
    
    /**
     * Finds all bones, assigns to bone array
     * <p>
     * May find adjacent crossing stick and count as bone
     */
    public void findAllBones()
       {  
        // initialize variables
        int rowIndex, colIndex, boneLength, xPos, yPos, boneIndex = 0;
        
        // initialize bone array
        boneArray= new ArtifactClass[ fieldArrayHeight * fieldArrayWidth ];
        
        // set number of bones to 0
        numBones = 0;
          
        // loop across rows
        for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ )
           {
            // loop across cols
            for( colIndex = 0; colIndex< fieldArrayWidth; colIndex++ )
               {
                // test if asterisk
                if( colIndex < fieldArrayWidth - 1 && 
                    fieldArray[ rowIndex ][ colIndex ].isUsed() )
                   {
                    // set bone length to 1
                    boneLength = 1;
        
                    // set x + y positions
                    xPos = colIndex;
                    yPos = rowIndex;
                    
                    // test if next val is also bone char
                    if( colIndex < fieldArrayWidth - 1 && 
                        fieldArray[ rowIndex ][ colIndex + 1 ].isUsed() )
                       {
                        // while the next col value is also * and 
                           // index < col length
                        while( colIndex < fieldArrayWidth - 1  &&
                               fieldArray[ rowIndex ][ colIndex + 1 ].isUsed() )
                           {
                            // increment bone length
                            boneLength++;
        
                            // increment col index
                            colIndex++;
                           }
                        // end loop
        
                        // set new bone array val to: x + y location, bone 
                           // and length
                        boneArray[ boneIndex ] = new ArtifactClass( xPos, yPos, 
                                               ArtifactClass.BONE, boneLength );
                        
                        // increment bone index
                        boneIndex++;
                        
                        // increment number of bones
                        numBones++;
                       }
                    // end test for next val an asterisk                       
                   }
                // end test for initial asterisk
               }
            // end col loop
           }
        // end row loop
       }
    
    /**
     * Finds all sticks, assigns to sticks array, 
     * <p>
     * May find adjacent crossing bone and count as stick
     */
    public void findAllSticks()
       {
        // initialize variables
        int rowIndex, colIndex, stickLength, xPos, yPos, stickIndex = 0;
        
        // initialize stick array
        stickArray = new ArtifactClass[ fieldArrayHeight * fieldArrayWidth ];
        
        // set num sticks to 0
        numSticks = 0;
            
        // loop across rows
        for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ )
           {
            // loop across cols
            for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
               {
                // test if asterisk
                if( rowIndex < fieldArrayHeight - 1 
                    && fieldArray[ rowIndex ][ colIndex ].isUsed() )
                   {
                    // set bone length to 1
                    stickLength = 1;
          
                    // set x + y positions
                    xPos = colIndex;
                    yPos = rowIndex;
                      
                    // test if next val is also bone char
                    if( rowIndex < fieldArrayHeight - 1 
                        && fieldArray[ rowIndex + 1 ][ colIndex ].isUsed() )
                       {
                        // while the next col value is also * and 
                           // index < col length
                        while( rowIndex < fieldArrayHeight - 1 && 
                               fieldArray[ rowIndex + 1 ][ colIndex ].isUsed() )
                             {
                              // increment bone length
                              stickLength++;
          
                              // increment row index
                              rowIndex++;
                             }
                        // end loop
          
                        // set new bone array val to: x + y location, bone 
                           // and length
                        stickArray[ stickIndex ] = new ArtifactClass( xPos, 
                                    yPos, ArtifactClass.STICK, stickLength );
                          
                        // increment bone index
                        stickIndex++;
                          
                        // increment number of bones
                        numSticks++;
                       }
                    // end test for next val an asterisk    
                     }
                // end test for initial asterisk
               }
            // end col loop
           }
        // end row loop
       }

    /**
     * Generates random values between given low, high, inclusive
     * 
     * @param low integer value representing low end of random output
     * 
     * @param high integer value representing high end of random output
     * 
     * @return integer random value returned between low and high
     * parameters, inclusive
     */
    public int generateRandBetween( int low, int high )
       {
        int range = high - low + 1;
        
        return (int)( Math.random() * range ) + low;          
       }    

    /**
     * Shows field of sticks and bones, has frame around perimeter
     */
    public void showField()
       {
        // initialize variables
        int index, rowIndex, colIndex;
        
        // print dashes the length of width
        for( index = 0; index < TWO_DIM_ARRAY_SIDE + 1; index++ )
           {
            System.out.print( HORIZ_LINE );
           }
        
        // print end line
        System.out.println();
        
        // loop across rows
        for( rowIndex = 0; rowIndex < fieldArrayHeight; rowIndex++ )
           {
            // print pipe
            System.out.print( VERTICAL_LINE );
          
            // loop across cols
            for( colIndex = 0; colIndex < fieldArrayWidth; colIndex++ )
               {
                // print each value
                System.out.print( fieldArray[ rowIndex ][ colIndex ] );
               }
          
            // print pipe
            System.out.print( VERTICAL_LINE );
          
            // print end line
            System.out.println();
           }
        // end row loop
          
        // print dashes the length of width
        for( index = 0; index < TWO_DIM_ARRAY_SIDE + 1; index++ )
           {
            System.out.print( HORIZ_LINE );
           }
       }
    
    /**
     * Shows bone list, provides results in formatted, aligned output
     * Hint: Google System.out.format
     *  
     */
    public void showBoneList()
       {
        // initialize variables
        int index;
          
        // loop across array
        for( index = 0; index < numBones; index++ ) 
           {
            // print each bone array value
            System.out.print( "Bone at ( " + boneArray[ index ].xPos + ", " + 
            boneArray[ index ].yPos + " ), length is: " + 
            boneArray[ index ].length );
          
            // print end line
            System.out.println();
           }
       }

    /**
     * Shows list of sticks, provides results in formatted, aligned output
     * Hint: Google System.out.format 
     *    
     */
    public void showStickList()
       {
        // initialize variables
        int index;
            
        // loop across array
        for( index = 0; index < numSticks; index++ ) 
           {
            // print each bone array value
            System.out.print( "Stick at ( " + stickArray[ index ].xPos + ", " + 
            stickArray[ index ].yPos + " ), length is: " + 
            stickArray[ index ].length );
            
            // print end line
            System.out.println();
           }
       }
    
   }
