package cs1302.gallery;

import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * Custom component for the MainMenu.
 */
public class MainMenu extends MenuBar {

    /** The nodes that make up the MainMenu. */
    VBox root;
    Stage stage;
    Scene scene;
    BorderPane pane;
    HBox imageAbout;
    Text name;
    Text email;
    Text version;
    Image portrait;
    ImageView iv1;
    Menu file;
    Menu help;
    MenuItem about;
    MenuItem exit;
    MenuBar menuBar;

    /**
     * Constructs a MainMenu object.
     *
     * @param app A GalleryApp object.
     */
    public MainMenu(GalleryApp app) {

        // Calls parent constructor
        super();

        // Initializes nodes
        stage = new Stage();
        pane = new BorderPane();
        name = new Text("Rishi Desai");
        email = new Text("rad47988@uga.edu");
        version = new Text("Version 1.0");
        portrait = new Image("https://i.imgur.com/O7n33OP.jpg");
        iv1 = new ImageView(portrait);
        file = new Menu("File");
        help = new Menu("Help");
        about = new MenuItem("About");
        exit = new MenuItem("Exit");

        // Creates the about me stage
        createAboutMe();

        // When exit MenuItem is clicked the App closes
        exit.setOnAction(e -> Platform.exit());

        // When about MenItem is clicked the App opens an about me scene
        about.setOnAction(e -> {
            stage.showAndWait();
        });

        // Adds MenuItems to the Menu
        help.getItems().add(about);
        file.getItems().add(exit);

        // Adds Menus to MenuBar
        this.getMenus().addAll(file, help);

    } // MainMenu

    /**
     * Formats the nodes for the scene. Then adds the nodes to the scene and
     * sets the scene to the stage
     */
    public void createAboutMe() {
        // Format the ImageView
        iv1.setFitWidth(300);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);

        // Sets the font of name and email
        name.setFont(new Font(15));
        email.setFont(new Font(15));

        // Formats and adds nodes to BorderPane
        pane.setAlignment(version, Pos.BOTTOM_LEFT);
        pane.setAlignment(name, Pos.TOP_LEFT);
        pane.setAlignment(email, Pos.TOP_RIGHT);
        imageAbout = new HBox(90, name, email);
        pane.setCenter(iv1);
        pane.setTop(imageAbout);
        pane.setBottom(version);

        // Creates the scene
        scene = new Scene(pane);

        // Sets the stage to the scene
        stage.setTitle("About Rishi Desai");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
    } // createAboutMe

} // MainMenu
