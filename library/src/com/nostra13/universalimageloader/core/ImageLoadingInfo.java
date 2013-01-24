package com.nostra13.universalimageloader.core;

import android.net.Uri;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.postprocessors.ImagePostProcessor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Information for load'n'display image task
 * 
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 * @see MemoryCacheUtil
 * @see DisplayImageOptions
 * @see ImageLoadingListener
 */
final class ImageLoadingInfo {

	final String uri;
	final String memoryCacheKey;
	final ImageView imageView;
	final ImageSize targetSize;
	final DisplayImageOptions options;
	final ImageLoadingListener listener;
	final ReentrantLock loadFromUriLock;

	public ImageLoadingInfo(String uri, ImageView imageView, ImageSize targetSize, DisplayImageOptions options, ImageLoadingListener listener, ReentrantLock loadFromUriLock) {
		this(uri, imageView, targetSize, options, listener, loadFromUriLock, null);
	}

    public ImageLoadingInfo(String uri, ImageView imageView, ImageSize targetSize, DisplayImageOptions options, ImageLoadingListener listener, ReentrantLock loadFromUriLock, ImagePostProcessor processor) {
        this.uri = Uri.encode(uri, "@#&=*+-_.,:!?()/~'%");
        this.imageView = imageView;
        this.targetSize = targetSize;
        this.options = options;
        this.listener = listener;
        this.loadFromUriLock = loadFromUriLock;
        memoryCacheKey = MemoryCacheUtil.generateKey(uri, targetSize, processor);
    }
}
