package interpretadorVM.java.miniVM.memory;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    private final Map<String, Integer> variables =
            new HashMap<>();

    public void store(String name, int value) {
        variables.put(name, value);
    }

    public int load(String name) {

        if (!variables.containsKey(name)) {
            throw new RuntimeException(
                    "Variável não encontrada: " + name
            );
        }

        return variables.get(name);
    }
}
