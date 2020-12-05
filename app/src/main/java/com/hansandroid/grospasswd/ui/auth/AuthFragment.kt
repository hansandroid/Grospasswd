package com.hansandroid.grospasswd.ui.auth

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.hansandroid.grospasswd.R
import com.hansandroid.grospasswd.databinding.AuthFragmentBinding
import com.hansandroid.grospasswd.ui.MainActivity
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AuthFragment : Fragment() {

    @Inject
    lateinit var viewModel: AuthViewModel
    private lateinit var binding: AuthFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AuthFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.getPasswords.setOnClickListener {
            (activity as MainActivity).let {
                val inputManager = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                it.currentFocus?.let { currentFocus ->
                    inputManager.hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
                }
                it.navController.navigate(R.id.action_authFragment_to_accountsListFragment)
            }
        }
    }

}