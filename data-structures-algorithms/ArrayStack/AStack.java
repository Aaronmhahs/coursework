import java.util.*;
import java.io.*;

public class AStack<T>
{
        private T[] arr;
        private int top;
        
        public static class MyException extends RuntimeException
        {
                public MyException()
                {
                        super();
                }
                public MyException(String message)
                {
                        super(message);
                }
        }
        
        public AStack(int size)
        {
                arr = (T[]) new Object[size];
                top = -1;
        }
        
        public void push(T elem)
        {
                if(top == arr.length-1)
                {
                        T[] temp = (T[]) new Object[2*arr.length];
                        for(int i = 0; i< arr.length; i++)
                        {
                                temp[i] = arr[i];
                        }
                        arr = temp;
                }
                top++;
                arr[top] = elem;
        }
        
        public T pop()
        {
                if(top == -1)
                {
                        throw new MyException("Stack is already empty");
                }
               T returnVal = arr[top];
               top--;
               return returnVal; 
        }
        
        public T peek()
        {
                if(top == -1)
                {
                        throw new MyException("Stack is already empty");
                }
               return arr[top];
        }
        
        public boolean isEmpty()
        {
                if(top == -1)
                {
                        return true;
                }
                else return false;
        }
}
