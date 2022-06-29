package command;

import java.util.ArrayList;
import java.util.List;

public interface Command {
        boolean called(ArrayList<String> args, CommandAdapter adapter);
        void action(ArrayList<String> args, CommandAdapter adapter);
        void executed(boolean success, CommandAdapter adapter);
        String help();
        ArrayList<String> perms();
}


