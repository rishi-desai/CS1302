package cs1302.gallery;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Represents an iTunes GalleryApp!.
 */
public class GalleryApp extends Application {

    // Creates the App node objects
    MainMenu menu;
    MainToolBar toolBar;
    MainContent content;
    HBox progress;
    Text credit;

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) {

        menu = new MainMenu(this);
        toolBar = new MainToolBar(this);
        content = new MainContent(this);
        credit = new Text("Images provided courtesy of iTunes");
        progress = new HBox(5);
        progress.setAlignment(Pos.CENTER_LEFT);
        progress.getChildren().addAll(content.getProgressBar(), credit);

        // Creates a VBox object and adds the nodes
        VBox root = new VBox();
        root.getChildren().addAll(menu, toolBar, content, progress);

        // Creates a Scene and sets the root to it
        Scene scene = new Scene(root);

        // Creates and formats the stage
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);;
        stage.setTitle("GalleryApp!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    } // start

} // GalleryApp
