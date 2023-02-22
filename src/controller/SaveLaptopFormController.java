package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Laptop;
import util.CrudUtil;

import java.sql.SQLException;

public class SaveLaptopFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtBrand;
    public TextField txtPrice;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Laptop laptop = new Laptop(
                txtId.getText(),txtName.getText(), txtBrand.getText(),
                Double.parseDouble(txtPrice.getText())
        );

        try {
            if (CrudUtil.execute("INSERT INTO LaptopA VALUES (?,?,?,?)",laptop.getId(),laptop.getName(),laptop.getBrand(),laptop.getPrice())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    }

