package com.cst.skeleton.fragement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cst.ble.R;


public class WelcomeFragment extends Fragment {
	
	public WelcomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fg_welcome, container, false);
		return rootView;
	}
}
