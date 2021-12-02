package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementPostgres implements ReimbursementDao {

	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_reimbursement;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_author"));
				reimbursements.add(r);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementById(int id) {
List<Reimbursement> rlist = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_reimbursement where reimb_author = ?;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_author"));
				rlist.add(r);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rlist;
		
		
	}

	@Override
	public List<Reimbursement> getReimbursementByType(int type) {
			List<Reimbursement> rlist = new ArrayList<>();
					
					try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
						String sql = "select * from ers_reimbursement where reimb_type_id = ?;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setInt(1, type);
						ResultSet rs = ps.executeQuery();
						
						while (rs.next()) {
							Reimbursement r = new Reimbursement(rs.getInt("reimb_id"),
									rs.getFloat("reimb_amount"),
									rs.getTimestamp("reimb_submitted"),
									rs.getTimestamp("reimb_resolved"),
									rs.getString("reimb_description"),
									rs.getInt("reimb_resolver"),
									rs.getInt("reimb_status_id"),
									rs.getInt("reimb_type_id"),
									rs.getInt("reimb_author"));
							rlist.add(r);
						}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					return rlist;
					
					
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(int status) {
		List<Reimbursement> rlist = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_reimbursement where reimb_status_id = ?;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_author"));
				rlist.add(r);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rlist;
		
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement r) {
		
		
		try (Connection con = ConnectionUtil.getConnectionFromEnv()){
			String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_type_id, reimb_author, reimb_status_id) values (?,?,?,?,?,?) returning reimb_id;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setFloat(1, r.getAmount());
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setString(3, r.getDescription());
			ps.setInt(4, r.getType());
			ps.setInt(5, r.getAuthorId());
			ps.setInt(6, 1);
			ps.executeQuery();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public boolean changeReimbursementStatus(Reimbursement r) {
		boolean result = false;
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "update ers_reimbursement set reimb_status_id = ?, reimb_resolver = ?, reimb_resolved = ? where reimb_id = ?;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getStatus());
			ps.setInt(2, r.getResolverId());
			ps.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
			ps.setInt(4, r.getId());
			ps.executeUpdate();
			result = true;
			
			
			
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return result;
	}

	

	@Override
	public Reimbursement getAReimbursement(int id) {
		Reimbursement r = null;
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_reimbursement where reimb_id = ?;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			System.out.println("You made it to rs.next!");
			if (rs.next()) {
				
				 r = new Reimbursement(rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_author"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return r;
		
	}
	@Override
	public List<Reimbursement> getEmpReimByStatus(int id,int status) {
		List<Reimbursement> rlist = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnectionFromEnv()) {
			String sql = "select * from ers_reimbursement where reimb_status_id = ? AND reimb_author = ?;"; //er inner join ers_reimbursement_status ers USING(reimb_status_id) inner join ers_reimbursement_type using(reimb_type_id) order by reimb_id;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement r = new Reimbursement(rs.getInt("reimb_id"),
						rs.getFloat("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"),
						rs.getInt("reimb_author"));
				rlist.add(r);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rlist;
		
	}
}
