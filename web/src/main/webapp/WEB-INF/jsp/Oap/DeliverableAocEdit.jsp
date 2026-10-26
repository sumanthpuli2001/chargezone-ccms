
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deliverable AOC Edit</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=DeliverableAocEditSubmit" method="post" commandName=""
                                           class="form-horizontal" role="form">


                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Deliverable AOC Edit</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" name="id" id="id" value="${id}">
                    <input type="hidden" name="id1" value="${aocformid}"> 

                    <span class="text-danger">* indicates mandatory field.</span>
                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label class="label">Date <span class="text-danger">*</span></label>
                                    <input class="input-field datepicker" name="date" id="serverip"  value="${list25.date}" placeholder="DD/MM/YYYY" required="required"/>

                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
$(function () {


                        flatpickr("#serverip", {
                            dateFormat: "d-m-Y",
                            allowInput: true
                        });
                        });
                    </script>

                    <div class="col-12 p-0">
                        <div class="form-group comment-box">
                            <label class="control-label">Comment :<span class="text-danger">*</span></label>
                            <textarea type="text" maxlength="250" class="textarea-field comment" id="description" name="description"  required="true"> ${list25.description}</textarea>
                        </div>
                    </div>

                    <h6 class="fw-600">Site Survey Details</h4>               
                        <table id="commonTable" class="table  table-striped bg-white" style="  max-width: 100%;" align="center">
                            <thead>
                                <tr>
                                    <th>Sr No</th>
                                    <th>Survey No</th>
                                    <th>Project Representative</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach var="aocSurveyAttch" items="${aocSurveyAttch}" varStatus="status">
                                    <tr>
                                        <td >${status.count}</td>
                                        <td><a class="fw-600 text-break gradient-text" href="oapForm.htm?act=siteSurveyView&id=${aocSurveyAttch.surveyNo}">${aocSurveyAttch.surveyNo}</a></td>
                                        <td >${aocSurveyAttch.projectRepresentative}</td>

                                    </tr>
                                </c:forEach>


                            </tbody>



                        </table>

                        <table id="commonTable1"  class="table table-striped bg-white" style="max-width: 100%;"> <!-- Set maximum width and border -->

                            <thead>
                                <tr>
                                    <th >Description</th>
                                    <th >Design Co-ordinator</th>
                                    <th data-dt-order="disable">Action</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach var="list28" items="${list28}">
                                    <tr>
                                        <td ><span>${list28.description}</span>
                                        </td> 
                                        <td><span>${list28.designCoordinator}</span>
                                        </td> 

                                        <td >
                                            <a href="oapForm.htm?act=deliverymultidelete&id1=${list28.id}&id=${id}" class="d-block text-danger p-1 mx-1"data-toggle="tooltip" data-placement="left"  title="Delete"><img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)"alt="Delete Icon" style="width: 22px; height: 22px;">
                                            </a> 




<!--                                                    <a href="oapForm.htm?act=deliverymultidelete&id1=${list28.id}&id=${id}">
    <i class="fas fa-trash-alt" style="color: red;"></i>
</a>-->
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>

                        </table> 
                    <hr>
<table id="policyTable" class="table dt-scroll" style="max-width: 100%" align="center">
                                                        <tr>

                                                            <th style="text-align: center; vertical-align: middle">Description</th>
                                                            <th style="text-align: center; vertical-align: middle">Design Co-ordinator</th>
                                                            <th style="text-align: center; vertical-align: middle">Add New</th>
                                                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                        <tr id="policyRow1">
                                                            <td>
                                                                <input id="description1" name="descriptions" placeholder="Description" class="input-field" type="text" required="required">
                                                            </td>  
                                                            <td>
                                                                <select class="select-input" id="attachment1" name="attach" style=" font-size: 12px; padding: 5px;" required="required" >
                                                                    <option value="">--SELECT--</option>
                                                                    <c:forEach var="list23" items="${list23}">
                                                                        <option value="${list23[1]}">${list23[0]}</option>
                                                                    </c:forEach>
                                                                </select>
                                                            </td> 
                                                            <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                                                <div class="clone-action clone-new-field mb-2" id="policyCloneid" style="cursor:pointer;">
                                                                    <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </table>                                   
                                                    
                                                    
                                                    
                                                    
                                                    
                 <script>
                     
                     
                     
                        var tempCount3 = 1;
                        $(function () {
                            $("#policyCloneid").on("click", function () {
                                tempCount3++;
                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                + "<td><input type =\"text\" class=\"input-field\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\"></td>"
                                + "<td id=\"addmoreFile" + tempCount3 + "\"  style=\"text-align: center\"><div>\n\
                                    <select id='attachment" + tempCount3 + "' name='attach" + "' class=\"select-input\">"
                                + "<option value=''>--Select--</option>"
                                + "<c:forEach var='list23' items='${list23}'>"
                                + "<option value='${list23[1]}'>${list23[0]}</option>"
                                + "</c:forEach>"
                                + "</select>"
                                + "</div></td>"
                                + "<td class=\"d-flex justify-content-center align-items-center\">"
                                + "<span style='margin-top: 5px;'>"
                                + "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\">"
                                + "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
                                + "</div>"
                                + "</span>"
                                + "</td>"
                                + "</tr>";
                                $("#policyTable").append(clone);
                                document.getElementById('policyCount').value = tempCount3;
                                $('.select-input').selectpicker("refresh");
                                addBPolicy(tempCount3);
                                
                                
                            });
                        });
                        $("#policyTable").on("click", ".delete-parent-field", function () {
                            var row = $(this).closest("tr");
                            row.remove();
                            var policyCount = document.getElementById('policyTable').rows.length - 1;
                            document.getElementById('policyCount').value = policyCount;
                        });
                    </script> 



                    </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
