import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Reservation {
    private UserDetails userDetails;
    private TourPackage tour;
    private LocalDateTime reservationDate;
    private String paymentMethod;

    public Reservation(UserDetails userDetails, TourPackage tour, String paymentMethod) {
        this.userDetails = userDetails;
        this.tour = tour;
        this.reservationDate = LocalDateTime.now();
        this.paymentMethod = paymentMethod;
    }

    public void saveReservationToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("reservation_history.txt", true))) {
            writer.println("User: " + userDetails.getName());
            writer.println("Tour: " + tour);
            writer.println("Reservation Date: " + reservationDate);
            writer.println("Payment Method: " + paymentMethod);
            writer.println("-----------------------------------------");
            System.out.println("Reservation saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving reservation.");
            e.printStackTrace();
        }
    }
}
