package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Entidades;



public class CrudBanco {

	private Connection con = Conexao.getconnection();

	public void cadastrar(Entidades usuario) {
		// monta sql
		String sql = "INSERT INTO USUARIO (nome, cpf, email) values (?,?,?)";

		try {

			// construção do PreparedStatement com o SQL
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getCpf());
			preparador.setString(3, usuario.getEmail());
			
			preparador.execute();
			preparador.close();

			System.out.println("Dados incluidos com sucesso!!!");

		} catch (SQLException e) {
			System.out.println("Erro ao incluir os dados!");
			;
		}

	}

	public List<Entidades> consultarTodos() {
		String sql = "SELECT * FROM usuario";

		List<Entidades> lista = new ArrayList<Entidades>();

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				Entidades usuario = new Entidades();

				usuario.setNome(resultado.getString("nome"));
				usuario.setCpf(resultado.getString("cpf"));
				usuario.setEmail(resultado.getString("email"));
				
				lista.add(usuario);

			}

			preparador.close();

			System.out.println("Consulta efetuada com sucesso!");

		} catch (SQLException e) {
			System.out.println("Erro ao efetuar a consulta!");
		}
		return lista;

	}

}