import java.util.Scanner;

public class HelpDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApplicationSystem system = ApplicationSystem.getInstance();

        int desk1 = 0, desk2 = 0, desk3 = 0;

        System.out.println("Pag-IBIG Office Centralized Queuing System Started");
        System.out.println("Initial Queue Number: 1\n");

        while (true) {
            system.showOnlineMonitor();

            System.out.println("[1] Help Desk 1 - Serve Next");
            System.out.println("[2] Help Desk 2 - Serve Next");
            System.out.println("[3] Help Desk 3 - Serve Next");
            System.out.println("[4] View Current Queue Status");
            System.out.println("[5] Reset Queue (Any Desk)");
            System.out.println("[6] Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    desk1 = system.serveNext();
                    System.out.println("Help Desk 1 served: " + desk1);
                    break;
                case 2:
                    desk2 = system.serveNext();
                    System.out.println("Help Desk 2 served: " + desk2);
                    break;
                case 3:
                    desk3 = system.serveNext();
                    System.out.println("Help Desk 3 served: " + desk3);
                    break;
                case 4:
                    showQueueStatus(system, desk1, desk2, desk3);
                    break;
                case 5:
                    System.out.print("Enter new queue number: ");
                    int newNum = sc.nextInt();
                    system.resetQueue(newNum);
                    desk1 = desk2 = desk3 = 0;
                case 6:
                    System.out.println("Shutting down. Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        }
    }

    public static void showQueueStatus(ApplicationSystem sys, int d1, int d2, int d3) {
        System.out.println("CURRENT QUEUE STATUS");
        System.out.println("--------------------");
        System.out.println("Current Queue Number: " + sys.getCurrentQueueNumber());
        System.out.println("Desk 1: " + (d1 == 0 ? "Not served yet" : d1));
        System.out.println("Desk 2: " + (d2 == 0 ? "Not served yet" : d2));
        System.out.println("Desk 3: " + (d3 == 0 ? "Not served yet" : d3));
        System.out.println();
    }
}