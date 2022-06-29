package command;

import java.util.ArrayList;

public class cmdPing implements Command{
    @Override
    public boolean called(ArrayList<String> args, CommandAdapter adapter) {
        return true;
    }

    @Override
    public void action(ArrayList<String> args, CommandAdapter adapter) {
        adapter.sendMessage("Pong!", "ping");
    }

    @Override
    public void executed(boolean success, CommandAdapter adapter) {
        adapter.sendMessage("Ping used by NOTIMPLEMENTEDYET", "ping");
    }

    @Override
    public String help() {
        return "";
    }

    @Override
    public ArrayList<String> perms() {
        return new ArrayList<>();
    }
}
