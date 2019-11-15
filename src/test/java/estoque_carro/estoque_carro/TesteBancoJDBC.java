package estoque_carro.estoque_carro;

import java.util.List;

import org.junit.Test;

import conexaoJDBC.SingleConnection;
import dao.CarroDao;
import model.Carro;

public class TesteBancoJDBC {
	
	/**
	 * @author gabriel
	 * Metodo de teste de inicialização do banco de dados
	 */
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}
	
	/**
	 * @author gabriel
	 * Metodo responsavel por inserir um carro no banco de dados
	 */
	@Test
	public void insertCarro() {
		CarroDao carroDao = new CarroDao();
		Carro carro = new Carro();
		carro.setNome("jeep");
		carro.setAno(2018);
		carro.setCor("amarelo");
		carro.setPlaca("XXT-378");
		carro.setQtde(1);
		carroDao.salvar(carro);
	}
	
	/**
	 * @author gabriel
	 * Metodo reponsavel por retornar todos os carros
	 * @return List
	 */
	@Test
	public void consultarCarros() {
		CarroDao carroDao = new CarroDao();
		List<Carro> carros = carroDao.consultarTodosCarros();
		for(Carro cars : carros) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println(cars);
			
		}
	}
	
	/**
	 * @author gabriel
	 * Metodo responsavel por retornar um unico objeto carro
	 */
	@Test
	public void consultarCarro() {
		CarroDao carroDao = new CarroDao();
		Carro carro = carroDao.consultarCarro(2L);
		System.out.println(carro);
	}

	/**
	 * @author gabriel
	 * Metodo responsavel por alterar o nome do veiculo 
	 */
	//@Test

	/*
	 * public void alterarNomeCarro() { Carro carro = new Carro(); CarroDao carroDao
	 * = new CarroDao(); carro.setNome("Mercedes 220"); carro.setId(5L);
	 * carroDao.atualizarNome(carro);
	 */
		 // outra forma
		//Carro buscaObjeto = carroDao.consultarCarro(4L);
		//buscaObjeto.setNome("Honda-HRV");
		//carroDao.atualizarNome(buscaObjeto);
//	}
	
	@Test
	public void deletarCarro() {
		CarroDao carroDao = new CarroDao();
		carroDao.deletar(6L);
	}
	
	@Test
	public void buscaCarroPorPlaca() {
		CarroDao carroDao = new CarroDao();
		Carro carro = carroDao.consultarCarroPorPlaca("mxz-123");
		System.out.println(carro);
	}
}
