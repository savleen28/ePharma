package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import Pharma.BKDatabaseUtil;
import Pharma.SQLQueries;

public class HospitalUtil {
	public static Hospital generateHospital(Hospital inHospital) throws SQLException {
		Connection con = null;
		CallableStatement cStmt = null;
		try {
			con = BKDatabaseUtil.getConnection();
			cStmt = con.prepareCall(SQLQueries.INSERT_HOSPITAL);
			cStmt.setString(1, inHospital.id);
			cStmt.setString(2, inHospital.name);
			cStmt.setString(3, inHospital.address);
			cStmt.setString(4, inHospital.contact);
			cStmt.setString(5, inHospital.email);
			cStmt.setString(6, inHospital.incharge);
			cStmt.setString(7, inHospital.active);
			cStmt.setString(8, inHospital.lst_updted_on);
			cStmt.setString(9, inHospital.lst_updted_by);
			
            cStmt.execute();
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			cStmt.close(); con.close();
		}
		return inHospital;

}
}