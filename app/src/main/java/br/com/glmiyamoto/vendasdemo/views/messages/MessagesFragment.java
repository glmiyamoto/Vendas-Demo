package br.com.glmiyamoto.vendasdemo.views.messages;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentCallback;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;
import br.com.glmiyamoto.vendasdemo.model.Message;
import br.com.glmiyamoto.vendasdemo.model.User;
import br.com.glmiyamoto.vendasdemo.views.IFragment;
import br.com.glmiyamoto.vendasdemo.views.IFragmentListener;

public class MessagesFragment extends Fragment implements IFragment {

    public static final String ARG_USER = "user";
    public static final String ARG_COLUMN_COUNT = "column-count";

    private User mUser;
    private int mColumnCount = 1;

    private IFragmentListener mListener;

    public MessagesFragment() {
    }

    public static MessagesFragment newInstance(final User user, final int columnCount) {
        MessagesFragment fragment = new MessagesFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mUser = getArguments().getParcelable(ARG_USER);
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_messages, container, false);

        // Set the adapter
        final View messagesListView = view.findViewById(R.id.rv_messages_list);
        if (messagesListView instanceof RecyclerView) {
            final Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) messagesListView;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            final List<Message> messages = new ArrayList<Message>();
            for (int i = 0; i < 18; i++) {
                final Message message = new Message();
                messages.add(message);
            }

            recyclerView.setAdapter(new MessagesRecyclerViewAdapter(getContext(), messages));
        }
        return view;
    }

    @Override
    public EFragmentType getFragmentType() {
        return EFragmentType.MESSAGES;
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