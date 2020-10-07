class Sala (var numSala: Int){

    var tipo = asignarTipo()
    var poderMaligno = asignarUnoDiez()
    var flechasSala = asignarUnoDiez()
    var enemigos = asignarUnoDiez()


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

    fun asignarUnoDiez(): Int{
        if (poderMaligno.equals("accion")){
            return generaNumeroAleatorio(1,10)
        }else
            return 0
    }

}
