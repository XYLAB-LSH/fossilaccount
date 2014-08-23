package com.fossil.fossilaccount;

import java.io.IOException;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fossil.account.util.ImageHelper;
import com.fossil.account.util.MyLog;
import com.fossil.account.util.MyShareprefrence;

public class Fragment3 extends Fragment implements OnClickListener {
	private ImageView iv_logo;
	private TextView tv_top_center, tv_frag_nickname;
	private Context context;
	private Activity act;
	private final String IMAGE_TYPE = "image/*";
	private final int IMAGE_CODE = 1;
	private RelativeLayout rl_setting;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View parentView = inflater
				.inflate(R.layout.fragment3, container, false);
		initView(parentView);
		return parentView;
	}

	private void initView(View view) {
		act = getActivity();
		context = act.getApplicationContext();
		tv_top_center = (TextView) view.findViewById(R.id.tv_top_center);
		tv_top_center.setText("��");
		tv_frag_nickname = (TextView) view.findViewById(R.id.tv_frag_nickname);
		tv_frag_nickname.setText(MyShareprefrence.getInstance(context)
				.getNickName());
		rl_setting = (RelativeLayout) view.findViewById(R.id.rl_setting);
		rl_setting.setOnClickListener(this);

		iv_logo = (ImageView) view.findViewById(R.id.iv_logo);
		iv_logo.setOnClickListener(this);
		// ��ʾͷ��
		setImg();

	}

	private void setImg() {
		String imgPath = MyShareprefrence.getInstance(context).getLogoPath();
		if (imgPath.equals("")) {
			getBit(R.drawable.boy);
		} else {
			try {
				setLocalLogo(imgPath);
			} catch (Exception e) {
				// ��·����ͼƬ������ ����ʾĬ��
				getBit(R.drawable.boy);
			}

		}

	}

	private void setLocalLogo(String path) {
		Bitmap temp = BitmapFactory.decodeFile(path);
		iv_logo.setImageBitmap(ImageHelper.toRoundBitmap(temp));
	}

	// ����Ĭ��ͷ��
	private void getBit(int drawable) {

		Resources res = getResources();
		Bitmap bmp = BitmapFactory.decodeResource(res, drawable);
		iv_logo.setImageBitmap(ImageHelper.toRoundBitmap(bmp));
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_logo:

			// ʹ��intent����ϵͳ�ṩ����Ṧ�ܣ�ʹ��startActivityForResult��Ϊ�˻�ȡ�û�ѡ���ͼƬ
			Intent getSysImgIntent = new Intent(Intent.ACTION_GET_CONTENT);
			getSysImgIntent.setType(IMAGE_TYPE);
			startActivityForResult(getSysImgIntent, IMAGE_CODE);
			break;
		case R.id.rl_setting:
			startActivityForResult(new Intent(act, EditUserinfoAct.class), 2);
			break;
		default:
			break;
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != getActivity().RESULT_OK) { // �˴��� RESULT_OK
			MyLog.e("ActivityResult resultCode error");
			return;
		}
		MyLog.e(requestCode + ":requestCode");
		switch (requestCode) {
		case 2:
			MyLog.e("�������ã�");
			tv_frag_nickname.setText(MyShareprefrence.getInstance(context)
					.getNickName());
			break;
		case IMAGE_CODE:
			Bitmap bm = null;
			// ���ĳ������ContentProvider���ṩ���� ����ͨ��ContentResolver�ӿ�
			ContentResolver resolver = act.getContentResolver();
			try {
				Uri originalUri = data.getData(); // ���ͼƬ��uri
				bm = MediaStore.Images.Media.getBitmap(resolver, originalUri); // �Եõ�bitmapͼƬ
				// ���￪ʼ�ĵڶ����֣���ȡͼƬ��·����
				String[] proj = { MediaStore.Images.Media.DATA };
				// ������android��ý�����ݿ�ķ�װ�ӿڣ�����Ŀ�Android�ĵ�
				Cursor cursor = act.managedQuery(originalUri, proj, null, null,
						null);
				// ���Ҹ������ ����ǻ���û�ѡ���ͼƬ������ֵ
				int column_index = cursor
						.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				// �����������ͷ ���������Ҫ����С�ĺ���������Խ��
				cursor.moveToFirst();
				// ����������ֵ��ȡͼƬ·��
				String path = cursor.getString(column_index);
				MyShareprefrence.getInstance(context).setLogoPath(path);
				setLocalLogo(path);
			} catch (IOException e) {
				MyLog.e(e.toString());
			}

			break;

		default:
			break;
		}

	}
}
