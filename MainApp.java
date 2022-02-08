import java.sql.SQLException;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		InterfaceEtudiantRepository etudiantRepository = new EtudiantRepository();
		InterfaceUniversiteRepository universiteRepository = new UniversiteRepository();
		InterfaceEtudiantService serv = new EtudiantService(etudiantRepository, universiteRepository);

		Etudiant etudiant = new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com", "xxxx", 1);
		InterfaceUniversite universite = new Universite(2, "Benyoucef Ben Khedda", TypePackage.Standard);


		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com", "xxxx", 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}