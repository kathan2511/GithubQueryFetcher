package com.intkhabahmed.githubquery;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Constants {
    public static final String BASE_URL = "https://api.github.com/";
    public final static String PARAM_QUERY = "q";

    /*
     * The sort field. One of stars, forks, or updated.
     * Default: results are sorted by best match if no field is specified.
     */
    public final static String PARAM_SORT = "sort";
    public final static String sortBy = "stars";

    public static URL getUrl(String query) {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, query)
                .appendQueryParameter(PARAM_SORT, sortBy)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getRepositories(String query) {
        //https://api.github.com/search/repositories?q=BakeNShake&sort=stars
        URL url = getUrl(query);
        String jsonResult = null;
        if (url != null) {
            try {
                HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                Scanner scanner =new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                if (scanner.hasNext()) {
                    jsonResult = scanner.next();
                }
                inputStream.close();
                urlConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonResult;
    }
}
