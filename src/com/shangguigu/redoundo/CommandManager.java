package com.shangguigu.redoundo;

import java.util.Stack;

public class CommandManager {

    private Stack<Command> redoStk = new Stack<>();
    private Stack<Command> undoStk = new Stack<>();

    public CommandManager() {

    }

    public void executeCommand(Command command) {
        command.execute();
        undoStk.push(command);

        if (!redoStk.isEmpty()) {
            redoStk.clear();
        }
    }

    public void undo() throws Exception{
        if (undoStk.isEmpty()) {
            throw new Exception("cannot undo!");
        }
        Command command = undoStk.pop();

        command.undo();

        redoStk.push(command);
    }

    public void redo() throws Exception{
        if (redoStk.isEmpty()) {
            throw new Exception("cannot redo!");
        }

        Command command = redoStk.pop();

        command.execute();

    }

}
