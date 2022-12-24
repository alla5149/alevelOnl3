package com.zhmaka.action;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Actions {
    CREATE("Create cars", new CreateAction()),
    COMPARE("Compare cars", new CompareAction()),
    SHOW_ALL("Show all cars", new ShowAllAction()),
    EXIT("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public static String[] mapActionToName(Actions[] values) {
        String[] names = Arrays.stream(Actions.values())
                .map(x -> x.getName())
                .toArray(String[]::new);
        return names;
    }
    public boolean execute(){
        if(action==null){
            return false;
        }
        action.execute();
        return true;
    }

}
