package main.Actions.Logic;

import main.Actions.Action;
import main.VarsMethods;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;

import static main.VarsMethods.log;

public class LogicHandler {
    public String determineIf(Action a) {
        switch (a.getAction().replaceAll("-", " "))
        {
            case "Item is in Inventory":
                return Inventory.getCount(VarsMethods.parsePint(a.getParam0())) >= (a.getParam1().equals("") ? 0 : VarsMethods.parsePint(a.getParam1())) ? "True" : "False";
            case "Entity is around":
                return Npcs.getClosest(VarsMethods.parsePint(a.getParam0())) != null ||
                        SceneObjects.getClosest(VarsMethods.parsePint(a.getParam0())) != null ? "True" : "False";
            case "Hitpoints is below":
                return Players.getMyPlayer().getHealth() < VarsMethods.parsePint(a.getParam0()) ? "True" : "False";
            default:
                log("Error: Unimplemented conditional: " + a.getAction());
        }
        return "False";
    }

    public String determineInverseIf(Action a) {
        return determineIf(a).equals("True") ? "False" : "True";
    }
}
