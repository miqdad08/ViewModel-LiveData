package com.miqdad.android.viewmodellivedata

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    //kita akan menyimpan data menggunakan LiveData
    private val scoreA : MutableLiveData<Int>? = MutableLiveData()
    private val scoreB : MutableLiveData<Int>? = MutableLiveData()

    fun addScoreA(){
        val result = getScoreA()?.value?.plus(1)
        scoreA?.value = result
    }

    fun addScoreB(){
        val result = getScoreB()?.value?.plus(1)
        scoreB?.value = result
    }
    fun minScoreB(){
        val result = getScoreB()?.value?.minus(1)
        if (result!! < 0 ){
            scoreB?.value = 0
        }else{
            scoreB?.value = result
        }
    }
    fun minScoreA(){
        val result = getScoreA()?.value?.minus(1)
        if (result!! < 0 ){
            scoreA?.value = 0
        }else{
            scoreA?.value = result
        }
    }
    fun resetScore(){
        scoreA?.value = 0
        scoreB?.value = 0
    }
    fun getScoreA():LiveData<Int>?{
        if(scoreA?.value == null){
            //untuk di main thread
            scoreA?.value = 0

//            untuk di background thread
//            scoreA?.postValue(0)
        }
        return scoreA
    }

    fun getScoreB():LiveData<Int>?{
        if(scoreB?.value == null){
            //untuk di main thread
            scoreB?.value = 0
//            untuk di background thread
//            scoreA?.postValue(0)
        }
        return scoreB
    }
}