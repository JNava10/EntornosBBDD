import str.Menu_str
var operaciones= Operaciones()
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
    println("4. Categoría de producto")
}

fun comprobarAccion(accion:Int) {
    when (accion){
        1 -> {
            imprimirOpcionesCat()
            var accion= pedirAccion()
            when(accion){
                1 -> operaciones.insertarCategoria()
                2 -> operaciones.borrarCategoria()
                3 -> operaciones.modificarCategoria()
            }
        }

        2 -> {
            imprimirOpcionesEmple()
            var accion= pedirAccion()
            when(accion){
                1 -> operaciones.contrEmpleado()
                2 -> operaciones.despEmpleado()
                3 -> operaciones.cambiarPuesto()
            }
        }

        3 -> {
            imprimirOpcionesProd()
            var accion= pedirAccion()
            when(accion){
                1 -> operaciones.contrEmpleado()
                2 -> operaciones.despEmpleado()
                3 -> operaciones.cambiarPuesto()
            }
        }

        4 -> {
            imprimirOpcionesProdCat()
            var accion= pedirAccion()
            when(accion){
                1 -> operaciones.contrEmpleado()
                2 -> operaciones.despEmpleado()
                3 -> operaciones.cambiarPuesto()
            }
        }
    }
}

fun imprimirOpcionesProd() {
    println("1.Añadir categoria")
    println("2.Borrar categoria")
    println("3.Modificar categoria")
}

fun imprimirOpcionesProdCat() {
    println("1.Añadir categoria")
    println("2.Borrar categoria")
    println("3.Modificar categoria")
}

fun imprimirOpcionesCat() {
    println("1.Añadir categoria")
    println("2.Borrar categoria")
    println("3.Modificar categoria")
}


fun imprimirOpcionesEmple() {
    println("1.Contratar empleado")
    println("2.Despedir empleado")
    println("3.Cambiar Puesto")
}

fun pedirAccion(): Int {
    var accion= 0
    try {
        accion = readln().toInt()
    } catch (ex: NumberFormatException) {
        println("Solo se puede introducir números")
        pedirAccion()
    }
    return accion
}


