package Cinema;

import java.util.Random;
class Cinemas {
    public int[] seat = new int [5];
}

class Person implements Runnable {
   private Thread t;
   private String threadName;
   Random rand = new Random();
   private Cinemas c;
   
   Person( String name,Cinemas k1) {
      this.c = k1;
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   public void run() {
      System.out.println("Running " +  threadName );
      try {
          while(true){
              int RandCinema = rand.nextInt(5);
              int RandTicket = rand.nextInt(5)+1;
              int a = (int)(Math.random()*500);
              Thread.sleep(a);
              if(Math.random() < 0.5)
              {
                  if(c.seat[RandCinema] + RandTicket <= 20)
                  {
                      c.seat[RandCinema] += RandTicket;
                      for(int i = 0; i < 5; i++)
                      {
                        System.out.println("Cinema" + (i+1) + ":" + c.seat[i]);
                      }
                  }
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

   public static void main(String args[]) {
      
      Cinemas k1 = new Cinemas();
      Person R1 = new Person( "Thread-1",k1);
      R1.start();
      
      Person R2 = new Person( "Thread-2",k1);
      R2.start();
      
      Person R3 = new Person( "Thread-3",k1);
      R3.start();
      
      Person R4 = new Person( "Thread-4",k1);
      R4.start();
      
      Person R5 = new Person( "Thread-5",k1);
      R5.start();
      
   }   
}
