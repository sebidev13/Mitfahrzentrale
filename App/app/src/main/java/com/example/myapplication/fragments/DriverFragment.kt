package com.example.myapplication.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.HelperClass.StringHelper.checkStringAndShowToast
import com.example.myapplication.R
import com.example.myapplication.REST.ApiService
import com.example.myapplication.REST.RetrofitClient
import com.example.myapplication.activities.MainActivity
import com.example.myapplication.adapters.DriverRoutesAdapter
//import com.example.myapplication. databinding.ActivityMainBinding
import com.example.myapplication.adapters.PassengerRouteAdapter
import com.example.myapplication.models.Route
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


        //val myrides = Supplier.myRides
        //var ridesAdapter = MyRidesAdapter(requireContext(), myrides)
        //listView.adapter = ridesAdapter

        var driverRoutes : MutableList<com.example.myapplication.REST.Route> = mutableListOf()
        var passengerRoutes : MutableList<com.example.myapplication.REST.Route> = mutableListOf()

        var driverRouteAdapter : DriverRoutesAdapter

        val driverListView : ListView = view.findViewById(R.id.driverListView)
        val passengerListView : ListView = view.findViewById(R.id.passengerListView)

        val driverCall = RetrofitClient.apiService.getCreatedRoutes(Constants.CURRENT_USER!!.id)
        val passengerCall = RetrofitClient.apiService.getPassengerRoutes(Constants.CURRENT_USER!!.id)



        HelperClass.ApiHelper.getApiResponse(driverCall,
            onSuccess = { response ->
                driverRoutes = response.toMutableList()
                driverRouteAdapter = DriverRoutesAdapter(requireContext(), driverRoutes)
                driverListView.adapter = driverRouteAdapter
            },
            onFailure = { t ->
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_LONG ).show()
            }
        )

        HelperClass.ApiHelper.getApiResponse(passengerCall,
            onSuccess = { response ->
                passengerRoutes = response.toMutableList()
                var passengerRouteAdapter = PassengerRouteAdapter(requireContext(), passengerRoutes)
                passengerListView.adapter = passengerRouteAdapter
            },
            onFailure = { t ->
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_LONG ).show()
            }
        )

        startBtn.setOnClickListener{ setDate(startBtn) }
        endBtn.setOnClickListener{ setDate(endBtn) }
        createBtn.setOnClickListener{

            val startET : EditText = view.findViewById(R.id.startET)
            val destinationET : EditText = view.findViewById(R.id.destinationET)

            val destinationPoint : String = destinationET.text.toString()
            val startPoint : String = startET.text.toString()
            val startTime: String = startBtn.text.toString()
            val endTime : String = endBtn.text.toString()

            val route : com.example.myapplication.REST.Route = com.example.myapplication.REST.Route(0,"","","", "",0, "")

            requireContext().checkStringAndShowToast( destinationPoint,"Ziel") { validString -> route.destination = destinationPoint }
            requireContext().checkStringAndShowToast( startPoint,"Start") { validString -> route.start_point = startPoint }
            requireContext().checkStringAndShowToast( startTime,"Start-Zeit") { validString -> route.start_time = startTime }
            requireContext().checkStringAndShowToast( endTime,"End-Zeit") { validString -> route.destination_time = endTime }

            val call = RetrofitClient.apiService.createRoute(route)

            HelperClass.ApiHelper.getApiResponse(call,
                onSuccess = { response ->
                    driverRoutes.add(response)
                    //driverRouteAdapter.notifyDataSetChanged()
                },
                onFailure = { t ->
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_LONG ).show()
                }
            )
        }
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