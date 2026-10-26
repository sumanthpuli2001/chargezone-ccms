<%-- 
    Document   : DesignationList
    Created on : 2 Jan, 2024, 6:04:27 PM
    Author     : Bulwark-5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <title>Material Group List </title>
    </head>
    <script>
        function viewClick(id) {
            window.location = 'materialMaster.htm?act=viewClick&id=' + id;
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
            <h1>Material List </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Material List </li>
            </ol>
        </section>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #FFF3F3; color: #D8000C; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #D8000C; box-shadow: 2px 2px 10px rgba(216, 0, 12, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">
                <div style="background: #D8000C; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px;">!</div>
                <div>
                    <strong>Note:</strong> <strong class="text-danger fs-13">${failureMessage} </strong><br>                            
                </div>
            </div>
        </c:if>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info mt-2 mb-2" style="display: flex; align-items: center; gap: 12px; background: #F0FFF4; color: #0F5132; font-size: 12px; padding: 5px 10px; border-radius: 8px; border: 1px solid #198754; box-shadow: 2px 2px 10px rgba(25, 135, 84, 0.2); position: relative; overflow: hidden; max-width: 100%; margin: auto;">                        
                <div style="background: #198754; color: white; width: 25px; height: 25px; display: flex; align-items: center; justify-content: center; border-radius: 50%; font-weight: bold; font-size: 14px; ">✓</div>  
                <div>                             
                    <strong>Note:</strong> <strong class="text-success fs-13">${successMessage} </strong><br>                            
                </div>
            </div>
        </c:if>
        <!-- Main content -->
        <form:form action="materialMaster.htm?act=deleteSubmit" method="post" commandName="materialMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="button" class="btn btn-primary" title="" style="float: right;width: 100px;" onclick="window.location = 'materialMaster.htm?act=showviewList'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty materialList}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                    <th>Sr.No.</th>

                                                                    <th>Material type </th>
                                                                    <th>Material Group </th>
                                                                    <th>Material code</th>
                                                                    <th>Material Description</th>
                                                                    <th>Material Long Description</th>
                                                                    <th>UOM</th>
                                                                    <th>Hsn No.</th>
                                                                    <th>GST</th>
                                                                    <th>View/Edit</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="materialList" items="${materialList}" varStatus="status">
                                                                    <tr>
                                                                        <td align="Center">
                                                                            <input type="checkbox" name="checkId" id="deptCheckId" value="${materialList[0]}">
                                                                        </td>
                                                                        <td> ${status.count}</td>

                                                                        <td>${materialList[1]}</td>
                                                                        <td>${materialList[2]}</td>
                                                                        <td>${materialList[3]}</td>
                                                                        <td>${materialList[4]}</td>
                                                                        <td>${materialList[5]}</td>
                                                                        <td>${materialList[6]}</td>
                                                                        <td>${materialList[7]}</td>
                                                                        <td>${materialList[8]}</td>

                                                                        <td>
                                                                            <div class="btn-group">
                                                                                <button type="button" class="btn btn-default dropdown-toggle"  id="${status.count}" value="${materialList[0]}"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  onclick="viewClick(${materialList[0]});">
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




