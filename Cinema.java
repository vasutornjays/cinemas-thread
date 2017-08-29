package Cinema;

import java.util.Random;
class Cinemas {
    public int[] seat = new int [5];
}

class Person implements Runnable {
   private Thread t;
   private String threadName;
   Random rand = new Random();
   
   Person( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
            while(true){
                int RandCinema = rand.nextInt(5);
                int RandTicket = rand.nextInt(5)+1;
                int a = (int)(Math.random()*50000);
                if(Cinema.k1.seat[RandCinema] + RandTicket <= 20)
                {
                    Cinema.k1.seat[RandCinema] += RandTicket;
                    System.err.println(RandTicket + " Tickets in Cinema " + (RandCinema+1) + " are Hold from:" + threadName);
  //                  System.out.println(a);
                    if(a >= 30000){
                        Thread.sleep(30000);
                        Cinema.k1.seat[RandCinema] -= RandTicket;
                        Thread.sleep(a-30000);
                        System.out.println(RandTicket + " Tickets in Cinema " + (RandCinema+1) + " are Cancle from:" + threadName);
                    }
                    else 
                    {
                        Thread.sleep(a);
                        if(Math.random() < 0.5)
                        {
                            Cinema.k1.seat[RandCinema] -= RandTicket;
                            System.out.println(RandTicket + " Tickets in Cinema " + (RandCinema+1) + " are Cancle from:" + threadName); 
                        }
                        else
                        {
                            System.out.println(RandTicket + " Tickets in Cinema " + (RandCinema+1) + " are Buy from:" + threadName);
                        }
                    }
                }
                for(int i = 0 ;i < 5;i++)
                {
                    System.out.println("Cinema" + (i+1) + ":" + Cinema.k1.seat[i]);
                }
            }
      }catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}

public class Cinema{
   public static Cinemas k1;
   
   public static void main(String args[]) {
      
      k1 = new Cinemas();
      Person R1 = new Person( "Thread-1");
      Person R2 = new Person( "Thread-2");
      Person R3 = new Person( "Thread-3");
      Person R4 = new Person( "Thread-4");
      Person R5 = new Person( "Thread-5");
      R1.start();
      R2.start();
      R3.start();
      R4.start();
      R5.start();
      
   }   
}
