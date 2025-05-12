/*
 * This class create a queue-based customer service system
 * 
 * @author: Hongbo Li
 * @date: May 11th, 2025
 * @version: CS2263 Assignment1
 */

import java.util.ArrayList;
import java.util.Random;

public class Driver 
{
    public static void main(String[] args) 
    {
        double openTime = 540;
        double closeTime = 1020;
        double enqProb = 0.6;
        double probability;
        int servedCust = 0;
        double servedWait = 0;
        double allWait = 0;
        
        Queue<Customer> myQueue = new Queue<Customer>();
        ArrayList<Customer> totalCusts = new ArrayList<Customer>();
        Random random = new Random();
        
        ArrivalTime fitstTime = new ArrivalTime(openTime);
        Customer firstCust = new Customer(fitstTime);
        myQueue.enqueue(firstCust);
        totalCusts.add(firstCust);
        
        for (double currentTime = openTime + 15; currentTime < closeTime; currentTime += 15) 
        {
            ArrivalTime time = new ArrivalTime(currentTime);
            probability = random.nextDouble();
            if (probability < enqProb) 
            {
                Customer cust = new Customer(time);
                myQueue.enqueue(cust);
                totalCusts.add(cust);
            } 
            else 
            {
                if(!myQueue.isEmpty())
                {
                    try 
                    {
                        Customer customer = myQueue.dequeue();
                        customer.served(currentTime);
                        servedCust++;
                    } 
                    catch (IllegalStateException e) 
                    {
                        System.err.println("Error: Queue is empty. Invalid dequeue operation." + e.getMessage());
                    }
                }
            }
        }

        
        for (Customer cust : totalCusts) 
        {
            double waitTime;
            if (cust.isServed()) 
            {
                waitTime = cust.getWaitTime();
                servedWait += waitTime;
            } 
            else 
            {
                waitTime = closeTime - cust.getArrivalTime();
            }
            allWait += waitTime;
        }

        double avgServedWait = servedWait / servedCust;
        double avgAllWait = allWait / totalCusts.size();
        int unservedCust = totalCusts.size() - servedCust;
        
        System.out.format("Total number of customers: %d\n", totalCusts.size());
        System.out.format("Total number of customers served: %d\n", servedCust);
        System.out.format("Total number of unserved customers: %d\n", unservedCust);
        System.out.format("Average waiting time for served customers: %.2f mins\n ", avgServedWait);
        System.out.format("Average waiting time for all customers: %.2f mins\n", avgAllWait);
    }
}
