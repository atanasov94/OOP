package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import javax.naming.OperationNotSupportedException;

public class Retire extends Command{
    public Retire(String[] data, Repository repository, UnitFactory factory) {
        super(data, repository, factory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String type = this.getData()[1];
        String result;
        try {
            this.getRepository().removeUnit(type);
            result = type + " retired!";
        } catch (OperationNotSupportedException e) {
            result = e.getMessage();
        }
        return result;
    }
}
