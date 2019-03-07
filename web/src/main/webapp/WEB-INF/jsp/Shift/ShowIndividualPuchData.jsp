<%-- 
    Document   : ShowIndividualPuchData
    Created on : Feb 23, 2016, 10:33:16 AM
    Author     : Dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
<script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
  <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Wise Punch Records</title>
    </head>
    <body>
            <section class="content-header">
                <h1>Date Wise Punch Records: </h1>
            </section>
            
                  <form:form class="form-horizontal" role="form" action="" commandName=""  method="post" name='form'>
  
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty punchList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr>
                                                                        <th >Date and time</th>
                                                                        <th>Location</th>
                                                                       
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${punchList}">
                                                            <tr>
                                                                <td>${list}</td>

                                                            </tr>
                                                            </c:forEach>
                                                             </tbody>
                                                    </table>
                                                </div>


                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

            </form:form>
    </body>
</html>

