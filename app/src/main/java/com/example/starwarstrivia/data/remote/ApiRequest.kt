package com.example.starwarstrivia.data.remote

import com.example.starwarstrivia.data.model.people.PeopleModel
import com.example.starwarstrivia.data.model.people.PeopleResultModel
import com.example.starwarstrivia.data.model.planets.PlanetsModel
import com.example.starwarstrivia.data.model.species.SpeciesModel
import com.example.starwarstrivia.data.model.starships.StarshipsModel
import com.example.starwarstrivia.data.model.vehicles.VehiclesModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiRequest {

    @GET(ApiDetails.PEOPLE)
    suspend fun getPeople(): PeopleModel

    @GET
    suspend fun getPeople(@Url next: String): PeopleModel

//    @GET(ApiDetails.PEOPLE_ID)
    @GET
    suspend fun getPeopleID(@Url apiURL: String): PeopleModel

    @GET(ApiDetails.SPECIES)
    suspend fun getSpecies(): SpeciesModel

    @GET
    suspend fun getSpecies(@Url next: String): SpeciesModel

    @GET(ApiDetails.PLANETS)
    suspend fun getPlanets(): PlanetsModel

    @GET
    suspend fun getPlanets(@Url next: String): PlanetsModel

    @GET(ApiDetails.STARSHIPS)
    suspend fun getStarships(): StarshipsModel

    @GET
    suspend fun getStarships(@Url next: String): StarshipsModel

    @GET(ApiDetails.VEHICLES)
    suspend fun getVehicles(): VehiclesModel

    @GET
    suspend fun getVehicles(@Url next: String): VehiclesModel

}