<%--
    Document   : SessionCheck
    Created on : Oct 6, 2015, 12:22:36 PM
    Author     : Pankaj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="StorageYard/JS/bootstrap/jquery.titlealert.js"></script>
<script>
    var minute = 2;
    var second = 0;
    var flag, flag2;
    var data;
    function isodatetime() {

        if (0 === second) {
            minute -= 1;
            second = 60;
        }
        second -= 1;
        if (flag2) {
            document.getElementById("displayTime").innerHTML = minute + " : " + second;
        }
        if (0 === second && 0 === minute) {
            $.post("logOut.htm?act=checkSession",
                    {
                        flag: "false"
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    window.location = 'logOut.htm?act=sessionExp';
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
            flag = false;
        }
        if (flag) {
            window.setTimeout("isodatetime();", (1000));
        } else {
            minute = 2;
            second = 0;
            init();
        }
    }
    function init() {
        flag = flag2 = true;
        window.setTimeout("abc();", (1000 * 60 * 13));
    }
    function abc() {
        $.titleAlert("Session expires too early", {
            requireBlur: true,
            stopOnFocus: true,
            interval: 500
        });

        $('#mySessionTimeOutModal').modal('show');
        isodatetime();
    }
    $(function () {
        $("#close").click(function () {
            flag2 = false;
        });
        $("#continue").click(function () {
            $.post("logOut.htm?act=checkSession",
                    {
                        flag: "true"
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    flag = false;
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        });
    });
    window.onload = init;

</script>




<!-- Button trigger modal -->
<!--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Launch demo modal
</button>-->

<!-- Modal -->
<div class="modal fade" id="mySessionTimeOutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">Session Expiry Alert</h4>
            </div>
            <div class="modal-body">
                <div style="padding: 20px;">Your session will expire after <span id="displayTime"></span>.</div>
            </div>
            <div class="modal-footer">
                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button id="continue" type="button" class="btn btn-primary" data-dismiss="modal">Continue</button>
            </div>
        </div>
    </div>
</div>
