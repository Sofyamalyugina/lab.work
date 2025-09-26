public class Main {
    public static void main(String[] args) {
        String str = "AaBbCcDd";
        
        StringBuilder uppercase = new StringBuilder();
        StringBuilder lowercase = new StringBuilder();
        
        // Проходим по всем символам строки
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercase.append(c);
            } else if (Character.isLowerCase(c)) {
                lowercase.append(c);
            }
        }
        
        System.out.println("Заглавные буквы: " + uppercase.toString());
        System.out.println("Строчные буквы: " + lowercase.toString());
    }
}