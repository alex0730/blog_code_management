<#include "admin/common/_head.ftl">
<#include "admin/common/_left.ftl">
<link rel="stylesheet" href="/static/admin/css/interview/global.css">
<link rel="stylesheet" href="/static/admin/css/interview/global.ui.css">
<link rel="stylesheet" href="/static/admin/css/interview/base.css">
<link rel="stylesheet" href="/static/admin/css/interview/default.css">
<link rel="stylesheet" href="/static/admin/css/interview/common.css">
<link rel="stylesheet" href="/static/admin/css/interview/env.css">
<link rel="stylesheet" href="/static/admin/css/interview/element-ui.css">
<link rel="stylesheet" href="/static/admin/css/interview/exercise.css"/>
<script>
    window.selected = {"content": ""};
    window.isIntelligentPaper = false;
    window.canPauseTime = true;
    window.isContest = false;
    window.leaveCount = 0;
    // 问题信息
    window.questionInfo = {
        pid: '2238',
        tid: '41001109',
        qid: '14817',
        total: '20',
        left: '20',
        type: '1',
        uuid: '2a1cdf3e61d14947bf00dfe10e25a2c0',
        paperName: 'Java工程师能力评估'
    };
    window.isInAGroup = true;
</script>
</head>
<body>


<div class="nk-container    ">

    <div class="nk-main  clearfix" style="width: fit-content">
        <div class="module-box subject-box">
            <div class="nowcoder-topic">
                <div class="com-subject-wrap">
                    <a href="javascript:void(0);" class="com-logo"><img
                                src="https://uploadfiles.nowcoder.com/images/20191109/59_1573270956405_8A9C8878206EDC89EA273AF6F4418EA6"
                                style="height:30px;display:block;"></a>
                    <div class="com-subject-title">Java工程师能力评估</div>
                    <a href="javascript:void(0);" class="progress-time" title="暂停">
                        <i class="ico-time-control"></i><span data-left="7200" data-time="0" class="time-text"></span>
                    </a>
                </div>
                <div class="subject-title-box">
                    <div class="answer-progress">1/20</div>
                    <div class="subject-title">[单选题]</div>
                </div>
                <div class="subject-main">
                    <div class="subject-content">
                        <div class="subject-question">
                            下面有关JVM内存，说法错误的是？
                        </div>
                        <a href="javascript:void(0);" class="subject-options" data-id="18134">
                            <label class="radio">
                                <span class="icons"></span>
                                <input type="radio" data-toggle="radio" value="18134">
                                <pre>程序计数器是一个比较小的内存区域，用于指示当前线程所执行的字节码执行到了第几行，是线程隔离的</pre>
                            </label>
                        </a>
                        <a href="javascript:void(0);" class="subject-options" data-id="18135">
                            <label class="radio">
                                <span class="icons"></span>
                                <input type="radio" data-toggle="radio" value="18135">
                                <pre>虚拟机栈描述的是Java方法执行的内存模型，用于存储局部变量，操作数栈，动态链接，方法出口等信息，是线程隔离的</pre>
                            </label>
                        </a>
                        <a href="javascript:void(0);" class="subject-options" data-id="18136">
                            <label class="radio">
                                <span class="icons"></span>
                                <input type="radio" data-toggle="radio" value="18136">
                                <pre>方法区用于存储JVM加载的类信息、常量、静态变量、以及编译器编译后的代码等数据，是线程隔离的</pre>
                            </label>
                        </a>
                        <a href="javascript:void(0);" class="subject-options" data-id="18137">
                            <label class="radio">
                                <span class="icons"></span>
                                <input type="radio" data-toggle="radio" value="18137">
                                <pre>原则上讲，所有的对象都在堆区上分配内存，是线程之间共享的</pre>
                            </label>
                        </a>
                    </div>
                    <div class="subject-action clearfix">
                        <div class="subject-opr">
                            <span class="subject-opr-item"><i class="ico-collect"></i><a href="javascript:void(0);"
                                                                                         class="js-follow"
                                                                                         data-id="14817">收藏本题</a></span>
                            <span class="subject-opr-item"><i class="ico-mark"></i><a href="javascript:void(0);"
                                                                                      class="js-mark" data-id="14817"
                                                                                      data-tid="41001109">标记一下</a></span>
                            <a href="javascript:void(0);" class="subject-opr-item js-call-help"><span
                                        class="icon-nc-share3"></span>场外求助</a>
                            <a href="javascript:void(0);" class="subject-opr-item js-feedback"><span
                                        class="icon-nc-question-sign"></span>知识点有误？</a>
                        </div>
                        <div class="subject-next">
                            <form id="submitForm" method="post" action="/question/next?pid=2238&qid=14817&tid=41001109">
                                <input type="hidden" name="content" id="answer"/>
                                <input id="aheadFinish" type="submit" name="button" class="btn warning-btn"
                                       value="提前交卷">
                                <input id="next" type="submit" name="button" class="btn btn-primary" value="下一题">
                            </form>
                        </div>
                    </div>
                    <div class="subject-new-tips">* 交卷即可查看全部答案和解析，完成所有题目有机会获得企业内推</div>
                </div>
                <!-- 展开的时候加class:open -->
                <div class="answer-sheet-box">
                    <div class="answer-sheet-type">
                        <i class="icon-nc-make-up"></i>
                        <span>单选题20道</span>
                    </div>
                    <a href="javascript:void(0)" class="card-unfold">收起答题卡</a>
                    <a href="javascript:void(0)" class="card-fold">展开答题卡</a>
                    <ul class="answer-sheet-num clearfix">
                        <li>
                            <a href="javascript:void(0);" class="answering-num " data-qid="14817">
                                1
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="14941">
                                2
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="14942">
                                3
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15033">
                                4
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15040">
                                5
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15042">
                                6
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15043">
                                7
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15081">
                                8
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15095">
                                9
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15244">
                                10
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15247">
                                11
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15267">
                                12
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15274">
                                13
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15318">
                                14
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15319">
                                15
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15328">
                                16
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15366">
                                17
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15383">
                                18
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="15541">
                                19
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0);" class="" data-qid="16021">
                                20
                            </a>
                        </li>
                    </ul>
                </div>
                <script src="/static/admin/js/vendor.dll.js" type="text/javascript"></script>
                <script src="/static/admin/js/runtime.js" type="text/javascript"></script>
                <script src="/static/admin/js/common.js" type="text/javascript"></script>
                <script src="/static/admin/js/main.entry.js" type="text/javascript"></script>
                <script>
                    window.isLogin = true;
                    window.globalInfo = {
                        ownerId: '830428622',
                        anonymousUserId: '',
                        ownerName: '小吴0730',
                        ownerTinyHead: 'https://images.nowcoder.com/head/390m.png?x-oss-process=image/resize,m_mfit,h_100,w_100',
                        ownerMainHead: 'https://images.nowcoder.com/head/390m.png?x-oss-process=image/resize,m_mfit,h_200,w_200',
                        ownerEmail: true,
                        ownerPhone: true,
                        ownerType: '1',
                        status: '0',
                        honorLevel: '2',
                        gender: '',
                        isCompleteInfo: true,
                        isSpiderUser: false,
                        canLoadInIframe: 'true',
                    };
                    window.useNeteaseCaptcha = true;
                    window.showCodeCompleteV2 = true;
                </script>
                <script type="text/javascript">
                    window.ncDeployImageRoot = "//static.nowcoder.com/";
                    window.ncJsInDev = false;
                    window.ncJsInPre = false;
                    window.ncJsVersion = "1.03.28";
                    window.ncJsPluginVersion = "1.0.17";
                    window.ncIsInNowcoderMainSite = true;
                </script>
                <script type="text/javascript">
                    var _hmt = _hmt || [];
                    (function () {
                        var hm = document.createElement("script");
                        hm.src = "//hm.baidu.com/hm.js?a808a1326b6c06c437de769d1b85b870";
                        var s = document.getElementsByTagName("script")[0];
                        s.parentNode.insertBefore(hm, s);
                    })();
                    (function () {
                        !function (e, t, n, g, i) {
                            e[i] = e[i] || function () {
                                (e[i].q = e[i].q || []).push(arguments)
                            }, n = t.createElement("script"), tag = t.getElementsByTagName("script")[0], n.async = 1, n.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + g, tag.parentNode.insertBefore(n, tag)
                        }(window, document, "script", "assets.growingio.com/2.1/gio.js", "gio");
                        gio('init', 'c196c3667d214851b11233f5c17f99d5', {});
                        gio('setUserId', '830428622');
                        gio('people.set', 'user_register_new', 0);
                        gio('people.set', 'edu_level', '本科');
                        gio('people.set', 'work_time', '2021');
                        gio('people.set', 'school', '北京开放大学');
                        gio('people.set', 'school_type', 'other');
                        gio('people.set', 'job', 'Java工程师');
                        gio('people.set', 'register_client', 'PC');
                        gio('send');
                    })();
                </script>
                <link rel="stylesheet"
                      href="//static.nowcoder.com/nowcoder/1.2.1875/javascripts-wp/page/question/test/dangxuan/main.entry.css">
                <input type="hidden" id="jsQuestionInfo" data-pid="2238" data-tid="41001109" data-qid="14817"
                       data-total="20" data-left="20"/>
            </div>
            <div class="living-layer js-global-tips" style="display:none;">
                <a href="javascript:void(0);" class="icon-nc-cancel"></a>
                <a class="cont js-global-tips-href" href="" target="_blank">
                    <i class="icon-nc-play"></i>
                    <div class="living-layer-cont">
                        <p class="living-layer-title"></p>
                        <p></p>
                    </div>
                </a>
            </div>
        </div>