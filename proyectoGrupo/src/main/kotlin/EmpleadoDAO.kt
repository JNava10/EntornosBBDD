interface EmpleadoDAO {
    fun getEmpleadoByDni(dni: String): Empleado?
    fun getAllEmpleados(): List<Empleado>
    fun insertEmpleado(empleado: Empleado): Boolean
    fun updateEmpleado(empleado: Empleado): Boolean
    fun deleteEmpleado(dni: String): Boolean
}