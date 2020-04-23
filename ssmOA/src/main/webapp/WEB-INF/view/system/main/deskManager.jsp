<%--
  Created by IntelliJ IDEA.
  User: JZK
  Date: 2020/4/23
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>工作台</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${ctx }/resources/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="${ctx }/resources/css/public.css" media="all" />

</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <blockquote class="layui-elem-quote layui-bg-green">
            <div id="nowTime"></div>
        </blockquote>
        <div class="layui-row layui-col-space10">
            <div class="layui-col-lg6 layui-col-md6">
                <blockquote class="layui-elem-quote title">最新文章 <i class="layui-icon layui-red">&#xe756;</i></blockquote>
                <table class="layui-table mag0" lay-skin="line">
                    <colgroup>
                        <col>
                        <col width="110">
                    </colgroup>
                    <tbody class="hot_news"></tbody>
                </table>

            </div>
        </div>
    </div>
</div>
<script src="${ctx}/resources/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="${ctx}/resources/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script type="text/javascript">
    //获取系统时间
    let newDate = '';
    getLangDate();
    //值小于10时，在前面补0
    function dateFilter(date){
        if(date < 10){return "0"+date;}
        return date;
    }
    function getLangDate(){
        let dateObj = new Date(); //表示当前系统时间的Date对象
        let year = dateObj.getFullYear(); //当前系统时间的完整年份值
        let month = dateObj.getMonth() + 1; //当前系统时间的月份值
        let date = dateObj.getDate(); //当前系统时间的月份中的日
        let day = dateObj.getDay(); //当前系统时间中的星期值
        let weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        let week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
        let hour = dateObj.getHours(); //当前系统时间的小时值
        let minute = dateObj.getMinutes(); //当前系统时间的分钟值
        let second = dateObj.getSeconds(); //当前系统时间的秒钟值
        let timeValue = "" + ((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午"); //当前时间属于上午、晚上还是下午
        newDate = dateFilter(year)+"年"+dateFilter(month)+"月"+dateFilter(date)+"日 "+" "+dateFilter(hour)+":"+dateFilter(minute)+":"+dateFilter(second);
        document.getElementById("nowTime").innerHTML = "亲爱的${user.realname}，"+timeValue+"好！ 欢迎使用尚学堂汽车出租系统。当前时间为： "+newDate+"　"+week;
        setTimeout("getLangDate()",1000);
    }
    layui.use(['layer', 'miniTab','form','element','jquery'], function () {
        let form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer,
            element = layui.element,
            $ = layui.jquery,
            miniTab = layui.miniTab;

        miniTab.listen();
        //上次登录时间【此处应该从接口获取，实际使用中请自行更换】
        $(".loginTime").html(newDate.split("日")[0]+"日</br>"+newDate.split("日")[1]);
        //icon动画
        $(".panel a").hover(function(){
            $(this).find(".layui-anim").addClass("layui-anim-scaleSpring");
        },function(){
            $(this).find(".layui-anim").removeClass("layui-anim-scaleSpring");
        })
        $(".panel a").click(function(){
            parent.addTab($(this));
        })
        //最新文章列表
        $.get("${ctx}/resources/api/newsList.json",function(data){
            var hotNewsHtml = '';
            for(var i=0;i<5;i++){
                hotNewsHtml += '<tr>'
                    +'<td align="left"><a href="javascript:;"> '+data.data[i].newsName+'</a></td>'
                    +'<td>'+data.data[i].newsTime.substring(0,10)+'</td>'
                    +'</tr>';
            }
            $(".hot_news").html(hotNewsHtml);
            $(".userAll span").text(data.length);
        })

    });
</script>
</body>
</html>
