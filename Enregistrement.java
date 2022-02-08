import java.sql.SQLException;

public class Enregistrement {

	public Enregistrement(){}
    public boolean EtudiantVerification(Etudiant E, InterfaceEtudiantRepository ER) throws SQLException{
        if(E.getEmail() != null || E.getEmail().length() != 0 ){
            if(!ER.Exists(E.getEmail())){
                if(!ER.Exists(E.getMatricule())){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }      
        return false;
    }
    public void setNbLivreMensuelAutorise(Etudiant E, TypePackage P){
        if(P == TypePackage.Standard){
            E.setNbLivreMensuel_Autorise(10);
        }
        if(P == TypePackage.Premium){
            E.setNbLivreMensuel_Autorise(20);
        }
    }
    } 