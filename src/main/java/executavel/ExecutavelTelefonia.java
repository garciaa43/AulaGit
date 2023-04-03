package executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.ClienteController;
import model.bo.ClienteBO;
import model.dao.telefonia.EnderecoDAO;
import model.dao.telefonia.TelefoneDAO;
import model.exception.CampoInvalidoExcpetion;
import model.exception.CpfAlteradoException;
import model.exception.CpfJaUtilizadoException;
import model.exception.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		
		
		/*
		List<Telefone> telefonesDoPele;
		Endereco endereco1 = new Endereco("800093", "Mauro Ramos", "10", "Centro", "Florianopolis", "SC");
		
		  EnderecoDAO enderecos = new EnderecoDAO();
		enderecos.inserir(endereco1);
		 if(endereco1.getId() != null) {
			System.out.println("Novo endereço cadastrado");
		} else {
			System.out.println("Erro ao cadastrar");
		}
		 */
		
		/*EnderecoDAO enderecos = new EnderecoDAO(); 
		 if(enderecos.excluir(3)) {
			 System.out.println("Excluido com sucesso");
		 } else {
			 System.out.println("Erro ao excluir");
		 }
		*/
		EnderecoDAO enderecos = new EnderecoDAO(); 
		TelefoneDAO telefones = new TelefoneDAO();
		
		Telefone telefoneQueExiste = telefones.consultarPorId(2);
		System.out.println(telefoneQueExiste);
		telefoneQueExiste.setDdd("47");
		boolean atualizou = telefones.atualizar(telefoneQueExiste);
		if(atualizou) {
			System.out.println("Telefone atualizado");
		} else {
			System.out.println("Erro ao atualizar");
		}
		//Telefone telefone1 = new Telefone("48", "32323705", false, false);
		//Telefone telefone5 = new Telefone("48", "54586957", false, false);
		//telefones.inserir(telefone5);
		//telefone5.setDdd("46");
		//boolean atualizou = telefones.atualizar(telefone5);
		
		//telefone5 = telefones.consultarPorId(2);
		//System.out.println(telefone5);
		
		//Telefone telefoneQueExiste = telefones.consultarPorId(3);
		//System.out.println(telefoneQueExiste);
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		Telefone telefone11 = new Telefone("48", "32323705", true, false);
		telefonesDoSocrates.add(telefone11);
		Cliente socrates = new Cliente("Socrates Brasileiro", "2132132", telefonesDoSocrates, true, null);
		Endereco enderecoQueExiste = enderecos.consultarPorId(1);
		System.out.println(enderecoQueExiste);
		
		ClienteBO clienteBO = new ClienteBO();
		
		Cliente novoCliente = new Cliente();
		ClienteController controladorDeClientes = new ClienteController();
		try {
			controladorDeClientes.inserir(novoCliente);
		} catch (CpfJaUtilizadoException | EnderecoInvalidoException | CampoInvalidoExcpetion e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		
		 /*
		Telefone telefone1 = new Telefone("48", "32323705", false, false);
		Telefone telefone2 = new Telefone("48", "984591053", true, false);
		TelefoneDAO telefones = new TelefoneDAO();
		//telefones.inserir(telefone2);
		telefones.deletar(telefone2);
		telefones.inserir(telefone1);
		*/
		
		/*
		if(telefone1.getId() != null) {
			System.out.println("Novo endereço cadastrado");
		} else {
			System.out.println("Erro ao cadastrar");
		}
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		Telefone telefone11 = new Telefone("48", "32323705", true, false);
		telefonesDoSocrates.add(telefone11);
		telefonesDoSocrates.add(new Telefone("48", "32324567", true, true));
		Cliente pele = new Cliente("Edson Arantes", "11111113243", null, true, endereco1);
		Cliente socrates = new Cliente("Socrates Brasileiro", "4324322132132", telefonesDoSocrates, true, null);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("----------Clientes da firma----------");
		
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		 
		*/
		}
	}


