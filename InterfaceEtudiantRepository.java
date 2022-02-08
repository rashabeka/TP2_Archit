import java.sql.SQLException;

public interface InterfaceEtudiantRepository {
	
		public  void add(InterfaceEtudiant e)throws SQLException ;
		public  boolean Exists(int matricule) throws SQLException;
		public  boolean Exists(String email) throws SQLException;

	}


