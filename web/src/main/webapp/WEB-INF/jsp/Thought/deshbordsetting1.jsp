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
        <title>Home Setting </title>
    </head>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Home Setting</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li><li>Setting</li>
                <li class="active">Home Setting</li>
            </ol>
        </section>
        <ul class="nav nav-tabs">
            <li><a href="thoughtMaster.htm?act=createthought">Thought oF the Day</a></li>
            <li class="active"><a href="">Upload Video</a></li>
            <li><a href="thoughtMaster.htm?act=createthought2">Gallery</a></li>
            <li><a href="thoughtMaster.htm?act=createthought3">R & R</a></li>
        </ul> 
        <form:form action="corporateVideo.htm?act=submitCorporateUploadVideo" method="post" enctype="multipart/form-data" 
                   commandName="corporateVideo" class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                Video to upload: <input type="file" name="uploadVideo" class="form-control" accept='video/*' ><br/>
                                                Desc about the Video: <textarea  id="thought" name="videoDesc" class="form-control"></textarea>
                                            </div>
                                            <c:if test="${sessionScope.userRight.employeeManagement}">
                                                <button type="submit" class="btn btn-primary" style="width: 100px;">Submit</button>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <c:forEach var="list" items="${videoList}">
                            <label><b>Desc about the Video</b>&nbsp; : &nbsp;</label>${list[2]}
                            <video width="400" controls>
                                <source src="${list[1]}" type="video/mp4">
                            </video>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </form:form>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
