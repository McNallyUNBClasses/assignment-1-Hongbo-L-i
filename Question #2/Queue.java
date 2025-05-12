/*
 * This class implements a generic queue using a linked list structure with enqueue and dequeue operations.
 * 
 * @author: Hongbo Li
 * @date: May 11th, 2025
 * @version: CS2263 Assignment1
 */

public class Queue<T> 
{
    private Node<T> head; 
    private Node<T> tail; 
    private int size;
    
    public boolean isEmpty() 
    {
        return head == null;
    }
    
    public void enqueue(T item) 
    {
        if (item == null) 
        {
            throw new IllegalArgumentException("Error: Cannot enqueue null item.");
        }
        
        Node<T> temp = new Node<>(item);
        if (isEmpty()) 
        {
            head = temp;
        }
        else
        {
            tail.setNext(temp);
        }
        
        tail = temp;
        size++;
    }

    public T dequeue() 
    {
        if (isEmpty()) 
        {
            throw new IllegalStateException("Error: Queue is empty. Invalid dequeue operation.");
        }
        
        T item = head.getData();
        head = head.getNext();
        
        if (head == null) 
        {
            tail = null;
        }
        size--;
        return item;
    }

    public int size() 
    {
        return size;
    }
}

