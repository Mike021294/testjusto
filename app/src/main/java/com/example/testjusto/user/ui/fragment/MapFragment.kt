package com.example.testjusto.user.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testjusto.R
import com.example.testjusto.background.result.Result
import com.example.testjusto.user.background.response.GetUserResponse
import com.example.testjusto.user.ui.viewmodel.MainSharedViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment: Fragment(), OnMapReadyCallback {

    private lateinit var mViewModel: MainSharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewModel = ViewModelProvider(requireActivity()).get(MainSharedViewModel::class.java)

        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val supportMapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.frg_map) as SupportMapFragment
        supportMapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(), R.raw.style_json))

        mViewModel.user.observe(viewLifecycleOwner, {

            when (it.status) {
                Result.Status.LOADING -> {

                }
                Result.Status.SUCCESS -> {
                    val data: GetUserResponse = it.data!!

                    val latitude = data.results!![0].location!!.coordinates!!.latitude
                    val longitude = data.results!![0].location!!.coordinates!!.longitude

                    val markerOptions = MarkerOptions()
                    markerOptions.position(LatLng(latitude!!.toDouble(), longitude!!.toDouble()))
                    markerOptions.title(data.results!![0].name.toString())
                    googleMap.addMarker(markerOptions)
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(latitude.toDouble(), longitude.toDouble()), 10.0f))
                }
                Result.Status.ERROR -> {
                }
            }
        })
    }
}