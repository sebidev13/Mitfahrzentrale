package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.example.myapplication.Constants
import com.example.myapplication.HelperClass
import com.example.myapplication.R
import com.example.myapplication.REST.RetrofitClient
import com.example.myapplication.adapters.RequestAdapter


class RequestsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_requests, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*val listView : ListView = view.findViewById(R.id.listView)
        val requests = Supplier.requestMsg
        var requestAdapter = RequestAdapter(requireContext(), requests)
        listView.adapter = requestAdapter */

        var requests : MutableList<com.example.myapplication.REST.Request> = mutableListOf()
        val requestListView : ListView = view.findViewById(R.id.listView)
        var requestAdapter : RequestAdapter

        val requestCall = RetrofitClient.apiService.getRequest4Driver(Constants.CURRENT_USER!!.id)

        HelperClass.ApiHelper.getApiResponse(requestCall,
            onSuccess = { response ->
                requests = response.toMutableList()
                requestAdapter = RequestAdapter(requireContext(), requests)
                requestListView.adapter = requestAdapter
            },
            onFailure = { t ->
                Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_LONG ).show()
            }
        )
    }
}