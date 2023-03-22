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

    var dni ="1111"
    var empleadoDAO=EmpleadoDAOImp()
    var empleado=empleadoDAO.getEmpleadoByDni(dni)
  //  println(empleado.toString())

/** funcion para obtener todos los empleados
 **/

    var empleados = empleadoDAO.getAllEmpleados()
    empleados.forEach { println(it) }

}
