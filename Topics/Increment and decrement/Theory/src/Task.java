// You can experiment here, it won’t be checked

import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int d = scanner.nextInt();

    StringBuilder sb = new StringBuilder();
    sb.append(a--).append(b--).append(c--).append(d--);
    System.out.println(sb);


  }
}
