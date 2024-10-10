public class Subtask extends Task {

    public Subtask(String taskName, String taskDescription, int taskId, TaskStatus taskStatus) {
        super(taskName, taskDescription, taskId, taskStatus);
    }

    public Subtask(Subtask subtask) {

        super(subtask.getTaskName(), subtask.getTaskDescription(), subtask.getTaskId(), subtask.getStatus());
    }
}
