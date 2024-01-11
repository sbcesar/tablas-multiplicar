/**
 * Solicita un número entero en un rango.
 *
 * @param min Int - valor mínimo
 * @param max Int - valor máximo
 *
 * @return Int - número entero válido dentro del rango especificado
 */
fun pedirNum(min: Int, max: Int): Int? {
    println("Introduzca un número entre $min y $max: ")
    val num = readln().toIntOrNull()

    if (num in min..max) {
        return num
    } else {
        return null
    }
}


/**
 * Realiza una pregunta para contestar con s/si ó n/no
 *
 * @param text String - Texto de la pregunta
 *
 * @return Boolean - true/false dependiendo de la respuesta válida a la pregunta
 */
fun pregunta(text: String): Boolean {
    var mensaje: String

    while (true) {
        println("$text (s/n): ")
        mensaje = readln()
        if (mensaje == "s" || mensaje == "n") {
            break
        }
    }
    return mensaje == "s"
}

fun main() {
    //TODO: Solicitar la introducción de un número entre 1 y 100 y mostrar su table de multiplicar...
    //Hasta que se responda negativamente a la pregunta "¿Desea generar otra tabla de multiplicación? (s/n)"

    var bandera = false

    while (true) {
        val numero = pedirNum(1,100)

        if (numero == null) {
            println("**Error** Número no válido (prulse ENTER para continuar...)")
            readln()
            continue
        }

        val tabla = Array(10) { i -> numero * (i + 1) } // el lambda calcula los valores de la tabla de multiplicar del numero introducido (1..10) que están dentro del contructor (Array) de tamaño 10

        println("La tabla de multiplicar del número $numero es: ")

        for (i in 1..10) {
            println("$i -> $numero x $i = ${tabla[i - 1]}")
        }

        bandera = pregunta("¿Desea generar otra tabla de multiplicación?")
        if (!bandera) {
            break
        }
    }
}