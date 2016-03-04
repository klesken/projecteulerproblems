/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteulerproblems;
/*
We define a block to be a rectangle with a height of 1 and an integer-valued length. Let a castle be a configuration of stacked blocks.

Given a game grid that is w units wide and h units tall, a castle is generated according to the following rules:

Blocks can be placed on top of other blocks as long as nothing sticks out past the edges or hangs out over open space.
All blocks are aligned/snapped to the grid.
Any two neighboring blocks on the same row have at least one unit of space between them.
The bottom row is occupied by a block of length w.
The maximum achieved height of the entire castle is exactly h.
The castle is made from an even number of blocks.
The following is a sample castle for w=8 and h=5:

Let F(w,h) represent the number of valid castles, given grid parameters w and h.

For example, F(4,2) = 10, F(13,10) = 3729050610636, F(10,13) = 37959702514, and F(100,100) mod 1 000 000 007 = 841913936.

Find (F(1012,100) + F(10000,10000) + F(100,1012)) mod 1 000 000 007.


https://projecteuler.net/problem=502
*/
/**
 * 1 000 000 000 000
 * @author vikka994
 */

public class Problem502 implements ProjectEulerProblem{
    private long solution;
    private final int pNr = 502; //Number of problem
    @Override
    public int problem() {
        return pNr;
    }

    @Override
    public void solution() {
        System.out.println("The solution to Problem" + problem() + " is: " + solution + " intMax="+Integer.MAX_VALUE + "  | longMax="+ Long.MAX_VALUE);
    }

    @Override
    public void solve() {
        UtilityClass.startTimer();
        
        int width = 4;
        int height = 2;
        long numberOfValidCastles;
        mainGrid = new GameGrid(width, height);
        numberOfValidCastles = mainGrid.solveGrid();
        
        
        UtilityClass.endTimer(this);
    }
    
    private static class Unit{
        private long unit;
        
        Unit(int i){
            unit = i;
        }
        
        public Unit setValue(long i){
            unit = i;
            return this;
        }
        
        public long value(){
            return unit;
        }
        
        public static final Unit ONE = new Unit(1);
        public static final Unit ZERO = new Unit(0);

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 73 * hash + (int) (this.unit ^ (this.unit >>> 32));
            return hash;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Unit other = (Unit) obj;
            return this.unit == other.unit;
        }
        
        
        
    }
    

    enum GridType{ EMPTYSPACE, BLOCK, SPACEAFTERBLOCK };
    private interface GridElement{
        public GridType type();
    }
        
    /*
    We define a block to be a rectangle with a height of 1 and an integer-valued length
    */
    private class Block implements GridElement{
        //private final int elementType = 1;
        @Override
        public GridType type(){
            return GridType.BLOCK; //type Block
        }
        
        private final Unit height = Unit.ONE;
        private Unit width;
        
        
        Block(int length){
            width = new Unit(length);
        }
        
        public Unit h(){
            return height;
        }
        public Unit w(){
            return width;
        }
        
        
    }
    
    /*
    We define a block to be a rectangle with a height of 1 and an integer-valued length
    */
    private class EmptySpace implements GridElement{

        //private final int elementType = 2;
        @Override
        public GridType type(){
            return GridType.EMPTYSPACE; //type EmptySpace
        }

    }
    
    private class SpaceAfterBlock implements GridElement{
        @Override
        public GridType type(){
            return GridType.SPACEAFTERBLOCK; //type SpaceAfterBlock
        }

        private final Unit height = Unit.ONE;
        private final Unit width = Unit.ONE;
                
        public final Unit h(){
            return height;
        }
        public final Unit w(){
            return width;
        }        
        
    }
    
    /*
    game grid that is w units wide and h units tall
    */
    private class GameGrid{
        private final Unit width, height;
        private long numberOfValidCastles = 0;
        
        private Block[] possibleBlocks; //If width=10 we will have blocks of width 10,9,8,...,2,1
        
        /*
        if calculatedCastles[x][y] > 0 then a castle of size x width and y height has been calculated
        calculatedCastles doesn't take into account conditions:
        (3)
        */
        private long[][] calculatedCastles;
        
        /*
        GameGrid visualization
        empty = EmptySpace
        _ = SpaceAfterBlock
        X = Filled by a block
           3 [][][][][]
           2 [][][][][]
           1 [X][_][][][]
           0 [X][X][_][X][X]
             0 1 2 3 4
        */  
        private GridElement[][] gameMatrix;
        
        //GameGrid(){ width = Unit.ONE; height = Unit.ONE; gameMatrix = new Block[1][1]; }
        GameGrid(int width, int height){
            this.width = new Unit(width);
            this.height = new Unit(height);
            gameMatrix = new EmptySpace[width][height];
            gameMatrix[0][0] = new Block(width); //Fill the bottom row with 1 block
            calculatedCastles = new long[width+1][height+1];
            possibleBlocks = new Block[width];
            for(int i = 0; i < width; i++){
                possibleBlocks[i] = new Block(width - i);
            }
        }
        
        public long solveGrid(){
            //for(long x = 1; x <= width.value(); x++){
                //for(long y = 1; y <= height.value(); y++){
                    
                //}
            //}

            /*
            Rewrite whole file with a cleaner mind
            
            When dividing up the grid need to keep track of if the smaller grid solution is
            even or uneven. Since even+even and uneven+uneven = even.
            But even+uneven = uneven.
            
            Also if the solution reaches height H etc.
            
            So basically create a Solution() class which holds:
            grid width
            grid height
            how many solutions are even
            how many solutions are uneven
            how many solutions are even and reaches height H
            how many solutions are uneven and reaches height H
            
            only use array, if two items are horizontally next to eachother [X][Z] and [Y][Z] where Y = X+1 then they are part of the same block
            
            So basically start with 1xMAX_HEIGHT, then go to 2xMAX_HEIGHT
            1xMAX_HEIGHT will solve all "grids" between 1x1 and 1xMAX_HEIGHT
            
            When you go onto 2xMAX_HEIGHT you will already know every 1xX and can use that information
            to move forward. When you then know 2xMAX_HEIGHT, you go to 3xMAX_HEIGHT etc.
            
            So one loop focuses on moving forward horizontally and one focuses on how you can combine already known
            horizontal sizes to produce different "sub-castles", i.e. 4xMAX_HEIGHT can contain 1 2xY and 1 1xY and combine this 2 different ways
            and it can of course also contain a 4xY.
            
            
            
            
            
            */
 
            //Create base cases for calculating how many castles are possible
            calculatedCastles[1][1] = 1;
            calculatedCastles[1][2] = 1;
            calculatedCastles[2][1] = 2;
            calculatedCastles[2][2] = 2;
            
            //Partition grid into smaller grids, until you reach one of the base cases, then recursively start solving
            int wIndex = (int)width.value();
            int hIndex = (int)height.value();
            long sum = 0;
            while(calculatedCastles[(int)width.value()][(int)height.value()] == 0){
                //The super loop that is supposed to do it all
                
                if(calculatedCastles[wIndex][hIndex] > 0){
                    sum += calculatedCastles[wIndex][hIndex];
                }
                else{
                    wIndex /= 2;
                    
                }
                
                
            }
            
            
            return numberOfValidCastles;
        }
        
        
        
        
        

        
        
         
    }
         

/*
Castle building plan:
    Create "base" blocks, i.e. the largest to smallest possible blocks on each row
    First fill the grid with the largest possible combination
    Then make the upper most block smaller 
    When it is so small that removing it destroys condition (5) 
    move to the previous row and restart the algorithm while always adding a block on top to revive condition (5)
    
    
    Alternative algorithm, (trying this first):
    Divide the grid into smaller grids and work your way up with placing blocks.
    i.e. a 3x3 grid contains 1x1, 1x2, 2x1, etc.
    1x2 grid only has 1 solution since height must always be H
    2x2 grid only has 2 solutions since height must always be H and a space between two blocks on same row must exist
    ...
    
    
    Work out exactly how the size of grids within a grid interact with the whole grid.
    IMPORTANT to remember the (6) condition
    

    We know(probably):
    This problem can probably be solved very elegantly with combinatoric math
    All castles start with 1 block(the bottom one)
    A "base block" has a fixed amount of ways to build on top of it
    Since the base block always exist, we can say that a 10x10 grid is actually a 10x9 grid with an uneven number of blocks to begin
    
    
    DO ALL COMPUTATIONS WITHIN CASTLE CLASS!!!
*/
/*
1.Blocks can be placed on top of other blocks as long as nothing sticks out past the edges or hangs out over open space.
2.All blocks are aligned/snapped to the grid.
3.Any two neighboring blocks on the same row have at least one unit of space between them.
4.The bottom row is occupied by a block of length w.
5.The maximum achieved height of the entire castle is exactly h.
6.The castle is made from an even number of blocks.


    
    */
    
    private static GameGrid mainGrid = null;
    
    private class Castle{
        
        private Unit width, height;
        
        
        Castle(int width, int height){
            this.width = new Unit(width);
            this.height = new Unit(height);
        }
        

        
        /*
        Creates the next castle in line
        
        */
        public boolean nextCastle(){
            
            return true;
        }
        
        
        /*
        Grid into smaller grid solution
        */
        
        /**
         * Tries to add a block to the GameGrid
         * @param block the block to be added to the GameGrid
         * 
         * @return
         * true if block was added
         * false if block was not added
         */
        public boolean addBlock(Block block){
            return true;
        }
    }        




}


