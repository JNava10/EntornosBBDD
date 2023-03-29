import str.*

class Operaciones {
    private var prod_cat = Prod_CatDAOImp()
    private var empleadoDAO = EmpleadoDAOImp()

    var nomTabla = ""

    constructor(nomTabla: String) {
        this.nomTabla = nomTabla
    }

    fun obtEmpleado(dni: String) {
        /** Obtener los datos de un empleado
         * introduciendo su DNI
         */
        var empleado=empleadoDAO.getEmpleadoByDni(dni)
        println(empleado.toString())
    }

    fun obtTodosEmpl() {
        var empleados = empleadoDAO.getAllEmpleados()
        empleados.forEach { println(it) }
    }

    /**Obtener todos los productos de una categoria
     */
    fun obtTodosProductos() {
        var cat = 1
        var productos2=prod_cat.getAllProdbyCat(cat)
        productos2.forEach{ println(it) }
    }

    fun obtCategoriaProd(codProd: Int) {
        /** obtener los datos de la categoria a la que pertenece un producto introduciendo el codigo de producto**/
        var productos1 = prod_cat.getCatByCod_Prod(codProd)
        println(productos1.toString())
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
        var dniEmple:String= readln()
        empleadoDAO.deleteEmpleado(dniEmple)
    }

    fun cambiarPuesto() {
        println("Dame el DNI del trabajador que va a cambiar de puesto")
        var dniEmple:String = readln()
        var emple=empleadoDAO.getEmpleadoByDni(dniEmple)
        println("Datos del empleado")
        println(emple.toString())
        println("¿Que puesto va a tener este trabajador?")
        var puesto= readln()
        empleadoDAO.updateEmpleado(emple, puesto)
    }
}