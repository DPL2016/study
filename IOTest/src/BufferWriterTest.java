import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterTest {
    public static void main(String[] args) throws Exception {
        File file = new File("d:/123.txt");
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("asdfgh");
        bw.newLine();
        bw.flush();
        bw.close();
        fw.close();
    }
}
