package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Laptop;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllLaptopFormController {
    public TableView tblLptops;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colBrand;
    public TableColumn colPrice;

    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colBrand.setCellValueFactory(new PropertyValueFactory("brand"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));

        try {
            loadAllLaptops();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private void loadAllLaptops() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM LaptopA");
        ObservableList<Laptop> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Laptop(
                            result.getString("LapID"),
                            result.getString("LapName"),
                            result.getString("LapBrand"),
                            result.getDouble("Price")
                    )
            );
        }
        tblLptops.setItems(obList);

    }
}
