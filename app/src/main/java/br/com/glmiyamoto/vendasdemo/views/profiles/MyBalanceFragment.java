package br.com.glmiyamoto.vendasdemo.views.profiles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.model.User;

public class MyBalanceFragment extends Fragment {

    private static final String ARG_USER = "user";
    private User mUser;

    public MyBalanceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param user User.
     * @return A new instance of fragment MyBalanceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyBalanceFragment newInstance(final User user) {
        MyBalanceFragment fragment = new MyBalanceFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_balance, container, false);
    }
}
