public abstract class AbstractFileSystemNode implements FileSystemNode{
    protected FileSystemNode parent = null;
    protected String name;

    public final FileSystemNode getParent(){
        return parent;
    }

    public String getName(){
        return name;
    }

    public final String getPath(){
        if (getParent() != null)
            return getParent().getPath() + "/" + name;
        return name;
    }
}
