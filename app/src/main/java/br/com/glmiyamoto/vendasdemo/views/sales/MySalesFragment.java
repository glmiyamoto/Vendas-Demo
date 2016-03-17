package br.com.glmiyamoto.vendasdemo.views.sales;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.model.Item;
import br.com.glmiyamoto.vendasdemo.model.User;

public class MySalesFragment extends Fragment {

    private static final String ARG_USER = "user";
    private User mUser;

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

            final List<Item> items = new ArrayList<Item>();
            for (int i = 0; i < 10; i++) {
                final Item item = new Item();
                item.setId(i);
                item.setName("Name " + i);
                item.setValue(i * 1000);
                item.setRegisteredDate(new Date());
                item.setFlag(i % 2 == 1);
                items.add(item);
            }

            recyclerView.setAdapter(new MySalesRecyclerViewAdapter(getContext(), items));
        }
        return view;
    }
}