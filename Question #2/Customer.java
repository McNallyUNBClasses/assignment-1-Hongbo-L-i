/*
 * This class represents a customer in a queue system.
 * 
 * @author: Hongbo Li
 * @date: May 11th, 2025
 * @version: CS2263 Assignment1
 */
public class Customer 
{
    private int count = 0; 
    private String name;
    private ArrivalTime arrivalTime;
    private double serviceTime = 0;
    private boolean isServed;
    private double waitTime;

    public Customer(ArrivalTime time) 
    {
        this.count = count++;
        this.name = "Customer" + count;
        this.arrivalTime = time;
        this.isServed = false;
    }

    public void served(double serviceTime) 
    {
        this.serviceTime = serviceTime;
        this.isServed = true;
    }

    public boolean isServed() 
    {
        return isServed;
    }

    public double getWaitTime() 
    {
        if (isServed) 
        {
            waitTime = serviceTime - arrivalTime.toMinutes();
        } 
        else 
        {
            waitTime = 0;
        }
        
        return waitTime;
    }

    public String getName() 
    {
        return name;
    }

    public double getArrivalTime() 
    {
        return arrivalTime.toMinutes();
    }

}



