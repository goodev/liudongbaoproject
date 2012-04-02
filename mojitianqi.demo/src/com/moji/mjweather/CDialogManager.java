// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CDialogManager.java

package com.moji.mjweather;

import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.moji.mjweather.activity.AddCityActivity;
import com.moji.mjweather.util.DownloadManager;
import com.moji.mjweather.util.Util;

// Referenced classes of package com.moji.mjweather:
//            Gl

public class CDialogManager {

	public CDialogManager(Context context, Handler handler) {
		m_fatherMsgHandler = handler;
		m_context = context;
	}

	private void downloadFromSites(Map map) {
		boolean flag = false;
		int i = 2;
		while (!flag && i < map.size()) {
			flag = true;
			String s = (new StringBuilder()).append("url").append(i).toString();
			try {
				m_context.startActivity(new Intent(
						"android.intent.action.VIEW", Uri.parse((String) map
								.get(s))));
			} catch (Exception exception) {
				flag = false;
			}
			i++;
		}
	}

	private void selectUpdateDialog(final Map map) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setTitle(0x7f0b002a)
				.setIcon(0x7f0200c5)
				.setItems(0x7f07000f,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								boolean flag = false;
								if (i == 0) {
									flag = true;
									try {
										m_context.startActivity((new Intent(
												"android.intent.action.VIEW",
												Uri.parse((String) map
														.get("url1"))))
												.setPackage("com.android.vending"));
									} catch (Exception exception) {
										flag = false;
									}
								}
								if (!flag)
									downloadFromSites(map);
							}

						}).show();
	}

	private void updateImmediatelyService() {
	 
	}

	public void CancelCurrentDialog() {
		if (m_currnetDialog != null)
			m_currnetDialog.dismiss();
		m_currnetDialog = null;
	}

	public void ShowBackGroundCheck() {
		(new android.app.AlertDialog.Builder(m_context))
				.setTitle(0x7f0b0166)
				.setSingleChoiceItems(0x7f070002, Gl.getWidgetUseBackground(),
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								Gl.saveWidgetUseBackground(i);
								updateImmediatelyService();
								dialoginterface.dismiss();
							}

						})
				.setNegativeButton(0x7f0b0018,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								dialoginterface.dismiss();
							}

						}).show();
	}

	public void ShowCloseActivityDialog(int i) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(i)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								((Activity) m_context).finish();
							}

						}).create();
		m_currnetDialog.show();
	}

	public void ShowDeleteCityYesNo(int i, final boolean deleteAll,
			final int index) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(i)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								Message message = m_fatherMsgHandler
										.obtainMessage(3);
								message.arg1 = index;
								message.obj = Boolean.valueOf(deleteAll);
								m_fatherMsgHandler.sendMessage(message);
							}

						})
				.setNegativeButton(0x7f0b0018,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
							}

						}).create();
		m_currnetDialog.show();
	}

	public void ShowMsgOKDialog(int i) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(i)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
							}

						}).create();
		m_currnetDialog.show();
	}

	public void ShowMsgOKDialogFromString(String s) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(s)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
							}

						}).create();
		m_currnetDialog.show();
	}

	public void ShowScreentypeNotifiy() {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(0x7f0b01a3)
				.setPositiveButton(0x7f0b0020,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								Intent intent = new Intent(
										"android.intent.action.DELETE",
										Uri.parse("package:com.moji.mjweather"));
								m_context.startActivity(intent);
							}

						})
				.setNegativeButton(0x7f0b001f,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								System.exit(0);
							}

						})
				.setOnCancelListener(
						new android.content.DialogInterface.OnCancelListener() {

							public void onCancel(DialogInterface dialoginterface) {
								System.exit(0);
							}

						}).create();
		m_currnetDialog.show();
	}

	public void ShowSendSuggestDialog() {
		final View textEntryView = LayoutInflater.from(m_context).inflate(
				0x7f030004, null);
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b0159)
				.setView(textEntryView)
				.setPositiveButton(0x7f0b015a,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								EditText edittext = (EditText) textEntryView
										.findViewById(0x7f0d0010);
								EditText edittext1 = (EditText) textEntryView
										.findViewById(0x7f0d0012);
								String s = edittext.getText().toString();
								String s1 = edittext1.getText().toString();
								if (s.length() > 0) {
									Message message = m_fatherMsgHandler
											.obtainMessage(106);
									message.obj = (new StringBuilder())
											.append(s).append("$").append(s1)
											.toString();
									m_fatherMsgHandler.sendMessage(message);
								} else {
									Toast.makeText(m_context, 0x7f0b01a4, 0)
											.show();
								}
							}

						})
				.setNegativeButton(0x7f0b0018,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
							}

						}).create();
		m_currnetDialog.show();
	}

	public void ShowVoiceDownLoad(final boolean needSave, int i,
			final String dataUrl) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(i)
				.setPositiveButton(0x7f0b0021,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								dialoginterface.dismiss();
								if (needSave)
									Gl.saveNotifyVoiceDataUpdate(true);
								(new DownloadManager(m_context,
										"qz1.mojichina.com", dataUrl,
										"mips.zip")).startDownLoad();
							}

						})
				.setNegativeButton(0x7f0b001f,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								dialoginterface.dismiss();
								if (needSave)
									Gl.saveNotifyVoiceDataUpdate(true);
							}

						})
				.setOnCancelListener(
						new android.content.DialogInterface.OnCancelListener() {

							public void onCancel(DialogInterface dialoginterface) {
								dialoginterface.dismiss();
								if (needSave)
									Gl.saveNotifyVoiceDataUpdate(true);
							}

						}).create();
		m_currnetDialog.show();
	}

	public void noSkinDialog(String s, final Intent intent) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(s)
				.setCancelable(false)
				.setPositiveButton(0x7f0b01a2,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								((Activity) m_context).finish();
								((Activity) m_context).startActivity(intent);
							}

						})
				.setNegativeButton(0x7f0b0026,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								((Activity) m_context).finish();
							}

						}).create();
		m_currnetDialog.show();
	}

	public void sHowSdcardDialog() {
		(new android.app.AlertDialog.Builder(m_context))
				.setTitle(0x7f0b002f)
				.setIcon(0x7f0200c5)
				.setMessage(0x7f0b015f)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								dialoginterface.dismiss();
							}

						})
				.setOnCancelListener(
						new android.content.DialogInterface.OnCancelListener() {

							public void onCancel(DialogInterface dialoginterface) {
								dialoginterface.dismiss();
							}

						}).show();
	}

	public void sHowUpdateNotify() {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(0x7f0b015e)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								dialoginterface.dismiss();
							}

						})
				.setNegativeButton(0x7f0b0018,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								dialoginterface.dismiss();
							}

						}).create();
		m_currnetDialog.show();
	}

	public void showNewVersionDialog(String s, int i, final Map map) {
		android.app.AlertDialog.Builder builder = (new android.app.AlertDialog.Builder(
				m_context)).setIcon(0x7f0200c5).setTitle(0x7f0b002f)
				.setMessage(s);
		if (i != 0)
			builder.setPositiveButton(i,
					new android.content.DialogInterface.OnClickListener() {

						public void onClick(DialogInterface dialoginterface,
								int j) {
							Gl.setHighPriorityDialogIsOpen(false);
							if (map != null) {
								if (Util.isAndroidMarketAvailable(m_context))
									selectUpdateDialog(map);
								else
									downloadFromSites(map);
							} else {
								try {
									m_context.startActivity((new Intent(
											"android.intent.action.VIEW",
											Uri.parse("market://details?id=com.moji.mjweather")))
											.setPackage("com.android.vending"));
								} catch (Exception exception) {
									Toast.makeText(m_context, 0x7f0b0028, 1)
											.show();
								}
							}
						}

					});
		builder.setNegativeButton(0x7f0b0018,
				new android.content.DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialoginterface, int j) {
						Gl.setHighPriorityDialogIsOpen(false);
					}

				});
		m_currnetDialog = builder.create();
		m_currnetDialog.show();
	}

	public void showNotifyAddCityDialog() {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(0x7f0b0034)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								Gl.setHandler(m_fatherMsgHandler);
								Intent intent = new Intent(m_context,
										AddCityActivity.class);
								Bundle bundle = new Bundle();
								bundle.putInt("cityindex", 0);
								bundle.putBoolean("isNoDisplayLocation", true);
								intent.putExtras(bundle);
								m_context.startActivity(intent);
							}

						}).create();
		m_currnetDialog.show();
	}

	public void showUrlDialog(String s, final String url) {
		String s1;
		if (s.contains(":"))
			s1 = s.substring(1 + s.indexOf(":"));
		else
			s1 = s;
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(s1)
				.setCancelable(false)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								Gl.setHighPriorityDialogIsOpen(false);
								m_context.startActivity(new Intent(
										"android.intent.action.VIEW", Uri
												.parse(url)));

							}

						})
				.setNegativeButton(0x7f0b0018,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int i) {
								Gl.setHighPriorityDialogIsOpen(false);
							}

						}).create();
		m_currnetDialog.show();
	}

	public void skinUnzipOkDialog(int i) {
		m_currnetDialog = (new android.app.AlertDialog.Builder(m_context))
				.setIcon(0x7f0200c5)
				.setTitle(0x7f0b002f)
				.setMessage(i)
				.setPositiveButton(0x7f0b0017,
						new android.content.DialogInterface.OnClickListener() {

							public void onClick(
									DialogInterface dialoginterface, int j) {
								Gl.setDownloadListInvalid(true);
								((Activity) m_context).finish();
							}

						}).create();
		m_currnetDialog.show();
	}

	private static final String TAG = "CDialogManager";
	private Context m_context;
	private Dialog m_currnetDialog;
	private Handler m_fatherMsgHandler;

}
