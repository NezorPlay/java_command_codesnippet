package command;

import java.util.ArrayList;
import java.util.List;

public class CommandContainer {
    private String raw;
    private String beheaded;
    private ArrayList<String> splitBeheaded;
    private String invoke;
    private ArrayList<String> args;

    //#### CHANGE TO A CONFIG FILE
    public static String PREFIX = "~";


    CommandContainer(String raw, String beheaded, ArrayList<String> splitBeheaded, String invoke, ArrayList<String> args) {
        this.raw = raw;
        this.beheaded = beheaded;
        this.splitBeheaded = splitBeheaded;
        this.invoke = invoke;
        this.args = args;
    }


    public static CommandContainer parse(String raw) {
        String beheaded = raw.replace(PREFIX, "");
        String[] splitBeheaded = beheaded.split(" ");
        String invoke = splitBeheaded[0];
        ArrayList<String> split = new ArrayList<>();
        for (String arg : splitBeheaded) {
            split.add(arg);
        }
        split.remove(0);
        return new CommandContainer(raw, beheaded, new ArrayList<>(List.of(splitBeheaded)), invoke, split);
    }

    public static void handleCommand(CommandContainer cmdCont, CommandAdapter adapter) {
        Command command = new CommandList().getCommand(cmdCont.invoke);
        if (command != null) {
            boolean safe = command.called(cmdCont.args, adapter);

            if (safe) {
                command.action(cmdCont.args, adapter);
                command.executed(safe, adapter);
            } else {
                command.executed(safe, adapter);
            }
        } else {
            //if (config.DEBUG_LEVEL == 2) {
            adapter.sendMessage("Command " + cmdCont.invoke + " not found!", "Error");
            //}
        }
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public String getBeheaded() {
        return beheaded;
    }

    public String getInvoke() {
        return invoke;
    }

    public ArrayList<String> getSplitBeheaded() {
        return splitBeheaded;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    public String getRaw() {
        return raw;
    }
}
