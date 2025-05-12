/*
 * This class represents a time of arrival using hours format and minutes format
 * 
 * @author: Hongbo Li
 * @date: May 11th, 2025
 * @version: CS2263 Assignment1
 */

public class ArrivalTime 
{
    private int hour;
    private int minute;
    private double minTime;
    
    public ArrivalTime(double minTime) 
    {
        this.hour = (int) minTime / 60;
        this.minute = (int) minTime % 60;
        this.minTime = minTime;
    }

    public double toMinutes() 
    {
        return minTime;
    }

    @Override
    public String toString() 
    {
        return String.format("%02d:%02d", hour, minute);
    }
}
