package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexionBD.ConexionDB;
import model.Persona;

public class PersonasDao {
	

	public ArrayList<Persona> getPersonas() throws SQLException {
		ConexionDB conexion = new ConexionDB();
		Connection con = conexion.getConexion();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		try {
			String sql = "Select persona.dni,nombre,apellido1,apelido2,email,telefono from persona,email,telefono where persona.dni=telefono.dni and persona.dni=email.dni";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				Persona p = new Persona();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return personas;
	}

}