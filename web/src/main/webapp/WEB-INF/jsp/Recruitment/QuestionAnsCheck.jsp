<%-- 
    Document   : QuestionAnsCheck
    Created on : 13 Mar, 2018, 10:48:49 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>

    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Check Question Paper Ans</title>

    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Check Question Paper Answer</h1>
            <label>Candidate User Name&nbsp; : &nbsp;&nbsp;${ajuMaster.userName}</label>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Check Question Paper Answer</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->

        <form:form class="form-horizontal" method="post" commandName="questionPaper" action="questionLibrary.htm?act=submitQuestionPaperStep1">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <%--<c:choose>--%>
                                        <%--<c:when test="${empty list2}">--%>
                                        <c:if test="${empty list2}">
                                            <div class="col-md-12 col-sm-12">

                                                <c:out value="There is no record found."></c:out>
                                                </div>
                                        </c:if>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>

                                        <input type="hidden" name="candidateID" id="candidateID" value="${candidateID}">
                                        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">

                                        <div class="form-group">
                                            <div class="col-sm-8"><h4><b>Questions</b></h4></div>
                                            <div class="col-sm-2"><h4><b>Answer Status</b></h4></div>
                                            <div class="col-sm-2"><h4><b>Marks</b></h4></div>
                                        </div>
                                        <c:forEach var="employeeAdditional" items="${list2}" varStatus="status">


                                            <div class="form-group">
                                                <div class="col-sm-8">
                                                    ${status.count}. ${employeeAdditional[0]}
                                                </div>
                                                <c:if test="${employeeAdditional[1] eq 0}">
                                                    <div class="col-sm-2">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[4]}">
                                                            Correct
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[4]}">
                                                            Incorrect
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${employeeAdditional[3] eq employeeAdditional[4]}">
                                                        <div class="col-sm-2">
                                                            <input type="text" value="${employeeAdditional[5]}" id="givenMarks2" name="givenMarks2" class="form1" readonly="true">
                                                            /Out of <b>${employeeAdditional[5]}</b>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${employeeAdditional[3] ne employeeAdditional[4]}">
                                                        <div class="col-sm-2">
                                                            <input type="text" value="0" name="givenMarks2" class="form1" id="givenMarks2" readonly="true">
                                                            /Out of <b>${employeeAdditional[5]}</b>
                                                        </div>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${employeeAdditional[1] eq 1}">

                                                    <div class="col-sm-1">
                                                        <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[4]}" >
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">Correct</label>
                                                    </div>
                                                    <div class="col-sm-1">
                                                        <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[4]}" >
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">Incorrect</label>
                                                    </div>
                                                    <div class="col-sm-2">

                                                        <input type="number" name="givenMarks1" class="form-control" id="givenMarks3" class="form2">
                                                        <label>/Out Of ${employeeAdditional[5]}</label>
                                                    </div>
                                                </c:if>

                                                <c:if test="${employeeAdditional[1] eq 0}">
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[7]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[2]}"  checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[7]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[2]}"  disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[3]}">${employeeAdditional[6]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[9]}">
                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[4]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[9]}">
                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[4]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">${employeeAdditional[8]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[11]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[7]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[11]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[7]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[8]}">${employeeAdditional[10]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[13]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[9]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[13]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[9]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[10]}">${employeeAdditional[12]}</label>
                                                    </div>
                                                </c:if>
                                                <c:if test="${employeeAdditional[1] eq 1}">
                                                    <div class="col-sm-8">
                                                        <textarea type="text" class="form-control"  name="${status.count}" id="${status.count}" rows="4" cols="70" readonly="true">${employeeAdditional[6]}</textarea>
                                                    </div>
                                                </c:if>
                                                ${givenMarks2}


                                            </div>



                                        </c:forEach>
                                        <%--</c:otherwise>--%>


                                        <div class="form-group">
                                            <div class="col-sm-5">

                                            </div>
                                            <div class="col-sm-5">


                                            </div>

                                            <div class="row">
                                                <br>
                                                <div  class="form-group" >
                                                    <div style="float: right;" class="col-sm-3">
                                                        
                                                      
                                                        <h4> <label class="control-label">Total Marks :   <a onclick="totalcal()" class="btn btn-default">Calculate</a></label></h4>
                                                        <label><input id="tt" class="form-control"></label>
                                                    </div>
                                                   
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <div class=" col-sm-6 col-sm-offset-5">
                                                    <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >Save & Next</button>
                                                </div>
                                            </div>
                                        </div>
                                        <%--</c:choose>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
    <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script>
                                                            initSample();
    </script>
</html>
<script>
    function totalcal() {
//        var text_value = $("#givenMarks2").val();
        var givenMarks2 = document.getElementById("givenMarks2").value;
        var givenMarks3 = document.getElementById("givenMarks3").value;
//        var text_value1 = $("#givenMarks1").val();
//        var text_value3 = $("#givenMarks3").val();
       

       document.getElementById("tt").value= Number(givenMarks2)+Number(givenMarks3);
    

    }
//    $(document).ready(function () {
//       
//// Function to get input value.
//        $('#givenMarks2').click(function () {
//            var text_value = $("#givenMarks2").val();
//            if (text_value == '') {
//                alert("Enter Some Text In Input Field");
//            } else {
//                alert(text_value);
//            }
//        });
//        $('#givenMarks1').click(function () {
//            var text_value = $("#givenMarks1").val();
//            if (text_value == '') {
//                alert("Enter Some Text In Input Field");
//            } else {
//                alert(text_value);
//            }
//        });
//    });
</script>
