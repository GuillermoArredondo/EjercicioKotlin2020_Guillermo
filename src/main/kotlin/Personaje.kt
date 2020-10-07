open class Personaje (var nombre: String, var estado: Boolean){

}

//funcion que devuelve un número aleatorio entre dos valores
fun generaNumeroAleatorio(min: Int, max: Int): Int {
    return Math.floor(Math.random() * (max - min + 1) + min).toInt()
}