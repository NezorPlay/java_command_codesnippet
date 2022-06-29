package command;

import static command.CommandContainer.handleCommand;
import static command.CommandContainer.parse;

public class ConsoleAdapter implements CommandAdapter{
    @Override
    public void resolveCommand(String command) {
        handleCommand(parse(command), this);
    }

    @Override
    public void sendMessage(String message, String command) {
        System.out.println("Nezora > console > " + command + "> " + message);
    }
}
