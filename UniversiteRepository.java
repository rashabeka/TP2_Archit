
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements InterfaceUniversiteRepository{

	private Connection connect;
	private Statement stmt;

	public UniversiteRepository(){

		try {
			this.connect = DBConnection.getConn();
			this.stmt = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public Universite GetById(int universityId) throws SQLException {


		System.out.println("LogBD : d�but recherche de id universit� dans la base de donn�e");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			
		System.out.println("LogBD : universit� r�cup�r�e");
		
		connect.close();
		return u;	
	
		
	}
}
