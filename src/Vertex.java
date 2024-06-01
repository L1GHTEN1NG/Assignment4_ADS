public class Vertex <V>{ //класс для вершины
    private V data; //значения для вершины
    private Map<Vertex<V>, Double> adjacentVertices; //карта смежных вершин с их значениями

    public Vertex(V data) { //конструктор для класса
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    //сеттер для значения
    public void setData(V data){
        this.data = data;
    }
    //геттер для значения
    public V getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<V> dest, double weight) { //внесение значения в карту смежных вершин
        adjacentVertices.put(dest, weight);
    }

    //геттер для карты
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
