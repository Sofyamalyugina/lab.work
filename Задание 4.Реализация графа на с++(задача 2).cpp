#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Graph {
    unordered_map<char, vector<char>> adj;  // Граф: буква -> соседи
    
public:
    void addEdge(char u, char v) {  // Добавить ребро между буквами
        adj[u].push_back(v);
        adj[v].push_back(u);  // Неориентированный граф
    }
    
    void printGraph() {  // Вывести связи между буквами
        for (auto& [vertex, neighbors] : adj) {
            cout << vertex << " -> ";
            for (char n : neighbors) cout << n << " ";
            cout << endl;
        }
    }
};

int main() {
    Graph g;
    g.addEdge('A', 'B');  // A связан с B
    g.addEdge('A', 'C');  // A связан с C
    g.addEdge('B', 'D');  // B связан с D
    g.addEdge('C', 'D');  // C связан с D
    
    g.printGraph();
    return 0;
}