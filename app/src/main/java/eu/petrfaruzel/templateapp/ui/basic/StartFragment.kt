package eu.petrfaruzel.templateapp.ui.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import eu.petrfaruzel.templateapp.R
import eu.petrfaruzel.templateapp.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private val model: FragmentViewModel by viewModels()

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        binding.model = model
        binding.moveOut.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.nav_main_to_nav_other)
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}