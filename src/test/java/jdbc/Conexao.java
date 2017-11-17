package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	
	
	public static Connection getconnection() {
		Connection con=null;	
		try {
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","");
			System.out.println("Conectado com sucesso!");
			
				
		} catch (SQLException e) {
		
			System.out.println("Erro ao se conectar ao banco de dados."+ e.getMessage());
			
		}
		return con;
	}

}
