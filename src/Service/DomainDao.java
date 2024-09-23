package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import helpers.GlobalVariable;
import helpers.connect;
import model.Domain;
import model.SearchHistory;
import model.User;
import view.LoginView;

public class DomainDao {
	public boolean saveDomainImportant(Domain domain,String email) throws Exception{
		
		
		
		String sql = "INSERT INTO Domain(domain_name,domain_content)"
				+ "VALUES(?,?)";
		String sql1 ="SELECT * FROM Domain where domain_name= ?";
		String sql2 ="SELECT * FROM users where email= ?";
		String sql3 = "INSERT INTO search_history(domain_id,search_time, user_id)"
				+ "VALUES(?,?,?)";
		try (
			Connection con = connect.connect();
			PreparedStatement pstmt = con.prepareStatement(sql);
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			PreparedStatement pstmt3 = con.prepareStatement(sql3);
			){
			pstmt.setString(1,domain.getDomainName());
			pstmt.setString(2,domain.getContentDomain());
			pstmt.executeUpdate();
			
			pstmt1.setString(1, domain.getDomainName());
			pstmt2.setString(1,email);
			
			System.out.println(email);
			
			
			System.out.println( domain.getDomainName() +" " + LoginView.emailGlobal);
			try(ResultSet rs = pstmt1.executeQuery();
				ResultSet rs2 = pstmt2.executeQuery()){
				if(rs.next() && rs2.next()){	
					pstmt3.setInt(1, rs.getInt("domain_id"));
					pstmt3.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
					pstmt3.setInt(3,rs2.getInt("id"));			
				}
			}		
		return pstmt3.executeUpdate()>0;
		}
		
	
	}
	
	public ArrayList<SearchHistory> getListDomains(String email) throws Exception{
		String sql ="SELECT * FROM users where email= ?";
		String sql1 = "SELECT search_id, domain.domain_name, domain.domain_content, search_time FROM search_history "
				+ "inner join users on users.id = search_history.user_id "
				+ "INNER join domain on domain.domain_id = search_history.domain_id where search_history.user_id = ?";
		ArrayList<SearchHistory> list = new ArrayList<>();
		Integer userId;
		try (
				Connection con = connect.connect();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setString(1,email);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					userId = rs.getInt("id");
					
					try (
							PreparedStatement ps1 = con.prepareStatement(sql1)){
							ps1.setInt(1,userId);
							
							ResultSet rs1 = ps1.executeQuery();
							while(rs1.next()) {
								SearchHistory search = new SearchHistory();
								search.setDomain_name(rs1.getString("domain_name"));
								search.setDomain_content(rs1.getString("domain_content"));
								search.setSearch_date(rs1.getString("search_time"));
								
								System.out.println(rs1.getString("domain_name")+" "+rs1.getString("domain_content")+rs1.getString("search_time"));
								list.add(search);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						return list;
					}				
					
				}
				return null;
		
				}
	
}
