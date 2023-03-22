class Empleado(val dni:String, val nombre:String, val puesto:String) {
    override fun toString(): String {
        return "Empleado(dni='$dni', nombre='$nombre', puesto='$puesto')"
    }
}