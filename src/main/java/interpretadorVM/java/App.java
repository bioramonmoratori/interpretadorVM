package interpretadorVM.java;

import interpretadorVM.java.MiniVM.MiniVM;

public class App
{
    public static void main(String[] args) {

        String[] program = {
                "PUSH 10",
                "PUSH 20",
                "ADD",
                "PUSH 5",
                "MUL",
                "PRINT",
                "HALT"
        };

        MiniVM vm = new MiniVM();

        vm.execute(program);
    }
}
