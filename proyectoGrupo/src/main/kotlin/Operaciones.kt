import java.lang.NumberFormatException

class Operaciones {
    private var prod_cat = Prod_CatDAOImp()
    private var empleadoDAO = EmpleadoDAOImp()
    private var categoriaDAO = CategoriaDAOImpl()

    var nomTabla = ""

    constructor(nomTabla: String) {
        this.nomTabla = nomTabla
    }

    fun insertarCategoria(codigo: Int, descripcion: String) {
        var categoria = categoriaDAO.insertCategoria(Categoria(codigo, descripcion))
        if (categoria) {
            println("Se ha insertado una nueva categoria:\n Codigo: $codigo\n Categoria: $categoria.")
        }
    }

    fun modificarCategoria(codigo: Int, descripcion: String) {
        var categoria = categoriaDAO.updateCategoria(Categoria(codigo, descripcion))
        if (categoria) {
            println("Se ha modificado la categoria con codigo $codigo")
        }
    }

    fun borrarCategoria(codigo: Int) {
        var categoria = categoriaDAO.deleteCategoria(codigo)
        if (categoria) {
            println("Se ha borrado la categoria con codigo $codigo.")
        }
    }

    fun obtEmpleado(dni: String) {
        /** Obtener los datos de un empleado
         * introduciendo su DNI
         */
        var empleado=empleadoDAO.getEmpleadoByDni(dni)
        println(empleado.toString())
    }

    fun contrEmpleado() {
        /** Funcion para contratar a un empleado**/
        println("DNI del empleado")
        var dniEmple:String= readln()
        println("Nombre del empleado")
        var nEmpleado : String= readln()
        println("Puesto del empleado")
        var puestoEmple:String= readln()
        var empleado1=Empleado(dniEmple,nEmpleado,puestoEmple)
        empleadoDAO.insertEmpleado(empleado1)
    }

    /**Funcion para despedir a un empleado**/
    fun despEmpleado() {
        println("Dame el DNI del trabajador que se va a despedir")
        var dniEmple = readln()
        empleadoDAO.deleteEmpleado(dniEmple)
    }

    /**
     * Obtener los datos de todos los empleados existentes.
     */
    fun obtTodosEmpl() {
        var empleados = empleadoDAO.getAllEmpleados()
        empleados.forEach { println(it) }
    }

    fun modificarEmpleado() {
        println("Introduce el DNI del empleado:\n")
        var dni = readln()

        println("Introduce el nombre del empleado:\n")
        var nombre = readln()

        println("Introduce el puesto del empleado:\n")
        var puesto = readln()

        // TODO
    }

    /** Obtener todos los productos de una categoria
     */
    fun obtTodosProductosCategoria() {
        var cat = 0

        try {
            println("Introduce el codigo de la categoria que quieras buscar:")
            cat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de producto que se ha introducido debe ser un numero.")
            obtTodosProductosCategoria()
        }

        var productosCat = prod_cat.getAllProdbyCat(cat)
        productosCat.forEach{ println(it) }
    }

    /** Obtener la categoria a la que pertenece un producto con codigo `codProd`
     * @return Contenido de la categoria pasado a String.
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

    /**Cambiar la categoria a la que pertenece un producto.
     */
    fun cambiarCategoriaProd() {
        var codProd = 0

        try {
            codProd = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de producto que se ha introducido debe ser un numero.")
            cambiarCategoriaProd()
        }

        // TODO: Añadir metodo en BBDD de actualizar cat.
    }

    fun cambiarPuesto() {
        println("Introduce el DNI del trabajador que va a cambiar de puesto:\n")
        var dniEmple: String = readln()

        var emple = empleadoDAO.getEmpleadoByDni(dniEmple)

        println("Datos del empleado")
        println(emple.toString())

        println("¿Que puesto va a tener este trabajador?")
        var puesto = readln()
        empleadoDAO.updateEmpleado(emple, puesto)
    }
}