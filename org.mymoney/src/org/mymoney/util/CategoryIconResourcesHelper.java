package org.mymoney.util;

import java.util.HashMap;

import org.mymoney.R;

public class CategoryIconResourcesHelper {
	public static HashMap<String, Integer> map = new HashMap<String, Integer>();

	static {
		map.put("icon_jjwy", R.drawable.icon_jjwy);
		map.put("icon_jjwy_fz", R.drawable.icon_jjwy_fz);
		map.put("icon_jjwy_rcyp", R.drawable.icon_jjwy_rcyp);
		map.put("icon_jjwy_sdmq", R.drawable.icon_jjwy_sdmq);
		map.put("icon_jjwy_wygl", R.drawable.icon_jjwy_wygl);
		map.put("icon_jjwy_yxby", R.drawable.icon_jjwy_yxby);
		map.put("icon_jltx", R.drawable.icon_jltx);
		map.put("icon_jltx_sjf", R.drawable.icon_jltx_sjf);
		map.put("icon_jltx_swf", R.drawable.icon_jltx_swf);
		map.put("icon_jltx_yjf", R.drawable.icon_jltx_yjf);
		map.put("icon_jltx_zjf", R.drawable.icon_jltx_zjf);
		map.put("icon_jrbx", R.drawable.icon_jrbx);
		map.put("icon_jrbx_ajhk", R.drawable.icon_jrbx_ajhk);
		map.put("icon_jrbx_lxzc", R.drawable.icon_jrbx_lxzc);
		map.put("icon_jrbx_pcfk", R.drawable.icon_jrbx_pcfk);
		map.put("icon_jrbx_tzks", R.drawable.icon_jrbx_tzks);
		map.put("icon_jrbx_xfss", R.drawable.icon_jrbx_xfss);
		map.put("icon_jrbx_yhsx", R.drawable.icon_jrbx_yhsx);
		map.put("icon_qtzx", R.drawable.icon_qtzx);
		map.put("icon_qtzx_lzss", R.drawable.icon_qtzx_lzss);
		map.put("icon_qtzx_qtzc", R.drawable.icon_qtzx_qtzc);
		map.put("icon_qtzx_ywds", R.drawable.icon_qtzx_ywds);
		map.put("icon_rqwl", R.drawable.icon_rqwl);
		map.put("icon_rqwl_csjz", R.drawable.icon_rqwl_csjz);
		map.put("icon_rqwl_hrqc", R.drawable.icon_rqwl_hrqc);
		map.put("icon_rqwl_slqk", R.drawable.icon_rqwl_slqk);
		map.put("icon_rqwl_xjjz", R.drawable.icon_rqwl_xjjz);
		map.put("icon_spjs", R.drawable.icon_spjs);
		map.put("icon_spjs_sgls", R.drawable.icon_spjs_sgls);
		map.put("icon_spjs_yjc", R.drawable.icon_spjs_yjc);
		map.put("icon_spjs_zwwc", R.drawable.icon_spjs_zwwc);
		map.put("icon_xcjt", R.drawable.icon_xcjt);
		map.put("icon_xcjt_dczc", R.drawable.icon_xcjt_dczc);
		map.put("icon_xcjt_ggjt", R.drawable.icon_xcjt_ggjt);
		map.put("icon_xcjt_sjcfy", R.drawable.icon_xcjt_sjcfy);
		map.put("icon_xxjx", R.drawable.icon_xxjx);
		map.put("icon_xxjx_pxjx", R.drawable.icon_xxjx_pxjx);
		map.put("icon_xxjx_sbzz", R.drawable.icon_xxjx_sbzz);

		map.put("icon_xxjx_smzb", R.drawable.icon_xxjx_smzb);
		map.put("icon_xxyl", R.drawable.icon_xxyl);
		map.put("icon_xxyl_cwbb", R.drawable.icon_xxyl_cwbb);
		map.put("icon_xxyl_fbjh", R.drawable.icon_xxyl_fbjh);
		map.put("icon_xxyl_lydj", R.drawable.icon_xxyl_lydj);
		map.put("icon_xxyl_xxwl", R.drawable.icon_xxyl_xxwl);
		map.put("icon_xxyl_ydjs", R.drawable.icon_xxyl_ydjs);
		map.put("icon_yfsp", R.drawable.icon_yfsp);
		map.put("icon_yfsp_hzsp", R.drawable.icon_yfsp_hzsp);
		map.put("icon_yfsp_xmbb", R.drawable.icon_yfsp_xmbb);
		map.put("icon_yfsp_yfkz", R.drawable.icon_yfsp_yfkz);
		map.put("icon_ylbj", R.drawable.icon_ylbj);
		map.put("icon_ylbj_bjf", R.drawable.icon_ylbj_bjf);
		map.put("icon_ylbj_mrf", R.drawable.icon_ylbj_mrf);
		map.put("icon_ylbj_ypf", R.drawable.icon_ylbj_ypf);
		map.put("icon_ylbj_zlf", R.drawable.icon_ylbj_zlf);
		map.put("default_firstlevelcategory_icon",
				R.drawable.default_firstlevelcategory_icon);
		map.put("default_subcategory_icon",
				R.drawable.default_subcategory_icon);
		map.put("icon_zysr", R.drawable.icon_zysr);
		map.put("icon_zysr_gzsr", R.drawable.icon_zysr_gzsr);
		map.put("icon_zysr_lxsr", R.drawable.icon_zysr_lxsr);
		map.put("icon_zysr_jbsr", R.drawable.icon_zysr_jbsr);
		map.put("icon_zysr_jjsr", R.drawable.icon_zysr_jjsr);
		map.put("icon_zysr_tzsr", R.drawable.icon_zysr_tzsr);
		map.put("icon_zysr_jzsr", R.drawable.icon_zysr_jzsr);
		map.put("icon_qtsr", R.drawable.icon_qtsr);
		map.put("icon_qtsr_ljsr", R.drawable.icon_qtsr_ljsr);
		map.put("icon_qtsr_zjsr", R.drawable.icon_qtsr_zjsr);
		map.put("icon_qtsr_ywlq", R.drawable.icon_qtsr_ywlq);
		map.put("icon_qtsr_jysd", R.drawable.icon_qtsr_jysd);
	}

	public static int geResId(String resName) {
		Integer resId = (Integer) map.get(resName);
		if (resId == null)
			return R.drawable.default_subcategory_icon;
		return resId.intValue();

	}

}
