import java.util.*;

class DigitGraph {
    // Хранилище графа: ключ - вершина (цифра), значение - список смежных вершин
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    
    /**
     * Добавляет ребро между двумя вершинами-цифрами
     * @param from начальная вершина
     * @param to конечная вершина
     */
    public void addEdge(int from, int to) {
        // Добавляем 'to' в список соседей 'from'
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        // Добавляем 'from' в список соседей 'to' (неориентированный граф)
        graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
    }
    
    /**
     * Отображает все вершины и их связи
     */
    public void displayGraph() {
        System.out.println("Структура графа:");
        // Проходим по всем вершинам графа
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            // Выводим всех соседей текущей вершины
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Проверяет существует ли ребро между двумя вершинами
     */
    public boolean hasEdge(int from, int to) {
        return graph.containsKey(from) && graph.get(from).contains(to);
    }
    
    public static void main(String[] args) {
        DigitGraph graph = new DigitGraph();
        
        // Создаем граф с цифровыми вершинами
        graph.addEdge(1, 2);  // Ребро между 1 и 2
        graph.addEdge(1, 3);  // Ребро между 1 и 3
        graph.addEdge(2, 4);  // Ребро между 2 и 4
        graph.addEdge(3, 5);  // Ребро между 3 и 5
        graph.addEdge(4, 5);  // Ребро между 4 и 5
        graph.addEdge(2, 5);  // Ребро между 2 и 5
        
        // Отображаем структуру графа
        graph.displayGraph();
        
        // Проверяем наличие рёбер
        System.out.println("\nПроверка рёбер:");
        System.out.println("Есть ребро 1-2? " + graph.hasEdge(1, 2));
        System.out.println("Есть ребро 1-4? " + graph.hasEdge(1, 4));
    }
}