package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Interfaces.IJournal;
import Interfaces.InterfaceEtudiant;
import Interfaces.InterfaceEtudiantRepository;

public class EtudiantRepository implements InterfaceEtudiantRepository{

	private Connection connect;

	private Statement stmt;
	private IJournal J;

	public EtudiantRepository() throws SQLException {
			try {
				this.connect = DBConnection.getConn();
				this.stmt = this.connect.createStatement(); // TO DO ..
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	public boolean Exists(String email) throws SQLException{
		AffichageDate.setClassName("EtudiantRepository");
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.execute(sql);
		
		if (rs){
			J.outPut_Msg("logBD--- :email existe dans la BD  " + email);
			this.connect.close();
			return true;
			}
		J.outPut_Msg("logBD--- : email n'existe pas " + email);	
		this.connect.close();
		return false;
	}
	
	public boolean Exists(int mat) throws SQLException	
	{    AffichageDate.setClassName("EtudiantRepository");
		String sql = "select * from etudiant where matricule="+ mat;
		boolean rs = stmt.execute(sql);
		
		if (rs){
		J.outPut_Msg("logBD--- :etudiant avec ce matricule existe d�ja dans la BD  " + mat);
			this.connect.close();
			return true;
			}
		J.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
		this.connect.close();
		return false;
	}


	
	@Override
	public void add(InterfaceEtudiant E) throws SQLException {
		// TODO Auto-generated method stub
		AffichageDate.setClassName("EtudiantRepository");
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
			J.outPut_Msg("log : ajout dans la BD r�ussi de l'�tudiant  du Matricule" + E.getMatricule());
			}else if (rs == 0){
			J.outPut_Msg("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule" + E.getMatricule());
			}
		this.connect.close();
		
	}

	}


