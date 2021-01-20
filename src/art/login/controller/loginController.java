/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art.login.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Bright
 */
public class loginController implements Initializable {

    @FXML
    private BorderPane rootPane;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            VBox box = (VBox) FXMLLoader.load(getClass().getResource("/art/login/view/loginForm.fxml"));
            rootPane.setRight(box);
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ScheduledService scheduledService = new ScheduledService() {
            @Override
            protected Task createTask() {
                return new Task() {
                    @Override
                    protected Object call() throws Exception {
                        setImage();
                        return null;
                    }
                };
            }
        };
        scheduledService.setDelay(Duration.ONE);
        scheduledService.setRestartOnFailure(true);
        scheduledService.setPeriod(Duration.seconds(8));
        Platform.runLater(() -> {
            scheduledService.start();
        });
    }

    private void setImage() {

        String image1 = "IMG_0291.PNG";
        String image2 = "IMG_0093.PNG";
        String image3 = "IMG_0090.JPG";
        String image4 = "IMG_0086.JPG";
        String image5 = "IMG_0292.PNG";
        String image6 = "IMG_0085.JPG";

        String image = "";
        int number = 1 + (int) (Math.random() * 5);
        switch (number) {
            case 1: {
                image = image1;
                break;
            }
            case 2: {
                image = image2;
                break;
            }
            case 3: {
                image = image3;
                break;
            }
            case 4: {
                image = image4;
                break;
            }
            case 5: {
                image = image5;
                break;
            }
            case 6: {
                image = image6;
                break;
            }
        }
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), imageView);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
        imageView.setImage(new Image("/art/login/images/" + image + ""));
    }

}
