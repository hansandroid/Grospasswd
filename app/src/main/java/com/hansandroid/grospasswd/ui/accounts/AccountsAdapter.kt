package com.hansandroid.grospasswd.ui.accounts

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hansandroid.grospasswd.model.AccountEntity
import com.hansandroid.grospasswd.databinding.AccountItemBinding

class AccountsAdapter(
    private val didTap: (accountId: Long) -> Unit
) : RecyclerView.Adapter<AccountViewHolder>() {

    private val accounts = mutableListOf<AccountEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val itemBinding = AccountItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AccountViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.bind(accounts[position], didTap)
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    fun updateAccounts(notes: List<AccountEntity>) {
        this.accounts.clear()
        this.accounts.addAll(notes)
        notifyDataSetChanged()
    }

    fun onItemDelete(position: Int) : AccountEntity {
        val noteModel = accounts[position]
        accounts.removeAt(position)
        notifyDataSetChanged()
        return noteModel
    }
}

class AccountViewHolder(private val itemBinding: AccountItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(account: AccountEntity, didTap: (accountId: Long) -> Unit) {
        itemBinding.account.text = account.name
        itemBinding.card.setOnClickListener { didTap(account.id) }
    }
}

class SpacingItemDecorator(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = verticalSpaceHeight
    }

}