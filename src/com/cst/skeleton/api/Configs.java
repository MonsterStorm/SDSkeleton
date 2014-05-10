package com.cst.skeleton.api;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * API设置
 * @author MonsterStorm
 *
 */
public class Configs {
	public static final String BASE_URL = "APIService.restBaseUrl";
	public static final String TEST_USERNAME = "APIService.test.username";
	public static final String TEST_PASSWORD = "APIService.test.password";
	
	private static final String BUNDLE_NAME = "com.zkmt.api.configs";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Configs() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
