package pk.foto.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pk.exceptions.AlbumVorhandenException;
import pk.foto.Album;

public class AlbumErfassungView extends ErfassungView<Object> {

    Label lOwner = new Label("Besitzer:");
    TextField tfOwner = new TextField();

    public AlbumErfassungView(Stage stage) {
        super(stage);
    }

    public boolean showView() {

        setButtons();

        hb0.getChildren().addAll(lName, tfName);
        hb1.getChildren().addAll(lOwner, tfOwner);
        hb2.getChildren().addAll(bOk, bAbbrechen);
        vbMain.getChildren().addAll(hb0, hb1, hb2);

        // Insets(double top, double right, double bottom, double left)
        lName.setPadding(new Insets(0, 10, 0, 0));
        lOwner.setPadding(new Insets(0, 10, 0, 0));
        tfOwner.setPadding(new Insets(2));
        tfName.setPadding(new Insets(2));

        tfOwner.setMaxWidth(Double.MAX_VALUE);
        tfName.setMaxWidth(Double.MAX_VALUE);

        hb0.setSpacing(3.0);
        hb1.setSpacing(3.0);
        hb2.setSpacing(3.0);

        lName.setAlignment(Pos.CENTER_LEFT);
        lOwner.setAlignment(Pos.CENTER_LEFT);
        hb2.setAlignment(Pos.BOTTOM_CENTER);

        HBox.setHgrow(tfOwner, Priority.ALWAYS);
        HBox.setHgrow(tfName, Priority.ALWAYS);
        HBox.setHgrow(hb0, Priority.ALWAYS);
        HBox.setHgrow(hb1, Priority.ALWAYS);
        HBox.setHgrow(hb2, Priority.ALWAYS);
        VBox.setVgrow(hb2, Priority.ALWAYS);
        VBox.setVgrow(vbMain, Priority.ALWAYS);

        super.showView();
        this.setTitle("Neues Album erfassen");

        showAndWait();
        return super.showView();
    }

    public void setButtons() {
        bOk.setOnAction(e -> {
            if (tfName.getText() == "" || tfOwner.getText() == "") {
                (new Alert(AlertType.WARNING, "Bitte geben Sie Name und Besitzer an!", ButtonType.OK)).showAndWait();
                return;
            }
            super.choice = true;
            Album alb = (Album) gibNeuesObjekt();
            System.out.println(alb);
            try {
                FotoUI.fv.addAlbum(alb);
                FotoUI.updateListView(alb);
                FotoUI.lMetaDescVal.setText("");
            } catch (AlbumVorhandenException e1) {
                (new Alert(AlertType.WARNING, "Dieses Album existiert bereits!", ButtonType.OK)).showAndWait();
            }
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
