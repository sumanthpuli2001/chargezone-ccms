<%-- 
    Document   : CreateQuestionPaperStep3
    Created on : 5 Mar, 2018, 6:01:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Question Paper Create</title>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Question Paper Create Step 3</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Question Paper</li>
            </ol>
        </section>

        <!-- Main content -->
        <form:form class="form-horizontal" method="post" commandName="questionPaper" action="questionLibrary.htm?act=finishQuestionPaper">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <div class="col-sm-5">
                                                <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                                    <label>Category :<span style="color: red;font-size: 12px;"></span></label>
                                                    <form:input path="categoryName.employeeCategory" id="categoryName" class="form-control" readonly="true"></form:input>
                                                </div>
                                                <div class="col-sm-5">
                                                    <label>Question Paper Name :</label>
                                                <form:input path="paperName" id="paperName" class="form-control" readonly="true"></form:input>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label><h4>Selected Questions</h4></label>

                                        </div>
                                    </div>

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="questionTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                            <!--<th style="width: 2%;"></th>-->
                                                            <th style="text-align: center; vertical-align: middle">Questions</th>
                                                            <th style="text-align: center; vertical-align: middle">Marks</th>
                                                            <!--<th style="text-align: center; vertical-align: middle">Action</th>-->
                                                            <!--<input type="hidden" name="questionCount" id="questionCount" value="1"/>-->
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="questionDetailses" items="${questionDetailses}" varStatus="status">

                                                        <tr>
                                                            <td style="text-align: center; vertical-align: middle">${status.count}</td>
                                                            <!--<td align="center" style="width: 2%;"><input type="checkbox" name="queId" id="queId" value="${questionDetailses[0]}"/></td>-->
                                                            <td align="center">${questionDetailses[1]}</td>
                                                            <td align="center">${questionDetailses[2]}</td>


                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>

                                        </div><!-- /.col -->
                                        <div class="row">
                                            <br>
                                            <div  class="form-group" >
                                                <div style="float: right;" class="col-sm-3">
                                                    <label class="control-label">Total Marks :</label>
                                                    <label><h4>${total}</h4></label>
                                                </div>
                                                <div  class="col-sm-3">
<!--                                                        <label>${total}</label>-->
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-4">
                                                    <div  class="col-sm-8">
                                                        <fieldset>
                                                            <label class="control-label">Status : <span style="color: red;font-size: 12px;">*</span></label>

                                                            <form:radiobutton path="status" id="status" name="status"  value="0"/>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                            <form:radiobutton path="status" id="status" name="status" value="1"/>Inactive
                                                        </fieldset>
                                                    </div>
                                                    <div  class="col-sm-3">

                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <button type="submit"  class="btn btn-primary" style="width: 100px;" >Finish</button>
                                            </div>
                                        </div>
                                    </div><!-- /.row -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>


    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
