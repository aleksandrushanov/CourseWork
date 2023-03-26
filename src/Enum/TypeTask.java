package Enum;

public enum TypeTask {
    WORK("Work"),
    PERSONAL("Personal");

    private final String type;

    TypeTask(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
