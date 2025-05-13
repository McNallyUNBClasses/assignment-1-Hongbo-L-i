/*
 * This driver class creates an array of 10 random integers, push them onto a stack and pop them to reverse the array.
 * 
 * @authors: Hongbo Li
 * @date: May 11th, 2025
 * @version CS2263 Assignment1
 */

import java.util.Arrays;
import java.util.Random;
import java.util.EmptyStackException;

public class StackDriver 
{
    public static void main(String[] args) 
    {
        int[] array = new int[10];
        int[] reArray = new int[10];
        Random randomNum = new Random();
        
        //original array with 10 random integers from -10 to 10
        for (int i = 0; i < array.length; i++)
        {
            array[i] = randomNum.nextInt(21)-10;
        }
        System.out.println("Original array: " + Arrays.toString(array));

        Stack myStack = new Stack();
        //push the numbers into Stack
        for (int num : array) 
        {
            myStack.push(num);
        }
        
        //pop values from the stack and reverse the array
        for (int i = 0; i < array.length; i++) 
        {
            try 
            {
                reArray[i] = myStack.peek();
                myStack.pop();
            }
            catch (EmptyStackException e) 
            {
                System.err.println("Error: Stack is Empty");
            }
        }
        
        System.out.println("Reversed array: " + Arrays.toString(reArray));
    }
}
