import java.util.*;

class TopKLetters {
    public static void main(String[] args) {
        String text = "программирование это интересно и увлекательно";
        int k = 3;
        
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> heap = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        heap.addAll(freq.entrySet());
        
        System.out.print("Топ-" + k + " частых букв: ");
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            Map.Entry<Character, Integer> entry = heap.poll();
            System.out.print(entry.getKey() + "(" + entry.getValue() + ") ");
        }
    }
}
