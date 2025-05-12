/*
 * This class implements a generic node used in a linked list structure. 
 * 
 * @author: Hongbo Li
 * @date: May 11th, 2025
 * @version: CS2263 Assignment1
 */
public class Node<T> 
{
    T data;
    Node<T> next;

    Node(T data) 
    {
        this.data = data;
    }
    
    public void setNext(Node<T> next) 
    {
        this.next = next;
    }
    
    public Node<T> getNext() 
    {
        return next;
    }

    public T getData() 
    {
        return data;
    }
}
