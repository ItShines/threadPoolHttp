package com.liaotian.api.utils.main;

import com.liaotian.api.utils.CustomThreadPoolExecutor;
import com.liaotian.api.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class TestCustom {
    public static void main(String[] args) {
        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor();
        executor.init();
        ExecutorService customThreadPoolExecutor = executor.getCustomThreadPoolExecutor();
        int iLength = 100;
        String url = "";
        for (int i = 0; i < iLength; i++) {
            System.out.println("提交第" + i + "个任务!");
            customThreadPoolExecutor.execute(
                    new Thread(() -> {
                        Map param = new HashMap();
                        param.put("", "");
                        String result = HttpClientUtil.doGet(url, param);
                        System.out.println("result is " + result);
                    })
            );
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
