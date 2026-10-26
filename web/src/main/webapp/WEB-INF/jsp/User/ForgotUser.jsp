<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Username</title>

    <!-- Favicon -->
    <link rel="apple-touch-icon" sizes="57x57" href="StorageYard/assets/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="StorageYard/assets/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="StorageYard/assets/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="StorageYard/assets/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="StorageYard/assets/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="StorageYard/assets/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="StorageYard/assets/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="StorageYard/assets/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="StorageYard/assets/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="StorageYard/assets/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="StorageYard/assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="StorageYard/assets/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="StorageYard/assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="StorageYard/assets/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="StorageYard/assets/favicon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- CSS Libraries -->
    <link rel="stylesheet" href="StorageYard/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/all.min.css">
    <link rel="stylesheet" href="StorageYard/assets/css/sweetalert2.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" href="StorageYard/assets/css/auth.css">
</head>

<body>
    <!-- Page Content -->
    <div class="login-wrapper d-flex justify-content-center align-items-center overflow-hidden">
        <div class="container">
            <div class="auth-inner position-relative mx-auto">
                <form class="position-relative row mx-0" id="forgotUsernameForm" action="out.html?act=checkUsername" method="POST">
                    <div class="col-lg-5 p-4 card-white">
                        <img src="StorageYard/Images/logo.png" alt="Company Logo">
                    </div>

                    <div class="col-lg-7 p-md-4 p-3">
                        <div class="form-content">
                            <h3 class="mb-4 fw-bolder text-lg-start text-center mt-auto">Forgot Username</h3>

                            <div class="form-group mb-3">
                                <label for="mobileNo">Mobile Number</label>
                                <input type="tel" name="mobileNo" id="mobileNo" class="form-control"
                                    autocomplete="off" placeholder="Enter mobile number">
                            </div>

                            <p class="text-center mb-2 small">- Or -</p>

                            <div class="form-group mb-3">
                                <label for="emailId">Email</label>
                                <input type="email" name="emailId" id="emailId" class="form-control"
                                   autocomplete="off"  placeholder="Enter email">
                            </div>

                            <div class="form-group mb-5 pt-2">
                                <button type="submit"
                                    class="btn theme-btn d-flex align-items-center justify-content-center w-100">
                                    <img src="StorageYard/assets/images/arrow-right-to-arc.svg" class="form-btn-icon mr-2"
                                        onload="SVGInject(this)" alt="Icon"> Submit
                                </button>
                            </div>

                            <div class="text-end d-flex align-items-center justify-content-between py-1 mt-auto">
                                <a href="logIn.html?act=firstStep" class="form-link"><i class="fa-solid fa-angle-left"></i> Back to
                                    Login</a>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
    <!-- Page Content -->

    <!-- JS Libraries -->
    <script src="StorageYard/assets/js/jquery-3.7.1.min.js"></script>
    <script src="StorageYard/assets/js/bootstrap.bundle.min.js"></script>
    <script src="StorageYard/assets/js/sweetalert2.all.min.js"></script>
    <script src="StorageYard/assets/js/auth.js"></script>
</body>

</html>