package br.ufc.eleicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.eleicao.entity.Candidato;

public class CandidatoJDBCDAO implements CandidatoDAO {

	public CandidatoJDBCDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Candidato entity, int opc) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into Candidato (num_titulo, cpf, codigo_partido, num_candidato) values (?, ?, ?, ?)";
			String update_sql = "update candidato set num_titulo = ?, cpf = ?, codigo_partido = ?, num_candidato = ? where num_titulo = ?";
			PreparedStatement pst = null;
			if (opc == 1) {
				pst = con.prepareStatement(insert_sql);
			}
			if (opc == 2){
				pst = con.prepareStatement(update_sql);
				pst.setInt(5, entity.getNum_titulo());
			}
			pst.setInt(1, entity.getNum_titulo());
			pst.setString(2, entity.getCpf());
			pst.setInt(3, entity.getCod_partido());
			pst.setInt(4, entity.getNum_candidato());
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
	public void delete(int num_titulo) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from candidato where num_titulo = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, num_titulo);
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
	public Candidato find(int num_titulo) {
		Connection con = null;
		Candidato cl = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select num_titulo, cpf, codigo_partido, num_candidato from candidato where num_titulo = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, num_titulo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cl = map(rs);
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
		return cl;
	}

	private Candidato map(ResultSet rs) throws SQLException {
		Candidato cl = new Candidato();
		cl.setNum_titulo(rs.getInt("num_titulo"));
		cl.setCpf(rs.getString("cpf"));
		cl.setCod_partido(rs.getInt("codigo_partido"));
		cl.setNum_candidato(rs.getInt("num_candidato"));
		return cl;
	}
	
	@Override
	public List<Candidato> find() {
		Connection con = null;
		List<Candidato> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select num_titulo, cpf, codigo_partido, num_candidato from Candidato";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Candidato>();
			while (rs.next()) {
				Candidato cl = map(rs);
				result.add(cl);
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
	public List<Candidato> findByNumero(int num_candidato) {
		Connection con = null;
		List<Candidato> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select num_titulo, cpf, codigo_partido, num_candidato from Candidato where num_candidato = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, num_candidato );
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Candidato>();
			while (rs.next()) {
				Candidato cl = map(rs);
				result.add(cl);
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
	public List<Candidato> findByCPF(String str) {
		Connection con = null;
		List<Candidato> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select num_titulo, cpf, codigo_partido, num_candidato from Candidato where cpf = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, str);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Candidato>();
			while (rs.next()) {
				Candidato cl = map(rs);
				result.add(cl);
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

}
