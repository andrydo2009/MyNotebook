package CourseWork.TaskAllService;

import CourseWork.AllExceptionTask.IncorrectArgumentException;
import CourseWork.AllExceptionTask.TaskNotFoundException;
import CourseWork.Task.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<Integer, Task> taskMap;

    public TaskService() {
        taskMap = new HashMap<> ();
    }

    public void add(Task task) throws IncorrectArgumentException {                                                      // метод добавление задачи
        if (task.getTitle () == null || task.getDescriptions () == null) {
            throw new IncorrectArgumentException ( "Некорректно введены данные задачи" );
        }
        taskMap.put ( task.getId () , task );
    }

    public Task remove(int id) throws TaskNotFoundException {                                                           // метод удаления задачи
        Task task = taskMap.remove ( id );

        if (task == null) {
            throw new TaskNotFoundException ( "В списке нет задачи с таким id" );
        }
        return task;
    }

    public Collection<Task> getAllByDate(LocalDate date) {                                                              // получение списка задач по текущей дате
        ArrayList<Task> list = new ArrayList<> ();
        for (int i = 1; i < taskMap.size () + 1; i++) {
            if (taskMap.get ( i ).appearsIn ( date )) {
                list.add ( taskMap.get ( i ) );
            }
        }
        if (list.isEmpty ()){
            System.out.println ("На сегодня у вас нет задач");
        }
        return list;
    }
}
