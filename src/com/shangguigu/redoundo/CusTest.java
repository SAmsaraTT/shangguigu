package com.shangguigu.redoundo;

import org.junit.jupiter.api.Test;

public class CusTest {
    @Test
    public void test() {
        String str = "12";


        CommandManager commandManager = new CommandManager();

        Command c1 = new CustomCommand("c1");

        Command c2 = new CustomCommand("c2");

        commandManager.executeCommand(c1);
        commandManager.executeCommand(c2);

        try {
            int num = Integer.parseInt(str);
            commandManager.undo();
            commandManager.undo();
            commandManager.redo();
            commandManager.redo();
            commandManager.redo();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
        }


    }


}
