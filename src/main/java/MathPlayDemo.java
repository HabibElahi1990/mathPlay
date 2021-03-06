import java.util.Scanner;

public class MathPlayDemo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your name: ");
        String name=scanner.nextLine();
        String ans="y";
        while (ans.equals("y")) {
            System.out.println("please select (1 or 2 or 3 ): \n 1-start game \n 2-show grades \n 3-exit");
            int result = scanner.nextInt();
            switch (result) {
                case 1:
                    System.out.println("start game");
                    StartGame.getNum(scanner, name);
                    break;
                case 2:
                    System.out.println("show grades");
                    ShowGrades.showGrades(name);
                    break;
                case 3:
                default:
                    System.exit(0);
                    break;
            }

            System.out.println("are you play again? y/n");
            ans=scanner.next();
        };
    }
}
