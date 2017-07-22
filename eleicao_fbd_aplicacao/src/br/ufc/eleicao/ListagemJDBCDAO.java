package br.ufc.eleicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.eleicao.entity.Listagem;

public class ListagemJDBCDAO implements ListagemDAO {

	public ListagemJDBCDAO() { }

	@Override
	public List<Listagem> findByNum_vot(int num) {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa where numero_votacao = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	@Override
	public List<Listagem> findByAno(double num) {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa where ano = ?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, num);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	@Override
	public List<Listagem> findByDesc(String str) {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa where upper(descricao) like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + str.toUpperCase() + "%");
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	@Override
	public List<Listagem> findByPartido(String str) {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa where upper(nome_partido) like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + str.toUpperCase() + "%");
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	@Override
	public List<Listagem> findByNum_cand(int num) {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa where num_candidato = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	@Override
	public List<Listagem> findByNome(String str) {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa where upper(nome) like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + str.toUpperCase() + "%");
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}

	@Override
	public List<Listagem> find() {
		Connection con = null;
		List<Listagem> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, ano, descricao, nome_partido, num_candidato, nome from Listagem_completa";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Listagem>();
			while (rs.next()) {
				Listagem l = map(rs);
				result.add(l);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return result;
	}
	
	private Listagem map(ResultSet rs) throws SQLException {
		Listagem l = new Listagem();
		l.setNum_votacao(rs.getInt("numero_votacao"));
		l.setAno(rs.getDouble("ano"));
		l.setDescricao(rs.getString("descricao"));
		l.setNome_partido(rs.getString("nome_partido"));
		l.setNum_cand(rs.getInt("num_candidato"));
		l.setNome(rs.getString("nome"));
		return l;
	}

	
}
