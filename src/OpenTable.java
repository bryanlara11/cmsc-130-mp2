import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenTable {
  public static void main(String[] args) {
    openImage();
  }

  public static void openImage() {
    File imageFile = new File("characteristic_tables.png");
    if (!imageFile.exists()) {
      System.out.println("Image file not found: " + imageFile.getAbsolutePath());
      return;
    }
    try {
      Desktop.getDesktop().open(imageFile);
    } catch (IOException e) {
      System.out.println("Failed to open image: " + e.getMessage());
    }
  }
}
