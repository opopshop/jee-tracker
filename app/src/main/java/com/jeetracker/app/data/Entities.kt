package com.jeetracker.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserProfile(
    @PrimaryKey val id: String,
    val name: String,
    val createdAt: Long
)

@Entity
data class Subject(
    @PrimaryKey val id: String,
    val profileId: String,
    val name: String,
    val colorHex: String
)

@Entity
data class Topic(
    @PrimaryKey val id: String,
    val subjectId: String,
    val chapter: String,
    val topicName: String,
    val completedSubitems: Int = 0,
    val totalSubitems: Int = 1,
    val lastRevisedAt: Long? = null
)

@Entity
data class StudySession(
    @PrimaryKey val id: String,
    val profileId: String,
    val subjectId: String,
    val topicId: String?,
    val startTime: Long,
    val endTime: Long,
    val durationMinutes: Int,
    val isRevision: Boolean = false,
    val notes: String? = null
)

@Entity
data class MockTest(
    @PrimaryKey val id: String,
    val profileId: String,
    val testName: String,
    val dateTaken: Long,
    val totalMarks: Int,
    val scoredMarks: Int
)
