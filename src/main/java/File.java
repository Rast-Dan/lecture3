public class File extends AbstractFileSystemNode{
    public File(String name){
        this.name = name;
    }
    public String getExtension(){
        return name.substring(name.lastIndexOf('.') + 1);
    }
}
