
class ApplicationSystem {
    private static ApplicationSystem instance;
    private int currentQueueNumber = 1;

    private ApplicationSystem() {}

    public static ApplicationSystem getInstance() {
        if (instance == null) {
            instance = new ApplicationSystem();
        }
        return instance;
    }

    public int serveNext() {
        int served = currentQueueNumber;
        currentQueueNumber++;
        return served;
    }

    public void resetQueue(int newNumber) {
        if (newNumber >= 1) {
            currentQueueNumber = newNumber;
            System.out.println("Queue reset to: " + newNumber);
        } else {
            System.out.println("Invalid number. Must be 1 or higher.");
        }
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public void showOnlineMonitor() {
        System.out.println("\n=== ONLINE MONITORING SYSTEM ===");
        System.out.println("   NOW SERVING: " + currentQueueNumber);
        System.out.println("===============================\n");
    }
}