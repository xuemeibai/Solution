package Solution;

import javax.swing.text.StyledEditorKit;
import java.util.*;

public class Preprocessing {

    static Map<String, Integer> refer = new HashMap<>();

    public static void preprocess(Project project) {
        List<Block> blocks = project.blocks;
        for (Block block : blocks) {
            List<Task> tasks = block.tasks;
            long max = 0;
            for (Task task : tasks) {
                max = Math.max(task.hours, max);
            }
            block.workload = max;
            if (block.dependencies.length > 0) {
                for (String depend : block.dependencies) {
                    refer.put(depend, refer.getOrDefault(depend, 0) + 1);
                }
            }

        }
        for (Map.Entry<String, Integer> entry : refer.entrySet()) {
            ConstructFromFile.blockMap.get(entry.getKey()).referNum = entry.getValue();
        }
        long[] max = new long[1];

        for (Block block : blocks) {
            if (block.referNum == null) {
                getPath(block, 0l, max);
            }

        }
        project.blocks = sort(blocks);
        System.out.println("Unlimited people to work for " + max[0] + " hours");
    }

    private static void getPath(Block block, long path, long[] max) {
        if (block.dependencies.length == 0) {
            // record length
            block.len = path + block.workload;
            max[0] = Math.max(max[0], block.len);
            return;
        }
        block.len = path + block.workload;
        for (String dependedID : block.dependencies) {
            getPath(ConstructFromFile.blockMap.get(dependedID), block.len, max);
        }

    }

    private static List<Block> sort(List<Block> blocks) {
        Collections.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block b1, Block b2) {
                if (b1.len == b2.len) {
                    if (b1.referNum == b2.referNum) {
                        if (b1.workload == b2.workload) {
                            return b1.name.compareTo(b2.name);
                        }
                        return b1.workload > b2.workload ? -1 : 1;
                    }
                    return b1.referNum > b2.referNum ? -1 : 1;
                }
                return b1.len > b2.len ? -1 : 1;
            }
        });
        return blocks;
    }
}
