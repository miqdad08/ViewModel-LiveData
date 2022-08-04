package com.miqdad.android.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.miqdad.android.viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

//    private var scoreA = 0
//    private var scoreB = 0

    private lateinit var getScoreViewModel: MainViewModel

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getScoreViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        initView()

        binding.btnMinusScoreTeamA.setOnClickListener(this)
        binding.btnPlusScoreTeamA.setOnClickListener(this)
        binding.btnMinusScoreTeamB.setOnClickListener(this)
        binding.btnPlusScoreTeamB.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)

    }

    private fun initView() {

        //kita akan mendapatkan data score menggunakan Live Data
        //Agar data yang sudah dirubah masih bisa di observe oleh UInya
        getScoreViewModel.getScoreA()?.observe(this, Observer{
            //disisini kita akan menampilkan livedata agar
            //setiap perubahan yang ada di live data bisa di tampilkan
            if (it != null) {
                binding.tvScoreTeamA.text = it.toString()
            }
        })
        getScoreViewModel.getScoreB()?.observe(this, Observer {
            if (it != null){
                binding.tvScoreTeamB.text = it.toString()
            }
        })
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnPlusScoreTeamA->{
                getScoreViewModel.addScoreA()
            }
            R.id.btnMinusScoreTeamA->{
                getScoreViewModel.minScoreA()
            }
            R.id.btnPlusScoreTeamB->{
                getScoreViewModel.addScoreB()
            }
            R.id.btnMinusScoreTeamB->{
                getScoreViewModel.minScoreB()
            }
            R.id.btnReset->{
                getScoreViewModel.resetScore()
            }
        }
    }

    // ini tanpa viewModel
//    private fun addScoreA(){
//        scoreA +=1
//        binding.tvScoreTeamA.text = scoreA.toString()
//    }
//    private fun addScoreB(){
//        scoreB +=1
//        binding.tvScoreTeamB.text = scoreB.toString()
//    }
//    private fun minScoreA(){
//        scoreA -= 1
//        binding.tvScoreTeamA.text = scoreA.toString()
//    }
//    private fun minScoreB(){
//        scoreB -= 1
//        binding.tvScoreTeamB.text = scoreB.toString()
//    }
//    private fun resetScore(){
//        scoreB = 0
//        scoreA = 0
//        binding.tvScoreTeamA.text = scoreA.toString()
//        binding.tvScoreTeamB.text = scoreB.toString()
//    }
}