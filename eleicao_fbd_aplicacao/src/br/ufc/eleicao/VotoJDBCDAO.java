package br.ufc.eleicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.eleicao.entity.Voto;

public class VotoJDBCDAO implements VotoDAO{

	public VotoJDBCDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Voto entity, int opc) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into Votos (numero_votacao, num_titulo, num_candidato) values (?, ?, ?)";
			String update_sql = "update Votos set numero_votacao = ?, num_titulo = ?, num_candidato = ? where numero_votacao = ? and num_titulo = ?";
			PreparedStatement pst = null;
			if (opc == 1) {
				pst = con.prepareStatement(insert_sql);
			}
			if (opc == 2){
				pst = con.prepareStatement(update_sql);
				pst.setInt(4, entity.getNum_votacao());
				pst.setInt(5, entity.getNum_titulo());
			}
			pst.setInt(1, entity.getNum_votacao());
			pst.setInt(2, entity.getNum_titulo());
			pst.setInt(3, entity.getNum_candidato());
			pst.execute();
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
	}

	@Override
	public void delete(int num_votacao, int num_titulo) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from votos where numero_votacao = ? and num_titulo = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, num_votacao);
			pst.setInt(2, num_titulo);
			pst.executeUpdate();
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
	}

	@Override
	public Voto find(int num_votacao, int num_titulo) {
		Connection con = null;
		Voto v = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select numero_votacao, num_titulo, num_candidato from Votos where numero_votacao = ? and num_titulo = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, num_votacao);
			pst.setInt(2, num_titulo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				v = map(rs);
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
		return v;
	}

	@Override
	public List<Voto> find() {
		Connection con = null;
		List<Voto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, num_titulo, num_candidato from Votos";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Voto>();
			while (rs.next()) {
				Voto v = map(rs);
				result.add(v);
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
	public List<Voto> findByNum_vot(int num) {
		Connection con = null;
		List<Voto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, num_titulo, num_candidato from Votos where numero_votacao = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Voto>();
			while (rs.next()) {
				Voto v = map(rs);
				result.add(v);
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
	public List<Voto> findByNum_titulo(int num) {
		Connection con = null;
		List<Voto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, num_titulo, num_candidato from Votos where num_titulo = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Voto>();
			while (rs.next()) {
				Voto v = map(rs);
				result.add(v);
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
	public List<Voto> findByNum_cand(int num) {
		Connection con = null;
		List<Voto> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select numero_votacao, num_titulo, num_candidato from Votos where num_candidato = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Voto>();
			while (rs.next()) {
				Voto v = map(rs);
				result.add(v);
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

	private Voto map(ResultSet rs) throws SQLException {
		Voto v = new Voto();
		v.setNum_votacao(rs.getInt("numero_votacao"));
		v.setNum_titulo(rs.getInt("num_titulo"));
		v.setNum_candidato(rs.getInt("num_candidato"));
		return v;
	}
}
