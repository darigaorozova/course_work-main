import java.util.Scanner;
// s
public class Main {
    public static void main(String[] args) {
        TourPackageManager manager = new TourPackageManager();
        Admin admin = new Admin(manager);
        User user = new User();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you an admin or a user? Enter 'admin' or 'user':");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            System.out.println("Enter admin password:");
            String password = scanner.nextLine();
            if (admin.authenticateAdmin(password)) {
                System.out.println("Authentication successful.");
                while (true) {
                    System.out.println("Admin Menu:");
                    System.out.println("1. Add Tour Package");
                    System.out.println("2. View Tour Packages");
                    System.out.println("3. Bookings");
                    System.out.println("4. Add Another Package");
                    System.out.println("5. Exit");

                    System.out.print("Enter your choice: ");
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.println("Enter package type:");
                            String type = scanner.nextLine();
                            System.out.println("Enter package transport:");
                            String transport = scanner.nextLine();
                            System.out.println("Enter package meals:");
                            String meals = scanner.nextLine();
                            System.out.println("Enter package days:");
                            int days = Integer.parseInt(scanner.nextLine());

                            admin.addTourPackage(type, transport, meals, days);
                            System.out.println("Tour Package added successfully!");
                            break;
                        case 2:
                            manager.displayPackages();
                            break;
                        case 3:
                            // Список броней
                            break;
                        case 4:
                            System.out.println("Exiting program.");
                            return;
                        default:
                            System.out.println("Invalid choice. Try again.");
                            break;
                    }
                }
            }
        } else if (role.equalsIgnoreCase("user")) {
            System.out.println("Available Packages:");
            manager.displayPackages();

            System.out.println("Enter your preferences:");
            System.out.print("Type: ");
            String type = scanner.nextLine();
            System.out.print("Transport: ");
            String transport = scanner.nextLine();
            System.out.print("Meals: ");
            String meals = scanner.nextLine();
            System.out.print("Days: ");
            int days = Integer.parseInt(scanner.nextLine());

            System.out.println("Matching Packages:");
            for (TourPackage tourPackage : manager.packages) {
                if (tourPackage.getType().equalsIgnoreCase(type) &&
                        tourPackage.getTransport().equalsIgnoreCase(transport) &&
                        tourPackage.getMeals().equalsIgnoreCase(meals) &&
                        tourPackage.getDays() == days) {
                    System.out.println(tourPackage);
                }
            }

            System.out.println("Enter the number of the package you want to book:");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= 0 && choice < manager.packages.size()) {
                TourPackage selectedPackage = manager.packages.get(choice);
                user.bookPackage(selectedPackage);
            } else {
                System.out.println("Invalid choice. Exiting program.");
                return;
            }

            user.displayBookedPackages();
        } else {
            System.out.println("Invalid role. Exiting program.");
            return;
        }
    }
}
