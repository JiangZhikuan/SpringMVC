package com.mxixm.spring.boot.chapter04;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        // 开启异步处理，标记此请求为异步。
        // 标记为异步处理后，当此请求相关的Servlet与Filter执行完成后，不会关系其请求与响应。
        AsyncContext asyncContext = request.startAsync();
        // 创建异步任务，异步对Response写入
        Runnable runnable = () -> {
            // 模拟长时间的处理
            simulateLongTimeProcess(5000L);
            try {
                // 异步通过响应返回数据
                asyncContext.getResponse().getWriter().write("Hello World!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 标记异步处理完成，可以释放与此请求相关的Request与Response了。
            asyncContext.complete();
        };
        // 创建线程，执行异步任务
        new Thread(runnable).start();
        // 此处Servlet逻辑处理完成，在其相关的Filter处理返回后，与该请求关联的HTTP处理线程就会被释放
    }

    // 模拟长时间请求，参数为休眠毫秒数
    private void simulateLongTimeProcess(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}