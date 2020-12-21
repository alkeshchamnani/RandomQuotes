package com.alkesh.randomquote.common.base;

import com.alkesh.randomquote.core.db.DbInstance;
import com.alkesh.randomquote.core.network.retrofitService.RetrofitService;

open class BaseRepository {
    val dbInstance = DbInstance.getInstance()
    val retrofit = RetrofitService.getInstance()

}