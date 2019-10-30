package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Object> context;

    public Context() {
        this.context = new HashMap<>();
    }

    public Object get(String key) {
        return this.context.get(key);
    }

    public Map<String, Object> getAll() {
        return Collections.unmodifiableMap(this.context);
    }

    public Context put(String key, Object value) {
        this.context.put(key, value);
        return this;
    }

}
