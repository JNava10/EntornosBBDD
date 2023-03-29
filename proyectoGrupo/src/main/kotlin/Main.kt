import str.Menu_str

fun main() {
    println(Menu_str.bienvenida)
    var accion: Int = pedirAccion()
    comprobarAccion()

}


fun mostrarTablas() {
    println("Selecciona una de las siguientes")
    println("1. Categoría")
    println("2. Empleado")
    println("3. Producto")
}

fun comprobarAccion() {

}

fun pedirAccion(): Int {
    try {
        var accion = readln().toInt()
    } catch (ex: NumberFormatException) {
        println("Solo se puede introducir números")
        pedirAccion()

    }
}
