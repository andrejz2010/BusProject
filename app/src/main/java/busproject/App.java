/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package busproject;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class App {



    public static String fetch(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();


        String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body) // tells the httpresponse instance(which has been stored) to use the body
                // method(thenapply is a public method of completablefuture class)
                .join();


        return response;
    }









    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        System.out.println("Input bus stop code:");
        String userStopCodeInput = sc.nextLine();   //490000129R


        String BUSESONSTOP_URL_API = "https://api.tfl.gov.uk/StopPoint/" + userStopCodeInput + "/Arrivals/?app_key=68d5f5951c8f4ab98a9b491f59c96c18";


       String jsonString= fetch(BUSESONSTOP_URL_API);





        ArrayList<Bus> timesToArrival = new ArrayList<Bus>();

        JSONArray jsonArray=new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject JObject = jsonArray.getJSONObject(i);

            Bus bus= new Bus(JObject.get("id").toString(), JObject.get("lineName").toString(), Integer.parseInt(JObject.get("timeToStation").toString()), JObject.get("destinationName").toString());

            timesToArrival.add(bus);



        }

        Collections.sort(timesToArrival, (b1, b2) -> b1.getSecondsTimeToStation()- b2.getSecondsTimeToStation());




        int numberOfBusesToDisplay=5;

        for (int i = 0; i < numberOfBusesToDisplay ; i++) {

            timesToArrival.get(i).getArrivalMessage();

        }




    }
}