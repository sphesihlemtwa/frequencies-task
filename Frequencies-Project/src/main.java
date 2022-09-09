import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class main {

    public static void main(String[] args) {
        //read txt file line by line ignore first line...
        Map<String, Coordinate> map = new HashMap<String, Coordinate>();
        try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8))){

            String line;
            int iteration=0;
            while((line=br.readLine())!=null){
                if(iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] split=line.split(",");
                //make cell ID the key of the hash map, create new coordinates object and add it as a value in the hash map
                map.put(split[0],new Coordinate(Integer.parseInt(split[1]),Integer.parseInt(split[2]),Double.parseDouble(split[3]),Double.parseDouble(split[4])));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*output the hashmap
        for (Map.Entry<String, Coordinate> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getEasting()+ " " +entry.getValue().getNorthing()+" "+entry.getValue().getLongitude()+" "+entry.getValue().getLatitude());
        }*/

        //iterate through hashmap and calculate distance between the current cell and the other objects
        Map<String, MinMax> minMaxMap = new HashMap<String, MinMax>(); //create new hashmap that will store the minimum and max distances
        for(Map.Entry<String, Coordinate> entry1: map.entrySet()) {
            String key1 = entry1.getKey();
            double min = -1;
            double max = -1;
            Coordinate value1 = entry1.getValue();
            for(Map.Entry<String, Coordinate> entry2: map.entrySet()) {
                String key2 = entry2.getKey();
                if (!key1.equals(key2)) continue;

                Coordinate value2 = entry2.getValue();
                // compare value1 and value2;
                //calculate distance between value1 and value2
                double distance = value1.calculateDistance(value2);
                //This case is for the first iteration is the loop
                if(min ==-1&& max==-1){
                    min = distance;
                    max = distance;
                }
                if(distance > max){
                    max=distance;
                }
                else if(distance < min){
                    min = distance;
                }


            }
            minMaxMap.put(key1,new MinMax(min,max));
        }
        //output min max map
        for (Map.Entry<String, MinMax> entry : minMaxMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getMin() + " " + entry.getValue().getMax());
        }
        
        //allocate frequencies

        //create graphs
    }


}
