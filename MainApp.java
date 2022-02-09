import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JSpinner.ListEditor;

import Class.AffichageDate;
import Class.AffichageEcran;
import Class.AffichageFile;
import Class.Composite;
import Class.Etudiant;
import Class.EtudiantRepository;
import Class.EtudiantService;
import Class.Premium;
import Class.Standard;
import Class.Universite;
import Class.UniversiteRepository;
import Class.ViewInscription;
import Interfaces.IJournal;
import Interfaces.InterfaceEtudiantRepository;
import Interfaces.InterfaceEtudiantService;
import Interfaces.InterfaceUniversite;
import Interfaces.InterfaceUniversiteRepository;
import Interfaces.TypePackage;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		
		Composite AListes = new Composite();
        IJournal AffichageEcran = new AffichageEcran();
        IJournal AffichageDate = new AffichageDate();
        IJournal AffichageFile = new AffichageFile();

        AListes.addAffichage(AffichageFile);
        AListes.addAffichage(AffichageEcran);
        AListes.addAffichage(AffichageDate);
        
        Standard standard = new Standard();
		standard.setBonus(5);
		Premium premium = new Premium();
		premium.setBonus(10);
		
		InterfaceEtudiantRepository etudiantRepository = new EtudiantRepository();
		InterfaceUniversiteRepository universiteRepository = new UniversiteRepository();
		InterfaceEtudiantService serv = new EtudiantService(etudiantRepository, universiteRepository,AListes);
        ArrayList<Etudiant>listeEtudiant=new ArrayList<Etudiant>();
        ArrayList<Universite>listeUniversite=new ArrayList<Universite>();
        
		listeEtudiant.add(new Etudiant(2, "Guendouziiiii", "wassila", "guen@gmail.com", "xxxx", 1));
		listeUniversite.add( new Universite(2, "Benyoucef Ben Khedda", TypePackage.Standard));
		ViewInscription V = new ViewInscription(etudiantRepository);


		try {
			for (Etudiant Etudiant:listeEtudiant) {
				 for (Universite Universite:listeUniversite) {
					 if(Etudiant.getId_universite()==Universite.getI_univ()) {
						 serv.inscription(Etudiant, Universite, etudiantRepository);
					 }
				 }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}