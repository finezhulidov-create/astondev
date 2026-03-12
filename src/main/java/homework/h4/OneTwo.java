package homework.h4;

public class OneTwo {
    private static final Object monitor = new Object();
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
      Runnable run1 = () -> {
            while (true){
                synchronized (monitor){
                    if (!flag){
                        try {
                            Thread.sleep(1000);
                            monitor.wait();

                        } catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    System.out.println(1);
                    flag = false;
                    monitor.notify();
                }
            }

      };

      Runnable run2 = () -> {
            while (true){
                synchronized (monitor){
                    if (flag){
                        try {
                            Thread.sleep(1000);
                            monitor.wait();
                        } catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    System.out.println(2);
                    flag = true;
                    monitor.notify();
                }
            }
      };
      Thread th1 = new Thread(run1);
      Thread th2 = new Thread(run2);
      th1.start();
      th2.start();
    }

}
