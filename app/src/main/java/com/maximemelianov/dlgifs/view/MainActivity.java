package com.maximemelianov.dlgifs.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.maximemelianov.dlgifs.R;
import com.maximemelianov.dlgifs.model.PostData;
import com.maximemelianov.dlgifs.presenter.MainPresenter;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements IMainView {

    private static final String TAG = "MainActivity";

    @InjectPresenter
    public MainPresenter presenter;

    ImageView imageView;
    TextView descriptionView;
    Button prevButton;
    Button nextButton;

    private RequestOptions requestOptions = new RequestOptions()
            .centerInside()
            .placeholder(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image);
        descriptionView = findViewById(R.id.description);
        prevButton = findViewById(R.id.prev);
        prevButton.setEnabled(false);
        prevButton.setClickable(false);
        nextButton = findViewById(R.id.next);

        prevButton.setOnClickListener((v) -> presenter.prevLoad() );
        nextButton.setOnClickListener((v) -> presenter.loadPost(true) );

        imageView.setOnLongClickListener(v -> shareGif());

        presenter.loadPost(false);

    }

    @Override
    public void loading() {
//        nextButton.setEnabled(false);
        imageView.setLongClickable(false);
        loadingViews();
    }

    @Override
    public void success(PostData data) {
        imageView.setLongClickable(true);
        setDescription(data.getDescription());
        setGIF(data);
        presenter.setUpPrevButton();

    }

    private void setGIF(PostData data){

        Glide.with(this)
                .load(data.getGifURL())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        error();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "Image ready: " + data);
//                        nextButton.setEnabled(true);
                        presenter.setUpPrevButton();
                        return false;
                    }
                })
                .into(imageView);
    }

    @Override
    public void error() {
        imageView.setLongClickable(true);
        Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show();
        presenter.setUpPrevButton();
    }

    @Override
    public void prevEnabled(boolean enabled) {
        prevButton.setEnabled(enabled);
    }

    private void loadingViews(){
        setDescription("loading...");
//        Glide.with(this)
//                .load(R.drawable.placeholder)
//                .placeholder(R.drawable.placeholder)
//                .into(imageView);
    }

    private void setDescription(String description){
        descriptionView.setText(description);
    }

    private boolean shareGif(){
        String message = getString(R.string.checkout) + "\n" +
                presenter.getCurrentPostData().getDescription() + "\n" +
                presenter.getCurrentPostData().getGifURL();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, getString(R.string.share_gif)));
        return false;
    }

}