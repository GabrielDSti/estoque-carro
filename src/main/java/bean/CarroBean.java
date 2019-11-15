package bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import dao.CarroDao;
import model.Carro;

@ManagedBean
@RequestScoped
public class CarroBean {
	private String nome;
	private Integer ano;
	private String cor;
	private String placa;
	private Integer qtde;
	private String novaPlaca;
	private String orientacao = "horizontal";
	private List<Carro> carros;

	public CarroBean() {
		consultar();
	}

	public void salvar() {
		Carro carro = new Carro();
		CarroDao carroDao = new CarroDao();
		carro.setNome(getNome());
		carro.setAno(getAno());
		carro.setCor(getCor());
		carro.setPlaca(getPlaca());
		carro.setQtde(getQtde());
		Carro placa = carroDao.consultarCarroPorPlaca(carro.getPlaca());
		if (placa.getPlaca() != null) {
			System.out.println("Veiculo de placa:" + carro.getPlaca() + " , já existe no BD");
			System.out.println("INFORMAÇÕES DO CARRO NO BANCO: NOME->" + placa.getNome() + " | ID->" + placa.getId());
		} else {
			carroDao.salvar(carro);
		}
	}

	public List<Carro> consultar() {
		carros = new ArrayList<Carro>();
		CarroDao carroDao = new CarroDao();
		carros = carroDao.consultarTodosCarros();

		return carros;
	}

	public void alterar() {
		Carro carro = new Carro();
		carro.setNome(getNome());
		carro.setPlaca(getPlaca());
	
		CarroDao carroDao = new CarroDao();
		carroDao.atualizarCarro(carro);

	}

	public void remover() {
		Carro carro = new Carro();
		carro.setPlaca(getPlaca());
		CarroDao carroDao = new CarroDao();
		carroDao.deletarPorPlaca(carro);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public String getNovaPlaca() {
		return novaPlaca;
	}

	public void setNovaPlaca(String novaPlaca) {
		this.novaPlaca = novaPlaca;
	}
	
	
	

}
