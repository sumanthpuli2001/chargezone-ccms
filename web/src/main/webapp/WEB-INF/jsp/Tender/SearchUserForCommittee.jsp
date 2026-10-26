<%-- 
    Document   : SearchUserForCommittee
    Created on : 25 Aug, 2022, 1:18:13 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
 //           window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
 
 
            var bid_type = document.form.bid_type.value;
            
            if(bid_type === '3')
            {
                window.opener.showuser2('1');
            }
            if(bid_type === '2')
            {
                //alert(bid_type);
                window.opener.showuser3('1');
            }
            window.opener.showuser4('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>User Information</h1>
            
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="tenderMaster.htm?act=searchUserForCommitteeSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                        name="form"   class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <input type="hidden" name="bid_type" id="bid_type" value="${bid_type}">
<!--                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">User Id :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="user_id" name="user_id"  >
                                        </div>
                                    </div>-->
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Employee Full Name :</label>
                                        </div>
<!--                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="full_name" name="full_name"  >
                                        </div>-->
                                        <div class="col-sm-3">
                                               <select id="userList1"  name="userList1"   class="form-control">
                                                    <option value="">--SELECT--</option>
                                                    <c:forEach var="list" items="${list}" varStatus = "status">
                                                        <option value="${list.id}">${list.approvalName}</option>
                                                    </c:forEach>
                                                </select>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5 text-center">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="Add" formaction="tenderMaster.htm?act=searchUserForCommitteeList">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty tenderCommittee1}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                   
                                                                    <th>User Name</th>
                                                                    <th>Full Name</th>
                                                                    
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="tenderCommittee1" items="${tenderCommittee1}" varStatus="status">
                                                                    <tr>
                                                                   
                                                                        <td>${tenderCommittee1.userId}</td>
                                                                         <td>${tenderCommittee1.fullName}</td>
                                                                         
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
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
    <script>
        function Validate() {
            var pass = $('#password').val();
            var pass1 = $('#password1').val();
            if (pass != pass1) {
                alert('Password not match');
                return false;
            }
            return true;
        }
    </script>

</html>
