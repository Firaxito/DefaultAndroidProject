package eu.petrfaruzel.templateapp.ui.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    private val _name: MutableLiveData<String> by lazy { MutableLiveData("This is name from viewmodel") }
    val name : LiveData<String> = _name

}