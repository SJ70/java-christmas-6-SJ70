package christmas.view;

public class ConsoleOutput implements Output {

    @Override
    public void display(String string) {
        System.out.println(string);
    }

}
