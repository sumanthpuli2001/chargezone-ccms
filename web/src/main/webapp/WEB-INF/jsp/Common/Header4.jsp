<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv='cache-control' content='no-cache'>
        <meta http-equiv='expires' content='0'>
        <meta http-equiv='pragma' content='no-cache'>
        <meta http-equiv="Expires" content="-1">
        <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
        <style>
          header {
  padding:8px 65px;
  transition: all 0.4s ease 0s;
  background: #223e4e; }

header.active {
  background: #121833; }

.navbar {
  padding: 0;
  background: #223e4e;
  margin-bottom: unset;
}

.navbar .navbar-brand {
  margin: -6px;
  padding: 0;
  font-size: 1.6em;
  font-weight: 600;
  text-transform: uppercase; }

.navbar .navbar-brand img {
    vertical-align: middle;
    height: auto;
  max-width: 200%;
  transition: all 0.5s ease; }

.navbar-expand-lg .navbar-nav .nav-item {
  padding: 0 12px;
  transition: all 0.5s ease; }

.navbar-expand-lg .navbar-nav .nav-item.active a {
  color: #fff;
  opacity: 1; }

.navbar-dark .navbar-toggler {
  outline: none; }

.navbar-expand-lg .navbar-nav .nav-item:last-child {
  padding-right: 0; }

.navbar-expand-lg .navbar-nav .dropdown-menu {
  transform: translateX(-50px); }

.navbar-expand-lg .navbar-nav .dropdown-menu:before {
  content: '';
  width: 14px;
  height: 14px;
  background: #fff;
  border: 1px solid #fff;
  display: block;
  border-right: none;
  border-bottom: none;
  transform: translateX(-50%) rotateZ(45deg);
  border-radius: 3px;
  position: absolute;
  top: -6px;
  left: 49%;
  z-index: 1001; }

.navbar-expand-lg .navbar-nav .nav-link {
  font-weight: 500;
  text-transform: uppercase;
  color: #ffffff;
  transition: all 0.5s ease;
  padding: 15px 0;
  opacity: .75; }

.navbar-expand-lg .navbar-nav .nav-link:hover {
  color: #ffffff;
  opacity: 1; }

header.nav-fixed {
  padding: 10px 15px;
  background-color: #124f8f; }

header.nav-fixed .navbar-brand img {
  max-width: 102px; }
.card {
    border: 0;
    margin-bottom: 30px;
    margin-top: 30px;
    border-radius: 6px;
    color: rgba(0, 0, 0, 0.87);
    background: #ffffff;
    width: 100%;
    box-shadow: 0 2px 2px 0 rgb(0 0 0 / 14%), 0 3px 1px -2px rgb(0 0 0 / 20%), 0 1px 5px 0 rgb(0 0 0 / 12%);
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;}
        </style>
    </head>


    <body class="hold-transition skin-blue sidebar-mini"><!--    closed in footer's second last line-->
        <div class="wrapper">
           <header id="site-header" class="fixed-top">
  <nav class="navbar navbar-expand-lg navbar-dark">
      <a class="navbar-brand" href="index.html">
          <img src="StorageYard/Images/logo.png" alt="" style="height: 100%;">
          
      </a>
     

      <div class="collapse navbar-collapse" id="navbarNav">
          
      </div>
  </nav>
</header>
           
            <script>
                $("#searchBox").keypress(function (e) {
                    if (e.keyCode == 13) {
                        var searchString = $('#searchBox').val();
                        window.location = "employeeMaster.htm?act=getEmployeeDetailsBySearchString&searchString=" + searchString;
                    }
                });
            </script>
            <script>
                $(document).ready(function () {
                    try {

                        $('#table_1').DataTable({
                            "ordering": false
                        });
                    } catch (ex) {

                    }
                });
            </script>

</body>