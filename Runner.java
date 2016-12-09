/**
 * Runner is a class that runs SantaBot so that a conversation will be possible rather than just
 * a one-time question.
 * 
 * @author Ethan Alcantara and Pranav Konduru
 * @version December 2, 2016
 * 
 */

import java.util.Scanner;
import java.util.*;
public class Runner
{
    /**
     * main() is the main method, and runs SantaBot
     * 
     * @param String[] args; does absolutely nothing
     * 
     * @return nothing
     * 
     */
    public static void main (String [] args)
    {
        SantaBot santabot = new SantaBot();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n-------------------\n");
        System.out.println("Santa: " + santabot.getGreeting());

        Scanner in = new Scanner (System.in);
        
        System.out.print("You: ");
        String statement = in.nextLine();
        List lastReplies = new ArrayList();
        int counter = 0;
        String thing = "";


        while (!statement.toLowerCase().equals("bye") && !statement.toLowerCase().equals("goodbye")){
            if(counter == 0){
                thing = santabot.processor1(statement, "");
            }
            else{
                thing = santabot.processor1(statement, lastReplies.get(counter - 1));
            }
            lastReplies.add(thing);
            
            System.out.print("Santa: ");
            System.out.println (thing);
            
            System.out.print("You: ");
            statement = in.nextLine();
            
            if(lastReplies.size() > 10){
                lastReplies.remove(0);
                counter --;
            }
            counter ++;
        }
        System.out.println ("\nSanta: Good-bye.");
    }
}