import javax.swing.JFrame;
import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.MenuElement;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrackerGUI{
    private LifestyleTracker Jimson;
    private JFrame frame;
    private JTextField input;
    private JTextField input2;
    private JTextField indexInput;
    private JLabel label;
    private JLabel text;
    private JLabel value;
    private JLabel label2;
    private JLabel indexLabel;
    private JButton Food;
    private JButton Activity;
    private JButton Report;
    private JButton AddF;
    private JButton EatF;
    private JButton ViewF;
    private JButton AddA;
    private JButton PerformA;
    private JButton ViewA;
    private JButton Edit;
    private JButton Delete;
    private JButton indexButton;
    private JButton Yes;
    private JButton No;
    private JTextArea ta;
    private JTextArea verifier;
    private int width;
    private int height;
    private boolean foodAct;
    private int indexVal;
    private java.lang.String nameFA;
    private double servhour;
    private Font titleF;
    private Font buttonF;
    private JLabel trans;
    private Font label2F;
    private JTextArea big;
    private Font bigF;

    //This constructor initializes the TrackerGUI object.
    public TrackerGUI(int w, int h){
        titleF = new Font("Arial",Font.BOLD,29);
        buttonF = new Font("Arial",Font.PLAIN,16);
        label2F = new Font("Arial",Font.PLAIN,14);
        trans = new JLabel("                               ");
        Jimson = new LifestyleTracker();
        frame = new JFrame();
        label = new JLabel(" Lifestyle Tracker       ");
        label2 = new JLabel("");
        text = new JLabel("Text");
        value = new JLabel("Value");
        input = new JTextField(18);
        input2 = new JTextField(17);
        Food = new JButton("FOOD");
        Activity = new JButton("ACTIVITY");
        Report = new JButton("REPORT");
        AddF = new JButton("Add Food");
        EatF = new JButton("Eat Food");
        verifier = new JTextArea();
        ViewF = new JButton("View Food");
        AddA = new JButton("Add Activity");
        PerformA = new JButton("Do Activity");
        ViewA = new JButton("View Activity");
        Edit = new JButton("-      Edit     -");
        Delete = new JButton("-      Delete      -");
        indexInput = new JTextField(10);
        indexLabel = new JLabel("Index:");
        indexButton  = new JButton("Enter");
        Yes = new JButton("Yes");
        No = new JButton("No");
        foodAct = false;
        indexVal = 0;
        nameFA = "";
        servhour = 0;
        ta = new JTextArea();
        width = w;
        height = h;
        big = new JTextArea("\nLife\nstyle\nTracker");
        bigF = new Font("Arial",Font.BOLD,90);
    }

    //This creates the main frame and adds the GUI elements on it.
    public void setUpGUI(){
        Container cp = frame.getContentPane();
        FlowLayout flow = new FlowLayout();
        cp.setLayout(flow);
        frame.setSize(width,height);
        frame.setTitle("Lifestyle Tracker");
        cp.setBackground(Color.WHITE);
        cp.add(trans);
        cp.add(label);
        cp.add(text);
        cp.add(input);
        cp.add(value);
        cp.add(input2);
        cp.add(Food);
        cp.add(Activity);
        cp.add(Report);
        cp.add(big);
        cp.add(AddF);
        cp.add(EatF);
        cp.add(ViewF);
        cp.add(AddA);
        cp.add(PerformA);
        cp.add(ViewA);
        cp.add(label2);
        cp.add(ta);
        cp.add(verifier);
        cp.add(Edit);
        cp.add(Delete);
        cp.add(indexLabel);
        cp.add(indexInput);
        cp.add(indexButton);
        cp.add(Yes);
        cp.add(No);
        Food.setSize(10,10);
        label.setFont(titleF);
        label.setForeground(Color.DARK_GRAY);
        label2.setFont(label2F);
        ta.setFont(label2F);
        ta.setOpaque(false);
        ta.setEditable(false);
        trans.setFont(titleF);
        input.setFont(buttonF);
        input2.setFont(buttonF);
        text.setFont(buttonF);
        value.setFont(buttonF);
        trans.setForeground(Color.WHITE);
        AddF.setVisible(false);
        EatF.setVisible(false);
        ViewF.setVisible(false);
        AddA.setVisible(false);
        PerformA.setVisible(false);
        ViewA.setVisible(false);
        Edit.setVisible(false);
        Delete.setVisible(false);
        indexLabel.setVisible(false);
        indexInput.setVisible(false);
        indexButton.setVisible(false);
        Yes.setVisible(false);
        No.setVisible(false);
        verifier.setVisible(false);
        verifier.setEditable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        big.setFont(bigF);
        big.setForeground(Color.DARK_GRAY);
        big.setEditable(true);

        label.setVisible(false);
        text.setVisible(false);
        input.setVisible(false);
        value.setVisible(false);
        input2.setVisible(false);

        
    }

    // This method sets up the Button Listeners.
    public void setUpButtonListeners() {
        ActionListener buttonListenerHide = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object o = ae.getSource();
                if (o == Food) {
                    label.setVisible(true);
                    text.setVisible(true);
                    input.setVisible(true);
                    value.setVisible(true);
                    input2.setVisible(true);
                    big.setVisible(false);
                    foodAct = true;
                    if (AddF.isVisible() == false){
                        AddF.setVisible(true);
                        EatF.setVisible(true);
                        ViewF.setVisible(true);
                        AddA.setVisible(false);
                        PerformA.setVisible(false);
                        ViewA.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                        verifier.setVisible(false);
                        ta.setText("");
                    } else {
                        AddF.setVisible(false);
                        EatF.setVisible(false);
                        ViewF.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                        verifier.setVisible(false);
                        ta.setText("");
                    }
                    
                } else if (o == Activity) {
                    foodAct = false;
                    label.setVisible(true);
                    text.setVisible(true);
                    input.setVisible(true);
                    value.setVisible(true);
                    input2.setVisible(true);
                    big.setVisible(false);
                    if (AddA.isVisible() == false){
                        AddA.setVisible(true);
                        PerformA.setVisible(true);
                        ViewA.setVisible(true);
                        AddF.setVisible(false);
                        EatF.setVisible(false);
                        ViewF.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                        verifier.setVisible(false);
                        ta.setText("");
                    } else {
                        AddA.setVisible(false);
                        PerformA.setVisible(false);
                        ViewA.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                        verifier.setVisible(false);
                        ta.setText("");
                    }
                } else if (o == Report){
                    label.setVisible(true);
                    text.setVisible(true);
                    input.setVisible(true);
                    value.setVisible(true);
                    input2.setVisible(true);
                    big.setVisible(false);
                    if (ta.getText() != Jimson.report()){
                        AddF.setVisible(false);
                        EatF.setVisible(false);
                        ViewF.setVisible(false);
                        AddA.setVisible(false);
                        PerformA.setVisible(false);
                        ViewA.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                        ta.setVisible(true);
                        verifier.setVisible(false);
                        ta.setText(Jimson.report());
                        label2.setText("");
                    } else {
                        ta.setVisible(false);
                    }
                    
                }
            }
        };

        ActionListener buttonListenerFood = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object a = ae.getSource();
                if (a == AddF){
                    java.lang.String name = input.getText();
                    double calories = Double.parseDouble(input2.getText());
                    label2.setText(Jimson.addFood(name,calories));
                    input.setText("");
                    input2.setText("");
                } else if (a == EatF){
                    nameFA = input.getText();
                    servhour = Double.parseDouble(input2.getText());
                    input.setText("");
                    input2.setText("");
                    java.lang.String output = Jimson.eat(nameFA,servhour);
                    if (output.equals("Option")){
                        java.lang.String question = "";
                        question += String.format("Do you want to add %s\nto the list of foods? If yes,   \ninput the calorie value and click Yes.   ",nameFA);
                        verifier.setVisible(true);
                        verifier.setText(question);
                        Yes.setVisible(true);
                        No.setVisible(true);

                    } else {
                        label2.setText(output);
                    }
                    

                } else if (a == ViewF){
                    if (Edit.isVisible() == false){
                        ta.setVisible(true);
                        ta.setText(Jimson.foodView());
                        label2.setText("");
                        input.setText("");
                        input2.setText("");
                        Edit.setVisible(true);
                        Delete.setVisible(true);
                        foodAct = true;
                        indexLabel.setVisible(true);
                        indexInput.setVisible(true);
                        indexButton.setVisible(true);
                        verifier.setVisible(false);
                    } else {
                        ta.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                        verifier.setVisible(false);
                    }
                    
                }
            }
        };

        ActionListener buttonListenerAct = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object t = ae.getSource();
                if (t == AddA){
                    java.lang.String name = input.getText();
                    double calories = Double.parseDouble(input2.getText());
                    label2.setText(Jimson.addActivity(name,calories));
                    input.setText("");
                    input2.setText("");
                    verifier.setVisible(false);
                } else if (t == PerformA){
                    nameFA = input.getText();
                    servhour = Double.parseDouble(input2.getText());
                    input.setText("");
                    input2.setText("");
                    java.lang.String output = Jimson.perform(nameFA,servhour);
                    if (output.equals("Option")){
                        java.lang.String question = "";
                        question += String.format("Do you want to add %s\nto the list of activities? If yes,   \ninput the calorie value and click Yes.   ",nameFA);
                        verifier.setVisible(true);
                        verifier.setText(question);
                        Yes.setVisible(true);
                        No.setVisible(true);

                    } else {
                        label2.setText(output);
                    }

                } else if (t == ViewA){
                    if (Edit.isVisible() == false){
                        ta.setVisible(true);
                        ta.setText(Jimson.activityView());
                        label2.setText("");
                        input.setText("");
                        input2.setText("");
                        Edit.setVisible(true);
                        Delete.setVisible(true);
                        indexLabel.setVisible(true);
                        indexInput.setVisible(true);
                        indexButton.setVisible(true);
                        verifier.setVisible(false);
                    } else {
                        ta.setVisible(false);
                        Edit.setVisible(false);
                        Delete.setVisible(false);
                        indexLabel.setVisible(false);
                        indexInput.setVisible(false);
                        indexButton.setVisible(false);
                    }
                    
                }
            }
        };

        ActionListener buttonListenerIndex = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object w = ae.getSource();
                if (w == indexButton){
                    indexVal = Integer.parseInt(indexInput.getText());
                    java.lang.String message = "";
                    message += String.format("Action Applicable to Index %d.", indexVal);
                    indexInput.setText("");
                    label2.setText(message);
                    indexInput.setVisible(false);
                    indexLabel.setVisible(false);
                    indexButton.setVisible(false);
                    
                }
            }

        };

        ActionListener buttonListenerEditDelete = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object w = ae.getSource();
                if (w == Edit && foodAct == true){
                    Double serving = Double.parseDouble(input2.getText());
                    label2.setText(Jimson.edit(indexVal, "Eat", input.getText(), serving));
                    ta.setText(Jimson.foodView());
                    input.setText("");
                    input2.setText("");
                } else if (w == Edit && foodAct == false){
                    Double serving = Double.parseDouble(input2.getText());
                    label2.setText(Jimson.edit(indexVal, "Do", input.getText(), serving));
                    ta.setText(Jimson.activityView());
                    input.setText("");
                    input2.setText("");
                } else if (w == Delete && foodAct == true){
                    label2.setText(Jimson.delete(indexVal, "Food"));
                    ta.setText(Jimson.foodView());
                } else if (w == Delete && foodAct == false){
                    label2.setText(Jimson.delete(indexVal, "Activity"));
                    ta.setText(Jimson.activityView());
                }
            }
        };

        ActionListener buttonListenerYesNo = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Object p = ae.getSource();
                if (p == Yes && foodAct == true){
                    Yes.setVisible(false);
                    No.setVisible(false);
                    verifier.setText(Jimson.addFood(nameFA, Double.parseDouble(input2.getText())) + "\n" + Jimson.eat(nameFA, servhour));
                    input2.setText("");
                } else if (p == No && foodAct == true) {
                    label2.setText("The specified food does not exist.");
                    Yes.setVisible(false);
                    No.setVisible(false);
                    verifier.setVisible(false);
                } else if (p == Yes && foodAct == false){
                    Yes.setVisible(false);
                    No.setVisible(false);
                    verifier.setText(Jimson.addActivity(nameFA, Double.parseDouble(input2.getText())) + "\n" + Jimson.perform(nameFA, servhour));
                    input2.setText("");
                } else if (p == No && foodAct == false){
                    label2.setText("The specified activity does not exist.");
                    Yes.setVisible(false);
                    No.setVisible(false);
                    verifier.setVisible(false);
                }
            }
        };







        Food.addActionListener(buttonListenerHide);
        Activity.addActionListener(buttonListenerHide);
        Report.addActionListener(buttonListenerHide);

        AddF.addActionListener(buttonListenerFood);
        EatF.addActionListener(buttonListenerFood);
        ViewF.addActionListener(buttonListenerFood);

        AddA.addActionListener(buttonListenerAct);
        PerformA.addActionListener(buttonListenerAct);
        ViewA.addActionListener(buttonListenerAct);

        indexButton.addActionListener(buttonListenerIndex);

        Edit.addActionListener(buttonListenerEditDelete);
        Delete.addActionListener(buttonListenerEditDelete);

        Yes.addActionListener(buttonListenerYesNo);
        No.addActionListener(buttonListenerYesNo);

    }
}