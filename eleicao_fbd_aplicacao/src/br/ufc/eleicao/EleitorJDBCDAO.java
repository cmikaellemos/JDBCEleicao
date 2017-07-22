package br.ufc.eleicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.ufc.eleicao.entity.Eleitor;


public class EleitorJDBCDAO implements EleitorDAO {

	public EleitorJDBCDAO() { }
	

	@Override
	public void save(Eleitor entity, int opc) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String insert_sql = "insert into eleitor (num_titulo, urna, nome, data_nascimento, sexo) values (?, ?, ?, ?, ?)";
			String update_sql = "update eleitor set num_titulo = ?, urna = ?, nome = ?, data_nascimento = ?, sexo = ? where num_titulo = ?";
			PreparedStatement pst = null;
			if (opc == 1) {
				pst = con.prepareStatement(insert_sql);
			}
			if (opc == 2){
				pst = con.prepareStatement(update_sql);
				pst.setInt(6, entity.getNum_titulo());
			}
			pst.setInt(1, entity.getNum_titulo());
			pst.setInt(2, entity.getUrna());
			pst.setString(3, entity.getNome());
			pst.setDate(4, entity.getData_nascimento());
			pst.setString(5, entity.getSexo());
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
			String sql = "delete from eleitor where num_titulo = ?";
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
	public Eleitor find(int num_titulo) {
		Connection con = null;
		Eleitor cl = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select num_titulo, urna, nome, data_nascimento, sexo from eleitor where num_titulo = ?";
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
	
	private Eleitor map(ResultSet rs) throws SQLException {
		Eleitor cl = new Eleitor();
		cl.setNum_titulo(rs.getInt("num_titulo"));
		cl.setUrna(rs.getInt("urna"));
		cl.setNome(rs.getString("nome"));
		cl.setData_nascimento(rs.getDate("data_nascimento"));
		cl.setSexo(rs.getString("sexo"));
		return cl;
	}

	@Override
	public List<Eleitor> find() {
		Connection con = null;
		List<Eleitor> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select num_titulo, urna, nome, data_nascimento, sexo from eleitor";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Eleitor>();
			while (rs.next()) {
				Eleitor cl = map(rs);
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
	public List<Eleitor> findByUrna(int urna) {
		Connection con = null;
		List<Eleitor> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select num_titulo, urna, nome, data_nascimento, sexo from eleitor where urna = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, urna);
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Eleitor>();
			while (rs.next()) {
				Eleitor cl = map(rs);
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
	public List<Eleitor> findByNome(String str) {
		Connection con = null;
		List<Eleitor> result = null;
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement pst;
			String sql = "select num_titulo, urna, nome, data_nascimento, sexo from eleitor where upper(nome) like ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + str.toUpperCase() + "%");
			ResultSet rs = pst.executeQuery();
			result = new ArrayList<Eleitor>();
			while (rs.next()) {
				Eleitor cl = map(rs);
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
