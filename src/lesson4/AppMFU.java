package lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMFU extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MFU");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        MFU mfu = loader.getController();
        stage.setOnHidden(e -> mfu.shutdown());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
