import java.util.Scanner;

public class Reservation {
    private String clientName;
    private String destination;
    private String date;

    // Конструктор класса
    public Reservation(String clientName, String destination, String date) {
        this.clientName = clientName;
        this.destination = destination;
        this.date = date;
    }

    // Метод для отображения информации о брони
    public void displayReservationInfo() {
        System.out.println("Информация о бронировании:");
        System.out.println("Клиент: " + clientName);
        System.out.println("Место назначения: " + destination);
        System.out.println("Дата: " + date);
    }

    // Метод для изменения даты бронирования
    public void changeDate(String newDate) {
        this.date = newDate;
        System.out.println("Дата бронирования изменена на " + newDate);
    }

    // Другие методы по мере необходимости

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Получаем данные от пользователя
        System.out.println("Введите имя клиента:");
        String name = scanner.nextLine();

        System.out.println("Введите место назначения:");
        String destination = scanner.nextLine();

        System.out.println("Введите дату бронирования:");
        String date = scanner.nextLine();

        // Создаем объект бронирования
        Reservation reservation = new Reservation(name, destination, date);

        // Отображаем информацию о бронировании
        reservation.displayReservationInfo();

        // Изменяем дату бронирования
        System.out.println("Введите новую дату бронирования:");
        String newDate = scanner.nextLine();
        reservation.changeDate(newDate);

        // Закрываем сканнер
        scanner.close();
    }
}
