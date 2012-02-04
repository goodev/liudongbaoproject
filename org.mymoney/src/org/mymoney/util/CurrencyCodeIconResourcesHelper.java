package org.mymoney.util;

import java.util.HashMap;
import java.util.Map;

import org.mymoney.R;

public class CurrencyCodeIconResourcesHelper {
	public static Map<String, Integer> map = new HashMap<String, Integer>();

	static {
		map.put("currency_icon_cny", R.drawable.currency_icon_cny);
		map.put("currency_icon_usd", R.drawable.currency_icon_usd);
		map.put("currency_icon_eur", R.drawable.currency_icon_eur);
		map.put("currency_icon_aud", R.drawable.currency_icon_aud);
		map.put("currency_icon_brl", R.drawable.currency_icon_brl);
		map.put("currency_icon_cad", R.drawable.currency_icon_cad);
		map.put("currency_icon_dkk", R.drawable.currency_icon_dkk);
		map.put("currency_icon_chf", R.drawable.currency_icon_chf);
		map.put("currency_icon_gbp", R.drawable.currency_icon_gbp);
		map.put("currency_icon_hkd", R.drawable.currency_icon_hkd);
		map.put("currency_icon_jpy", R.drawable.currency_icon_jpy);
		map.put("currency_icon_krw", R.drawable.currency_icon_krw);
		map.put("currency_icon_mop", R.drawable.currency_icon_mop);
		map.put("currency_icon_dkk", R.drawable.currency_icon_dkk);
		map.put("currency_icon_myr", R.drawable.currency_icon_myr);
		map.put("currency_icon_nzd", R.drawable.currency_icon_nzd);
		map.put("currency_icon_nok", R.drawable.currency_icon_nok);
		map.put("currency_icon_php", R.drawable.currency_icon_php);
		map.put("currency_icon_sgd", R.drawable.currency_icon_sgd);
		map.put("currency_icon_sek", R.drawable.currency_icon_sek);
		map.put("currency_icon_twd", R.drawable.currency_icon_twd);
		map.put("currency_icon_thb", R.drawable.currency_icon_thb);
		map.put("currency_icon_lkr", R.drawable.currency_icon_lkr);
		map.put("currency_icon_default", R.drawable.currency_icon_default);
	}

	public static int geResId(String resName) {
		Integer resId = (Integer) map.get(resName);
		if (resId == null)
			return R.drawable.currency_icon_default;
		return resId.intValue();

	}
}
