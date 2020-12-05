package com.hansandroid.grospasswd.ui.accounts

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hansandroid.grospasswd.R
import com.hansandroid.grospasswd.databinding.AccountsListFragmentBinding
import com.hansandroid.grospasswd.model.AccountEntity
import com.hansandroid.grospasswd.ui.MainActivity
import com.hansandroid.grospasswd.utils.ACCOUNT_ID
import com.hansandroid.grospasswd.utils.observe
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AccountsListFragment : Fragment() {

    @Inject
    lateinit var viewModel: AccountsViewModel

    private lateinit var binding: AccountsListFragmentBinding
    private val didTap: (accountId: Long) -> Unit = { id ->
        val args = Bundle()
        args.putLong(ACCOUNT_ID, id)
        (activity as MainActivity).navController.navigate(R.id.action_accountsListFragment_to_accountDetailFragment, args)
    }

    private val accountsAdapter = AccountsAdapter(didTap)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = AccountsListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAccountsListView()
        observe(viewModel.accounts, ::updateList)
        binding.addAccount.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_accountsListFragment_to_accountDetailFragment)
        }
    }

    private fun updateList(accounts: List<AccountEntity>) {
        accountsAdapter.updateAccounts(accounts)
    }

    private fun initAccountsListView() {
        binding.accountsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(SpacingItemDecorator(20))
            adapter = accountsAdapter
        }
        val itemTouchCallback = ItemTouchCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.accountsList)
    }

    inner class ItemTouchCallback(dragDirs: Int, swipeDirs: Int) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            viewModel.delete(accountsAdapter.onItemDelete(position))
        }
    }


}