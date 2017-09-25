public class Boss implements IWorker {

    @Override
    public void goToWork() {
        System.out.println("Boss приехал на работу в 12:00");
    }

    @Override
    public void pay() {
        System.out.println("Boss зачисленно 1000");
    }
}
