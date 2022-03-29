abstract class AbstractFileSystemNode : FileSystemNode {
    protected var parent_value: FileSystemNode? = null
    protected var name_value: String? = null
    override fun getParent(): FileSystemNode? {
        return parent_value
    }

    fun setParent(parent: FileSystemNode ) {
        parent_value = parent
    }

    override fun getName(): String {
        return name_value!!
    }

    override fun getPath(): String {
        return if (getParent() != null) getParent()?.getPath() + "/" + getName() else getName()!!
    }
}