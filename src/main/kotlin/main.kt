import java.util.*

fun main() {

    //creo la cola de salas
    val salas: Queue<Sala> = LinkedList<Sala>()

    //añado 36 salas a la cola
    for (num in 1..36) {
        salas.add(Sala(num))
    }

    //creo los personajes
    var Gandalf = Mago("Gandalf")
    var Legolas = Elfo("Legolas")
    var Frodo = Hobbit("Frodo")

    var numAle: Int
    var salasSuperadas = 0
    var derrota = false


        for (sala in salas) {

            if (Gandalf.estado && Legolas.estado && Frodo.estado) {

                when (sala.tipo) {
                    "magica" -> {

                        Gandalf.recargarVara(generaNumeroAleatorio(1, 10))

                        if (Gandalf.poderVara() > sala.poderMaligno) {
                            println("Gandalf gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                        } else if (Gandalf.poderVara() == sala.poderMaligno) {
                            numAle = generaNumeroAleatorio(1, 10)
                            if (numAle <= 6) {
                                println("Gandalf gana la batalla en la sala " + sala.numSala)
                                salasSuperadas++
                            } else {
                                if (huir()) {
                                    println("Gandalf ha perdido, pero lográn huir a la siguiente sala")
                                } else {
                                    println("Gandalf ha perdidio y no han conseguido huir")
                                    Gandalf.estado = false
                                }
                            }
                        } else if (Gandalf.poderVara() < sala.poderMaligno) {
                            numAle = generaNumeroAleatorio(1, 10)
                            if (numAle <= 3) {
                                println("Gandalf gana la batalla en la sala " + sala.numSala)
                                salasSuperadas++
                            } else {
                                if (huir()) {
                                    println("Gandalf ha perdido, pero lográn huir a la siguiente sala")
                                } else {
                                    println("Gandalf ha perdidio y no han conseguido huir")
                                    //salir = true
                                    Gandalf.estado = false
                                }
                            }
                        }
                    }

                    "accion" -> {

                        for (num in 0..sala.enemigos) {
                            if (Legolas.carcaj == 0) {
                                if (huir()) {
                                    println("Legolas se quedó sin flechas, pero lográn huir a la siguiente sala")
                                } else {
                                    println("Legolas ha perdidio y no han conseguido huir")
                                    //salir = true
                                    Legolas.estado = false
                                }
                            } else {
                                Legolas.lanzarFlecha()
                            }
                        }
                        println("Legolas gana la batalla en la sala " + sala.numSala)
                        salasSuperadas++
                        Legolas.recargarFlecha(sala.flechasSala)
                    }

                    "habilidad" -> {

                        numAle = generaNumeroAleatorio(1, 5)
                        var numAle2 = generaNumeroAleatorio(1, 10)

                        if (numAle <= 5 && numAle2 <= 9) {
                            println("Frodo gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                        } else if (numAle > 5 && numAle2 <= 2) {
                            println("Frodo gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                        } else {
                            if (huir()) {
                                println("Frodo ha perdido la batalla, pero lográn huir a la siguiente sala")
                            } else {
                                println("Frodo ha perdio y no han conseguido huir")
                                //salir = true
                                Frodo.estado = false
                            }
                        }
                    }
                }
            }else{
            derrota = true
            }
        }
}

fun huir(): Boolean {
    var h = false
    var numAle = generaNumeroAleatorio(1, 10)
    if (numAle <= 8) {
        h = true
    }
    return h
}