package ness.edu.xmlandfirebase;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class YnetDetailFragment extends Fragment {
    //Constants:
    private static final String ARG_URL = "url";

    //properties:
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ynet_detail, container, false);
        webView = (WebView) v.findViewById(R.id.webview);
        String url = getArguments().getString(ARG_URL);
        //JS


        //redirect...
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(request.getUrl().toString());
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }
        });

        webView.loadUrl(url);



        return v;
    }


    public static YnetDetailFragment newInstance(String url) {
        Bundle args = new Bundle();

        args.putString(ARG_URL, url);

        YnetDetailFragment fragment = new YnetDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
