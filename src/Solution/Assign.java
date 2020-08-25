package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Assign {
    public static void assignTask(Project project){
        List<Block> blocks= new LinkedList<>(project.blocks);
        for(Block block:blocks){
            for(Task task:block.tasks){
                if(!couldAssign(task)){
                    //
                }else {

                }
            }

        }
    }

    private static boolean couldAssign(Task task){
        //assign task to operators
        return true;
    }
}
