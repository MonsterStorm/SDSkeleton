package com.cst.skeleton.fragement.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cst.skeleton.fragement.callback.Callbacks;


/**
 * Fragment 基类
 * @author MonsterStorm
 * 
 */
public class BaseFragment extends Fragment {
	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	protected Callbacks mCallbacks = sDummyCallbacks;

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onAction(Fragment fg, Bundle data) {
		}
	};

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException("Activity must implement fragment's callbacks.");
		}

		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();

		// Reset the active callbacks interface to the dummy implementation.
		mCallbacks = sDummyCallbacks;
	}
	
	public Callbacks getCallbacks() {
		return mCallbacks;
	}
}
