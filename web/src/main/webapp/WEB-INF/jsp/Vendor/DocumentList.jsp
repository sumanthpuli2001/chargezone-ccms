<%-- 
    Document   : SapList
    Created on : 10 Sep, 2022, 2:56:23 PM
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Document</title>
    </head>
    <script>
        function viewClick(id) {
//             alert("P");
////            var x1=document.getElementById('id').value;
//            var x= $('#id' + id).val();
            var rightName = $('#rightName' + id).val();
            window.location = 'oapForm.htm?act=DocumentEdit&id=' + rightName;
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
                <h3 style="margin-top: 1px;">Document List</h3>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="oapForm.htm?act=deleteDocument" method="post" commandName="sapConnection"
                   class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'oapForm.htm?act=DocumentCreate'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;" ><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <!--                                            <div class="table">-->
                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                <c:choose>
                                                    <c:when test="${empty list}">
                                                        <tr>
                                                            <td align="Center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center"  ></th>
                                                                <th>Sr.No</th>
                                                                <th>State</th>
                                                                <th>Discom Type</th>
                                                                <th>Connection Type</th>



                                                                <th>Action</th>
                                                                    <c:if test="${fn:contains(sessionScope.wright[1],'U')}">
                                                                    <th>View/Edit</th>
                                                                    </c:if>
                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach var="list" items="${list}" varStatus="status" >
                                                                <tr>
                                                                    <td align="Center">
                                                                        <input type="checkbox" name="checkId" id="deptCheckId" value="${list[0]}">
                                                                    </td>
                                                                    <td> ${status.count}</td>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[5]}</td>
                                                                    <td>${list[6]}</td>
                                                                


                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" class="btn btn-default dropdown-toggle"  id="rightName${list[0]}" value="${list[0]}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${list[0]});">
                                                                                &nbsp;View/Edit
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


