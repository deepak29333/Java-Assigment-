
//DP8
import java.lang.Thread;
class Producer extends Thread {
    Thread t1;
    StringBuffer buffer;

    Producer() {
        // Initializing the buffer
        buffer = new StringBuffer(5);

        // Creating a new thread with
        // the current object
        t1 = new Thread(this);
    }

    // Overriding the run method
    public void run() {

        for (int i = 0; i < 5; i++) {
            buffer.append(i);
            System.out.println("Produced:- " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nBuffer is FUll");

        Consumer c = new Consumer(this);
        t1 = new Thread(c);
        t1.start();
    }
}

class Consumer extends Thread {

    Producer p;

    Consumer(Producer temp) {
        p = temp;
    }

    // Overriding the run method
    public void run() {

        for (int i = 0; i < p.buffer.length(); i++) {
            System.out.println("Consumed:- " + p.buffer.charAt(i));
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nBuffer is Empty");
    }
}

 class DP8 {
    public static void main(String[] args) {
        Producer p = new Producer();
        p.start();
    }
}
