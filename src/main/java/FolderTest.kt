import kotlin.jvm.JvmStatic

object FolderTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val file1 = File("Test1.exe")
        val file2 = File("Test2.txt")
        val file3 = File("Test3.zip")
        val file4 = File("Test4.jpeg")
        val file5 = File("Test5.log")
        val folder1 = Folder("folder1", file1, file2, file3)
        val folder2 = Folder("folder2", file4, file5)
        val rootFolder = Folder("rootFolder", folder1, folder2)
        println(file1.getPath())
        println(file5.getPath())
        println(folder1.getFiles()[1].extension)
    }
}