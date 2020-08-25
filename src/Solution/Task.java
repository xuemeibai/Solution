package Solution;

import java.util.List;

public class Task {
    public String id;
    public String name;
    public Long hours;
    public  Long count;
    public TaskType type;

    public String belongTo;
//    private List<Task> dependencies;


    //TODO: add priority level here,


    /*
     * Funtions*/

    /*
     * Create a node without dependencies
     * */
    Task(String id, String name, Long hours, Long count,TaskType type, String belongTo) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.type = type;
        this.belongTo = belongTo;
        this.count=count;

    }

    /*
     * Create a node with dependencies.
     * */
//    Task(String id, String name, int hours, taskType type, Block belongTo, List<Task> dependencies) {
//        this(id, name, hours, type, belongTo);
//        this.dependencies = dependencies;
//    }


}
