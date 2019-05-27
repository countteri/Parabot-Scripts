package main.NewGuis;



import main.Actions.Action;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by SRH on 1/9/2018.
 */
public class NewActionGUI extends NewStatementGUI {
    public NewActionGUI(ArrayList<Action> actionList, Consumer<Integer> updateTextfield) {
        String[] actionTypes = new String[]{"Interact with", "Inventory item interact", "Use item on", "Type", "Click xy", "Sleep", "Send raw Action"};
        NewStatementGUI.Descriptions[] setDescs = {
                new Descriptions("Entity to interact with (eg. 4296 = banker)", "Option to select (eg. \"1\")"),
                new Descriptions("Item in your inventory to use (eg. 951 = \"Silk\")", "Option to select (eg. \"Sell 10\") (cAsE sEnSiTiVe)"),
                new Descriptions("Item in your inventory to use (eg. 999 = \"Bones\")", "Entity to use it on (eg. 999 = altar)<999 isn't actually altar>", "Item option to select (i.e. \"Use\") (cAsE sEnSiTiVe)"),
                new Descriptions("Text to type in (eg. 28)", "Hit enter? (0 for no, 1 for yes)"),
                new Descriptions("X coordinate to click (eg. 0)", "Y coordinate to click (eg. 600)", "Click type? (0 for left, 1 for right)"),
                new Descriptions("Amount of time to sleep (ms)"),
                new Descriptions("Action id", "Actions must be in format: \"action1; action2; action3; action4\""),
        };

        initGui("Add new action", actionList, updateTextfield, actionTypes, setDescs);
    }
}
