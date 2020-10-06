class Elfo (nombre: String): Personaje(nombre,estado = true){

    var carcaj = generaNumeroAleatorio(1,20)

    fun lanzarFlecha(){
        carcaj--
    }

    fun recargarFlecha(flechas: Int){
        carcaj = carcaj + flechas
    }
}

