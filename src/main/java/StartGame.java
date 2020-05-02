

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class StartGame {

    public static void getNum(Scanner scanner, String name) {
        List<Integer> wrongIntegers = new ArrayList<Integer>(5);
        List<Integer> rightIntegers = new ArrayList<Integer>(5);
        Random random = new Random();
        int i = 0;
        Instant startTime = Instant.now();
        while (i < 10) {

            int firstNum = random.nextInt(10);
            int secondNum = random.nextInt(10);
            if (i < 5) {
                int sum = firstNum + secondNum;
                System.out.print("\n" + firstNum + " + " + secondNum + " = ");
                int result = scanner.nextInt();
                if (sum != result) {
                    try {
                        throw new MathException("Wrong!");
                    } catch (MathException mathExeption) {
                        wrongIntegers.add(1);
                    }
                } else {
                    System.out.println("Right!");
                    rightIntegers.add(1);
                }

            } else {
                int minus = firstNum - secondNum;
                System.out.print("\n" + firstNum + " - " + secondNum + " = ");
                int result = scanner.nextInt();
                if (minus != result) {
                    try {
                        throw new MathException("Wrong!");
                    } catch (MathException mathExeption) {
                        wrongIntegers.add(1);
                    }
                } else {
                    rightIntegers.add(1);
                    System.out.println("Right!");
                }

            }

            i++;
        }
        Instant endTime = Instant.now();
        Duration timeElapsed = Duration.between(startTime, endTime);
        ResultGame resultGame=new ResultGame(name,timeElapsed.toMinutes()+":"+timeElapsed.toSeconds()%60 ,rightIntegers.size(),wrongIntegers.size());
        System.out.println(resultGame.toString());
        FileAction fileAction=new FileAction();
        try {
            fileAction.saveFile(resultGame.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
