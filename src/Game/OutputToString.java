package Game;

import java.util.HashMap;

public interface OutputToString {
    /**
     * kimeneti nyelv miatt szukseges
     * @param objects a hashmap ami tarolja az objektum-id-kat es a hozza tartozo objektumokat
     * @return
     */
    public String toString(HashMap<String,Object> objects);
}
