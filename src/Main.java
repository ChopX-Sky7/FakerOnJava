import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = Generator.crutch();

        for (String elem : arr) {
            System.out.printf("\"" + elem + "\", ");
        }
    }
}
