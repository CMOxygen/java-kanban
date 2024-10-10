import java.util.ArrayList;

public class Epic extends Task {

    ArrayList<Subtask> subtasks;

    public Epic(String taskName, String taskDescription, int taskId, TaskStatus taskStatus) {
        super(taskName, taskDescription, taskId, taskStatus);

        subtasks = new ArrayList<>();
    }

    public Epic(Epic epic) {
        super(epic.getTaskName(), epic.getTaskDescription(), epic.getTaskId(), epic.getStatus());

        subtasks = new ArrayList<>();

        for (Subtask s : epic.getSubtasks()) {

            subtasks.add(new Subtask(s));
        }
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void updateStatus() {

        if (subtasks.stream().allMatch(s -> s.getStatus() == TaskStatus.NEW)) {

            setStatus(TaskStatus.NEW);

        } else if (subtasks.stream().allMatch(s -> s.getStatus() == TaskStatus.DONE)) {

            setStatus(TaskStatus.DONE);

        } else {

            setStatus(TaskStatus.IN_PROGRESS);
        }
    }
}
