package com.example.vegcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vegcart.adapters.ProductAdapter
import com.example.vegcart.dataSources.ProductSource
import com.example.vegcart.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productList=ProductSource().get()
        val adapter=ProductAdapter(requireContext(),R.layout.product_card,productList)
        binding.productList.adapter=adapter
        binding.productList.layoutManager=GridLayoutManager(requireContext(),2)
        binding.productList.setHasFixedSize(true)//improve performance
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}