package pk.foto.ui;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class FotoErfassungView<T> extends ErfassungView<T>{

    public <T> FotoErfassungView (Stage stage) {
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
    }
    
    public <T> Object gibNeuesObjekt() {
        return null;
    }

}
