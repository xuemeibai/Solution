package Solution;

public class Main {
    public static void main(String[] args) {
        // read from file
        Project project = ConstructFromFile.parseFromFile("C:/Users/xueme/IdeaProjects/Solution/data/TestData1.json");

        // sort
        Preprocessing.preprocess(project);


        for (Block block : project.blocks) {

            System.out.print(block.name + "->");

        }
        System.out.println();


        //Assign.assignTask(project);

        // solve

        // output
    }
}
