package com.sample.criminalintent



object CrimeRepository {
    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0..5) {
            crimes.add(Crime(title = "Преступление #$i", isSolved = i % 2 == 0))
        }
    }
}