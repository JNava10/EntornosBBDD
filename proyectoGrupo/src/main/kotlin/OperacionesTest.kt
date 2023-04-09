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
    }

    @org.junit.jupiter.api.Test
    fun obtCategoriaProd() {
    }

    @org.junit.jupiter.api.Test
    fun contrEmpleado() {
    }

    @org.junit.jupiter.api.Test
    fun despEmpleado() {
    }

    @org.junit.jupiter.api.Test
    fun cambiarPuesto() {
    }
}