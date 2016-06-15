import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("D:/123");
       delete(file);
    }
    public static void delete(File file){
        if (file.isFile()||file.listFiles().length==0){
            file.delete();
            return;
        }else {
            for (File f:file.listFiles()){
                delete(f);
            }
        }
        file.delete();
    }
}
