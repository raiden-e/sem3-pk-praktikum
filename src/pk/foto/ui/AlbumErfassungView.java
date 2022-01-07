package pk.foto.ui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlbumErfassungView <T> extends ErfassungView <T>{

    public <T> AlbumErfassungView (Stage stage) {
        var gridpane = new GridPane();
        gridpane.setPadding(new Insets(10.0));
        gridpane.setHgap(5.0);
        gridpane.setVgap(5.0);
        var lName = new Label ("Name");
        var lBesitzer = new Label ("Besitzer");
        var tfName = new TextField();
        var tfBesitzer = new TextField();
        var bOk = new Button("OK");
        var bAbbrechen = new Button("Abbrechen");
        
        gridpane.add(lName, 0, 0);
        gridpane.add(tfName, 1, 0, 3, 1);
        gridpane.add(lBesitzer, 0, 1);
        gridpane.add(tfBesitzer, 1, 1, 3, 1);
        gridpane.add(bOk, 1, 2);
        gridpane.add(bAbbrechen, 2, 2);
        
        this.initOwner(stage);
        this.initModality(Modality.WINDOW_MODAL);
        
        GridPane.setHalignment(bOk, HPos.CENTER);
        GridPane.setHalignment(bAbbrechen, HPos.CENTER);
        
        stage.setScene(new Scene(gridpane));
        stage.setTitle("Neues Album erstellen");
        stage.show();
    }
    
    /*public static void main(String[] args) {
        launch(args);
    }*/
    
    public <T> Object gibNeuesObjekt() {
        return null;
    }
    
    public boolean showView() {
        Stage stage = new Stage();
        var albumerfassungview1 = new AlbumErfassungView(stage);
        return false;
    }

    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        var gridpane = new GridPane();
        gridpane.setPadding(new Insets(10.0));
        gridpane.setHgap(5.0);
        gridpane.setVgap(5.0);
        var lName = new Label ("Name");
        var lBesitzer = new Label ("Besitzer");
        var tfName = new TextField();
        var tfBesitzer = new TextField();
        var bOk = new Button("OK");
        var bAbbrechen = new Button("Abbrechen");

        

        
        gridpane.add(lName, 0, 0);
        gridpane.add(tfName, 1, 0, 3, 1);
        gridpane.add(lBesitzer, 0, 1);
        gridpane.add(tfBesitzer, 1, 1, 3, 1);
        gridpane.add(bOk, 1, 2);
        gridpane.add(bAbbrechen, 2, 2);
        
        //this.initOwner(stage);
        //this.initModality(Modality.WINDOW_MODAL);
        
        GridPane.setHalignment(bOk, HPos.CENTER);
        GridPane.setHalignment(bAbbrechen, HPos.CENTER);
        
        primaryStage.setScene(new Scene(gridpane));
        primaryStage.setTitle("Neues Album erstellen");
        primaryStage.show();
        
    }
    */
    
}
