package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.ClienteDao;
import model.ClienteModel;

@Named
@RequestScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 7201629867247186587L;
	@Inject
	private ClienteModel clienteModel;
	@Inject
	private ClienteDao clienteDao;

	public ClienteModel getClienteModel() {
		return clienteModel;
	}

	public void setClienteModel(ClienteModel clienteModel) {
		this.clienteModel = clienteModel;
	}

	public String submit() {
		clienteDao.salvar(clienteModel);
		clienteModel = new ClienteModel();
		return "index";
	}

	public List<ClienteModel> listar() {
		return clienteDao.listarTodos(new StringBuilder("from cliente_model"));
	}

	public String editar(ClienteModel model) {
		this.clienteModel = model;
		return "index";
	}

	public String deletarItem(ClienteModel model) {
		String sql = "DELETE from cliente_model where id=" + model.getId();
		clienteDao.deletar(sql);
		// System.out.println("Deletar item :"+ model.getNome());
		return "index";
	}

	public void limpar() {
		clienteModel = new ClienteModel();
	}
}
