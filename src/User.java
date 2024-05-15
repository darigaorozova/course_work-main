import java.util.ArrayList;
import java.util.List;

public class User {
    private List<TourPackage> bookedPackages;

    public User() {
        this.bookedPackages = new ArrayList<>();
    }

    public void bookPackage(TourPackage tourPackage) {
        bookedPackages.add(tourPackage);
        System.out.println("Package booked: " + tourPackage);
    }

    public void displayBookedPackages() {
        System.out.println("Booked Packages:");
        for (TourPackage tourPackage : bookedPackages) {
            System.out.println(tourPackage);
        }
    }
}
