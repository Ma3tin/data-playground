package processing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import streams.MockDataProvider
import streams.School

class DataProcessing2Test {
    lateinit var school: School

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        school = MockDataProvider.getNewSchool()
    }

    @Test
    fun testSumOfAgesOfAllStudents() {
        assertEquals(63, sumOfAgesOfAllStudents(school))
    }

    @Test
    fun allStudentsWithAgeGreaterThan() {
        assertEquals(listOf(school.classes[0].students[1]), allStudentsWithAgeGreaterThan(school, 14))
        assertEquals(listOf(
            school.classes[0].students[0],
            school.classes[0].students[1],
            school.classes[0].students[2],
        ), allStudentsWithAgeGreaterThan(school, 12))
    }

    @Test
    fun avgMathGradeForAllFemaleStudents() {
        assertEquals(44.0, avgMathGradeForAllFemaleStudents(school))
    }
}
