package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteLaptopFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtBrand;
    public TextField txtPrice;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try{
            if (CrudUtil.execute("DELETE FROM LaptopA WHERE LapID=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result = CrudUtil.execute("SELECT * FROM LaptopA WHERE LapID=?",txtId.getText());
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
}
