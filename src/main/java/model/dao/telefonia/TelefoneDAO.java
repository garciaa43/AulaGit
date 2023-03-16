package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {

	public Telefone inserir(Telefone novoTelefone) {
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO TELEFONE (DDD, NUMERO, ATIVO, MOVEL) "
				+ " VALUES (?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		try {
			query.setString(1, novoTelefone.getDdd());
			query.setString(2, novoTelefone.getNumero());
			query.setBoolean(3, novoTelefone.isAtivo());
			query.setBoolean(4, novoTelefone.isMovel());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoTelefone.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o telefone. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		return novoTelefone;
		
	}
	
	public boolean atualizar(Telefone telefoneAtualizado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE TELEFONE SET DDD = ?, NUMERO = ?, ATIVO = ?, MOVEL = ? "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, telefoneAtualizado.getDdd());
			query.setString(2, telefoneAtualizado.getNumero());
			query.setBoolean(3, telefoneAtualizado.isAtivo());
			query.setBoolean(4, telefoneAtualizado.isMovel());
			query.setInt(5, telefoneAtualizado.getId());
			int quantidadeDeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeDeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar o telefone. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return atualizou;
	}

	public Telefone consultarPorId(int id) {
		Telefone telefoneConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM TELEFONE WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				telefoneConsultado = new Telefone();
				telefoneConsultado.setId(resultado.getInt("id"));
				telefoneConsultado.setDdd(resultado.getString("ddd"));
				telefoneConsultado.setNumero(resultado.getString("numero"));
				telefoneConsultado.setAtivo(resultado.getBoolean("ativo"));
				telefoneConsultado.setMovel(resultado.getBoolean("movel"));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar telefone por id: " + id + " Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
	}
		return telefoneConsultado;
	}

	public boolean excluir(int id) {
		boolean excluiu = false;
		Connection conexao = Banco.getConnection();
		
		String sql = " DELETE FROM TELEFONE "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch (SQLException e) {
			System.out.println("Erro ao excluir telefone. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return excluiu;
	}
}
