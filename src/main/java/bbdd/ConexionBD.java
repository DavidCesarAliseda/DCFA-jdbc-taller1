package bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase conecta con la base de datos nttdata_javajdbc.
 * @author David César Fernández Aliseda
 * @version 11/11/21/A
 */

public class ConexionBD {
	private static Connection con = null;

	public static Connection getConnection() {

		try {
			if (con == null) {
				con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3336/nttdata_javajdbc?user=root&password=root"
						+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				System.out.println("Connection Successful");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return (con);
	}

	public static void close(){
        try {
            if (con != null) con.close();
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
