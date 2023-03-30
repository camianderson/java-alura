import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // call the API to get the data (response body) and get top movies
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // ContentExtractor extractor = new MoviesContentExtractor();

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        ContentExtractor extractor = new NasaContentExtractor();
        
        var http = new ClientHttp();
        String json = http.dataSearch(url);

        List<Content> allContent = extractor.extractContent(json);
       
        var generator = new StickerGenerator();

        for(int i = 0; i < 3; i++){

            Content content = allContent.get(i);
            
            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String stickerTitle = content.getTitle() + ".png";

            generator.generate(inputStream, stickerTitle);

            System.out.println("\u001b[1mTitle:\u001b[m " + content.getTitle());
            System.out.println();

        }
    
    }
}
