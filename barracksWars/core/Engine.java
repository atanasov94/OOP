package barracksWars.core;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private static final String COMMAND_PACKAGE = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        String result;

		String command = getCorrectClassName(data[0]);
		try {
			Class clazz = Class.forName(COMMAND_PACKAGE + command);
			Constructor declaredConstructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			Executable instance = (Executable) declaredConstructor.newInstance(data, this.repository, this.unitFactory);

			result = instance.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();

			result = "Invalid Command!";
		}

		return result;
    }

	private String getCorrectClassName(String name) {
    	StringBuilder builder = new StringBuilder();
			builder.append(Character.toUpperCase(name.charAt(0)));
			builder.append(name.substring(1));
			return builder.toString();
	}
}
