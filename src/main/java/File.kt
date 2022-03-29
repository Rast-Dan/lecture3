class File(name: String?) : AbstractFileSystemNode() {
    val extension: String
        get() = getName().substring(getName().lastIndexOf('.') + 1)

    init {
        this.name_value = name
    }
}