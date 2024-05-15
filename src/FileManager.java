import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    // Метод для сохранения информации о бронировании в файл
    public static void saveToFile(String data, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(data + "\n");
            writer.close();
            System.out.println("Информация сохранена в файле " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл.");
            e.printStackTrace();
        }
    }
}
