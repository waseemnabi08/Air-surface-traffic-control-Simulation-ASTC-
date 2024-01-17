import java.util.*;

public class TaskEngine {
    private Queue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> {
        if (t1.getPriority() != t2.getPriority()) {
            return Integer.compare(t2.getPriority(), t1.getPriority()); // Higher priority tasks first
        } else {
            return Long.compare(t1.getTimeMark(), t2.getTimeMark()); // Earlier tasks first
        }
    });

    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public Task dispatchTask(Airplane airplane, AirportGroundNetwork network) {
        Task task = taskQueue.poll(); // Retrieve and remove the highest priority task from the queue

        if (task != null) {
            switch (task.getActionType()) {
                case MOVE:
                    airplane.move(task.getTargetObject());
                    network.updateObjectState(task.getTargetObject());
                    break;
                case HOLD:
                    airplane.hold();
                    break;
                    case PARK:
                    airplane.parkAt(task.getTargetObject());
                    network.updateObjectState(task.getTargetObject());
                    break; 
                default:
                    break;
            }
        }

        return task;
    }

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }
}

enum ActionType {
    MOVE, HOLD, PARK
}