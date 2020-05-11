package bsu.comp152;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class PhoneModel {
    private String location;

    public PhoneModel(String loc) {location = loc; }

    public HashMap<String, String> getData(){
        var dataGrabber = HttpClient.newHttpClient();
        var requestBuilder = HttpRequest.newBuilder();
        var dataRequest = requestBuilder.uri(URI.create(location)).build();
        HttpResponse<String> response = null;
        try {
            response = dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }catch(IOException e){
            System.out.println("Error. Cant connect to site");
        }
        catch (InterruptedException e){
            System.out.println("Connection to Site Lost");
        }
        if (response == null ){
            System.out.println("Something Went Wrong. End of Program");
            System.exit(-1);
        }
        var usefulData = response.body();
        var jsonInterpreter = new Gson();
        HashMap<String,String> phoneData = jsonInterpreter.fromJson(usefulData, new TypeToken<HashMap<String, String>>(){}.getType());
        return phoneData;
    }

}
