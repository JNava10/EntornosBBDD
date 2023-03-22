interface Prod_CatDAO {
    fun getCatByCod_Prod(codigo: Int): Categoria?
    fun getAllProdbyCat(cod_cat:Int): List<Producto>
}