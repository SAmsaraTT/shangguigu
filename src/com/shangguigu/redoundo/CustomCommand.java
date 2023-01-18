package com.shangguigu.redoundo;


public class CustomCommand implements Command {
    private String name;

    public CustomCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("The " + name + " have been executed!");
    }

    @Override
    public void undo() {
        System.out.println("The " + name + " have been revoked!");
    }
}
