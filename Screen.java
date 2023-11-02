import javafx.application.Application;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Screen extends Application{
    Button button;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Form Document");
        Group root = new Group();
        // button = new Button();
        // button.setText("Next");
        //StackPane layout = new StackPane();
        //layout.getChildren().add(button);

        Scene scene = new Scene(root, 950, 950);

        Text text = new Text();
        text.setText("Name: ");
        text.setX(20);
        text.setY(20);

        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
    }
    
}