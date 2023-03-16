package executavel;

import java.util.ArrayList;
import java.util.List;

import model.dao.telefonia.EnderecoDAO;
import model.dao.telefonia.TelefoneDAO;
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
		 EnderecoDAO enderecos = new EnderecoDAO();
		 Endereco endereco1 = new Endereco(1,"800093", "Rua dos rubis", "10", "Centro", "Florianopolis", "SC" );
		 boolean atualizou = enderecos.atualizar(endereco1);
		 boolean excluiu = enderecos.excluir(9);
		 if(excluiu) {
			 System.out.println("Excluido com sucesso");
		 } else {
			 System.out.println("Não deu para excluir");
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


