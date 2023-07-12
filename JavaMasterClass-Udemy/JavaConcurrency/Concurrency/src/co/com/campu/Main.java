package co.com.campu;

public class Main {
    public static void main(String[] args) {
        System.out.println(ThreadColor.ANSI_PURPLE + "Hello from main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another thread ==");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ThreadColor.ANSI_GREEN + "Hello from the anonymous thread");
            }
        }.start();

        //Thread myRunnableThread = new Thread(new MyRunnable());
        //myRunnableThread.start();

        Thread anotherRunnable = new Thread(() -> {
            System.out.println(ThreadColor.ANSI_RED + "Hello from the anonymous class's implementation of run()");
            try{
                anotherThread.join();
                System.out.println(ThreadColor.ANSI_RED + "AnotherThread terminated, or timed out, so I'm running again");
            }catch (InterruptedException e){
                System.out.println(ThreadColor.ANSI_RED + "I couldn't wait after all. I was interrupted");
            }
        });
        anotherRunnable.start();

        //anotherThread.interrupt();

        System.out.println(ThreadColor.ANSI_PURPLE + "Hello again from the main thread");
    }
}
