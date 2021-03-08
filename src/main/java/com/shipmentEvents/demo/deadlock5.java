public class DeadlockExample {

    private Object lock = new Object();
    private boolean stopped = true;

    public void run() {
        synchronized (lock) {
            isStopped();
        }
    }

    private synchronized boolean isStopped() {
        return stopped;
    }

    public synchronized void stopWorker() {
        synchronized (lock) {
            System.out.println("Stopping...");
        }
    }

    public static void main(String args[]) throws InterruptedException {
        DeadlockExample deadlock = new DeadlockExample();

        Thread threadA = new Thread(() -> {
            deadlock.run();
            System.out.println("Running...");
        });
        Thread threadB = new Thread(() -> {
            deadlock.stopWorker();
            System.out.println("Stopped...");
        });
        threadA.start();
        threadB.start();
    }
}

