class Hobbit (nombre: String): Personaje(nombre,estado = true){

    var anillo = false;


    fun ponerseAnillo(){
        anillo = true
    }

    fun quitarseAnillo(){
        anillo = false
    }
}
