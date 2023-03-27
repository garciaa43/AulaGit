package model.dao.vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.TipoPessoa;

public class PessoaDAO {

	
	public Pessoa inserir(Pessoa novaPessoa) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO PESSOA (NOME, DATANASCIMENTO, SEXO, CPF, TIPOPESSOA, NOTAVACINA) "
				+ " VALUES (?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			query.setString(1, novaPessoa.getNome());
			query.setString(2, novaPessoa.getDtNascimento());
			query.setString(3, novaPessoa.getSexo());
			query.setString(4, novaPessoa.getCpf());
			query.setInt(5, novaPessoa.getTipoPessoa().getValor());
			query.setDouble(6, novaPessoa.getNotaVacina());
			query.execute();
			
			
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir a pessoa. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return novaPessoa;
		
	}
	
	public boolean atualizar(Pessoa pessoaAtualizada) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE PESSOA SET NOME = ?, DATANASCIMENTO = ?, SEXO = ?, CPF = ?, TIPOPESSOA = ?, NOTAVACINA = ? "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, pessoaAtualizada.getNome());
			query.setString(2, pessoaAtualizada.getDtNascimento());
			query.setString(3, pessoaAtualizada.getSexo());
			query.setString(4, pessoaAtualizada.getCpf());
			query.setInt(5, pessoaAtualizada.getTipoPessoa().getValor());
			query.setDouble(6, pessoaAtualizada.getNotaVacina());
			query.setInt(7, pessoaAtualizada.getId());
			int quantidadeDeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeDeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a pessoa. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return atualizou;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		Connection conexao = Banco.getConnection();
		
		String sql = " DELETE FROM PESSOA "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir pessoa. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return excluiu;
	}
	
	public Pessoa consultarPorId(int id) {
		Pessoa pessoaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaConsultada = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoa com id: + " + id 
								+ "\n Causa: " + e.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return pessoaConsultada;
	}
	
	
	
	public ArrayList<Pessoa> consultarTodasPessoasDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
		
		String query = "SELECT p.id, p.nome, p.datanascimento, p.sexo, p.cpf, p.tipopessoa, p.notavacina "
				+ " FROM pessoa p " ;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setId(resultado.getInt(1));
				pessoa.setNome(resultado.getString(2));
				pessoa.setDtNascimento(resultado.getString(3));
				pessoa.setSexo(resultado.getString(4));
				pessoa.setCpf(resultado.getString(5));
				pessoa.setTipoPessoa(TipoPessoa.valueOf(resultado.getString(6)));
				pessoa.setNotaVacina(resultado.getDouble(7));
				listaPessoa.add(pessoa);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query do metodo consultarTodasPessoasDAO");
			System.out.println("Erro: " + e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaPessoa;
	}
	
	private Pessoa converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Pessoa pessoaConsultada = new Pessoa(); 
		pessoaConsultada.setId(resultado.getInt("id"));
		pessoaConsultada.setNome(resultado.getString("nome"));
		pessoaConsultada.setDtNascimento(resultado.getString("datanascimento"));
		pessoaConsultada.setSexo(resultado.getString("sexo"));
		pessoaConsultada.setCpf(resultado.getString("cpf"));
		pessoaConsultada.getTipoPessoa().getValor();
		pessoaConsultada.setNotaVacina(resultado.getDouble("notavacina"));
		return pessoaConsultada;
	}
	
	
}


