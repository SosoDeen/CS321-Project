import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Screen extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DocumentRequestForm form = new DocumentRequestForm("Starling Devine", "October 27 2002", "123 tester", 102, 10203, "Book", "Entry");
        displayScreen(form);
        return;
        /**stage.setTitle("Form Document");

        //Group root = new Group();

        // button = new Button();
        // button.setText("Next");
        //StackPane layout = new StackPane();
        //layout.getChildren().add(button);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Scene scene = new Scene(grid, 950, 950);

        Label name = new Label("Name: ");
        TextField textField = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(name,textField);
        hb.setSpacing(10);
        grid.add(hb,1,1); 


        Button submit = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(submit);
        grid.add(hbBtn, 50, 80);
        //scene.add(hb);
        stage.setScene(scene);
        stage.show();
        **/
    }
    public void displayScreen(DocumentRequestForm form){
        Stage stage = new Stage();
        stage.setTitle("Form Document");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 950, 950);
        
        Text formID = new Text("FormID: " + form.getFormID());
        formID.setFont(Font.font(20));
        grid.add(formID, 1, 1);
        Text status = new Text("Status: " + form.getStatus());
        status.setFont(Font.font(20));
        grid.add(status, 1, 2);
        Text name = new Text("Name: " + form.getName());
        name.setFont(Font.font(20));
        grid.add(name, 1, 3);
        Text anum = new Text("Anumber: " + form.getANum());
        anum.setFont(Font.font(20));
        grid.add(anum, 1, 4);
        Text dob = new Text("DOB: " + form.getDob());
        dob.setFont(Font.font(20));
        grid.add(dob, 1, 5);
        Text address = new Text("Address: " + form.getAddress());
        address.setFont(Font.font(20));
        grid.add(address, 1, 6);
        Text docName = new Text("Document: " + form.getDocName());
        docName.setFont(Font.font(20));
        grid.add(docName, 1, 7);

        // Button submit = new Button("Submit");
        // HBox hbBtn = new HBox(10);
        // hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        // hbBtn.getChildren().add(submit);
        // grid.add(hbBtn, 50, 50);
        //scene.add(hb);
        stage.setScene(scene);
        stage.show();
    }
    
}