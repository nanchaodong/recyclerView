package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.databinding.BannerItemBinding;
import com.wolf.recyclerview.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class BannerHolder extends BaseViewHolder<Advert, BannerItemBinding> {
    public BannerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Advert model, int position, BaseAdapter adapter) {
        List<Banner> topAdvs = model.getTopAdvs();
        List<String> list = new ArrayList<String>();
        if (topAdvs != null){
            for (int i = 0; i < topAdvs.size(); i++) {
                list.add(topAdvs.get(i).getImageurl());
            }
        }
        bindingView.banner.setImageLoader(new GlideImageLoader()).setImages(list).start();
    }


}
