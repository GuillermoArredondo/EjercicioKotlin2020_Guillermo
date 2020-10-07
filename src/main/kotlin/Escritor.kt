import java.io.*
import java.lang.Exception

class Escritor {

    var f = FileWriter("moria.txt",true)
    var strings = mutableListOf<String>()

    fun escribir(){
        try {
            for(string in strings) {
                f.appendLine(string)
            }
            f.close()
        }catch (ex:Exception){
            print(ex.message)
        }
    }

    fun addText(str: String){
        strings.add(str)
    }
}