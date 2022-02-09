package Interfaces;
import java.sql.SQLException;

import Class.Universite;

public interface InterfaceUniversiteRepository {
    public   Universite GetById(int id) throws SQLException;
			}

