package CourseWork.AllExceptionTask;

public class IncorrectArgumentException extends Exception {
    private final String argument;
    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }
    @Override
    public String toString() {
        return argument;
    }
}



