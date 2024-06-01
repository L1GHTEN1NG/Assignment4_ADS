import java.util.*;

public class Search<V> {
    protected WeightedGraph<V> graph; //Создаем граф весов
    protected Set<Vertex<V>> visited; //Создаем сет посещенных точек
    protected Map<Vertex<V>, Vertex<V>> edgeWay; //Создаем карту границ от одной к другой
    protected final Vertex<V> source; //Создаем пункт В

    public Search(WeightedGraph<V> graph, Vertex<V> source) { //констурктор класса
        this.graph = graph;
        this.source = source;
        visited = new HashSet<>();
        edgeWay = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<V> v) { //метод проверки имеется ли у нас путь от одной вершинвы к другой
        return visited.contains(v);
    }

    public Iterable<Vertex<V>> pathTo(Vertex<V> v) { //создаем путь
        if (!hasPathTo(v)){ //проверяет есть ли путь
            return null;
        }

        LinkedList<Vertex<V>> path = new LinkedList<>(); // создаем новый лист вершин
        for (Vertex<V> i = v; i != source; i = edgeWay.get(i)) { //проверяем вершины на пути
            path.push(i); //добавляем в общий путь
        }

        path.push(source); //добавляем наш пункт

        return path; //возвращаем путь
    }
}
