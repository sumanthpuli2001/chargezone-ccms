<%--
    Document   : NavbarCmss	
    Created on : 25-May-2020, 14:40:47	
    Author     : Aman Bahukhandi 	
--%>

<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
    <section class="sidebar">
        <ul class="side-nav list-unstyled">
            <c:if test="${fn:contains(sessionScope.v_flag,'1')}">
                <li class="side-nav-item mb-2">
                    <a href="vendor.htm?act=liveTender" class="nav-link">	
                        <i class="fa fa-shield-alt mr-3"></i>
                        Live Tender
                    </a>
                </li>
            </c:if>

<!--            <li class="side-nav-item mb-2">
                <a href="vendor.htm?act=liveTender" class="nav-link">	
                    <i class="fa fa-shield-alt mr-3"></i>
                    Live Tender
                </a>
            </li>-->

            <c:if test="${sessionScope.status!=20}">
                <li class="side-nav-item mb-2">	
                    <a href="vendorInformation.htm?act=vendorpolicy&id=${sessionScope.codString}" class="nav-link">	
                        <i class="fa fa-home fa-lg mr-3"></i>Vendor Information
                    </a>	
                </li>
            </c:if>

            <c:if test="${fn:contains(sessionScope.v_flag,'1')}">
                <li class="side-nav-item mb-2">
                    <a href="vendor.htm?act=acceptanceTender" class="nav-link">	
                        <i class="fa fa-home fa-lg mr-3"></i>Tender Acceptance
                    </a>	
                </li>

                <li class="side-nav-item mb-2">
                    <a href="vendor.htm?act=closeTender" class="nav-link">	
                        <i class="fa fa-home fa-lg mr-3"></i>Close Tender
                    </a>
                </li>
                <li class="side-nav-item mb-2">
                    <a href="poDetails.htm?act=poDetails" class="nav-link">	
                        <i class="fa fa-home fa-lg mr-3"></i>PO Details
                    </a>
                </li>
            </c:if>

            <li class="side-nav-item mb-2">
                <a href="vendorInformation.htm?act=vendorHelpFile" class="nav-link">
                    <i class="fa fa-file mr-3"></i>Vendor Help File
                </a>	
            </li>

            <li class="side-nav-item mb-2">
                <a href="userMaster.htm?act=passwordChangeV" class="nav-link">
                    <i class="fa fa-key mr-3"></i>Change Password
                </a>	
            </li>

            <li class="side-nav-item mb-2">
                <a href="logOut.htm?act=logout" class="nav-link">
                    <i class="fa fa-key mr-3"></i>Log Out
                </a>	
            </li>

        </ul>
    </section>
</html>