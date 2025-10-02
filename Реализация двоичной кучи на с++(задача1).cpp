#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct Element {
    int value;      // цифра
    int arrayIndex; // индекс массива
    int elemIndex;  // индекс элемента в массиве
    
    bool operator>(const Element& other) const {
        return value > other.value;
    }
};

vector<int> mergeSortedArrays(const vector<vector<int>>& arrays) {
    priority_queue<Element, vector<Element>, greater<Element>> minHeap;
    vector<int> result;
    
    // Добавляем первые элементы каждого массива в кучу
    for (int i = 0; i < arrays.size(); i++) {
        if (!arrays[i].empty()) {
            minHeap.push({arrays[i][0], i, 0});
        }
    }
    
    // Извлекаем минимальные элементы и добавляем следующие
    while (!minHeap.empty()) {
        Element current = minHeap.top();
        minHeap.pop();
        result.push_back(current.value);
        
        // Добавляем следующий элемент из того же массива
        if (current.elemIndex + 1 < arrays[current.arrayIndex].size()) {
            minHeap.push({
                arrays[current.arrayIndex][current.elemIndex + 1],
                current.arrayIndex,
                current.elemIndex + 1
            });
        }
    }
    
    return result;
}

int main() {
    vector<vector<int>> arrays = {
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9}
    };
    
    vector<int> merged = mergeSortedArrays(arrays);
    
    cout << "Объединенный массив: ";
    for (int num : merged) {
        cout << num << " ";
    }
    cout << endl;
    
    return 0;
}
