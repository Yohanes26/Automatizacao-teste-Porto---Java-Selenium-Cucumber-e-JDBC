package jdbc;

import java.util.List;

import entidades.Entidades;

public class TesteCrud { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		testeConsultarTodos();
	}
			
			//classe utilizada para teste de busca ao banco para utilização dentro do webdriver.
			private static void testeConsultarTodos() {
				CrudBanco banco = new CrudBanco();
				List<Entidades> listaResultado = banco.consultarTodos();

				Entidades usuario = new Entidades();

				for (Entidades usuario1 : listaResultado) {

					usuario.setNome(usuario1.getNome());

					System.out.println(usuario1.getNome());

				}

			}

			private static void testeCadastrar() {

				Entidades usuario = new Entidades();
				usuario.setNome("Yohanes Lopes");
				usuario.setCpf("35020020020");
				usuario.setEmail("yohaneslopes@gmail.com");
				
				CrudBanco banco = new CrudBanco();
				banco.cadastrar(usuario);

			}

		



		
	}


