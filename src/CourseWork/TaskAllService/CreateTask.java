package CourseWork.TaskAllService;

import CourseWork.AllExceptionTask.IncorrectArgumentException;
import CourseWork.EnumTask.RepeatabilityTask;
import CourseWork.EnumTask.Type;
import CourseWork.Task.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CreateTask {

    private static Type inputTaskType(Scanner scanner) {

        System.out.println ( "Выберите тип задачи выбрав пункт меню под нужной цифрой: \n 1 - Личная \n 2 - Рабочая" );
        Type type = null;
        int taskType = scanner.nextInt ();
        if (taskType == 1) {
            type = Type.PERSONAL;
        } else if (taskType == 2) {
            type = Type.WORK;
        }
        return type;
    }

    private static String inputTaskTitle() throws IncorrectArgumentException {
        System.out.print ( "Введите название задачи: " );
        String myInputTitle;
        Scanner myScanner = new Scanner ( System.in ).useDelimiter ( "\\n" );
        myInputTitle = myScanner.next ();
        if (myInputTitle == null||myInputTitle.isEmpty ())
            throw new IncorrectArgumentException ( "Некорректно введены данные задачи" );
        System.out.println ( myInputTitle );
        return myInputTitle;
    }

    private static String inputTaskDescriptions() throws IncorrectArgumentException {
        System.out.print ( "Введите описание задачи: " );
        String myInputDescriptions;
        Scanner myScanner = new Scanner ( System.in ).useDelimiter ( "\\n" );
        myInputDescriptions = myScanner.next ();
        if (myInputDescriptions == null||myInputDescriptions.isEmpty ()) {
            throw new IncorrectArgumentException ( "Некорректно введены данные задачи" );
        }
        System.out.println ( myInputDescriptions );
        return myInputDescriptions;
    }

    public static LocalDateTime createLeadTime(Scanner scanner) {
        System.out.println ( "Когда первый раз приступить к задаче, введите дату: " );
        System.out.println ( " Формат  ввода:" + "\n год - " +
                "\n месяц (от 1 до 12) - " +
                "\n день(от 1 до 31) - " +
                "\n часы ( от 0 до 23 ) - " +
                "\n минуты( от 0 до 59 ) - " );
        LocalDateTime leadTime = LocalDateTime.of (
                scanner.nextInt () ,
                scanner.nextInt () ,
                scanner.nextInt () ,
                scanner.nextInt () ,
                scanner.nextInt () );
        System.out.println ( leadTime );
        return leadTime;
    }


    public static Task createTask(Scanner scanner) throws IncorrectArgumentException {
        while (true) {
            System.out.println ( "Выберите периодичность повторения задачи указав нужный пункт меню : " +
                    "\n 1 - однократная " +
                    "\n 2 - ежедневная " +
                    "\n 3 - еженедельная " +
                    "\n 4 - ежемесячная " +
                    "\n 5 - ежегодная" );
            int taskRepeat = scanner.nextInt ();
            switch (taskRepeat) {
                case 1:
                    return new OneTimeTask ( inputTaskType ( scanner ) , inputTaskTitle () , inputTaskDescriptions () , createLeadTime ( scanner ) , RepeatabilityTask.TASK_ONE_TIME );
                case 2:
                    return new DailyTask ( inputTaskType ( scanner ) , inputTaskTitle () , inputTaskDescriptions () , createLeadTime ( scanner ) , RepeatabilityTask.TASK_DAILY );
                case 3:
                    return new WeeklyTask ( inputTaskType ( scanner ) , inputTaskTitle () , inputTaskDescriptions () , createLeadTime ( scanner ) , RepeatabilityTask.TASK_WEEKLY );
                case 4:
                    return new MonthlyTask ( inputTaskType ( scanner ) , inputTaskTitle () , inputTaskDescriptions () , createLeadTime ( scanner ) , RepeatabilityTask.TASK_MONTH );
                case 5:
                    return new YearlyTask ( inputTaskType ( scanner ) , inputTaskTitle () , inputTaskDescriptions () , createLeadTime ( scanner ) , RepeatabilityTask.TASK_YEARLY );
            }
            System.out.println ( "Ввведите правильный пункт меню " );
        }
    }


}
