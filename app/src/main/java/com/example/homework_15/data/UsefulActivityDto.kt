package com.example.homework_15.data

import com.example.homework_15.entity.UsefulActivity

data class UsefulActivityDto(override val activity: String) : UsefulActivity {
    override fun toString(): String {
        return this.activity
    }
}