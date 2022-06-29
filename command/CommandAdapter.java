package command;

public interface CommandAdapter {
    void resolveCommand(String command);
    void sendMessage(String message, String command);
}
