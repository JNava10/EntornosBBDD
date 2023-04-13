class Operaciones {
    var prod_cat = Prod_CatDAOImp()
    var empleadoDAO = EmpleadoDAOImp()
    var categoriaDAO = CategoriaDAOImpl()

    // Empleado //

    /** Obtener todos los empleados existentes. */
    fun obtTodosEmpl() {
        var empleados = empleadoDAO.getAllEmpleados()
        empleados.forEach { println(it) }
    }

    /** Obtener los datos de un empleado introduciendo su DNI */
    fun obtEmpleado() {
        var dni = readln()

        var empleado = empleadoDAO.getEmpleadoByDni(dni)
        println(empleado.toString())
    }

    /**Funcion para despedir a un empleado**/
    fun despEmpleado() {
        println("Dame el DNI del trabajador que se va a despedir")
        var dniEmple: String = readln()

        empleadoDAO.deleteEmpleado(dniEmple)
    }

    /** Contratar a un empleado introduciendo sus datos. */
    fun contrEmpleado() {
        var r=false
        var dniEmple: Int=0
        while (!r){
            var r2=false
            while (!r2) {
                r2=true
                println("DNI del empleado")
                try {
                    dniEmple = readln().toInt()
                    if (dniEmple.toString().length > 10) {
                        throw Exception()
                    }
                } catch (e2: NumberFormatException) {
                    println("El dni debe ser un numero")
                    r2=false
                }catch (E: Exception) {
                    println("Se ha excedido el tamaño maximo (10) ")
                    r2=false
            }
            println("Nombre del empleado")
            var nEmpleado: String = readln()

            println("Puesto del empleado")
            var puestoEmple: String = readln()

            var empleado1 = Empleado(dniEmple.toString(), nEmpleado, puestoEmple)
            r=empleadoDAO.insertEmpleado(empleado1)
        }
    }}

    fun cambiarPuesto() {
        println("Introduce el DNI del empleado que va a cambiar de puesto:\n")
        var dniEmple: String = readln()

        var emple = empleadoDAO.getEmpleadoByDni(dniEmple)

        println("Datos del empleado")
        println(emple.toString())

        println("¿Que puesto va a tener este trabajador?")
        var puesto = readln()

        empleadoDAO.updateEmpleado(emple, puesto)
    }

    // Categoria //

    /** Obtener todos los productos pertenecientes a una categoria. */
    fun insertarCategoria() {
        var codCat = 0
        var descCat = ""

        var categoria=false
        while (!categoria) {
            var b=false
            while (!b) {
                b = true
                try {
                    println("Introduce el codigo de la categoria que quieres insertar:")
                    codCat = readln().toInt()
                } catch (numEx: NumberFormatException) {
                    b = false
                    println("El codigo de categoria que se ha introducido debe ser un numero.")
                    codCat = readln().toInt() // FIXME
                }
            }

            b = false
            while (!b) {
                b = true
                try {
                    println("Introduce la descripcion de la categoria que quieres insertar:")
                    descCat = readln()
                    if (descCat.length > 40) {
                        throw Exception()
                    }
                } catch (e: Exception) {
                    println("La descripcion ha superado el limite (40)")
                    b = false
                }
            }
            categoria = categoriaDAO.insertCategoria(Categoria(codCat, descCat))
        }
        if (categoria) {
            println("Se ha insertado una nueva categoria:\n Codigo: $codCat\n Descripción: $descCat.")
        }
    }

    fun modificarCategoria() {
        var codCat = 0
        var descCat = ""

        try {
            println("Introduce el codigo de la categoria que quieres modificar:")
            codCat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de categoria que se ha introducido debe ser un numero.")
            codCat = readln().toInt() // FIXME
        }

        println("Introduce la descripcion de la categoria que quieras modificar:")
        descCat = readln()

        var categoria = categoriaDAO.updateCategoria(Categoria(codCat, descCat))

        if (categoria) {
            println("Se ha modificado la categoria con codigo $codCat")
        }
    }

    fun borrarCategoria() {
        var codCat = 0
        try {
            println("Introduce el codigo de la categoria que quieres borrar:")
            codCat = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de categoria que se ha introducido debe ser un numero.")
            codCat = readln().toInt() // FIXME
        }

        var categoria = categoriaDAO.deleteCategoria(codCat)

        if (categoria) {
            println("Se ha borrado la categoria con codigo $codCat.")
        }
    }

    fun obtTodasCat() {
        var categorias = categoriaDAO.getAllCategorias()
        for (i in categorias.indices) {
            println("Categoria ${categorias[i].codigo} - ${categorias[i].descripcion}")
        }
    }

    // Categorias de productos

    /** Obtener todos los productos de una categoria */
    fun obtTodosProdCat() {
        var codCat=0
        var r=false
        var cDAO=CategoriaDAOImpl()
        var categorias=cDAO.getAllCategorias()
        categorias.forEach { println(it) }
        println("Introduce un numero de categoria")
        while (!r) {
            r=true
            try {
                codCat = readln().toInt()
            } catch (numEx: NumberFormatException) {
                println("El codigo de categoria que se ha introducido debe ser un numero.")
                r=false
            }
            var categoria=cDAO.getCategoriaByCodigo(codCat)
            if (!categoria?.codigo.toString().equals(codCat.toString())){
                r=false
                println("Codigo de categoria no valido")
            }
        }
    var producto = prod_cat.getAllProdbyCat(codCat)
       producto.forEach{ println(it) }
    }

    /** Obtener la categoria a la que pertenece un producto.
     * @return `producto.toString()`: Contenido de la categoria pasado a String.
     */
    fun obtCategoriaProd(): String {
        var codProd = 0
        var r=false
        var categoria:Categoria?=null
        println("Introduce el codigo del producto para consultar su categoria")
        while (!r) {
            r=true
            try {
                codProd = readln().toInt()
                if (!categoria?.codigo.toString().equals(codProd.toString())){
                    throw Exception()
                }
            }catch (e:Exception){
                println("Ese producto no existe")
                r=false
            }
            catch (numEx: NumberFormatException) {
                println("El codigo de producto que se ha introducido debe ser un numero.")
                r=false
            }
            categoria = prod_cat.getCatByCod_Prod(codProd)
        }
        return categoria.toString()
       }



    /** Cambiar la categoria a la que pertenece un producto. */
    fun cambiarCategoriaProd() {
        var codProd = 0

        try {
            println("Introduce el codigo de la categoria que se quiere obtener:\n")
            codProd = readln().toInt()
        } catch (numEx: NumberFormatException) {
            println("El codigo de producto que se ha introducido debe ser un numero.")
            codProd = readln().toInt() // FIXME
        }
    }
    fun altaProducto() {
        var r=false
        var categoria:Int=0
        var cod: Int=0
        var precio =0
        var cantidad=0
        var nombre=""
        while (!r){
            var r2=false
            while (!r2) {
                r2=true
                println("Intruduce el codigo del producto")
                try {
                    cod = readln().toInt()
                    if (cod.toString().length > 11) {
                        throw Exception()
                    }
                } catch (e2: NumberFormatException) {
                    println("El codigo debe ser un numero")
                    r2=false
                }catch (E: Exception) {
                    println("Se ha excedido el tamaño maximo (11) ")
                    r2=false
                }
            }
            r=false
            while (!r){
                r2=true
                println("Codigo de categoria: ")
                try {
                    categoria= readln().toInt()
                } catch (e2: NumberFormatException) {
                println("El codigo debe ser un numero")
                r2=false
            }catch (E: Exception) {
                println("Se ha excedido el tamaño maximo (3) ")
                r2=false
            }
            }
                println("Introduce el nombre")
                 nombre= readln()
              r2=false
            while (!r2) {
                r2=true
                println("Cantidad:")
                try {
                    cantidad = readln().toInt()
                } catch (e: NumberFormatException) {
                    println("Debe ser un numero")
                    r2=false
                }
            }
            r2=false
                println("Puesto del empleado")
                var puestoEmple: String = readln()
            while (!r2){
                r2=true
                println("Precio")
                try {
                    precio= readln().toInt()
                }catch (e2:NumberFormatException){
                    println("Debe ser un numero")
                    r2=false
                }
            }
            var producto = Producto(cod,categoria,nombre,cantidad,precio)
            var p=ProductoDAOImp()
            r=p.insertProducto(producto)
        }
    }
    fun bajaProducto(){
        var cod=0
        var r=false
        var p=ProductoDAOImp()

        while (!r){
         var r2=false
         while (!r2){
             r2=true
        println("Introduce el codigo del producto a dar de baja")
        try {
            cod= readln().toInt()
        }catch (e:NumberFormatException){
            println("Debe ser un numero")
            r2=false
        }
         }
        p.deleteProducto(cod)
    }
    println("Producto eliminado")
    }

    fun modificarPrecio() {
        var p =ProductoDAOImp()
        var cod=0
        var precio=0
        var producto:Producto?=null
        println("Elige el producto al que le quieres cambiar el precio")
        var productos=p.getAllProducto()
        productos.forEach { println(it) }
        var r=false
        while (!r) {
            r=true
            try {
                cod = readln().toInt()
            } catch (e: NumberFormatException) {
                println("Elige bien la clave primaria")
                r=false
            }
            producto=p.getProductoByCodigo(cod)
            if (!producto?.codigo.toString().equals(cod.toString())){
                r=false
                println("Elige bien la clave primaria")
            }
        }
        println("Establece el nuevco precio: ")
        r=false
        while (!r) {
            r=true
            try {
                precio = readln().toInt()
            }catch (e:NumberFormatException){
                println("Escribe bien el precio")
                r=false
            }
        }
        producto?.precio=precio
        p.updateProductoPrecio(producto)
    }
    fun modificarCantidad() {
        var p =ProductoDAOImp()
        var cod=0
        var cantidad=0
        var producto:Producto?=null
        println("Elige el producto al que le quieres cambiar el precio")
        var productos=p.getAllProducto()
        productos.forEach { println(it) }
        var r=false
        while (!r) {
            r=true
            try {
                cod = readln().toInt()
            } catch (e: NumberFormatException) {
                println("Elige bien la clave primaria")
                r=false
            }
        producto=p.getProductoByCodigo(cod)
            if (!producto?.codigo.toString().equals(cod.toString())){
                r=false
                println("Elige bien la clave primaria")
            }
        }
        println("Establece la cantidad actual: ")
        r=false
        while (!r) {
            r=true
            try {
                cantidad = readln().toInt()
            }catch (e:NumberFormatException){
                println("Escribe bien el precio")
                r=false
            }
        }
        producto?.cambiarCantidad(cantidad)
        p.updateProductoPrecio(producto)
    }

    fun obtTProd() {
       var p=ProductoDAOImp()
        var producto=p.getAllProducto()
        producto.forEach { println(it) }
    }
}


