package sparkexample;

import static spark.Spark.get;
import static spark.Spark.port;
import com.google.gson.Gson;
import java.util.HashMap;

public class Service {

    public static void main(String[] args) {
        port(80);
        get("/", "application/json", (req, res) -> {
            HashMap<String,Object> result = new HashMap<String,Object>();
            
            DiceRoller roller = new ServiceDiceRoller();
                
            result.put( "message", roller.roll());
            return new Gson().toJson(result);
        });
    }
}
