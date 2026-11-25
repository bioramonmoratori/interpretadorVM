package interpretadorVM.java;

import interpretadorVM.java.miniVM.MiniVM;

public class App
{
    public static void main(String[] args) {

        String[] program = {

                "PUSH 20",
                "PRINT",
                "JMP 3",
                "HALT"
        };

        MiniVM vm = new MiniVM();

        vm.execute(program);
    }
}
