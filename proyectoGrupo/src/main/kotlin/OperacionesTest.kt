import org.junit.jupiter.api.Assertions.*

internal class OperacionesTest {

    @org.junit.jupiter.api.Test
    fun obtEmpleado() {
        var dni="1111"
        var empleadoDAO=EmpleadoDAOImp()
        var emple=empleadoDAO.getEmpleadoByDni(dni)

        assertEquals("Pedro",emple?.nombre)

    }

    @org.junit.jupiter.api.Test
    fun obtTodosEmpl() {
        var empleadoDAO = EmpleadoDAOImp()
        var emple = empleadoDAO.getAllEmpleados()

        assertEquals(4,emple.size)
    }

    @org.junit.jupiter.api.Test
    fun obtTodosProductos() {
        var dao = ProductoDaoImp()
        var prop = dao.getAllProducto()

        assertEquals(12, prop.size)
    }

    @org.junit.jupiter.api.Test
    fun obtCategoriaProd() {
        val prod_cat = Prod_CatDAOImp()
        var codProd = 1
        var productos1 = prod_cat.getCatByCod_Prod(codProd)

        assertEquals(1,codProd)
    }

    @org.junit.jupiter.api.Test
    fun contrEmpleado() {
        var dao = EmpleadoDAOImp()
        var dniEmple:String = "23"
        var nEmpleado : String = "Paco"
        var puestoEmple:String = "3"
        var empleado1=Empleado(dniEmple,nEmpleado,puestoEmple)
        dao.insertEmpleado(empleado1)
    }

    @org.junit.jupiter.api.Test
    fun despEmpleado() {
        var dao = EmpleadoDAOImp()
        var dniEmple:String = "23"
        dao.deleteEmpleado(dniEmple)
    }

    @org.junit.jupiter.api.Test
    fun cambiarPuesto() {
        var dao = EmpleadoDAOImp()
        var dniEmple:String = "1111"
        var emple=dao.getEmpleadoByDni(dniEmple)
        var puesto= "2"
        dao.updateEmpleado(emple, puesto)
    }
}