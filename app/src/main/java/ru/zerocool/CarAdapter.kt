package ru.zerocool

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.zerocool.databinding.CarItemBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarHolder>() {
    val carList = ArrayList<Car>()
    class CarHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CarItemBinding.bind(item)
        fun bind(car: Car) = with(binding) {
            carImageView.setImageResource(car.imageId)
            carDescription.text = car.title
        }
    }
//Берет нашу разметку xml, создает ее с помощью inflate и создает класс CarHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return  CarHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarHolder, position: Int) {
        holder.bind(carList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCar(car: Car){
        carList.add(car)
        notifyDataSetChanged()
    }
}