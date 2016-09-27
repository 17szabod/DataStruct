package prefix;
 

 
public class LispTester {
 

 
  /**
 
   * @param args
 
   */
 
  public static void main(String[] args) {
 
    // TODO Auto-generated method stub
 
    System.out.println("1. result: " + LispEvaluator.evaluate("(+ 5 0 10)"));
 
    System.out.println("2. result: " + LispEvaluator.evaluate("(+ 5 0 10 (- 7 2))"));
 
    System.out.println("3. result: " + LispEvaluator.evaluate("(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1)))"));
 
    System.out.println("4. result: " + LispEvaluator.evaluate("(+ (- 632) (* 21 3 4) (/ (+ 32) (*) (- 21 3 1)))"));
 
    //System.out.println("result:" + LispEvaluator.evaluate(""));
 
    //System.out.println("result:" + LispEvaluator.evaluate("(/ 0 g)"));
 

 
  }
 

 
}
 