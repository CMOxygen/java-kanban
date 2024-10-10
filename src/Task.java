public class Task {

    private String taskName;
    private String taskDescription;
    private int taskId;

    private TaskStatus status;

    public Task(String taskName, String taskDescription, int taskId, TaskStatus status) {

        setTaskName(taskName);
        setTaskDescription(taskDescription);
        setTaskId(taskId);
        setStatus(status);
    }

    public Task(Task task) {

        if (task != null) {

            setTaskName(task.getTaskName());
            setTaskDescription(task.getTaskDescription());
            setTaskId(task.getTaskId());
            setStatus(task.getStatus());
        } else {
            throw new IllegalArgumentException("TASK НЕ МОЖЕТ БЫТЬ NULL");
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {

        if (taskName != null) {
            this.taskName = taskName;
        } else {
            throw new IllegalArgumentException("НАЗВАНИЕ ЗАДАЧИ НЕ МОЖЕТ БЫТЬ NULL");
        }
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {

        if (taskDescription != null) {
            this.taskDescription = taskDescription;
        } else {
            throw new IllegalArgumentException("ОПИСАНИЕ ЗАДАЧИ НЕ МОЖЕТ БЫТЬ NULL");
        }
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {

        if (taskId < 0) {
            this.taskId = taskId;
        } else {
            throw new IllegalArgumentException("TASK ID НЕ МОЖЕТ БЫТЬ МЕНЬШЕ 0");
        }
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus taskStatus) {

        if (taskStatus != null) {
            this.status = taskStatus;
        } else {
            throw new IllegalArgumentException("СТАТУС ЗАДАЧИ НЕ МОЖЕТ БЫТЬ NULL");
        }
    }
}
