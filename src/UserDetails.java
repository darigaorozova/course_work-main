import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserDetails {
    private String name;
    private String email;

    public UserDetails() {}

    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        this.name = scanner.nextLine();
        System.out.println("Enter your email:");
        this.email = scanner.nextLine();
        System.out.println("User registered successfully.");
    }

    public void saveUserDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("user_data.txt"))) {
            writer.println("Name: " + name);
            writer.println("Email: " + email);
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving user data to file.");
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
