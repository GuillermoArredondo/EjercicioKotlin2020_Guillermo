class Sala (var numSala: Int){

    var tipo = asignarTipo()
    var poderMaligno = asignarPoderMaligno()
    var flechasSala = asignarFlechasSala()
    var enemigos = asignarEnemigos()


    fun asignarTipo() :String{
        var tipo = ""
        var i = generaNumeroAleatorio(1,3)
        when (i){
            1 -> tipo = "magica"
            2 -> tipo = "accion"
            3 -> tipo = "habilidad"
        }
        return tipo
    }

    fun asignarPoderMaligno(): Int {
        return generaNumeroAleatorio(Parametros.MINPMALIGNO, Parametros.MAXPMALIGNO)
    }
    fun asignarFlechasSala(): Int {
        return generaNumeroAleatorio(Parametros.MINFLECHAS, Parametros.MAXFLECHAS)
    }
    fun asignarEnemigos(): Int {
        return generaNumeroAleatorio(Parametros.MINENEMIGOS, Parametros.MAXENEMIGOS)
    }
}
