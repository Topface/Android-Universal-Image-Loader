package com.nostra13.universalimageloader.postprocessors;

import android.graphics.Bitmap;

abstract public class ImagePostProcessor {
    abstract public String getCachePrefix();

    abstract public Bitmap processBitmap(Bitmap bitmap);

    public String addCachePrefix(String cacheKey) {
        return getCachePrefix() + "_" + cacheKey;
    }
}
