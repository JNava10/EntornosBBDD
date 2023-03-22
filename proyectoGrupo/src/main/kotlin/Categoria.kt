/**
 * Categoria
 *
 * @property codigo
 * @property descripcion
 * @constructor Create empty Categoria
 */
class Categoria(val codigo: Int, var descripcion: String) {
    override fun toString(): String {
        return "Categoria [codigo=$codigo, descripcion=$descripcion]"
    }
}
