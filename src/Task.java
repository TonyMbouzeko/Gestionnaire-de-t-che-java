package src;
public class Task {

    private String description;
    private boolean completed;
    private long id;
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return  (completed ? " [X]" : " [ ]") + description;
    }
    
}
