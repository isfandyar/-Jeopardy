//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 2

import java.util.Random;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class JeopardyButton extends JButton// implements ActionListener
{
  private int category;
  private int question;
  
  
  public JeopardyButton(ActionListener listener, int category, int question, int amount)
  {
    super ("$" + Integer.toString(amount));
    this.category = category;
    this.question = question;
    //String label = "$"+amount;
    //JButton jeopardyButton =  new JButton (label);
    
    this.addActionListener(listener);
    
    
  }
  public int getCategory(){
    return this.category;
  }
  
  public int getQuestion(){
    return this.question;
  }
}
