package Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Abstract.AbsractFactory;
import Interfaces.IJournal;
import Interfaces.InterfaceEtudiant;
import Interfaces.InterfaceEtudiantRepository;
import Interfaces.InterfaceEtudiantService;
import Interfaces.InterfaceUniversite;
import Interfaces.InterfaceUniversiteRepository;
import Interfaces.Package;
public class EtudiantService implements InterfaceEtudiantService {

	private InterfaceEtudiantRepository EtudRep;
	private InterfaceUniversiteRepository UnivRep;
	private IJournal J;

	public EtudiantService(InterfaceEtudiantRepository EtudRep ,InterfaceUniversiteRepository UnivRep, IJournal J) {
		super();
		this.EtudRep = EtudRep;
		this.UnivRep = UnivRep;
		this.J=J;

	}
public void AjouerBonusEtudiant(Etudiant E, InterfaceUniversiteRepository UR) throws SQLException{
		
		InterfaceUniversite universite = UR.GetById(E.getId_universite());
		AbsractFactory AB = new AbsractFactory();
		Package P = AB.getPackage(universite.getPack());
		E.bonus(P.getBonus());
	}
	public boolean inscription(Etudiant etudiant, InterfaceUniversite universite, InterfaceEtudiantRepository etudiantRepository,InterfaceUniversiteRepository universiteRepository) throws SQLException {	    
		AffichageDate.setClassName("EtudiantService");
		J.outPut_Msg("Log: debut de l'operation d'ajout de l'etudiant avec matricule "+etudiant.getMatricule());
	    
		if (etudiantRepository.EtudiantVerification(etudiant))
		{    AbsractFactory AFactory = new AbsractFactory();
		     Package P = AFactory.getPackage(universite.getPack());
	       	 P.setNbLivreMensuelAutorise(etudiant );
		     etudiantRepository.add(etudiant);
		 J.outPut_Msg("Log: Fin de l'opération d'ajout de l'étudiant avec matricule "+etudiant.getMatricule());
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
