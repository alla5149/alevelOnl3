package com.zhmaka.action;

public class ExitAction implements Action{
    @Override
    public void execute() {
        System.out.println("Program is ended");
        System.exit(0);
    }

}
