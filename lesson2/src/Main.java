import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //int a=sc.nextInt();
        //System.out.println(a*a);
        //float b=sc.nextFloat();
        //System.out.println(++b);
        /*int c=6;
        int d=++c;
        System.out.println(c);
        System.out.println(d);*/
        /*System.out.println("Введите год рождения:");
        int year=sc.nextInt();
        if(2017-year>=18)
            System.out.println("Пользователь совершеннолетний");
        else
            System.out.println("Пользователь не совершеннолетний");*/
        /*int i=10;
        while(i>0){
            System.out.println(i);
            i--;
        }
        do{
            System.out.println(i*2);
            i++;
        }
        while (i<5);*/
        /*for(int i=0;i<10;i++){
            if(i%3==0&&i!=0){
                System.out.println(i);
            }
        }*/
        /*int a=100,b=200;
        for(int i=a;i<=b;i++){
            if(i%5==0&&i%7==0){
                System.out.println(i);
                break;
            }
        }*/
        /*System.out.println("Введите номер месяца");
        int mounth=sc.nextInt();
        switch(mounth){
            case 1:
                System.out.println("Январь");
                break;
            case 2:
                System.out.println("Февраль");
                break;
            default:
                System.out.println("Не правильно");
        }*/
        System.out.print("Введите число:");
        int n=sc.nextInt();
        int fact=1;
        for(int i=n;i>0;i--){
            fact*=i;
        }
        System.out.println(fact);
    }
}
