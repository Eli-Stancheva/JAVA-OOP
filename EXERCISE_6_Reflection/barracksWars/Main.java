package OOP.EXERCISE_6_Reflection.barracksWars;

import OOP.EXERCISE_6_Reflection.barracksWars.interfaces.Repository;
import OOP.EXERCISE_6_Reflection.barracksWars.interfaces.Runnable;
import OOP.EXERCISE_6_Reflection.barracksWars.interfaces.UnitFactory;
import OOP.EXERCISE_6_Reflection.barracksWars.core.Engine;
import OOP.EXERCISE_6_Reflection.barracksWars.core.factories.UnitFactoryImpl;
import OOP.EXERCISE_6_Reflection.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
