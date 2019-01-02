<%-- 
    Document   : KaizenApproval
    Created on : Apr 21, 2018, 9:37:56 AM
    Author     : Aman
--%>

<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
<head>
    <title>Kaizen List</title>
</head>
<script>
    function viewClick(id) {
        window.location = 'kaizen.htm?act=viewKaizenApproval&id=' + id;
    }
    function viewApprove(id) {
        window.location = 'kaizen.htm?act=viewApproveKaizenSumbit&id=' + id;
    }
</script>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <c:if test="${!empty successMessage}">
        <div class="alert alert-info" role="alert">${successMessage}</div>
    </c:if>
    <section class="content-header">
        <h1>KAIZEN LIST</h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Kaizen List</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="nav-tabs-custom">
                    <div class="tab-content">
                        <div class="box-body no-padding">
                            <div class="row">
                                <div class="col-md-12 col-sm-12">
                                    <div class="table table-bordered">
                                        <table id="table" class="table table-bordered table-striped table-hover" style="" align="center"  >

                                            <c:choose>
                                                <c:when test="${empty list}">
                                                    <tr>
                                                        <td align="Center">There Is No Any Record</td>
                                                    </tr>
                                                </c:when>
                                                <c:otherwise>
                                                    <thead>

                                                        <tr>
                                                            <!--<th style="width: 1px; text-align: center" ><input type="checkbox" id="toggleId" align="Center" ></th>-->
                                                            <th style="width: 50px;">Sr.No</th>
                                                            <th style="width: 50px;">Team Name</th>
                                                            <th style="width: 50px;">Department Name</th>
                                                            <th style="width: 50px;">status</th>
                                                            <th style="width: 50px;">Action</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach  var="list1" items="${list}">
                                                            <tr>
                                                                <!--                                                                <td align="Center">
                                                                                                                                    <input type="checkbox" name="checkId" id="checkId" value="${list[0]}">
                                                                                                                                </td>-->
                                                                <td>${list1[1]}</td>
                                                                <td>${list1[2]}</td>
                                                                <td>${list1[3]}</td>
                                                                <c:if test="${list1[8] eq 0}"><td><span class="badge">Pending</span></td></c:if>
                                                                <c:if test="${list1[8] eq 1}"><td><span class="badge">Approved</span></td></c:if>
                                                                <c:if test="${list1[8] eq 2 || list1[8] eq 22 }"><td><span class="badge">Recycled</span></td></c:if>
                                                                <c:if test="${list1[8] eq 3}"><td><span class="label label-danger">Rejected</span></td></c:if>
                                                                <%--<c:if test="${list1[8] eq 4 && list1[8] eq list1[5]}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list1[8] eq 4 && list1[4] ne list1[5]}"><td><span class="label label-success">Approved</span></td></c:if>--%>
                                                                <%--<c:if test="${list1[8] eq 5}"><td><span class="label label-success">Final Approved</span></td></c:if>--%>
                                                                <%--<c:if test="${list1[8] eq 10}"><td><span class="label label-default">OnHold</span></td></c:if>--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewClick(${list1[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>
                                                                    <%--<c:if test="${list1[3] eq 0 || list1[8] eq 2 && list1[8] eq list1[8] || list1[8] eq 10 }">--%>
                                                                    <c:if test="${list1[8] eq 0 || list1[8] eq 22}">
                                                                        <div class="btn-group">
                                                                            <button type="button" onclick="viewApprove(${list1[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;Approve
                                                                            </button>
                                                                        </div>
                                                                    </c:if>
                                                                    <%--<c:if test="${list1[8] eq 4 && list1[8] eq list1[8] }">--%>
                                                                        <!--<div class="btn-group">-->
                                                                            <!--<button type="button" onclick="viewApprove(${list1[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">-->
                                                                                <!--&nbsp;&nbsp;Approve-->
                                                                            <!--</button>-->
                                                                        <!--</div>-->
                                                                    <%--</c:if>--%>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </c:otherwise>
                                            </c:choose>
                                        </table>
                                    </div>
                                </div> 
                            </div>  
                        </div>
                    </div>  
                </div>  
            </div> 
        </div>
    </section>

    <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
    <!-- /.content -->
</div>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
