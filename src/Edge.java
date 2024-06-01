public class Edge <Vertex> extends Vertex { //класс ребра
    private Vertex source; //точка А (пункт выхода)
    private Vertex dest;  //точка В (пункт начначения)
    private Double weight; //определенное значение в ребре (то есть, его вес)

    public Edge (Vertex source, Vertex dest, Double weight){ //конструкто для класса
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex dest) { //тот же самый, только для ребер без значения
        this.source = source;
        this.dest = dest;
    }

    //сеттеры
    public void setSource(Vertex source){
        this.source = source;
    }

    public void setDest(Vertex dest){
        this.dest = dest;
    }

    public void setWeight(Double weight){
        this.weight = weight;
    }

    //геттеры
    public Vertex getSource() {
        return source;
    }

    public Vertex getDest() {
        return dest;
    }

    public Double getWeight() {
        return weight;
    }
}
