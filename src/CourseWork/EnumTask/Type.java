package CourseWork.EnumTask;

public enum Type {
    WORK ( "Рабочая задача" ),
    PERSONAL ( "Личная задача" );

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Тип задачи: " + getValue ();
    }

}


