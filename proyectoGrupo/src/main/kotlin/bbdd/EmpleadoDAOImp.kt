import java.sql.SQLIntegrityConstraintViolationException

/**
 * Empleado d a o imp
 *
 * @constructor Create empty Empleado d a o imp
 */
class EmpleadoDAOImp : EmpleadoDAO {
    private val conexion = ConexionBD()
    override fun getEmpleadoByDni(dni: String): Empleado? {
            conexion.conectar()
            val query = "SELECT * FROM empleados WHERE dni = ?"
            val ps = conexion.getPreparedStatement(query)
            ps?.setString(1, dni)
            val rs = ps?.executeQuery()
            var empleado: Empleado? = null
            if (rs?.next() == true) {
               empleado= Empleado(rs.getString("dni"), rs.getString("nombre"),rs.getString("puesto"))
            }
            ps?.close()
            conexion.desconectar()
            return empleado
        }

    override fun getAllEmpleados(): List<Empleado> {
        conexion.conectar()
        val query = "SELECT * FROM empleados"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val empleados = mutableListOf<Empleado>()
        while (rs?.next() == true) {
            val  empleado= Empleado(rs.getString("dni"), rs.getString("nombre"),rs.getString("puesto"))
            empleados.add(empleado)
        }
        st?.close()
        conexion.desconectar()
        return empleados
    }

    override fun insertEmpleado(empleado: Empleado): Boolean {
        conexion.conectar()
        var result:Int?=null
        val query = "INSERT INTO empleados (dni, nombre, puesto) VALUES (?, ?, ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, empleado.dni)
        ps?.setString(2, empleado.nombre)
        ps?.setString(3, empleado.puesto)
        try {
             result = ps?.executeUpdate()
        }catch (pk:SQLIntegrityConstraintViolationException){
            println("La clave primaria esta repetida")
        }
        ps?.close()
        conexion.desconectar()
        return result==1
    }

    override fun updateEmpleado(empleado: Empleado?,puesto:String): Boolean {
        conexion.conectar()
        val query = "UPDATE empleados SET puesto = ? WHERE dni = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, puesto)
        ps?.setString(2, empleado?.dni)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteEmpleado(dni: String): Boolean {
        conexion.conectar()
        val query = "DELETE FROM empleados WHERE dni = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, dni)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}
