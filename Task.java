public class Task {
    private int id;
    private String description;
    private int priority;
    private boolean isCompleted;

    public Task(int id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.isCompleted = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
               " | Description: " + description +
               " | Priority: " + priority +
               " | Status: " + (isCompleted ? "Completed" : "Pending");
    }
}
