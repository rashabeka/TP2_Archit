package Interfaces;
import java.sql.SQLException;

import Class.Etudiant;
import Class.Universite;

public interface InterfaceUniversiteRepository {
    public   Universite GetById(int id) throws SQLException;
   
			}

