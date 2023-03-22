fun main() {

/**obtener todos los productos de una categoria
*/

var prod_cat=Prod_CatDAOImp()
var cat=1
var productos2=prod_cat.getAllProdbyCat(cat)
productos2.forEach{ println(it) }
}
