package model;

public class Editura {
    private int id;
    private String denumire;
    private Data dataInfiintare;

    public Editura(int id, String denumire, Data dataInfiintare) {
        this.id = id;
        this.denumire = denumire;
        this.dataInfiintare = dataInfiintare;
    }

    public String getDenumire() {
        return denumire;
    }

    public Data getDataInfiintare() {
        return dataInfiintare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Editura{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", dataInfiintare=" + dataInfiintare +
                '}';
    }
}
