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
 * @author Somaya Zaheereldeen
 */
public class Screen extends JFrame implements ActionListener{
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
    private JButton exitButton;


    // DE PARAMS --------------------------------------------------------------
    /** Reference to Data Entry module */
    private DataEntry dataEntryClass;

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


    // R PARAMS ---------------------------------------------------------------



    // A PARAMS ---------------------------------------------------------------
    /** Button for Approval to approve item */
    private JButton approveButton;
    /** Button for Approval to reject item */
    private JButton rejectButton;
    /** Button to load in next form */
    private JButton nextForm;


    /** Start screen constructor */
    public Screen()
    {
        // FRAMES -------------------------------------------------------------
        
        // initializes start frame
        super("Document Request Form");
        setSize(780,790);

        // defines multiple frames
        dataEntry = new JFrame("Data Entry");
        dataEntry.setSize(780,790);
        
        //dataEntry.setVisible(true);

        review = new JFrame("Data Entry");
        review.setSize(780,790);
        //review.setVisible(true);

        approve = new JFrame("Data Entry");
        approve.setSize(780,790);
        //approve.setVisible(true);

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

    /**
     * Function to implement ActionListener
     * @param event when the user hits a button
     */
    public void actionPerformed(ActionEvent event) {
        // finds which button was pressed
        JButton sourceEvent = (JButton) event.getSource(); 
        
        if(sourceEvent == exitButton){
            StartScreenCall();
        }
        // DATA ENTRY SCREEN AND BUTTON ACTIONS -------------------------------
        else if (sourceEvent == DEModuleButton) {
            DataEntryScreen();
        }
        else if(sourceEvent == submitButton){
            docNameField.setText("Submitted!");
        }
        else if(sourceEvent == cancelButton){
            docNameField.setText("Canceled!");
        }


        // REVIEW SCREEN AND BUTTON ACTIONS -----------------------------------
        else if(sourceEvent == RModuleButton){

        }


        // APPROVER SCREEN AND BUTTON ACTIONS ---------------------------------
        else if(sourceEvent == AModuleButton){
            approverScreen();
        }
        else if(sourceEvent == approveButton){

        }
        else if(sourceEvent == rejectButton){

        }
        else if(sourceEvent == nextForm){
            
        }
    }

    // SCREEN DEFINITIONS -----------------------------------------------------

    public void StartScreenCall(){
        setVisible(true);
        dataEntry.setVisible(false);
        review.setVisible(false);
        approve.setVisible(false);
    }

    public void DataEntryScreen(){
        setVisible(false);

        GridBagConstraints layoutConst = null;
        dataEntry.setLayout(new GridBagLayout());

        // DE labels
        DELabel = new JLabel("Please fill in all the fields");
        name = new JLabel("Name:");
        dob = new JLabel("Date of Birth:");
        address = new JLabel("Address:");
        aNum = new JLabel("A-Number:");
        docName = new JLabel("Requested Document Name:");


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


        // Place components

        // labels
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        dataEntry.add(DELabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        dataEntry.add(name, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        dataEntry.add(dob, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        dataEntry.add(address, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        dataEntry.add(aNum, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        dataEntry.add(docNameField, layoutConst);

        // Fields
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        dataEntry.add(nameField, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        dataEntry.add(dobField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        dataEntry.add(addressField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        dataEntry.add(aNumField, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        dataEntry.add(docNameField, layoutConst);

        // Buttons
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 6;
        dataEntry.add(submitButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 6;
        dataEntry.add(cancelButton, layoutConst);

        dataEntry.setVisible(true);
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

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        approve.add(nextForm, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        approve.add(approveButton, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        approve.add(rejectButton, layoutConst);

        approve.setVisible(true);
    }
    

    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args){
        Screen skweenn = new Screen();
    }
}