<%-- 
    Document   : Dashbordsetting
    Created on : 20 Feb, 2018, 9:57:16 AM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Dashbord Setting </title>
        <script>
             function checkFileSize() {
            if (typeof FileReader !== "undefined") {
                var fileSize = document.getElementById('photograph').files[0].size;
//                alert("my File size is   " + fileSize);
                if (fileSize > 102400) {
                    document.getElementById('photograph').value = '';
                    document.getElementById('photographError').innerHTML = "- It must not more than 100kb";
                } else {
                    document.getElementById('photographError').innerHTML = '';
                }
                // check file size
            }
        </script>
    </head>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Dashbord Setting</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li><li>Setting</li>
                <li class="active">Dashbord Setting</li>
            </ol>
        </section>
        <ul class="nav nav-tabs">
            <li><a href="thoughtMaster.htm?act=createthought">Thought oF the Day</a></li>
            <li><a href="thoughtMaster.htm?act=createthought1">Upload Video</a></li>
            <li class="active"><a href="">Gallery</a></li>
            <li><a href="thoughtMaster.htm?act=createthought3">R & R</a></li>
        </ul> 
        <form:form class="form-horizontal" role="form1" action="thoughtMaster.htm?act=submitgallery"  method="post" enctype="multipart/form-data"  name='form'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Image Upload:<span style="color: red;font-size: 12px;"></span></label>
                                                    <input type="file" class="form-control" id="photograph" name="photograph" accept="image/jpg,image/jpeg,image/png" onchange="checkFileSize();">
                                                    <span style="font-size: 14px; color: red;" id="photographError"></span>


                                                </div>
                                            </div>


                                        </div>



                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->

                            <div class="form-group">
                                <div class=" col-sm-2">
                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >submit</button>
                                </div>
                            </div>

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

    </section>
</form:form>
</div>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
