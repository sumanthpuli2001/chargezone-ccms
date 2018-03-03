<%@page import="com.bul.zydex.model.EmployeeMaster"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<script src="StorageYard/JS/jssor.slider-27.0.3.min.js"></script>
<!DOCTYPE html>
<style>
    body {font-family: Arial, Helvetica, sans-serif;}

    #myImg {
        border-radius: 5px;
        cursor: pointer;
        transition: 0.3s;
    }

    #myImg:hover {opacity: 0.7;}

    /* The Modal (background) */
    /*    .modal {
            display: none;  Hidden by default 
            position: fixed;  Stay in place 
            z-index: 1;  Sit on top 
            padding-top: 100px;  Location of the box 
            left: 0;
            top: 0;
            width: 100%;  Full width 
            height: 100%;  Full height 
            overflow: auto;  Enable scroll if needed 
            background-color: rgb(0,0,0);  Fallback color 
            background-color: rgba(0,0,0,0.9);  Black w/ opacity 
        }*/

    /* Modal Content (image) */
    /*    .modal-content {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
        }*/

    /* Caption of Modal Image */
    /*    #caption {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
            text-align: center;
            color: #ccc;
            padding: 10px 0;
            height: 150px;
        }*/

    /* Add Animation */
    /*    .modal-content, #caption {    
            -webkit-animation-name: zoom;
            -webkit-animation-duration: 0.6s;
            animation-name: zoom;
            animation-duration: 0.6s;
        }*/

    /*    @-webkit-keyframes zoom {
            from {-webkit-transform:scale(0)} 
            to {-webkit-transform:scale(1)}
        }
    
        @keyframes zoom {
            from {transform:scale(0)} 
            to {transform:scale(1)}
        }*/

    /* The Close Button */
    /*    .close {
            position: absolute;
            top: 15px;
            right: 35px;
            color: #f1f1f1;
            font-size: 40px;
            font-weight: bold;
            transition: 0.3s;
        }
    
        .close:hover,
        .close:focus {
            color: #bbb;
            text-decoration: none;
            cursor: pointer;
        }*/

    /* 100% Image Width on Smaller Screens */
    /*    @media only screen and (max-width: 700px){
            .modal-content {
                width: 100%;
            }
        }*/
    /*jssor slider loading skin spin css*/
    .jssorl-009-spin img {
        animation-name: jssorl-009-spin;
        animation-duration: 1.6s;
        animation-iteration-count: infinite;
        animation-timing-function: linear;
    }

    @keyframes jssorl-009-spin {
        from { transform: rotate(0deg); }
        to { transform: rotate(360deg); }
    }

    /*jssor slider bullet skin 052 css*/
    .jssorb052 .i {position:absolute;cursor:pointer;}
    .jssorb052 .i .b {fill:#000;fill-opacity:0.3;}
    .jssorb052 .i:hover .b {fill-opacity:.7;}
    .jssorb052 .iav .b {fill-opacity: 1;}
    .jssorb052 .i.idn {opacity:.3;}

    /*jssor slider arrow skin 053 css*/
    .jssora053 {display:block;position:absolute;cursor:pointer;}
    .jssora053 .a {fill:none;stroke:#fff;stroke-width:640;stroke-miterlimit:10;}
    .jssora053:hover {opacity:.8;}
    .jssora053.jssora053dn {opacity:.5;}
    .jssora053.jssora053ds {opacity:.3;pointer-events:none;}
</style>-->

<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head onload="showSlides(1);">
        <title>Home</title>
        <script>
            function viewEmployeeDetail(employeeId, userId) {
                window.location = "employeeMaster.htm?act=getUserDetail&id=" + employeeId + "&userid=" + userId;
            }
        </script>
        <script>
            jQuery.noConflict();
            jQuery(document).ready(function () {

                jQuery("#employeeName").tokenInput(${list}, {
                    preventDuplicates: true,
                    noResultsText: "No Result",
                    tokenLimit: "1",
                    searchingText: "Searching ... .. ."
                });
            });

        </script>

        <style>
            /*            body {
                            font-family: Arial;
                            margin: 0;
                        }
            
                        * {
                            box-sizing: border-box;
                        }
            
                        img {
                            vertical-align: middle;
                        }*/

            /* Position the image container (needed to position the left and right arrows) */
            .imgcontainer {
                position: relative;
            }

            /* Hide the images by default */
            .mySlides {
                display: none;
                width: 100% !important;
                height: 150px !important;
            }
            div.mySlides img{
                width: 100% !important;
                height: 150px !important;
            }

            /* Add a pointer when hovering over the thumbnail images */
            /*            .cursor {
                            cursor: pointer;
                        }*/

            /* Next & previous buttons */
            .prev1,
            .next1 {
                cursor: pointer;
                position: absolute;
                top: 45%;
                width: auto;
                margin-top: -50px;
                color: white;
                font-weight: bold;
                font-size: 20px;
                border-radius: 0 3px 3px 0;
                user-select: none;
                -webkit-user-select: none;
            }

            .prev1{
                padding-left: 3%;
            }

            /* Position the "next button" to the right */
            .next1 {
                right: 0;
                border-radius: 3px 0 0 3px;
                padding-right: 10%;
            }

            /* On hover, add a black background color with a little bit see-through */
            .prev1:hover,
            .next1:hover {
                background-color: rgba(0, 0, 0, 0.8);
            }

            /* Number text (1/3 etc) */
            /*            .numbertext {
                            color: #f2f2f2;
                            font-size: 12px;
                            padding: 8px 12px;
                            position: absolute;
                            top: 0;
                        }*/

            /* Container for image text */
            .img-caption-container {
                text-align: center;
                background-color: #222;
                padding: 2px 16px;
                color: white;
            }

            /*            .row:after {
                            content: "";
                            display: table;
                            clear: both;
                        }*/

            /* Six columns side by side */
            /*            .column {
                            float: left;
                            width: 16.66%;
                        }*/

            /* Add a transparency effect for thumnbail images */
            /*            .demo {
                            opacity: 0.6;
                        }*/

            /*            .active,
                        .demo:hover {
                            opacity: 1;
                        }*/
        </style>

        <!--        <script type="text/javascript">
                    jssor_1_slider_init = function () {
        
                        var jssor_1_SlideoTransitions = [
                            [{b: 0, d: 600, y: -290, e: {y: 27}}],
                            [{b: 0, d: 1000, y: 185}, {b: 1000, d: 500, o: -1}, {b: 1500, d: 500, o: 1}, {b: 2000, d: 1500, r: 360}, {b: 3500, d: 1000, rX: 30}, {b: 4500, d: 500, rX: -30}, {b: 5000, d: 1000, rY: 30}, {b: 6000, d: 500, rY: -30}, {b: 6500, d: 500, sX: 1}, {b: 7000, d: 500, sX: -1}, {b: 7500, d: 500, sY: 1}, {b: 8000, d: 500, sY: -1}, {b: 8500, d: 500, kX: 30}, {b: 9000, d: 500, kX: -30}, {b: 9500, d: 500, kY: 30}, {b: 10000, d: 500, kY: -30}, {b: 10500, d: 500, c: {x: 125.00, t: -125.00}}, {b: 11000, d: 500, c: {x: -125.00, t: 125.00}}],
                            [{b: 0, d: 600, x: 535, e: {x: 27}}],
                            [{b: -1, d: 1, o: -1}, {b: 0, d: 600, o: 1, e: {o: 5}}],
                            [{b: -1, d: 1, c: {x: 250.0, t: -250.0}}, {b: 0, d: 800, c: {x: -250.0, t: 250.0}, e: {c: {x: 7, t: 7}}}],
                            [{b: -1, d: 1, o: -1}, {b: 0, d: 600, x: -570, o: 1, e: {x: 6}}],
                            [{b: -1, d: 1, o: -1, r: -180}, {b: 0, d: 800, o: 1, r: 180, e: {r: 7}}],
                            [{b: 0, d: 1000, y: 80, e: {y: 24}}, {b: 1000, d: 1100, x: 570, y: 170, o: -1, r: 30, sX: 9, sY: 9, e: {x: 2, y: 6, r: 1, sX: 5, sY: 5}}],
                            [{b: 2000, d: 600, rY: 30}],
                            [{b: 0, d: 500, x: -105}, {b: 500, d: 500, x: 230}, {b: 1000, d: 500, y: -120}, {b: 1500, d: 500, x: -70, y: 120}, {b: 2600, d: 500, y: -80}, {b: 3100, d: 900, y: 160, e: {y: 24}}],
                            [{b: 0, d: 1000, o: -0.4, rX: 2, rY: 1}, {b: 1000, d: 1000, rY: 1}, {b: 2000, d: 1000, rX: -1}, {b: 3000, d: 1000, rY: -1}, {b: 4000, d: 1000, o: 0.4, rX: -1, rY: -1}]
                        ];
        
                        var jssor_1_options = {
                            $AutoPlay: 1,
                            $Idle: 2000,
                            $Cols: 1,
                            $Align: 0,
                            $CaptionSliderOptions: {
                                $Class: $JssorCaptionSlideo$,
                                $Transitions: jssor_1_SlideoTransitions,
                                $Breaks: [
                                    [{d: 2000, b: 1000}]
                                ]
                            },
                            $ArrowNavigatorOptions: {
                                $Class: $JssorArrowNavigator$
                            },
                            $BulletNavigatorOptions: {
                                $Class: $JssorBulletNavigator$
                            }
                        };
        
                        var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);
        
                        /*#region responsive code begin*/
        
                        var MAX_WIDTH = 980;
        
                        function ScaleSlider() {
                            var containerElement = jssor_1_slider.$Elmt.parentNode;
                            var containerWidth = containerElement.clientWidth;
        
                            if (containerWidth) {
        
                                var expectedWidth = Math.min(MAX_WIDTH || containerWidth, containerWidth);
        
                                jssor_1_slider.$ScaleWidth(expectedWidth);
                            }
                            else {
                                window.setTimeout(ScaleSlider, 30);
                            }
                        }
        
                        ScaleSlider();
        
                        $Jssor$.$AddEvent(window, "load", ScaleSlider);
                        $Jssor$.$AddEvent(window, "resize", ScaleSlider);
                        $Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
                        /*#endregion responsive code end*/
                    };
                </script>-->
        <!--<link href="https://fonts.googleapis.com/css?family=Oswald:200,300,regular,500,600,700&subset=latin-ext,vietnamese,latin,cyrillic" rel="stylesheet" type="text/css" />-->
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Home</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">

                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="">
                                            <div class="box-header">
                                                <div class="box-tools pull-right">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">

                                    <!--                                    <div class="col-md-5">
                                                                            <div class="box box-primary">
                                    
                                                                                <div class="box-header">
                                                                                    <h3 class="box-title">Employee Detail</h3>
                                                                                    <div class="box-tools pull-right">
                                                                                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="box-body">
                                    <%--<form:form role="form" class="form-horizontal" method="post"--%>
                                               name='form'  commandName="employeeMaster" action="homeController.htm?act=searchEmployeeDetail">
                                    <%--<form:hidden path="id"></form:hidden>--%>




                                        <div class="form-group">
                                            <div ><span style="color: red;font-size: 12px;"></span>
                                                <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                    <%--<form:input path="employeeName" class="form-control"></form:input>--%>
                                    <%--<form:errors path="employeeName" cssClass="errorDiv"></form:errors>--%>
                                </div>


                            </div>

                            <div class="form-group">
                                <div >
                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                </div>
                            </div>





                                    <%--</form:form>--%>  
                                    <ul class="products-list product-list-in-box">
                                        <li class="item">
                                            <span class="product-title">Employee No : </span>
                                            <span class="product-title">  ${employeeMaster.employeeId}</span>
                                        </li> /.item 
                                        <li class="item">
                                            <span class="product-title">Employee Name : </span>
                                            <span class="product-title">  ${employeeMaster.employeeName}</span>
                                        </li> /.item 
                                      
                                        <li class="item">
                                            <span class="product-title">Email id : </span>
                                            <span class="product-title">  ${employeeMaster.levelMaster.level}</span>
                                        </li> /.item 
                                        <li class="item">
                                            <span class="product-title">Contact Number :</span>
                                            <span class="product-title">  ${employeeMaster.reportingManagerLevel1}</span>
                                        </li> /.item 
                                     
                                    </ul>
                                </div>
                            </div>
                        </div>-->


                                    <div class="col-md-5">
                                        <div class="box box-primary">
                                            <div class="box-header">
                                                <h3 class="box-title" id="gallery">Gallery</h3>
                                            </div>
                                        </div>
                                        <div class="box-body">
                                            <div>
                                                <c:forEach var="gallery" items="${galleryList}">

                                                    <a href="homeController.htm?act=opanGallery">
                                                        <div  class="mySlides">

                                                            <img hight="400" width="500" src="StorageYard/galleryimage/${gallery.imagesPath}"  >
                                                        </div>
                                                    </a>
                                                </c:forEach>



                                                <a class="prev1" onclick="plusSlides(-1)">❮</a>
                                                <a class="next1" onclick="plusSlides(1)">❯</a>

                                                <div >
                                                    <p id="caption"></p>
                                                </div>


                                            </div>
                                        </div>
                                        <div class="box box-primary">
                                            <div class="box-header">
                                                <h3 class="box-title" id="myImg1">Emergency Contact Detail</h3>
                                            </div>
                                        </div>
                                        <div class="box box-primary">
                                            <div class="box-header">
                                                <h3 class="box-title" id="rAndR">Rewards And Recognition</h3>
                                            </div>
                                        </div>
                                    </div>           

                                    <div class="col-md-1">
                                    </div>
                                    <div class="col-md-6">
                                        <div class="box box-primary">
                                            <div class="box-header">
                                                <h3 class="box-title">Video Detail</h3>
                                                <div class="box-tools pull-right">
                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="col-xs-12 col-sm-12">
                                                    <c:forEach var="video" items="${videoList}">

                                                        <video controls style="width: 100%" height="367px;">
                                                            <source src="${video[1]}" type="video/mp4">
                                                        </video>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <!--                                <div class="col-md-5">
                                                                    <div class="box box-primary">
                                                                        <div class="box-header">
                                                                            <h3 class="box-title" id="gallery">Gallery</h3>
                                                                        </div>
                                                                    </div>
                                                                    <div class="box-body">
                                                                        <div >
                                <%--<c:forEach var="gallery" items="${galleryList}">--%>

                                    <div  class="mySlides">

                                        <img hight="200" width="420" src="StorageYard/galleryimage/${gallery.imagesPath}"  >
                                    </div>
                                <%--</c:forEach>--%>



                                <a class="prev1" onclick="plusSlides(-1)">❮</a>
                                <a class="next1" onclick="plusSlides(1)">❯</a>

                                <div >
                                    <p id="caption"></p>
                                </div>


                            </div>
                        </div>-->
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h3 class="box-title" id="myImg1">Emergency Contact Detail</h3>
                                    </div>
                                </div>
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h3 class="box-title" id="rAndR">Rewards And Recognition</h3>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-2">
                            </div>
                            <div class="col-md-5">
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h3 class="box-title">Todays Birthday</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        </div>
                                        <div class="box-body">

                                            <c:forEach var="todayBirthday" items="${TodaysBirthdays}">
                                                <ul class="products-list product-list-in-box">
                                                    <li class="item">
                                                        <span class="product-title">  ${todayBirthday[1]}</span>
                                                    </li>
                                                </ul>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="box box-primary">
                                    <div class="box-header">
                                        <h3 class="box-title">New Joinee</h3>
                                        <div class="box-tools pull-right">
                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                        </div>
                                        <div class="box-body">
                                            <ul class="products-list product-list-in-box">
                                                <li class="item">
                                                    <c:forEach var="newJoining" items="${newJoiningList}">
                                                        <ul class="products-list product-list-in-box">
                                                            <li class="item">
                                                                <span class="product-title">  ${newJoining}</span>
                                                            </li>
                                                        </ul>
                                                    </c:forEach>

                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-12">
                                    <!--<span class="product-title">  ${thoughtMaster}</span>-->
                                <marquee style="font-size:26px !important;">${thoughtMaster.thought}</marquee>
                            </div>
                        </div>

                    </div>
                    <div class="tab-pane" id="tab_2">
                    </div>
                    <div class="tab-pane" id="tab_3"></div>
                </div>
            </div>
    </div>
</div>
</section>
</div>
<%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;</button>
                <h4 class="modal-title" id="myModalLabel">
                    Gallery</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <!--                    <div class="tab-content">
                                            <div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                                                <div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:980px;height:380px;overflow:hidden;visibility:hidden;">
                                                    <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
                                                        <img style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;" src="img/spin.svg" />
                                                    </div>
                                                    <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                    <%--<c:forEach var="gallery" items="${galleryList}">--%>
                        <div data-p="240.00">
                            <img data-u="image" src="StorageYard/galleryimage/${gallery.imagesPath}" />
                        </div>
                    <%--</c:forEach>--%>

                </div>
                <div data-u="arrowleft" class="jssora053" style="width:55px;height:55px;top:0px;left:25px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <polyline class="a" points="11040,1920 4960,8000 11040,14080 "></polyline>
                    </svg>
                </div>
                <div data-u="arrowright" class="jssora053" style="width:55px;height:55px;top:0px;right:25px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <polyline class="a" points="4960,1920 11040,8000 4960,14080 "></polyline>
                    </svg>
                </div>
            </div>
        </div>
    </div>-->
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;</button>
                <h4 class="modal-title" id="myModalLabel">
                    Rewards And Recognition</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="tab-content">
                        <div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                            <div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:980px;height:380px;overflow:hidden;visibility:hidden;">
                                <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
                                    <img style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;" src="img/spin.svg" />
                                </div>
                                <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                                    <c:forEach var="RR" items="${RRList}">
                                        <div data-p="240.00">
                                            <img data-u="image" src="StorageYard/RandRimage/${RR.imagesPath}" />
                                        </div>
                                    </c:forEach>
                                </div>
                                <div data-u="arrowleft" class="jssora053" style="width:55px;height:55px;top:0px;left:25px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
                                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                                    <polyline class="a" points="11040,1920 4960,8000 11040,14080 "></polyline>
                                    </svg>
                                </div>
                                <div data-u="arrowright" class="jssora053" style="width:55px;height:55px;top:0px;right:25px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
                                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                                    <polyline class="a" points="4960,1920 11040,8000 4960,14080 "></polyline>
                                    </svg>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;</button>
                <h4 class="modal-title" id="myModalLabel">
                    Gallery</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="tab-content">
                        <div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
                            <div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:980px;height:380px;overflow:hidden;visibility:hidden;">
                                <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
                                    <img style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;" src="img/spin.svg" />
                                </div>
                                <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                                    <div data-p="170.00">
                                        <img data-u="image" src="StorageYard\GalleryImages\1.png" />
                                    </div>
                                    <div data-p="170.00">
                                        <img data-u="image" src="StorageYard\GalleryImages\2.png" />
                                    </div>
                                    <div data-p="170.00">
                                        <img data-u="image" src="StorageYard\GalleryImages\3.png" />
                                    </div>
                                </div>
                                <div data-u="arrowleft" class="jssora053" style="width:55px;height:55px;top:0px;left:25px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
                                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                                    <polyline class="a" points="11040,1920 4960,8000 11040,14080 "></polyline>
                                    </svg>
                                </div>
                                <div data-u="arrowright" class="jssora053" style="width:55px;height:55px;top:0px;right:25px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
                                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                                    <polyline class="a" points="4960,1920 11040,8000 4960,14080 "></polyline>
                                    </svg>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<script>
    jQuery(document).ready(function () {
        $("#org").jOrgChart({
            chartElement: '#chart',
            dragAndDrop: true
        });
    });

    // Get the modal


    // Get the image and insert it inside the modal - use its "alt" text as a caption
    var galleryModel = document.getElementById('gallery');
    var rAndrModel = document.getElementById('rAndR');
    var modal = document.getElementById('myModal');
    galleryModel.onclick = function () {
        $('#myModal').modal('show');
    };
    rAndrModel.onclick = function () {
        $('#myModal1').modal('show');


    };

</script>
<!--
<script>
    var main = function () {

        var paused = false;

        $('.arrowR').click(function () {
            paused = true;
            $('#slideshow > div:first')
                    .fadeOut(1000)
                    .next()
                    .fadeIn(1000)
                    .end()
                    .appendTo('#slideshow');
        });

        $('.arrowL').click(function () {
            paused = true;
            $('#slideshow > div:last')
                    .fadeIn(1000)
                    .prependTo('#slideshow')
                    .next()
                    .fadeOut(1000)
                    .end();
        });



        setInterval(function () {
            if (paused === false) {
                $('#slideshow > div:first')
                        .fadeOut(1000)
                        .next()
                        .fadeIn(1000)
                        .end()
                        .appendTo('#slideshow');
            }
            ;
        }, 5000);


    };

    $(document).ready(main);
</script>-->



<!--<script type="text/javascript">jssor_1_slider_init();</script>-->


</html>
<script>
    var slideIndex = 1;
    showSlides(slideIndex);

    function plusSlides(n) {
        showSlides(slideIndex += n);
    }

    function currentSlide(n) {
        showSlides(slideIndex = n);
    }

    function showSlides(n) {
        var i;
        var j;
        var imgsize = 1;

        var slides = document.getElementsByClassName("mySlides");


        if (n > slides.length) {
            slideIndex = 1;
        }
        if (n < 1) {
            slideIndex = slides.length;
        }
        if (n === 1 && slides.length === 0) {
            slides.length = 1;

        }

        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        slides[slideIndex - 1].style.display = "block";


    }


</script>

<script>
    showSlides();
    var slideIndex = 0;

    function showSlides() {
        var slides = document.getElementsByClassName("mySlides");

        var n;

        for (n = 0; n < slides.length; n++) {
            slides[n].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {
            slideIndex = 1;
        }

        slides[slideIndex - 1].style.display = "block";

        setTimeout(showSlides, 3000); // Change image every 2 seconds
    }
</script>



