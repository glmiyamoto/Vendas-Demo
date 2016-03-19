package br.com.glmiyamoto.vendasdemo.views.messages;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.model.Item;
import br.com.glmiyamoto.vendasdemo.model.Message;
import br.com.glmiyamoto.vendasdemo.utils.ImageUtil;

public class MessagesRecyclerViewAdapter extends RecyclerView.Adapter<MessagesRecyclerViewAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Message> mValues;

    public MessagesRecyclerViewAdapter(Context context, List<Message> messages) {
        mContext = context;
        mValues = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.messages_item, parent, false);
        RecyclerView recyclerView = (RecyclerView) parent;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            view.getLayoutParams().width = parent.getContext().getResources()
                    .getDimensionPixelSize(R.dimen.messages_item_width);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Message message = mValues.get(position);
        holder.mMessage = message;

        // Set Message's contact photo
        holder.mUserPhotoView.setImageDrawable(ImageUtil.
                createRoundedBitmap(mContext.getResources(), R.drawable.photo01));

        // Set Message's contact name
        holder.mUserNameView.setText("User" + position);//message.getDestUserId());

        // Set Message's alert
        if (message.isAlert()) {
            holder.mAlertView.setVisibility(View.VISIBLE);
        } else {
            holder.mAlertView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mUserPhotoView;
        public final ImageView mAlertView;
        public final TextView mUserNameView;
        public Message mMessage;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUserPhotoView = (ImageView) view.findViewById(R.id.iv_message_user_photo);
            mAlertView = (ImageView) view.findViewById(R.id.iv_message_alert);
            mUserNameView = (TextView) view.findViewById(R.id.tv_message_user_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mUserNameView.getText() + "'";
        }
    }
}
