import java.util.ArrayList;

public class FolderTest {

    public static void main(String[] args) {
        File file1 = new File("Test1.exe");
        File file2 = new File("Test2.txt");
        File file3 = new File("Test3.zip");
        File file4 = new File("Test4.jpeg");
        File file5 = new File("Test5.log");

        Folder folder1 = new Folder("folder1", file1, file2, file3);
        Folder folder2 = new Folder("folder2", file4, file5);

        Folder rootFolder = new Folder("rootFolder", folder1, folder2);

        System.out.println(file1.getPath());
        System.out.println(file5.getPath());

        System.out.println(folder1.getFiles().get(1).getExtension());
    }
}
