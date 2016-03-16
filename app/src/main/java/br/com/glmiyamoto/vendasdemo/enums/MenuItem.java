package br.com.glmiyamoto.vendasdemo.enums;

import br.com.glmiyamoto.vendasdemo.R;

/**
 * Created by Gustavo-VAIO on 2016/03/15.
 */
public enum MenuItem {
    MY_SALES(R.drawable.ico_minhas_vendas, R.string.menu_my_sales, null, true),
    MY_PRODUCTS(R.drawable.ico_meus_produtos, R.string.menu_my_products, null, true),
    AFFILIATES(R.drawable.ico_afiliados, R.string.menu_affiliates, "121", true),
    MESSAGES(R.drawable.ico_mensagens, R.string.menu_messages, "+50", false),
    NOTIFICATIONS(R.drawable.ico_notificacoes, R.string.menu_notifications, "15", false),
    MY_ACCOUNT(R.drawable.ico_minha_conta, R.string.menu_my_account, null, true),
    ABOUT_APPS(R.drawable.ico_sobre_o_app, R.string.menu_about_apps, null, true);

    private int mIconResId;
    private int mTitleResId;
    private String mCounter;
    private boolean mEnabled;

    MenuItem(final int iconResId, final int titleResId, final String counter, final boolean enabled) {
        mIconResId = iconResId;
        mTitleResId = titleResId;
        mCounter = counter;
        mEnabled = enabled;
    }

    public int getIconResId() {
        return mIconResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public String getCounter() {
        return mCounter;
    }

    public boolean isEnabled() {
        return mEnabled;
    }
}
