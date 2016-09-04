import java.util.*;

public class Separator
{
        private static final int N = 5;
        private static int[] ints;
        private static float[] floats;
        static Scanner scanner;
        
        public static void main(String[] args)
        {
                ints = new int[N];
                floats = new float[N];
                scanner = new Scanner(System.in);
                boolean go = true;
                int intCount = 0;
                int floatCount = 0;
                System.out.println("type stuff in: ");
                while(go)
                {
                        if(!scanner.hasNext())
                        {
                                go = false;
                        }
                        if(scanner.hasNextInt())
                        {
                               
                                        if(intCount == N)
                                        {
                                                go = false;
                                        }
                                        else
                                        {
                                                ints[intCount] = scanner.nextInt();
                                                intCount++;
                                        }
                                
                        }
                        else if(scanner.hasNextFloat())
                        {
                            
                                        if(floatCount == N)
                                        {
                                                go = false;
                                        }
                                        else
                                        {
                                                floats[floatCount] = scanner.nextFloat();
                                                floatCount++;
                                        }
                                        
                               
                        }
                        else go = false;
                }
                
                
                System.out.print("Integers: ");
                for(int i=0; i < intCount; i++)
                {
                        System.out.print(ints[i] + " ");
                }
                System.out.println();
                System.out.print("Floats: ");
                for(int i=0; i < floatCount; i++)
                {
                        System.out.print(floats[i] + " ");
                }
                System.out.println();
                
        }
}
