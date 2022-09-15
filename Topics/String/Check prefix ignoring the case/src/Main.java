import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        String word = scanner.next();
        System.out.println(word.toLowerCase().startsWith("j")? "true": "false");

    }
}