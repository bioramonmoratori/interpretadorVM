package interpretadorVM.java.MiniVM;

import java.util.Stack;

public class MiniVM {

    private final Stack<Integer> stack = new Stack<>();

    private int pc = 0;

    private boolean running = true;

    public void execute(String[] program) {
        while (running && pc < program.length) {

            String instruction = program[pc];
            String[] parts = instruction.split(" ");
            String opcode = parts[0];

            switch (opcode) {
                case "PUSH":
                    int value = Integer.parseInt(parts[1]);
                    stack.push(value);
                    break;
                case "ADD":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                case "SUB":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "MUL":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "DIV":
                    b = stack.pop();
                    a = stack.pop();

                    if (b == 0) {
                        throw new ArithmeticException("Divisão por zero");
                    }
                    stack.push(a / b);
                    break;
                case "PRINT":
                    System.out.println(stack.peek());
                    break;
                case "HALT":
                    running = false;
                    break;
                default:
                    throw new RuntimeException(
                            "Instrução desconhecida: " + opcode
                    );
            }
            pc++;
        }
    }
}
