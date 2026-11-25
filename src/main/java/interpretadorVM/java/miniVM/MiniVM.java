package interpretadorVM.java.miniVM;

import interpretadorVM.java.miniVM.memory.Memory;

import java.util.Stack;

public class MiniVM {

    private final Stack<Integer> stack = new Stack<>();
    private final Memory memory = new Memory();

    private int pc = 0;

    private boolean running = true;

    public void execute(String[] program) {
        while (running && pc < program.length) {

            String instruction = program[pc];
            String[] parts = instruction.split(" ");
            String opcode = parts[0];

            pc++;

            switch (opcode) {
                case "PUSH":
                    int value = Integer.parseInt(parts[1]);
                    stack.push(value);
                    break;
                case "STORE":
                    String variableName = parts[1];
                    int storedValue = stack.pop();
                    memory.store(variableName, storedValue);
                    break;
                case "LOAD":
                    String loadedName = parts[1];
                    int loadedValue = memory.load(loadedName);
                    stack.push(loadedValue);
                    break;
                case "GT":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a > b ? 1 : 0);
                    break;
                case "LT":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a < b ? 1 : 0);
                    break;
                case "EQ":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a == b ? 1 : 0);
                    break;
                case "JMP":
                    int address = Integer.parseInt(parts[1]);
                    pc = address;
                    break;
                case "JZ":
                    address = Integer.parseInt(parts[1]);
                    int condition = stack.pop();
                    if (condition == 0) {
                        pc = address;
                    }
                    break;
                case "ADD":
                    b = stack.pop();
                    a = stack.pop();
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
        }
    }
}
