package com.example.android_technical_exam.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_technical_exam.R
import com.example.android_technical_exam.api.PersonAPI
import com.example.android_technical_exam.api.model.RandomUserResponse
import com.example.android_technical_exam.databinding.PeopleFragmentBinding
import com.example.android_technical_exam.view.adapter.PeopleListAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import rx.Observer
import rx.Subscriber
import java.util.concurrent.Flow.*


class PeopleFragment : androidx.fragment.app.Fragment() {
    lateinit var mPeopleFragmentBinding: PeopleFragmentBinding
    lateinit var mPeopleListAdapter: PeopleListAdapter

    private var mIsTabletLayout = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mPeopleFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.people_fragment, container, false)
        mIsTabletLayout = false
        return mPeopleFragmentBinding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(requireView(), savedInstanceState)

        val randomUserAPI: PersonAPI = PersonAPI.Factory.create()

        randomUserAPI.getRandomUsers(20)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Subscriber<RandomUserResponse?>() {
                override fun onCompleted() {
                }

                override fun onError(e: Throwable) {
                    Log.e("People", e.message!!)
                }

                override fun onNext(response: RandomUserResponse?) {
                    mPeopleFragmentBinding.rvPeopleList.layoutManager = setLayoutManager()
                    mPeopleFragmentBinding.rvPeopleList.setHasFixedSize(true)
                    if (response != null) {
                        mPeopleListAdapter = PeopleListAdapter(context!!, response.getResults())
                    }
                    mPeopleFragmentBinding.rvPeopleList.adapter = mPeopleListAdapter
                }

            })
    }

    private fun setLayoutManager(): RecyclerView.LayoutManager {
        val layoutManager: RecyclerView.LayoutManager
        if (!mIsTabletLayout) {
            layoutManager = LinearLayoutManager(activity)
            context?.let {
                ContextCompat.getDrawable(
                    it, R.drawable.divider_drawable
                )
            }
            mPeopleFragmentBinding.rvPeopleList.addItemDecoration(
                DividerItemDecoration(
                    context, LinearLayout.HORIZONTAL
                )
            )
        } else {
            val gridLayoutManager = GridLayoutManager(null, 3)
            gridLayoutManager.spanSizeLookup = object : SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return 1
                }
            }
            layoutManager = gridLayoutManager
        }
        return layoutManager
    }
}