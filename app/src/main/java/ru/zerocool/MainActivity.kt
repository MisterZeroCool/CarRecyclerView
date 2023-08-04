package ru.zerocool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ru.zerocool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = CarAdapter()
    private val imageIdList = listOf(
        R.drawable.ferrari,
        R.drawable.bugati_veyron,
        R.drawable.ford_gt40,
        R.drawable.porsche_cayman_3260,
        R.drawable.shevrole_kamaro,)

    private var countIndexCar = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager =LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            buttonAddCar.setOnClickListener {
                if (countIndexCar > 4) countIndexCar = 0
                val car = Car(imageIdList[countIndexCar], "Car $countIndexCar")
                adapter.addCar(car)
                countIndexCar++
            }
        }
    }
}