/* This class should implement the DisplayableMaze interface */
import java.util.*;

// PHASE 1
public class Maze implements DisplayableMaze {
  
   private MazeContents[][] mazeGrid;
   private int height;
   private int width;
   private MazeLocation start;
   private MazeLocation finish;

   //asked ai for debuggin
   public Maze() {
    initDemoMaze();
}

    public int getHeight(){
      return height;
    }
    public int getWidth(){
      return width;

    }
   public MazeContents getContents(int i, int j) {
      return mazeGrid[i][j];
  }

    public MazeLocation getStart(){
      return start;

    }
    public MazeLocation getFinish(){
      return finish;

    }
  

//ask what is it suppose to return 
//can i use else if/if 

   //pseudocode 
      //columns = 8, row = 10 
      //if i is greater than this.height (row) then out of bound 
      //if j is greater than this.width then out of bound
      //if content[i] != # --> not a wall good
      //tracker for a location [1,1] then checks if they did it 
      //ok theyhave a .WALL & .VISITED


      public Boolean isExplorable(int i, int j) {
        // out of bounds check
        if (i < 0 || j < 0) {
            return false;
        }
        if (i >= height || j >= width) {
            return false;
        }
       
        if (mazeGrid[i][j] == MazeContents.WALL) {
            return false;
        }
  
        if (mazeGrid[i][j] == MazeContents.VISITED) {
            return false;
        }
        if (mazeGrid[i][j] == MazeContents.PATH) {
            return false;
        }
        return true;
    }


//Phase 2
public Boolean solve(MazeLocation location) {
  // base case 1:
  if (location.equals(finish)) {
    mazeGrid[location.getRow()][location.getCol()] = MazeContents.PATH;
    return true;
  }
  // base case 2:
  if (isExplorable(location.getRow(), location.getCol()) == false) {
    return false;

  }
  

  //Recursive 
  // how do I mark as visited?
  mazeGrid[location.getRow()][location.getCol()] = MazeContents.VISITED;
  // NEWS 

  //ok so for North --> it goes 1 up    --> row
  //S --> 1 down --> row
  //E --> 1 right?? --> column
  //W --> 1 left?? --> column 

  MazeLocation NORTH = new MazeLocation(location.getRow()-1,location.getCol());
  MazeLocation EAST = new MazeLocation(location.getRow(),location.getCol()+1); 
  MazeLocation WEST = new MazeLocation(location.getRow(),location.getCol()-1);
  MazeLocation SOUTH = new MazeLocation(location.getRow()+1,location.getCol());
//NEWS 
boolean result = solve(NORTH) || solve(EAST) || solve(WEST) || solve(SOUTH);
if (result==false){
  mazeGrid[location.getRow()][location.getCol()] = MazeContents.DEAD_END;
}
else{
  mazeGrid[location.getRow()][location.getCol()] = MazeContents.PATH;
}
return result;
}








  // ## Phase 2: Recursive Solver

  // Implement recursive exploration so the solver returns whether a path exists.
  
  // ### Problem Statement
  
  // Given a maze, determine whether `F` can be reached from `S` by moving only one square at a time in cardinal directions (`NORTH`, `SOUTH`, `EAST`, `WEST`).
  
  // ### Base Cases
  
  // 1. Success case:
  //    - If current location is finish, mark it `MazeContents.PATH` and return `true`.
  // 2. Failure case:
  //    - If current location is not explorable, return `false`.
  
  // ### Recursive Step
  
  // When neither base case applies:
  
  // 1. Mark current location as `MazeContents.VISITED`.
  // 2. Recursively explore neighbors.
  // 3. Combine results with logical OR (`||`).
  // 4. Before returning:
  //    - mark current location `PATH` if any recursive call succeeds,
  //    - otherwise mark it `DEAD_END`.

  // PHASE 2- ask prof hailie
  //Pseudocode : 
  // .=
  // base case 
  // if mazelocation().equals (finish): ok thats better
  // then that location is MAZECONTENTS.PATH  -- dont know how to mark it 


  //mazeGrid[i][j] == MAZECONTENTS.PATH
  //return true  
  // if isExplorable () = false:
  //return false

//mazeGrid[i][j] == MAZECONTENTS.visited
//so for recursive we can onmluexplore things that arent a wall 
//if its a wall then deadend 




// from office hr : 
//




   

    




    /** This DemoMaze method will allow you to generate a simple maze
     * to test your code on as you develop it. Ultimately, you need
     * to accept maze files as command line inputs or standard input.
     * You will need to implement the DisplayableMaze interface before you
     * can run the initDemoMaze method.
     * * @author Tianah Gooden
     * * @version October 17th 2023
     */
    public void initDemoMaze(){ //String fileName, 
      //window of the grid of the maze 
        this.height = 10;
        this.width = 8;
        this.mazeGrid = new MazeContents[height][width];

      //starts from 1, 1 and finish to 8,6
        this.start = new MazeLocation(1,1);
        this.finish = new MazeLocation(8,6);

        this.mazeGrid[0][0] = MazeContents.WALL; this.mazeGrid[0][1] = MazeContents.WALL; this.mazeGrid[0][2] = MazeContents.WALL; this.mazeGrid[0][3] = MazeContents.WALL; this.mazeGrid[0][4] = MazeContents.WALL; this.mazeGrid[0][5] = MazeContents.WALL; this.mazeGrid[0][6] = MazeContents.WALL; this.mazeGrid[0][7] = MazeContents.WALL;
        this.mazeGrid[1][0] = MazeContents.WALL; this.mazeGrid[1][1] = MazeContents.OPEN; this.mazeGrid[1][2] = MazeContents.OPEN; this.mazeGrid[1][3] = MazeContents.OPEN; this.mazeGrid[1][4] = MazeContents.OPEN; this.mazeGrid[1][5] = MazeContents.OPEN; this.mazeGrid[1][6] = MazeContents.WALL; this.mazeGrid[1][7] = MazeContents.WALL;
        this.mazeGrid[2][0] = MazeContents.WALL; this.mazeGrid[2][1] = MazeContents.WALL; this.mazeGrid[2][2] = MazeContents.OPEN; this.mazeGrid[2][3] = MazeContents.WALL; this.mazeGrid[2][4] = MazeContents.WALL; this.mazeGrid[2][5] = MazeContents.OPEN; this.mazeGrid[2][6] = MazeContents.WALL; this.mazeGrid[2][7] = MazeContents.WALL;
        this.mazeGrid[3][0] = MazeContents.WALL; this.mazeGrid[3][1] = MazeContents.OPEN; this.mazeGrid[3][2] = MazeContents.WALL; this.mazeGrid[3][3] = MazeContents.OPEN; this.mazeGrid[3][4] = MazeContents.OPEN; this.mazeGrid[3][5] = MazeContents.OPEN; this.mazeGrid[3][6] = MazeContents.WALL; this.mazeGrid[3][7] = MazeContents.WALL;
        this.mazeGrid[4][0] = MazeContents.WALL; this.mazeGrid[4][1] = MazeContents.OPEN; this.mazeGrid[4][2] = MazeContents.OPEN; this.mazeGrid[4][3] = MazeContents.OPEN; this.mazeGrid[4][4] = MazeContents.WALL; this.mazeGrid[4][5] = MazeContents.WALL; this.mazeGrid[4][6] = MazeContents.OPEN; this.mazeGrid[4][7] = MazeContents.WALL;
        this.mazeGrid[5][0] = MazeContents.WALL; this.mazeGrid[5][1] = MazeContents.OPEN; this.mazeGrid[5][2] = MazeContents.WALL; this.mazeGrid[5][3] = MazeContents.OPEN; this.mazeGrid[5][4] = MazeContents.OPEN; this.mazeGrid[5][5] = MazeContents.WALL; this.mazeGrid[5][6] = MazeContents.WALL; this.mazeGrid[5][7] = MazeContents.WALL;
        this.mazeGrid[6][0] = MazeContents.WALL; this.mazeGrid[6][1] = MazeContents.OPEN; this.mazeGrid[6][2] = MazeContents.WALL; this.mazeGrid[6][3] = MazeContents.WALL; this.mazeGrid[6][4] = MazeContents.OPEN; this.mazeGrid[6][5] = MazeContents.OPEN; this.mazeGrid[6][6] = MazeContents.OPEN; this.mazeGrid[6][7] = MazeContents.WALL;
        this.mazeGrid[7][0] = MazeContents.WALL; this.mazeGrid[7][1] = MazeContents.OPEN; this.mazeGrid[7][2] = MazeContents.WALL; this.mazeGrid[7][3] = MazeContents.OPEN; this.mazeGrid[7][4] = MazeContents.OPEN; this.mazeGrid[7][5] = MazeContents.WALL; this.mazeGrid[7][6] = MazeContents.OPEN; this.mazeGrid[7][7] = MazeContents.WALL;
        this.mazeGrid[8][0] = MazeContents.WALL; this.mazeGrid[8][1] = MazeContents.OPEN; this.mazeGrid[8][2] = MazeContents.OPEN; this.mazeGrid[8][3] = MazeContents.WALL; this.mazeGrid[8][4] = MazeContents.OPEN; this.mazeGrid[8][5] = MazeContents.WALL; this.mazeGrid[8][6] = MazeContents.OPEN; this.mazeGrid[8][7] = MazeContents.WALL;
        this.mazeGrid[9][0] = MazeContents.WALL; this.mazeGrid[9][1] = MazeContents.WALL; this.mazeGrid[9][2] = MazeContents.WALL; this.mazeGrid[9][3] = MazeContents.WALL; this.mazeGrid[9][4] = MazeContents.WALL; this.mazeGrid[9][5] = MazeContents.WALL; this.mazeGrid[9][6] = MazeContents.WALL; this.mazeGrid[9][7] = MazeContents.WALL;
  }

}


