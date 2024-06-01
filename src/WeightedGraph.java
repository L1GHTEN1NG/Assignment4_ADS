import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class WeightedGraph <V>{
    private final Map<Vertex<V>, List<Edge<Vertex<V>>>> map = new HashMap<>();

    public boolean existVertex(Vertex<V> vertex) { //проверяет имеется ли у на вершина
        return map.containsKey(vertex); //добавляет сравнение в дальнейшие методы класса, а там они уже проверяют его наличие
    }

    public boolean existEdge(Vertex<V> source, Vertex<V> dest) { //проверяет имеется ли ребро
        if (!existVertex(source)) return false; //для начала проверяет имеется ли вектор с начальной точкой

        return map.get(source).contains(new Edge<>(source, dest)); //а потом уже проверяет есть ли ребро с токами от А до В
    }

    public void addVertex(Vertex<V> vertex) { //метод для добавления вершины
        if (!existVertex(vertex)) { //опять же, как я писал выше, берет метод existVertex и сравнивает его
            map.put(vertex, new ArrayList<>()); //если имеется, то добавляет новую вершину
        }
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {  //метод для добавления ребра
        if (!existVertex(source)) { //если имеется вершина
            addVertex(source); //добавляет точку А
        }

        if (!existVertex(dest)) { //если имеется вершина
            addVertex(dest); //добавляет точку В
        }

        map.get(source).add(new Edge<>(source, dest, weight)); //тут он уже добавляет ребро с А, В и весом
    }

    public int numberOfVertices() { //метод для вывода количества вершин
        return map.size(); //достаточно просто вывести размер карты смежных вершин
    }

    public int numberOfEdges() { //метод для вывода количества граней
        int count = 0; //создадем наш каунтер граней
        for (List<Edge<Vertex<V>>> edges : map.values()) { //из листа с гранями под значения карты
            count += edges.size(); //поочередно добавляем значение в наш каунтер
        }
        return count; //выводим
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> v) { //создаем лист смежных
        if (!existVertex(v)){ //проверяем наличие вершины
            return null;
        }

        List<Vertex<V>> vertices = new ArrayList<>(); //создаем новый лист вершин
        for (Edge<Vertex<V>> E : map.get(v)) { //из листа границ
            vertices.add(E.getDest()); //добавляем дестинейшн
        }

        return vertices; //выводим вершины
    }

    public Map<Vertex<V>, List<Edge<Vertex<V>>>> getAdjacentVertices() { //возвращает карту со смежными вершинами
        return map;
    }
}
