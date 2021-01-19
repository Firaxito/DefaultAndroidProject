package eu.petrfaruzel.templateapp.ui.basic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import eu.petrfaruzel.templateapp.databinding.FragmentOtherBinding

class OtherFragment : Fragment() {

    private val model: FragmentViewModel by viewModels()

    private var _binding: FragmentOtherBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtherBinding.inflate(inflater, container, false)
        binding.model = model

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}