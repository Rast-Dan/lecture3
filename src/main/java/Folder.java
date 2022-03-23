import java.util.ArrayList;
import java.util.Arrays;

public class Folder extends AbstractFileSystemNode{
    private ArrayList <AbstractFileSystemNode> children;

    public Folder(String name, AbstractFileSystemNode ... files) {
        this.name = name;
        children = new ArrayList<>();
        children.addAll(Arrays.asList(files));
        for (AbstractFileSystemNode child : children) {
            child.parent = this;
        }
    }

    public ArrayList<File> getFiles() {
        ArrayList<File> files = new ArrayList<>();
        for (AbstractFileSystemNode child : children) {
            if (child instanceof File){
                files.add((File) child);
            }
        }
        return files;
    }
}
