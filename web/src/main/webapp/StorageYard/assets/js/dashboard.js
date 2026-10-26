    const filterType = document.getElementById('filter_type');
const yearFilter = document.getElementById('filter_by_year');
const monthFilter = document.getElementById('filter_by_month');

const currentYear = new Date().getFullYear();

const startYear = currentYear - 4;
const endYear = currentYear + 1;




// Populate year options
for (let year = startYear; year <= endYear; year++) {
    const option = document.createElement("option");
    option.value = year;
    option.textContent = year;

    if (year === currentYear) {
        option.selected = true;
    }

    yearFilter.appendChild(option);
}

// Toggle month filter visibility
filterType.addEventListener('change', function () {

    if (this.value === 'monthly') {
        monthFilter.parentElement.classList.remove('d-none');
        yearFilter.parentElement.classList.add('d-none');
    } else {
        monthFilter.parentElement.classList.add('d-none');
        yearFilter.parentElement.classList.remove('d-none');
    }
});

$(document).ready(function () {

    initTable('#top_ten_vendors');
    initTable('#new_vendors');

    // Common DataTable initializer
    function initTable(selector) {
        return $(selector).DataTable({
            paging: true,
            lengthChange: true,
            searching: true,
            info: true,
            autoWidth: true,
            ordering: false,
            dom: 't',
            responsive: true,
            scrollCollapse: true,
            scrollY: '250px',
            scrollX: false
        });
    }


    // Total Vendors by month Chart
    



              

    // PR Management Chart
    if ($('#prChart').length > 0) {
        const prChart = document.getElementById('prChart');
        const ctx = prChart.getContext('2d');

        // Keep chart square
        function resizeChart() {
            prChart.style.maxWidth = (prChart.parentElement.parentElement.offsetWidth * 0.6) + 'px';
            prChart.style.maxHeight = (prChart.parentElement.parentElement.offsetWidth * 0.6) + 'px';
        }
        window.addEventListener('resize', resizeChart);
        resizeChart();

        // Chart data
        const prData = {
            labels: ['Approved', 'Pending', 'Rejected', 'Draft','Deleted'],
            datasets: [{
                label: 'PR Management',
                data: [prApprovedSize,prPendingSize,prRejectedSize,prDraftSize,prDeletedSize], // your values
                backgroundColor: [
                    '#2bc899', // Approved
                    '#f4c351', // Pending
                    '#e64b40', // Rejected
                    '#cddaebff',  // Draft
                    '#00BFFF'  // Deleted
//                    '#f4a261'  // Closed
                 
                    ],
                borderWidth: 0
            }]
        };

        // Custom plugin for center text
        const centerText = {
            id: 'centerText',
            beforeDraw(chart) {
                const { width, height, ctx } = chart;
                ctx.save();
                const total = chart.data.datasets[0].data.reduce((a, b) => a + b, 0);

                ctx.font = 'bold ' + (height / 10) + 'px sans-serif'; // bold + smaller
                ctx.fillStyle = '#000';
                ctx.textAlign = 'center';
                ctx.textBaseline = 'middle';
                ctx.fillText(total, width / 2, height / 2);
                ctx.restore();
            }
        };

        // Chart config
        const config = {
            type: 'doughnut',
            data: prData,
            options: {
                cutout: '45%', // hole size
                responsive: true,
                plugins: {
                    legend: {
                        display: false // hide built-in legend
                    },
                    tooltip: {
                        callbacks: {
                            label: function (context) {
                                return `${context.label}: ${context.parsed} PR`;
                            }
                        }
                    }
                }
            },
            plugins: [centerText]
        };

        // Create chart
        new Chart(ctx, config);
    }


    // Vendors Data by Categories 
    if ($('.vendor-category-chart').length > 0) {
        const total = 1000; // example total vendors
        const categories = [100, 650, 310, 300, 120, 80, 720]; // example per-category vendors

        const chart = document.querySelector(".vendor-category-chart");
        chart.innerHTML = ""; // clear existing content

        categories.forEach((value, i) => {
            const percent = Math.round((value / total) * 100);

            // create bar element
            const bar = document.createElement("div");
            bar.className = `bar category-${i + 1} mb-3`;

            bar.innerHTML = `
            <div class="label fw-500">Category ${i + 1}</div>
            <div class="data-width rounded-1 overflow-hidden position-relative">
                <div class="status" style="width:${percent}%"></div>
                <span class="percent">${percent}%</span>
            </div>
            <div class="value fw-500 fs-15">${value}</div>
        `;

            chart.appendChild(bar);

            // handle percent label positioning
            const percentSpan = bar.querySelector(".percent");
            if (percent <= 15) {
                percentSpan.style.left = `calc(${percent}% + 10px)`;
            } else {
                percentSpan.style.left = `calc(${percent}% - 50px)`;
            }
        });
    }


    // Tenders Breakup Table Data
    if ($('#tenders_breakup').length > 0) {
        // Example backend data (replace with your API / AJAX call)
        const tenderData = [
            { tenderName: "Project Alpha", lowestBid: "₹ 100,000", vendorName: "Vendor A", currentBids: 325, totalBids: 350 },
            { tenderName: "Project Beta", lowestBid: "₹ 150,000", vendorName: "Vendor B", currentBids: 220, totalBids: 300 },
            { tenderName: "Project Gamma", lowestBid: "₹ 90,000", vendorName: "Vendor C", currentBids: 180, totalBids: 200 },
            { tenderName: "Project Delta", lowestBid: "₹ 250,000", vendorName: "Vendor D", currentBids: 400, totalBids: 500 },
            { tenderName: "Project Epsilon", lowestBid: "₹ 75,000", vendorName: "Vendor E", currentBids: 120, totalBids: 150 },
            { tenderName: "Project Zeta", lowestBid: "₹ 300,000", vendorName: "Vendor F", currentBids: 95, totalBids: 120 },
            { tenderName: "Project Eta", lowestBid: "₹ 200,000", vendorName: "Vendor G", currentBids: 280, totalBids: 320 },
            { tenderName: "Project Theta", lowestBid: "₹ 180,000", vendorName: "Vendor H", currentBids: 150, totalBids: 180 },
            { tenderName: "Project Iota", lowestBid: "₹ 400,000", vendorName: "Vendor I", currentBids: 500, totalBids: 600 },
            { tenderName: "Project Kappa", lowestBid: "₹ 50,000", vendorName: "Vendor J", currentBids: 60, totalBids: 80 }
        ];


        $('#tenders_breakup').DataTable({
            paging: true,
            lengthChange: true,
            searching: true,
            info: true,
            autoWidth: true,
            ordering: false,
            dom: 't',
            responsive: true,
            data: tenderData,   // Feed backend data here
            columns: [
                { data: "tenderName" },
                { data: "lowestBid" },
                { data: "vendorName" },
                {
                    data: null, // we will render this manually
                    render: function (data, type, row) {
                        const progress = Math.round((row.currentBids / row.totalBids) * 100);
                        return `<div class="bid-value">
                                <div class="progress-bar rounded-pill">
                                    <div class="p-bar rounded-pill" style="width:${progress}%"></div>
                                </div>
                                <div class="counts fs-13">
                                    <span class="val">${row.currentBids}</span> /
                                    <span class="total-val">${row.totalBids}</span>
                                </div>
                            </div>`;
                    }
                }
            ]
        });
    }


    // Auctions Data Chart
    if ($('#auctionChart').length > 0) {
        const auctionChart = document.getElementById('auctionChart');
        const ctx = auctionChart.getContext('2d');

        // Keep chart square
        function resizeChart() {
            auctionChart.style.maxWidth = (auctionChart.parentElement.parentElement.offsetWidth * 0.7) + 'px';
            auctionChart.style.maxHeight = (auctionChart.parentElement.parentElement.offsetWidth * 0.7) + 'px';
        }
        window.addEventListener('resize', resizeChart);
        resizeChart();

//        // Chart data
//        const auctionData = {
//            labels: ['Reverse Auctions', 'Forward Auctions'],
//            datasets: [{
//                label: 'PR Management',
//                data: [20, 80], // your values
//                backgroundColor: [
//                    '#14ac7f', // Forward Auctions
//                    '#f0b432', // Reverse Auctions
//                ],
//                borderWidth: 0
//            }]
//        };

        // Custom plugin for center text
        const centerText = {
            id: 'centerText',
            beforeDraw(chart) {
                const { width, height, ctx } = chart;
                ctx.save();
                const total = chart.data.datasets[0].data.reduce((a, b) => a + b, 0);

                ctx.font = 'bold ' + (height / 10) + 'px sans-serif'; // bold + smaller
                ctx.fillStyle = '#000';
                ctx.textAlign = 'center';
                ctx.textBaseline = 'middle';
                ctx.fillText(total, width / 2, height / 2);
                ctx.restore();
            }
        };

        // Chart config
        const config = {
            type: 'doughnut',
            data: auctionData,
            options: {
                cutout: '60%', // hole size
                responsive: true,
                plugins: {
                    legend: {
                        display: false // hide built-in legend
                    },
                    tooltip: {
                        callbacks: {
                            label: function (context) {
                                return `${context.label}: ${context.parsed} PR`;
                            }
                        }
                    }
                }
            },
            plugins: [centerText]
        };

        // Create chart
        new Chart(ctx, config);
    }


    // Total RFQs Chart
    if ($('#totalRFQsChart').length > 0) {
        const totalRFQsChart = document.getElementById('totalRFQsChart');
        const ctx = totalRFQsChart.getContext('2d');

        // Declare variables in outer scope
        let cutoutVal = '18%';
        let fontVal = "bold 18px Arial";

        if ($(window).width() >= 1920) {
            cutoutVal = '25%';
            fontVal = "bold 24px Arial";
        }

        // Keep chart square
        function resizeChart() {
            let parentWidth = totalRFQsChart.parentElement.parentElement.offsetWidth;

            totalRFQsChart.style.maxWidth = (parentWidth * 0.5) + 'px';
            totalRFQsChart.style.maxHeight = (parentWidth * 0.5) + 'px';
        }

        window.addEventListener('resize', resizeChart);
        resizeChart();

        new Chart(ctx, {
            type: 'doughnut',
            data: {
                datasets: [
                    {
                        label: "Commercial Bids",
                        data: [commercialSize,commercialSize1],
                        backgroundColor: ["#00C49F", "transparent"],
                        borderWidth: 8,
                        borderRadius: 10,
                        circumference: 360,
                        rotation: 0
                    },
                    {
                        label: "Receive Bids",
                        data: [receiveSize,receiveSize1],
                        backgroundColor: ["#FFBB28", "transparent"],
                        borderWidth: 8,
                        borderRadius: 10,
                        circumference: 360,
                        rotation: 0
                    },
                    {
                        label: "Technical Bids",
                        data: [technicalSize,technicalSize1],
                        backgroundColor: ["#0088FE", "transparent"],
                        borderWidth: 8,
                        borderRadius: 10,
                        circumference: 360,
                        rotation: 0
                    },
                    {
                        label: "Final Price Bid Approve",
                        data: [40, 60],
                        backgroundColor: ["#FF69B4", "transparent"],
                        borderWidth: 8,
                        borderRadius: 10,
                        circumference: 360,
                        rotation: 0
                    },
                    {
                        label: "Closed RFQ",
                        data: [closedSize,closedSize1],
                        backgroundColor: ["#FFB7CE", "transparent"],
                        borderWidth: 8,
                        borderRadius: 10,
                        circumference: 360,
                        rotation: 0
                    },
                  
                ]
            },
            options: {
                cutout: cutoutVal, // inner hole
                plugins: {
                    tooltip: {
                        callbacks: {
                            label: function (context) {
                                const ds = context.dataset;
                                return `${ds.label}: ${ds.data[0]}%`;
                            }
                        }
                    }
                }
            },
            plugins: [{
                id: 'centerText',
                afterDraw(chart) {
                    const { ctx, chartArea: { width, height } } = chart;
                    ctx.save();
                    ctx.font = fontVal;
                    ctx.fillStyle = "#000";
                    ctx.textAlign = "center";
                    ctx.textBaseline = "middle";
                    ctx.fillText(totalRfqSize, width / 2, height / 2);
                }
            }]
        });
    }
})