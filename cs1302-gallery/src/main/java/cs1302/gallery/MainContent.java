package cs1302.gallery;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import java.time.LocalTime;
import javafx.util.Duration;
import java.util.Random;

/**
 * Custom component for the MainContent.
 */
public class MainContent extends GridPane {

    /** The variables that make up the MainContent. */
    protected ArrayList<String> extraUrls;
    protected ArrayList<ImageView> imageViews;
    protected Timeline timeline;
    protected int count = 0;
    protected ProgressBar progressBar = new ProgressBar();
    protected Random rand = new Random();
    protected GalleryApp app;

    /**
     * Constructs a MainContent object.
     *
     * @param app A GalleryApp object.
     */
    public MainContent(GalleryApp app) {
        // Calls parent constructor
        super();

        this.app = app;

        // Calls methods to set default contents
        updateImages(app);
        swapImages(timeline);
    } // MainContent

    /**
     * Updates the images of the 5x4 grid.
     *
     * @param app A GalleyApp Object.
     */
    public void updateImages(GalleryApp app) {
        // Creates a new ArrayList object and calls getUrl from the ToolBar class
        ArrayList<String> urls = app.toolBar.getUrl();

        imageViews = new ArrayList<>();
        extraUrls = new ArrayList<>();
        timeline = new Timeline();
        count = 0;

        setProgress(0);
        // If less than 21 urls are gathered then an alert displays
        if (urls.size() < 21) {
            imagesAlert();
        } else {
            // Creates the images from the urls
            for (int i = 0; i < urls.size(); i++) {
                if (i <= 20) {
                    imageViews.add(new ImageView());
                    final Image tempImage = new Image(urls.get(i), 120, 120, false, false);
                    setProgress(1.0 * i / 20);
                    imageViews.get(i).setImage(tempImage);
                } else {
                    // Extra urls are added to the ArrayList
                    extraUrls.add(urls.get(i));
                } // if
            } // for
            setProgress(1);

            // Sets each of the 20 ImageViews to the image
            int count = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    ImageView temp = imageViews.get(count);
                    this.add(temp, i, j);
                    count++;
                } // for
            } // for
        } // if
    } // updateImages

    /**
     * An alert that displays when not enough images were able to be gathered.
     */
    public void imagesAlert() {
        // Creates a Alert object and sets the title, header, and content
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setResizable(true);
        errorAlert.setTitle("Alert");
        errorAlert.setHeaderText("Main contents could not be updated");
        errorAlert.setContentText("Less than twenty one (21) distinct artwork image" +
                                   " were able to be gathered");
        errorAlert.showAndWait();
    } //  imagesAlert

    /**
     * Allows the images to swap every two seconds while the app is running.
     *
     * @param timeline a TimeLine.
     */
    public void swapImages(Timeline timeline) {
        EventHandler<ActionEvent> handler = event -> randImages();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), handler);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    } // swapImages

    /**
     * Sets random ImageViews to the unused urls.
     */
    public void randImages() {
        if (count < extraUrls.size()) {
            // Creates a Random Object and a random int from 0-images.length
            int index = rand.nextInt(imageViews.size());

            // Sets a urls to an image and then the ImageView to the image
            Image temp = new Image(extraUrls.get(count), 120, 120, false, false);
            Platform.runLater(() -> imageViews.get(index).setImage(temp));
            count++;
        } // if
    } // randImages

    /**
     * Returns the ProgressBar.
     *
     * @return the ProgressBar
     */
    public ProgressBar getProgressBar() {
        return progressBar;
    } // getProgressBar

    /**
     * Sets the progress of the ProgressBar.
     *
     * @param progress the progress of the ProgressBar.
     */
    private void setProgress(final double progress) {
        Platform.runLater(() -> progressBar.setProgress(progress));
    } // setProgress

    /**
     * Returns the Timeline.
     *
     * @return the Timeline.
     */
    public Timeline getTimeLine() {
        return timeline;
    } // getTimeLine

} // MainContent
