/**
 * Prod_cat d a o imp
 *
 * @constructor Create empty Prod_cat d a o imp
 */
class Prod_CatDAOImp:Prod_CatDAO {
    private val conexion = ConexionBD()
    override fun getCatByCod_Prod(codigo: Int): Categoria? {
        conexion.conectar()
        val query = "SELECT * FROM categorias WHERE cod_grupo = (select cod_cat from productos where cod_prod = ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        val rs = ps?.executeQuery()
        var categoria: Categoria? = null
        if (rs?.next() == true) {
            categoria = Categoria(rs.getInt("cod_grupo"), rs.getString("descripcion"))
        }
        ps?.close()
        conexion.desconectar()
        return categoria
    }

    override fun getAllProdbyCat(cod_cat: Int): List<Producto> {
        conexion.conectar()
        val query = "SELECT * FROM productos WHERE COD_CAT = $cod_cat"
        val ps = conexion.getPreparedStatement(query)
        //ps?.setInt(1, cod_cat)
        val rs = ps?.executeQuery(query)
        val productos = mutableListOf<Producto>()
        while (rs?.next() == true) {
            val producto = Producto(rs.getInt("cod_prod"), rs.getInt("cod_cat"),rs.getString("nombre"),rs.getInt("cant"),rs.getInt("precio"))
            productos.add(producto)
        }
        ps?.close()
        conexion.desconectar()
        return productos
    }

    /** Cambiar la categoria de un producto.
     * @param codProd
     * @param cod_cat
     */
    override fun updateCatProd(cod_prod: Int, cod_cat: Int) {
        conexion.conectar()
        val query = "UPDATE Producto SET cod_cat = ? WHERE cod_prod LIKE ?"

        val preparedStatement = conexion.getPreparedStatement(query)

        preparedStatement?.setInt(1, cod_cat)
        preparedStatement?.setInt(2, cod_prod)

        val resultSet = preparedStatement?.executeQuery(query)
        preparedStatement?.close()
        conexion.desconectar()
    }
}