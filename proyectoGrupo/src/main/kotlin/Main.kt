fun main() {

    /**obtener todos los productos de una categoria
     */

    var prod_cat = Prod_CatDAOImp()
    var cat = 1
//var productos2=prod_cat.getAllProdbyCat(cat)
//productos2.forEach{ println(it) }

    /** obtener los datos de la categoria a la que pertenece un producto introduciendo el codigo de producto**/

 //   var productos1 = prod_cat.getCatByCod_Prod(1)
   // println(productos1.toString())
    /** Obtener los datos de un empleado
     * introduciendo su DNI
     */

    //var dni ="1111"
   // var empleadoDAO=EmpleadoDAOImp()
 //   var empleado=empleadoDAO.getEmpleadoByDni(dni)
  //  println(empleado.toString())

/** funcion para obtener todos los empleados
 **/

   // var empleados = empleadoDAO.getAllEmpleados()
    //empleados.forEach { println(it) }

    /** Funcion para contratar a un empleado**/

   /*
   var empleadoDAO=EmpleadoDAOImp()
    println("DNI del empleado")
    var dniEmple:String= readln()
    println("Nombre del empleado")
    var nEmpleado : String= readln()
    println("Puesto del empleado")
    var puestoEmple:String= readln()
    var empleado1=Empleado(dniEmple,nEmpleado,puestoEmple)
    empleadoDAO.insertEmpleado(empleado1)
    */


    /**Funcion para despedir a un empleado**/

   /* var empleadoDAO=EmpleadoDAOImp()
    println("Dame el DNI del trabajador que se va a despedir")
    var dniEmple:String= readln()
    empleadoDAO.deleteEmpleado(dniEmple)
    */


    /**Funcion para cambiar el puesto a un trabajador*/

    /*
    var empleadoDAO=EmpleadoDAOImp()
    println("Dame el DNI del trabajador que va a cambiar de puesto")
    var dniEmple:String= readln()
    var emple=empleadoDAO.getEmpleadoByDni(dniEmple)
    println("Datos del empleado")
    println(emple.toString())
    println("Que puesto va a tener este trabajador")
    var puesto= readln()
    empleadoDAO.updateEmpleado(emple,puesto)
    */
}
