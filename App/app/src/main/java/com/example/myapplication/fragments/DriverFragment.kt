package com.example.myapplication.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.adapters.MyRidesAdapter
//import com.example.myapplication. databinding.ActivityMainBinding
import com.example.myapplication.adapters.NewRouteAdapter
import com.example.myapplication.models.Supplier

class DriverFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_driver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val startBtn : Button = view.findViewById(R.id.startBtn)
        val endBtn : Button = view.findViewById(R.id.endButton)
        val createBtn : Button = view.findViewById(R.id.createBtn)

        startBtn.setOnClickListener{ setDate(startBtn) }
        endBtn.setOnClickListener{ setDate(endBtn) }

        val listView : ListView = view.findViewById(R.id.listView)

        val myrides = Supplier.myRides

        var ridesAdapter = MyRidesAdapter(requireContext(), myrides)
        listView.adapter = ridesAdapter
    }

    private fun setDate(btn: Button){
        val calendar = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)

            val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hour)
                calendar.set(Calendar.MINUTE, minute)

                btn.text = "${calendar.time}"
            }

            TimePickerDialog(requireActivity(), timeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true).show()
        }

        DatePickerDialog(requireActivity(), dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)).show()
    }
}