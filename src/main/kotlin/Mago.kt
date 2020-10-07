class Mago (nombre: String): Personaje(nombre,estado = true){

    var vara = generaNumeroAleatorio(1,30)

    fun recargarVara(energia: Int){
        vara -= energia
    }

    fun poderVara() = vara
}



