import java.util.*;


public class Task {
    private String id;
    private int priority;
    private long timeMark;
   // private Map<String, Object> supplementalData;
    private ActionType actionType;
    private AirportGroundNetwork targetObject;
    public Task(String id, int priority, long timeMark,
                ActionType actionType, AirportGroundNetwork targetObject, Graph path) {
        this.id = id;
        this.priority = priority;
        this.timeMark = timeMark;
        //this.supplementalData = supplementalData;
        this.actionType = actionType;
        this.targetObject = targetObject;
    }

    public String getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public long getTimeMark() {
        return timeMark;
    }

   /*  public Map<String, Object> getSupplementalData() {
        return supplementalData;
    }*/

    public ActionType getActionType() {
        return actionType;
    }

    public AirportGroundNetwork getTargetObject() {
        return targetObject;
    }

    public boolean isExecutable(Airplane airplane, Taxiway taxiway) {
        // Check airplane's state
        if (!airplane.getState().isCompatibleWith(actionType)) {
            return false;
        }

        // Check target object's availability 
        if (targetObject != null && !targetObject.isAvailable()) {
            return false;
        }

        return true;
    }

    public String getAction() {
        return actionType.name();
    }
}
    