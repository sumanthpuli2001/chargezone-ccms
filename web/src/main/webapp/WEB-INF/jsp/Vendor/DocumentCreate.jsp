<%-- 
    Document   : SapCreate
    Created on : Oct 18, 2023, 11:44:51 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Document Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px; justify-content: space-between; align-items: center;">
                <h3 style="margin-top: 1px;">Document Create</h3>
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
                                <form:form action="oapForm.htm?act=DocumentCreateSubmit" method="post" commandName="sapConnection"
                                           class="form-horizontal" role="form">


                                    <div class="form-group row ">

                                        <div class="col-sm-2 ">
                                            <label class="control-label "style="padding-left: 25px;">
                                                State<span style="color: red; font-size: 10px;">*</span>
                                            </label>
                                        </div>

                                        <div class="col-sm-3">
                                            <select class="form-control" id="documentname" name="documentname" required="required">
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list2" items="${list2}">
                                                    <option value="${list2.state}">${list2.state}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                         <div class="col-md-2 d-flex align-items-center">
                                            <label class="control-label" style="padding-left: 25px;">
                                                Discom<span style="color: red; font-size: 10px;">*</span>
                                            </label>
                                        </div>

                                        <!-- Discom Select Box -->
                                        <div class="col-md-3">
                                            <select class="form-control" id="discom" name="discom" required="required">
                                                <option value="">--SELECT--</option>
                                               
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <!-- Discom Label -->
                                       

                                        <!-- Connection Type Label -->
                                        <div class="col-md-2 ">
                                            <label class="control-label" style="padding-left: 25px;">
                                                Connection Type<span style="color: red; font-size: 10px;">*</span>
                                            </label>
                                        </div>

                                        <!-- Connection Type Select Box -->
                                        <div class="col-md-3">
                                            <select class="form-control" id="connectiontype" name="connectiontype" required="required">
                                                <option value="">--SELECT--</option>
                                                <c:forEach var="list3" items="${list3}">
                                                    <option value="${list3.id}">${list3.connectionType}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    
                                   <script>
   document.addEventListener("DOMContentLoaded", function () {
    var stateDropdown = document.getElementById("documentname"); // Dropdown for selecting state
    var discomDropdown = document.getElementById("discom"); // Dropdown for selecting discom

    // Creating an array to store the states and their respective discom types
    var data = [
        <c:forEach var="list2" items="${list2}" varStatus="status">
            {
                locationName: "${list2.state}", // The state name
                discomType: "${list2.discomType}", // The corresponding discom type
                id: "${list2.id}" // The corresponding discom id
            }
            <c:if test="${!status.last}">,</c:if> 
        </c:forEach>
    ];

    // Event listener to handle state change and populate discom options
    stateDropdown.addEventListener("change", function () {
        var selectedState = this.value; // Get the selected state value
        discomDropdown.innerHTML = '<option value="">--SELECT--</option>'; // Reset discom dropdown

        // If a state is selected, populate the discom dropdown
        if (selectedState) {
            data.forEach(function (item) {
                if (item.locationName === selectedState) {
                    var option = document.createElement("option");
                    option.value = item.id; // Set discom ID as value
                    option.textContent = item.discomType; // Set discom type as text
                    discomDropdown.appendChild(option); // Add the option to the dropdown
                }
            });
        }
    });

    // Event listener to handle discom selection and save the discom ID to the database
    discomDropdown.addEventListener("change", function () {
        var selectedDiscomId = this.value; // Get the selected discom ID

        // If a discom is selected, send an AJAX request to store it in the database
        if (selectedDiscomId) {
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/saveDiscomId", true); // Assuming '/saveDiscomId' is the server endpoint to store discom ID
            xhr.setRequestHeader("Content-Type", "application/json");

            var dataToSend = JSON.stringify({
                discomId: selectedDiscomId // Send the discom ID to the backend
            });

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    console.log("Discom ID saved successfully!");
                }
            };

            xhr.send(dataToSend); // Send the request
        }
    });
});

</script>
        


                                    <div class="form-group">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table-responsive">
                                                <table id="policyTable" class="table table-bordered table-striped table-hover" style="max-width: 95%" align="center">
                                                    <tr>
                                                        <!--<th style="text-align: center; vertical-align: middle">Sr. No.</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Document Name</th>
                                                        <th style="text-align: center; vertical-align: middle">Mandatory</th>

                                                        <!--                                                            <th style="text-align: center; vertical-align: middle">Document name</th>-->

                                                        <th style="text-align: center; vertical-align: middle">Add New</th>
                                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                    </tr>
                                                    <tr id="policyRow1">
                                                        <!--                                                        <td id="policyId1">
                                                                                                                    <input type="text" class="form-control" name="srNo1" value="1" readonly>
                                                                                                                </td>                                                           -->
                                                        <td>
                                                            <input id="attachment1" name="attach" class="form-control" type="text" placeholder="Document Name" >

                                                        </td> 



                                                        <td>
                                                            <select id="description1" class="form-control" name="descriptions" placeholder="Description" required="required">
                                                                <option value="" disabled selected>--SELECT--</option>
                                                                <option value="yes">Yes</option>
                                                                <option value="no">No</option>
                                                            </select>
                                                        </td>






                                                        <td style="text-align: center">
                                                            <span style='margin-top: 5px;'>
                                                                <input type="button" value="+" id="policyCloneid"/>
                                                            </span>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>

                                    <script>
                                        var tempCount3 = 1;
                                        $(function () {
                                            $("#policyCloneid").on("click", function () {
                                                tempCount3++;
                                                var clone = "<tr id='addmoreFile" + tempCount3 + "' style='clear:both;'>"
                                                        //                                                        + "<td id='policyId" + tempCount3 + "'><input type='text' class='form-control' name='srNo" + tempCount3 + "' value='" + tempCount3 + "' readonly></td>"
                                                        //                                                            + "<td><input type =\"text\" class=\"form-control\" placeholder=\"description\" name=\"description" + "\" id=\"description" + tempCount3 + "\"></td>"

                                                        //                                                                                    + "<td id='attachment1" + tempCount3 + "'><input type='file' class='form-control' name='attachment" + "' required></td>"

                                                        + "<td><input type =\"text\" class=\"form-control\" placeholder=\"Document Name\" name=\"attach" + "" + "\" id=\"attachment" + tempCount3 + "\"></td>"
                                                        + "<td><select type=\"text\" class=\"form-control\" placeholder=\"Description\" name=\"descriptions" + "" + "\" id=\"description" + tempCount3 + "\">"
                                                        + "<option value=\"\" disabled selected>--SELECT--</option>"
                                                        + "<option value=\"yes\">Yes</option>"
                                                        + "<option value=\"no\">No</option>"
                                                        + "</select></td>"

                                                        //                                                            + "<td><input type =\"text\" class=\"form-control\" placeholder=\"remark\" name=\"remark" + "\" id=\"remark" + tempCount3 + "\"></td>"


                                                        + "<td >"
                                                        + "<span style='margin-top: 5px;'>"
                                                        + "  &nbsp;&nbsp;&nbsp;" + "<input type=\"button\"value=\"-\" style='width: 20px; margin-top: -8px; border: 1px solid black;'   onclick=\"removePolicy('addmoreFile" + tempCount3 + "');\"/>"
                                                        + "</span>"
                                                        + "</td>" + "</tr>";
                                                $("#policyTable").append(clone);
                                                document.getElementById('policyCount').value = tempCount3;
                                            });
                                        });
                                        function removePolicy(policyDiv) {
                                            try {
                                                var element1 = document.getElementById(policyDiv);
                                                element1.parentNode.removeChild(element1);
                                                // Update the serial numbers
                                                updateSerialNumbers();
                                                // Update policyCount
                                                var policyCount = document.getElementById('policyTable').rows.length - 1; // subtract 1 for header row
                                                document.getElementById('policyCount').value = policyCount;
                                            } catch (e) {
                                                console.log(e);
                                            }
                                        }



                                    </script>












                                    <div class="form-group text-center">
                                        <div class="col-sm-3 col-sm-offset-4">
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>
