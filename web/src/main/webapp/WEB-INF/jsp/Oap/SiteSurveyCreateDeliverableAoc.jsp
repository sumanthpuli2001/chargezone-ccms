
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Site Survey Create</title>
    </head>
      <script>
        function initDocTable(selector, obj = {}) {
            return $(selector).DataTable({
                paging: false,
                lengthChange: false,
                searching: false,
                info: false,
                autoWidth: true,
                ordering: false,
                scrollX: false,
                ...obj,
            });
        }
    </script>
    <body>

        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                <form:form action="oapForm.htm?act=SiteSurveyCreateDeliverableAocsubmit" method="post" commandName=""
                           class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Site Survey Create</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back()" class="btn theme-btn light-btn mr-3">Back</a>
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>

                    <hr>
                    <input type="hidden" id="id" name="id" value="${id}">           

                    <h6>AOC Form Details</h6>
                    <div class="rounded-4 mt-4"> 
                        <div class="card-box rounded-3 mb-4 pt-4 pb-2">
                            <div class="row buyer-info">
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Document Number</label>
                                        <p class="fw-600">${aocForm.documentNo}</p>

                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Depo.Name</label>
                                        <p class="fw-600">${aocForm.hubDepoName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-8 pb-1">
                                    <div class="form-group">
                                        <label>Project Name</label>
                                        <p class="fw-600">${aocForm.clientProjectName}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Created By</label>
                                        <p class="fw-600">${aocForm.userId}</p>
                                    </div>
                                </div>
                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Client Name</label>
                                        <p class="fw-600">${aocForm.mobileNo}</p>
                                    </div>
                                </div>

                                <div class="col-xxl-2 col-lg-3 col-md-4 pb-1">
                                    <div class="form-group">
                                        <label>Date</label>
                                        <p class="fw-600">${aocForm.createdDate}</p>
                                    </div>
                                </div>  


                            </div>
                        </div>  
                    </div>  

                                    <table id="policyTable"   class="table table-striped bg-white dt-scroll" style="max-width: 100%" align="Center">
                                                <thead>
                                                    <tr>

                                                        <th >Survey No</th>
                                                        <th>Project Representative</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="Table">
                                                    <tr>
                                                <input type="hidden" name="policy" id="policy" value="1"/>

                                                <td >
                                                    <input id="siteradio" name="surveyNo" placeholder="Survey No" class="input-field" type="text" required="true">
                                                </td>
                                                <td style="">
                                                    <input id="projectRepresentative" name="projectRepresentative" required="true" placeholder="Project Representative" class="input-field" type="text" required="true">
                                                </td>
                                               <td style="text-align: center" class="d-flex justify-content-center align-items-center">
                                    <div class="clone-action clone-new-field mb-2" id="Cloneids" style="cursor:pointer;">
                                        <img src="StorageYard/assets/images/clone-btn.svg" onload="SVGInject(this)" alt="Clone Btn" />
                                    </div>
                                </td> 
                                                
                                                
                                                
                                                </tr>
                                                </tbody>
                                            </table>

                               <div class="form-group">
                        <div style="display: flex;  justify-content: center;">
                            <button type="submit" class="btn theme-btn">Submit</button>
                        </div>
                    </div>     
                                    


<script>
     if ($("#policyTable").length) {
                                            const table1 = initDocTable("#policyTable");
                                        }
    
    
    
    
    
    var rowCounter = 1; // Initial row count

    $(function () {
        // Event handler for "+" button to add new rows
        $("#Cloneids").on("click", function () {
            rowCounter++; // Increment the row counter
            var newRow = "<tr id='addRow" + rowCounter + "' style='clear:both;'>"
                + "<td><input type=\"text\" class=\"input-field\" required=\"true\" placeholder=\"Survey No\" name=\"surveyNo\" id=\"surveyNo" + rowCounter + "\"></td>"
                + "<td><input type=\"text\" class=\"input-field\" required=\"true\" placeholder=\"Project Representative\" name=\"projectRepresentative\" id=\"projectRepresentative" + rowCounter + "\"></td>"
                                             + "<td class=\"d-flex justify-content-center align-items-center\">"

+ "<span style='margin-top: 5px;'>"
+ "<div class='clone-action delete-parent-field' title='Remove' style='cursor: pointer; display:inline-block;' onclick=\"removeRow('addRow" + rowCounter + "');\">"
+ "<img src='StorageYard/assets/images/clone-delete-btn.svg' onload='SVGInject(this)' alt='Remove'>"
+ "</div>"
+ "</span>"
+ "</td>"
+ "</tr>";

            $("#Table").append(newRow); // Add the new row to the table
            document.getElementById('policy').value = rowCounter; // Update the hidden input field with the row count
        });
    });

    // Function to remove a row
    function removeRow(rowId) {
        try {
            var rowToRemove = document.getElementById(rowId); // Get the row by its ID
            rowToRemove.parentNode.removeChild(rowToRemove); // Remove the row from the table
            // Update the policy count in the hidden input field
            var rowCount = document.getElementById('Table').rows.length;
            document.getElementById('policy').value = rowCount;
        } catch (e) {
            console.log(e);
        }
    }
</script>


                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
