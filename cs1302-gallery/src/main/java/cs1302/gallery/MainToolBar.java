package cs1302.gallery;

import javafx.scene.control.ToolBar;
import javafx.scene.control.Separator;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.URL;
import java.io.InputStreamReader;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.io.IOException;
import javafx.animation.Timeline;

/**
 * Custom component for the MainToolBar.
 */
public class MainToolBar extends ToolBar {

    /** The nodes and variables that make up the MainToolBar. */
    protected ArrayList<String> stringUrl;
    Button playPause;
    Text search;
    TextField queryField;
    String query;
    Button updateImage;
    int count;

    /**
     * Constructs a MainToolBar object.
     *
     * @param app A GalleryApp object.
     */
    public MainToolBar(GalleryApp app) {

        // Calls parent constructor
        super();

        // Initializes nodes
        playPause = new Button("Pause");
        search = new Text("Search Query:");
        queryField = new TextField();
        query = new String("The Beatles");
        updateImage = new Button("Update Image");

        queryField.setText("Pop");
        querySearch();

        // When playPause is clicked the text is changed and the App plays or pauses
        playPause.setOnAction(p -> {
            if (playPause.getText().equals("Pause")) {
                playPause.setText("Play");
                app.content.getTimeLine().pause();
            } else {
                playPause.setText("Pause");
                app.content.getTimeLine().play();
            } // if
        });

        // When updateImage is clicked the App images change
        updateImage.setOnAction(i -> {
            querySearch();
            app.content.updateImages(app);
            app.content.swapImages(app.content.getTimeLine());
        });

        // Adds nodes to the MainToolBar
        this.getItems().addAll(playPause, new Separator(), search, queryField, updateImage);

    } // MainToolBar

    /**
     * Downloads the JSON results and parses the art work URL and adds them to a {@code JsonArray}.
     */
    public void querySearch() {
        try {
            query = queryField.getText();

            // Encodes the user inputted text so it can be used in the Itunes API
            String sUrl = "https://itunes.apple.com/search?term=" + URLEncoder.encode
                (query, StandardCharsets.UTF_8) + "&limit=50&media=music";
            URL url = new URL(sUrl);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            JsonElement je = JsonParser.parseReader(reader);
            JsonObject root = je.getAsJsonObject();
            JsonArray results = root.getAsJsonArray("results");
            stringUrl = new ArrayList<>();

            // Gets the Json object urls and turns them into strings
            // and adds them to an array
            count = 0;
            for (int i = 0; i < 50; i++) {
                JsonObject result = results.get(i).getAsJsonObject();
                JsonElement artworkUrl100 = result.get("artworkUrl100");
                stringUrl.add(artworkUrl100.getAsString());
                stringUrl = removeDuplicates(stringUrl);
            } // for
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } // try
    } // querySearch

    /**
     * Removes the duplicates from an ArrayList.
     *
     * @param <T> The type.
     * @param list An ArrayList.
     * @return An ArrayList.
     */
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
                newList.add(element);
            } // if
        } // for

        // return the new list
        return newList;
    } // removeDuplicates

    /**
     * Gets the url ArrayList.
     *
     * @return An ArrayList of type String.
     */
    public ArrayList<String> getUrl() {
        return stringUrl;
    } // getUrl

} // MainToolBar
