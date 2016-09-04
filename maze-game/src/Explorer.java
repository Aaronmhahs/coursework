import java.awt.event.*;
import java.util.*;

/**
 * Class that contains all the logic to model an Explorer.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public class Explorer extends Occupant
{
   // Instance variables
   private String name;
   private Maze maze;

   // Constructors
   public Explorer(Square location, Maze maze, String name)
   {
      super(location);
      this.maze = maze;
      this.name = name;
 
      maze.lookAround(location);
   }
   
   public Explorer(Maze maze)
   {
      this.maze = maze;
   }
   
   // Methods
   public String name()
   {
      return name;
   }   

   public void move(int key)
   {
      if (key == KeyEvent.VK_UP)
      {
         if (location().wall(0) == false)
         {
            Square s = maze.getSquare(location().row() - 1, location().col());
            this.moveTo(s);   
         }
      }
     
       if (key == KeyEvent.VK_RIGHT)
      {  
         if (location().wall(1) == false)
         {
            Square s = maze.getSquare(location().row(), location().col() + 1);
            this.moveTo(s);
         }
      }
      
       if (key == KeyEvent.VK_DOWN)
      {  
         if (location().wall(2) == false)
         {
            Square s = maze.getSquare(location().row() + 1, location().col());
            this.moveTo(s);
         }
      }
 
       if (key == KeyEvent.VK_LEFT)
      {  
         if (location().wall(3) == false)
         {
            Square s = maze.getSquare(location().row(), location().col() - 1);
            this.moveTo(s);
         }
      }
      if (key == KeyEvent.VK_KP_UP)
      {
         if (location().wall(0) == false)
         {
            Square s = maze.getSquare(location().row() - 1, location().col());
            this.moveTo(s);
         }
      }

       if (key == KeyEvent.VK_KP_RIGHT)
      {
         if (location().wall(1) == false)
         {
            Square s = maze.getSquare(location().row(), location().col() + 1);
            this.moveTo(s);
         }
      }

       if (key == KeyEvent.VK_KP_DOWN)
      {
         if (location().wall(2) == false)
         {
            Square s = maze.getSquare(location().row() + 1, location().col());
            this.moveTo(s);
         }
      }

       if (key == KeyEvent.VK_KP_LEFT)
      {
         if (location().wall(3) == false)
         {
            Square s = maze.getSquare(location().row(), location().col() - 1);
            this.moveTo(s);
         }
      }
   }
   
   public void moveTo(Square s)
   {
      super.moveTo(s);
      s.enter();
      maze.lookAround(s);
   }

   public String toText(char delimiter)
   {
      return super.toText(delimiter) + delimiter + name; 
   }

   public void toObject(Scanner input)
   {
      moveTo(maze.getSquare(input.nextInt(), input.nextInt()));
      this.name = input.next(); 
   }
}
