package com.app.suit.customviewp.livedata;


import android.arch.lifecycle.Observer;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.suit.customviewp.R;

import java.math.BigDecimal;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LiveDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveDataFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public LiveDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LiveDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiveDataFragment newInstance(String param1, String param2) {
        LiveDataFragment fragment = new LiveDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_live_data, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        StockLiveData.get("1").observe(this, new Observer<BigDecimal>() {
            @Override
            public void onChanged(@Nullable BigDecimal bigDecimal) {
                Log.e("t---", "LiveDataFragment---" + bigDecimal);
            }
        });
    }
}
