import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // call the API to get the data (response body) and get top movies
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // instatiate the StickerGenerator to create the stickers
        var parser = new JsonParser();
        List<Map<String, String>> movieList = parser.parse(body);
        for (Map<String,String> movie: movieList) {
            InputStream inputStream = new URL(movie.get("image")).openStream();
            String stickerTitle = movie.get("title") + ".png";

            var generator = new StickerGenerator();
            generator.generate(inputStream, stickerTitle);

            System.out.println("\u001b[1mTitle:\u001b[m " + movie.get("title"));
            System.out.println();

        }
    
    }
}
