package org.linphone.assistant;

/**********************************************************************
 * VVDN Technologies
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * VVDN Technologies. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with VVDN.
 ********************************************************************/
import org.linphone.LinphoneManager;
import org.linphone.R;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.OpenH264DownloadHelperListener;
import org.linphone.core.PayloadType;
import org.linphone.tools.OpenH264DownloadHelper;
import org.linphone.utils.AppKeyHelper;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class CodecDownloaderFragment extends Fragment {
	private Handler mHandler = new Handler();
	private TextView question;
	private TextView downloading;
	private TextView downloaded;
	private Button yes;
	private Button no;
	private Button ok;
	private ProgressBar bar;
	private TextView downloadingInfo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.assistant_codec_downloader, container, false);

		question = (TextView) view.findViewById(R.id.question);
		downloading = (TextView) view.findViewById(R.id.downloading);
		downloaded = (TextView) view.findViewById(R.id.downloaded);
		yes = (Button) view.findViewById(R.id.answerYes);
		no = (Button) view.findViewById(R.id.answerNo);
		ok = (Button) view.findViewById(R.id.answerOk);
		bar = (ProgressBar) view.findViewById(R.id.progressBar);
		downloadingInfo = (TextView) view.findViewById(R.id.downloadingInfo);

		final OpenH264DownloadHelper codecDownloader = LinphoneManager.getInstance().getOpenH264DownloadHelper();
		final OpenH264DownloadHelperListener codecListener = new OpenH264DownloadHelperListener() {

			@Override
			public void OnProgress(final int current, final int max) {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						if (current <= max) {
							hideAllItems();
							downloadingInfo.setText(current + " / " + max);
							downloadingInfo.setVisibility(View.VISIBLE);
							downloading.setVisibility(View.VISIBLE);
							bar.setMax(max);
							bar.setProgress(current);
							bar.setVisibility(View.VISIBLE);
						} else {
							hideAllItems();
							downloaded.setVisibility(View.VISIBLE);
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
								enabledH264(true);
								LinphoneManager.getLc().reloadMsPlugins(AssistantActivity.instance().getApplicationInfo().nativeLibraryDir);
								AssistantActivity.instance().endDownloadCodec();
							} else {
								// We need to restart due to bad android linker
								AssistantActivity.instance().restartApplication();
							}
						}
					}
				});
			}

			@Override
			public void OnError(final String error) {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						hideAllItems();
						downloaded.setText(R.string.error_message);
						downloaded.setVisibility(View.VISIBLE);
						ok.setVisibility(View.VISIBLE);
						enabledH264(false);
						AssistantActivity.instance().endDownloadCodec();
					}
				});
			}
		};

		codecDownloader.setOpenH264HelperListener(codecListener);

		yes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				hideAllItems();
				bar.setVisibility(View.VISIBLE);
				codecDownloader.downloadCodec();
			}
		});

		no.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				enabledH264(false);
				AssistantActivity.instance().endDownloadCodec();
			}
		});
		hideAllItems();

		if (savedInstanceState != null) {
			if (savedInstanceState.containsKey(AppKeyHelper.KEY_QUESTION))
				question.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_QUESTION));
			else
				question.setVisibility(View.VISIBLE);

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_YES))
				yes.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_YES));
			else
				yes.setVisibility(View.VISIBLE);

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_NO))
				no.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_NO));
			else
				no.setVisibility(View.VISIBLE);

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_DOWNLOADING))
				downloading.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_DOWNLOADING));

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_DOWNLOADED))
				downloaded.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_DOWNLOADED));

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_BAR))
				bar.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_BAR));

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_DOWNLOADING_INFO))
				downloadingInfo.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_DOWNLOADING_INFO));

			if (savedInstanceState.containsKey(AppKeyHelper.KEY_OK))
				ok.setVisibility((Integer) savedInstanceState.getSerializable(AppKeyHelper.KEY_OK));
		} else {
			yes.setVisibility(View.VISIBLE);
			question.setVisibility(View.VISIBLE);
			no.setVisibility(View.VISIBLE);
		}

		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		if (question != null) outState.putSerializable(AppKeyHelper.KEY_QUESTION, question.getVisibility());
		if (downloading != null) outState.putSerializable(AppKeyHelper.KEY_DOWNLOADING, downloading.getVisibility());
		if (downloaded != null) outState.putSerializable(AppKeyHelper.KEY_DOWNLOADED, downloaded.getVisibility());
		if (yes != null) outState.putSerializable(AppKeyHelper.KEY_YES, yes.getVisibility());
		if (no != null) outState.putSerializable(AppKeyHelper.KEY_NO, no.getVisibility());
		if (ok != null) outState.putSerializable(AppKeyHelper.KEY_OK, ok.getVisibility());
		if (bar != null) outState.putSerializable(AppKeyHelper.KEY_BAR, bar.getVisibility());
		if (downloadingInfo != null) outState.putSerializable(AppKeyHelper.KEY_DOWNLOADING_INFO, downloadingInfo.getVisibility());
		super.onSaveInstanceState(outState);
	}

	private void hideAllItems() {
		if (question != null) question.setVisibility(View.INVISIBLE);
		if (downloading != null) downloading.setVisibility(View.INVISIBLE);
		if (downloaded != null) downloaded.setVisibility(View.INVISIBLE);
		if (yes != null) yes.setVisibility(View.INVISIBLE);
		if (no != null) no.setVisibility(View.INVISIBLE);
		if (ok != null) ok.setVisibility(View.INVISIBLE);
		if (bar != null) bar.setVisibility(View.INVISIBLE);
		if (downloadingInfo != null) downloadingInfo.setVisibility(View.INVISIBLE);
	}

	private void enabledH264(boolean enable) {
		PayloadType h264 = null;
		for (PayloadType pt : LinphoneManager.getLc().getVideoCodecs()) {
			if (pt.getMime().equals("H264")) h264 = pt;
		}

		if (h264 != null) {
			try {
				LinphoneManager.getLc().enablePayloadType(h264, enable);
			} catch (LinphoneCoreException e) {
				e.printStackTrace();
			}
		}
	}
}
