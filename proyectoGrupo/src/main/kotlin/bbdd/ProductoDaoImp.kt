/**
 * Producto dao imp
 *
 * @constructor Create empty Producto dao imp
 */
class ProductoDaoImp : ProductoDAO{
    private val conexion = ConexionBD()
    override fun getProductoByCodigo(codigo: Int): Producto? {
        conexion.conectar()
        val query = "SELECT * FROM productos WHERE cod_prod = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        val rs = ps?.executeQuery()
        var producto: Producto? = null
        if (rs?.next() == true) {
            producto = Producto(rs.getInt("cod_prod"), rs.getInt("cod_cat"),rs.getString("nombre"),rs.getInt("cant"),rs.getInt("precio"))
        }
        ps?.close()
        conexion.desconectar()
        return producto
    }

    override fun getAllProducto(): List<Producto> {
        conexion.conectar()
        val query = "SELECT * FROM productos"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val productos = mutableListOf<Producto>()
        while (rs?.next() == true) {
            val   producto = Producto(rs.getInt("cod_prod"), rs.getInt("cod_cat"),rs.getString("nombre"),rs.getInt("cant"),rs.getInt("precio"))
            productos.add(producto)
        }
        st?.close()
        conexion.desconectar()
        return productos
    }

    override fun insertProducto(producto: Producto): Boolean {
         conexion.conectar()
        val query = "INSERT INTO productos(cod_prod, cod_cat, nombre, cant, precio) VALUES (?, ?, ?, ?, ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, producto.codigo)
        ps?.setInt(2, producto.cod_cat)
        ps?.setString(3, producto.nombre)
        ps?.setInt(4, producto.cantidad)
        ps?.setInt(5, producto.precio)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateProductoNombre(producto: Producto): Boolean {
        conexion.conectar()
        val query = "UPDATE productos SET nombre = ? WHERE cod_prod = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, producto.nombre)
        ps?.setInt(2, producto.codigo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateProductoPrecio(producto: Producto?): Boolean {
            conexion.conectar()
            val query = "UPDATE productos SET precio = ? WHERE cod_prod = ?"
            val ps = conexion.getPreparedStatement(query)
        if (producto != null) {
            ps?.setInt(1, producto.precio)
        }
        if (producto != null) {
            ps?.setInt(2, producto.codigo)
        }
            val result = ps?.executeUpdate()
            ps?.close()
            conexion.desconectar()
            return result == 1

        }
    override fun updateProductoCantidad(producto: Producto?): Boolean {
        conexion.conectar()
        val query = "UPDATE productos SET cantidad = ? WHERE cod_prod = ?"
        val ps = conexion.getPreparedStatement(query)
        if (producto != null) {
            ps?.setInt(1, producto.cantidad)
        }
        if (producto != null) {
            ps?.setInt(2, producto.codigo)
        }
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1

    }

    override fun deleteProducto(codigo: Int): Boolean {
        conexion.conectar()
        val query = "DELETE FROM productos WHERE cod_prod = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}