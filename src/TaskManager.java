import java.util.ArrayList;

public class TaskManager {

    private static ArrayList<Task> taskList = new ArrayList<>();
    private static int taskIdCounter = 0;

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void clearTaskList() {
        taskList.clear();
        taskIdCounter = 0;
    }

    public static Task getTaskById(int id) {

        Task taskGotById = taskList.stream().filter(t -> t.getTaskId() == id).findFirst().orElse(null);
        return taskGotById;
    }

    public static void createTask(Task task) {

        if (task != null) {
            task.setTaskId(taskIdCounter);
            taskList.add(task);
            taskIdCounter++;
        } else {
            throw new IllegalArgumentException("TASK НЕ МОЖЕТ БЫТЬ NULL");
        }
    }

    public void updateTask(Task task) {

        if (task != null) {
            for (Task value : taskList) {
                if (value.getTaskId() == task.getTaskId()) {

                    value.setTaskName(task.getTaskName());
                    value.setTaskDescription(task.getTaskDescription());
                    value.setStatus(task.getStatus());
                }
            }
        } else {
            throw new IllegalArgumentException("TASK НЕ МОЖЕТ БЫТЬ NULL");
        }
    }

    public void removeById(int id) {

        taskList.removeIf(t -> t.getTaskId() == id);
    }

    public ArrayList<Subtask> getSubtasksListFromEpic(int id) {

        Epic epicToGetSubtasks = getEpicById(id);

        return epicToGetSubtasks.getSubtasks();
    }

    public void updateSubtask(int epicId, Subtask subtask) {

        if (subtask != null) {
            ArrayList<Subtask> subtaskList = getSubtasksListFromEpic(epicId);

            for (Subtask s : subtaskList) {

                if (s.getTaskId() == subtask.getTaskId()) {

                    s.setStatus(subtask.getStatus());
                    s.setTaskDescription(subtask.getTaskDescription());
                    s.setTaskName(subtask.getTaskName());
                }
            }

            getEpicById(epicId).updateStatus();
        } else {
            throw new IllegalArgumentException("SUBTASK НЕ МОЖЕТ БЫТЬ NULL");
        }

    }

    public Epic getEpicById(int id) {

        ArrayList<Epic> epicList = (ArrayList<Epic>) taskList.stream().filter(t -> t instanceof Epic);

        for (Epic epic : epicList) {
            if (epic.getTaskId() == id) {
                return epic;
            }
        }
        return null;
    }
}
