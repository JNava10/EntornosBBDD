package str

/**
 * str.NomTablas
 *
 * @constructor Clase que almacena los nombres
 * de las tablas existentes en la base de datos
 */
class NomTablas {
    companion object {
        var nombres = arrayListOf(
            "Categoria",
            "Empleado",
            "Prod_Cat",
            "Producto"
        )
        fun imprimir() {
            for (i in nombres.indices) {
                println("$i ${nombres[i]}")
            }
        }
    }
}