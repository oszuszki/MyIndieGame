package saveData;

import appearance.MapBuilding;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteInJson {
    public static void saveData() {
        JSONObject lvlCounter = new JSONObject();
        lvlCounter.put("level", MapBuilding.getLvlCounter());

        try (FileWriter file = new FileWriter("src/main/resources/playerData.json")) {
            file.write(lvlCounter.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + lvlCounter);
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public static int readLvl(){
        String path = "src/main/resources/playerData.json";
        int level = 0;
        try {
            String contents = new String((Files.readAllBytes(Paths.get(path))));
            JSONObject obj = new JSONObject(contents);
            level = obj.getInt("level");
            System.out.println(level);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return level;
    }
}
