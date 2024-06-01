import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {
    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> source) { //констурктор класса
        super(graph, source); //наследствует классы от серч
    }

    public void execute() {
        Queue<Vertex<V>> queue = new LinkedList<>(); //создаем очередь для бфс
        queue.add(source); //добавляем туда сорс
        visited.add(source); //добавляем сорс в сет посещенных точек

        while (!queue.isEmpty()) {  //проверяет не пустая ли очередь
            Vertex<V> currentVertex = queue.poll(); //очередь получает значение точки
            for (Vertex<V> edge : graph.adjacencyList(currentVertex)) {
                Edge<V> neighbor = edge.getDest(); //проходится по точкам и находит соседние
                if (!visited.contains(neighbor)) { //если нашлась соседняя
                    visited.add(neighbor); //добавляем в сет пройденных точек
                    edgeWay.put(neighbor, currentVertex); //также добавляем значение пути
                    queue.add(neighbor); //добавляем в нашу очередь бфс
                }
            }
        }
    }
}
