import java.util.Scanner;
import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(String.valueOf(--a)).add(String.valueOf(--b)).add(String.valueOf(--c)).add(String.valueOf(--d));
        System.out.println(joiner);
    }
}
