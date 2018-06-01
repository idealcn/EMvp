package com.xuan.eapi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.xuan.eapi.helper.ToolKitContext;
import com.xuan.eapi.component.Component;

/**
 * Author : xuan.
 * Date : 2018/5/14.
 * Description :the description of this file
 */

public class EAdapter extends RecyclerView.Adapter<Component> {
    private ToolKitContext toolKitContext;

    public EAdapter(ToolKitContext toolKitContext) {
        this.toolKitContext = toolKitContext;
    }

    @Override
    public Component onCreateViewHolder(ViewGroup parent, int viewType) {
        return toolKitContext.createComponent(viewType, parent);
    }

    @Override
    public void onBindViewHolder(Component holder, int position) {
        holder.onBind(position, toolKitContext.getItem(position));
    }

    @Override
    public int getItemCount() {
        return toolKitContext.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return toolKitContext.getItemType(position);
    }
}