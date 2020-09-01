package com.maximemelianov.dlgifs.api;

import com.maximemelianov.dlgifs.model.PostData;

public class ResponseToPostConverter {
    public static PostData convert(ResponseData response){
        return new PostData(response.getId(), response.getGifURL(), response.getDescription());
    }
}
