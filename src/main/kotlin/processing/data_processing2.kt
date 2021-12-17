package processing

import streams.Gender
import streams.School
import streams.Student
import streams.Subject

fun sumOfAgesOfAllStudents(school: School): Int {
    return school.classes.asSequence().flatMap { it.students }.sumOf { it.age }
}

fun allStudentsWithAgeGreaterThan(school: School, minAge: Int): List<Student> {
    return school.classes.asSequence().flatMap { it.students }.filter { it.age > minAge }.toList()
}

fun avgMathGradeForAllFemaleStudents(school: School): Double {
    return school.classes.asSequence().flatMap { it.students }
        .filter { it.gender == Gender.FEMALE }
        .flatMap { it.grades }
        .filter { it.subject == Subject.MATH }
        .map { it.type.value }.average()
}

