<%-- 
    Document   : VendorSafetyLevelOneCriteria
    Created on : 4 Jan, 2025, 1:02:09 PM
    Author     : bulwarks-2
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vendor Safety Criteria</title>

        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }

        </style>


        <script>
            var flag3 = true;
                    function saveSubmit11() {
                    if (flag3) {
                    flag3 = false;
                            document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                            document.form1.submit();
                            return true;
                    } else {
                    return false;
                    }
                    }
        </script>
    </head>
    <body>
        <div class="content-wrapper" style="min-height: 720px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Vendor Safety Criteria</h1>
                <ol class="breadcrumb">

                    <input type="button" class="btn btn-primary" style="width: 100px;position: relative; bottom: 2vh; width: 100px; " onclick="history.back();" title="" value="Back">
                </ol>
            </section>

            <!-- Main content -->
            <form:form action="vendorInformation.htm?act=safetyCriteriaLevelOneSubmit" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                       class="form-horizontal" role="form" name="form">
                <input type="hidden" id="VInformationId" name="VInformationId" value="${VInformationId}"/>





                <section class="content">
                    <div class="row">
                        <div class="col-md-12">

                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    
                                    <div class="box-body no-padding">

                                        <div class="row">

                                            <div class="col-md-12 col-sm-12">
                                                <div class="table">


                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <tr style="background: gainsboro">

                                                            <th>Criteria</th>
                                                            <th>Selection Criteria</th>
                                                            <th>Score</th>
                                                            <th>Comment</th>
                                                            <th>Attachment</th>
                                                        </tr>
                                                        <c:set var="groupname" value=""/>
                                                        <c:forEach var="list" items="${list6}" varStatus="status1">
                                                            <c:if test="${list[1] != groupname}">
                                                                <tr>
                                                                    <td colspan="5"><b style="font-size: 16px;">${list[1]} </b></td>
                                                                </tr>
                                                            </c:if>    
                                                            <tr>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                            <input type="hidden" name="criteriaName" value="${list[2]}"  >
                                                            <input type="hidden" name="criteriaDescription" value="${list[3]}"  >
                                                            <td>
                                                                <c:forEach var="list66" items="${list66}" varStatus="status">
                                                                    <c:if test="${list[2]==list66.criteriaName && list[3]==list66.criteriaDescription}">
                                                                        <input type="hidden" value="${list66.id}"  name="hrId" id="hrId">

                                                                        <select name="score" id="score${status1.count}" class="form-control" onchange="response();" required="required">
                                                                            <c:choose>
                                                                                <c:when test="${list66.score=='0'}">
                                                                                    <option value="">--Select--</option>
                                                                                    <option selected="true" value="0">0</option>
                                                                                    <option value="1">1</option>
                                                                                    <option value="2">2</option>
                                                                                </c:when>
                                                                                <c:when test="${list66.score=='1'}">
                                                                                    <option value="">--Select--</option>
                                                                                    <option value="0">0</option>
                                                                                    <option selected="true" value="1">1</option>
                                                                                    <option value="2">2</option>
                                                                                </c:when>
                                                                                <c:when test="${list66.score=='2'}">
                                                                                    <option value="">--Select--</option>
                                                                                    <option value="0">0</option>
                                                                                    <option value="1">1</option>
                                                                                    <option selected="true" value="2">2</option>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <option value="">--Select--</option>
                                                                                    <option value="0">0</option>
                                                                                    <option value="1">1</option>
                                                                                    <option value="2">2</option>
                                                                                </c:otherwise>
                                                                            </c:choose>



                                                                        </select>
                                                                    <td><textarea name="comment" class="form-control" required="required">${list66.comment}</textarea></td>
                                                                    <td>
                                                                        <span>
                                                                            <a href="vendorInformation.htm?act=downloadFileAprrove&amp;fileName=${list66.attachement}">${list66.attachement}</a>
                                                                        </span>
                                                                        <input type="hidden" class="form-control" name="attachment1" value="${list66.attachement}">
                                                                        <input type="file" class="form-control" name="attachment" id="file${status.count}" onchange="validateFileSize(this, 'fileError${status.count}');">
                                                                        <span id="fileError${status.count}" style="color: red; font-size: 11px; display: none;">* File should not exceed 5MB</span>
                                                                    </td>
                                                                </c:if>

                                                            </c:forEach>




                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td colspan="2">Total</td>
                                                            <td><input type="text" id="total" readonly="true" name="total" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2">Total Percentage</td>
                                                            <td><input type="text" id="percentage" readonly="true" name="percentage" class="form-control"></td>
                                                        </tr>
                                                    </table>
                                                    <script>
                                                                function validateFileSize(input, errorId) {
                                                                const file = input.files[0]; // Get the selected file
                                                                        const maxSize = 5 * 1024 * 1024; // 5MB

                                                                        if (file && file.size > maxSize) {
                                                                document.getElementById(errorId).style.display = 'block';
                                                                        input.value = ''; // Clear the file input
                                                                } else {
                                                                document.getElementById(errorId).style.display = 'none';
                                                                }
                                                                }
                                                    </script>
                                                    <script>
                                                        function response() {

                                                        var l = document.form.criteriaName ? document.form.criteriaName.length : 0;
                                                                var i = 1;
                                                                var sum = 0;
                                                                var total = l * 2;
                                                                if (l == null) {
                                                        var accept = parseFloat(document.getElementById("score1").value);
                                                                sum += accept;
                                                                var totals = 2;
                                                                var total1 = (sum * 100) / totals;
                                                                document.getElementById("total").value = sum;
                                                                document.getElementById("percentage").value = total1.toFixed(2);
                                                        } else {
                                                        while (i <= l) {
                                                        var accept = parseFloat(document.getElementById("score" + i).value) || 0;
                                                                sum += accept;
                                                                i++;
                                                        }
                                                        var total1 = (sum * 100) / total;
                                                                document.getElementById("total").value = sum;
                                                                document.getElementById("percentage").value = total1.toFixed(2);
                                                        }

                                                        }
                                                    </script>


                                                    <div class="form-group">
                                                        <div class="col-sm-12 text-center" style="margin-top: 20px;">
                                                            <input type="submit" class="btn btn-primary" style="width: 150px !important;" title="" value="Save And Next">
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

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

    </body>
    <body onload="response();">

    </body>

</html>


