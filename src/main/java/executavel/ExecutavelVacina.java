package executavel;

import model.dao.vacina.PessoaDAO;
import model.dao.vacina.VacinaDAO;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.TipoPessoa;
import model.vo.vacinas.Vacina;

public class ExecutavelVacina {

	public static void main(String[] args) {
		//Pessoa pessoa1 = new Pessoa("William", "24/02/2000", "M", "13245687955", TipoPessoa.PESQUISADOR, 5.5);
		PessoaDAO pessoas = new PessoaDAO();
		//pessoas.inserir(pessoa1);
		Pessoa pessoa2 = new Pessoa("Thiago", "20/07/1993", "M", "14356789055", TipoPessoa.PUBLICO, 7.8);
		//pessoas.inserir(pessoa2);
		//pessoa2.setNome("Gabriel");
		//Boolean atualizou = pessoas.atualizar(pessoa2);
		//pessoas.consultarTodasPessoasDAO();
		//pessoas.excluir(1);
		//System.out.println(pessoa2);
		//Vacina vacina = new Vacina("INICIA", "14/02/2000", "GABRIEL");
		VacinaDAO vacinas = new VacinaDAO();
		//vacinas.inserir(vacina);
		//vacinas.excluir(2);
		/*Vacina vacina1 = new Vacina("APLICACAO EM MASSA", "30/01/1998", "EDUARDO");
		vacinas.inserir(vacina1);
		vacina1.setNomepesquisador("GABRIEL");
		Boolean atualizou = vacinas.atualizar(vacina1);
		if(atualizou) {
			System.out.println("Vacina atualizada");
		} else {
			System.out.println("Erro ao atualizar a vacina");
		}
		System.out.println(vacina1);
		*/
		Vacina vacinaQueExiste = vacinas.consultarPorId(1);
		System.out.println(vacinaQueExiste);
		
		System.out.println(vacinas.consultarTodos());
	}

}
