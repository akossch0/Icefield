package Skeleton;



public class Skeleton {
    static int n;
    public static void Called(String FuncHeader){
        for (int i = 0;i<n;i++) System.out.print("\t");
        System.out.println(FuncHeader);
        n++;
    }
    public static void Return(){
        n--;
    }
}
