/**
 * Producto d a o
 *
 * @constructor Create empty Producto d a o
 */
interface ProductoDAO {
    /**
     * Get producto by codigo
     *
     * @param codigo
     * @return
     */
    fun getProductoByCodigo(codigo: Int): Producto?

    /**
     * Get all producto
     *
     * @return
     */
    fun getAllProducto(): List<Producto>

    /**
     * Insert producto
     *
     * @param producto
     * @return
     */
    fun insertProducto(producto: Producto): Boolean

    /**
     * Update producto nombre
     *
     * @param producto
     * @return
     */
    fun updateProductoNombre(producto: Producto): Boolean

    /**
     * Delete producto
     *
     * @param codigo
     * @return
     */
    fun deleteProducto(codigo: Int): Boolean
}