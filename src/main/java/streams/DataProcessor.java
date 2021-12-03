package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().anyMatch(grade -> grade.getType() == GradeType.A);
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream().map(Student::getAge).toList();
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(student -> student.getAge() == minAge).toList();
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.MALE).toList().size();
        //return students.stream().reduce(0, (student, student2) -> (student.getGender() == Gender.MALE) )
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.FEMALE)
                .mapToInt(student -> student.getAge())
                .average().orElseGet(() -> 0);
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().mapToInt(value -> value.getAge())
                .reduce(1, (left, right) -> left * right);
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().filter(grade -> grade.getType() != GradeType.F)
                .mapToInt(value -> value.getType()
                .getValue()).reduce(1, (left, right) -> left * right);
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        //return Optional.empty();

        return student.getGrades().stream().filter(grade -> grade.getSubject() == Subject.MATH)
                .sorted((g1, g2) -> g2.getType().getValue() - g1.getType().getValue()).findFirst();
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        //return new ArrayList<>();
        return students.stream().map(value -> value.getAge()).sorted().toList();
    }

    // endregion
}
