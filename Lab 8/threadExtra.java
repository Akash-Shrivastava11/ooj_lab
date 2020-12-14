// 1. Write a program to create a thread and find the sum of odd numbers from 1 to 100 in
// this thread. Find the sum of even numbers for the same range in the main thread.
import java.util.*;
import java.lang.*;
class oddThread implements Runnable
{
    String name;
    oddThread (String threadname)
    {
        Thread t=new Thread(this,threadname);
        t.start();
    }
   public void run()
   {
       int sumo=0;
       try {
           for(int i=1;i<=100;i++)
           {
                if(i%2!=0)
                sumo+=i;
           }
           System.out.println("Sum of the odd numbers is: "+sumo);
           throw new InterruptedException();
          
       } catch (InterruptedException e) {
           System.out.println("Child thread trminated");
       }
   }
}
class threadExtra
{
    public static void main(String[]args)
    {
    int sum=0;
    new oddThread("odd");
    try {
        for(int i=1;i<=100;i++)
        {
            if(i%2==0)
            sum+=i;
        }
        System.out.println("Sum of even numbers: "+sum);
        throw new InterruptedException();
        
    } catch (InterruptedException e) {
        System.out.println("Main Thread terminated due to interrupt"+e);
    }
}
}