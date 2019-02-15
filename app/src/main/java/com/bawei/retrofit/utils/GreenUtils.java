package com.bawei.retrofit.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bawei.retrofit.greendao.DaoMaster;
import com.bawei.retrofit.greendao.DaoSession;

public class GreenUtils {
    private static  volatile GreenUtils instance;
    private DaoSession daoSession;

    public static GreenUtils getInstance(){
        if(instance==null)
        {
            synchronized (GreenUtils.class){
                if(instance==null)
                {
                    instance = new GreenUtils();
                }
            }
        }
        return instance;
    }
    public void initGreen(Context context)
    {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "shop.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }
    public DaoSession getDaoSession() {
        return daoSession;
    }

}
