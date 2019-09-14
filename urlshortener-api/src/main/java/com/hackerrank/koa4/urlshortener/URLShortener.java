package com.hackerrank.koa4.urlshortener;

import java.nio.file.ProviderNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

import com.hackerrank.koa4.urlshortener.spi.URLShortenerServiceProvider;

/**
 * A Utility class to load the providers and return a default one.
 * 
 * @author fguitton
 *
 */
public final class URLShortener {
    private static final String DEFAULT_PROVIDER = "com.hackerrank.koa4.urlshortener.impl.TinyURLShortenerServiceProvider";

    //All providers
    public static List<URLShortenerServiceProvider> providers() {
        List<URLShortenerServiceProvider> services = new ArrayList<>();
        ServiceLoader<URLShortenerServiceProvider> loader = ServiceLoader.load(URLShortenerServiceProvider.class);
        loader.forEach(urlShortenerServiceProvider -> {
            services.add(urlShortenerServiceProvider);
        });
        return services;
    }

    //Default provider
    public static URLShortenerServiceProvider provider() {
        return provider(DEFAULT_PROVIDER);
    }

    //provider by name
    public static URLShortenerServiceProvider provider(String providerName) {
        ServiceLoader<URLShortenerServiceProvider> loader = ServiceLoader.load(URLShortenerServiceProvider.class);
        Iterator<URLShortenerServiceProvider> it = loader.iterator();
        while (it.hasNext()) {
        	URLShortenerServiceProvider provider = it.next();
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("URLShortener service provider " + providerName + " not found");
    }
}
