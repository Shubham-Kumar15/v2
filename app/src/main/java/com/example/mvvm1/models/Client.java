package com.example.mvvm1.models;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Client {
    private Client(){}
    private static RequestQueue rq= null;
    public static RequestQueue getRequestQueue(Context context){
        if(rq==null)
            rq= Volley.newRequestQueue(context);
        return rq;
    }
}
