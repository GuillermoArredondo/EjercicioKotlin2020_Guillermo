class Mago (nombre: String): Personaje(nombre,estado = true){

    var vara = generaNumeroAleatorio(Parametros.MINVARA,Parametros.MAXVARA)

    fun recargarVara(energia: Int){
        vara -= energia
    }

    fun poderVara() = vara
}



