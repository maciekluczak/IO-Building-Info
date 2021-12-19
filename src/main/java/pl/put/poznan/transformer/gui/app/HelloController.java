package pl.put.poznan.transformer.gui.app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.put.poznan.transformer.data.DataHolder;
import pl.put.poznan.transformer.models.Building;

import java.io.IOException;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    DataHolder dataHolder = new DataHolder();

    @FXML
    protected void onHelloButtonClick() {
        try {
            dataHolder.readModels();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<Building> buildings = DataHolder.getBuildingArray();

        welcomeText.setText(buildings.get(0).getName());
    }
}