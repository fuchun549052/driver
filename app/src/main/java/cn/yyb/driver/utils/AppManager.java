package cn.yyb.driver.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import java.util.Iterator;
import java.util.Stack;

/**
 * author : lfc
 * esc   : 用于退出程序用（退出所有activity）
 * version: 1.0
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager instance;
    /**
     * 主Activity
     */
    private static Class<? extends Activity> mainAct;

    public static Class<? extends Activity> getMainAct() {
        if (null == mainAct) {
            try {
                //为了代码隔离,暂时以反射的方式实现
                //noinspection unchecked
                mainAct = (Class<? extends Activity>) Class.forName("com.yhbc.yhz.buffet.view.activity.StartActivity");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mainAct;
    }

    private AppManager(){}
    /**
     * 单一实例
     */
    public static AppManager getAppManager(){
        if(instance==null){
            instance=new AppManager();
        }
        return instance;
    }
    /**
     * 添加Activity到堆栈 */
    public void addActivity(Activity activity){
        if(activityStack==null){
            activityStack=new Stack<Activity>();
        }
        activityStack.add(activity);
    }
    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity(){
        Activity activity=activityStack.lastElement();
        return activity;
    }
    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity(){
        Activity activity=activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity2(Class<?> cls) {
        if (activityStack == null || activityStack.isEmpty()) {
            return;
        }
        Iterator<Activity> it = activityStack.iterator();
        while (it.hasNext()) {
            Activity activity = it.next();
            if (activity.getClass().equals(cls)) {
                it.remove();
                activity.finish();
            }
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity){
        if(activity!=null){
            activityStack.remove(activity);
            activity.finish();
        }
    }
    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls){
        for (Activity activity : activityStack) {
            if(activity.getClass().equals(cls) ){
                finishActivity(activity);
            }
        }
    }
    /**
     * 结束所有Activity
     */
    public static void finishAllActivity(){
        for (int i = 0, size = activityStack.size(); i < size; i++){
            if (null != activityStack.get(i)){
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
            System.exit(0);
        } catch (Exception e) { }
    }
}
