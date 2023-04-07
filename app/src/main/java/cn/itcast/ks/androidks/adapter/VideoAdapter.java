package cn.itcast.ks.androidks.adapter;

import android.widget.BaseAdapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import cn.itcast.ks.androidks.R;
import cn.itcast.ks.androidks.bean.VideoBean;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Administrator on 2023/4/7.
 */



public class VideoAdapter extends BaseAdapter {
        int[] mVideoIndexs = {0, 1,2,3,4};
        Context mContext;
        int mPager = -1;

        public VideoAdapter(Context context) {
            this.mContext = context;
        }

        public VideoAdapter(Context context, int pager) {
            this.mContext = context;
            this.mPager = pager;
        }

        @Override
        public int getCount() {
            return mPager == -1 ? mVideoIndexs.length : 5;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (null == convertView) {
                holder = new ViewHolder();
                LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
                convertView = mLayoutInflater.inflate(R.layout.video_listview_item, null);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mJCVideoPlayerStandard =  convertView.findViewById(R.id.videoplayer);
            if (mPager == -1) {
                holder.mJCVideoPlayerStandard.setUp(
                        VideoBean.mVideoUrls[0][position], JCVideoPlayer.SCREEN_LAYOUT_LIST,
                        VideoBean.mVideoTitles[0][position]);
                Log.e("TAG", "setUp" + position);
                Picasso.with(convertView.getContext())
                        .load(VideoBean.mVideoThumbs[0][position])
                        .into(holder.mJCVideoPlayerStandard.thumbImageView);
            } else {
                holder.mJCVideoPlayerStandard.setUp(
                        VideoBean.mVideoUrls[mPager][position], JCVideoPlayer.SCREEN_LAYOUT_LIST,
                        VideoBean.mVideoTitles[mPager][position]);
                Picasso.with(convertView.getContext())
                        .load(VideoBean.mVideoThumbs[mPager][position])
                        .into(holder.mJCVideoPlayerStandard.thumbImageView);
            }
            return convertView;
        }

        class ViewHolder {
            JCVideoPlayerStandard mJCVideoPlayerStandard;
        }
}
