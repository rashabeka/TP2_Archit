package Class;
import Interfaces.Package;

public class Standard implements Package {
	
	    int Bonus;
	    @Override
	    public  void setBonus(int bonus) {
	        // TODO Auto-generated method stub
	        this.Bonus = bonus;
	    }

	    @Override
	    public int getBonus() {
	        // TODO Auto-generated method stub
	        return this.Bonus;
	    }
	    public void setNbLivreMensuelAutorise(Etudiant E){
            E.setNbLivreMensuel_Autorise(10);
    }
	}

