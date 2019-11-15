package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoJDBC.SingleConnection;
import model.Carro;

public class CarroDao {
	private Connection connection;

	public CarroDao() {
		connection = SingleConnection.getConnection();
	}

	/**
	 * salva o objeto carro no banco
	 * 
	 * @param carro
	 */
	public void salvar(Carro carro) {
		try {
			String sql = " insert into carro ( nome, ano, cor, placa, qtde ) values( ?, ?, ?, ?, ? ); ";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, carro.getNome());
			insert.setInt(2, carro.getAno());
			insert.setString(3, carro.getCor());
			insert.setString(4, carro.getPlaca());
			insert.setInt(5, carro.getQtde());
			insert.execute();
			connection.commit();
			System.out.println("Veiculo:" + carro.getNome() + "-" + carro.getPlaca() + " salvo com sucesso!");
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println("Falha ao salvar no banco! rollback feito.");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	/**
	 * consulta todos os carros no banco
	 * 
	 * @return
	 */
	public List<Carro> consultarTodosCarros() {
		List<Carro> carros = new ArrayList<Carro>();
		try {
			String sql = " select * from carro order by id asc; ";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet resultado = select.executeQuery();
			while (resultado.next()) {
				Carro carro = new Carro();
				carro.setId(resultado.getLong("id"));
				carro.setNome(resultado.getString("nome"));
				carro.setCor(resultado.getString("cor"));
				carro.setAno(resultado.getInt("ano"));
				carro.setPlaca(resultado.getString("placa"));
				carro.setQtde(resultado.getInt("qtde"));
				carros.add(carro);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carros;
	}

	/**
	 * consulta apenas um objeto carro no banco de acordo com o ID informado.
	 * 
	 * @param id
	 * @return
	 */
	public Carro consultarCarro(Long id) {
		Carro carro = new Carro();
		try {
			String sql = " select * from carro where id = " + id;
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet resultado = select.executeQuery();
			while (resultado.next()) {

				carro.setId(resultado.getLong("id"));
				carro.setNome(resultado.getString("nome"));
				carro.setCor(resultado.getString("cor"));
				carro.setAno(resultado.getInt("ano"));
				carro.setPlaca(resultado.getString("placa"));
				carro.setQtde(resultado.getInt("qtde"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}

	/**
	 * atualiza nome do carro no banco de acordo com o ID informado
	 * 
	 * @param carro
	 */
	public void atualizarCarro(Carro carro) {

		try {
			/*
			 * StringBuilder sb = new StringBuilder(); if( carro.getNome() != "")
			 * sb.append(" nome = ?, "); if( carro.getCor() != "") sb.append(" cor = ?, ");
			 * if( carro.getAno() != 0) sb.append(" ano = ?, "); if( carro.getPlaca() != "")
			 * sb.append(" placa = ?, "); if( carro.getQtde() != 0)
			 * sb.append(" qtde = ?, ");
			 */
			String sql = "update carro set nome = ? where placa =" +"'"+ carro.getPlaca()+"'";
			PreparedStatement update = connection.prepareStatement(sql);
			if (carro.getNome() != "") {
				update.setString(1, carro.getNome());
			}
			/*
			 * if (carro.getCor() != "") { update.setString(2, carro.getCor()); } if
			 * (carro.getAno() != null) { update.setInt(3, carro.getAno()); } if
			 * (carro.getNovaPlaca() != "") { update.setString(4, carro.getNovaPlaca()); }
			 * if(carro.getQtde() != 0) { update.setInt(5, carro.getQtde()); }
			 */
			update.execute();
			connection.commit();
			System.out.println("Nome do carro atualizado!");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void deletar(Long id) {
		try {
			String sql = "delete from carro where id = " + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			System.out.println("Veiculo de ID:" + id + " deletado!");
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void deletarPorPlaca(Carro carro) {
		try {
			String sql = "delete from carro where placa = '" + carro.getPlaca()+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();
			System.out.println("Veiculo de placa:" + carro.getPlaca() + " deletado!");
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public Carro consultarCarroPorPlaca(String placa) {
		Carro carro = new Carro();
		try {
			String sql = " select * from carro where placa = '" + placa + "'";
			PreparedStatement select = connection.prepareStatement(sql);
			ResultSet resultado = select.executeQuery();
			while (resultado.next()) {

				carro.setId(resultado.getLong("id"));
				carro.setNome(resultado.getString("nome"));
				carro.setCor(resultado.getString("cor"));
				carro.setAno(resultado.getInt("ano"));
				carro.setPlaca(resultado.getString("placa"));
				carro.setQtde(resultado.getInt("qtde"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}

}
