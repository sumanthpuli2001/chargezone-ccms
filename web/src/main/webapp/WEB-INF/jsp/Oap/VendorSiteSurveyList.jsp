<%-- 
    Document   : VendorSiteSurveyList
    Created on : Apr 21, 2025, 3:10:45 PM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    <head>
        <title> Vendor Site Survey</title>
    </head>
    <script>
        function viewClick(id) {
            //             alert("P");
            ////            var x1=document.getElementById('id').value;
            //            var x= $('#id' + id).val();
            var rightName = $('#rightName' + id).val();
            window.location = 'oapForm.htm?act=Sitesurveyopenvendor&id=' + rightName;
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

            <div style="display: flex; height: 25px; justify-content: space-between; align-items: center;">
                <h3 style="margin-top: 1px;">Vendor Site Survey</h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>

        <!-- Main content -->
        <form:form action=".htm?act=" method="post" commandName="rightMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">

                            <div class="tab-content">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <div style="display: flex; justify-content: flex-end;">
                                    <div style="display: flex; height: 25px; width: 100px; justify-content: space-between; align-items: center;">
                                        <a href="oapForm.htm?act=Sitesurveypage" class="btn btn-primary"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</a>
                                    </div>
                                </div>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty vendorSiteList}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <!--<th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>-->

                                                                    <th>Site Name</th>
                                                                    <th>Site Address</th>
                                                                    <th>Description</th>
                                                                    <th>Start Date</th>
                                                                    <th>End Date </th>
                                                                    <th>Type</th>
                                                                    <th>Created By</th>
                                                                    <th>Action</th>

                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${vendorSiteList}" varStatus="status">
                                                                    <tr>
                                                                        <!--                                                                        <td align="Center">
                                                                                                                                                    <input type="checkbox" name="checkId" id="deptCheckId" value="${list.id}">
                                                                                                                                                </td>-->
                                                                        <!--                                                                <input type="hidden" name="id" class="id" value="${list.id}">-->

                                                                        <td>${list.siteName}</td>
                                                                        <td>${list.siteAddress}</td>
                                                                        <td>${list.description}</td>
                                                                        <td>${list.startDate}</td>
                                                                        <td>${list.endDate}</td>
                                                                        <td>${list.formFillType}</td>
                                                                        <td>${list.createdBy}</td>

                                                                        <td>
                                                                           
                                                                                <div class="btn-group">
                                                                                    <button type="button" class="btn btn-default dropdown-toggle"  id="rightName${list.id}" value="${list.id}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list.id});">
                                                                                        &nbsp;Create Form
                                                                                    </button>

                                                                                </div>
                                                                            

                                                                        </td>

                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>



                                            </div>
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
</html>




