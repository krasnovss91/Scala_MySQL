import java.sql.Connection
import java.sql.DriverManager

object ScalaDBMain {
  var connection:Connection = _
  def main(args: Array[String]) {

    val url = "jdbc:mysql://localhost/mysql"
    val driver = "com.mysql.jdbc.Driver"
    val username = "root"
    val password = "password"


    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT host, user FROM user")
      while ( resultSet.next() ) {
        val host = resultSet.getString("host")
        val user = resultSet.getString("user")
        println("host, user = " + host + ", " + user)
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
    connection.close()
  }
}
