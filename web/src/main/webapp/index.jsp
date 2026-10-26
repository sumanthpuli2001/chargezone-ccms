 <div id="exTab" class="container" style="width: 100%;">
                    <ul class="nav nav-pills nav-tabs" style="display: flex; justify-content: space-between; align-items: center;">
                        <li class="active">
                            <a href="dashboard.htm?act=tenderDashboard">
                                <i class="fa fa-circle-o"></i>Dashboard
                            </a>
                        </li>

                        <li>
                            <a href="dashboard.htm?act=report">
                                <i class="fa fa-circle-o"></i>PR Register
                            </a>
                        </li>

                        <li class="search-container" style="margin-left: auto; display: flex; align-items: center;">

                            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#searchModal">
                                <i class="fa fa-filter" style="margin-right: 5px;"></i> Filter
                            </button>
                        </li>
                    </ul>
                </div>
                <!-- Bootstrap 3 Modal -->
                <div id="searchModal" class="modal fade" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal-sm" role="document" style="margin-top: 100px;">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title">Search</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row">

                                    <div class="col-xs-12">
                                        <label>From Date :</label>
                                        <input autocomplete="off" name="Fromdate" id="fromDate" type="text" class="form-control" />
                                    </div>

                                    <div class="col-xs-12" style="margin-top: 10px;">
                                        <label>To Date :</label>
                                        <input autocomplete="off" name="Todate" id="toDate" type="text" class="form-control" />
                                    </div>

                                    <script>
                                        var fromDatePicker = new Pikaday({
                                            field: document.getElementById('fromDate'),
                                            format: 'DD-MM-YYYY', // Specify the format you need
                                            onSelect: function (date) {
                                                console.log(this.getMoment().format('DD-MM-YYYY'));  // Optional: Log the selected date in your format
                                            }
                                        });

                                        var toDatePicker = new Pikaday({
                                            field: document.getElementById('toDate'),
                                            format: 'DD-MM-YYYY', // Same format for 'To Date'
                                            onSelect: function (date) {
                                                console.log(this.getMoment().format('DD-MM-YYYY'));  // Optional: Log the selected date in your format
                                            }
                                        });
                                    </script>

                                </div>

                                <!-- Dropdowns for Filter By and Department -->
                                <div class="row" style="margin-top: 10px;">
                                    <div class="col-sm-12">
                                        <label for="date-filter">Filter By:</label>
                                        <select id="date-filter" name="Filter" class="form-control">
                                            <option value="--select--">--SELECT--</option>
                                            <option value="last-week">Last-1-Week</option>
                                            <option value="last-month">Last-1-Month</option>
                                            <option value="last-6-month">Last-6-Month</option>
                                            <option value="last-year">Last-1-Year</option>
                                        </select>
                                    </div>

                                    <div class="col-sm-12" style="margin-top: 10px;">
                                        <label for="date-Department">Department:</label>
                                        <select id="date-Department" name="Department" class="form-control">
                                            <option value="--select--">--SELECT--</option>
                                            <c:forEach var="list" items="${list0}">
                                                <option value="${list.departmentName}">${list.departmentName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary" name="btn" value="1">Apply</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
