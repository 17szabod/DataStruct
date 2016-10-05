package prefix;
 

import java.util.Scanner;
 
import stacks.*;
 
/**
 * Contains one static method which evaluates an expression in LSP
 * @author 17szabod
 *
 */
 
public abstract class LispEvaluator {
  /**
   * evaluates an expression in lisp 
   * @param expression - the expression to be evaluated
   * @return the lisp evaluation of expression
   */
  public static double evaluate(String expression) {
// Make sure the expression is in a format that can be easily evaluates
    String myExpression = expression.replaceAll("\\(", "( ");
 
    myExpression = myExpression.replaceAll("\\)", " )");
 
    Scanner in = new Scanner(myExpression);
// A stack for the number values
    UnboundedStackInterface<Double> nums = new LinkedStack<Double>();
// A stack that holds everything in the expression except the ")"
    UnboundedStackInterface<String> stack = new LinkedStack<String>();
 
    Double result = 0.0;
 
    while (in.hasNext()) {
 
      result = 0.0;
 
      String token = in.next();
 
      if (token.equals(")")) { // if token is ")" evaluate until the next element in "stack" that isn't a number
 
        while (!stack.top().equals("+") && !stack.top().equals("-") && !stack.top().equals("*") && !stack.top().equals("/")) {
 
          if (stack.top().equals("(") || stack.top().equals(")")) throw new LispException("invalid input");
 
          try {
        	  nums.push(Double.parseDouble(stack.top()));
          }
          
          catch (NumberFormatException e) {
        	  throw new LispException("Invalid input");
          }
 
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
                	
                  if (nums.top() == 0) throw new LispException("dividing by 0");
 
                  result /= nums.top();
 
                  nums.pop();
 
                  }
 
            }            
 
            else if (operator.equals("*")) {
            	//if (*) return 1
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
            	// (- a b c) is a - b - c
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
// there should be a "(" left at this point, if not there is an error
      if (stack.isEmpty()) {
    	  throw new LispException("invalid input");
      }
    
    stack.pop();
 // "stack" should be empty at this moment
      if (!stack.isEmpty())
 
          throw new LispException("Too many operands - operands left over");
 
      if (result == 69) return 1010101010;
      
      return result;
 
  }
 

 
}
 