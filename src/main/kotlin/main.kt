import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
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

    //declaracion de variables
    var esc = Escritor()
    var numAle: Int
    var salasSuperadas = 0
    var derrota = false
    var nDerrota = 0

    //empiezo la simulacion
    esc.addText("Fecha de inicio: "+obtenerFecha())
    esc.addText("----------------------------------------------------------------------------------")
    esc.addText("--------------------LA COMPAÑIA DEL ANILLO SE ADENTRA EN MORIA--------------------")
    esc.addText("----------------------------------------------------------------------------------")
    esc.addText("---Gandalf cuenta con "+Gandalf.poderVara()+" puntos de poder y Legolas tiene "+Legolas.carcaj+" flechas en su carcaj---")

        for (sala in salas) {

            if (Gandalf.estado && Legolas.estado && Frodo.estado) {

                when (sala.tipo) {
                    "magica" -> {

                        Gandalf.recargarVara(generaNumeroAleatorio(1, 10))

                        if (Gandalf.poderVara() > sala.poderMaligno) {
                            esc.addText("Gandalf gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                        } else if (Gandalf.poderVara() == sala.poderMaligno) {
                            numAle = generaNumeroAleatorio(1, 10)
                            if (numAle <= 6) {
                                esc.addText("Gandalf gana la batalla en la sala " + sala.numSala)
                                salasSuperadas++
                            } else {
                                if (huir()) {
                                    esc.addText("Gandalf ha perdido, pero lográn huir a la siguiente sala")
                                } else {
                                    esc.addText("Gandalf ha perdidio y no han conseguido huir")
                                    Gandalf.estado = false
                                    nDerrota = sala.numSala
                                }
                            }
                        } else if (Gandalf.poderVara() < sala.poderMaligno) {
                            numAle = generaNumeroAleatorio(1, 10)
                            if (numAle <= 3) {
                                esc.addText("Gandalf gana la batalla en la sala " + sala.numSala)
                                salasSuperadas++
                            } else {
                                if (huir()) {
                                    esc.addText("Gandalf ha perdido, pero lográn huir a la siguiente sala")
                                } else {
                                    esc.addText("Gandalf ha perdidio y no han conseguido huir")
                                    Gandalf.estado = false
                                    nDerrota = sala.numSala
                                }
                            }
                        }
                    }

                    "accion" -> {

                        while (sala.enemigos > 0) {
                            if (Legolas.carcaj == 0) {
                                if (huir()) {
                                    esc.addText("Legolas se quedó sin flechas, pero lográn huir a la siguiente sala")
                                    sala.enemigos = 0
                                } else {
                                    esc.addText("Legolas ha perdidio y no han conseguido huir")
                                    Legolas.estado = false
                                    nDerrota = sala.numSala
                                }
                            } else
                                Legolas.lanzarFlecha()
                                sala.enemigos--
                        }

                        if (Legolas.estado) {
                            esc.addText("Legolas gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                            Legolas.recargarFlecha(sala.flechasSala)
                        }
                    }

                    "habilidad" -> {

                        numAle = generaNumeroAleatorio(1, 5)
                        var numAle2 = generaNumeroAleatorio(1, 10)

                        if (numAle <= 5 && numAle2 <= 9) {
                            esc.addText("Frodo gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                        } else if (numAle > 5 && numAle2 <= 2) {
                            esc.addText("Frodo gana la batalla en la sala " + sala.numSala)
                            salasSuperadas++
                        } else {
                            if (huir()) {
                                esc.addText("Frodo ha perdido la batalla, pero lográn huir a la siguiente sala")
                            } else {
                                esc.addText("Frodo ha perdio y no han conseguido huir")
                                Frodo.estado = false
                                nDerrota = sala.numSala
                            }
                        }
                    }
                }
            }else{
            derrota = true
            }
        }
    esc.addText("----------------------------------------------------------------------------------")
    if (derrota){
        esc.addText("La compañia ha sido derrotada en la sala "+nDerrota)
        esc.addText("Han superado un total de "+salasSuperadas+" salas")
    }else{
        esc.addText("La compañia ha logrado pasar Moria!")
        esc.addText("Han superado un total de "+salasSuperadas+" salas")
    }
    esc.addText("----------------------------------------------------------------------------------")
    esc.addText("Fecha fin: "+obtenerFecha())
    esc.addText("")

    esc.escribir()
}

//funcion que devuelve si la huida es efectiva o no
fun huir(): Boolean {
    var h = false
    var numAle = generaNumeroAleatorio(1, 10)
    if (numAle <= 8) {
        h = true
    }
    return h
}

//funcion que devuelve la fecha con formato de anio, mes, dia, hora, minutos y segundos
fun obtenerFecha():String{
    val current = LocalDateTime.now()
    var fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val fechaFormateada = current.format(fecha)
    return fechaFormateada
}

//funcion que devuelve un número aleatorio entre dos valores
fun generaNumeroAleatorio(min: Int, max: Int): Int {
    return Math.floor(Math.random() * (max - min + 1) + min).toInt()
}