import java.util.*;

class LetterSorter {
    public static void main(String[] args) {
        String word = "программирование";
        int k = 5;
        
        PriorityQueue<Character> heap = new PriorityQueue<>();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                heap.offer(c);
            }
        }
        
        System.out.print("Первые " + k + " букв по алфавиту: ");
        for (int i = 0; i < k && !heap.isEmpty(); i++) {
            System.out.print(heap.poll() + " ");
        }
    }
}
