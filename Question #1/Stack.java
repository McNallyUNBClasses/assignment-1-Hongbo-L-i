/*
 * This class implements a basic stack of integers using an ArrayList. the array.
 * 
 * @authors: Hongbo Li
 * @date: May 11th, 2025
 * @version CS2263 Assignment1
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack
{
    private ArrayList<Integer> myArray = new ArrayList<>();

    public void push(int item) 
    {
        myArray.add(item);
    }

    public int pop()
    {
        if (isEmpty()) 
        {
            throw new EmptyStackException();
        }
        
        return myArray.remove(myArray.size() - 1);
    }

    public int peek()
    {
        if (isEmpty()) 
        {
            throw new EmptyStackException();
        }
        
        return myArray.get(myArray.size() - 1);
    }

    public boolean isEmpty()
    {
        return myArray.isEmpty();
    }
}
