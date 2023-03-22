import java.sql.*

/**
 * Conexion b d
 *
 * @constructor Create empty Conexion b d
 */
class ConexionBD {
    val url = "jdbc:mysql://localhost/supermercadosimple"
    val user = "root"
    val password = ""
    var conn: Connection? = null


    /**
     * Conectar
     *
     */
    fun conectar() {
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    /**
     * Desconectar
     *
     */
    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    /**
     * Get statement
     *
     * @return
     */
    fun getStatement(): Statement? {
        return conn?.createStatement()
    }

    /**
     * Get prepared statement
     *
     * @param sql
     * @return
     */
    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }
}
