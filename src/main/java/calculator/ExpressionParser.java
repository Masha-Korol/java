package calculator;

import java.util.Stack;

/**
 * This class is structure for building a tree
 */
class TreeNode {
    TreeNode left, right;
    boolean isLeaf;
    double value;
    char operation;
}

/**
 * This class is used for solving math expressions
 */
public class ExpressionParser {
    private TreeNode root;

    /**
     * This method is called to solve math expression.
     * The result is a tree with root
     *
     * @param expression - string math expression
     */
    public void parseExpression(String expression) {
        root = parse(expression);
    }

    /**
     * This method parses string expression: searches for operation signs and separates the expression with them.
     * Then recursively parses sub-expressions and builds a tree.
     *
     * @param expression - string math expression
     * @return - current node in the process and the root in the end (null if there's an error).
     */
    private TreeNode parse(String expression) {
        TreeNode node = new TreeNode();
        int currentPosition;
        boolean currentExpressionIsANumberOrInParents = true;

        // ищем '+' или '-'
        for (currentPosition = expression.length() - 1; currentPosition >= 0; currentPosition--) {
            char currentChar = expression.charAt(currentPosition);

            if (currentChar == '(') {
                return null;
            }
            if (currentChar == ')') {
                // если наткнулись на закрывающую скобку, ищем открывающую и игнорируем все, что в них
                //  (воспринимаем содержимое скобок как отдельный член выражения, не поддающийся дроблению на данном этапе)
                int leftParentPosition = findLeftParent(expression, currentPosition);
                if (leftParentPosition == -1) {
                    return null;
                }
                currentPosition = leftParentPosition;

            } else if (currentChar == '+' || currentChar == '-') {
                currentExpressionIsANumberOrInParents = false;
                break;
            }
        }


        // если таких знаков нет
        if (currentPosition == 0 || currentPosition == -1) {
            // ищем '*' или '/'
            for (currentPosition = expression.length() - 1; currentPosition >= 0; currentPosition--) {
                char currentChar = expression.charAt(currentPosition);

                if (currentChar == '(') {
                    return null;
                }
                if (currentChar == ')') {
                    // если наткнулись на закрывающую скобку, ищем открывающую и игнорируем все, что в них
                    //  (воспринимаем содержимое скобок как отдельный член выражения, не поддающийся дроблению на данном этапе)
                    int leftParentPosition = findLeftParent(expression, currentPosition);
                    if (leftParentPosition == -1) {
                        return null;
                    }
                    currentPosition = leftParentPosition;

                } else if (currentChar == '*' || currentChar == '/') {
                    currentExpressionIsANumberOrInParents = false;
                    break;
                }
            }
        }

        // если в оставшемся выражении нет никаких знаков, значит, оно либо в скобках
        // (тк при поиске знаков в выражении мы игнорируем то, что в скобках)
        // либо мы дошли до числа
        if (currentExpressionIsANumberOrInParents) {
            // если выражение в скобках, отдельно парсим их содержимое
            if (expression.charAt(0) == '(' && expression.charAt(expression.length() - 1) == ')') {
                return parse(expression.substring(1, expression.length() - 1));
            } else {
                // если выражение - число
                Double currentValue;
                try {
                    currentValue = Double.parseDouble(expression);
                } catch (NumberFormatException e) {
                    return null;
                }
                node.isLeaf = true;
                node.value = currentValue;
                return node;
            }
        }

        // рекурсивно вычисляем правую и левую части выражения
        node.left = parse(expression.substring(0, currentPosition));
        node.right = parse(expression.substring(currentPosition + 1));
        node.operation = expression.charAt(currentPosition);
        return node;
    }

    /**
     * This method finds the position of the left parent by the position of the right one.
     * We use stack in this one: whenever we bump into left ')', we push it to stack,
     * while it's '(', we delete previous parent. We stop when the stack is empty.
     *
     * @param expression - string math expression
     * @param i          - position of the right parent
     * @return - position of the left parent (-1, if there's an error).
     */
    private int findLeftParent(String expression, int i) {
        Stack<Character> stack = new Stack<Character>();
        stack.push(expression.charAt(i));
        for (int currentPosition = i - 1; currentPosition >= 0; currentPosition--) {
            char currentChar = expression.charAt(currentPosition);
            if (currentChar == ')') {
                stack.push(currentChar);
            } else if (currentChar == '(') {
                stack.pop();
                if (stack.empty()) {
                    return currentPosition;
                }
            }
        }
        return -1;
    }

    /**
     * This method computes the expression by tree, which was build previously.
     *
     * @return - expression result (null if there's an error).
     */
    public Double computeValue() {
        return compute(root);
    }

    /**
     * This method computes the expression by tree, which was build previously.
     *
     * @param node
     * @return - expression result (null if there's an error).
     */
    private Double compute(TreeNode node) {
        try {
            if (node.isLeaf) {
                return node.value;
            }
        } catch (NullPointerException e) {
            return null;
        }

        Double leftValue = compute(node.left);
        Double rightValue = compute(node.right);

        if (leftValue == null || rightValue == null) {
            return null;
        }

        switch (node.operation) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;

            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
            default:
                return null;
        }
    }

    public int findVariables(String expression) {
        int currentPosition = 0;
        while (currentPosition < expression.length()) {
            if (Character.isLetter(expression.charAt(currentPosition))) {
                return currentPosition;
            }
            currentPosition++;
        }
        return -1;
    }
}
