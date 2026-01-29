import java.io.*;
import java.net.*;
import com.google.gson.*;

public class WeatherApp {

    static final String WEATHER_API_KEY = "your_openweather_api_key"; // Replace this

    public static void main(String[] args) throws IOException {
        String location = getUserLocation();
        if (location != null) {
            getWeather(location);
        } else {
            System.out.println("Unable to detect location.");
        }
    }

    // Get user's city using IP Geolocation API
    static String getUserLocation() {
        try {
            URL url = new URL("http://ip-api.com/json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            return json.get("city").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Get weather using OpenWeatherMap API
    static void getWeather(String city) {
        try {
            String urlStr = "https://api.openweathermap.org/data/2.5/weather?q=" + 
                URLEncoder.encode(city, "UTF-8") + 
                "&appid=" + WEATHER_API_KEY + "&units=metric";

            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();

            String weather = json.getAsJsonArray("weather")
                                 .get(0).getAsJsonObject()
                                 .get("description").getAsString();
            double temp = json.getAsJsonObject("main").get("temp").getAsDouble();
            String name = json.get("name").getAsString();

            System.out.println("\n📍 Location: " + name);
            System.out.println("🌤️  Weather: " + weather);
            System.out.println("🌡️  Temperature: " + temp + "°C\n");

        } catch (Exception e) {
            System.out.println("Error retrieving weather: " + e.getMessage());
        }
    }
}