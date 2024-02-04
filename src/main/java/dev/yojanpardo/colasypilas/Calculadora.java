package dev.yojanpardo.colasypilas;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 * Calculadora
 * Dada una cadena s que representa una expresión, evaluar esta expresión y devolver su valor. La división de enteros debe truncar hacia cero. Puede asumir que la expresión dada es siempre válida. Todos los resultados intermedios estarán en el rango de [-231, 231 - 1].
 *<p>
 * Nota: No está permitido utilizar ninguna función incorporada que evalúe cadenas como expresiones matemáticas, como eval().
 */
public class Calculadora {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the operation");
        final String operation = scanner.nextLine();

        System.out.printf("The result for operation [%s] is: %d", operation, resolve(operation));
    }

    private static int resolve(String operation) {
        if(Objects.isNull(operation) || operation.isBlank()){
            System.out.println("this operation is null or blank");
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operationSymbol = '+';

        for(int i = 0; i < operation.length(); i++){
            char c = operation.charAt(i);

            if(Character.isDigit(c)){
                currentNumber = (currentNumber * 10) + (c - '0');
            }

            if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == operation.length() -1){
                switch (operationSymbol) {
                    case '-' -> stack.push(-currentNumber);
                    case '+' -> stack.push(currentNumber);
                    case '*' -> stack.push(stack.pop() * currentNumber);
                    case '/' -> stack.push(stack.pop() / currentNumber);
                }

                operationSymbol = c;
                currentNumber = 0;
            }
        }

        int result = 0;

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
