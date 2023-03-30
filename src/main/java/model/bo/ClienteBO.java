package model.bo;

import model.dao.telefonia.ClienteDAO;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();
	
	public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, EnderecoInvalidoException{
		if(dao.cpfJaUtilizado(novoCliente.getCpf())) {
			throw new CpfJaUtilizadoException("CPF informado ja fui utilizado");
		} 
	
		if(novoCliente.getEndereco() == null || novoCliente.getEndereco().getId() == null) {
			throw new EnderecoInvalidoException("Endereço não informado")
		}
		
		
		return dao.inserir(novoCliente);;
	}
	
}
