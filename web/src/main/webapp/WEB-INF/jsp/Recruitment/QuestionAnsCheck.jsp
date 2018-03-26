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

        <form:form class="form-horizontal" method="post" commandName="questionPaper" action="onlineAssessment.htm?act=submitResult">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <%--<c:choose>--%>
                                        <%--<c:when test="${empty list2}">--%>
                                        <c:if test="${not empty list2}">
                                            <div  class="col-sm-6 col-sm-offset-3">

                                                <h4> <label>Candidate User Name&nbsp;:&nbsp;</label><label style="color: #0064cd">${candidateApplyJob.name}</label></h4> 
                                            </div>
                                        </c:if>
                                        <c:if test="${empty list2}">
                                            <div class="col-sm-6 col-sm-offset-5">

                                                <c:out value="There is no record found."></c:out>
                                                </div>
                                        </c:if>
                                        <%--</c:when>--%>
                                        <%--<c:otherwise>--%>

                                        <input type="hidden" name="candidateId" id="candidateID" value="${candidateID}">
                                        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">
                                        <c:if test="${not empty list2}">
                                            <div class="form-group">
                                                <div class="col-sm-8"><h4><b>Questions</b></h4></div>
                                                <div class="col-sm-2"><h4><b>Answer Status</b></h4></div>
                                                <div class="col-sm-2"><h4><b>Marks</b></h4></div>
                                            </div>
                                        </c:if>
                                        <input type="hidden" name="countDetailId" id="countDetailId" value="${fn:length(list2)}">
                                        <c:forEach var="employeeAdditional" items="${list2}" varStatus="status">

                                            <input type="hidden" id="id" name="id" value="${employeeAdditional[8]}">
                                            <input type="hidden" id="id" name="type" value="${employeeAdditional[1]}">
                                            <input type="hidden" id="pp" name="pp" value="${employeeAdditional[6]}">
                                            <input type="hidden" id="ttm" name="ttm" value="${employeeAdditional[7]}">
                                            <div class="form-group">
                                                <div class="col-sm-8">
                                                    ${status.count}. ${employeeAdditional[0]}
                                                </div>
                                                <c:if test="${employeeAdditional[1] eq 0}">
                                                    <div class="col-sm-2">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[4]}">
                                                            Correct
                                                            <input type="hidden" name="mcqStatus${status.count}" value="0">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[4]}">
                                                            Incorrect
                                                            <input type="hidden" name="mcqStatus${status.count}" value="1">
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${employeeAdditional[3] eq employeeAdditional[4]}">
                                                        <div class="col-sm-2">
                                                            <input type="text" value="${employeeAdditional[5]}" id="givenMarks2${status.count}" name="givenMarks2" class="form-control" readonly="true">
                                                            /Out of <b>${employeeAdditional[5]}</b>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${employeeAdditional[3] ne employeeAdditional[4]}">
                                                        <div class="col-sm-2">
                                                            <input type="text" value="0" name="givenMarks2" class="form-control" id="givenMarks2${status.count}" readonly="true">
                                                            /Out of <b>${employeeAdditional[5]}</b>
                                                        </div>
                                                    </c:if>
                                                </c:if>
                                                <c:if test="${employeeAdditional[1] eq 1}">

                                                    <div class="col-sm-1">
                                                        <input class="form-check-input" name="mcqStatus${status.count}" type="radio"  value="0" >
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">Correct</label>
                                                    </div>
                                                    <div class="col-sm-1">
                                                        <input class="form-check-input" name="mcqStatus${status.count}" type="radio"  value="1" >
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">Incorrect</label>
                                                    </div>
                                                    <div class="col-sm-2">

                                                        <input type="number" name="givenMarks2" class="form-control" id="givenMarks3${status.count}" class="form-control">
                                                        <label>/Out Of ${employeeAdditional[5]}</label>
                                                    </div>
                                                </c:if>

                                                <c:if test="${employeeAdditional[1] eq 0}">
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[10]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[2]}"  checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[10]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[2]}"  disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[3]}">${employeeAdditional[9]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[12]}">
                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[4]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[12]}">
                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[4]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[6]}">${employeeAdditional[11]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[14]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[7]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[14]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[7]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[8]}">${employeeAdditional[13]}</label>
                                                    </div>
                                                    <div class="col-sm-10">
                                                        <c:if test="${employeeAdditional[3] eq employeeAdditional[16]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio" id="radio100${status.count}" value="${employeeAdditional[9]}" checked="true">
                                                        </c:if>
                                                        <c:if test="${employeeAdditional[3] ne employeeAdditional[16]}">

                                                            <input class="form-check-input" name="${status.count}" type="radio"  value="${employeeAdditional[9]}" disabled>
                                                        </c:if>
                                                        <label class="form-check-label" for="radio100${employeeAdditional[10]}">${employeeAdditional[15]}</label>
                                                    </div>
                                                </c:if>
                                                <c:if test="${employeeAdditional[1] eq 1}">
                                                    <div class="col-sm-8">
                                                        <textarea type="text" class="form-control"  name="${status.count}" id="${status.count}" rows="4" cols="70" readonly="true">${employeeAdditional[9]}</textarea>
                                                    </div>
                                                </c:if>



                                            </div>



                                        </c:forEach>
                                        <%--</c:otherwise>--%>

                                        <c:if test="${not empty list2}">
                                            <div class="row">
                                                <div class="form-group">

                                                    <div  class="col-sm-3">


                                                        <h4> <label> Result Status :</label>&nbsp;
                                                            <label style="color: red;" id="reStatusFail"></label><input type="hidden" id="failResult" name="failResult">
                                                            <label style="color: green;" id="reStatusPass"></label><input type="hidden" id="passResult" name="passResult">
                                                        </h4>

                                                    </div>
                                                    <div  class="col-sm-3">


                                                        <h4> <label> Percentage :&nbsp;</label>
                                                            <label style="color: blue;" id="per"></label>
                                                            <input type="hidden" name="percentageResult" id="percentageResult">
                                                        </h4>

                                                    </div>
                                                    <div  class="col-sm-3">


                                                        <h4> <label>Obtain Marks :</label>&nbsp;<label id="obtainTT" ></label>
                                                            <input type="hidden" name="totalResult" id="totalResult">
                                                        </h4>



                                                    </div>
                                                    <div style="float: right;" class="col-sm-3">


                                                        <h4> <label>Total Marks :</label>&nbsp;<label id="tt" ></label>
                                                            <!--<input type="hidden" name="totalResult" id="totalResult">-->
                                                        </h4>



                                                    </div>



                                                </div>


                                                <div class="form-group">
                                                    <div class=" col-sm-6 col-sm-offset-5">
                                                        <a onclick="totalcal()" class="btn btn-default">Check Result</a>
                                                        <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
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
        var data;
        var givenMarks2;
        var givenMarks3;
        var ttlm = 0;
        var len = document.getElementById("countDetailId").value;
        for (var i = 1; i < parseInt(len) + 1; i++) {
//            data1 = document.getElementById("candidateIDEmp" + i).value;
            if (document.getElementById("givenMarks2" + i) == null) {
                givenMarks2 = 0
            } else {
                givenMarks2 = document.getElementById("givenMarks2" + i).value;
                
                ttlm = ttlm + Number(givenMarks2);
            }
            if (document.getElementById("givenMarks3" + i) == null) {
                givenMarks3 = 0
            } else {
                givenMarks3 = document.getElementById("givenMarks3" + i).value;
                ttlm = ttlm + Number(givenMarks3);
                
            }
        }


        var pp = document.getElementById("pp").value;
        var ttm = document.getElementById("ttm").value;
//        var text_value1 = $("#givenMarks1").val();
//        var text_value3 = $("#givenMarks3").val();
       
//        var ttlm = Number(givenMarks2) + Number(givenMarks3);
        var per = (ttlm * 100) / Number(ttm);
        
        document.getElementById("obtainTT").innerHTML = ttlm;
        document.getElementById("per").innerText = Number(per).toFixed(2);
        document.getElementById("percentageResult").value = Number(per).toFixed(2);
        if (per < pp) {
            document.getElementById("reStatusFail").innerText = "FAIL";
            document.getElementById("failResult").value = "FAIL";
            document.getElementById("reStatusPass").innerText = "";
            document.getElementById("passResult").value = "";

        } else {
            document.getElementById("reStatusPass").innerText = "PASS";
            document.getElementById("failResult").value = "";
            document.getElementById("reStatusFail").innerText = "";
            document.getElementById("passResult").value = "PASS";
        }

        document.getElementById("tt").innerText = ttm;
        document.getElementById("totalResult").value = ttlm;



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
