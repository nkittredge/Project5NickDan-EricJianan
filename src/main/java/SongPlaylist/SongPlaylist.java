package SongPlaylist;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import java.net.URL;
import java.util.*;
import static com.google.gson.internal.bind.TypeAdapters.URL;


public class SongPlaylist<HttpURLConnection> {

    @FXML
    private ListView DataList;

    public void loadData() {
        try {
            URL myurl = new URL("https://searchly.asuarez.dev/api/v1/song/search" +
                    "?query=" + "QUERY");
            con = (HttpURLConnection) myurl.openConnection();
            con.setRequestMethod("GET");
            StringBuilder content;

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }
        }
    }
}