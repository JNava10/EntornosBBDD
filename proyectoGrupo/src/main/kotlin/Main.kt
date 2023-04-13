import str.Menu_str

fun main() {
    println(Menu_str.bienvenida)
    mostrarTablas()
    var operaciones=Operaciones()
    var accion: Int = pedirNumero(4)
    comprobarAccion(accion,operaciones)

}

fun mostrarTablas() {
    println("Selecciona una de las siguientes")
    println("1. Categoría")
    println("2. Empleado")
    println("3. Producto")
    println("4. Categoría de producto")
}

fun comprobarAccion(accion:Int,operaciones:Operaciones) {
    when (accion){
        1 -> {
            imprimirOpcionesCat()
            var accion= pedirNumero(4)
            when(accion){
                1 -> operaciones.insertarCategoria()
                2 -> operaciones.borrarCategoria()
                3 -> operaciones.modificarCategoria()
                4 -> operaciones.obtTodasCat()
            }
        }

        2 -> {
            imprimirOpcionesEmple()
            var accion= pedirNumero(4)
            when(accion){
                1 -> operaciones.contrEmpleado()
                2 -> operaciones.despEmpleado()
                3 -> operaciones.cambiarPuesto()
                4 -> operaciones.obtTodosEmpl()
            }
        }

        3 -> {
            imprimirOpcionesProd()
            var accion= pedirNumero(5)
            when(accion){
                1 -> operaciones.altaProducto()
                2 -> operaciones.bajaProducto()
                3 -> operaciones.modificarPrecio()
                4->operaciones.modificarCantidad()
                5->{
                    operaciones.obtTProd()
                }
            }
        }

        4 -> {
            imprimirOpcionesProdCat()
            var accion= pedirNumero(2)
            when(accion){
                1 -> operaciones.obtTodosProdCat()
                2 -> println( operaciones.obtCategoriaProd())
                }
            }
        }
    }

fun imprimirOpcionesProd() {
    println("1.Añadir producto")
    println("2.Borrar producto")
    println("3.Modificar precio de un producto")
    println("4.Modificar cantidad de un producto")
    println("5.Consultar todos los productos")
}

fun imprimirOpcionesProdCat() {
    println("1.Consultar productos de una categoria")
    println("2.Consultar datos de una categoria de un producto")

}

fun imprimirOpcionesCat() {
    println("1.Añadir categoria")
    println("2.Borrar categoria")
    println("3.Modificar categoria")
    println("4. Obtener todas las categorias")
}


fun imprimirOpcionesEmple() {
    println("1.Contratar empleado")
    println("2.Despedir empleado")
    println("3.Cambiar Puesto")
    println("4.Obtener todos los empleados")
}

fun pedirNumero(n:Int): Int {
    var accion= 0
    var c =true

    do {
        try {
            accion = readln().toInt()
            if (accion>n){
                throw Exception("El numero no es correcto")
            }
        } catch (ex: NumberFormatException) {
            println("Solo se puede introducir números")
            c=false
        } catch (e:Exception){
            c=false
            println("El numero no es correcto")
        }
    if (accion<=n){
        c=true
    }
    }while (!c)

    return accion
}



