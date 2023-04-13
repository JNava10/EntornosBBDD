import java.lang.Exception
import java.sql.ResultSet
import java.sql.SQLIntegrityConstraintViolationException

/**
 * Producto dao imp
 *
 * @constructor Create empty Producto dao imp
 */
class ProductoDAOImp: ProductoDAO {
    private val conexion = ConexionBD()
    override fun getProductoByCodigo(codigo: Int): Producto? {
        conexion.conectar()
        var rs:ResultSet?=null
        val query = "SELECT * FROM productos WHERE cod_prod = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        try {
             rs = ps?.executeQuery()
        }catch (e:Exception){
            println("Clave primaria no valida")
        }

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
        var result:Int?=0
        val query = "INSERT INTO productos(cod_prod, cod_cat, nombre, cant, precio) VALUES (?, ?, ?, ?, ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, producto.codigo)
        ps?.setInt(2, producto.cod_cat)
        ps?.setString(3, producto.nombre)
        ps?.setInt(4, producto.cantidad)
        ps?.setInt(5, producto.precio)
        try {
            result = ps?.executeUpdate()
        }catch (e:SQLIntegrityConstraintViolationException){
            println("Clave primaria repetida")
        }
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
        val query = "UPDATE productos SET cant = ? WHERE cod_prod = ?"
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
        var result:Int?=0
        val query = "DELETE FROM productos WHERE cod_prod = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        try {
             result = ps?.executeUpdate()
        }catch (e:Exception){
            println("Esa clave primaria no existe")
        }

        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}