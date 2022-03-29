interface FileSystemNode {
    fun getParent():FileSystemNode?
    fun getName():String
    fun getPath():String
}