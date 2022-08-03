package OOP.LAB_4_InterfacesAndAbstraction.P2_CarShopExtended;

public interface Rentable extends Car {
    Integer getMinRentDay();
    Double getPricePerDay();
}
