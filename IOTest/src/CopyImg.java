import java.io.*;

public class CopyImg {
    public static void main(String[] args) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:/1.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:/2.jpg"));
        byte[]buffer = new byte[1024];
        int len = bis.read(buffer);
        while (len>0){
            bos.write(buffer,0,len);
            len = bis.read(buffer);
        }
        bos.flush();
        bos.close();
        bis.close();
    }
}
