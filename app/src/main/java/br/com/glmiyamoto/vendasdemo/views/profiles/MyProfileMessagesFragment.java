package br.com.glmiyamoto.vendasdemo.views.profiles;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.model.Message;
import br.com.glmiyamoto.vendasdemo.model.User;
import br.com.glmiyamoto.vendasdemo.views.messages.MessagesRecyclerViewAdapter;

public class MyProfileMessagesFragment extends Fragment {

    public static final String ARG_USER = "user";

    private User mUser;

    public MyProfileMessagesFragment() {
    }

    public static MyProfileMessagesFragment newInstance(final User user, final int columnCount) {
        MyProfileMessagesFragment fragment = new MyProfileMessagesFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mUser = getArguments().getParcelable(ARG_USER);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_my_profile_messages, container, false);
        final Context context = view.getContext();

        // Set the adapter
        final View listView = view.findViewById(R.id.list);
        if (listView instanceof RecyclerView) {
            final RecyclerView recyclerView = (RecyclerView) listView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

            final List<Message> messages = new ArrayList<Message>();
            for (int i = 0; i < 18; i++) {
                final Message message = new Message();
                messages.add(message);
            }

            recyclerView.setAdapter(new MessagesRecyclerViewAdapter(getContext(), messages));
        }
        return view;
    }
}