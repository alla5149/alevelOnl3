package com.zhmaka.action;

public enum Actions {
    CREATE("Create cars", new CreateAction()),
    COMPARE("Compare cars", new CompareAction()),
    SHOW_ALL("Show all cars", new ShowAllAction()),
    OPTIONAL("Examples of Optional", new OptionalAction()),
    EXIT("Finish program", new ExitAction());

    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
    }

    public void execute() {
        action.execute();
    }
}
