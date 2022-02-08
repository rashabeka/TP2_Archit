import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService implements InterfaceEtudiantService {

	private InterfaceEtudiantRepository EtudRep;
	private InterfaceUniversiteRepository UnivRep;

	public EtudiantService(InterfaceEtudiantRepository EtudRep ,InterfaceUniversiteRepository UnivRep) {
		super();
		this.EtudRep = EtudRep;
		this.UnivRep = UnivRep;

	}

	public boolean inscription(Etudiant etudiant, InterfaceUniversite universite, InterfaceEtudiantRepository etudiantRepository) throws SQLException {	    
	    System.out.println("Log: debut de l'operation d'ajout de l'etudiant avec matricule "+etudiant.getMatricule());
	    Enregistrement  R = new Enregistrement ();
		if (R.EtudiantVerification(etudiant, etudiantRepository))
		{
		 R.setNbLivreMensuelAutorise(etudiant, universite.getPack());
		 etudiantRepository.add(etudiant);
		 System.out.println("Log: Fin de l'operation d'ajout de l'etudiant avec matricule "+etudiant.getMatricule());
		 return true;
		}
		return false;
	   }
	
	
	

public ArrayList<InterfaceEtudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<InterfaceEtudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}

	
}
