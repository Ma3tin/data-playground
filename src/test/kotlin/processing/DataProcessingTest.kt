package processing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import streams.*


class DataProcessingTest {
    lateinit var school: School

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        school = MockDataProvider.getNewSchool()
    }

    @Throws(Exception::class)
    @Test
    fun studentAges() {
        Assertions.assertEquals(
            listOf(14, 15, 13),
            getStudentAges(school.classes[0].students)
        )
        Assertions.assertEquals(listOf(9, 12), getStudentAges(school.classes[1].students))
    }

    @Throws(Exception::class)
    @Test
    fun multiplyStudentAge() {
        Assertions.assertEquals(14 * 15 * 13, getProductOfStudentAges(school.classes[0].students))
        Assertions.assertEquals(9 * 12, getProductOfStudentAges(school.classes[1].students))
    }

    @Throws(Exception::class)
    @Test
    fun studentsWithMinimumAge() {
        Assertions.assertEquals(
            listOf(school.classes[1].students[1]),
            getStudentsWithMinimumAge(school.classes[1].students, 12)
        )

        Assertions.assertEquals(
            listOf(school.classes[0].students[0], school.classes[0].students[1]),
            getStudentsWithMinimumAge(school.classes[0].students, 14)
        )
    }

    @Throws(Exception::class)
    @Test
    fun sortedAges() {
        var list = school.classes[0].students
        Assertions.assertEquals(
            listOf(list[2].age, list[0].age, list[1].age),
            getSortedAges(list)
        )

        list = school.classes[1].students
        Assertions.assertEquals(listOf(list[0].age, list[1].age), getSortedAges(list))
    }

    @Test
    @Throws(Exception::class)
    fun countMaleStudents() {
        Assertions.assertEquals(2, countMaleStudents(school.classes[0].students))
        Assertions.assertEquals(0, countMaleStudents(school.classes[1].students))
    }

    @Test
    @Throws(Exception::class)
    fun avgAgeOfFemaleStudent() {
        Assertions.assertEquals(15.0, avgAgeOfFemaleStudent(school.classes[0].students), 0.0)
        Assertions.assertEquals(10.5, avgAgeOfFemaleStudent(school.classes[1].students), 0.0)
    }

    @Test
    @Throws(Exception::class)
    fun productOfStudentGrades() {
        Assertions.assertEquals(38400000, productOfStudentGrades(school.classes[0].students[0]))
        Assertions.assertEquals(800000, productOfStudentGrades(school.classes[0].students[2]))
        Assertions.assertEquals(960000000, productOfStudentGrades(school.classes[1].students[1]))
    }

    @Throws(Exception::class)
    @Test
    fun bestMathGradeFromStudent(): Unit {
        var s = school.classes[0].students[0]
        Assertions.assertEquals(s.grades[0], getBestMathGradeFromStudent(s))
        s = school.classes[1].students[1]
        Assertions.assertEquals(s.grades[1], getBestMathGradeFromStudent(s))
    }

    @Test
    @Throws(Exception::class)
    fun atLeastOneGradeA() {
        Assertions.assertTrue(
            atLeastOneGradeA(
                Student(
                    "Pepa",
                    14,
                    Gender.MALE,
                    listOf(
                        Grade(Subject.MATH, GradeType.A),
                        Grade(Subject.MATH, GradeType.B),
                        Grade(Subject.GEOLOGY, GradeType.B),
                        Grade(Subject.GEOLOGY, GradeType.F),
                        Grade(Subject.BIOLOGY, GradeType.C)
                    ), Subject.MATH
                )
            )
        )
        Assertions.assertTrue(
            atLeastOneGradeA(
                Student(
                    "Lucie",
                    15,
                    Gender.FEMALE,
                    listOf(
                        Grade(Subject.MATH, GradeType.F),
                        Grade(Subject.MATH, GradeType.B),
                        Grade(Subject.GEOLOGY, GradeType.B),
                        Grade(Subject.GEOLOGY, GradeType.A),
                        Grade(Subject.BIOLOGY, GradeType.B),
                        Grade(Subject.COMPUTER_SCIENCE, GradeType.B),
                        Grade(Subject.COMPUTER_SCIENCE, GradeType.C)
                    ), Subject.GEOLOGY
                )
            )
        )
        Assertions.assertFalse(
            atLeastOneGradeA(
                Student(
                    "Anna",
                    9,
                    Gender.FEMALE,
                    listOf(
                        Grade(Subject.MATH, GradeType.F),
                        Grade(Subject.GEOLOGY, GradeType.E),
                        Grade(Subject.GEOLOGY, GradeType.E)
                    ), Subject.MATH
                )
            )
        )
    }
}
