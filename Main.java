import command.CommandAdapter;
import command.ConsoleAdapter;

public class Main {
    public static void main(String[] args){
        CommandAdapter test = new ConsoleAdapter();
        test.resolveCommand("~ping");
    }
}