$(document).ready(function () {

    if ($('select').length > 0) {
        $('select').selectpicker();
    }

    $('[data-toggle="tooltip"]').tooltip();

    // Sidebar Dropdown toggle
    $('li.has-children > a.nav-link').on('click', function (e) {
        e.preventDefault();
        let $dropdown = $(this).next('.drop-down');
        let $parent = $(this).parent();

        if ($parent.hasClass('open')) {
            $parent.removeClass('open');
            $dropdown.slideUp(250);
        } else {
            // Close other open dropdowns (optional)
            $('li.has-children').removeClass('open').find('.drop-down').slideUp(300);

            $parent.addClass('open');
            $dropdown.slideDown(250);
        }
    });

    // Sidebar toggle
    $('.toggle-sidebar').on('click', function () {
        $('.main-content').toggleClass('expanded');
        $('.sidebar').toggleClass('collapsed');
    });
})
