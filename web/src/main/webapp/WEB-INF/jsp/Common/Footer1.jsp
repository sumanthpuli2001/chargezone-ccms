<%--
    Document   : footer
    Created on : 21/05/2021
    Author     : chetan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

</div>
<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
<!--<script src="StorageYard/Plugins/jQuery/jQuery-2.1.4.min.js"></script>-->
<!--============= Move On Last in this Page ===========================-->
<!--<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>-->
<!--============= Move On Last in this Page =================================-->
<script src="StorageYard/Plugins/jQueryUI/jquery-ui.min.js"></script>
<script src="StorageYard/Plugins/fastclick/fastclick.min.js"></script>
<script src="StorageYard/JS/bootstrap/app.min.js"></script>
<script src="StorageYard/Plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="StorageYard/Plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="StorageYard/Plugins/chartjs/Chart.min.js"></script>
<script src="StorageYard/Plugins/daterangepicker/moment.min.js"></script>
<script src="StorageYard/Plugins/fullcalendar/fullcalendar.min.js"></script>
<script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
<script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="StorageYard/JS/JQuery/common.js"></script>
<script src="StorageYard/JS/bootstrap/jquery.tokeninput.js"></script>
<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>


<script>
    var bar_chart_options = {
        scaleGridLineColor: "rgba(0,0,0,.05)",
        responsive: true
    };
    var barChartData = {
        labels: ["Active", "Recycled", "Rejected", "Inprocess", "Invites", "Direct Request"],
        datasets: [
            {
                fillColor: "#34B8E8",
                strokeColor: "#49A7E5",
                highlightFill: "rgba(31,186,242,0.7)",
                highlightStroke: "rgba(18,177,234,0.7)",
                data: [85, 16, 18, 45, 29, 36]
            }
        ]
    }
    var scorebarchartData = {
        labels: ["Auditor 1", "Auditor 2", "Auditor 3"],
        datasets: [
            {
                fillColor: "#00A65A",
                strokeColor: "#00914D",
                highlightFill: "rgba(0,166,90,0.8)",
                highlightStroke: "rgba(0,145,77,0.8)",
                data: [15, 02, 05]
            },
            {
                fillColor: "#F39C12",
                strokeColor: "#E28E0F",
                highlightFill: "rgba(243,156,18,0.8)",
                highlightStroke: "rgba(226,142,15,0.8)",
                data: [08, 11, 10]
            },
            {
                fillColor: "#F56954",
                strokeColor: "#E25C4A",
                highlightFill: "rgba(245,105,84,0.8)",
                highlightStroke: "rgba(226,92,74,0.8)",
                data: [04, 01, 18]
            }
        ]
    }

    var pieData = [{
            value: 0,
            color: "#dd4b39",
            highlight: "#dd4b39",
            label: "January"
        }, {
            value: 4,
            color: "#f39c12",
            highlight: "#f39c12",
            label: "February"
        }, {
            value: 4,
            color: "#00c0ef",
            highlight: "#00c0ef",
            label: "March"
        }, {
            value: 3,
            color: "#0073b7",
            highlight: "#0073b7",
            label: "April"
        }, {
            value: 0,
            color: "#111111",
            highlight: "#111111",
            label: "May"
        }, {
            value: 0,
            color: "#00a65a",
            highlight: "#00a65a",
            label: "June"
        }, {
            value: 0,
            color: "#d2d6de",
            highlight: "#d2d6de",
            label: "July"
        }, {
            value: 0,
            color: "#d81b60",
            highlight: "#d81b60",
            label: "August"
        }, {
            value: 1,
            color: "#39cccc",
            highlight: "#39cccc",
            label: "September"
        }, {
            value: 4,
            color: "#605ca8",
            highlight: "#605ca8",
            label: "October"
        }, {
            value: 2,
            color: "#01ff70",
            highlight: "#01ff70",
            label: "November"
        }, {
            value: 3,
            color: "#ff851b",
            highlight: "#ff851b",
            label: "December"
        }];

    window.onload = function () {
        var ctx = document.getElementById("barchart").getContext("2d");
        var bar1 = new Chart(ctx).Bar(barChartData, bar_chart_options);

        var ctx2 = document.getElementById("scorebarchart").getContext("2d");
        var bar2 = new Chart(ctx2).Bar(scorebarchartData, bar_chart_options);

        var ctx1 = document.getElementById("chart-area1").getContext("2d");
        var piechart = new Chart(ctx1).Pie(pieData);

        $('#tab1').on('shown.bs.tab', function (e) {
            bar2.destroy();
            bar1 = new Chart(ctx).Bar(barChartData, bar_chart_options);
        });

        $('#tab2').on('shown.bs.tab', function (e) {
            bar1.destroy();
            bar2 = new Chart(ctx2).Bar(scorebarchartData, bar_chart_options);
            piechart = new Chart(ctx1).Pie(pieData);
            $(function () {

                /* initialize the calendar
                 -----------------------------------------------------------------*/
                //Date for the calendar events (dummy data)
                var date = new Date();
                var d = date.getDate(),
                        m = date.getMonth(),
                        y = date.getFullYear();
                $('#calendar').fullCalendar({
                    header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay'
                    },
                    buttonText: {
                        today: 'today',
                        month: 'month',
                        week: 'week',
                        day: 'day'
                    },
                    //Random default events
                    events: [
                        {
                            title: 'Available',
                            start: new Date(y, m, 17, 12),
                            backgroundColor: "#FF5C00", //Orange
                            borderColor: "#FF5C00" //Orange
                        },
                        {
                            title: 'Available',
                            start: new Date(y, m, 19, 06),
                            backgroundColor: "#00CCFF", //Blue
                            borderColor: "#00CCFF" //Blue
                        },
                        {
                            title: 'Available',
                            start: new Date(y, m, 26, 18),
                            backgroundColor: "#4DD100", //Green
                            borderColor: "#4DD100" //Green
                        },
                    ],
                    editable: true,
                    droppable: true, // this allows things to be dropped onto the calendar !!!
                    drop: function (date, allDay) { // this function is called when something is dropped

                        // retrieve the dropped element's stored Event Object
                        var originalEventObject = $(this).data('eventObject');

                        // we need to copy it, so that multiple events don't have a reference to the same object
                        var copiedEventObject = $.extend({}, originalEventObject);

                        // assign it the date that was reported
                        copiedEventObject.start = date;
                        copiedEventObject.allDay = allDay;
                        copiedEventObject.backgroundColor = $(this).css("background-color");
                        copiedEventObject.borderColor = $(this).css("border-color");

                        // render the event on the calendar
                        // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                        $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

                        // is the "remove after drop" checkbox checked?
                        if ($('#drop-remove').is(':checked')) {
                            // if so, remove the element from the "Draggable Events" list
                            $(this).remove();
                        }

                    }
                });

                /* ADDING EVENTS */
                var currColor = "#3c8dbc"; //Red by default
                //Color chooser button
                var colorChooser = $("#color-chooser-btn");
                $("#color-chooser > li > a").click(function (e) {
                    e.preventDefault();
                    //Save color
                    currColor = $(this).css("color");
                    //Add color effect to button
                    $('#add-new-event').css({"background-color": currColor, "border-color": currColor});
                });
                $("#add-new-event").click(function (e) {
                    e.preventDefault();
                    //Get value and make sure it is not null
                    var val = $("#new-event").val();
                    if (val.length == 0) {
                        return;
                    }

                    //Create events
                    var event = $("<div />");
                    event.css({"background-color": currColor, "border-color": currColor, "color": "#fff"}).addClass("external-event");
                    event.html(val);
                    $('#external-events').prepend(event);

                    //Add draggable funtionality
                    ini_events(event);

                    //Remove event from text input
                    $("#new-event").val("");
                });
            });
        });
    }
</script>
<div class="footer-copyright-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer-copy-right">
                        <br>© 2023 <a href=href="http://www.bulwarks.com/" target="_blank"><strong>Bulwark Systems</strong></a> All rights reserved.
                    </div>
                </div>
            </div>
        </div>
    </div>
<!--<label style="font-weight: normal;float: right;"> © 2019 <a href="http://www.gipcl.com/" target="_blank"><strong>GIPCL</strong></a> All rights reserved. </label>-->
<script>
//==============================================================//
//set time out for errorDiv Class
    window.setTimeout(function () {
        $(".errorDiv").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 8000);
//============================================================//
</script>
</body>
</html>
