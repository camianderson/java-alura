import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

    public List<Content> extractContent(String json) {

        //extract the data I need
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> allContent = new ArrayList<>();

        //populate the content list
        for (Map<String, String> attributes : attributesList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url");

            var content = new Content(title, urlImage);

            allContent.add(content);
        }

        return allContent;

    }

}
