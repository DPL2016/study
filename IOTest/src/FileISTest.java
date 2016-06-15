import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileISTest {
    public static void main(String[] args) {
        File file = new File("D:/123.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            int length = (int) file.length();
            byte[] data = new byte[length];
            try {
                fis.read(data);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String str = new String(data);
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
