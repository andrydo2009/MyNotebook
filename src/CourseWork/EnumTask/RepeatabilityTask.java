package CourseWork.EnumTask;

public enum RepeatabilityTask {
    TASK_ONE_TIME ( "Единоразовая задача " ),
    TASK_DAILY ( "Ежедневная задача" ),
    TASK_WEEKLY ( "Еженедельная задача" ),
    TASK_MONTH ( "Ежемесячная задача" ),
    TASK_YEARLY ( "Ежегодная задача" );
    private final String repeatabilityTask;

    RepeatabilityTask(String repeatabilityTask) {
        this.repeatabilityTask
                = repeatabilityTask;
    }

    public String getRepeatabilityTask() {
        return repeatabilityTask;
    }

    @Override
    public String toString() {
        return getRepeatabilityTask ();
    }
}

