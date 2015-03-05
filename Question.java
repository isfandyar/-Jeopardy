//Name: Isfandyar Virani  &  Riyanson Alfred
//ID: 7751854 & 7810835  
//Course: ITI 1121 Section A
//Assignment: 2



public class Question
{
  
  private String question; // The String Containing Question
  private String response; // The String containing Answer
  
  public Question(String response, String question)
  {
    this.response = response;
    this.question = question;
    
  }
  
  public String getQuestion()
  {
    return this.question; 
  }
  
  public String getResponse()
  {
    return this.response; 
  }
}
