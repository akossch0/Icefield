package Game;

import java.util.HashMap;

/**
 * A kimeneti nyelv miatt szukseges interfesz
 */
public interface OutputToString {
    /**
     *
     * @param objects a hashmap ami tarolja az objektum-id-kat es a hozza tartozo objektumokat
     * @return
     */
    public String toString(HashMap<String,Object> objects);
}
