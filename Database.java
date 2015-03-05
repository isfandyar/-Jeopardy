//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class Database
{
  
  private int m; //number of categories
  private int n; // number of question per category
  
  
  private String[] categories;
  private Question[][] questions;
  
  
  private Database (int m , int n)
  {
    this.m = m;
    this.n = n;
    this.categories = new String [m];
    this.questions = new Question [m][n];
    
  }
  
  public static Database readQuestions(String name)
  {
    Scanner sc;  
    Database data;
    try {  
      sc = new Scanner(new File(name));  
    } 
    catch (java.io.FileNotFoundException e) {  
      sc = null;  
    }
    
    
    if( sc != null)
    {
      int m = sc.nextInt(); // number of Categories
      int n = sc.nextInt(); // number of Questions per Category
      sc.nextLine();
      data = new Database (m ,n);
      
      for (int i = 0; i < m ; i++)
      {
        data.setCategory (i , sc.nextLine());
      }
      //String dummy = sc.nextLine();
      for (int i = 0 ; i < m ; i++)
        for(int j = 0 ; j < n ; j++){
        String question  = sc.nextLine();
        String response = sc.nextLine();
        Question temp = new Question (response, question);
        data.setQuestion (i , j, temp);     
      }
      
    }
    
    else {
      System.err.println("Error reading: "+name);
      data = null;
    }
    return data;
  }
  
  
  public String getCategory(int index)
  {
    
    return this.categories[index];
    
  }
  
  public void setCategory (int index, String category)
  {
    this.categories[index] = category;
  }
  
  public Question getQuestion(int category, int index)
  {
    return this.questions[category][index];
  }
  
  public void setQuestion(int category , int index ,Question question)
  {
    this.questions[category][index] = question; 
  }
  
  public int getNumCategories()
  {
    return this.m; 
  }
  
  public int getNumQuestions()
  {
    return this.n; 
  }
}
