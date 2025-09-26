import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Исходный список
        List<String> originalList = new ArrayList<>();
        originalList.add("a");
        originalList.add("1");
        originalList.add("b");
        originalList.add("2");
        originalList.add("c");
        originalList.add("3");
        
        // Списки для букв и чисел
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        
        // Разделение элементов
        for (String item : originalList) {
            if (item.matches("[a-zA-Z]")) {
                letters.add(item);
            } else if (item.matches("\\d")) {
                numbers.add(item);
            }
        }
        
        // Удаление исходного списка
        originalList.clear();
        originalList = null; // Помечаем для сборщика мусора
        
        // Вывод результатов
        System.out.println(letters);
        System.out.println(numbers);
    }
}