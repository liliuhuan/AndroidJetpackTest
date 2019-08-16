package com.app.suit.customviewp.databinding;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.app.suit.customviewp.BR;
import com.app.suit.customviewp.R;
import com.app.suit.customviewp.databinding.ItemFragment.OnListFragmentInteractionListener;
import com.app.suit.customviewp.databinding.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_item, parent, false);
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.fragment_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bindData(mValues.get(position));

//        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
//        binding.setVariable(R.id.item,mValues.get(position));
    }

    public void onItemClick(DummyItem mItem) {
        Log.e("t---","onItemClick==="+mItem.toString());
        if (null != mListener) {
            // Notify the active callbacks interface (the activity, if the
            // fragment is attached to one) that an item has been selected.
            mListener.onListFragmentInteraction(mItem);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        void bindData(DummyItem item) {
            binding.setVariable(BR.dummyItem,item);
            binding.setVariable(BR.adapter,MyItemRecyclerViewAdapter.this);
//            binding.executePendingBindings();
        }

    }
}
