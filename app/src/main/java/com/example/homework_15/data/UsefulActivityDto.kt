package com.example.homework_15.data

import com.example.homework_15.entity.UsefulActivity
import javax.inject.Inject

data class UsefulActivityDto @Inject constructor(override val activity: String) : UsefulActivity {
    override fun toString(): String {
        return this.activity
    }
}