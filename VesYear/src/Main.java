import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите год:");
        int year=sc.nextInt();
        if((year%4==0&&year%100!=0)||(year%400==0))
            System.out.println("Год високосный");
        else
            System.out.println("Год не високосный");
    }
}
