package executavel;

import java.util.ArrayList;
import java.util.List;

import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {
		
		List<Telefone> telefonesDoPele;
		Endereco endereco1 = new Endereco("800098803", "Mauro Ramos", "10", "Centro", "Florianopolis", "SC");
		
		
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		Telefone telefone1 = new Telefone("48", "32323705", true, false);
		telefonesDoSocrates.add(telefone1);
		telefonesDoSocrates.add(new Telefone("48", "32324567", true, true));
		
		Cliente socrates = new Cliente("Socrates Brasileiro", "4324322132132", telefonesDoSocrates, true, null);
		Cliente pele = new Cliente("Edson Arantes", "11111113243", null, true, endereco1);
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(pele);
		clientes.add(socrates);
		
		System.out.println("----------Clientes da firma----------");
		
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		}
	}

}
