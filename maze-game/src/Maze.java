import java.util.*;
import java.io.*;
/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Aaron Hahs 
 * @version 4/27
 */
public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
      this.squares = squares;
      this.rows = rows;
      this.cols = cols;  
 		
      randOccupants = new ArrayList<RandomOccupant>();		
   }

   public Maze()
   {
      randOccupants = new ArrayList<RandomOccupant>();
   }
	
   // QUERIES
   public Square getSquare(int row, int col) { return squares[row][col]; }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   public RandomOccupant getRandomOccupant(int index) {return randOccupants.get(index);}
   public int getNumRandOccupants() {return randOccupants.size();}
	
   // COMMANDS
   public void addRandomOccupant(RandomOccupant ro) {randOccupants.add(ro);}
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      for (RandomOccupant ro : randOccupants)
      {
         ro.move();
      }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
        
      if (foundAllTreasures() == true)
      {
         status = EXPLORER_WIN;   
      }
      for (RandomOccupant ro : randOccupants)
      {
         if (ro instanceof Monster)
         {
            if (explorer.location() == ro.location())
            {
               status = MONSTER_WIN;
            }
         }
      }
        
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      for (RandomOccupant ro : randOccupants)
      {
         if (ro instanceof Treasure)
         {
            if (((Treasure)ro).found() == false)
            {
               foundAll = false;
            }
         }
      }
              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
        
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
        
      if (s.wall(0) == false)
      {
         Square sUp = this.getSquare(row - 1, col);
         sUp.setInView(true);
         if (sUp.wall(1) == false)
         {
            Square sTopRight = this.getSquare(row - 1, col + 1);
            sTopRight.setInView(true);
         }
         if (sUp.wall(3) == false)
         {
            Square sTopLeft = this.getSquare(row - 1, col - 1);
            sTopLeft.setInView(true);
         }
      }

      if (s.wall(1) == false)
      {
         Square sRight = this.getSquare(row, col + 1);
         sRight.setInView(true);
         if (sRight.wall(0) == false)
         {
            Square sTopRight = this.getSquare(row - 1, col + 1);
            sTopRight.setInView(true);
         }
         if (sRight.wall(2) == false)
         {
            Square sBotRight = this.getSquare(row + 1, col + 1);
            sBotRight.setInView(true);
         }
      }

      if (s.wall(2) == false)
      {
         Square sDown = this.getSquare(row + 1, col);
         sDown.setInView(true);
         if (sDown.wall(1) == false)
         {
            Square sBotRight = this.getSquare(row + 1, col + 1);
            sBotRight.setInView(true);
         }
         if (sDown.wall(3) == false)
         {
            Square sBotLeft = this.getSquare(row + 1, col - 1);
            sBotLeft.setInView(true);
         }
      }
 
      if (s.wall(3) == false)
      {
         Square sLeft = this.getSquare(row, col - 1);
         sLeft.setInView(true);
         if (sLeft.wall(0) == false)
         {
            Square sTopLeft = this.getSquare(row - 1, col - 1);
            sTopLeft.setInView(true);
         }
         if (sLeft.wall(2) == false)
         {
            Square sBotLeft = this.getSquare(row + 1, col - 1);
            sBotLeft.setInView(true);
         }
      }
   }
    
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }

   public void writeMazeToFile(String fileName) throws IOException
   {
      PrintStream ps = new PrintStream(new File(fileName));
      ps.println(rows + "," + cols);
      for (Square[] s : squares)
      {
         for (Square square : s)
         {
            ps.println(square.toText(','));
         }
      }
      ps.println(explorer.toText(','));
      for (RandomOccupant r : randOccupants)
      {
         ps.println(r.toText(','));
      }
   }
   
   public void readMazeFromFile(String filename) throws IOException, FileNotFoundException, MazeReadException
   {
      int lineLoc = 2;
      Scanner in = new Scanner(new File(filename));
      String header = in.nextLine();
      Scanner parser = new Scanner(header).useDelimiter(",");
      String type;     
 
      try
      {
         rows = parser.nextInt();
         cols = parser.nextInt();
      }
      catch(NoSuchElementException e)
      {
         throw new MazeReadException("Rows and columns not specified.", header, 1);
      }

      squares = new Square[rows][cols];
      while (in.hasNextLine())
      {
         String myLine = in.nextLine();
         parser = new Scanner(myLine).useDelimiter(",");

         try
         {
            type = parser.next();
         }
         catch (Exception e)
         {
            throw new MazeReadException("Line format or other error.", myLine, lineLoc);
         }
   
         if (type.equals("Square"))
         {
            int row = parser.nextInt();
            int col = parser.nextInt();
            Square s = new Square(row, col);
            
            try
            {
               s.toObject(parser);
            }
            catch(Exception e)
            {
               throw new MazeReadException("Line format or other error.", myLine, lineLoc);
            }
            
            if (squares[row][col] == null) 
            {
               squares[row][col] = s;
               lineLoc ++;
            }
            else
            {
               throw new MazeReadException("Duplicate square.", myLine, lineLoc);
            }
         }
         else if (type.equals("Explorer"))
         {
            explorer = new Explorer(this);

            try
            {
               explorer.toObject(parser);
            }
            catch(Exception e)
            {
               throw new MazeReadException("Line format or other error.", myLine, lineLoc);
            }

            lineLoc ++;
         }
         else if (type.equals("Treasure"))
         {
            Treasure t = new Treasure(this);
            
            try
            {
               t.toObject(parser);
            }
            catch(Exception e)
            {
               throw new MazeReadException("Line format or other error.", myLine, lineLoc);
            }

            randOccupants.add(t);
            lineLoc ++;
         }
         else if (type.equals("Monster"))
         {
            Monster m = new Monster(this);
            
            try
            {
               m.toObject(parser);
            }
            catch(Exception e)
            {
               throw new MazeReadException("Line format or other error.", myLine, lineLoc);
            }

            randOccupants.add(m);
            lineLoc ++;
         }
         else
         {
            throw new MazeReadException("Unknown type.", myLine, lineLoc);
         }
      }
   }
}
