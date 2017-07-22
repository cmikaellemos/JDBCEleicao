package br.ufc.eleicao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.ufc.eleicao.entity.Fiscal;

public class FiscalJDBCDAO implements FiscalDAO {

	public FiscalJDBCDAO() {}

	@Override
	public void save(Fiscal entity, int opc) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into Fiscal (num_titulo, cpf, cpf_super) values (?, ?, ?)";
			String update_sql = "update Fiscal set num_titulo = ?, cpf = ?, cpf_super = ? where num_titulo = ?";
			PreparedStatement pst = null;
			if (opc == 1) {
				pst = con.prepareStatement(insert_sql);
			}
			if (opc == 2){
				pst = con.prepareStatement(update_sql);
				pst.setInt(4, entity.getNum_titulo());
			}
			pst.setInt(1, entity.getNum_titulo());
			pst.setString(2, entity.getCpf());
			pst.setString(3, entity.getCpf_super());
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
			String sql = "delete from fiscal where num_titulo = ?";
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
	public Fiscal find(int num_titulo){
		Connection con = null;
		Fiscal f = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select f.num_titulo, urna, cpf, cpf_super from fiscal f, Eleitor e where f.num_titulo = ? and f.num_titulo = e.num_titulo";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, num_titulo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				f = map(rs);
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
		return f;
	}
	
	
	public List<Fiscal> find() {
		Connection con = null;
		List<Fiscal> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select f.num_titulo, urna, cpf, cpf_super from Fiscal f, Eleitor e where f.num_titulo = e.num_titulo";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Fiscal>();
			while (rs.next()) {
				Fiscal f = map(rs);
				result.add(f);
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
	public List<Fiscal> findByCpf(String str) {
		Connection con = null;
		List<Fiscal> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select f.num_titulo, urna, cpf, cpf_super from Fiscal f, Eleitor e where cpf = ? and f.num_titulo = e.num_titulo";
			pst = con.prepareStatement(sql);
			pst.setString(1, JOptionPane.showInputDialog("CPF", '0'));
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Fiscal>();
			while (rs.next()) {
				Fiscal f = map(rs);
				result.add(f);
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
	public List<Fiscal> findByNum_titulo(int num) {
		Connection con = null;
		List<Fiscal> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select f.num_titulo, urna, cpf, cpf_super from Fiscal f, Eleitor e where f.num_titulo = ? and f.num_titulo = e.num_titulo";
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(JOptionPane.showInputDialog("NUM_TITULO", 1)));
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Fiscal>();
			while (rs.next()) {
				Fiscal f = map(rs);
				result.add(f);
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
	public List<Fiscal> findByUrna(int urna) {
		Connection con = null;
		List<Fiscal> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select f.num_titulo, urna, cpf, cpf_super from Fiscal f, Eleitor e where f.num_titulo = e.num_titulo and e.urna = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, urna);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Fiscal>();
			while (rs.next()) {
				Fiscal f = map(rs);
				result.add(f);
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
	
	private Fiscal map(ResultSet rs) throws SQLException {
		Fiscal f = new Fiscal();
		f.setNum_titulo(rs.getInt("num_titulo"));
		f.setCpf(rs.getString("cpf"));
		f.setUrna(rs.getInt("urna"));
		f.setCpf_super(rs.getString("cpf_super"));
		return f;
	}

}
