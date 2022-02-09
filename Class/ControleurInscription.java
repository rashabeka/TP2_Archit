package Class;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Abstract.AbstractViewInscription;

public class ControleurInscription {
	public void ShowErreur(String msg) {
        JOptionPane.showMessageDialog(new JFrame(), msg, "Erreur", 0);
    }
    private AbstractViewInscription View;
    private Boolean status;
    public  ControleurInscription(ViewInscription View){
        this.View = View;
        if (View.getMatriculeText().isEmpty() || View.getLastNameText().isEmpty() || View.getFirstNameText().isEmpty() || View.getEmailTex().isEmpty() || View.getPasswordText().isEmpty() || View.getUniversiteText().isEmpty()) {
            this.ShowErreur("veuillez remplir tous les champs");
            setStatus(false);
        }
        if (!View.getMatriculeText().matches("-?\\d+") || !View.getMatriculeText().matches("-?\\d+")) {
            this.ShowErreur("Les champs matricule et ID universite doivent etre de format numerique ");
            setStatus(false);
        }
        if (!View.getEmailTex().matches("^(.+)@(.+)$")) {
            this.ShowErreur("Il faut respecter le format de l'email xxx@xxx.xxx");
            setStatus(false);
        }
        setStatus(true);
    }
    public boolean getStatus(){return this.status;}

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
