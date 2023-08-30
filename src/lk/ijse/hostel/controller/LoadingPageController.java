package lk.ijse.hostel.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoadingPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ProgressBar proBar;

    @FXML
    private AnchorPane loadingPane;

    @FXML
    void initialize() {
        new ShowSplashScreen().start();
    }
        class ShowSplashScreen extends Thread {
            public void run() {
                try {
                    for (int i = 0; i <= 10; i++) {
                        double x = i * (0.1);
                        proBar.setProgress(x);


                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Platform.runLater(() -> {
                        Stage stage = new Stage();
                        stage.setTitle("Login");
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/lk/ijse/hostel/view/LoginForm.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(LoadingPageController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                        loadingPane.getScene().getWindow().hide();
                    });
                } catch (Exception ex) {
                    Logger.getLogger(LoadingPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

