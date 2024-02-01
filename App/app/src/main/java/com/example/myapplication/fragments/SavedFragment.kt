package com.example.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.R
import com.example.myapplication.REST.RetrofitClient
import com.example.myapplication.adapters.RequestAdapter
import com.example.myapplication.adapters.SavedAdapter
//import com.example.myapplication.adapters.RouteAdapter
import com.example.myapplication.models.Supplier

class SavedFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_saved, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val listView : ListView = view.findViewById(R.id.listView)
        val requests = Supplier.routes
        var requestAdapter = SavedAdapter(requireContext(), requests)
        listView.adapter = requestAdapter */

        var savedRoutes : MutableList<com.example.myapplication.REST.Route> = mutableListOf()
        val savedRoutesListView : ListView = view.findViewById(R.id.listView)
        var savedRoutesAdapter : SavedAdapter

        val savedRoutesCall = RetrofitClient.apiService.getSavedRoutes(Constants.CURRENT_USER!!.id)

        HelperClass.ApiHelper.getApiResponse(savedRoutesCall,
            onSuccess = { response ->
                savedRoutes = response.toMutableList()
                savedRoutesAdapter = SavedAdapter(requireContext(), savedRoutes)
                savedRoutesListView.adapter = savedRoutesAdapter
            },
            onFailure = { t ->
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_LONG ).show()
            }
        )
    }
}