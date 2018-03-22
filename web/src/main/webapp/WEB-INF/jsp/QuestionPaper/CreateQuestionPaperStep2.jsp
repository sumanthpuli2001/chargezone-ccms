<%-- 
    Document   : newjspCreateQuestionPaperStep2
    Created on : 26 Feb, 2018, 12:44:09 PM
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
            <h1>Question Paper Create Step 2</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Question Paper</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" method="post" commandName="questionPaper" action="questionLibrary.htm?act=searchQuestionLibraryRecord">
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
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label><h4>Filter Questions</h4></label>
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-5"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Question : <span style="color: red;font-size: 12px;"></span></label>
                                                    <input type="text" id="question" name="question" class="form-control"/>
                                                </div>
                                                <div class="col-sm-5"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Marks : <span style="color: red;font-size: 12px;"></span></label>
                                                    <input type="text" id="marks" name="marks" class="form-control"/>
                                                </div>

                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <button  class="btn btn-primary" style="width: 100px;" onclick="window.location = 'questionLibrary.htm?act=searchQuestionLibraryRecord'"  >Search</button>
                                                </div>

                                            </div>

                                            <!--                                            <div class="form-group">
                                                                                            <div class=" col-sm-6 col-sm-offset-5">
                                                                                                <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >Save & Next</button>
                                                                                            </div>
                                                                                        </div>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </section>
        </form:form>
        <form:form action="questionLibrary.htm?act=addQuePaperData" method="post" modelAttribute="questionLibrary" commandName="questionPaper"
                   name='form1' onsubmit='return checkBoxValue();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label><h4>Searched Result</h4></label>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <div>

                                                    <button type="submit" class="btn btn-primary" style="float: right; width: 100px;" ><i class="fa fa-plus"></i>&nbsp;ADD</button>
                                                </div>
                                                <div>

                                                    &nbsp;
                                                    <form:input path="id" id="id" class="form-control" type="hidden"></form:input>
                                                    <input type="hidden" name="id" value="${questionPaper.id}"/>
                                                </div>
                                                <table id="questionTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                            <!--<th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>-->
                                                            <th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>
                                                            <th style="text-align: center; vertical-align: middle">Question</th>
                                                            <th style="text-align: center; vertical-align: middle">Marks</th>
                                                            <!--<th style="text-align: center; vertical-align: middle">Action</th>-->
                                                            <!--<input type="hidden" name="questionCount" id="questionCount" value="1"/>-->
                                                        </tr>
                                                    </thead>
                                                    <tbody id="tableData">
                                                        <c:forEach var="list" items="${list}" varStatus="status">

                                                            <tr>
                                                                <!--<td style="text-align: center; vertical-align: middle">${status.count}</td>-->
                                                                <td align="center"><input type="checkbox" name="checkId" id="hoursId" value="${list.id}"/></td>
                                                                <td style="text-align: center; vertical-align: middle">${list.question}</td>
                                                                <td style="text-align: center; vertical-align: middle">${list.marks}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div><!-- /.col -->
                                            <!--                                            <div class="form-group">
                                                                                            <div class=" col-sm-6 col-sm-offset-5">
                                                                                                <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >Save & Next</button>
                                                                                            </div>
                                                                                        </div>-->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </div>

            </section>
        </form:form>
        <form:form action="questionLibrary.htm?act=deleteQuesClick" method="post" modelAttribute="questionLibrary" commandName="questionPaper"
                   name='form1' onsubmit='return deleteCheckQuesValue();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="form-group">
                                        <div class="col-sm-5">
                                            <label><h4>Selected Questions</h4></label>

                                        </div>
                                    </div>
                                    <div>

                                        <button type="submit" class="btn btn-danger" style="float: right; width: 100px;"><i class="fa fa-trash"></i>&nbsp;DELETE</button>
                                    </div>
                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="questionTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 2%;"></th>
                                                            <th style="text-align: center; vertical-align: middle;width: 5%">Sr.No.</th>
                                                            <th style="text-align: center; vertical-align: middle">Questions</th>
                                                            <th style="text-align: center; vertical-align: middle">Marks</th>
                                                            <!--<th style="text-align: center; vertical-align: middle">Action</th>-->
                                                            <!--<input type="hidden" name="questionCount" id="questionCount" value="1"/>-->
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="questionDetailses" items="${questionDetailses}" varStatus="status">

                                                            <tr>
                                                                <td align="center" style="width: 2%;"><input type="checkbox" name="queId" id="queId" value="${questionDetailses[0]}"/></td>
                                                                <td style="text-align: center; vertical-align: middle">${status.count}</td>
                                                                <td align="center">${questionDetailses[1]}</td>
                                                                <td align="center">${questionDetailses[2]}</td>
                                                                <!--                                                                <td style="text-align: center; vertical-align: middle">
                                                                                                                                    <div class="btn-group">
                                                                                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                                                                            <span class="caret"></span>
                                                                                                                                        </button>
                                                                                                                                        <ul class="dropdown-menu" >
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>

                                                                                                                                            <li style="width: 100px;">
                                                                                                                                                <a href="#"
                                                                                                                                                   onclick="editClick(${questionDetailses[0]});">
                                                                                                                                                    &nbsp;&nbsp;View/Edit
                                                                                                                                                </a>
                                                                                                                                            </li>
                                                                <li style="width: 100px;">
                                                                    <a href="#"
                                                                       onclick="deleteClick(${questionDetailses[0]},${questionPaper.id});">
                                                                        &nbsp;&nbsp;Delete
                                                                    </a>
                                                                </li>
                                                                <%--</c:if>--%>

                                                                                                                                            <li>
                                                                                                                                        <a href="#"
                                                                                                                                        onclick="editRotation($/{list[6]});">
                                                                                                                                        &nbsp;&nbsp;Edit Shift Rotation
                                                                                                                                        </a>
                                                                                                                                        </li>
                                                            </ul>
                                                        </div></td>-->

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

                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>

            </section>
        </form:form>
        <form:form action="questionLibrary.htm?act=SubmitStep2" method="post" modelAttribute="questionPaper" commandName="questionPaper"
                   name='form1'  class="form-horizontal" role="form">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <input type="hidden" name="id" value="${questionPaper.id}"/>
                        <div class="col-sm-6 col-sm-offset-5">
                            <button type="submit"  class="btn btn-primary" style="width: 100px;" >Save & Next</button>
                        </div>
                    </div><!-- /.tab-content -->

                </div><!-- /.col -->
            </div>


        </div>
    </form:form>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>


<script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
<script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<script>
                                                        initSample();
</script>
<script>
    function checkBoxValue() {
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
<script>

//    function deleteClick(id, QpId) {
//        window.location = 'questionLibrary.htm?act=deleteQuesClick&id=' + id + '&QpId=' + QpId;
//    }

    function deleteCheckQuesValue() {
        var checkboxes = confirm("Are you sure want to delete ?");
        if (checkboxes) {
            checkboxes = document.getElementsByName('queId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
        }
        return false;
    }

</script>

