package com.jeetracker.app.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserProfile::class, Subject::class, Topic::class, StudySession::class, MockTest::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun subjectDao(): SubjectDao
    abstract fun topicDao(): TopicDao
    abstract fun studyDao(): StudySessionDao
    abstract fun mockTestDao(): MockTestDao
}
