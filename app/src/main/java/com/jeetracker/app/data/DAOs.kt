package com.jeetracker.app.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: UserProfile)

    @Query("SELECT * FROM UserProfile")
    fun getAll(): Flow<List<UserProfile>>
}

@Dao
interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(subject: Subject)

    @Query("SELECT * FROM Subject WHERE profileId = :pid")
    fun getForProfile(pid: String): Flow<List<Subject>>
}

@Dao
interface TopicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(topic: Topic)

    @Query("SELECT * FROM Topic WHERE subjectId = :sid")
    fun getForSubject(sid: String): Flow<List<Topic>>
}

@Dao
interface StudySessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(session: StudySession)

    @Query("SELECT SUM(durationMinutes) FROM StudySession WHERE profileId = :pid AND startTime BETWEEN :from AND :to")
    suspend fun sumDurationBetween(pid: String, from: Long, to: Long): Int?
}

@Dao
interface MockTestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(test: MockTest)

    @Query("SELECT * FROM MockTest WHERE profileId = :pid ORDER BY dateTaken DESC")
    fun getTestsForProfile(pid: String): Flow<List<MockTest>>
}
