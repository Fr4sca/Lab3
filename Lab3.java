import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Введіть текстовий рядок:");
        String inputText = scanner.nextLine();
        
        String[] words = inputText.trim().split("\\s+");
        
        int vowelEndingCount = countWordsEndingWithVowel(words);
        List<String> shortWords = getWordsWithLengthLessThan5(words);
        List<String> filteredWords = removeWordsWithLatinLetters(words);
        
        System.out.println("\n=== РЕЗУЛЬТАТИ ===");
        System.out.println("1. Кількість слів, які закінчуються на голосну: " + vowelEndingCount);
        
        System.out.println("\n2. Слова довжиною менше 5 символів:");
        if (shortWords.isEmpty()) {
            System.out.println("   Немає слів довжиною менше 5 символів");
        } else {
            for (String word : shortWords) {
                System.out.println("   " + word);
            }
        }
        
        System.out.println("\n3. Текст після видалення слів з латинськими літерами:");
        if (filteredWords.isEmpty()) {
            System.out.println("   Текст порожній після фільтрації");
        } else {
            System.out.println("   " + String.join(" ", filteredWords));
        }
        
        scanner.close();
    }
    
    public static int countWordsEndingWithVowel(String[] words) {
        String vowels = "аеєиіїоуюяАЕЄИІЇОУЮЯ";
        int count = 0;
        
        for (String word : words) {
            if (word.length() > 0) {
                char lastChar = word.charAt(word.length() - 1);
                if (vowels.indexOf(lastChar) != -1) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static List<String> getWordsWithLengthLessThan5(String[] words) {
        List<String> shortWords = new ArrayList<>();
        
        for (String word : words) {
            if (word.length() < 5) {
                shortWords.add(word);
            }
        }
        
        return shortWords;
    }
    
    public static List<String> removeWordsWithLatinLetters(String[] words) {
        List<String> filteredWords = new ArrayList<>();
        
        for (String word : words) {
            if (!containsLatinLetters(word)) {
                filteredWords.add(word);
            }
        }
        
        return filteredWords;
    }
    
    public static boolean containsLatinLetters(String word) {
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c) && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                return true;
            }
        }
        return false;
    }
}