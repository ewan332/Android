package com.example.demo1

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.demo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val tauxEuroDollar:Double = 1.12
    private var haut:Double = 0.0
    private var bas:Double = 0.0
//    private lateinit var bthaut: ImageButton
//    private lateinit var btbas: ImageButton
//    private lateinit var eHaut: EditText
//    private lateinit var eBas: EditText
    private val df = DecimalFormat("#.##")
    private lateinit var binding : ActivityMainBinding
    private lateinit var dataForBindingViewModel: DataForBindingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        dataForBindingViewModel = ViewModelProvider(this).get(DataForBindingViewModel::class.java)
        binding.infoIhm = dataForBindingViewModel
        binding.lifecycleOwner = this@MainActivity


        binding.buttonBas.setOnClickListener {
            haut = binding.editTextHaut.toString().replace(",","").toDoubleOrNull()?:0.0
            if(haut>0.0){
               dataForBindingViewModel.updateDataForBing(DataForBinding(resultatHaut = haut, resultatBas = haut*tauxEuroDollar))

                Toast.makeText(this,"cool",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Erreur de saisie",Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonHaut.setOnClickListener() {
            bas = binding.editTextBas.text.toString().replace(",","").toDoubleOrNull()?:0.0
            if(bas>0.0){
                dataForBindingViewModel.updateDataForBing(DataForBinding(resultatHaut = bas*1/tauxEuroDollar, resultatBas = bas))
                Toast.makeText(this,"cool",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Erreur de saisie",Toast.LENGTH_LONG).show()
            }
        }
    }


}