package ru.job4j.tracker;

import ru.job4j.tracker.action.Create;
import ru.job4j.tracker.action.Delete;
import ru.job4j.tracker.action.Exit;
import ru.job4j.tracker.action.FindAll;
import ru.job4j.tracker.action.FindById;
import ru.job4j.tracker.action.FindByName;
import ru.job4j.tracker.action.Replace;
import ru.job4j.tracker.action.UserAction;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выбрать: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Неверный ввод, вы можете выбрать: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Меню:");
        for (UserAction action : actions) {
            output.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Create(output));
        actions.add(new FindAll(output));
        actions.add(new Replace(output));
        actions.add(new Delete(output));
        actions.add(new FindById(output));
        actions.add(new FindByName(output));
        actions.add(new Exit(output));
        new StartUI(output).init(input, tracker, actions);
    }
}
