
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="/WEB-INF/jsp/Common/Exception.jsp"%>
<!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


 <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="57x57" href="StorageYard/assets/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="StorageYard/assets/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="StorageYard/assets/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="StorageYard/assets/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="StorageYard/assets/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="StorageYard/assets/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="StorageYard/assets/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="StorageYard/assets/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="StorageYard/assets/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="StorageYard/assets/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="StorageYard/assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="StorageYard/assets/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="StorageYard/assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="StorageYard/assets/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="StorageYard/assets/favicon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- CSS Libraries -->
    <link rel="stylesheet" href="StorageYard/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/all.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/buttons.bootstrap4.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/bootoast.min.css" rel="stylesheet" type="text/css"/>
    <link href="StorageYard/assets/css/flatpickr.min.css" rel="stylesheet" type="text/css"/>


    <!-- Theme CSS -->
    <link rel="stylesheet" href="StorageYard/assets/css/global.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/style.min.css">
    <link href="StorageYard/assets/css/global.css" rel="stylesheet" type="text/css"/>
    
    <!-- Js -->
    <script src="StorageYard/assets/js/jquery-3.7.1.min.js"></script>
    <script src="StorageYard/assets/js/bootstrap.bundle.min.js"></script>
    <script src="StorageYard/assets/js/bootstrap-select.min.js"></script>
    <script src="StorageYard/assets/js/sweetalert2.all.min.js"></script>
    
    <!--Currency Handle Js-->
    <script src="StorageYard/assets/js/currency.js" type="text/javascript"></script>
    
    <script src="StorageYard/assets/js/dataTables.min.js"></script>
    <script src="StorageYard/assets/js/dataTables.bootstrap4.min.js"></script>
    <!--<script src="StorageYard/assets/js/pr-scripts.js" type="text/javascript"></script>-->
    <script src="StorageYard/assets/js/bootoast.min.js" type="text/javascript"></script>
    <script src="StorageYard/assets/js/main.js"></script>
    <script src="StorageYard/assets/js/flatpickr.min.js" type="text/javascript"></script>
    <script>
        function isJQueryLoaded() {
    return typeof window.jQuery !== "undefined";
}
        if (isJQueryLoaded()) {
    console.log("jQuery is loaded");
} else {
    console.log("jQuery is NOT loaded");
}
    </script>
    <%-- Below code is for Text area counter Style --%>
    <style>
        textarea.limit-reached {
            border-color: red;
        }

        .char-counter {
            position: absolute;
            bottom: -2px;
            right: 4px;
            font-size: 12px;
            background: rgba(255, 255, 255, 0.0);
            padding: 2px 6px;
            border-radius: 4px;
            pointer-events: none;
            color: #666;
        }

        .char-counter .current-count {
            color: red;
        }
    </style>

    <style>
        .middle-scrollbar {
            overflow-x: auto;
            overflow-y: hidden;
            border-bottom: 1px solid #dee2e6;
            background-color: #f8f9fa;
        }
        .middle-scrollbar div {
            height: 1px;
        }
        .middle-scrollbar::-webkit-scrollbar {
            height: 9px;
        }
        .middle-scrollbar::-webkit-scrollbar-track {
            background: #ffffff;
            border-radius: 4px;
        }
        .middle-scrollbar::-webkit-scrollbar-thumb {
            background-color: #afafb2;
            border-radius: 10px;
        }

        .middle-scrollbar {
            scrollbar-color: #afafb2 #e9ecef;
            scrollbar-width: thin;
        }
    </style>

