package andrealm.td7_exercice2;

public class Meteo {


    private String pays;
    private String temperature;
    private String leverSoleil;
    private String coucherSoleil;
    private String condition;


    public Meteo(String pays, String temperature, String leverSoleil, String coucherSoleil, String condition) {
        this.pays = pays;
        this.temperature = temperature;
        this.leverSoleil = leverSoleil;
        this.coucherSoleil = coucherSoleil;
        this.condition = condition;
    }


    public String getCoucherSoleil() {
        return coucherSoleil;
    }

    public String getCondition() {
        return condition;
    }

    public String getLeverSoleil() {
        return leverSoleil;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPays() {
        return pays;
    }
}