package br.com.glmiyamoto.vendasdemo.views.profiles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.enums.EFragmentType;
import br.com.glmiyamoto.vendasdemo.model.Item;
import br.com.glmiyamoto.vendasdemo.model.Message;
import br.com.glmiyamoto.vendasdemo.model.User;
import br.com.glmiyamoto.vendasdemo.views.IFragment;
import br.com.glmiyamoto.vendasdemo.views.IFragmentListener;
import br.com.glmiyamoto.vendasdemo.views.messages.MessagesRecyclerViewAdapter;
import br.com.glmiyamoto.vendasdemo.views.sales.MySalesRecyclerViewAdapter;

public class MyProfileFragment extends Fragment implements IFragment {

    private static final String ARG_USER = "user";
    private User mUser;

    private IFragmentListener mListener;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param user User.
     * @return A new instance of fragment MyProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfileFragment newInstance(final User user) {
        MyProfileFragment fragment = new MyProfileFragment();
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
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        // Set the adapter
        final View messagesListView = view.findViewById(R.id.rv_messages_list);
        if (messagesListView instanceof RecyclerView) {
            final RecyclerView recyclerView = (RecyclerView) messagesListView;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

            final List<Message> messages = new ArrayList<Message>();
            for (int i = 0; i < 18; i++) {
                final Message message = new Message();
                messages.add(message);
            }

            recyclerView.setAdapter(new MessagesRecyclerViewAdapter(getContext(), messages));
        }

        // Set the adapter
        final View mySalesListView = view.findViewById(R.id.rv_my_sales_list);
        if (mySalesListView instanceof RecyclerView) {
            final RecyclerView recyclerView = (RecyclerView) mySalesListView;
            final List<Message> messages = new ArrayList<Message>();
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            final List<Item> items = new ArrayList<Item>();
            for (int i = 0; i < 10; i++) {
                final Item item = new Item();
                item.setId(i);
                item.setName("Name " + i);
                item.setValue(i * 1000);
                item.setRegisteredDate(new Date());
                item.setAlert(i % 2 == 1);
                items.add(item);
            }

            recyclerView.setAdapter(new MySalesRecyclerViewAdapter(getContext(), items));
        }

        return view;
    }

    @Override
    public EFragmentType getFragmentType() {
        return EFragmentType.MY_PROFILE;
    }

    @Override
    public void setFragmentListener(IFragmentListener listener) {
        mListener = listener;
    }

    @Override
    public boolean onBackPressed() {
        return true;
    }
}
