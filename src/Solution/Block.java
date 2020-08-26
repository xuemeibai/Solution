package Solution;

import java.util.List;

public class Block {
    public String id;
    public String name;
    public String belongTo;
    public String[] dependencies;
    public Long endTimeLock;
    public List<Task> tasks;
    public Integer referNum ;
    public Long len;
    public Long workload;

    Block(String id, String name, String belongTo, Long endTimeLock, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.belongTo = belongTo;
        this.endTimeLock = endTimeLock;
        this.tasks = tasks;

    }

    /*
     * Create a node with dependencies.
     * */
    Block(String id, String name, String belongTo, Long endTimeLock, List<Task> tasks, String[] dependencies) {
        this(id, name, belongTo, endTimeLock,tasks);
        this.dependencies = dependencies;
    }

}
