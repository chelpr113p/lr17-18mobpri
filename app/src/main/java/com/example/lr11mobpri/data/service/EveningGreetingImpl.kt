package com.example.lr11mobpri.data.service

import com.example.lr11mobpri.domain.service.GreetingService
import javax.inject.Inject

class EveningGreetingImpl @Inject constructor() : GreetingService {
    override fun getGreeting(): String = "Добрый вечер!"
}