class Prod_CatDAOImp:Prod_CatDAO {
    private val conexion = ConexionBD()
    override fun getCatByCod_Prod(codigo: Int): Categoria? {
        conexion.conectar()
        val query = "SELECT * FROM categorias WHERE cod_grupo = (select cod_cat from productos where cod_prod = ?"
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
        val query = "SELECT * FROM productos WHERE cod_cat = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1,cod_cat)
        val rs = ps?.executeQuery(query)
        val productos = mutableListOf<Producto>()
        while (rs?.next() == true) {
            val producto = Producto(rs.getInt("cod_prod"), rs.getInt("cod_cat"),rs.getString("nombre"),rs.getInt("cantidad"),rs.getInt("precio"))
            productos.add(producto)
        }
        ps?.close()
        conexion.desconectar()
        return productos
    }
}