class Sala (var numSala: Int){

    var poderMaligno = asignarPoderMaligno()
    var flechasSala = asignarAccion()
    var enemigos = asignarAccion()


    fun asignarPoderMaligno() :String{
        var poder = ""
        var i = generaNumeroAleatorio(1,3)
        when (i){
            1 -> poder = "magico"
            2 -> poder = "accion"
            3 -> poder = "habilidad"
        }
        return poder
    }

    fun asignarAccion(): Int{
        if (poderMaligno.equals("accion")){
            return generaNumeroAleatorio(1,10)
        }else
            return 0
    }

}
