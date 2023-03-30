import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // call the API to get the data (response body) and get top movies
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        
       var http = new ClientHttp();
       String json = http.dataSearch(url);

        // instatiate the StickerGenerator to create the stickers
        var parser = new JsonParser();
        List<Map<String, String>> contentList = parser.parse(json);
        for (Map<String,String> content: contentList) {
            InputStream inputStream = new URL(content.get("image")).openStream();
            String stickerTitle = content.get("title") + ".png";

            var generator = new StickerGenerator();
            generator.generate(inputStream, stickerTitle);

            System.out.println("\u001b[1mTitle:\u001b[m " + content.get("title"));
            System.out.println();

        }
    
    }
}
