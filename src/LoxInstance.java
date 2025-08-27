import java.util.HashMap;
import java.util.Map;

public class LoxInstance {
    private LoxClass classObj;
    private final Map<String, Object> fields = new HashMap<>();

    LoxInstance(LoxClass classObj) {
        this.classObj = classObj;
    }

    Object get(Token name) {
        if (fields.containsKey(name.lexeme)) {
            return fields.get(name.lexeme);
        }

        throw new RuntimeError(name, "Undefined property '" + name.lexeme + "'.");
    }

    @Override
    public String toString() {
        return classObj.name + " instance";
    }
}
