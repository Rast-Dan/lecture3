import java.util.ArrayList
import java.util.Arrays

class Folder(name: String?, vararg files: AbstractFileSystemNode) : AbstractFileSystemNode() {
    private val children: ArrayList<AbstractFileSystemNode>
    fun getFiles(): ArrayList<File> {
            val files = ArrayList<File>()
            for (child in children) {
                if (child is File) {
                    files.add(child)
                }
            }
            return files
    }

    init {
        this.name_value = name
        children = ArrayList()
        for (child in files) {
            children.add(child)
            child.setParent(this)
        }
    }
}