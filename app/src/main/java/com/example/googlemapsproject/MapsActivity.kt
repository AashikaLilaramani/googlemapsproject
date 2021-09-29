package com.example.googlemapsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapsproject.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.CameraPosition

import android.R

import LatLongANDName




class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        for (i in LatLongANDName.locations.indices) {
            val l: LatLongANDName = LatLongANDName.locations.get(i)
            // below line is use to add marker to each location of our array list.
            mMap.addMarker(
                MarkerOptions().position(l.getPoint()).title(l.getName()).icon(
                    BitmapFromVector(
                        applicationContext, R.drawable.ic_baseline_flag_24
                    )
                )
            )

            //link to cameraPosition class info https://developers.google.com/android/reference/com/google/android/gms/maps/model/CameraPosition

            //https://docs.mapbox.com/android/maps/examples/animate-the-map-camera/
            val position = CameraPosition.Builder()
                .target(l.getPoint()) // Sets the new camera position
                .zoom(5f) // Sets the zoom
                .bearing(180f) // Rotate the camera
                .tilt(30f) // Set the camera tilt
                .build() // Creates a CameraPosition from the builder
            mMap.animateCamera(
                CameraUpdateFactory
                    .newCameraPosition(position)
            )
        }


        // Add a marker in Sydney and move the camera

    }
}