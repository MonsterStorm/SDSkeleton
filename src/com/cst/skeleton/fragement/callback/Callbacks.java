package com.cst.skeleton.fragement.callback;

import android.os.Bundle;
import android.support.v4.app.Fragment;


/**
 * A callback interface that all activities containing this fragment must
 * implement. This mechanism allows activities to be notified of item
 * selections.
 */
public interface Callbacks {
	/**
	 * Callback for when an item has been selected.
	 */
	public void onAction(Fragment fg, Bundle data);
}