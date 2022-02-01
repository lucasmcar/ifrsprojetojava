package cde.util;

import java.util.Random;

public class RandomIdUtil {
    
    private static final Random rnd = new Random();
    
    public static double generateRandomId(int min, int max)
    {
        return rnd.nextInt(max - min + 1) + min;
    }
    
    
}
