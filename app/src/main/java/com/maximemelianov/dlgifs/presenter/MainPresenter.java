package com.maximemelianov.dlgifs.presenter;


import android.graphics.drawable.Drawable;
import android.util.Log;

import com.maximemelianov.dlgifs.api.APIConfig;
import com.maximemelianov.dlgifs.api.APIServerConstructor;
import com.maximemelianov.dlgifs.api.APIService;
import com.maximemelianov.dlgifs.api.ResponseData;
import com.maximemelianov.dlgifs.api.ResponseToPostConverter;
import com.maximemelianov.dlgifs.model.PostData;
import com.maximemelianov.dlgifs.view.IMainView;

import java.util.LinkedList;
import java.util.Map;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class MainPresenter extends MvpPresenter<IMainView> {

    private static final String TAG = "MainPresenter";

    private APIService service;

    private LinkedList<PostData> postDatas = new LinkedList<>();

    private PostData currentPostData;

    public MainPresenter(){
        service = APIServerConstructor.CreateService(APIService.class);
    }

    public void setUpPrevButton(){
        boolean enabled = postDatas.indexOf(currentPostData) > 0;
        getViewState().prevEnabled(enabled);
    }

//    public void deletePost(PostData post){
//        if (!postDatas.contains(post)) return;
//        int idx = postDatas.indexOf(post);
//        if (post == currentPostData){
//            if (idx > 0){
//                currentPostData = postDatas.get(idx-1);
//            } else {
//                if (postDatas.size() > 1){
//                    currentPostData = postDatas.get(idx+1);
//                } else {
//                    currentPostData = null;
//                }
//            }
//        }
//        postDatas.remove(idx);
//    }

    public void loadPost(boolean isNext){

        getViewState().loading();

        if (isNext && postDatas.indexOf(currentPostData) < postDatas.size()-1){
            loadNext();
            return;
        }

        if (!isNext && currentPostData != null){
            getViewState().success(currentPostData);
            return;
        }

        Call<ResponseData> call = service.getRandomPost(APIConfig.JSON_PARAM);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.body() != null){
                    currentPostData = ResponseToPostConverter.convert(response.body());
                    postDatas.addLast(currentPostData);
                    getViewState().success(currentPostData);
                } else {
                    getViewState().error();
                    setUpPrevButton();
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                getViewState().error();
                setUpPrevButton();
            }
        });
    }

    private void loadNext(){
        int idx = postDatas.indexOf(currentPostData);
        idx++;
        currentPostData = postDatas.get(idx);
        getViewState().success(currentPostData);
    }

    public void prevLoad(){
        if (currentPostData == null || postDatas.isEmpty() || postDatas.size() <= 1) return;
        int idx = postDatas.indexOf(currentPostData);
        --idx;
        if (idx < 0) idx = 0;
        currentPostData = postDatas.get(idx);
        getViewState().success(currentPostData);
    }

    public PostData getCurrentPostData(){
        return currentPostData;
    }

}
