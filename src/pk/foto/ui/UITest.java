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
import javafx.stage.Stage;

public class UITest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        var gp = new GridPane();
        gp.setPadding(new Insets(10.0));
        gp.setHgap(5.0);
        gp.setVgap(5.0);

        var lv = new ListView<String>();
        for (int i = 0; i < 100; i++)
            lv.getItems().add("This item " + i);

        var l1 = new Label("Label 0");
        var l2 = new Label("Label 1");

        var tf1 = new TextField("Text Field 0");
        var tf2 = new TextField("Text Field 1");

        var b = new Button("Start");

        gp.add(lv, 0, 0, 1, 3);
        gp.add(l1, 1, 0);
        gp.add(l2, 1, 1);
        gp.add(tf1, 2, 0);
        gp.add(tf2, 2, 1);
        gp.add(b, 2, 3);

        GridPane.setHalignment(b, HPos.CENTER);

        primaryStage.setScene(new Scene(gp));
        primaryStage.setTitle("GridPane Layout");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}