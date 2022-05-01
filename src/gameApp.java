public class gameApp {
    public static void main(String[] args) {
        stage1.generateNumbers();
        stage1.subSum(stage1.numbers,0,0,stage1.sum,"");
        stage1.showSolutions();
        System.out.println(stage1.nbSolutions);
    }
}
