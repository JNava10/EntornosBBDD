import str.*

class Operaciones {
    private var prod_cat = Prod_CatDAOImp()
    private var empleadoDAO = EmpleadoDAOImp()

    var nomTabla = ""

    constructor(nomTabla: String) {
        this.nomTabla = nomTabla
    }


/**FUNCIONES DE CONSULTA**/
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
        var dao=ProductoDaoImp()
        var productos2=dao.getAllProducto()
        productos2.forEach{ println(it) }
    }
    fun obtTodosProductosPorCategoria(categoria: Int) {
        var productos2=prod_cat.getAllProdbyCat(categoria)
        productos2.forEach{ println(it) }
    }
    fun obtProducto(cod:Int){
        var dao=ProductoDaoImp()
        var prod=dao.getProductoByCodigo(cod)
        println(prod.toString())
    }
    fun obtTodoProductos(){
        var dao=ProductoDaoImp()
        var prod=dao.getAllProducto()
        prod.forEach{ println(it) }
    }

    fun obtCategoriaProd(codProd: Int) {
        /** obtener los datos de la categoria a la que pertenece un producto introduciendo el codigo de producto**/
        var productos1 = prod_cat.getCatByCod_Prod(codProd)
        println(productos1.toString())
    }
    fun obtCategoria(cod: Int){
        var dao=CategoriaDAOImpl()
        var c=dao.getCategoriaByCodigo(cod)
        println(c.toString())
    }
    fun obtTodoCategoria(){
        var dao=CategoriaDAOImpl()
        var c=dao.getAllCategorias()
        c.forEach { println(it) }
    }


/**FUNCIONES DE MODIFICACION**/
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


    /**Funcion para modificar precio de un producto**/
    fun modPrecio(cod:Int,precio:Int){
        var dao=ProductoDaoImp()
        var producto:Producto?
        producto=dao.getProductoByCodigo(cod)

        if (producto != null) {
            producto.precio=precio
        }
        dao.updateProductoPrecio(producto)
    }
    fun altaProd(){
        println("COD del producto")
        var cod= readln().toInt()
        println("Nombre del producto")
        var n: String= readln()
        println("Categoria del producto")
        var c= readln().toInt()
        println("Cantidad")
        var can= readln().toInt()
        println("Precio")
        var pre= readln().toInt()
        var prod=Producto(cod,c,n,can,pre)
        var dao=ProductoDaoImp()
        dao.insertProducto(prod)

    }
    fun bajaProd(){
        println("Introduce el codigo del producto a dar de baja")
        var cod= readln().toInt()
        var dao=ProductoDaoImp()
        dao.deleteProducto(cod)
    }
    fun modCantidad(cod:Int,cant:Int){
        var dao=ProductoDaoImp()
        var producto:Producto?
        producto=dao.getProductoByCodigo(cod)

        if (producto != null) {
            producto.cantidad=cant
        }
        dao.updateProductoPrecio(producto)

    }




}