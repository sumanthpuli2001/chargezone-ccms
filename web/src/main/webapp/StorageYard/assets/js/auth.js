$(document).ready(function () {
    // SweetAlert Demo On Login Form
    $('#loginForm').on('submit', function (e) {
        e.preventDefault();
        window.location.href = 'dashboard.html';
    });

    // SweetAlert Demo On Forgot Password Form
    $('#forgotPasswordForm').on('submit', function (e) {
       

        Swal.fire({
            title: "Verification Link Sent!",
            text: "A reset password link has been sent successfully to abcxxx@gmail.com. Please check your email for instructions to reset your password.",
            icon: "success",
        });
    });

    // SweetAlert Demo On Forgot Username Form
    $('#forgotUsernameForm').on('submit', function (e) {
//        e.preventDefault();

        Swal.fire({
            title: "Account details Sent!",
            text: "We have sent you an email to you with your Username and Password.",
            icon: "success",
        });
    });

    // SweetAlert Demo On Forgot Password Form
    $('#unlockUserForm').on('submit', function (e) {
        e.preventDefault();

        Swal.fire({
            title: "We received your request!",
            text: "We will notify you once your account will be unlocked.",
            icon: "success",
        });
    });


});
