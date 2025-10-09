import java.util.*;

class LetterGraph {
    private Map<Character, List<Character>> graph = new HashMap<>();
    
    // Добавить ребро между двумя буквами
    public void addEdge(char from, char to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from); // Неориентированный
    }
    
    // Показать все связи графа
    public void showConnections() {
        for (char vertex : graph.keySet()) {
            System.out.print(vertex + " -> ");
            for (char neighbor : graph.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        LetterGraph g = new LetterGraph();
        g.addEdge('A', 'B'); // Создаем рёбра
        g.addEdge('A', 'C');
        g.addEdge('B', 'D');
        g.addEdge('C', 'E');
        g.addEdge('D', 'E');
        g.showConnections(); // Показываем связи
    }
}