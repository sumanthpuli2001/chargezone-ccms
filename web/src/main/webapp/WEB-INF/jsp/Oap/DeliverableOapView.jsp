

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deliverable OAP View</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">

            <div style="display: flex; height: 25px;
                 justify-content: space-between;
                 align-items: center;">
                <h3 style="margin-top: 1px;">Deliverable OAP View</h3>
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
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action=".htm?act=" method="post" commandName=""
                                           class="form-horizontal" role="form">


                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Date<span style="color: red;font-size: 10px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input class="form-control" value="${list10.date}"  readonly />
                                        </div>
                                    </div> 
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Description<span style="color: red;font-size: 10px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <textarea style="width: 100%; " disabled>${list10.description}</textarea>
                                        </div>
                                    </div>


                                    <table  class="table table-bordered mb-4" style="max-width: 95%; margin: auto; border: 1px solid black; border-collapse: collapse;"> <!-- Set maximum width and border -->

                                        <thead>
                                            <tr>
                                                <th style="border: 1px solid black; text-align: left;">Description</th>
                                                <th style="border: 1px solid black; text-align: left;">Design Co- Ordinater</th>
                                               
                                            </tr>
                                        </thead>


                                        <c:forEach var="list11" items="${list11}">
                                            <tr>
                                                <td style="border: 1px solid black;"><span>${list11.description}</span>
                                                </td> 
                                                <td style="border: 1px solid black;"><span>${list11.designCoordinator}</span>
                                                </td> 

                                               
                                            </tr>
                                        </c:forEach>



                                    </table> 







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
