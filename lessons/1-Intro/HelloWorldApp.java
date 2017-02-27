// one class needs to have a main() method
public class HelloWorldApp
{
  
  public static char bar(int a, int b){
   return (char)(a+b);
  }
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    String s="Hello Worl";
    
    System.out.println(s+bar(50,50));
  
  }
}
