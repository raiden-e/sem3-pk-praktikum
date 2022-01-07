package pk.foto.ui;

import javafx.stage.Stage;

public abstract class ErfassungView <T> extends Stage{
    
    public boolean showView() {
        return false;
    }
    
    public abstract <T> Object gibNeuesObjekt();
}
