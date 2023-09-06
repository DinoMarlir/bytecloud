package net.bytemc.bytecloud.launcher.loader

import java.net.URL
import java.net.URLClassLoader

class LauncherUrlClassLoader(vararg urls: URL) : URLClassLoader(urls, ClassLoader.getSystemClassLoader()) {

    public override fun addURL(url: URL?) {
        super.addURL(url)
    }
}