package calculator;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void solve() {
        ExpressionParser expressionParser = new ExpressionParser();

        String line1 = "(11-(5-2)+1)";
        String line2 = "(6*3)*11";
        String line3 = "(3-2+4)-4*5+5/(2-4)";

        String errorLine1 = "5+(6-1";
        String errorLine2 = "4+&";
        String errorLine3 = "(5+2))";

        expressionParser.parseExpression(line1);
        Double result = expressionParser.computeValue();
        assertEquals(Double.valueOf(9.0), result);
        expressionParser.parseExpression(line2);
        result = expressionParser.computeValue();
        assertEquals(Double.valueOf(198.0), result);
        expressionParser.parseExpression(line3);
        result = expressionParser.computeValue();
        assertEquals(Double.valueOf(-17.5), result);

        expressionParser.parseExpression(errorLine1);
        result = expressionParser.computeValue();
        assertNull(result);
        expressionParser.parseExpression(errorLine2);
        result = expressionParser.computeValue();
        assertNull(result);
        expressionParser.parseExpression(errorLine3);
        result = expressionParser.computeValue();
        assertNull(result);
    }
}
