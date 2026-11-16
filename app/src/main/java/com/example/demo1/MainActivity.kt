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


    private var haut:Double = 0.0
    private var bas:Double = 0.0

    private val TAUX_E_D: Double = 1.12
    private var taux:Double = 0.0
    private val TAUX_E_Y: Double = 175.70
    private val TAUX_D_Y: Double = TAUX_E_Y / TAUX_E_D
//    private lateinit var bthaut: ImageButton
//    private lateinit var btbas: ImageButton
//    private lateinit var eHaut: EditText
//    private lateinit var eBas: EditText
    private val df = DecimalFormat("#.##")
    private lateinit var binding : ActivityMainBinding
    private lateinit var dataForBindingViewModel: DataForBindingViewModel
    private lateinit var conversionViewModel: ConversionViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        dataForBindingViewModel = ViewModelProvider(this).get(DataForBindingViewModel::class.java)
        conversionViewModel = ViewModelProvider(this).get(ConversionViewModel::class.java)
        binding.infoIhm = dataForBindingViewModel
        binding.lifecycleOwner = this@MainActivity

        binding.buttonBas.setOnClickListener {
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()

            haut = binding.editTextHaut.text.toString().replace(",",".").toDoubleOrNull()?:0.0
            if(haut>0.0){
               dataForBindingViewModel.updateDataForBing(DataForBinding(resultatHaut = haut, resultatBas = haut*taux))

                Toast.makeText(this,"cool",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Erreur de saisie",Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonHaut.setOnClickListener() {
            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
            bas = binding.editTextBas.text.toString().replace(",",".").toDoubleOrNull()?:0.0
            if(bas>0.0){
                dataForBindingViewModel.updateDataForBing(DataForBinding(resultatHaut = bas*1/taux, resultatBas = bas))
                Toast.makeText(this,"cool",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Erreur de saisie",Toast.LENGTH_LONG).show()
            }
        }

        if(conversionViewModel.taux == null){
            binding.euroDollar.isChecked = true
            mettreAjour(TAUX_E_D,R.string.euro,R.string.dollar)
        }

    }

    private fun mettreAjour(taux: Double, euro: Int, dollar: Int) {
        this.taux = taux
        conversionViewModel.modifierTaux(taux)
        dataForBindingViewModel.updateDataForBing(DataForBinding(labelHaut = getString(euro),labelBas = getString(dollar) ))

    }


}