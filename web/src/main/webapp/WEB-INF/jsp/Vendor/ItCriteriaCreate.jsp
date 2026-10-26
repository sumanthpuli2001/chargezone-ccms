<%-- 
    Document   : ItCriteriaCreate
    Created on : 23 Aug, 2025, 2:58:27 PM
    Author     : bulwarks-2
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendor IT Criteria Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Vendor IT Criteria Create</h4>
                <input type="button"  class="btn btn-primary" style="" onclick="history.back();" title="" value="Back" >
            </div>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="group.htm?act=submitItCriteria" method="post" commandName="itCriteria"
                                           class="form-horizontal" role="form">

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Group  Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <select class="form-control" id="groupName" name="groupName" required="true" onchange="fetchGroupCategory(this.value)">
                                                <option value="">--select--</option>
                                                <c:forEach var="list" items="${list}">
                                                    <option value="${list.id}">${list.groupName}</option>
                                                </c:forEach>
                                            </select>              
                                        </div>
                                    </div>






                                    <div class="form-group">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="policyTable5" class="table table-bordered table-striped table-hover" style="" align="center">
                                                    <tr>
                                                        <th >Sr. No.</th>
                                                        <th >Criteria Name</th>
                                                        <th >Criteria Description</th>
                                                        <th >Mandatory</th>
                                                        <th>Compulsary</th>
                                                        <th >Add New</th>
                                                    <input type="hidden" name="policyCount5" id="policyCount5" value="1"/>
                                                    </tr>
                                                    <tr id="policyRow1">
                                                        <td id="policyId1" style="width: 15vh;">
                                                            <input required="true"  style="width: 15vh;" type="text" class="form-control" name="srNo1" value="1" readonly>
                                                        </td>
                                                        <td id="name1">
                                                            <input required="true"  type="text" class="form-control" name="criteriaName" placeholder="Criteria Name" id="criteriaName">
                                                        </td>

                                                        <td id="value1">
                                                            <input type="text" required   class="form-control" name="criteriaDescription" placeholder="Criteria Description" id="criteriaDescription">
                                                        </td>
                                                        <td id="value1">
                                                            <select required="true"  name="mandatory" class="form-control">
                                                                <option value="">-- Select --</option>
                                                                <option value="Yes">Yes</option>
                                                                <option value="No">No</option>
                                                            </select>      
                                                        </td>
                                                        <td id="value1">
                                                            <select required="true"  name="yesNo" class="form-control">
                                                                <option value="">-- Select --</option>
                                                                <option value="1">Yes</option>
                                                                <option value="0">No</option>
                                                            </select>
                                                        </td>


                                                        <td >
                                                            <span style='margin-top: 10px;'>
                                                                &nbsp;&nbsp; <input type="button" value="+" id="policyCloneid5"/>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                        </div>
                                    </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <script>
        var tempCount5 = 1;
        $(function () {
            $("#policyCloneid5").on("click", function () {
                tempCount5++;
                var clone = "<tr id='addmoreFile" + tempCount5 + "' style='clear:both;'>"
                        + "<td style=\"width: 15vh;\" id=\"policyId" + tempCount5 + "\"><input style=\"width: 15vh; \" type=\"text\" class=\"form-control\" name=\"srNo" + tempCount5 + "\" value=\"" + tempCount5 + "\" readonly></td>"
                        + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Criteria Name\" name=\"criteriaName" + "\" id=\"criteriaName" + tempCount5 + "\"></td>"



                        + "<td><input type=\"text\" class=\"form-control\" placeholder=\"Criteria Description\" name=\"criteriaDescription\" id=\"criteriaDescription" + tempCount5 + "\"></td>"


                        + "<td>"
                        + "<select name='mandatory' class='form-control' id='mandatory" + tempCount5 + "'>"
                        + "<option value=''>-- Select --</option>"
                        + "<option value='Yes'>Yes</option>"
                        + "<option value='No'>No</option>"
                        + "</select>"
                        + "</td>"


                        + "<td>"
                        + "<select name='yesNo' class='form-control' id='yesNo" + tempCount5 + "'>"
                        + "<option value=''>-- Select --</option>"
                        + "<option value='1'>Yes</option>"
                        + "<option value='0'>No</option>"
                        + "</select>"
                        + "</td>"

                        + "<td>"

                        + "<span style='margin-top: 5px;'>"
                        + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;'   onclick=\"removePolicy('addmoreFile" + tempCount5 + "');\"/>"
                        + "</span>"
                        + "</td>" + "</tr>";
                $("#policyTable5").append(clone);
                document.getElementById('policyCount5').value = tempCount5;
            });
        });





        function removePolicy(policyDiv) {
            try {
                var element1 = document.getElementById(policyDiv);
                element1.parentNode.removeChild(element1);

                // Update the serial numbers
                updateSerialNumbers();

                // Update policyCount5
                var policyCount5 = document.getElementById('policyTable5').rows.length - 1;
                document.getElementById('policyCount5').value = policyCount5;
            } catch (e) {
                console.log(e);
            }
        }

        function updateSerialNumbers() {
            var table = document.getElementById('policyTable5');
            var rowCount = table.rows.length;
            var srNo = 1;
            for (var i = 1; i < rowCount; i++) {
                if (table.rows[i].id !== '') { // Skip the header row
                    table.rows[i].cells[0].getElementsByTagName('input')[0].value = srNo++;
                }
            }
        }
    </script>   
    <script>
        function fetchGroupCategory(groupName) {
            var groupMasterId = document.getElementById("groupName").value;

            $.ajax({
                data: 'groupName=' + groupName,
                url: "group.htm?act=selectgroupCategoryByGroupName",
                success: function (content) {

                    var data1 = "";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupCategory']).length;
                    var object = obj['groupCategory'];

                    for (var i = 0; i < objLength; i++) {

                        if (i === 0) {

                            data1 = "<option value=''>-- Select --</option><option value='" + object[i].id + "'>" + object[i].groupCategoryName + "</option>";

                        } else {
                            data1 += "<option value='" + object[i].id + "'>" + object[i].groupCategoryName + "</option>";
                        }
                        document.getElementById('groupCategoryName').innerHTML = data1;
                    }


                }


            });
        }

        function fetchGroupSubCategory(groupCategoryName) {
            var groupCategoryId = document.getElementById("groupCategoryName").value;

            $.ajax({
                data: 'groupCategoryName=' + groupCategoryName,
                url: "group.htm?act=selectgroupSubCategoryByGroupCategory",
                success: function (content) {

                    var data1 = "";
                    var obj = JSON.parse(content);
                    var objLength = Object.keys(obj['groupSubCategory']).length;
                    var object = obj['groupSubCategory'];

                    for (var i = 0; i < objLength; i++) {

                        if (i === 0) {

                            data1 = "<option value=''>-- Select --</option><option value='" + object[i].id + "'>" + object[i].subCategoryName + "</option>";

                        } else {
                            data1 += "<option value='" + object[i].id + "'>" + object[i].subCategoryName + "</option>";
                        }
                        document.getElementById('SubCategoryName').innerHTML = data1;
                    }


                }


            });
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>

</html>
