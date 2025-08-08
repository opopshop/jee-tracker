package com.jeetracker.app.data

class Repository(private val db: AppDatabase) {
    fun profiles() = db.profileDao().getAll()
    fun subjects(pid: String) = db.subjectDao().getForProfile(pid)
    suspend fun addStudy(session: StudySession) = db.studyDao().insert(session)
    suspend fun addTest(test: MockTest) = db.mockTestDao().insert(test)
}
