import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {//8193
    public static int k=0;

    public  static synchronized void doSome(int d){
        k+=d;
    }

    public static void main(String[] args) throws InterruptedException {
        /*long t=System.currentTimeMillis();
        MyThread mt=new MyThread();
        MyThread2 mt2=new MyThread2();
        mt.start();
        mt2.start();
        mt.join();
        mt2.join();
        long dt=System.currentTimeMillis()-t;
        System.out.println(dt);*/


        /*Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    doSome(1);
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    doSome(-1);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(k);*/


        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());//Время с 01.01.1970
        d.setTime(123);//Устанавливает новое время
        System.out.println(d);
        Date d2 = new Date();
        if(d2.before(d)){
            System.out.println("d2<d");
        }
        else {
            System.out.println("d2>=d");
        }
        SimpleDateFormat format = new SimpleDateFormat("'Today:'dd.MM.EEE");//Форматирование вывода даты
        System.out.println(format.format(d2));


        Calendar c = Calendar.getInstance();//Текущая дата
        System.out.println(c.getTime());
        c.add(Calendar.MONTH,2);//Добавить
        System.out.println(c.getTime());
        c.set(Calendar.MONTH,8);//Ввести
        System.out.println(c.getTime());
        c.set(Calendar.DAY_OF_WEEK,12);
        System.out.println(c.getTime());
        int year = c.get(Calendar.YEAR);//Получить
        System.out.println(year);

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR,1960);
        if(gc.isLeapYear(1960)){
            System.out.println("Год весокосный");
        }
        else{
            System.out.println("Год не весокосный");
        }
    }
}
