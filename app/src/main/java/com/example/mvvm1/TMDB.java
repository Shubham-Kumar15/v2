package com.example.mvvm1;

public class TMDB {
    public static final String base="https://api.themoviedb.org/3/movie/popular?";
    public static final String seriesDetailBase="https://api.themoviedb.org/3/tv/";
    public static final String seriesBase="https://api.themoviedb.org/3/tv/popular?";
    public static final String moviesBase="https://api.themoviedb.org/3/movie/";
    public static final String seriesDetail="https://api.themoviedb.org/3/tv/";
    public static final String ApiKey="f34c7550ac4ff9b6367d6cb0656c3d4c";
    public static final String baseImage="https://image.tmdb.org/t/p/original/";
    public static final String lan="en-US";
    public final static String ID="ID";

    private TMDB() {

    }
    public static String getMovieImageList(int id){
        String res=moviesBase+id+"/images?";
        res=res+"api_key="+ApiKey;
        return res;
    }
    public static String getAPI(int page){
        String res=base+"api_key="+ApiKey+"&";
        res=res+"language="+lan+"&";
        res=res+"page="+page;
        return  res;
    }
    public static String getSeriesApi(int sp){
        String res=seriesBase+"api_key="+ApiKey+"&";
        res=res+"language="+lan+"&";
        res=res+"page="+sp;
        return res;
    }
    public static String getMoviesAPI(int id){
        String res=moviesBase+id+"?"+"api_key="+ApiKey+"&language="+lan;
        return res;
    }
    public static String getSeriesAPI(int id,int se){
        String res=seriesDetail+id+"/"+"season/"+se+"?";
        res=res+"api_key="+ApiKey+"&language="+lan;
        return res;
    }
    public static String getSeriesDetail(int id){
        String res=seriesDetailBase+id+"?";
        res=res+"api_key="+ApiKey+"&";
        res=res+"language="+lan;
        return res;
    }
    public static String getMoviesCredit(int id){
        String res=moviesBase+id+"/credits?api_key="+ApiKey;
        return res;
    }

}
