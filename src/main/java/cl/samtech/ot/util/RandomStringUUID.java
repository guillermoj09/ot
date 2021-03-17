package cl.samtech.ot.util;
import java.util.UUID;

public class RandomStringUUID {
	
    public static String obetenerUID() {

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();       
        return randomUUIDString;
    }
    
    
}