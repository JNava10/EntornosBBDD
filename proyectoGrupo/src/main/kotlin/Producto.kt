class Producto(val codigo:Int,val cod_cat:Int,val nombre:String,val cantidad:Int,val precio:Int) {
    override fun toString(): String {
        return "Producto(codigo=$codigo, cod_cat=$cod_cat, nombre='$nombre', cant=$cantidad, precio=$precio)"
    }
}