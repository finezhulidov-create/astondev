package homework.h4;

public class DeadLock {
    private static final Object res1 = new Object();
    private static final Object res2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread( () -> {
            synchronized (res1) {
                System.out.println("Ресурс 1 захвачен");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Захват ресурса2 вторым потоком...");
                synchronized (res2) {
                    System.out.println("ресурс 2 захвачен");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (res2) { // чтобы избежать нужно захватывать мониторы в одном и том же порядке
                System.out.println("Ресурс 2 захвачен");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                System.out.println("Захват ресурса2 вторым потоком...");
                synchronized (res1) {
                    System.out.println("ресурс 1 захвачен");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
