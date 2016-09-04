import java.util.*;
import java.lang.*;

/**
 * Abstract class that contains all the logic to model Occupants of the Maze.
 *
 * @author Aaron Hahs
 * @version 4/27
 */

public abstract class Occupant implements DelimitedTextIO
{
   // Instance variables
   private Square location;

   // Constructors
   public Occupant()
   {
   }
 
   public Occupant(Square start)
   {
      location = start;
   }

   public Square location()
   {
      return location;
   }   
   
   public void moveTo(Square newLoc)
   {
      location = newLoc;
   }
 
   public String toText(char delimiter)
   {
      return getClass().getName() + delimiter + location.row() + delimiter + location.col(); 
   }
}
