import java.util.Scanner;

public class Deposit {
    private float balance=0;
    private int pinCode;
    public void setPinCode(int pinCode){
        this.pinCode = pinCode;
    }
    public void add(float sum){
        balance+=sum;
    }
    public void getMoney(float sum) throws MyExeption {
        Scanner sc = new Scanner(System.in);
        int incorrect=0;
        while (true){
            System.out.print("Введите пин-код:");
            int pin = sc.nextInt();
            if(pin==pinCode){
                balance-=sum;
                break;
            }
            if(pin!=pinCode){
                incorrect++;
            }
            if(incorrect==3){
                throw new MyExeption();
            }
        }
        /*int pin = sc.nextInt();
        if(pin!=pinCode){
            throw new MyExeption();
        }
        balance-=sum;*/
    }
    public void printMyBalance(){
        System.out.print("Ваш баланс составляет:");
        System.out.println(balance);

    }
}
