package com.example.mvvm1.Models

import android.util.Log
import com.android.volley.NetworkResponse
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.HttpHeaderParser
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.nio.charset.Charset

class VolleyReqTV(val callback: Callback,val methord:Int,val URL:String,val listner:Response.ErrorListener):
    Request<TV_Response>(methord,URL,listner,) {
    interface Callback{
        fun cllback(tv:TV_Response?)
    }
    override fun parseNetworkResponse(response: NetworkResponse?): Response<TV_Response> {
        var res:String?=null
        if (response != null) {
            res= String(response?.data?: ByteArray(0),
                Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            val r:TV_Response=Gson().fromJson(res,TV_Response::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: TV_Response?) {
        callback.cllback(response)
    }
}


class VolleyReqSeries(val callback: Callback,val methord: Int,val URL:String,val listner: Response.ErrorListener):Request<SeasonResponse>(methord,
    URL,listner
    ){
    interface Callback{
        fun callback(sr:SeasonResponse)
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<SeasonResponse> {
        if(response!=null){
            val s:String= String(response?.data?: ByteArray(0), Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            val r:SeasonResponse=Gson().fromJson(s,SeasonResponse::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: SeasonResponse?) {
        if (response != null) {
            callback.callback(response)
        }
    }
}

class VolleyReqMovieList(val callback: Callback,val met:Int,val URL:String,listner: Response.ErrorListener):Request<Result>(
    met,URL,listner
){
    interface Callback{
        fun callback(res:Result)
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<Result> {
        if(response!=null){
            val s:String= String(response?.data?: ByteArray(0), Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            val r:Result=Gson().fromJson(s,Result::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: Result?) {
        if (response != null) {
            callback.callback(response)
        }
    }
}

class VolleyReqSeriesList(var callback: VolleyReqSeriesList.Callback, val mode:Int, val URL: String, val listner: Response.ErrorListener
):Request<Series_Result>(mode,URL,listner){
    interface Callback{
        fun callback(sr:Series_Result)
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<Series_Result> {
        if(response!=null){
            val s:String= String(response?.data?: ByteArray(0), Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            val r:Series_Result=Gson().fromJson(s,Series_Result::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: Series_Result?) {
        if (response != null) {
            callback.callback(response)
        }
    }


}



class VolleyReqMovieImage(val callback: Callback,val met:Int,val URL:String,listner: Response.ErrorListener):
Request<MovieImageResponsee>(met,URL,listner){
    interface Callback {
        fun callback(re:MovieImageResponsee)
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<MovieImageResponsee> {
        if(response!=null){
            val s:String= String(response?.data?: ByteArray(0), Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            //Log.e("The output from imageUrl",s)
            val r:MovieImageResponsee=Gson().fromJson(s,MovieImageResponsee::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: MovieImageResponsee?) {
        if (response != null) {
            //Log.e("The value is returned to the callback",""+response.id)
            callback.callback(response)
        }
    }


}

class VolleyReqMovieDetail(val calllback:Callback,req:Int,val URL:String,listner: Response.ErrorListener):
        Request<MoviesDetail>(req,URL,listner){
    interface Callback{
        fun callback(re:MoviesDetail)
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<MoviesDetail> {
        var res:String?=null
        if (response != null) {
            res= String(response?.data?: ByteArray(0),
                    Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            val r:MoviesDetail=Gson().fromJson(res,MoviesDetail::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: MoviesDetail?) {
        if (response != null) {
            calllback.callback(response)
        }
    }
}

class VolleyReqMovieCredit(val callback:Callback,met:Int,val URL:String,listner: Response.ErrorListener):
Request<CreditResult>(met,URL,listner){
    interface Callback{
        fun callback(re:CreditResult)
    }

    override fun parseNetworkResponse(response: NetworkResponse?): Response<CreditResult> {
        var res:String?=null
        if (response != null) {
            res= String(response?.data?: ByteArray(0),
                    Charset.forName(HttpHeaderParser.parseCharset(response.headers)))
            val r:CreditResult=Gson().fromJson(res,CreditResult::class.java)
            return Response.success(r,HttpHeaderParser.parseCacheHeaders(response))
        }
        return Response.error(VolleyError("FUBAR"))
    }

    override fun deliverResponse(response: CreditResult?) {
        if (response != null) {
            callback.callback(response)
        }
    }
}


