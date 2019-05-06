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
    <head onload="rrshowSlides(1);">
        <title>Homepage</title>
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
                height: 200px !important;
            }
            div.mySlides img{
                width: 100% !important;
                height: 200px !important;
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
                top: 50%;
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


            .rrmySlides {
                display: none;
                width: 100% !important;
                height: 150px !important;
            }

            div.rrmySlides img{
                width: 100% !important;
                height: 150px !important;
            }

            .prev2,
            .next2 {
                cursor: pointer;
                position: absolute;
                top: 88%;
                width: auto;
                margin-top: -50px;
                color: white;
                font-weight: bold;
                font-size: 20px;
                border-radius: 0 3px 3px 0;
                user-select: none;
                -webkit-user-select: none;
            }

            .prev2{
                padding-left: 3%;
            }

            /* Position the "next button" to the right */
            .next2 {
                right: 0;
                border-radius: 3px 0 0 3px;
                padding-right: 10%;
            }

            /* On hover, add a black background color with a little bit see-through */
            .prev2:hover,
            .next2:hover {
                background-color: rgba(0, 0, 0, 0.8);
            }


            .links {
                font-size:24px; 
                color: #00a56c;
            }

            .test {
                width:60px;
                margin-bottom: 0px !important;
                white-space: normal;
                text-align: center;

            }
            .vertical-menu {
                width: 250px;
            }

            .vertical-menu a {
                background-color: white;
                color: black;
                display: block;
                padding: 12px;
                text-decoration: none;
            }

            .vertical-menu a:hover {
                background-color: #ccc;
            }

            .vertical-menu a.active {
                background-color: #3c8dbc;
                color: white;
            }
        </style>


        <!--<link href="https://fonts.googleapis.com/css?family=Oswald:200,300,regular,500,600,700&subset=latin-ext,vietnamese,latin,cyrillic" rel="stylesheet" type="text/css" />-->
    </head>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>HOMEPAGE</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Homepage</a></li>
                <li class="active">My Dashboard</li>
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
                                    <div class="col-md-3">
                                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                                <h3 class="box-title" style="font-size: 30px;color: white;font-weight:700;font-size:16px;">QUICK LINKS</h3>
                                            </div>
                                        </div>
                                        <div class="vertical-menu">
                                            <a style="font-size: 14px;text-align: left;color: #2c3e50;"  href="hrServiceRequest.htm?act=searchSubmit">
                                                <i class="fa fa-envelope"></i>&nbsp;HR Help Desk
                                            </a>
                                          
                                            <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="emergencyContact.htm?act=viewContact">
                                                <i class="fa fa-book"></i>&nbsp;Emergency Contact
                                            </a>
                                            
                                            
                                            <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="holidayMaster.htm?act=viewHolidaysLocationWise">
                                                <i class="fa fa-twitch"></i>&nbsp;Holiday List
                                            </a>
                                            <a style="font-size: 14px;text-align: left;color: #2c3e50;" href="policyMaster.htm?act=dashboardshowPolicy">
                                                <i class="fa fa-paypal"></i>
                                                Policy
                                            </a>
                                        </div>
                                    </div>
                                    <div class="col-md-9">
                                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                                <h3 class="box-title" style="font-size: 30px;color: white;font-weight:700;font-size:16px; ">LIFE @ Vadera & Co</h3>
                                            </div>
                                        </div>
                                        <div class="col-md-3">&nbsp;
                                        </div>
                                        <div class="col-md-6">
                                            <div class="box-body">
                                                <div>
                                                    <c:forEach var="gallery" items="${galleryList}">

                                                        <a href="homeController.htm?act=opanGallery">
                                                            <div  class="mySlides">

                                                                <img src="StorageYard/galleryimage/${gallery[1]}"  >
                                                            </div>
                                                        </a>
                                                    </c:forEach>
                                                    <a class="prev1" onclick="plusSlides(-1)">❮</a>
                                                    <a class="next1" onclick="plusSlides(1)">❯</a>
                                                    <div>
                                                        <p id="caption"></p>
                                                    </div>
                                                </div>      
                                            </div>      
                                        </div>      
                                        <div class="col-md-3">&nbsp;
                                        </div>
                                    </div>           
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                                            <div class="box-header" style="background-color: #006fad;text-align: center;">
                                                <h3 class="box-title" id="rAndR" style="font-size: 30px;color: white;font-weight:700;font-size:16px;">REWARDS AND RECOGNITION</h3>
                                            </div>
                                            <div class="box-body">
                                                <div>
                                                    <c:forEach var="rr" items="${RRList}">

                                                        <a href="homeController.htm?act=opanRR">
                                                            <div  class="rrmySlides">

                                                                <img hight="400" width="500" src="StorageYard/RandRimage/${rr[1]}"  >
                                                            </div>
                                                        </a>
                                                    </c:forEach>



                                                    <a class="prev2" onclick="rrplusSlides(-1)">❮</a>
                                                    <a class="next2" onclick="rrplusSlides(1)">❯</a>

                                                    <div >
                                                        <p id="caption"></p>
                                                    </div>


                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                                            <div class="box-header" style="background-color: #006fad;text-align: center;">
                                                <h3 class="box-title" id="rAndR"  style="font-size: 30px;color: white;font-weight:700;font-size:16px;">TODAY'S BIRTHDAY</h3>
                                            </div>
                                            <div class="box-body">
                                                <br/>
                                                <br/>
                                                <marquee scrollamount="1">
                                                    <div class="node-cell">
                                                        <div class="node ui-draggable ui-droppable"> 
                                                            <div >
                                                                <c:forEach var="todayBirthday" items="${TodaysBirthdays}">
                                                                    <div style="text-align: center;float: left;display: inline-block;margin-left:10px;width: 80px; ">
                                                                        <img src="${todayBirthday[2]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                        <br/>
                                                                        <label class="test">${todayBirthday[1]}</label>
                                                                        <br/>
                                                                        <div style="text-align: center;">
                                                                            <a style="font-size: 9px;"  onclick="window.open('homeController.htm?act=newJoineDetail&id=' +${todayBirthday[0]}, 'popUpWindow', 'height=400,width=600,left=500%,top=100%,resizable=1,scrollbars=no,toolbar=no,menubar=no,location=no,directories=no')">View</a>
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                                </marquee>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div  style="border: 1px #3c8dbc solid;border-radius: 5px;">
                                            <div class="box-header" style="background-color: #006fad !important;text-align: center;">
                                                <h3 class="box-title" id="rAndR" style="font-size: 30px;color: white;font-weight:700;font-size:16px;">NEW JOINEE</h3>
                                            </div>
                                            <div class="box-body">
                                                <br/>
                                                <br/>
                                                <marquee scrollamount="1">
                                                    <div class="node-cell">
                                                        <div class="node ui-draggable ui-droppable"> 
                                                            <div >
                                                                <c:forEach var="newJoining" items="${newJoiningList}">
                                                                    <div style="text-align: center;float: left;display: inline-block;margin-left:10px;width: 80px; ">
                                                                        <img src="${newJoining[2]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                        <br/>
                                                                        <label class="test">${newJoining[1]}</label>
                                                                        <br/>
                                                                        <div style="text-align: center;">
                                                                            <a style="font-size: 9px;" onclick="window.open('homeController.htm?act=newJoineDetail&id=' +${newJoining[0]}, 'popUpWindow', 'height=400,width=600,left=500%,top=100%,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no')">View</a>
                                                                        </div>
                                                                    </div>
                                                                </c:forEach>
                                                            </div>
                                                        </div>
                                                </marquee>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1">
                                </div>
                            </div>
                            <!--                                <div class="row">
                                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                                    <a class="label label-primary" style="font-size: 20px"  href="hrServiceRequest.htm?act=searchSubmit">
                                                                        <i class="fa fa-envelope"></i><strong> HR Help Desk </strong>
                                                                    </a>
                                                                </div>
                                                                <div  class="col-xs-4 col-sm-4 col-md-4">
                                                                    <a class="label label-primary" style="font-size: 20px" href="homeController.htm?act=kaizen">
                                                                        <i class="fa fa-twitch"></i>
                                                                        <strong>Kaizen</strong>
                                                                    </a>
                                                                </div>
                                                                <div class="col-xs-4 col-sm-4 col-md-3">
                                                                    <a class="label label-primary" style="font-size: 20px" href="hrServiceRequest.htm?act=searchSubmit">
                                                                    <a class="label label-primary" style="font-size: 20px" href="emergencyContact.htm?act=viewContact">
                                                                        <i class="fa fa-book"></i> &nbsp<strong>Emergency Contact</strong>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                            <br>
                                                            <br>
                                                            <div class="row">
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                                    <a class="label label-primary" style="font-size: 20px"  href="http://www.spcls.co.in/csr.aspx" target="_blank">
                                                                        <i class="fa fa-pencil-square-o"></i> &nbsp<strong>CSR</strong>
                                                                    </a>
                                                                </div>
                                                                <div class="col-xs-4 col-sm-4 col-md-4">
                                                                    <a class="label label-primary" style="font-size: 20px"  href="http://www.spcls.co.in/news-events.aspx" target="_blank">
                                                                        <i class="fa fa-newspaper-o"></i> &nbsp<strong>News & Event</strong>
                                                                    </a>
                                                                </div>
                                                                <div  class="col-xs-4 col-sm-4 col-md-3">
                                                                    <a class="label label-primary" style="font-size: 20px" href="holidayMaster.htm?act=viewHolidaysLocationWise">
                                                                        <i class="fa fa-twitch"></i>
                                                                        <strong>Holiday List</strong>
                                                                    </a>
                                                                </div>
                                                            </div>-->
                            <br>
                            <br>

                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                        <!--<span class="product-title">  ${thoughtMaster}</span>-->
                                    <marquee scrollamount="2" style="font-size:18px !important;"><strong style="color: #006fad;">THOUGHT OF THE DAY : </strong> <span style="color: #006fad">${thoughtMaster.thought}</span></marquee>
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
                            <img data-u="image" src="StorageYard/galleryimage/${gallery[1]}" />
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
                                            <img data-u="image" src="StorageYard/RandRimage/${RR[1]}" />
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
<!-- //////////////// New Joinee Detail view    -->                   
<!--<div class="modal fade" id="myModalOnline" role="dialog" tabindex="-1">
    <div class="modal-dialog">
         Modal content
        <div class="modal-content">
            <div class="modal-header">
                <h1>Hello1</h1>

            </div>
            <div class="modal-body">

                <h1>Hello</h1>
            </div>
        </div>
    </div>
</div>-->
<div class="modal fade" id="myModalOnline" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Modal Header</h4>
            </div>
            <div class="modal-body">
                <p>Some text in the modal.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>



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

        setTimeout(showSlides, 5000); // Change image every 2 seconds
    }
</script>



<script>
    var rrslideIndex = 1;
    rrshowSlides(rrslideIndex);

    function rrplusSlides(n) {
        rrshowSlides(rrslideIndex += n);
    }
    function rrcurrentSlide(n) {
        rrshowSlides(rrslideIndex = n);
    }

    function rrshowSlides(n) {
        var i;
        var j;
        var imgsize = 1;

        var rrslides = document.getElementsByClassName("rrmySlides");


        if (n > rrslides.length) {
            rrslideIndex = 1;
        }
        if (n < 1) {
            rrslideIndex = rrslides.length;
        }
        if (n === 1 && rrslides.length === 0) {
            rrslides.length = 1;

        }

        for (i = 0; i < rrslides.length; i++) {
            rrslides[i].style.display = "none";
        }

        rrslides[rrslideIndex - 1].style.display = "block";


    }


</script>
<script>
    rrshowSlides();
    var rrslideIndex = 0;

    function rrshowSlides() {
        var rrslides = document.getElementsByClassName("rrmySlides");
        var n;

        for (n = 0; n < rrslides.length; n++) {
            rrslides[n].style.display = "none";
        }
        rrslideIndex++;
        if (rrslideIndex > rrslides.length) {
            rrslideIndex = 1;
        }

        rrslides[rrslideIndex - 1].style.display = "block";

        setTimeout(rrshowSlides, 5000); // Change image every 2 seconds
    }
</script>
<script>
    function viewClick(id) {
        alert(id);
    }
    function showPunchData(id) {
        alert(id);
//        var path = 'attendanceRegularizationMaster.htm?act=showDateWisePunch  DataOfSubordinate&id=' + id;
        popupWindow = window.open("path", 'popUpWindow', 'height=300,width=500,left=500%,top=100%,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no');

//             window.location = 'attendanceRegularizationMaster.htm?act=showDateWisePunchData&date=' + date;
    }

</script>




