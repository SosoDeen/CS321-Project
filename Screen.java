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
    /** Description of file */
    private JLabel label;
    /** Prompts player to imput a file */
    private JLabel file;
    /** stores file name to iterate over */
    private JTextField filename;
    /** button to submit the file */
    private JButton submitFile;
    /** Button for no skipping iteration */
    private JButton iterF_F;
    /** Button for skip sus reviews keep words iteration */
    private JButton iterF_T;
    /** Button for keep reviews skip sus words iteration */
    private JButton iterT_F;
    /** Button for skip sus reviews and words iteration */
    private JButton iterT_T;
    /** Label to display iteration */
    private JTextArea iterPrint;
    /** Allows to scroll in iteration display */
    private JScrollPane scrollPane;
    private JFrame dataEntry, review, approve;
    

    /** Constructor */
    public Screen()
    {
        // sets up frame basics
        super("Document Request Form");

        //TO DO add multiple frames
        dataEntry = new JFrame("Data Entry");
        dataEntry.setSize(780,790);
       /// dataEntry.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        
        

        review = new JFrame("Data Entry");
        review.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //review.setVisible(true);

        approve = new JFrame("Data Entry");
        approve.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //approve.setVisible(true);
        
        
        GridBagConstraints layoutConst = null;
        //setLayout(new FlowLayout());
        setLayout(new GridBagLayout());

        // Creates fields
        // program description
        label = new JLabel("Choose your appropriate Module");
        
        // file input promt field
        file = new JLabel("\nEnter File name:");
        
        // input field
        filename = new JTextField(20);
        filename.setEditable(true);
        filename.setText("");

        // submit input button
        submitFile = new JButton("Submit File");
        submitFile.addActionListener(this);

        // iter option buttons
        iterF_F = new JButton("Review: False Words: False");
        iterF_F.addActionListener(this);
        iterF_T = new JButton("Review: False Words: True");
        iterF_T.addActionListener(this);
        iterT_F = new JButton("Review: True Words: False");
        iterT_F.addActionListener(this);
        iterT_T = new JButton("Review: True Words: True");
        iterT_T.addActionListener(this);

        // iteration print field
        iterPrint = new JTextArea(30, 50);
        scrollPane = new JScrollPane(iterPrint); 
        iterPrint.setLineWrap(true);
        iterPrint.setEditable(false);

        
        // Place compnents in grids
        // program desc
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(label, layoutConst);

        // input prompt
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(file, layoutConst);

        // filename input
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        add(filename, layoutConst);

        // submitfile button
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        add(submitFile, layoutConst);

        // Iterator: false, false
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        //add(iterF_F, layoutConst);

        // Iterator: true, false
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        add(iterT_F, layoutConst);

        // Iterator: false, true
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        add(iterF_T, layoutConst);

        // Iterator: true, true
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        add(iterT_T, layoutConst);

        // iteration output
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridwidth = 3;
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        add(iterPrint, layoutConst);

        this.setVisible(false);
        DataEntryScreen();

        // add components
        /*
        add(label);
        add(file,1);
        add(filename);
        add(submitFile);
        add(iterF_F);
        add(iterF_T);
        add(iterT_F);
        add(iterT_T);
        */


        // do iterations for each button

    }

    public void DataEntryScreen(){
        // SHOULD hide start menu
        

        GridBagConstraints layoutConst = null;
        //setLayout(new FlowLayout());
        dataEntry.setLayout(new GridBagLayout());

        // Creates fields
        // program description
        label = new JLabel("Choose your appropriate Module");
        
        // file input promt field
        file = new JLabel("\nEnter File name:");
        
        // input field
        filename = new JTextField(20);
        filename.setEditable(true);
        filename.setText("");

        // submit input button
        submitFile = new JButton("Submit File");
        submitFile.addActionListener(this);

        // iter option buttons
        iterF_F = new JButton("Review: False Words: False");
        iterF_F.addActionListener(this);
        iterF_T = new JButton("Review: False Words: True");
        iterF_T.addActionListener(this);
        iterT_F = new JButton("Review: True Words: False");
        iterT_F.addActionListener(this);
        iterT_T = new JButton("Review: True Words: True");
        iterT_T.addActionListener(this);

        // iteration print field
        iterPrint = new JTextArea(30, 50);
        scrollPane = new JScrollPane(iterPrint); 
        iterPrint.setLineWrap(true);
        iterPrint.setEditable(false);

        
        // Place compnents in grids
        // program desc
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        dataEntry.add(label, layoutConst);

        // input prompt
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        dataEntry.add(file, layoutConst);

        // filename input
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        dataEntry.add(filename, layoutConst);

        // submitfile button
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        dataEntry.add(submitFile, layoutConst);

        // Iterator: false, false
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        dataEntry.add(iterF_F, layoutConst);

        // Iterator: true, false
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        dataEntry.add(iterT_F, layoutConst);

        // Iterator: false, true
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        dataEntry.add(iterF_T, layoutConst);

        // Iterator: true, true
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        dataEntry.add(iterT_T, layoutConst);

        // iteration output
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridwidth = 3;
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        dataEntry.add(iterPrint, layoutConst);

        dataEntry.setVisible(true);
    }

    /**
     * Function to implement ActionListener
     * @param event when the user hits enter
     */
    public void actionPerformed(ActionEvent event) {
        String userInput;      // User file name
        JButton sourceEvent = (JButton) event.getSource(); // finds which button was pressed
        if (sourceEvent == submitFile) {
        // Get user's filename input
        userInput = filename.getText();
    
        // Display filename
        //filename.setText(userInput);
        iterPrint.setText("You pressed\nbutton submit");
        }
        else if (sourceEvent == iterF_F){
            iterPrint.setText("You pressed\nbutton F_F");
            dataEntry.setVisible(false);
            setVisible(true);
            /* 
            try {
            // opens file to be iterated
            String name = filename.getText();
            File filef = new File(name);

            //PROVIDED FROM PDF
            ReviewList list = new ReviewList(filef);
            String text = "";

            // prints all reviews and all their words without skipping anything
            for (Review r : list){
                for (String s : r)
                    text+= s+ " ";
                text+= "\n";
            }
            iterPrint.setText(text);

            
            } catch(Exception e){System.out.println();e.printStackTrace();}
            */
        }
        else if (sourceEvent == iterF_T){
            iterPrint.setText("You pressed\nbutton F_T");
            /*
            try {
                // opens file to be iterated
                String name = filename.getText();
                File filef = new File(name);

                //PROVIDED FROM PDF
                ReviewList list = new ReviewList(filef);
                String text = "";

                // prints all reviews and all their words without skipping anything
                Iterator<Review> it1 = list.iterator();
                while(it1.hasNext())
                {
                    Review r = it1.next();
                    Iterator<String> it2 = r.iterator(true);
                    
                    while(it2.hasNext())
                        text+=it2.next() + " ";
                    text+= "\n";
                }
                iterPrint.setText(text);

                
                } catch(Exception e){System.out.println();e.printStackTrace();}
            */
        }
        else if (sourceEvent == iterT_F){
            iterPrint.setText("You pressed\nbutton T_F");
            /*
            try {
                // opens file to be iterated
                String name = filename.getText();
                File filef = new File(name);

                //PROVIDED FROM PDF
                ReviewList list = new ReviewList(filef);
                String text = "";

                // skips the suspicious reviews and prints all the words in the non-suspicious reviews
                Iterator<Review> it = list.iterator(true);
                while(it.hasNext())
                {
                    Review r = it.next();
                    for (String s : r)
                        text+=s+ " ";
                    text+= "\n";
                }
                iterPrint.setText(text);

                
            } catch(Exception e){System.out.println();e.printStackTrace();}
            */
        }
        else if (sourceEvent == iterT_T){
            iterPrint.setText("You pressed\nbutton T_T");
            /*
            try {
                // opens file to be iterated
                String name = filename.getText();
                File filef = new File(name);

                //PROVIDED FROM PDF
                ReviewList list = new ReviewList(filef);
                String text = "";

                // skips the suspicious reviews and the suspicious words in the non-suspicious reviews
                Iterator<Review> it1 = list.iterator(true);
                while(it1.hasNext())
                {
                    Review r = it1.next();
                    Iterator<String> it2 = r.iterator(true);
                    
                    while(it2.hasNext())
                        text+=it2.next() + " ";
                    text+= "\n";
                }
                iterPrint.setText(text);

                
            } catch(Exception e){System.out.println();e.printStackTrace();}
            */
        }
    }
    

    /**
     * 
     * @param args command line arguments
     */
    public static void main(String[] args){
        Screen bucky = new Screen();
        bucky.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bucky.setSize(800,800);
        //bucky.setVisible(true);

    //     Screen dataEntry = new Screen("DE");
    //     dataEntry.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    //     Screen review = new Screen("R");
    //     review.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    //     Screen approve = new Screen("A");
    //     approve.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}