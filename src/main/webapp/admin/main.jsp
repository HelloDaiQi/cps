<%--
  Created by IntelliJ IDEA.
  User: DaiQi
  Date: 2018/2/7
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="cps"/>

<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${cps}/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="${cps}/static/build/css/font-awesome.min.css">
    <style>
        .info-box {
            height: 85px;
            background-color: white;
            background-color: #ecf0f5;
        }

        .info-box .info-box-icon {
            border-top-left-radius: 2px;
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 2px;
            display: block;
            float: left;
            height: 85px;
            width: 85px;
            text-align: center;
            font-size: 45px;
            line-height: 85px;
            background: rgba(0, 0, 0, 0.2);
        }

        .info-box .info-box-content {
            padding: 5px 10px;
            margin-left: 85px;
        }

        .info-box .info-box-content .info-box-text {
            display: block;
            font-size: 14px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            text-transform: uppercase;
        }

        .info-box .info-box-content .info-box-number {
            display: block;
            font-weight: bold;
            font-size: 18px;
        }

        .major {
            font-weight: 10px;
            color: #01AAED;
        }

        .main {
            margin-top: 25px;
        }

        .main .layui-row {
            margin: 10px 0;
        }
    </style>
    <script src="${cps}/static/layui/layui.js"></script>
</head>
<script>
    layui.use(['layer','jquery'], function() {
        var $ = layui.jquery;
        $('#test').on('click', function() {
            parent.message.show({
                skin: 'cyan'
            });
        });


    });
</script>
<body>
<div class="layui-fluid main">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#00c0ef !important;color:white;"><i class="fa fa-ambulance" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">CPU Traffic</span>
                    <span class="info-box-number">90%</span>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#dd4b39 !important;color:white;"><i class="fa fa-google-plus" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">Likes</span>
                    <span class="info-box-number">25,412</span>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#00a65a !important;color:white;"><i class="fa fa-shopping-bag" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">Sales</span>
                    <span class="info-box-number">654</span>
                </div>
            </div>
        </div>
        <div class="layui-col-md3">
            <div class="info-box">
                <span class="info-box-icon" style="background-color:#f39c12 !important;color:white;"><i class="fa fa-users" aria-hidden="true"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">New Members</span>
                    <span class="info-box-number">85</span>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md12">
            <ul class="layui-timeline">
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">置顶的说明文档</h3>
                        <ul>
                            <li>开始做毕业设计。。。。。</li>
                        </ul>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-01</h3>
                        <p>
                        <h3>#双子座真的很纠结</h3>
                        <ul>
                            <li>第二次题目申报表审核通过了，心里稍微舒服了一点，毕竟题目很重要，如果题目都审核不通过，也就没有什么毕业设计了。</li>
                            <li>可是更大的麻烦还在后面，仅仅只想了个题目，具体要做什么自己还真没有太具体的想法。</li>
                            <li>想当学霸力不从心，想当罢学狠不下心来。自己做不出来好的毕业设计，却又舍不得花钱买，心累！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-04</h3>
                        <p>
                        <h3>#再不做就来不及了</h3>
                        <ul>
                            <li>今天向指导老师提交任务书的时候，老师并没有像往常一样只说嗯、知道了，而是向我提了一些意见，说我的想法还不够具体。</li>
                            <li>对于存在的问题，我还是并不讨厌别人向我提的，虽然一点头绪都没有，但是确实该好好考虑我的毕业设计的问题了。</li>
                            <li>那明天先设计一下数据库吧！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-05</h3>
                        <p>
                        <h3>#开始设计数据库</h3>
                        <ul>
                            <li>大概自己想的数据库表设计了一下。</li>
                            <li>不知道是自己学的不好，还是经验不足，总感觉设计的不是特别合理。</li>
                            <li>就先这样了，在做的过程中边做边改吧</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-06</h3>
                        <p>
                        <h3>#搭建系统环境</h3>
                        <ul>
                            <li>开发语言：JAVA</li>
                            <li>开发工具：IntelliJ IDEA</li>
                            <li>数据库：MySQL</li>
                            <li>后台代码框架：Spring+SpringMVC+Mybatis</li>
                            <li>前台代码框架：html+css+JavaScript+bootstrap+layui</li>
                            <li>托管项目：maven</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-07</h3>
                        <p>
                        <h3>#环境搭建完成，准备写代码</h3>
                        <ul>
                            <li>系统前台管理系统的界面代码不打算自己去写了，在网上找一份模板，改一下</li>
                            <li>心累，模板也不是这么好改的，不过还不算太糟糕</li>
                            <li>后台基础代码，首先采用mybatis逆向工程生成简单的实体类，其他的在做的过程中自己添加</li>
                            <li>初步想法是这样，不过先把以上的基础搞好</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-24</h3>
                        <p>
                        <h3>#又回到了学校，好像一个星期没碰电脑了</h3>
                        <ul>
                            <li>。。。</li>
                            <li>。。。</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-02-28</h3>
                        <p>
                        <h3>#双重打击</h3>
                        <ul>
                            <li>任务书</li>
                            <li>开题报告</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-03-01</h3>
                        <p>
                        <h3>#备战省考</h3>
                        <ul>
                            <li>2018年的江苏省考就要开始了，可是买的一套华图的资料翻也没翻过</li>
                            <li>国考的时候考的并不好，但是发现省考的竞争力更大，估计这次要淹死了</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-03-24</h3>
                        <p>
                        <h3>#省考结束了</h3>
                        <ul>
                            <li>折腾了一天，终于结束了！</li>
                            <li>真的巧啊，国考的时候和班长一个考点，现在省考又在一个考点！</li>
                            <li>班长说还要继续参加安徽省考，我就不掺和了，估计没被淹死，也要被挤死了（苦笑）！</li>
                            <li>又是十几二十天没写代码，手又生了（其实根本就不会）！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-03-25</h3>
                        <p>
                        <h3>#写周报</h3>
                        <ul>
                            <li>负(sha)责(bi)的学校要求我们每周都要写周报！</li>
                            <li>连续写了好几周了，都没给批改（我猜根本就没看过）！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-03-28</h3>
                        <p>
                        <h3>#愁死了，没工作</h3>
                        <ul>
                            <li>大早上的去一家小公司面试了！</li>
                            <li>面完试我估计就凉了，问了三个问题，两个半不会（苦笑）！</li>
                            <li>这个确实怪我自己，没准备好，人拒绝我也很正常！</li>
                            <li>完了，在徐州投了几家都没反应，估计是凉了！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-03-30</h3>
                        <p>
                        <h3>#继续码代码</h3>
                        <ul>
                            <li>emmmm</li>
                            <li>实际大致的框架已经搭起来了（我自己认为的，还都没有给老师看过（苦笑））！</li>
                            <li>接下来主要就是处理一些细节性的东西，比如登录，注册，修改密码等等！</li>
                            <li>实际上我感觉，项目管理那一块做的还不太好，总觉得逻辑上处理的不太好！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-03-31</h3>
                        <p>
                        <h3>#继续码代码</h3>
                        <ul>
                            <li>其实我真的不奢望什么，只希望我的毕业设计能顺顺利利的</li>
                            <li>明天就四月份了，心里越来越烦躁了，毕业设计没做好，也不敢出远门去找工作！</li>
                            <li>只希望可以顺利毕业，拿到毕业证以及学位证书，然后找一份正当的工作！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-04-01</h3>
                        <p>
                        <h3>#继续码代码</h3>
                        <ul>
                            <li>做了一个小功能</li>
                            <li>实现了密码记住功能</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-05-02</h3>
                        <p>
                        <h3>#突然想写点什么</h3>
                        <ul>
                            <li>不知不觉距离我上次写心得体会已过一月有余</li>
                            <li>时间转瞬即逝，有如白驹过隙，忽然而已</li>
                            <li>毕业设计也就这样了，我已无力再改变什么了，也拿给老师看了，虽然被批的一塌糊涂</li>
                            <li>老师说，管理系统已经落后了，做一个APP多好</li>
                            <li>其实我也有点明白老师说的话，现在安卓确实蛮火的，有的人可以不用电脑，但是不能没有手机</li>
                            <li>但是实在是技术有限，心有余而力不足</li>
                            <li>虽然老师不喜欢我做的东西，但是我确实有认认真真去做的，基本也符合学校要求，最后努力答辩争取通过</li>
                            <li>谋事在人，成事在天，接下来好好写论文，争取顺利毕业！</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <h3 class="layui-timeline-title">2018-05-18</h3>
                        <p>
                        <h3>#继续写点什么</h3>
                        <ul>
                            <li>上周又去找了一下老师</li>
                            <li>系统被批的一塌糊涂不说，50多页的论文估计也就剩10几页能用了</li>
                            <li>噫嘘唏，我做的他不喜欢，他说的我不懂。江山易得，人心难测啊，谁能告诉我，他到底想看到什么样的论文</li>
                        </ul>
                        <h3>#继续写点什么</h3>
                        <ul>
                            <li>屈原尚能跪敷衽以陈词，而我却无处倾诉心中的苦闷</li>
                            <li>没找到工作不说，学校还逼着交第三方协议</li>
                            <li>俗话说的好，胳膊拗不过大腿，况且，我不是胳膊，学校也不是大腿</li>
                            <li>一个天，一个地，要想毕业，只得屈服其淫威之下</li>
                        </ul>
                        </p>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <div class="layui-timeline-title">2018年</div>
                    </div>
                </li>
                <li class="layui-timeline-item">
                    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                    <div class="layui-timeline-content layui-text">
                        <div class="layui-timeline-title">更新日志</div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
