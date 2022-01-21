package pk.foto.ui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pk.foto.Album;

public class AlbumErfassungView extends ErfassungView<Object> {
    TextField tfBesitzer = new TextField();

    public AlbumErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {
        super.showView();
        this.setTitle("Album Erfassen");
        setButtons();

        var lBesitzer = new Label("Besitzer:");
        tfBesitzer.setMaxWidth(Double.MAX_VALUE);

        gridpane.add(lBesitzer, 0, 1);
        gridpane.add(tfBesitzer, 1, 1);

        stage.setTitle("Neues Album erstellen");

        showAndWait();
        return super.showView();
    }

    public Object gibNeuesObjekt() {
        return new Album(super.tfName.getText(), tfBesitzer.getText());
    }

    public void setButtons() {
        bOk.setOnAction(e -> {
            super.choice = true;
            System.out.println(gibNeuesObjekt());
            this.stage.close();
        });
        bAbbrechen.setOnAction(e -> {
            super.choice = false;
            this.stage.close();
        });
    }
}
