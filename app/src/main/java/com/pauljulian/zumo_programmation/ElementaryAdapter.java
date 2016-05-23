package com.pauljulian.zumo_programmation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

public class ElementaryAdapter extends ArrayAdapter<ElementaryAction> {

    private Context context;
    private List<ElementaryAction> listElementaryActions;

    public ElementaryAdapter(Context context, int resource, List<ElementaryAction> list) {
        super(context, resource, list);
        this.context = context;
        this.listElementaryActions = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Make sur we have a view to work with
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = layoutInflater.inflate(R.layout.elementary, parent, false);
        }

        // Find the elementary action to work with
        ElementaryAction currentAction = listElementaryActions.get(position);

        // Fill the view
        ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);
        imageView.setImageResource(currentAction.getIconId());

        return itemView;
    }
}