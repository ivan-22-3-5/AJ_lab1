public class TypedValue {
    private final Class<?> type;
    private final Object value;

    public TypedValue(Object value, Class<?> type){
        this.type = type;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Class<?> getType() {
        return type;
    }
}
