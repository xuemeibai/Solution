package Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Assign {
    int[][] people;
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
    //3D：100人
    //平面：150人
    //工业设计：50人
    //动画：30人
    public void initiate(int days){
        people = new int[4][days];
        for(int i=0;i<4;i++){
            for(int j=0;j<days;j++){
                if(i==0){
               people[i][j]=100;
                }else if(i==1){
                    people[i][j]=150;

                }else if(i==2){
                    people[i][j]=50;
                }else{
                    people[i][j]=30;
                }
            }
        }
    }
}
