
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public class test
{
    public static void main1() //#1
    {
        //Part A
        int[] a = new int[20];
        //Part B
        for(int i=0;i<20;i++)
        {
            int num = (int)(Math.random() * 101);
            a[i] = num;
        }
        //Part C
        System.out.println("PART C");
        for (int item:a)
        {
            System.out.println(item);
        }
        //Part D
        ArrayList<Integer> alist = new ArrayList<Integer>();
        for(int item:a)
        {
            alist.add(item);
        }
        //Part E
        System.out.println("PART E");
        for(Integer item:alist)
        {
            System.out.println(item);
        }
        //Part F
        for(int i=1; i<a.length; i+=2)
        {
            alist.set(i,0);
            a[i] = 0;
        }
        //Part G
        System.out.println("PART G");
        for(int item:a)
        {
            System.out.println(item);
        }
        for(Integer item:alist)
        {
            System.out.println(item);
        }
        //Part H
        for(int i=4; i<a.length; i+=5)
        {
            a[i] = 0;
        }
        for(int i=4; i<alist.size(); i+=5)
        {
            alist.remove(i);
        }
        //Part I
        System.out.println("PART I");
        for(int item:a)
        {
            System.out.println(item);
        }
        for(Integer item:alist)
        {
            System.out.println(item);
        }
    }
    
    public static void main2() //#2a
    {
       int time = 1000000;
       int[] array = new int[time];
       List<Integer> arrayList = new ArrayList<Integer>(time);
 
       long startTime = System.nanoTime();
       for (int i = 0; i < time; i++) {
           array[i] = i;
       }
       float arrayTime= (System.nanoTime() - startTime) / 1000000000F;
       System.out.println("Array takes: " + arrayTime);
 
       startTime = System.nanoTime();
       for (int i = 0; i < time; i++) {
           arrayList.add(i);
       }
       float arrayListTime= (System.nanoTime() - startTime) / 1000000000F;
       System.out.println("ArrayList takes: " + arrayListTime);
       System.out.println("ArrayList takes: " + (arrayListTime/arrayTime) + " times longer");
    }
    
    public static void main3() //#2b
    {
       int time = 1000000;
       int[] array = new int[time];
       List<Integer> arrayList = new ArrayList<Integer>(time);
 
       long startTime = System.nanoTime();
       for (int i = 3; i < time; i+=4) {
           array[i] = i;
       }
       float arrayTime= (System.nanoTime() - startTime) / 1000000000F;
       System.out.println("Array takes: " + arrayTime);
 
       startTime = System.nanoTime();
       for (int i = 3; i < time; i+=4) {
           arrayList.add(i);
       }
       float arrayListTime= (System.nanoTime() - startTime) / 1000000000F;
       System.out.println("ArrayList takes: " + arrayListTime);
       System.out.println("ArrayList takes: " + (arrayListTime/arrayTime) + " times longer");
    }
}
