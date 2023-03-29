import java.lang.NumberFormatException

class Operaciones {
    private var prod_cat = Prod_CatDAOImp()
    private var empleadoDAO = EmpleadoDAOImp()
    private var categoriaDAO = CategoriaDAOImpl()

    // Empleado //

    /** Obtener todos los empleados existentes. */
    fun obtTodosEmpl() {
        var empleados = empleadoDAO.getAllEmpleados()
        empleados.forEach { println(it) }
    }

    /** Obtener los datos de un empleado introduciendo su DNI */
    fun obtEmpleado() {
        var dni = readln()

        var empleado = empleadoDAO.getEmpleadoByDni(dni)
        println(empleado.toString())
    }

    /**Funcion para despedir a un empleado**/
    fun despEmpleado() {
        println("Dame el DNI del trabajador que se va a despedir")
        var dniEmple: String = readln()

        empleadoDAO.deleteEmpleado(dniEmple)
    }

    /** Contratar a un empleado introduciendo sus datos. */
    fun contrEmpleado() {
        println("DNI del empleado")
        var dniEmple: String = readln()

        println("Nombre del empleado")
        var nEmpleado: String = readln()

        println("Puesto del empleado")
        var puestoEmple: String = readln()

        var empleado1 = Empleado(dniEmple, nEmpleado, puestoEmple)
        empleadoDAO.insertEmpleado(empleado1)
    }

    fun cambiarPuesto() {
        println("Introduce el DNI del empleado que va a cambiar de puesto:\n")
        var dniEmple: String = readln()

        var emple = empleadoDAO.getEmpleadoByDni(dniEmple)

        println("Datos del empleado")
        println(emple.toString())

        println("¿Que puesto va a tener este trabajador?")
        var puesto = readln()

        empleadoDAO.updateEmpleado(emple, puesto)
    }

    // Categoria //

    /** Obtener todos los productos pertenecientes a una categoria. */
    fun insertarCategoria() {
        var codCat = 0
        var descCat = ""

        try {
            println("Introduce el codigo de la categoria que quieres insertar:")
            codCat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de categoria que se ha introducido debe ser un numero.")
            codCat = readln().toInt() // FIXME
        }

        println("Introduce la descripcion de la categoria que quieres insertar:")
        descCat = readln()

        var categoria = categoriaDAO.insertCategoria(Categoria(codCat, descCat))

        if (categoria) {
            println("Se ha insertado una nueva categoria:\n Codigo: $codCat\n Descripción: $descCat.")
        }
    }

    fun modificarCategoria() {
        var codCat = 0
        var descCat = ""

        try {
            println("Introduce el codigo de la categoria que quieres modificar:")
            codCat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de categoria que se ha introducido debe ser un numero.")
            codCat = readln().toInt() // FIXME
        }

        println("Introduce la descripcion de la categoria que quieras modificar:")
        descCat = readln()

        var categoria = categoriaDAO.updateCategoria(Categoria(codCat, descCat))

        if (categoria) {
            println("Se ha modificado la categoria con codigo $codCat")
        }
    }

    fun borrarCategoria() {
        var codCat = 0
        try {
            println("Introduce el codigo de la categoria que quieres borrar:")
            codCat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de categoria que se ha introducido debe ser un numero.")
            codCat = readln().toInt() // FIXME
        }

        var categoria = categoriaDAO.deleteCategoria(codCat)

        if (categoria) {
            println("Se ha borrado la categoria con codigo $codCat.")
        }
    }

    // Categorias de productos

    /** Obtener todos los productos de una categoria */
    fun obtTodosProdCat() {
        var codCat = 0
        try {
            codCat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de categoria que se ha introducido debe ser un numero.")
            cambiarCategoriaProd()
        }

//        var producto = prod_cat.getAllProdbyCat(codCats)
//        producto.forEach{ println(it) }
    }

    /** Obtener la categoria a la que pertenece un producto.
     * @return `producto.toString()`: Contenido de la categoria pasado a String.
     */
    fun obtCategoriaProd(): String {
        var codProd = 0

        try {
            codProd = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de producto que se ha introducido debe ser un numero.")
            obtCategoriaProd()
        }

        var producto = prod_cat.getCatByCod_Prod(codProd)
        return producto.toString()
    }

    /** Cambiar la categoria a la que pertenece un producto. */
    fun cambiarCategoriaProd() {
        var codProd = 0

        try {
            println("Introduce el codigo de la categoria que se quiere obtener:\n")
            codProd = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de producto que se ha introducido debe ser un numero.")
            codProd = readln().toInt() // FIXME
        }

        // TODO: Añadir metodo en BBDD de actualizar cat.
    }
}