class Elfo (nombre: String): Personaje(nombre,estado = true){

    var carcaj = generaNumeroAleatorio(Parametros.MINCARCAJ,Parametros.MAXCARCAJ)

    fun lanzarFlecha(){
        carcaj--
    }

    fun recargarFlecha(flechas: Int){
        carcaj += flechas
    }
}

