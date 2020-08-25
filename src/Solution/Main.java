package Solution;

public class Main {
    public static void main(String[] args){
        // read from file
       Project project= ConstructFromFile.parseFromFile("C:/Users/xueme/IdeaProjects/Solution/data/TestData1.json");

        // sort
        Preprocessing.preprocess(project);

        Assign.assignTask(project);

        // solve

        // output
    }
}
