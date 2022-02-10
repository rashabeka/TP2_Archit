package Interfaces;
import java.sql.SQLException;

import Class.Etudiant;

public interface InterfaceEtudiantRepository {
	
		public  void add(InterfaceEtudiant e)throws SQLException ;
		public  boolean Exists(int matricule) throws SQLException;
		public  boolean Exists(String email) throws SQLException;
		public boolean EtudiantVerification(InterfaceEtudiant E) throws SQLException;

	}


