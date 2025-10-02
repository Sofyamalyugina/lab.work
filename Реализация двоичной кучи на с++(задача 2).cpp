#include <iostream>
#include <queue>
#include <vector>
#include <unordered_map>
using namespace std;

int main() {
    vector<int> digits = {1, 3, 5, 3, 7, 1, 3, 5, 1, 3, 7, 1, 5};
    int k = 3;
    
    unordered_map<int, int> freq;
    for (int digit : digits) {
        freq[digit]++;
    }
    
    priority_queue<pair<int, int>> heap;
    for (auto& [digit, count] : freq) {
        heap.push({count, digit});
    }
    
    cout << "Топ-" << k << " частых цифр: ";
    for (int i = 0; i < k && !heap.empty(); i++) {
        auto [count, digit] = heap.top();
        heap.pop();
        cout << digit << "(" << count << " раз) ";
    }
    
    return 0;
}
