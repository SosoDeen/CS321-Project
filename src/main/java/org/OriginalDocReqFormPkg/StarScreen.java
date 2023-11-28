package org.OriginalDocReqFormPkg;

import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Represents the visual interface for iterating over reviews from a file
 * @author @author Somaya Zaheereldeen, Starling Devine, William  O'Brian
 */
public class StarScreen extends JFrame implements ActionListener{
    // START SCREEN PARAMS ----------------------------------------------------    
    /** Start screen prompt */
    private JLabel startLabel;
    /** Button for opening Data Entry module */
    private JButton DEModuleButton;
    /** Button for opening Review module */
    private JButton RModuleButton;
    /** Button for opening Approval module  */
    private JButton AModuleButton;
    /** Screen frames */
    private JFrame dataEntry, review, approve;

    /** (OLD) Label to display iteration */
    private JTextArea iterPrint;
    /** (OLD) Allows to scroll in field display */
    private JScrollPane scrollPane;


    // SHARED PARAMS ----------------------------------------------------------
    /** Document Request Form labels */
    private JLabel name;
    private JLabel dob;
    private JLabel address;
    private JLabel formID;
    private JLabel aNum;
    private JLabel docName;
    private JLabel status;
    private JLabel popupMessage;
    private JButton exitButton;


    // DE PARAMS --------------------------------------------------------------

    /** DE instruction label */
    private JLabel DELabel;

    /** Data Entry textfields per DRF label */
    private JTextField nameField;
    private JTextField dobField;
    private JTextField addressField;
    private JTextField aNumField;
    private JTextField docNameField;

    /** Button for submitting form */
    private JButton submitButton;
    /** Button for canceling form */
    private JButton cancelButton;

    /** Data Entry class instance */
    DataEntry dataEntryClass;


    // R PARAMS ---------------------------------------------------------------
    private JLabel ReviewLabel;
    private JLabel welcomeLabel;
    private JTextField typeField;
    private JTextField changeField;
    private JButton editButton;
    private JButton reviewAppButton;
    private JButton cancelRevButton;
    private JButton nextReviewButton;

    private Review currentReview;
    

    // A PARAMS ---------------------------------------------------------------
    /** Button for Approval to approve item */
    private JButton approveButton;
    /** Button for Approval to reject item */
    private JButton rejectButton;
    /** Button to load in next form */
    private JButton nextForm;

    private JLabel welcome;

    private Approver approver;

    // START SCREEN INIT ------------------------------------------------------
    /** Start screen constructor */
    public StarScreen()
    {
        // FRAMES -------------------------------------------------------------
        
        // initializes start frame
        super("Document Request Form");
        setSize(1000,550);

        // defines multiple frames
        dataEntry = new JFrame("Data Entry");
        dataEntry.setSize(1000,550);
        dataEntryClass = new DataEntry();

        review = new JFrame("Review");
        review.setSize(1000,550);
        currentReview = new Review();

        approve = new JFrame("Approve");
        approve.setSize(1000,550);
        approver = new Approver();

        // Module Exit button behaviour
        dataEntry.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        review.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        approve.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridBagConstraints layoutConst = null;
        setLayout(new GridBagLayout());


        // LABELS -------------------------------------------------------------
        
        // start screen label
        startLabel = new JLabel("Choose your appropriate Module");
        name = new JLabel("Name:");
        dob = new JLabel("Date of Birth:");
        address = new JLabel("Address:");
        aNum = new JLabel("A-Number:");
        docName = new JLabel("Requested Document Name:");

        // FIELDS -------------------------------------------------------------
        
        // Editable field
        nameField = new JTextField(20);
        nameField.setEditable(true);
        nameField.setText("");

        // Uneditable field
        iterPrint = new JTextArea(30, 50);
        scrollPane = new JScrollPane(iterPrint); 
        iterPrint.setLineWrap(true);
        iterPrint.setEditable(false);
        

        // BUTTONS ------------------------------------------------------------

        // submit input button
        DEModuleButton = new JButton("Immigrant");
        DEModuleButton.addActionListener(this);
        
        RModuleButton = new JButton("Reviewer");
        RModuleButton.addActionListener(this);

        AModuleButton = new JButton("Approver");
        AModuleButton.addActionListener(this);

        
        // PLACE COMPONENTS ---------------------------------------------------
        // Module select label
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(startLabel, layoutConst);

        // DE button
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        add(DEModuleButton, layoutConst);

        // R button
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        add(RModuleButton, layoutConst);

        // A button
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        add(AModuleButton, layoutConst);

        this.setVisible(true);
    }

    // ACTION LISTENER --------------------------------------------------------

    public void actionPerformed(ActionEvent event) {
        // Finds which button was pressed
        JButton sourceEvent = (JButton) event.getSource();
        
        if(sourceEvent == exitButton){
            startScreenCall();
            if(currentReview.getForm() != null){
                currentReview.addToFlow(Review.MODULEID);
                currentReview = new Review();
            }
            if(approver.getForm() != null){
                approver.rejectAndReturn(Approver.MODULEID);
                approver = new Approver();
            }
        }
        // DATA ENTRY SCREEN AND BUTTON ACTIONS -------------------------------
        else if (sourceEvent == DEModuleButton) {
            dataEntryScreen();
        }
        else if(sourceEvent == submitButton){
            String errormessage = dataEntryClass.createNewForm(nameField.getText(), dobField.getText(), 
                                addressField.getText(), aNumField.getText(), docNameField.getText());

            popupMessage.setVisible(true);
            popupMessage.setText(errormessage);
            
            if (errormessage.equals("Form has been submitted!")) resetDEFields();
        }
        else if(sourceEvent == cancelButton){
            resetDEFields();
            popupMessage.setText("Canceled Successfully!");
        }


        // REVIEW SCREEN AND BUTTON ACTIONS -----------------------------------
        else if(sourceEvent == RModuleButton){
            reviewScreen();

        }
        else if (sourceEvent == editButton){
            currentReview.editData(nameField.getText(), dobField.getText(), addressField.getText(), aNumField.getText(), docNameField.getText());
            popupMessage.setVisible(true);
            popupMessage.setText("Updated!");
        }
        else if(sourceEvent == reviewAppButton){
            currentReview.addToFlow(Approver.MODULEID);

            int taskCount = ProjectManager.getModuleTaskListSize(Review.MODULEID);
            welcomeLabel = new JLabel("Welcome to review! You have "+taskCount+" tasks left!");
            setReviewFormVisibility(false);
        }
        else if(sourceEvent == nextReviewButton){
            String errorMessage = currentReview.setForm();
            if(errorMessage.equals("Success")){
                setReviewFormVisibility(true);
                fillReviewFields(currentReview.getForm());
            }
            System.out.println(errorMessage);
        }

        // APPROVER SCREEN AND BUTTON ACTIONS ---------------------------------
        else if(sourceEvent == AModuleButton){
            approverScreen();
        }
        else if(sourceEvent == approveButton){
            if(approver.getForm() != null){
                int count = ProjectManager.getModuleTaskListSize(Approver.MODULEID);
                welcome.setText("Approved: There are " + count + " form requests left.");
                nameField.setText(" ");
                dobField.setText(" ");
                addressField.setText(" ");
                aNumField.setText(" ");
                docNameField.setText(" ");
                approver.acceptAndEmail("Email");
                approver.getForm().setStatus("Approved");
                approver = new Approver();
                nextForm.setVisible(true);
                approveButton.setVisible(false);
                rejectButton.setVisible(false);
            }
            else{
                welcome.setText("There is currently no form up for approval");
            }

        }
        else if(sourceEvent == rejectButton){
            if(approver.getForm() != null){
                int count = ProjectManager.getModuleTaskListSize(Approver.MODULEID);
                welcome = new JLabel("Rejected: There are " + count + " form requests left.");
                nameField.setText(" ");
                dobField.setText(" ");
                addressField.setText(" ");
                aNumField.setText(" ");
                docNameField.setText(" ");
                approver.getForm().setStatus("Review");
                approver.rejectAndReturn(Review.MODULEID);
                approver = new Approver();
                nextForm.setVisible(true);
                approveButton.setVisible(false);
                rejectButton.setVisible(false);
            }
            else{
                welcome.setText("There is currently no form up for rejection");
            }
        }
        else if(sourceEvent == nextForm){
            String errorMessage = approver.nextForm();
            if(errorMessage.equals("Loading next form.")){ 
                nameField.setText(approver.getForm().getName());
                dobField.setText(approver.getForm().getDob());
                addressField.setText(approver.getForm().getAddress());
                aNumField.setText(approver.getForm().getANum()+"");
                docNameField.setText(approver.getForm().getDocName());
                welcome.setText("Next form loaded.");
                nextForm.setVisible(false);
                approveButton.setVisible(true);
                rejectButton.setVisible(true);
            }
            else{
                welcome.setText("There is currently no form to load.");
            }
        }
    }

    // SCREEN DEFINITIONS -----------------------------------------------------

    public void startScreenCall(){
        // show start screens
        setVisible(true);

        // clear other screens
        dataEntry.getContentPane().removeAll();
        dataEntry.repaint();
        review.getContentPane().removeAll();
        review.repaint();
        approve.getContentPane().removeAll();
        approve.repaint();
        // hide other screens
        dataEntry.setVisible(false);
        review.setVisible(false);
        approve.setVisible(false);
    }

    public void dataEntryScreen(){
        GridBagConstraints layoutConst = null;
        dataEntry.setLayout(new GridBagLayout());

        // DE labels
        DELabel = new JLabel("Please fill in all the fields");
        popupMessage = new JLabel("I'm a popup message");
        popupMessage.setVisible(false);
        name.setVisible(true);
        dob.setVisible(true);
        address.setVisible(true);
        aNum.setVisible(true);
        docName.setVisible(true);

        // DE fields
        nameField = new JTextField(50);
        nameField.setEditable(true);
        nameField.setText("");

        dobField = new JTextField(50);
        dobField.setEditable(true);
        dobField.setText("");

        addressField = new JTextField(50);
        addressField.setEditable(true);
        addressField.setText("");

        aNumField = new JTextField(50);
        aNumField.setEditable(true);
        aNumField.setText("");

        docNameField = new JTextField(50);
        docNameField.setEditable(true);
        docNameField.setText("");

        
        // DE buttons
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);

        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);


        // Place components

        // labels
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        dataEntry.add(DELabel, layoutConst);

        layoutConst.gridy = 6;
        dataEntry.add(popupMessage, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        dataEntry.add(name, layoutConst);
        
        layoutConst.gridy = 2;
        dataEntry.add(dob, layoutConst);

        layoutConst.gridy = 3;
        dataEntry.add(address, layoutConst);

        layoutConst.gridy = 4;
        dataEntry.add(aNum, layoutConst);

        layoutConst.gridy = 5;
        dataEntry.add(docName, layoutConst);

        // Fields
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        dataEntry.add(nameField, layoutConst);
        
        layoutConst.gridy = 2;
        dataEntry.add(dobField, layoutConst);

        layoutConst.gridy = 3;
        dataEntry.add(addressField, layoutConst);

        layoutConst.gridy = 4;
        dataEntry.add(aNumField, layoutConst);

        layoutConst.gridy = 5;
        dataEntry.add(docNameField, layoutConst);

        // Buttons
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        dataEntry.add(submitButton, layoutConst);

        layoutConst.gridx = 2;
        dataEntry.add(cancelButton, layoutConst);

        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        dataEntry.add(exitButton, layoutConst);
        

        dataEntry.setVisible(true);
        setVisible(false);
    }

    public void approverScreen(){
        setVisible(false);
        GridBagConstraints layoutConst = null;
        approve.setLayout(new GridBagLayout());

        startLabel = new JLabel("Approval Step");

        approveButton = new JButton("Approve Form");
        approveButton.addActionListener(this);

        rejectButton = new JButton("Reject Form");
        rejectButton.addActionListener(this);

        nextForm = new JButton("Load Next Form");
        nextForm.addActionListener(this);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        approve.add(nextForm, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        approve.add(approveButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        approve.add(rejectButton, layoutConst);

        layoutConst.gridx = 3;
        approve.add(exitButton, layoutConst);

        welcome = new JLabel("");
        name = new JLabel("Name: ");
        dob = new JLabel("Date of Birth: ");
        address = new JLabel("Address: ");
        aNum = new JLabel("ANum: ");
        docName = new JLabel("Document: ");

        nameField = new JTextField(50);
        nameField.setEditable(false);
        dobField = new JTextField(50);
        dobField.setEditable(false);
        addressField = new JTextField(50);
        addressField.setEditable(false);
        aNumField = new JTextField(50);
        aNumField.setEditable(false);
        docNameField = new JTextField(50);
        docNameField.setEditable(false);

        layoutConst.gridx = 0;
        layoutConst.gridy = 7;
        approve.add(welcome, layoutConst);

        layoutConst.gridy = 2;
        approve.add(name, layoutConst);
        layoutConst.gridx = 1;
        approve.add(nameField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        approve.add(dob, layoutConst);
        layoutConst.gridx = 1;
        approve.add(dobField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        approve.add(address, layoutConst);
        layoutConst.gridx = 1;
        approve.add(addressField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        approve.add(aNum, layoutConst);
        layoutConst.gridx = 1;
        approve.add(aNumField, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        approve.add(docName, layoutConst);
        layoutConst.gridx = 1;
        approve.add(docNameField, layoutConst);

        approveButton.setVisible(false);
        rejectButton.setVisible(false);

        approve.setVisible(true);
    }
    
    public void reviewScreen(){

        GridBagConstraints layoutConst =  new GridBagConstraints();
        review.setLayout(new GridBagLayout());

        popupMessage = new JLabel("I'm a popup message");
        popupMessage.setVisible(false);

        int taskCount = ProjectManager.getModuleTaskListSize(Review.MODULEID);
        welcomeLabel = new JLabel("Welcome to review! You have "+taskCount+" tasks left!");
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        review.add(welcomeLabel, layoutConst);
        if(ProjectManager.getTasklistSize() == 0){
            welcomeLabel.setText("There are no forms left to review!");
        }

        ReviewLabel = new JLabel("Apply Correction to the given data if needed then hit update");

        // R fields
        nameField = new JTextField(50);
        nameField.setEditable(true);
        nameField.setText("");

        dobField = new JTextField(50);
        dobField.setEditable(true);
        dobField.setText("");

        addressField = new JTextField(50);
        addressField.setEditable(true);
        addressField.setText("");

        aNumField = new JTextField(50);
        aNumField.setEditable(true);
        aNumField.setText("");

        docNameField = new JTextField(50);
        docNameField.setEditable(true);
        docNameField.setText("");

        // DONT SHOW ON START
        // labels
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        ReviewLabel.setVisible(false);
        review.add(ReviewLabel, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        name.setVisible(false);
        review.add(name, layoutConst);
        
        layoutConst.gridy = 2;
        dob.setVisible(false);
        review.add(dob, layoutConst);

        layoutConst.gridy = 3;
        address.setVisible(false);
        review.add(address, layoutConst);

        layoutConst.gridy = 4;
        aNum.setVisible(false);
        review.add(aNum, layoutConst);

        layoutConst.gridy = 5;
        docName.setVisible(false);
        review.add(docName, layoutConst);

        // Fields
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        nameField.setVisible(false);
        review.add(nameField, layoutConst);
        
        layoutConst.gridy = 2;
        dobField.setVisible(false);
        review.add(dobField, layoutConst);

        layoutConst.gridy = 3;
        addressField.setVisible(false);
        review.add(addressField, layoutConst);

        layoutConst.gridy = 4;
        aNumField.setVisible(false);
        review.add(aNumField, layoutConst);

        layoutConst.gridy = 5;
        docNameField.setVisible(false);
        review.add(docNameField, layoutConst);

        // BUTTONS
        editButton = new JButton("Update");
        editButton.addActionListener(this);
        layoutConst.gridx = 2;
        layoutConst.gridy = 8;
        editButton.setVisible(false);
        review.add(editButton, layoutConst);

        reviewAppButton = new JButton("Submit");
        reviewAppButton.addActionListener(this);
        layoutConst.gridx = 1;
        layoutConst.gridy = 8;
        reviewAppButton.setVisible(false);
        review.add(reviewAppButton, layoutConst);
        
        // FIX: rename cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        layoutConst.gridx = 2;
        layoutConst.gridy = 8;
        cancelButton.setVisible(false);
        review.add(cancelButton, layoutConst);
       

        // SHOW ON START
        exitButton = new JButton("EXIT");
        exitButton.addActionListener(this);
        nextReviewButton = new JButton("Get Next");
        nextReviewButton.addActionListener(this);

        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        review.add(exitButton, layoutConst);
        layoutConst.gridx = 3;
        layoutConst.gridy = 0;
        review.add(nextReviewButton, layoutConst);
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        review.add(popupMessage, layoutConst);

        review.setVisible(true);
        setVisible(false);
    }
    
    // HELPER METHODS ---------------------------------------------------------

    public void ShowScreen(String screenName){
        setVisible(false);
        dataEntry.setVisible(false);
        review.setVisible(false);
        approve.setVisible(false);

        if (screenName.equals("Start")){
            setVisible(true);
        }
        else if (screenName.equals("DataEntry")){
            dataEntry.setVisible(true);
        }
        else if (screenName.equals("Review")){
            review.setVisible(true);
        }
        else if (screenName.equals("Approve")){
            approve.setVisible(true);
        }
    }

    public void fillReviewFields(DocumentRequestForm form){
        // fill review fields with form data
        nameField.setText(form.getName());
        dobField.setText(form.getDob());
        addressField.setText(form.getAddress());
        aNumField.setText(form.getANum() + "");
        docNameField.setText(form.getDocName());
    }

    public void setReviewFormVisibility(boolean state){
        welcomeLabel.setVisible(!state);
        // labels
        popupMessage.setVisible(false);
        ReviewLabel.setVisible(state);
        name.setVisible(state);
        dob.setVisible(state);
        address.setVisible(state);
        aNum.setVisible(state);
        docName.setVisible(state);

        // Fields
        nameField.setVisible(state);
        dobField.setVisible(state);
        addressField.setVisible(state);
        aNumField.setVisible(state);
        docNameField.setVisible(state);

        // BUTTONS
        editButton.setVisible(state);
        reviewAppButton.setVisible(state);
        // FIX: rename cancel button
        cancelButton.setVisible(state);
        nextReviewButton.setVisible(!state);
    }

    public void resetDEFields(){
        nameField.setText("");
        dobField.setText("");
        addressField.setText("");
        aNumField.setText("");
        docNameField.setText("");
    }

    public static void main(String[] args){
        StarScreen skweenn = new StarScreen();
        
    }
}