package week2;

public class CountingValleys {

    public static void main(String[] args) {
        assert countingValleys(8, "UDDDUDUU") == 1;
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        char[] chPath = path.toCharArray();
        int currentLevel = 0;
        int prevLevel = 0;
        int valleys = 0;

        for (int i = 0; i < chPath.length; i++) {
            if (i != 0) prevLevel = currentLevel;
            if (chPath[i] == 'U') currentLevel++;
            else currentLevel--;
            if (currentLevel == 0 && prevLevel < 0) valleys++;
        }

        return valleys;
    }
}
