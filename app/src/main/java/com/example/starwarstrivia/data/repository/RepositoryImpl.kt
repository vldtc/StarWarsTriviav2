package com.example.starwarstrivia.data.repository

import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.model.planets.PlanetsModel
import com.example.starwarstrivia.data.model.species.SpeciesModel
import com.example.starwarstrivia.data.model.starships.StarshipsModel
import com.example.starwarstrivia.data.model.vehicles.VehiclesModel
import com.example.starwarstrivia.data.remote.ApiRequest
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
): Repository {
    override suspend fun getPeople(): PeopleModel = apiRequest.getPeople()

    override suspend fun getPeople(next: String): PeopleModel = apiRequest.getPeople(next)

    override suspend fun getPeopleID(id: String): PeopleModel = apiRequest.getPeopleID(id)

    override suspend fun getSpecies(): SpeciesModel = apiRequest.getSpecies()

    override suspend fun getSpecies(next: String): SpeciesModel = apiRequest.getSpecies(next)

    override suspend fun getPlanets(): PlanetsModel = apiRequest.getPlanets()

    override suspend fun getPlanets(next: String): PlanetsModel = apiRequest.getPlanets(next)

    override suspend fun getStarships(): StarshipsModel = apiRequest.getStarships()

    override suspend fun getStarships(next: String): StarshipsModel = apiRequest.getStarships(next)

    override suspend fun getVehicles(): VehiclesModel = apiRequest.getVehicles()

    override suspend fun getVehicles(next: String): VehiclesModel = apiRequest.getVehicles(next)

}