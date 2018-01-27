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
public class ClienteController implements Serializable{

	/**
	 * 
	 */
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
		return "";
	}
	public List<ClienteModel> listar(){
		clienteDao.listarTodos("cliente_model").forEach(item -> {
			System.out.println(item.getNome());
		});
		return clienteDao.listarTodos("cliente_model");
	}
	public ClienteModel atualizar() {
		return clienteDao.atualizar(clienteModel);
	}
}





