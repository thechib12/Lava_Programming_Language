import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Rogier on 16-06-16 in Enschede.
 */
public class Sikkel {
    public static void main(String[] args) {
        double testD = 211.3513;
        String testS = Double.toString(testD);
        String[] test = testS.split(Pattern.quote("."));
        System.out.println(testS);
        System.out.println(test);
        int t1 = Integer.parseInt(test[0]);
        int t2 = Integer.parseInt(test[1]);
        System.out.println(t1);
        System.out.println(t2);

    }
}
