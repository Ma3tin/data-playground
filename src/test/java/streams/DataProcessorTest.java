package streams;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static streams.GradeType.*;
import static streams.Subject.*;


/**
 * Created by semantier on 11/28/2016.
 */
public class DataProcessorTest {

    School school;

    @BeforeEach
    public void setUp() throws Exception {
        school = MockDataProvider.getNewSchool();
    }

    @Test
    public void getStudentAges() throws Exception {
        assertEquals(Arrays.asList(14, 15, 13), DataProcessor.getStudentAges(school.getClasses().get(0).getStudents()));
        assertEquals(Arrays.asList(9, 12), DataProcessor.getStudentAges(school.getClasses().get(1).getStudents()));
    }

    @Test
    public void getMultiplyStudentAge() throws Exception {
        assertEquals(14 * 15 * 13, DataProcessor.getProductOfStudentAges(school.getClasses().get(0).getStudents()));
        assertEquals(9 * 12, DataProcessor.getProductOfStudentAges(school.getClasses().get(1).getStudents()));
    }

    @Test
    public void getStudentsWithMinimumAge() throws Exception {
        assertEquals(
                List.of(school.getClasses().get(1).getStudents().get(1)),
                streams.DataProcessor.getStudentsWithMinimumAge(school.getClasses().get(1).getStudents(), 12)
        );

        assertEquals(
                List.of(school.getClasses().get(0).getStudents().get(0), school.getClasses().get(0).getStudents().get(1)),
                streams.DataProcessor.getStudentsWithMinimumAge(school.getClasses().get(0).getStudents(), 14)
        );
    }

    @Test
    public void getSortedAges() throws Exception {
        List<Student> list = school.getClasses().get(0).getStudents();
        assertEquals(Arrays.asList(list.get(2).getAge(), list.get(0).getAge(), list.get(1).getAge()), DataProcessor.getSortedAges(list));
        list = school.getClasses().get(1).getStudents();
        assertEquals(Arrays.asList(list.get(0).getAge(), list.get(1).getAge()), DataProcessor.getSortedAges(list));
    }

    @Test
    public void countMaleStudents() throws Exception {
        assertEquals(2, DataProcessor.countMaleStudents(school.getClasses().get(0).getStudents()));
        assertEquals(0, DataProcessor.countMaleStudents(school.getClasses().get(1).getStudents()));
    }

    @Test
    public void avgAgeOfFemaleStudent() throws Exception {
        assertEquals(15, DataProcessor.avgAgeOfFemaleStudent(school.getClasses().get(0).getStudents()), 0.0);
        assertEquals(10.5, DataProcessor.avgAgeOfFemaleStudent(school.getClasses().get(1).getStudents()), 0.0);
    }

    @Test
    public void productOfStudentGrades() throws Exception {
        assertEquals(38400000, DataProcessor.productOfStudentGrades(school.getClasses().get(0).getStudents().get(0)), 0.0);
        assertEquals(800000, DataProcessor.productOfStudentGrades(school.getClasses().get(0).getStudents().get(2)), 0.0);
        assertEquals(960000000, DataProcessor.productOfStudentGrades(school.getClasses().get(1).getStudents().get(1)), 0.0);
    }

    @Test
    public void getBestMathGradeFromStudent() throws Exception {
        Student s = school.getClasses().get(0).getStudents().get(0);
        assertEquals(Optional.of(s.getGrades().get(0)), DataProcessor.getBestMathGradeFromStudent(s));
        s = school.getClasses().get(1).getStudents().get(1);
        assertEquals(Optional.of(s.getGrades().get(1)), DataProcessor.getBestMathGradeFromStudent(s));
    }

    @Test
    public void atLeastOneGradeA() throws Exception {
        assertTrue(DataProcessor.atLeastOneGradeA(new Student(
                "Pepa",
                14,
                Gender.MALE,
                Arrays.asList(
                        new Grade(MATH, A),
                        new Grade(MATH, B),
                        new Grade(GEOLOGY, B),
                        new Grade(GEOLOGY, F),
                        new Grade(BIOLOGY, C)
                ),
                MATH)));
        assertTrue(DataProcessor.atLeastOneGradeA(new Student(
                "Lucie",
                15,
                Gender.FEMALE,
                Arrays.asList(
                        new Grade(MATH, F),
                        new Grade(MATH, B),
                        new Grade(GEOLOGY, B),
                        new Grade(GEOLOGY, A),
                        new Grade(BIOLOGY, B),
                        new Grade(COMPUTER_SCIENCE, B),
                        new Grade(COMPUTER_SCIENCE, C)
                ),
                GEOLOGY)));
        assertFalse(DataProcessor.atLeastOneGradeA(new Student(
                "Anna",
                9,
                Gender.FEMALE,
                Arrays.asList(
                        new Grade(MATH, F),
                        new Grade(GEOLOGY, E),
                        new Grade(GEOLOGY, E)
                ),
                MATH)));
    }

}
