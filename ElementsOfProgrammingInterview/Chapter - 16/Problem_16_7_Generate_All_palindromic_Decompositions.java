import java.util.List;
import java.util.ArrayList;

class PalindromicDecompositions {
    public List<List<String>> generatePalindromicDecompositions(String input) {
        List<List<String>> result = new ArrayList<>();

        directedPalindromicGeneration(input, 0, new ArrayList<>(), result);
        return result;
    }

    public void directedPalindromicGeneration(
                    String input, 
                    int offset, 
                    List<String> partialDecomposition,
                    List<List<String>> result) {
        if (offset == input.length()) {
            result.add(new ArrayList<>(partialDecomposition));
            return;
        }

        for (int i = offset + 1; i <= input.length(); i++) {
            String prefix = input.substring(offset, i);
            if (isPalindrome(prefix)) {
                partialDecomposition.add(prefix);
                directedPalindromicGeneration(input, i, partialDecomposition, result);
                partialDecomposition.remove(partialDecomposition.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String input) {
        if (input == null) return false;
        if (input.isEmpty()) return false;
        for (int i = 0, j = input.length() - 1; i < input.length() / 2; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromicDecompositions decompositions = new PalindromicDecompositions();
        List<List<String>> result = decompositions.generatePalindromicDecompositions("1221");

        for (List<String> temp : result) {
            System.out.println(temp);
        }

    }

    
}