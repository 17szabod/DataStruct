package prefix;
 

 
import java.util.Scanner;
 
import stacks.ArrayStack;
 
import stacks.BoundedStackInterface;
 

 
public class LispEvaluator {
 
  public static double evaluate(String expression) {
 
    String myExpression = expression.replaceAll("\\(", "( ");
 
    myExpression = myExpression.replaceAll("\\)", " )");
 
    //System.out.println(myExpression);
 
    Scanner in = new Scanner(myExpression);
 
    BoundedStackInterface<Double> nums = new ArrayStack<Double>(50);
 
    BoundedStackInterface<String> stack = new ArrayStack<String>(100);
 
    Double result = 0.0;
 
    while (in.hasNext()) {
 
      result = 0.0;
 
      String token = in.next();
 
      //System.out.println("\n" + token);
 
      if (token.equals(")")) {
 
        while (!stack.top().equals("+") && !stack.top().equals("-") && !stack.top().equals("*") && !stack.top().equals("/")) {
 
          if (stack.top().equals("(") || stack.top().equals(")")) throw new LispException("invalid input");
 
          nums.push(Double.parseDouble(stack.top()));
 
          //System.out.println(stack.top());
 
          stack.pop();
 
        }
 
        String operator = stack.top();
 
        // Perform operation.
 
            if (operator.equals("/")) {
 
                  result = nums.top();
 
                  nums.pop();
 
                if (nums.isEmpty()) {
 
                  //if (/ a), return 1/a
 
                  result = 1 / result;
 
                }
 
                while (!nums.isEmpty()) {
 
                  result /= nums.top();
 
                  nums.pop();
 
                  }
 
            }            
 
            else if (operator.equals("*")) {
 
                    result = 1.0;
 
                while (!nums.isEmpty()) {
 
                  result *= nums.top();
 
                  nums.pop();
 
                  }
 
                }  
 
            else if (operator.equals("+")) {
 
                while (!nums.isEmpty()) {
 
                  result += nums.top();
 
                  nums.pop();
 
                  }
 
                }  
 
            else if (operator.equals("-")) {
 
                  result = nums.top();
 
                  nums.pop();
 
              if (nums.isEmpty()) {
 
                //if (- a), return -a
 
                result = -result;
 
              }
 
                while (!nums.isEmpty()) {
 
                    result -= nums.top();
 
                  nums.pop();
 
                  }
 
                }  
 
            stack.pop();
 
            stack.pop();
 
            stack.push(result.toString());
 
      }
 
      else {
 
        stack.push(token);
 
      }
 
    }
    
    stack.pop();
 
      if (!stack.isEmpty())
 
          throw new LispException("Too many operands - operands left over");
 
      return result;
 
  }
 

 
}
 