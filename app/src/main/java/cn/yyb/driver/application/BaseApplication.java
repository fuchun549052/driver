package cn.yyb.driver.application;

import android.app.Application;
import android.content.Context;
import org.greenrobot.greendao.database.Database;
import greendao.dao.DaoMaster;
import greendao.dao.DaoSession;


public class BaseApplication extends Application{

    private String DATABASENAME="driver";//数据库名
    private static DaoSession daoSession;
    public static BaseApplication application;
    public static Context mAppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDatabase(this);
        application=this;
        mAppContext=getApplicationContext();
    }


    /**
     * 数据库初始化
     * @param context
     */
    private void setupDatabase(Context context){
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(context,DATABASENAME);
        Database database=helper.getWritableDb();
        DaoMaster daoMaster=new DaoMaster(database);
        daoSession=daoMaster.newSession();
    }

    /**
     * 获取DaoSession
     * @return
     */
    public static DaoSession getDaoSession(){
        return daoSession;
    }

    public static BaseApplication getInstance() {
        return application;
    }

    /**获取系统上下文*/
    public static Context getAppContext()
    {
        return mAppContext;
    }
}
