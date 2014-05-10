package com.cst.skeleton.fragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cst.ble.R;


public class ContentFragment extends Fragment {
	public static final String ARG_ITEM_ID = "item_id";

	private String id = null;
	
	public ContentFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			id = getArguments().getString(ARG_ITEM_ID);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fg_content, container, false);

		if (id != null) {
			((TextView) rootView.findViewById(R.id.item_detail)).setText(id);
		}

		return rootView;
	}
}
