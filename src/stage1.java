import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class stage1 {
    public static int[] numbers;
    public static int sum;
    public static int n;
    public static double score;
    public static int nbSolutions = 0;
    public static List<String> userSolutions = new ArrayList<>();
    public static List<String> solutions = new ArrayList<>();

    public static void generateNumbers(){
        Scanner s = new Scanner(System.in);
        System.out.println("donner n :");
        n = s.nextInt();
        numbers = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = rand.nextInt(100);
        }
        sum = 40+rand.nextInt(60);

        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i]+" ");
        }
        System.out.println("");
        System.out.println("somme = "+sum);
    }



    public static void subSum(int list[], int sum, int start, int target, String result) {
        if( target == sum )
        {
            nbSolutions++;
            result = result.substring(0,result.length()-1);
            String tab[] = result.split("-");
            solutions.add(extractSolution(tab));
            if(start < list.length)
                result = "";
            subSum(list, sum - list[start-1], start, target,result);
        }
        else
        {
            for( int i = start; i < list.length; i++ )
            {
                result = result +start+"-";
                subSum(list, sum + list[i], i + 1, target,result);
            }
        }
    }


    public static String extractSolution(String tab[]){
        List<Integer> solution = new ArrayList<Integer>();
        String result="";

        for (int i = 0; i < tab.length; i++)
            solution.add(Integer.parseInt(tab[i]));

        solution.add(null);

        int index = solution.get(0);
        for (int i = 0; i < solution.size()-1; i++) {
            if (i < solution.size()-1){
                if (solution.get(i) == solution.get(i+1)){
                    index++;
                }else {
                    result += numbers[index] + "-";
                    if (i < solution.size() -2){
                        index = solution.get(i+1);
                    }
                }
            }
        }
        result = result.substring(0,result.length()-1);
        return result;
    }

    public static void calculScore(){
        score = (nbRightSolution() / nbSolutions) * 100;
        score = score - (nbWrongSolution() * 5);
    }

    public static int nbRightSolution(){
        int nb=0;
        for (int i = 0; i < userSolutions.size(); i++) {
            if (solutions.contains(userSolutions.get(i))){
                nb++;
            }
        }
        return nb;
    }

    public static int nbWrongSolution(){
        int nb=0;
        for (int i = 0; i < userSolutions.size(); i++) {
            if (! solutions.contains(userSolutions.get(i))){
                nb++;
            }
        }
        return nb;
    }

    public static void showSolutions(){
        for (int i = 0; i < solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
    }
}
