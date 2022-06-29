package command;

import java.util.ArrayList;
import java.util.HashMap;

public class CommandList {
    public CommandList() {
        addCommand("ping", new cmdPing());
    }
    private HashMap<String, Command> commands = new HashMap<>();

    public HashMap<String, Command> getCommands() {
        return commands;
    }
    public void addCommand(String commandName, Command c) {
        commands.put(commandName, c);
    }
    public boolean containsInvoke(String invoke) {
        return commands.containsKey(invoke);
    }

    public Command getCommand(String commandName) {
        if(!containsInvoke(commandName)) return null;
        return commands.get(commandName);
    }
}
