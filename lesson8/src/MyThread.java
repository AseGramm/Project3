public class MyThread extends Thread {
    @Override
    public void run(){
        for(int i=0;i<5000000;i++){
            double d=Math.sin(i)*Math.tan(i*2)-Math.sqrt(i/2);
        }
    }
}
