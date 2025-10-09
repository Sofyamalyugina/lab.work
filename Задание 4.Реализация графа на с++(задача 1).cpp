#include <iostream>
#include <vector>
using namespace std;

class Graph {
    vector<vector<int>> adj;  // Список смежности
public:
    Graph(int n) : adj(n) {}  // Конструктор с количеством вершин
    
    void addEdge(int u, int v) {  // Добавление ребра
        adj[u].push_back(v);      // u -> v
        adj[v].push_back(u);      // v -> u (неориентированный)
    }
    
    void print() {  // Вывод графа
        for(int i = 0; i < adj.size(); i++) {
            cout << "Вершина " << i << " соединена с: ";
            for(int neighbor : adj[i]) 
                cout << neighbor << " ";
            cout << endl;
        }
    }
};

int main() {
    Graph g(4);           // Граф с 4 вершинами
    g.addEdge(0, 1);      // Ребро 0-1
    g.addEdge(0, 2);      // Ребро 0-2
    g.addEdge(1, 3);      // Ребро 1-3
    g.addEdge(2, 3);      // Ребро 2-3
    g.print();            // Вывод структуры
    return 0;
}
