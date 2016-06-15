import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOSTest {
    public static void main(String[] args) {
        File file = new File("D:/123.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            byte[]data = "q23gvqw".getBytes();
            try {
                fos.write(data);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
