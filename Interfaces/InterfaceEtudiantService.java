package Interfaces;
import java.sql.SQLException;
import java.util.ArrayList;

import Class.Etudiant;

public interface InterfaceEtudiantService {
	
	public boolean inscription(Etudiant etudiant, InterfaceUniversite universite, InterfaceEtudiantRepository etudiantRepository) throws SQLException;	    
		
	public ArrayList<InterfaceEtudiant> GetEtudiantParUniversitye();
		
	public ArrayList<InterfaceEtudiant> GetEtudiatparLivreEmprunte();

			}

