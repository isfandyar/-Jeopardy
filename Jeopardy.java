//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 2


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;

public class Jeopardy extends JFrame implements ActionListener 
{
  
  
  
  
  
  private Database database;
  
  private int numCategories;
  private int numQuestions;
  private String name;
  private JButton Reveal;
  private JButton Load;
  private JPanel control;
  private JeopardyButton questionButtons [][];
  private JPanel categoryTitles;
  private JLabel title[];
  private JPanel buttons;
  private JLabel label;
  private JLabel label2;
  private String qquestion;
  private int colm;
  private int rows;
  private boolean check = false;
  private boolean firstRun = true;
  
  public Jeopardy()
  {
    super ("Jeopardy");
    
    StudentInfo.display();
    
    
    String StudentInfo = ("************************************************************"+
                          "\nRiyanson Alfred, Isfandyar Virani                               "+
                          "\n7810835 , 7751854                                        "+
                          "\nITI1121 A                                                      "+
                          "\nAssignment 2                                                   "+
                          "\nPress OK to Continue! "+
                          "\n************************************************************");
    pack();
    
    //JOptionPane.showOptionDialog(StudentInfo);
    JOptionPane.showMessageDialog(null, StudentInfo, "StudentInfo", JOptionPane.INFORMATION_MESSAGE);
    
    
    
    A: while (true){
      this.name = JOptionPane.showInputDialog("Enter the name of the file", "lorem_ipsum.txt");
      this.database = database.readQuestions(name);
      
      if (database == null)
      {
        Object[] options = { "OK", "CANCEL" };
        JOptionPane.showOptionDialog(null, "The name that was Entered does not exist. Click OK to Enter another file name", "Warning",
                                     JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                     null, options, options[0]);
      }
      else {
        break A;
      }
      
    }//checks to see if the file that was entered actually exists or not
    
    
    
    this.setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.WHITE);
    
    
    numCategories = this.database.getNumCategories();
    numQuestions = this.database.getNumQuestions();
    
    this.label = new JLabel ("");
    this.label2 = new JLabel ("");
    
    this.Reveal = new JButton ("Reveal");
    this.Load = new JButton ("Load");
    this.Reveal.setFocusPainted(false);
    this.Load.setFocusPainted(false);
    this.Reveal.addActionListener(this);
    this.Load.addActionListener(this);
    
    //bottom panel
    this.control = new JPanel();
    this.control.setLayout(new GridLayout(0,1));
    this.control.add(label);
    this.control.add(label2);
    this.control.add(Reveal);
    this.control.add(Load);
    add(this.control,BorderLayout.SOUTH);
    
    
    //top panel
    this.categoryTitles = new JPanel();
    
    this.categoryTitles.setLayout(new GridLayout(1,numCategories));
    this.title = new JLabel [numCategories];
    this.categoryTitles.setBackground(Color.YELLOW);
    
    for(int i = 0; i < title.length ; i++)
    {
      this.title[i] = new JLabel (this.database.getCategory(i));
      this.title[i].setHorizontalAlignment(JLabel.CENTER);
      categoryTitles.add(title[i]);
    }
    add(this.categoryTitles,BorderLayout.NORTH);
    
    
    
    
    //center panel with question buttons
    this.buttons = new JPanel();
    this.buttons.setLayout (new GridLayout (numCategories, numQuestions));
    
    this.questionButtons = new JeopardyButton [numCategories][numQuestions];
    
    
    
    for (int col=0; col < numQuestions; col++) { 
      int amount = 100;
      
      for(int row=0; row<numCategories; row++){
        
        this.questionButtons[row][col] = new JeopardyButton(this,row,col,amount); 
        amount = amount + 100;
        
      }// end categories per quesstion 
    }//end num categories
    
    
    // This nested for loop is used to lay out the questions on the board
    for(int row=0; row<numCategories; row++){
      for (int col=0; col < numQuestions; col++) {
        
        this.buttons.add(questionButtons[row][col]);
        this.questionButtons[row][col].addActionListener(this);
        
      }// end categories per quesstion for laying out the questions  
    }//end num categories for laying out the questions
    
    
    add(this.buttons, BorderLayout.CENTER);
    pack();
    
  }
  
  
  public void actionPerformed( ActionEvent e ) {
    
    String cmd = e.getActionCommand();
    
    //if one of the buttons are pressed
    for (int col=0; col < numQuestions; col++) { 
      //int amount = 100;
      
      for(int row=0; row < numCategories; row++){
        
        if (e.getSource() == questionButtons[row][col])
        {
          this.colm = col;
          this.rows = row;
          this.qquestion =  database.getQuestion(col , row).getQuestion();
          // System.out.println(qquestion);
          int amount = 0;
          this.questionButtons[row][col].setText("-");
          
          this.label.setText(qquestion);
          this.label2.setText("-");
          this.check = true;
          
          
          setVisible(true);
          pack();
          
        }
        
      }// end categories per quesstion 
    }//end num categories
    
    
    
    if (cmd.equals( "Load" )){
      
      this.setVisible(false);
      new Jeopardy();
      
    }//ends the actionlistener for Load button
    
    else if (cmd.equals( "Reveal" )){
      
      if (check == false)
      {
        Object[] options = { "OK", "CANCEL" };
        JOptionPane.showOptionDialog(null, "No Question has been selected. Click OK to continue", "Warning",
                                     JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                                     null, options, options[0]);
      }
      
      else{
        
        String rresponse =  database.getQuestion(this.colm , this.rows).getResponse();
        this.label2.setText(rresponse);
        this.check = false;
      }
    } //end the actionlistener for Reveal 
    
  }
  
  public static void main(String[] args) {
    Jeopardy NEW = new Jeopardy();
  }
  
}
