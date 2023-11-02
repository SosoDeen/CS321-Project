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
    private Stage stage;
    private GridPane grid;
    private Scene scene;
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        DocumentRequestForm form = new DocumentRequestForm("Starling Devine", "October 27 2002", "123 tester", 102, 10203, "Book", "Entry");
        
        //displayScreen(form);
        //displayScreenForDataEntry();
        //displayScreenForReview(form);
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
        stage = new Stage();
        stage.setTitle("Form Document");
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scene = new Scene(grid, 950, 950);
       
        Text formID = new Text("FormID: " + form.getFormID());
        formID.setFont(Font.font(20));
        grid.add(formID, 0, 1);
        Text status = new Text("Status: " + form.getStatus());
        status.setFont(Font.font(20));
        grid.add(status, 0, 2);
        Text name = new Text("Name: " + form.getName());
        name.setFont(Font.font(20));
        grid.add(name, 0, 3);
        Text anum = new Text("Anumber: " + form.getANum());
        anum.setFont(Font.font(20));
        grid.add(anum, 0, 4);
        Text dob = new Text("DOB: " + form.getDob());
        dob.setFont(Font.font(20));
        grid.add(dob, 0, 5);
        Text address = new Text("Address: " + form.getAddress());
        address.setFont(Font.font(20));
        grid.add(address, 0, 6);
        Text docName = new Text("Document: " + form.getDocName());
        docName.setFont(Font.font(20));
        grid.add(docName, 0, 7);

        // Button submit = new Button("Submit");
        // HBox hbBtn = new HBox(10);
        // hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        // hbBtn.getChildren().add(submit);
        // grid.add(hbBtn, 50, 50);
        //scene.add(hb);
        stage.setScene(scene);
        stage.show();
    }
    public String[] displayScreenForDataEntry(){
        stage = new Stage();
        stage.setTitle("Form Document");
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        scene = new Scene(grid, 950, 950);
        String[] newInfo = new String[2];
        Label nameLabel = new Label("Name: ");
        grid.add(nameLabel, 0, 1);
        
        TextField nameField = new TextField();
        grid.add(nameField, 1, 1);
        
        Label aNumLabel = new Label("ANumber: ");
        grid.add(aNumLabel, 0, 3);
        
        TextField aNumField = new TextField();
        grid.add(aNumField, 1, 3);

        Label DOBLabel = new Label("DOB: ");
        grid.add(DOBLabel, 0, 5);
        
        TextField DOBField = new TextField();
        grid.add(DOBField, 1, 5);
        
        Label addressLabel = new Label("Address: ");
        grid.add(addressLabel, 0, 7);
        
        TextField addressField = new TextField();
        grid.add(addressField, 1, 7);

        Label docTypeLabel = new Label("Document: ");
        grid.add(docTypeLabel, 0, 9);
        
        TextField docTypeField = new TextField();
        grid.add(docTypeField, 1, 9);
        
        
        Button update = new Button("Submit");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(update);
        grid.add(hbBtn, 0, 11);

        Button approve = new Button("Cancel");
        HBox hbApp = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(approve);
        grid.add(hbApp, 1, 11);
        
        
        stage.setScene(scene);
        stage.show();

        return newInfo;
    }
    public String[] displayScreenForReview(DocumentRequestForm form){
        String[] newInfo = new String[2];

        displayScreen(form);
        Label change = new Label("Category: ");
        grid.add(change, 0, 30);
        
        TextField changeField = new TextField();
        grid.add(changeField, 1, 30);
        
        Label infoLabel = new Label("Correction: ");
        grid.add(infoLabel, 0, 31);
        
        TextField infoField = new TextField();
        grid.add(infoField, 1, 31);
        
        
        Button update = new Button("Update");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(update);
        grid.add(hbBtn, 0, 32);

        Button approve = new Button("Approve");
        HBox hbApp = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(approve);
        grid.add(hbApp, 1, 32);

        return newInfo;

    }

    public String displayScreenForApproval(DocumentRequestForm form){
        displayScreen(form);

        Button approve = new Button("Approve");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(approve);
        grid.add(hbBtn, 0, 32);

        Button reject = new Button("Reject");
        HBox hbApp = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(reject);
        grid.add(hbApp, 1, 32);

        return null;
    }
    
}