package com.example.lr11mobpri.data.service

import com.example.lr11mobpri.domain.service.GreetingService
import javax.inject.Inject

class MorningGreetingImpl @Inject constructor() : GreetingService {
    override fun getGreeting(): String = "Доброе утро!"
}