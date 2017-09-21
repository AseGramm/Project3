public class Main {
    public static void main(String[] args){
        /*int []arr={1,3,8,2,-5};
        int imax=0;
        for (int i=1; i<arr.length; i++){
            if(arr[i]>arr[imax]){
                imax=i;
            }
        }
        System.out.print("Максимальное число ");
        System.out.println(arr[imax]);
        //arr[10]=20;
        try {
            int a=5/0;
            //arr[10]=20;
        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("Вы не можете обратиться к элементу с данным индексом "+e1.getMessage());
        }
        catch(Exception e){
            System.out.println("Error");
        }*/
        Deposit dep = new Deposit();
        dep.setPinCode(1234);
        dep.add(100.2f);
        try {
            dep.getMoney(30.1f);
            dep.printMyBalance();
        } catch (MyExeption e) {
            System.out.println(e.getError());
        }
    }
}
