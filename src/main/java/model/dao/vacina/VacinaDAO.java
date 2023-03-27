package model.dao.vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.Banco;
import model.vo.telefonia.Endereco;
import model.vo.vacinas.Pessoa;
import model.vo.vacinas.Vacina;

public class VacinaDAO {

	
	public Vacina inserir(Vacina novaVacina) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO VACINA (ESTAGIO, DATAINICIO, NOMEPESQUISADOR) "
				+ " VALUES (?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			query.setString(1, novaVacina.getEstagio());
			query.setString(2, novaVacina.getDtinicio());
			query.setString(3, novaVacina.getNomepesquisador());
			query.execute();
			
			
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novaVacina.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir a vacina. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return novaVacina;	
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		Connection conexao = Banco.getConnection();
		
		String sql = " DELETE FROM VACINA "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir vacina. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return excluiu;
	}
	
	
	public boolean atualizar(Vacina vacinaAtualizada) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE VACINA SET ESTAGIO = ?, DATAINICIO = ?, NOMEPESQUISADOR = ? "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, vacinaAtualizada.getEstagio());
			query.setString(2, vacinaAtualizada.getDtinicio());
			query.setString(3, vacinaAtualizada.getNomepesquisador());
			query.setInt(4, vacinaAtualizada.getId());
			int quantidadeDeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeDeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar a vacina. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return atualizou;
	}
	
	public Vacina consultarPorId(int id) {
		Vacina vacinaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM VACINA "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				vacinaConsultada = converterDeResultSetParaEntidade(resultado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar vacina com id: + " + id 
								+ "\n Causa: " + e.getMessage());	
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return vacinaConsultada;
	}
	
	public List<Vacina> consultarTodos() {
		List<Vacina> vacinas = new ArrayList<Vacina>();
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM VACINA ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			ResultSet resultado = query.executeQuery();
			while(resultado.next()) {
				Vacina vacinaConsultada = converterDeResultSetParaEntidade(resultado);
				vacinas.add(vacinaConsultada);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar todos os endereços" 
								+ "\n Causa: " + e.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return vacinas;
	}
	
	private Vacina converterDeResultSetParaEntidade(ResultSet resultado) throws SQLException {
		Vacina vacinaConsultada = new Vacina(); 
		vacinaConsultada.setId(resultado.getInt("id"));
		vacinaConsultada.setEstagio(resultado.getString("estagio"));
		vacinaConsultada.setDtinicio(resultado.getString("datainicio"));
		vacinaConsultada.setNomepesquisador(resultado.getString("nomepesquisador"));
		return vacinaConsultada;
	}
}
