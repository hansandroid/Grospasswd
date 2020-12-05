package com.hansandroid.grospasswd.ui.accountdetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hansandroid.grospasswd.databinding.AccountDeatilFragmentBinding
import com.hansandroid.grospasswd.model.AccountEntity
import com.hansandroid.grospasswd.ui.accounts.AccountsViewModel
import com.hansandroid.grospasswd.utils.ACCOUNT_ID
import com.hansandroid.grospasswd.utils.observe
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AccountDetailFragment : Fragment() {

    @Inject
    lateinit var viewModel: AccountsViewModel
    private lateinit var binding: AccountDeatilFragmentBinding
    private var accountEntity: AccountEntity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = AccountDeatilFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actionBar = (activity as? AppCompatActivity)?.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val id = arguments?.getLong(ACCOUNT_ID)
        if (id != null) {
            observe(viewModel.findAccountById(id), ::setAccount)
        }
    }

    override fun onPause() {
        super.onPause()
        val accountString = binding.account.text.toString()

        if (accountEntity != null) {
            if (accountString.isNotEmpty()) {
                viewModel.insert(accountString)
            } else {
                viewModel.delete(accountEntity!!)
            }
        } else {
            viewModel.insert(accountString)
        }
    }

    private fun setAccount(accountEntity: AccountEntity) {
        this.accountEntity = accountEntity
        binding.account.setText(accountEntity.name)
    }

}