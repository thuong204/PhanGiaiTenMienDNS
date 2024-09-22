package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import helpers.connect;
import model.Domain;

public class DomainDao {
	public boolean saveDomainImportant(Domain domain) throws Exception{
		
		
		
		String sql = "INSERT INTO Domain(domain_name,domain_content)"
				+ "VALUES(?,?)";
		try (
			Connection con = connect.connect();
			PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setString(1,domain.getDomainName());
			pstmt.setString(2,domain.getContentDomain());
			return pstmt.executeUpdate()>0;
		}
	}

}
