package CourseWork.Task;

// одноразовая задача

import CourseWork.EnumTask.RepeatabilityTask;
import CourseWork.EnumTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(Type type , String title , String descriptions , RepeatabilityTask repeatabilityTask) {
        super ( type , title , descriptions , repeatabilityTask );
    }

    public OneTimeTask(Type type , String title , String descriptions , LocalDateTime dateLead , RepeatabilityTask repeatabilityTask) {
        super ( type , title , descriptions , dateLead , repeatabilityTask );
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateLead ().toLocalDate ().equals ( date );
    }


}
