package week2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {

    public static void main(String[] args) {

        System.out.println(gradingStudents(
                List.of(84, 29, 57, 38))
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        var multiplier = 5;
        var updatedGrades = new ArrayList<Integer>();
        for (Integer grade : grades) {
            if (grade < 38) {
                updatedGrades.add(grade);
                continue;
            }
            var residue = grade % multiplier;
            if (residue > 2) updatedGrades.add(grade + (multiplier - residue));
            else updatedGrades.add(grade);
        }
        return updatedGrades;
    }
}
