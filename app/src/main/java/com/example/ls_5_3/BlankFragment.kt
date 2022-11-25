package com.example.ls_5_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ls_5_3.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding
    private var isItPlus = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentBlankBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnPlus.setOnClickListener {
            var numNow = binding.tv1.text.toString().toInt()
            if (isItPlus) {
                var newNumber = numNow + 1
                binding.tv1.text = newNumber.toString()
                if (newNumber == 10) {
                    isItPlus = false
                    binding.btnPlus.text = "-"
                }
            } else {
                var newNumber = numNow - 1
                binding.tv1.text = newNumber.toString()
                if (newNumber == 0) {
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,BlankFragment2()).commit()
                }
            }
        }
    }
}