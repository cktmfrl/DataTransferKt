package com.chahye.datatransferkt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.button
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(R.layout.fragment_second) {

    val getStartActivityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            activityResult.data?.let { intent ->
                intent.extras?.let { bundle ->
                    Toast.makeText(
                        requireContext(),
                        "message: ${bundle.getString("message", "empty")}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { key, bundle ->
            val data = bundle.getString("data", "")
            Toast.makeText(requireContext(), data, Toast.LENGTH_SHORT).show()
        }

        button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        button_result.setOnClickListener {
            Intent(requireContext(), ResultActivity::class.java).apply {
                this.putExtra("message", "Hi~ I'm SecondFragment")
                getStartActivityForResult.launch(this)
            }
        }

    }

}