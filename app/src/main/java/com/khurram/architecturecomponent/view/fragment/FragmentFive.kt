package com.khurram.architecturecomponent.view.fragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.khurram.architecturecomponent.R
import com.khurram.architecturecomponent.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.fragment_five.*

class FragmentFive : Fragment(R.layout.fragment_five) {

    val sharedViewModel: SharedViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_5.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentFive_to_fragmentOne)
        }

        sharedViewModel.data.observe(requireActivity(), object : Observer<String> {
            override fun onChanged(t: String?) {
                textView.text=t.toString()
//                Toast.makeText(requireContext(),t.toString(), Toast.LENGTH_LONG).show()
            }

        })
    }


}