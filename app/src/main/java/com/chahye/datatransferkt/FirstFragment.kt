package com.chahye.datatransferkt

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            setFragmentResult("requestKey", bundleOf("data" to "hello"))
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

    }

}