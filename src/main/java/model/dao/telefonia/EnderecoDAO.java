package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Endereco;

public class EnderecoDAO {

	//INSERT
	//INSERT INTO (DDD, NUMERO, ATIVO, MOVEL, ID_CLIENTE)
	//VALEUS ('', '', '', '', '');
	
	/**
	 * Insere um novo telefone no banco
	 * @param novoTelefone o telefone a ser persistido
	 * @return o telefone inserido com a chave primária gerada
	 */
	
	public Endereco inserir(Endereco  novoEndereco) {
		//Conectar ao banco
		Connection conexao = Banco.getConnection();
		String sql = " INSERT INTO ENDERECO (RUA, CEP, BAIRRO, CIDADE, ESTADO, NUMERO) "
				+ " VALUES (?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		
		//Executar o INSERT 
		
		try {
			query.setString(1, novoEndereco.getRua());
			query.setString(2, novoEndereco.getCep());
			query.setString(3, novoEndereco.getBairro());
			query.setString(4, novoEndereco.getCidade());
			query.setString(5, novoEndereco.getEstado());
			query.setString(6, novoEndereco.getNumero());
			query.execute();
			
			//Preencher o id gerado no banco no objeto
			ResultSet resultado = query.getGeneratedKeys();
			if(resultado.next()) {
				novoEndereco.setId(resultado.getInt(1));
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o endereço. Causa: " + e.getMessage());
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		
		
		
		
		return novoEndereco;
	}
	
	public boolean atualizar(Endereco enderecoAtualizado) {
		boolean atualizou = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE ENDERECO SET CEP = ?, RUA = ?, NUMERO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? "
				+ " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, enderecoAtualizado.getCep());
			query.setString(2, enderecoAtualizado.getRua());
			query.setString(3, enderecoAtualizado.getNumero());
			query.setString(4, enderecoAtualizado.getBairro());
			query.setString(5, enderecoAtualizado.getCidade());
			query.setString(6, enderecoAtualizado.getEstado());	
			query.setInt(7, enderecoAtualizado.getId());
			int quantidadeDeLinhasAtualizadas = query.executeUpdate();
			atualizou = quantidadeDeLinhasAtualizadas > 0;
		} catch(SQLException e) {
			System.out.println("Erro ao atualizar o endereço. Causa: " + e.getMessage());
		}finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		
		return atualizou;
	}

	public Endereco consultarPorId(int id) {
		Endereco enderecoConsultado = null;
		Connection conexao = Banco.getConnection();
		String sql = " SELECT * FROM ENDERECO WHERE ID = ? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				enderecoConsultado = new Endereco();
				enderecoConsultado.setId(resultado.getInt("id"));
				enderecoConsultado.setCep(resultado.getString("cep"));
				enderecoConsultado.setRua(resultado.getString("rua"));
				enderecoConsultado.setBairro(resultado.getString("bairro"));
				enderecoConsultado.setNumero(resultado.getString("numero"));
				enderecoConsultado.setCidade(resultado.getString("cidade"));
				enderecoConsultado.setEstado(resultado.getString("estado"));
			}
			
			enderecoConsultado = new Endereco();
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar endereço por id: " + id + "Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		
		return null;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM ENDERECO WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			
			int quantidadeLinhasAtualizadas = query.executeUpdate();
			excluiu = quantidadeLinhasAtualizadas > 0;
		} catch(SQLException e) {
			System.out.println("Erro ao deletar o endereço. Causa: " + e.getMessage());
		} finally {
			Banco.closeConnection(conexao);
			Banco.closePreparedStatement(query);
		}
		return excluiu;
	}
	
}
