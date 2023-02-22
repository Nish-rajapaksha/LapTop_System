package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {
    public void saveLaptopOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SaveLaptopForm");
    }

    public void searchLaptopOnAction(ActionEvent actionEvent) throws IOException {
        setUi("SearchLaptopForm");
    }

    public void updateLaptopOnAction(ActionEvent actionEvent) {
    }

    public void deleteLaptopOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DeleteLaptopForm");
    }

    public void loadAllaptopOnAction(ActionEvent actionEvent) {
    }
    private void setUi(String URI) throws IOException {
        Parent parent  = FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }
}
