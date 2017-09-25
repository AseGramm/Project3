public class Cleaner implements IWorker {

    @Override
    public void goToWork() {
        System.out.println("Cleaner приехал на работу в 9:00");
    }

    @Override
    public void pay() {
        System.out.println("Cleaner зачисленно 500");
    }
}
