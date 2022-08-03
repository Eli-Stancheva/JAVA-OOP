package OOP.LAB_4_InterfacesAndAbstraction.P2_CarShopExtended;

public interface Car {
    Integer TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
