import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        File file = new File("D:/123.txt");
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
