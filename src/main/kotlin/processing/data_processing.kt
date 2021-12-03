package processing

import streams.*


fun atLeastOneGradeA(student: Student): Boolean {
    TODO()
}


fun getStudentAges(students: List<Student>): List<Int> {
    TODO()
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    TODO()
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    TODO()
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    TODO()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    TODO()
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    TODO()
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    TODO()
}

// endregion
