import java.util.*;
public class Parser {
    private ArrayList<Double> numberList;
    private ArrayList<Character> operationList; 

    public Parser(ArrayList<Double> nL, ArrayList<Character> oL){
        numberList = nL;
        operationList = oL;
    }

    public double evaluate(){
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        int numbersIndex = 0;
        int operationsIndex = 0;
        for(int i = 0; i < numberList.size() + operationList.size(); i++){
            if(i % 2 == 0){
                numbers.push(numberList.get(numbersIndex));
                numbersIndex++;
            }
            else{
                char currentOperation = operationList.get(operationsIndex);
                char previousOperation = operations.peek();
                if(!operations.empty() && precedence(previousOperation, currentOperation)){
                    double b = numbers.pop();
                    double a = numbers.pop();
                    char op = operations.pop();
                    numbers.push(evaluateOperation(b,a,op));
                }
                operations.push(currentOperation);
                operationsIndex++;
            }
        }
        while(!operations.empty()){
            double b = numbers.pop();
            double a = numbers.pop();
            char op = operations.pop();
            numbers.push(evaluateOperation(b,a,op));
        }
        return numbers.pop();
    }

    private double evaluateOperation(double b, double a, char op){
        if(op == '+') return a+b;
        else if(op == '-') return a-b;
        else if(op == '*') return a*b;
        else return a/b; 
    }

    private boolean precedence(char op1, char op2){
        if((op1 == '+' || op1 == '-') && (op2 == '*' || op2 == '/')) return false;
        return true; 
    }

}
