<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Tender Unauthorize List</title>
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
            <h1>Tender Unauthorize List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tender Unauthorize List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="employeeMaster.htm?act=disableEmployee" method="post" commandName="employeeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
<!--                                            <div class="table">-->

                                                <table id="table_1" class="table table-bordered" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${1 == 2}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Tender No.</th>
                                                                    <th>P.R. No.</th>
                                                                    <th>Tender Title</th>
                                                                    <th>Fee</th>
                                                                    <th>Tender Date</th>
                                                                    <th>Tender Due Date</th>
                                                                    <th>Tender Type</th>
                                                                    <th>Authorize</th>
                                                                        
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <td>${list.refNo}</td>
                                                                        <td>${list.prNo}</td>
                                                                        <td>${list.title}</td>
                                                                        <td>${list.docCost}</td>
                                                                        <td>${list.announceDate}</td>
                                                                        <td>${list.submitLastdate}</td>
                                                                        <td>${list.tenderPhase} Part</td>
                                                                        <td>
                                                                            <c:if test="${list.tenderType == 'Service Manually'}">
                                                                                <a href="tenderMaster.htm?act=authorizeServiceManualView&id=${list.id}">Authorize</a>
                                                                            </c:if>
                                                                            <c:if test="${list.tenderType != 'Service Manually'}">
                                                                                <a href="tenderMaster.htm?act=authorizeView&id=${list.id}">Authorize</a>
                                                                            </c:if>
                                                                            
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                <c:forEach var="list1" items="${list1}" varStatus="status">
                                                                    <tr>
                                                                        <td>${list1.refNo}</td>
                                                                        <td>${list1.prNo}</td>
                                                                        <td>${list1.title}</td>
                                                                        <td>${list1.docCost}</td>
                                                                        <td>${list1.announceDate}</td>
                                                                        <td>${list1.submitLastdate}</td>
                                                                        <td>${list1.tenderPhase} Part</td>
                                                                        <td>
                                                                            <c:if test="${list1.tenderType == 'Service Manually'}">
                                                                                <a href="tenderMaster.htm?act=serviceManualCorrigendumAuthorizeView&id=${list1.id}">Authorize</a>
                                                                            </c:if>
                                                                            <c:if test="${list1.tenderType != 'Service Manually'}">
                                                                                <a href="tenderMaster.htm?act=corrigendumAuthorizeView&id=${list1.id}">Authorize</a>
                                                                            </c:if>
                                                                            
                                                                        
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                                    
                                                                <c:forEach var="list2" items="${list2}" varStatus="status">
                                                                    <tr>
                                                                        <td>${list2.refNo}</td>
                                                                        <td>${list2.prNo}</td>
                                                                        <td>${list2.title}</td>
                                                                        <td>${list2.docCost}</td>
                                                                        <td>${list2.announceDate}</td>
                                                                        <td>${list2.submitLastdate}</td>
                                                                        <td>${list2.tenderPhase} Part</td>
                                                                        <td>
                                                                            <a href="#" onclick="window.open('tenderMaster.htm?act=sendEmailAuth&refNo=${list2.refNo}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Send Email Authorize</a>
                                                                            
                                                                        </td>
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
</html>

