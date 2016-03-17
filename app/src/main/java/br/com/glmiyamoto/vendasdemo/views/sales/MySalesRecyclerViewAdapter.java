package br.com.glmiyamoto.vendasdemo.views.sales;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.glmiyamoto.vendasdemo.R;
import br.com.glmiyamoto.vendasdemo.model.Item;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MySalesRecyclerViewAdapter extends RecyclerView.Adapter<MySalesRecyclerViewAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Item> mValues;

    public MySalesRecyclerViewAdapter(Context context, List<Item> items) {
        mContext = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Item item = mValues.get(position);
        holder.mItem = item;

        // Set row color
        if (position % 2 == 0) {
            holder.mView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorItemLine));
        } else {
            holder.mView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorItemLineAlt));
        }

        // Set Item's title
        holder.mTitleView.setText(item.getName());

        // Set Item's id
        final String idFormat = mContext.getResources().getString(R.string.sales_id_format);
        holder.mIdView.setText(String.format(idFormat, item.getId()));

        // Set Item's registered date
        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        holder.mRegDateView.setText(dateFormat.format(item.getRegisteredDate()));

        // Set Item's value
        final NumberFormat numFromat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        holder.mValueView.setText(numFromat.format(item.getValue()));

        // Set Item's alert
        if (item.isAlert()) {
            holder.mAlertView.setVisibility(View.VISIBLE);
            holder.mLineView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorSideLineBlue));
        } else {
            holder.mAlertView.setVisibility(View.INVISIBLE);
            holder.mLineView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorSideLineGray));
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mIdView;
        public final TextView mRegDateView;
        public final TextView mValueView;
        public final ImageView mAlertView;
        public final View mLineView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.tv_sales_title);
            mIdView = (TextView) view.findViewById(R.id.tv_sales_id);
            mRegDateView = (TextView) view.findViewById(R.id.tv_sales_reg_date);
            mValueView = (TextView) view.findViewById(R.id.tv_sales_value);
            mAlertView = (ImageView) view.findViewById(R.id.iv_sales_alert);
            mLineView = view.findViewById(R.id.vw_line);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "'";
        }
    }
}
