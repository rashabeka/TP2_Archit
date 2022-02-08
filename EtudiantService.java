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

	public boolean inscription (int matricule, String nom, String prenom, String email,String pwd, int id_universite) throws SQLException
	{
		EtudiantRepository StudRep= new EtudiantRepository();
	    UniversiteRepository UnivRep= new UniversiteRepository();
	    Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	    Universite univ=UnivRep.GetById(id_universite);
	    
	    System.out.println("Log: debut de l'operation d'ajout de l'etudiant avec matricule "+matricule);
	    
	    if(email == null || email.length() == 0)
	    {
	    	return false;
	    }
	    
	    if (StudRep.Exists(matricule))
	    {
	        return false;
	    }
	    
		if (StudRep.Exists(email))
	    {
	        return false;
	    }
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 StudRep.add(stud);
		 System.out.println("Log: Fin de l'operation d'ajout de l'etudiant avec matricule "+matricule);
		 return true;
	    
		
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
