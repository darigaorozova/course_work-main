import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TourPackageManager {
    public List<TourPackage> packages;
    private static final String FILENAME = "tour_packages.txt";

    public TourPackageManager() {
        this.packages = new ArrayList<>();
        loadPackages();
    }

    public void addPackage(TourPackage tourPackage) {
        packages.add(tourPackage);
        savePackages();
    }

    public void displayPackages() {
        for (TourPackage tourPackage : packages) {
            System.out.println(tourPackage);
        }
    }

    public void sortPackages() {
        Collections.sort(packages, (p1, p2) -> p1.getType().compareTo(p2.getType()));
    }

    private void savePackages() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (TourPackage tourPackage : packages) {
                writer.println(tourPackage.getType() + "," + tourPackage.getTransport() + "," +
                        tourPackage.getMeals() + "," + tourPackage.getDays());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPackages() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    packages.add(new TourPackage(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
