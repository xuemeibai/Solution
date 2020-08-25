package Solution;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ConstructFromFile {
    static Map<String,Block>  blockMap=new HashMap<>();

    static public Project parseFromFile(String fileName){
        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
        List<Project> projects=new LinkedList<>();
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray projectList = (JSONArray) obj;
            System.out.println(projectList);



            //Iterate over project array
            projectList.forEach( proj -> parseProject( (JSONObject) proj , projects) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return projects.size()==0?null:projects.get(0);//TODO:
    }
    static private void parseProject(JSONObject project, List<Project> projects){


        JSONObject projectObject = (JSONObject) project.get("project");


        String id = (String) projectObject.get("id");
        System.out.println(id);


        String name = (String) projectObject.get("name");
        System.out.println(name);


        Long confirmAt = (Long)projectObject.get("confirmAt");
        System.out.println(confirmAt);
        Long deliveryAt = (Long) projectObject.get("deliveryAt");
        System.out.println(deliveryAt);
        JSONArray blockList = (JSONArray) projectObject.get("blocks");

        List<Block> blocks=new LinkedList<>();
        //Iterate over block array
        blockList.forEach( block -> parseBlock( (JSONObject) block , blocks,id) );
        Project tmp = new Project(id,name,confirmAt,deliveryAt,blocks);
        projects.add(tmp);
    }
    static private void parseBlock(JSONObject block, List<Block> blocks,String project_id){

        String id = (String) block.get("id");
        System.out.println(id);


        String name = (String) block.get("name");
        System.out.println(name);


        JSONArray depend = (JSONArray)block.get("dependencies");
        String[] dependency=new String[depend.size()];
        for(int i=0;i<depend.size();i++){
            dependency[i]=(String)depend.get(i);
        }
        System.out.println(dependency);

        Long endTimeLock = (Long) block.get("endTimeLock");
        System.out.println(endTimeLock);

        JSONArray taskList = (JSONArray) block.get("tasks");

        List<Task> tasks=new LinkedList<>();

        taskList.forEach( task -> parseTask( (JSONObject) task , tasks,id) );
        Block tmp = new Block(id,name,project_id,endTimeLock,taskList,dependency);

        blocks.add(tmp);
        blockMap.put(id,tmp);
    }
    static private void parseTask(JSONObject task, List<Task> tasks,String block_id){

//        Task tmp = new Task();
        String id = (String) task.get("id");
        System.out.println(id);


        String name = (String) task.get("name");
        System.out.println(name);

      Long hours = (Long) task.get("hours");
        System.out.println(hours);
        Long count = (Long) task.get("count");
        System.out.println(count);

        JSONObject type = (JSONObject) task.get("taskType");

       TaskType taskType=parseType((JSONObject)type);

        Task tmp = new Task(id,name,hours,count,taskType,block_id);

        tasks.add(tmp);
    }
    static private TaskType parseType(JSONObject type){


        String id = (String) type.get("id");
        System.out.println(id);


        String name = (String) type.get("name");
        System.out.println(name);

        String code = (String) type.get("code");
        System.out.println(name);
      TaskType tmp = new TaskType(id,name,code);
      return tmp;

    }



}
