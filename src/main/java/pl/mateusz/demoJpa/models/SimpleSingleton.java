package pl.mateusz.demoJpa.models;

//Klasa singleton

public class SimpleSingleton {

    private static SimpleSingleton simpleSingleton = new SimpleSingleton();  //tworzymy prywatny obiekt klasy
    public static SimpleSingleton getInstance(){
        return simpleSingleton;             //zwraca singeton cały czas ten sam
    }

    int couinter;

    public int getCouinter() {
        return couinter;
    }

    public void setCouinter(int couinter) {
        this.couinter = couinter;
    }

    //blokada konstruktora
    private SimpleSingleton(){
        couinter=0;
    }

    public void incrementCounter(){
        couinter++;
    }


}
