package br.com.glmiyamoto.vendasdemo.views.sales;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentCallback;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;
import br.com.glmiyamoto.vendasdemo.model.Item;
import br.com.glmiyamoto.vendasdemo.model.User;
import br.com.glmiyamoto.vendasdemo.views.IFragment;
import br.com.glmiyamoto.vendasdemo.views.IFragmentListener;

public class MySalesFragment extends Fragment implements IFragment {

    private static final String ARG_USER = "user";
    private User mUser;

    private IFragmentListener mListener;

    public MySalesFragment() {
    }

    public static MySalesFragment newInstance(final User user) {
        MySalesFragment fragment = new MySalesFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mUser = getArguments().getParcelable(ARG_USER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my_sales, container, false);

        if (view instanceof RecyclerView) {
            final Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new MySalesRecyclerViewAdapter(getContext(), mUser.getSales()));
        }
        return view;
    }

    @Override
    public EFragmentType getFragmentType() {
        return EFragmentType.MY_SALES;
    }

    @Override
    public void setFragmentListener(IFragmentListener listener) {
        mListener = listener;
    }

    @Override
    public boolean onBackPressed() {
        mListener.onFragmentCallBack(EFragmentCallback.BACK, getFragmentType(), null);
        return false;
    }
}