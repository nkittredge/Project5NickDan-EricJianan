package bsu.comp152;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import java.net.URL;
import java.util.*;

public class PhoneNumber implements Initializable {

    @FXML
    private ListView DataList;

    public void loadData() {
        var phoneLoc = "http://country.io/phone.json";
        var nameLoc =  "http://country.io/names.json";

        var country = getCountry();

        var phoneModel = new PhoneModel(phoneLoc);
        var phoneData = phoneModel.getData();

        var nameModel = new PhoneModel(nameLoc);
        var nameData = nameModel.getData();

        ArrayList<String> info = new ArrayList<>();

        for (HashMap.Entry<String, String> entry : nameData.entrySet()){
            if (entry.getValue().equals(country)){
                info.add(entry.getKey());
                info.add(entry.getValue());
                info.add(phoneData.get(entry.getKey()));
            }
        }

        var observableData = FXCollections.observableArrayList(info);
        DataList.setItems(observableData);
    }

    private String getCountry(){
        TextInputDialog answer = new TextInputDialog("United States");
        answer.setHeaderText("Gathering Information");
        answer.setContentText("What country do you want to look up?");
        Optional<String> result = answer.showAndWait();
        if (result.isPresent())
            return result.get();
        else
            return "";
    }

    @Override
    public void initialize (URL location, ResourceBundle resources) {

    }
}