package example.enumeration;

public enum Tranportation {
    
    BUS(100) { public int fare(int distance) { return distance * BASIC_FARE; }},
    TRAIN(150) { public int fare(int distance) { return distance * BASIC_FARE; }},
    SHIP(100) { public int fare(int distance) { return distance * BASIC_FARE; }},
    AIRPLANE(300) { public int fare(int distance) { return distance * BASIC_FARE; }};

    protected final int BASIC_FARE;

    // priavte만 가능하다.
    private Tranportation(int basicFare){
        BASIC_FARE = basicFare;
    }

    public int getBasicFare() { return BASIC_FARE; }

    public abstract int fare(int distance);
}
