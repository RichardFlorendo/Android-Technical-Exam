package com.example.android_technical_exam.view.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android_technical_exam.R
import com.example.android_technical_exam.BR
import com.example.android_technical_exam.api.model.RandomUserResponse
import com.example.android_technical_exam.model.Person
import com.example.android_technical_exam.viewmodel.UserViewModel
import java.util.concurrent.Flow.*


class PeopleListAdapter(private val mContext: Context, speakers: List<Person>) :
    RecyclerView.Adapter<PeopleListAdapter.BindingViewHolder>() {
    private val mUsers: List<Person> = speakers

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val binding = DataBindingUtil
            .inflate<ViewDataBinding>(
                LayoutInflater
                    .from(parent.context), R.layout.user_item_view, parent, false
            )
        return BindingViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val viewDataBinding = holder.viewDataBinding
        viewDataBinding.setVariable(
            BR.user,
            UserViewModel(mContext, mUsers[position])
        )
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    inner class BindingViewHolder(val viewDataBinding: ViewDataBinding) : ViewHolder(
        viewDataBinding.root
    ) {
        init {
            viewDataBinding.executePendingBindings()
        }
    }
}