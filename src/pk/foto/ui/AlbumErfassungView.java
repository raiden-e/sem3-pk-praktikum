package pk.foto.ui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import pk.foto.Album;

public class AlbumErfassungView extends ErfassungView<Object> {
    public AlbumErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {
        super.showView();
        this.setTitle("Neues Album erfassen");
        setButtons();

        stage.setTitle("Neues Album erfassen");
        showAndWait();
        return super.showView();
    }

    public void setButtons() {
        bOk.setOnAction(e -> {
            if (super.tfName.getText() == "" || tfOwner.getText() == "") {
                (new Alert(AlertType.CONFIRMATION, "Uff Bruder, das lepsch", ButtonType.OK)).showAndWait();
                return;
            }
            super.choice = true;
            System.out.println(gibNeuesObjekt());
            this.close();
        });
        bAbbrechen.setOnAction(e -> {
            super.choice = false;
            this.close();
        });
    }

    public Object gibNeuesObjekt() {
        return new Album(super.tfName.getText(), tfOwner.getText());
    }
}
