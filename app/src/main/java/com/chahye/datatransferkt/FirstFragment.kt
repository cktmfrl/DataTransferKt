package com.chahye.datatransferkt

import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        imageView.setImageURI(it)
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

    }

}