/**
 * Empleado d a o
 *
 * @constructor Create empty Empleado d a o
 */
interface EmpleadoDAO {
    /**
     * Get empleado by dni
     *
     * @param dni
     * @return
     */
    fun getEmpleadoByDni(dni: String): Empleado?

    /**
     * Get all empleados
     *
     * @return
     */
    fun getAllEmpleados(): List<Empleado>

    /**
     * Insert empleado
     *
     * @param empleado
     * @return
     */
    fun insertEmpleado(empleado: Empleado): Boolean

    /**
     * Update empleado
     *
     * @param empleado
     * @return
     */
    fun updateEmpleado(empleado: Empleado?,puesto:String): Boolean

    /**
     * Delete empleado
     *
     * @param dni
     * @return
     */
    fun deleteEmpleado(dni: String): Boolean
}