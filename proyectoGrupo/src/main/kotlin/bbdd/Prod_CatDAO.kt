/**
 * Prod_cat d a o
 *
 * @constructor Create empty Prod_cat d a o
 */
interface Prod_CatDAO {
    /**
     * Get cat by cod_prod
     *
     * @param codigo
     * @return
     */
    fun getCatByCod_Prod(codigo: Int): Categoria?

    /**
     * Get all prodby cat
     *
     * @param cod_cat
     * @return
     */
    fun getAllProdbyCat(cod_cat:Int): List<Producto>
    fun updateCatProd(cod_prod: Int, cod_cat: Int)
}