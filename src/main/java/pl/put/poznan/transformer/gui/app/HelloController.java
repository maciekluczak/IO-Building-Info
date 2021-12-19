package pl.put.poznan.transformer.gui.app;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.put.poznan.transformer.data.DataHolder;
import pl.put.poznan.transformer.models.Building;
import pl.put.poznan.transformer.models.Floor;
import pl.put.poznan.transformer.models.Location;
import pl.put.poznan.transformer.models.Room;

import java.io.IOException;
import java.util.List;

public class HelloController {
    public TableColumn areacol;
    public TableColumn heatingcol;
    public TableColumn lightcol;
    public TableColumn cubecol;
    public TableColumn idcol;
    public TableColumn<Location, String> typecol;
    public TableColumn<Location, String> light2col;
    public TableColumn<Location, String> heating3;
    public TextField textField;
    private float limit = 999999999;
    @FXML
    private Button load;
    @FXML
    private TableColumn namecol;


    DataHolder dataHolder = new DataHolder();
    private final ObservableList<Location> data = FXCollections.observableArrayList();
    @FXML
    private TableView table;

    @FXML
    protected void onHelloButtonClick() {
        this.updateTable();
    }

    @FXML
    protected void heatingCount() {
        this.limit = Float.parseFloat(textField.getText());
        updateTable();
    }
    private void updateTable(){
        table.getItems().clear();
        table.refresh();
        List<Building> buildings = DataHolder.getBuildingArray();
        List<Floor> floors = DataHolder.getFloorArray();
        List<Room> rooms = DataHolder.getRoomArray();
        for (Building building : buildings) {
            data.add(building);
        }
        for (Floor floor : floors) {
            data.add(floor);
        }
        for (Room room : rooms) {
            data.add(room);
        }
        table.setItems(data);

    }
    @FXML
    public void initialize() {
        namecol.setCellValueFactory(new PropertyValueFactory<Location, String>("name"));
        idcol.setCellValueFactory(new PropertyValueFactory<Location, Integer>("id"));
        areacol.setCellValueFactory(new PropertyValueFactory<Location, Float>("area"));
        cubecol.setCellValueFactory(new PropertyValueFactory<Location, Float>("cube"));
        heatingcol.setCellValueFactory(new PropertyValueFactory<Location, Float>("heating"));
        lightcol.setCellValueFactory(new PropertyValueFactory<Location, Float>("light"));
        typecol.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getClass().getSimpleName()));
        light2col.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getLightPerUnit())));
        heating3.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getHeatingPerUnit())));
        textField.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.getControlNewText().matches("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)"))
                return null;
            else
                return c;
        }
        ));
        try {
            dataHolder.readModels();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        table.setRowFactory(tv -> new TableRow<Location>(){
            @Override
            protected void updateItem(Location location, boolean empty){
                if (location == null || !location.getClass().getSimpleName().equals("Room")){
                    setStyle("");
                } else if (location.getHeatingPerUnit() > limit){
                    setStyle("-fx-background-color: #ffbaba;");
                } else {
                    setStyle("");
                }
            }
        });
    }
}