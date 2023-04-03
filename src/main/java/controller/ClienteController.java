package controller;

import java.util.List;

import model.bo.ClienteBO;
import model.exception.CampoInvalidoExcpetion;
import model.exception.ClienteComTelefoneException;
import model.exception.CpfAlteradoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;

public class ClienteController {
	
	private ClienteBO bo = new ClienteBO();
		
		public Cliente inserir(Cliente novoCliente) throws CpfJaUtilizadoException, 
				EnderecoInvalidoException, CampoInvalidoExcpetion {
			
			//TODO validar o preenchimento dos campos obrigatórios
			this.validarCamposObrigatorios(novoCliente);
			return bo.inserir(novoCliente);
		}
		
		public boolean atualizar(Cliente clienteAlterado) throws EnderecoInvalidoException, CpfAlteradoException {
			//TODO validar o preenchimento dos campos obrigatórios
			return bo.atualizar(clienteAlterado);
		}
		
		private void validarCamposObrigatorios(Cliente c) throws CampoInvalidoExcpetion{
			String mensagemValidacao = "";
			
			if(c.getNome() != null && c.getNome().trim().length() < 2) {
				throw new CampoInvalidoExcpetion("Nome inválido");
			}
			
			validarCPF(c);
			
			if(c.getEndereco() == null) {
				throw new CampoInvalidoExcpetion("Informe um endereço");
			}
		}
		
		private void validarCPF(Cliente c) throws CampoInvalidoExcpetion {
			String cpfSemMascara = c.getCpf();
			cpfSemMascara = c.getCpf().replace(".", "");
			c.setCpf(cpfSemMascara);
			
			if(c.getCpf() != null) {
				if(c.getCpf().length() != 11) {
					throw new CampoInvalidoExcpetion("CPF deve possuir 11 digitos");
				}
				try {
					Integer.valueOf(c.getCpf());
				} catch (NumberFormatException ex) {
					throw new CampoInvalidoExcpetion("CPF deve possuir apenas numeros");
				}
			}
			
		}

		public boolean excluir(int id) throws ClienteComTelefoneException {
			return bo.excluir(id);
		}
		
		public Cliente consultarPorId(int id) {
			return bo.consultarPorId(id);
		}
		
		public List<Cliente> consultarTodos() {
			return bo.consultarTodos();
		}
}
