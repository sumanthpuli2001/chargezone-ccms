<%-- 
    Document   : RightEdit
    Editd on : 24-Jun-2020, 23:47:46
    Author     : Aman Bahukhandi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Right</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Right</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Right</li>
            </ol>
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
                                <form:form action="right.htm?act=editSubmit" method="post" commandName="rightMaster"
                                           class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Right Name :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="rightName" readonly="true"  class="form-control"   required="required"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">User Right :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[0],'R')}">
                                                        <input type="checkbox" name="u" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="u" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[0],'W')}">
                                                        <input type="checkbox" name="u" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="u" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[0],'U')}">
                                                        <input type="checkbox" name="u" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="u" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[0],'D')}">
                                                        <input type="checkbox" name="u" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="u" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Employee Rights ${wright[1]} :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[1],'R')}">
                                                        <input type="checkbox" name="e" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="e" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[1],'W')}">
                                                        <input type="checkbox" name="e" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="e" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[1],'U')}">
                                                        <input type="checkbox" name="e" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="e" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[1],'D')}">
                                                        <input type="checkbox" name="e" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="e" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Contractor Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[2],'R')}">
                                                        <input type="checkbox" name="cn" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="cn" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[2],'W')}">
                                                        <input type="checkbox" name="cn" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="cn" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[2],'U')}">
                                                        <input type="checkbox" name="cn" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="cn" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[2],'D')}">
                                                        <input type="checkbox" name="cn" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="cn" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Apprentice Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[3],'R')}">
                                                        <input type="checkbox" name="a" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="a" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[3],'W')}">
                                                        <input type="checkbox" name="a" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="a" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[3],'U')}">
                                                        <input type="checkbox" name="a" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="a" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[3],'D')}">
                                                        <input type="checkbox" name="a" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="a" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Coupon Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[4],'R')}">
                                                        <input type="checkbox" name="co" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="co" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[4],'W')}">
                                                        <input type="checkbox" name="co" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="co" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[4],'U')}">
                                                        <input type="checkbox" name="co" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="co" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[4],'D')}">
                                                        <input type="checkbox" name="co" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="co" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Card Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[5],'R')}">
                                                        <input type="checkbox" name="ca" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="ca" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[5],'W')}">
                                                        <input type="checkbox" name="ca" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="ca" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[5],'U')}">
                                                        <input type="checkbox" name="ca" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="ca" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[5],'D')}">
                                                        <input type="checkbox" name="ca" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="ca" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Wright Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[6],'R')}">
                                                        <input type="checkbox" name="w" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="w" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[6],'W')}">
                                                        <input type="checkbox" name="w" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="w" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[6],'U')}">
                                                        <input type="checkbox" name="w" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="w" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[6],'D')}">
                                                        <input type="checkbox" name="w" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="w" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Report Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[7],'R')}">
                                                        <input type="checkbox" name="rp" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="rp" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[7],'W')}">
                                                        <input type="checkbox" name="rp" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="rp" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Logs Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[8],'R')}">
                                                        <input type="checkbox" name="l" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="l" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read      </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Recharge Rights :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[9],'R')}">
                                                        <input type="checkbox" name="rc" checked="checked" value="R" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="rc" value="R" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Read  </label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[9],'W')}">
                                                        <input type="checkbox" name="rc" checked="checked" value="W" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="rc" value="W" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Write</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[9],'U')}">
                                                        <input type="checkbox" name="rc" checked="checked" value="U" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="rc" value="U" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Update</label>
                                            <label>
                                                <c:choose>
                                                    <c:when test="${fn:contains(wright[9],'D')}">
                                                        <input type="checkbox" name="rc" checked="checked" value="D" />
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="checkbox" name="rc" value="D" />
                                                    </c:otherwise>
                                                </c:choose>
                                                Delete</label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()" title="" value="SUBMIT">
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
