<%-- 
    Document   : HeaderNewPrint
    Created on : Feb 9, 2026, 10:45:21 AM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="StorageYard/assets/js/svg-inject.min.js"></script>
<!-- SVG Inject -->
<script src="StorageYard/assets/js/svg-inject.min.js"></script>
<header class="d-print-none">
<style>
    @media print {
    @page {
        margin: 0;
    }

    body {
        margin: 0;
        padding: 0;
    }
}
@media print {
    .no-print {
        display: none !important;
    }
}
</style>
    <nav class="navbar navbar-expand-sm bg-body-tertiary d-print-none">
        <div class="container-fluid pl-0 pr-4">
            <a class="navbar-brand" href="javascript:void(0)">
                <img src="StorageYard/assets/images/logo_1.png"  alt="Bulwarks" class="img-fluid">
            </a>

            <button class="navbar-toggler ml-auto" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav ml-auto align-items-center">
                    <li class="nav-item">
                        <a class="nav-link active d-flex align-items-center" href="#">
                            <span class="user-name mr-2">${sessionScope.user.userFullName}</span>
                            <div class="profile-img rounded-circle">
                                <img src="StorageYard/assets/images/user.png" alt="User Image">
                            </div>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link theme-btn light-btn rounded-2" href="logOut.htm?act=logout">
                            <i class="fa-solid fa-arrow-right-from-bracket"></i>
                            Sign Out
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

</html>

