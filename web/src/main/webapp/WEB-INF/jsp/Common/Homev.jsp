<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    <head onload="rrshowSlides(1);">
        <title>Homepage</title>
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


            /* Container for image text */
            .img-caption-container {
                text-align: center;
                background-color: #222;
                padding: 2px 16px;
                color: white;
            }


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
            <h1>VENDOR PAGE</h1>
            <ol class="breadcrumb">
                <li> ${CurrentDate}</li>
                <li><a href="#"><i class="fa fa-dashboard"></i> Vendor page</a></li>
                <li class="active">Vendor Dashboard</li>
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
                                <div class="col-md-1">
                                </div>
                            </div>
                            <br>
                            <br>

                            <div class="row">
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                        <!--<span class="product-title">  ${thoughtMaster}</span>-->
                                </div>
                            </div>

                        </div>
                        <div class="tab-pane" id="tab_2">
                        </div>
                        <div class="tab-pane" id="tab_3"></div>
                    </div>
                </div>
        </section>
    </div>
    <!--</div>
    </div>-->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
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




