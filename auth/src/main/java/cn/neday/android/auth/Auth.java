package cn.neday.android.auth;

import android.content.Context;

import com.therouter.app.flowtask.lifecycle.FlowTask;
import com.therouter.flow.TheRouterFlowTask;

import cn.neday.android.auth.config.KoinConfig;

public class Auth {

    /**
     * 将会在主线程初始化
     */
    @FlowTask(taskName = "auth_init", dependsOn = TheRouterFlowTask.APP_ONCREATE)
    public static void init(Context context) {
        System.out.println("main线程=========应用启动就会执行");
        KoinConfig.INSTANCE.init();
    }
}
