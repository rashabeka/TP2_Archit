public class AbsractFactory {
	
    public AbsractFactory(){}
    public Package getPackage(TypePackage TP){
        if(TP.equals(TypePackage.Standard)){
			return new Standard();
			
		}else if(TP.equals(TypePackage.Premium)){
			return new Premium();
		}
        return new Illimite();
    }
}
