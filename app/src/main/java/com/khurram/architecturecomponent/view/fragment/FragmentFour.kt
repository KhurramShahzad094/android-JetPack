package com.khurram.architecturecomponent.view.fragment

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.khurram.architecturecomponent.R
import com.khurram.architecturecomponent.databinding.FragmentFourBinding
import com.khurram.architecturecomponent.network.ResultType
import com.khurram.architecturecomponent.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_four.*


@AndroidEntryPoint
class Fragment_four : Fragment() {


    private var binding: FragmentFourBinding?=null
    private val homeViewModel : HomeViewModel by viewModels()
    private val  args : Fragment_fourArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment using databinding
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_four,container,false)

//        for activity binding in activity on create
//        val binding : PlainActivityBinding =
//            DataBindingUtil.setContentView(this, R.layout.plain_activity)

        return binding?.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textview.text=args.firstName + " " + args.lastName

        var context = requireContext()


        homeViewModel.getAllUsers().observe(viewLifecycleOwner,
            Observer{ result ->
                when (result!!.status) {
                    ResultType.Status.SUCCESS -> {
                        // usable  data and code here

                        progressBar.visibility= View.GONE
                        textview.text=args.firstName + " " + args.lastName + "  " + result.data?.total

                        Toast.makeText(context,result.data!!.total.toString(), Toast.LENGTH_LONG).show()

                        binding?.user=result.data!!.data[0]
                    }
                    ResultType.Status.LOADING -> progressBar.visibility= View.VISIBLE
                    ResultType.Status.ERROR -> {
                        // usable  message and code here
                        textview.text="Error " + result.message


                        Toast.makeText(context,result.message, Toast.LENGTH_LONG).show()
                        progressBar.visibility= View.GONE
                    }
                }
            })

    }




    override fun onResume() {
        super.onResume()
        val supportActionBar: ActionBar? =
            (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.hide()

        requireActivity()?.findViewById<BottomNavigationView>(R.id.bottom_navbar)?.visibility=GONE

    }

    override fun onStop() {
        super.onStop()
        val supportActionBar: ActionBar? =
            (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.show()

        requireActivity()?.findViewById<BottomNavigationView>(R.id.bottom_navbar)?.visibility= VISIBLE

    }



}
