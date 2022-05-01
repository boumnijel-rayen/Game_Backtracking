import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class gameApp {
    public static void main(String[] args) {
        stage1.generateNumbers();
        stage1.subSum(stage1.numbers,0,0,stage1.sum,"");
        stage1.showSolutions();

        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        Boolean continuee=true;
        while (continuee){
            System.out.println("donner un solution :");
            String solution = s.next();
            stage1.userSolutions.add(solution);
            System.out.println("vous avez d'autres solutions ? (True or False)");
            continuee = s.nextBoolean();
        }
        long end = System.currentTimeMillis();

        int time =(int) TimeUnit.MILLISECONDS.toSeconds(end-start);

        if (time > 90){
            System.out.println("vous avez dépassé le temps");
        }else{
            stage1.calculScore();
            System.out.println(stage1.score);
        }
    }
}
