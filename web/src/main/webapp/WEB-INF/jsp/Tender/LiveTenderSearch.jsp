<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Live Tender List</title>
    </head>
    <script>
        function viewClick(id) {
            var loginName = $('#loginName' + id).val();
            window.location = 'employeeMaster.htm?act=viewClick&id=' + loginName;
        }
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Live Tender List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Live Tender List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="tenderMaster.htm?act=liveTenderSearchSubmit" method="post" 
                   name='form1'  class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="tenderMaster.htm?act=createLiveTender" title="" value="NEW" >
                                    
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
<!--                                            <div class="table">-->

                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label class="control-label">Tender No. :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                        <input type="text" name="tender_no" value="" class="form-control" maxlength="30" />
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <label class="control-label">Description :</label>
                                                    </div>
                                                    <div class="col-sm-3">
                                                         <input type="text" name="description" value="" class="form-control" maxlength="300" />
                                                    </div>
                                                </div>
                                                
                                                

                                            <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="Search">
                                        </div>
                                    </div>
                            
                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Sr. No.</th>
                                                                    <th>Tender No.</th>
                                                                    <th>Description</th>
                                                                    <th>File</th>
                                                                    <th>Edit</th>
                                                                    <th>Delete</th>
                                                                        
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td>${status.count}</td>
                                                                        <td>${list.tenderno}</td>
                                                                        <td>${list.description}</td>
                                                                        <td>${list.tenderdoc}</td>
                                                                        <td><a href="tenderMaster.htm?act=editLiveTender&id=${list.id}">Edit</a></td>
                                                                        <td><a href="tenderMaster.htm?act=deleteLiveTender&id=${list.id}">Delete</a></td>
                                                                    
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                                
<!--                                            </div>-->
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                            
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>
        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
 <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>

