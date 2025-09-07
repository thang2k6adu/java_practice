import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class HelloFile {
  public static void main(String[] args) {
    String fileName = "Hello.txt";
    try {
      Path path = Paths.get(fileName);
      List<String> lines = Files.readAllLines(path);
      for (String line : lines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.out.println("Không thể đọc file: " + e.getMessage());
    }
  }
}
