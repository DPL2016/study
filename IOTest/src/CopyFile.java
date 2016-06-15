import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CopyFile {
    public static void main(String[] args) throws Exception {
        File fromfile = new File("e:/eclipse-jee-mars-2-win32-x86_64.zip");
        File tofile = new File("D:/eclipse.zip");
        FileInputStream fis = new FileInputStream(fromfile);
        FileOutputStream fos = new FileOutputStream(tofile,true);
        if (tofile.exists()){
            tofile.delete();
        }
        tofile.createNewFile();
        byte[]buffer = new byte[1024*64];
        int length = fis.read(buffer);
        while (length>0){
            fos.write(buffer,0,length);
            length=fis.read(buffer);
        }
        fos.close();
        fis.close();


    }
}

