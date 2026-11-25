package interpretadorVM.java;

import interpretadorVM.java.miniVM.MiniVM;

public class App
{
    public static void main(String[] args) {

        String[] program = {
                "PUSH 10",
                "STORE x",
                "PUSH 20",
                "STORE y",
                "LOAD x",
                "LOAD y",
                "ADD",
                "PRINT",
                "HALT"
        };

        MiniVM vm = new MiniVM();

        vm.execute(program);
    }
}
