class CategoriaDAOImpl : CategoriaDAO {
    private val conexion = ConexionBD()

    override fun getCategoriaByCodigo(codigo: Int): Categoria? {
        conexion.conectar()
        val query = "SELECT * FROM categorias WHERE cod_grupo = ?"
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

    override fun getAllCategorias(): List<Categoria> {
        conexion.conectar()
        val query = "SELECT * FROM categorias"
        val st = conexion.getStatement()
        val rs = st?.executeQuery(query)
        val categorias = mutableListOf<Categoria>()
        while (rs?.next() == true) {
            val categoria = Categoria(rs.getInt("cod_grupo"), rs.getString("descripcion"))
            categorias.add(categoria)
        }
        st?.close()
        conexion.desconectar()
        return categorias
    }

    override fun insertCategoria(categoria: Categoria): Boolean {
        conexion.conectar()
        val query = "INSERT INTO categorias (cod_grupo, descripcion) VALUES (?, ?)"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, categoria.codigo)
        ps?.setString(2, categoria.descripcion)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun updateCategoria(categoria: Categoria): Boolean {
        conexion.conectar()
        val query = "UPDATE categorias SET descripcion = ? WHERE cod_grupo = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setString(1, categoria.descripcion)
        ps?.setInt(2, categoria.codigo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }

    override fun deleteCategoria(codigo: Int): Boolean {
        conexion.conectar()
        val query = "DELETE FROM categorias WHERE cod_grupo = ?"
        val ps = conexion.getPreparedStatement(query)
        ps?.setInt(1, codigo)
        val result = ps?.executeUpdate()
        ps?.close()
        conexion.desconectar()
        return result == 1
    }
}
