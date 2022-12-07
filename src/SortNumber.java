import java.util.Random;

public class SortNumber {
    public static boolean isNumber(int num) {
        
        if (num == getSortedNumber()) {
            return true;
        } 
            
        return false;
        
    }

    public static int getSortedNumber() {

        Random random = new Random();
        int number = random.nextInt(-1,100);

        return number;
    }
}
