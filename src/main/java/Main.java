import calculator.ExpressionParser;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        ExpressionParser expressionParser = new ExpressionParser();

        int variablePosition = expressionParser.findVariables(line);
        while (variablePosition != -1){
            System.out.println("Введите значение переменной "+line.charAt(variablePosition)+" = ");
            Integer var = scanner.nextInt();
            line = line.replaceAll(String.valueOf(line.charAt(variablePosition)), var.toString());
            variablePosition = expressionParser.findVariables(line);
        }

        expressionParser.parseExpression(line);
        Double result = expressionParser.computeValue();
        if(result == null){
            System.out.println("error");
        } else{
            System.out.println(line + " = " + result);
        }

        scanner.close();
    }
}
