import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TourPackageManager manager = new TourPackageManager();
        Admin admin = new Admin(manager);
        UserDetails userDetails = new UserDetails(); // Используем UserDetails для регистрации пользователя
        User user = new User();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you an admin or a user? Enter 'admin' or 'user':");
        String role = scanner.nextLine();

        if (role.equalsIgnoreCase("admin")) {
            // Код для админа...
        } else if (role.equalsIgnoreCase("user")) {
            System.out.println("Available Packages:");
            manager.displayPackages();

            // Запрос пользовательских предпочтений
            System.out.println("Enter your preferences:");
            System.out.print("Type: ");
            String type = scanner.nextLine();
            System.out.print("Transport: ");
            String transport = scanner.nextLine();
            System.out.print("Meals: ");
            String meals = scanner.nextLine();
            System.out.print("Days: ");
            int days = Integer.parseInt(scanner.nextLine());

            // Вывод совпадающих пакетов
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
                // Бронирование тура
                user.bookPackage(selectedPackage);
                // Сохранение данных пользователя
                userDetails.registerUser();
                userDetails.saveUserDataToFile();
                // Выбор способа оплаты
                System.out.println("Enter payment method (card, cash, etc.):");
                String paymentMethod = scanner.nextLine();
                // Бронирование тура и сохранение информации
                Reservation reservation = new Reservation(userDetails, selectedPackage, paymentMethod);
                reservation.saveReservationToFile();
            } else {
                System.out.println("Invalid choice. Exiting program.");
                return;
            }

            // Вывод забронированных пакетов
            user.displayBookedPackages();
        } else {
            System.out.println("Invalid role. Exiting program.");
            return;
        }
    }
}
