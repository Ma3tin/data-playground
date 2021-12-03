package processing

import streams.*

fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any { grade -> grade.type == GradeType.A }
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.map { it.age }
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.filter { it.age >= minAge }
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.filter { it.gender == Gender.MALE }.size
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.asSequence().filter { it.gender == Gender.FEMALE }.map { it.age }.average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.fold(1) { acc, student -> acc * student.age }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.asSequence().filter { grade -> grade.type != GradeType.F }
        .fold(1) { acc, student -> acc * student.type.value }
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    return student.grades.filter { it.subject == Subject.MATH }.maxOrNull()
}

fun getSortedAges(students: List<Student>): List<Int> {
    return students.map { it.age }.sorted().toList()
}

// endregion
