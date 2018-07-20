
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
<%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>

<head >

    <title>Life @ SPC</title>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        #myImg {
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        #myImg:hover {opacity: 0.7;}

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            padding-top: 100px; /* Location of the box */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(255,255,255,0.4); /* Black w/ opacity */
        }

        /* Modal Content (image) */
        .img-modal-content {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
        }

        /* Caption of Modal Image */
        #caption {
            margin: auto;
            display: block;
            width: 80%;
            max-width: 700px;
            text-align: center;
            color: #ccc;
            padding: 10px 0;
            height: 150px;
        }

        /* Add Animation */
        .img-modal-content, #caption {    
            -webkit-animation-name: zoom;
            -webkit-animation-duration: 0.6s;
            animation-name: zoom;
            animation-duration: 0.6s;
        }

        @-webkit-keyframes zoom {
            from {-webkit-transform:scale(0)} 
            to {-webkit-transform:scale(1)}
        }

        @keyframes zoom {
            from {transform:scale(0)} 
            to {transform:scale(1)}
        }

        /* The Close Button */
        .close1{
            position: absolute;
            top: 10%;
            right:  15%;
            color: #000;
            font-size: 40px;
            font-weight: bold;
            transition: 0.3s;
        }

        .close1:hover,
        .close1:focus {
            color: #bbb;
            text-decoration: none;
            cursor: pointer;
        }

        /* 100% Image Width on Smaller Screens */
        @media only screen and (max-width: 700px){
            .img-modal-content {
                width: 100%;
            }
        }
        img:hover {
            cursor: pointer;
        }
    </style>
</head>
<div class="content-wrapper">
    <section class="content-header">
        <h1>Life @ SPC</h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-home"></i> Home</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <div style="width: 100%">
        <c:forEach var="gallery" items="${galleryList}">
            <div style="width:22%;margin: 1%;display: inline-block;">

                <img onclick="imageClick(this.src);" style="width: 100%;height:150px;"src="StorageYard/galleryimage/${gallery[1]}"  >
            </div>
        </c:forEach>
    </div>
</div>
<div id="myModal1" class="modal">
    <span class="close1">&times;</span>
    <img class="img-modal-content" id="img01">
</div>

<script>



// Get the modal
    var modal = document.getElementById('myModal1');

// Get the image and insert it inside the modal - use its "alt" text as a caption

    var modalImg = document.getElementById("img01");
    imageClick = function (abc) {
        modal.style.display = "block";
        modalImg.src = abc;
    };

// Get the <span> element that close11s the modal
    var span = document.getElementsByClassName("close1")[0];

// When the user clicks on <span> (x), close1 the modal
    span.onclick = function () {
        modal.style.display = "none";
    };
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
