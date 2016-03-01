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
        
        Unit test = new Unit(4);
        
        
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
            if (this.unit != other.unit) {
                return false;
            }
            return true;
        }
        
        
        
    }
    
//    private class GridElement{
//        //private final int elementType = 0;
//        public int type(){
//            return 0; //default type
//        }
//    }
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
        }
        

        
        
         
    }
         

/*
Castle building plan:
Place the smallest building blocks first.
Build horizontally first.

    
End iteration when castle has been completely filled.
    We know:
    All castles start with 1 block(the bottom one)
    
*/
/*
1.Blocks can be placed on top of other blocks as long as nothing sticks out past the edges or hangs out over open space.
2.All blocks are aligned/snapped to the grid.
3.Any two neighboring blocks on the same row have at least one unit of space between them.
4.The bottom row is occupied by a block of length w.
5.The maximum achieved height of the entire castle is exactly h.
6.The castle is made from an even number of blocks.


    
    */     
    private class Castle{
        
        
        
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


