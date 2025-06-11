package com.sample.criminalintent

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.criminalintent.databinding.FragmentCrimeListBinding

class CrimeListFragment : Fragment() {

    private lateinit var binding: FragmentCrimeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCrimeListBinding.inflate(inflater, container, false)
        val crimeAdapter = CrimeAdapter(CrimeRepository.crimes)

        binding.crimeListView.adapter = crimeAdapter

        // Переход к деталям
        binding.crimeListView.setOnItemClickListener { _, _, position, _ ->
            val crime = CrimeRepository.crimes[position]
            val action = CrimeListFragmentDirections.actionCrimeListToCrimeDetail(crime.id)
            requireView().findNavController().navigate(action)
        }

        return binding.root
    }
}