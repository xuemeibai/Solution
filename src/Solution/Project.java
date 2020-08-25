package Solution;

import Solution.Block;

import java.util.List;

public class Project {
    public String id;
    public String name;
    public Long confirmAt;
    public Long deliveryAt;
    public List<Block> blocks;

    Project(String id, String name, Long confirmAt, Long deliveryAt, List<Block> blocks) {
        this.id = id;
        this.name = name;
        this.confirmAt = confirmAt;
        this.deliveryAt = deliveryAt;
        this.blocks = blocks;

    }
}
