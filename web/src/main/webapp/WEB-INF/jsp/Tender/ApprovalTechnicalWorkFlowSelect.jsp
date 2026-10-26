
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TECHNICAL APPROVE TENDER WORK FLOW</title>
    </head>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="tenderMaster.htm?act=technicalApprovalWorkFlowSubmit" method="post" commandName="tenderMaster"
                           class="form-horizontal" role="form" enctype="multipart/form-data">

                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">TECHNICAL APPROVE TENDER WORK FLOW</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" id="id" name="id" value="${id}">           
                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>

                    <div class="rounded-4 mt-4">
                        <div class="row mb-3">
                            <div class="col-lg-4 col-md-6">
                                <div class="form-group">
                                    <label for="department-name" class="label">Tender No<span
                                            class="text-danger">*</span></label>

                                    <input type="text" class="input-field" id="refNo" name="refNo" value="${refNo}" readonly="true">
                                </div>
                            </div>
                        </div>
                    </div>       


                                    <table id="policyTable" class="table dt-scroll" style="max-width: 100%" align="center">
                                        <tr>
                                            <th>Approval List</th>
                                            <th class="text-center">Add New</th>
                                        <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                        </tr>
                                        <tr id="policyRow1">


                                            
                                            <td>
                                                <select id="tenderApprovalSetting1"  name="tenderApprovalSetting1"   class="select-input" required="true">
                                                      <option value="">--SELECT--</option>
                                                    <c:forEach var="employeeMaster1" items="${employeeMaster1}" varStatus = "status">
                                                        <option value="${employeeMaster1.employeeCode}">${employeeMaster1.name}</option>


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
                                + "<td id=\"addmoreFile" + tempCount3 + "\"  style=\"text-align: center\"><div>\n\
                                    <select id='tenderApprovalSetting1" + tempCount3 + "' name='tenderApprovalSetting1" + "' class=\"select-input\">"
                                + "<option value=''>--Select--</option>"
                                + "<c:forEach var='employeeMaster1' items='${employeeMaster1}'>"
                                + "<option value='${employeeMaster1.employeeCode}'>${employeeMaster1.name}</option>"
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
                                
                                
                                
                                
              <div class="col-12 p-0">
                    <div class="form-group comment-box">
                        <label class="control-label">Comment :<span class="text-danger">*</span></label>
                        <textarea type="text" maxlength="250" class="textarea-field comment" id="comment" name="comment"  required="true">${comment}</textarea>
                     </div>
                </div>                   

  <br>
                    <div class="form-group">
                   <div style="display: flex;  justify-content: center;">

                       <button type="submit" class="btn theme-btn" style="width: 100px;"  title="" onclick="return Validate()" >Submit</button>
                        </div>
                        </div>


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
