package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Laptop;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateLaptopFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtBrand;
    public TextField txtPrice;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM LaptopA WHERE id=?",txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtBrand.setText(result.getString(3));
                txtPrice.setText(String.valueOf(result.getDouble(4)));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Laptop laptop = new Laptop(
                txtId.getText(),txtName.getText(), txtBrand.getText(),
                Double.parseDouble(txtPrice.getText())
        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE LaptopA SET LapName=? ,  LapBrand=? , Price=? WHERE LapID=?",laptop.getName(),laptop.getBrand(),laptop.getPrice(),laptop.getId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }


        }catch (SQLException | ClassNotFoundException e){

        }
    }
}
