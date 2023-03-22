interface ProductoDAO {
    fun getProductoByCodigo(codigo: Int): Producto?
    fun getAllProducto(): List<Producto>
    fun insertProducto(producto: Producto): Boolean
    fun updateProductoNombre(producto: Producto): Boolean
    fun deleteProducto(codigo: Int): Boolean
}