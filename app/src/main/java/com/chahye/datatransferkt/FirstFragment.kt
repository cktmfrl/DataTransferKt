package com.chahye.datatransferkt

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageView.setImageURI(uri)
    }

    val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { map ->
            if (map[Manifest.permission.ACCESS_COARSE_LOCATION]!!) {
                Toast.makeText(requireContext(), "ACCESS_COARSE_LOCATION 성공", Toast.LENGTH_SHORT)
                    .show()
            }
            if (map[Manifest.permission.READ_EXTERNAL_STORAGE]!!) {
                Toast.makeText(requireContext(), "READ_EXTERNAL_STORAGE 성공", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("data" to "hello"))
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        button_photo.setOnClickListener {
            // MIME TYPE
            getContent.launch("image/*")
        }

        button_permission.setOnClickListener {
            requestPermission.launch(
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                )
            )
        }
    }

}