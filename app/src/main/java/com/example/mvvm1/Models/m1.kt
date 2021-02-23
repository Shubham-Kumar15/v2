package com.example.mvvm1.Models

class Movies(
        var poster_path: String,
        var overview: String,
        var release_date: String,
        var original_title: String,
        var id: Int) {
    override fun toString(): String {
        return "Movies{" +
                "poster_path='" + poster_path + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", original_title='" + original_title + '\'' +
                ", id=" + id +
                '}'
    }
}


class Result(var page: Int, var results: List<Movies>) {
    override fun toString(): String {
        return "Result{" +
                "page=" + page +
                ", results=" + results +
                '}'
    }
}


class Series     //this.poster_path=TMDB.baseImage+poster_path;
    (var poster_path: String, var overview: String, var first_air_date: String, var original_name: String, var id: Int) {
    override fun toString(): String {
        return "Movies{" +
                "poster_path='" + poster_path + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + first_air_date + '\'' +
                ", original_title='" + original_name + '\'' +
                ", id=" + id +
                '}'
    }
}

class Series_Result(var page: Int, var results: List<Series>) {
    override fun toString(): String {
        return "Result{" +
                "page=" + page +
                ", results=" + results +
                '}'
    }
}

data class GENRE(val id:Int,val name:String)

data class ProductionCOMPANY(val name:String,
                             val id:Int,
                             val logo_path:String
)

data class MoviesDetail(val budget:Int,
                        val genres:List<GENRE>,
                        val id:Int,
                        val original_language:String,
                        val original_title:String,
                        val overview:String,
                        val release_date:String,
                        val revenue:Int,
                        val tagline:String,
                        val poster_path:String,
                        val runtime:Int,
                        val title:String,
                        val production_companies:List<ProductionCOMPANY>)

data class People(
        val adult:Boolean,
        val gender:Int,
        val name:String,
        val character:String,
        val original_name: String,
        val id:Int,
        val cast_id:Int,
        val profile_path:String//Image of cast
)

data class CreditResult(
        val id:Int,
        val cast:ArrayList<People>,
        val crew:ArrayList<People>
)

data class season(val air_date:String,
                  val episode_count:Int,
                  val season_number:Int,
                  val name:String
)

data class episode(val air_date:String,
                   val episode_number:Int,
                   val name:String,
                   val overview:String,
                   val vote_average:Double,
                   val still_path: String
                   )


data class TV_Response(
    val backdrop_path:String,
    val first_air_date:String,
    val name:String,
    val number_of_seasons:Int,
    val overview: String,
    val seasons:List<season>,
    val tagline:String,
    val poster_path:String
)


data class SeasonResponse(
    val name:String,
    val overview: String,
    val id: Int,
    val poster_path: String,
    val season_number:Int,
    val episodes:ArrayList<episode>
)


data class Poster(
    val height:String,
    val file_path:String,
    val aspect_ratio:Double
)

data class Backdrop(
    val height:String,
    val file_path:String,
    val aspect_ratio:Double
)

data class MovieImageResponsee(
    val id:Int,
    val backdrops:ArrayList<Backdrop>,
    val posters:ArrayList<Poster>
)