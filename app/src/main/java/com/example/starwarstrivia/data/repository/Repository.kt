package com.example.starwarstrivia.data.repository

import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.model.planets.PlanetsModel
import com.example.starwarstrivia.data.model.species.SpeciesModel
import com.example.starwarstrivia.data.model.starships.StarshipsModel
import com.example.starwarstrivia.data.model.vehicles.VehiclesModel
import retrofit2.http.Url

interface Repository {

    suspend fun getPeople(): PeopleModel

    suspend fun getPeople(next: String): PeopleModel

    suspend fun getPeopleID(id: String): PeopleModel

    suspend fun getSpecies(): SpeciesModel

    suspend fun getSpecies(next: String): SpeciesModel

    suspend fun getPlanets(): PlanetsModel

    suspend fun getPlanets(next: String): PlanetsModel

    suspend fun getStarships(): StarshipsModel

    suspend fun getStarships(next: String): StarshipsModel

    suspend fun getVehicles(): VehiclesModel

    suspend fun getVehicles(next: String): VehiclesModel
}
