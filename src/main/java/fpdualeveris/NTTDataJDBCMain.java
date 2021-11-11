package fpdualeveris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import models.SoccerPlayer;

/**
 * Esta clase crea objetos SoccerPlayer a raiz del nombre y posicion extraidos desde la base de datos.
 * @author David César Fernández Aliseda
 * @version 11/11/21/A
 */

public class NTTDataJDBCMain {
	
	public static void main(String[] args) {
		
		try {
			Connection con = getConnection();
			Scanner sc = new Scanner(System.in);
			
			//List para almacenar jugadores
			List<SoccerPlayer> players = new ArrayList<SoccerPlayer>();
			
			//Consulta para extraer nombre y primera posicion de los jugadore cuya id sea mayor igual a 3 y menor que 6.
			String sql = "select name, first_rol from nttdata_mysql_soccer_player where id_soccer_player >= ? and id_soccer_player <= ?";
			PreparedStatement statement = getConnection().prepareStatement(sql);
			int firstPlayer = 3;
			int lastPlayer = 6;
			statement.setInt(1, firstPlayer);
			statement.setInt(2, lastPlayer);
			ResultSet resultSet = statement.executeQuery();
			
			//Creacion los objetos con los datos extraidos de la consulta y se almacenan en una lista
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String rol = resultSet.getString("first_rol");

				SoccerPlayer obj = new SoccerPlayer();
				obj.setName(name);
				obj.setFirstRol(rol);

				players.add(obj);

			}
			//Iteracion de la lista para mostrar la informacion de los objetos
			Iterator<SoccerPlayer> iterator = players.iterator();
			while (iterator.hasNext()) {
				SoccerPlayer elemento = iterator.next();
				System.out.print(elemento.toString()+"\n");
			}

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Este metodo conecta con la base de datos nttdata_javajdbc.
	 */
	
	private static Connection con = null;

	private static Connection getConnection() {

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
