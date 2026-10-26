

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Safety Criteria Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h4 style="margin-top: 1px;">Vendor Safety Criteria Create</h4>
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
                                <form:form action="group.htm?act=submitSafetyCriteria" method="post" commandName="safetyCriteria"
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
                                                            <input required style="width: 15vh; " type="text" class="form-control" name="srNo1" value="1" readonly>
                                                        </td>
                                                        <td id="name1">
                                                            <input required  type="text" class="form-control" placeholder="Criteria Name" name="criteriaName" id="criteriaName">
                                                        </td>

                                                        <td id="value1">
                                                            <input required type="text" class="form-control" name="criteriaDescription" placeholder="Criteria Description" id="criteriaDescription">
                                                        </td>
                                                        <td id="value1">
                                                            <select required name="mandatory" class="form-control">
                                                                <option value="">-- Select --</option>
                                                                <option value="Yes">Yes</option>
                                                                <option value="No">No</option>
                                                            </select>
                                                        </td>
                                                        <td id="value1">
                                                            <select required name="checkbox" class="form-control">
                                                                <option value="">-- Select --</option>
                                                                <option value="1">Yes</option>
                                                                <option value="0">No</option>
                                                            </select>
                                                        </td>


                                                        <td style="">
                                                            <span style='margin-top: 5px;'>
                                                                &nbsp;&nbsp;<input type="button" value="+" id="policyCloneid5"/>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3 col-sm-offset-3">
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



                        + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Criteria Description\" name=\"criteriaDescription" + "\" id=\"criteriaDescription" + tempCount5 + "\"></td>"




                        + "<td>"
                        + "<select name='mandatory' class='form-control' id='mandatory" + tempCount5 + "'>"
                        + "<option value=''>-- Select --</option>"
                        + "<option value='Yes'>Yes</option>"
                        + "<option value='No'>No</option>"
                        + "</select>"
                        + "</td>"



                        + "<td>"
                        + "<select name='checkbox' class='form-control' id='checkbox" + tempCount5 + "'>"
                        + "<option value=''>-- Select --</option>"
                        + "<option value='1'>Yes</option>"
                        + "<option value='0'>No</option>"
                        + "</select>"
                        + "</td>"

                        + "<td >"
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
                var policyCount5 = document.getElementById('policyTable5').rows.length - 1; // subtract 1 for header row
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
    <%@include file="/WEB-INF/jsp/Common/Footer1.jsp"%>

</html>
