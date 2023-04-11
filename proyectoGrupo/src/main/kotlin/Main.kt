import str.Menu_str
var operaciones= Operaciones()
fun main() {
    println(Menu_str.bienvenida)
    var accion: Int = pedirNumero()
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
            var accion= pedirNumero()
            when(accion){
                1 -> operaciones.insertarCategoria()
                2 -> operaciones.borrarCategoria()
                3 -> operaciones.modificarCategoria()
                4 -> operaciones.obt
            }
        }

        2 -> {
            imprimirOpcionesEmple()
            var accion= pedirNumero()
            when(accion){
                1 -> operaciones.contrEmpleado()
                2 -> operaciones.despEmpleado()
                3 -> operaciones.cambiarPuesto()
                4 -> operaciones.obtTodosEmpl()
            }
        }

        3 -> {
            imprimirOpcionesProd()
            var accion= pedirNumero()
            when(accion){
                1 -> operaciones.contrEmpleado()
                2 -> operaciones.despEmpleado()
                3 -> operaciones.cambiarPuesto()
            }
        }

        4 -> {
            imprimirOpcionesProdCat()
            var accion= pedirNumero()
            when(accion){
                1 -> operaciones.obtCategoriaProd()
                2 -> operaciones.cat()
                3 -> operaciones.cambiarCategoriaProd()
                4 -> operaciones.obtTodosProdCat()
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
    println("4.Obtener todos los productos de categoria")
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
    println("4.Obtener todos los empleados")
}

fun pedirNumero(): Int {
    var accion= 0
    try {
        accion = readln().toInt()
    } catch (ex: NumberFormatException) {
        println("Solo se puede introducir números")
        pedirNumero()
    }
    return accion
}



