/**
 * Categoria d a o
 *
 * @constructor Create empty Categoria d a o
 */

val campos = arrayListOf(
    "codigo",
    "descripcion"
)

interface CategoriaDAO {


    /**
     * Get categoria by codigo
     *
     * @param codigo
     * @return
     */
    fun getCategoriaByCodigo(codigo: Int): Categoria?

    /**
     * Get all categorias
     *
     * @return
     */
    fun getAllCategorias(): List<Categoria>

    /**
     * Insert categoria
     *
     * @param categoria
     * @return
     */
    fun insertCategoria(categoria: Categoria): Boolean

    /**
     * Update categoria
     *
     * @param categoria
     * @return
     */
    fun updateCategoria(categoria: Categoria): Boolean

    /**
     * Delete categoria
     *
     * @param codigo
     * @return
     */
    fun deleteCategoria(codigo: Int): Boolean
}
