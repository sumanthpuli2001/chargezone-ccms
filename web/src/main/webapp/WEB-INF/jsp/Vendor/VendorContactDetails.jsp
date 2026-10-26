<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Vendor Information</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <!--        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">-->

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">

        <!--        <style>
                    .labelDiv {
                        width: 120px;
                    }
                </style>-->
        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }

        </style>
        <!--        <style>
                    element.style {
                        left: 0px !important;
                        top: 0px !important;
                        overflow: hidden !important;
                        margin: 0px !important;
                        padding: 0px !important;
                        height: 442px !important;
                        width: 1349px !important;
                        z-index: -999999 !important;
                        position: fixed !important;
                        margin-top: -50px !important;
                    }
                </style>-->
        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper container-fluid" style="min-height: 720px;">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Vendor Information</h1>
                <!--            <ol class="breadcrumb">
                                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                                <li class="active">Vendor Information</li>
                            </ol>-->
            </section>

            <!-- Main content -->
            <section class="content">

                <div class="row">
                    <div class="col-md-12">

                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">

                            <div class="tab-content">

                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" style="padding: 0px" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty faliureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" style="padding: 0px" role="alert">${faliureMessage}</div>
                                </c:if>
                                <!--<div class="form-bottom contact-form">-->

                                <form:form action="vendorInformation.htm?act=generalTradersDetails" method="post" enctype="multipart/form-data" commandName="vendorInformation"
                                           class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Company Name :</label>
                                        </div>
                                        <div class="col-sm-3"><h5>${vendorInformation.companyName}</h5>
                                                <form:input type="hidden" path="companyName" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Email ID :</label>
                                        </div>
                                        <div class="col-sm-3"><h5>${vendorInformation.vendorEmailId}</h5>
                                                <form:input type="hidden" path="vendorEmailId" class="form-control"   maxlength="30" required="required"/>
                                        </div>
                                    </div>
                                    <br>
                                    <center><h2><b>Vendor Contract Details</b></h2></center>
                                    <br>

                                    <div class="form-group">
                                         <div class="col-sm-3">
                                            <label class="control-label">Vendor Contract Details <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="abc" id="abc" class="form-control"   maxlength="100" />
                                        </div>

                                    </div>

                                    <div class="form-group">
                                         <div class="col-sm-3">
                                            <label class="control-label">Vendor Contract Details <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="abc" id="abc" class="form-control"   maxlength="100" />
                                        </div>

                                    </div>


                                    <div class="form-group">
                                         <div class="col-sm-3">
                                            <label class="control-label">Vendor Contract Details <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="abc" id="abc" class="form-control"   maxlength="100" />
                                        </div>

                                    </div>

                                    <div class="form-group">
                                         <div class="col-sm-3">
                                            <label class="control-label">Vendor Contract Details <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="abc" id="abc" class="form-control"   maxlength="100" />
                                        </div>

                                    </div>
                                    
                                     <div class="form-group">
                                          <div class="col-sm-3">
                                            <label class="control-label">Vendor Contract Details <span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="text" name="abc" id="abc" class="form-control"   maxlength="100" />
                                        </div>

                                    </div>

                                    <div class="form-group">


                                    </div>


                                    <div class="form-group">


                                    </div>

                                    <div class="form-group">


                                    </div>
                                    
                                     <div class="form-group">


                                    </div>

                                    <div class="form-group">


                                    </div>


                                    


                                    
                                    
                                     


                                   


                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn1" id="submit1" title="submit1" value="SAVE AND NEXT" >
                                        </div>
                                    </div>

                                </form:form>

                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->

            </section><!-- /.content -->
        </div>
        <script language="javascript">
            populateCountries("country", "state", "city1");


        </script> 

        <script>
            // Define a JavaScript object to hold the cities data
            var citiesByState = {
                "Andaman and Nicobar Islands - 35": [
                    "Select City",
                    "Port Blair",
                    "Diglipur",
                    "Mayabunder",
                    "Rangat",
                    "Hut Bay (Little Andaman)",
                    "Car Nicobar",
                    "Campbell Bay (Great Nicobar)",
                    "Wandoor",
                    "Garacharma",
                    "Malacca (Malakka)"
                ],
                "Andhra Pradesh - 28": [
                    "Select City",
                    "Adilabad",
                    "Anantapur",
                    "Chittoor",
                    "Kakinada",
                    "Guntur",
                    "Hyderabad",
                    "Karimnagar",
                    "Khammam",
                    "Krishna",
                    "Kurnool",
                    "Mahbubnagar",
                    "Medak",
                    "Nalgonda",
                    "Nizamabad",
                    "Ongole",
                    "Hyderabad",
                    "Srikakulam",
                    "Nellore",
                    "Visakhapatnam",
                    "Vizianagaram",
                    "Warangal",
                    "Eluru",
                    "Kadapa"
                ],
                "Arunachal Pradesh - 12": [
                    "Select City",
                    "Anjaw",
                    "Changlang",
                    "East Siang",
                    "Kurung Kumey",
                    "Lohit",
                    "Lower Dibang Valley",
                    "Lower Subansiri",
                    "Papum Pare",
                    "Tawang",
                    "Tirap",
                    "Dibang Valley",
                    "Upper Siang",
                    "Upper Subansiri",
                    "West Kameng",
                    "West Siang"
                ],
                "Assam - 18": [
                    "Select City",
                    "Baksa", "Barpeta", "Bongaigaon", "Cachar", "Chirang", "Darrang", "Dhemaji",
                    "Dima Hasao", "Dhubri", "Dibrugarh", "Goalpara", "Golaghat", "Hailakandi",
                    "Jorhat", "Kamrup", "Kamrup Metropolitan", "Karbi Anglong", "Karimganj",
                    "Kokrajhar", "Lakhimpur", "Marigaon", "Nagaon", "Nalbari", "Sibsagar",
                    "Sonitpur", "Tinsukia", "Udalguri"
                ],
                "Bihar - 10": [
                    "Select City",
                    "Araria", "Arwal", "Aurangabad", "Banka", "Begusarai", "Bhagalpur", "Bhojpur",
                    "Buxar", "Darbhanga", "East Champaran", "Gaya", "Gopalganj", "Jamui", "Jehanabad",
                    "Kaimur", "Katihar", "Khagaria", "Kishanganj", "Lakhisarai", "Madhepura",
                    "Madhubani", "Munger", "Muzaffarpur", "Nalanda", "Nawada", "Patna", "Purnia",
                    "Rohtas", "Saharsa", "Samastipur", "Saran", "Sheikhpura", "Sheohar", "Sitamarhi",
                    "Siwan", "Supaul", "Vaishali", "West Champaran", "Chandigarh"
                ],
                "Chhattisgarh - 22": [
                    "Select City",
                    "Bastar", "Bijapur", "Bilaspur", "Dantewada", "Dhamtari", "Durg", "Jashpur",
                    "Janjgir-Champa", "Korba", "Koriya", "Kanker", "Kabirdham (Kawardha)",
                    "Mahasamund", "Narayanpur", "Raigarh", "Rajnandgaon", "Raipur", "Surguja"
                ],
                "Dadra and Nagar Haveli - 26": [
                    "Select City",
                    "Dadra and Nagar Haveli"
                ],
                "Daman and Diu - 26": [
                    "Select City",
                    "Daman", "Diu"
                ],
                "Chandigarh - 4": [
                    "Select City",
                    "Atawa", "Atawa Choa", "Badheri", "Bahlana", "Bahlolpur", "Bajwara", "Bijwari Bakhta",
                    "Burail", "Buterla", "Chandigarh", "Dadu Majra", "Dariya", "Dhanas", "Dhanauran", "Fatehgarh",
                    "Gurudwara", "Hala Majra", "Jhampur", "Kaimbwala", "Kanji Maira", "Kansil", "Kanthara",
                    "Khoda Jassu", "Kujheri", "Kursan", "Madanpur", "Mahla Majra", "Malak", "Mariwala Town",
                    "Mastgarh", "Moloia", "Palsaura", "Purnapani", "Raipur", "Raj Bhavan Haryana", "Raj Bhavan Punjab",
                    "Sadoriaja Goth", "Saini Majra", "Sangariwala", "Sarangpur", "Shahpur Cholian", "Shahzadpur",
                    "Togan"
                ],
                "Delhi - 7": [
                    "Select City",
                    "Central Delhi", "East Delhi", "New Delhi", "North Delhi", "North East Delhi",
                    "North West Delhi", "South Delhi", "South West Delhi", "West Delhi"
                ],
                "Goa - 30": [
                    "Select City",
                    "North Goa", "South Goa"
                ],
                "Gujarat - 24": [
                    "Select City",
                    "Ahmedabad", "Amreli district", "Anand", "Banaskantha", "Bharuch", "Bhavnagar",
                    "Dahod", "The Dangs", "Gandhinagar", "Jamnagar", "Junagadh", "Kutch", "Kheda",
                    "Mehsana", "Narmada", "Navsari", "Patan", "Panchmahal", "Porbandar", "Rajkot",
                    "Sabarkantha", "Surendranagar", "Surat", "Vyara", "Vadodara", "Valsad"
                ],
                "Haryana - 6": [
                    "Select City",
                    "Ambala", "Bhiwani", "Faridabad", "Fatehabad", "Gurgaon", "Hissar", "Jhajjar",
                    "Jind", "Karnal", "Kaithal", "Kurukshetra", "Mahendragarh", "Mewat", "Palwal",
                    "Panchkula", "Panipat", "Rewari", "Rohtak", "Sirsa", "Sonipat", "Yamuna Nagar"
                ],
                "Himachal Pradesh - 2": [
                    "Select City",
                    "Bilaspur", "Chamba", "Hamirpur", "Kangra", "Kinnaur", "Kullu", "Lahaul and Spiti",
                    "Mandi", "Shimla", "Sirmaur", "Solan", "Una"
                ],
                "Jammu and Kashmir - 1": [
                    "Select City",
                    "Anantnag", "Badgam", "Bandipora", "Baramulla", "Doda", "Ganderbal", "Jammu",
                    "Kargil", "Kathua", "Kishtwar", "Kupwara", "Kulgam", "Leh", "Poonch", "Pulwama",
                    "Rajauri", "Ramban", "Reasi", "Samba", "Shopian", "Srinagar", "Udhampur"
                ],
                "Jharkhand - 20": [
                    "Select City",
                    "Bokaro", "Chatra", "Deoghar", "Dhanbad", "Dumka", "East Singhbhum", "Garhwa",
                    "Giridih", "Godda", "Gumla", "Hazaribag", "Jamtara", "Khunti", "Koderma",
                    "Latehar", "Lohardaga", "Pakur", "Palamu", "Ramgarh", "Ranchi", "Sahibganj",
                    "Seraikela Kharsawan", "Simdega", "West Singhbhum"
                ],
                "Karnataka - 29": [
                    "Select City",
                    "Bagalkot", "Bangalore Rural", "Bangalore Urban", "Belgaum", "Bellary", "Bidar",
                    "Bijapur", "Chamarajnagar", "Chikkamagaluru", "Chikkaballapur", "Chitradurga",
                    "Davanagere", "Dharwad", "Dakshina Kannada", "Gadag", "Gulbarga", "Hassan",
                    "Haveri district", "Kodagu", "Kolar", "Koppal", "Mandya", "Mysore", "Raichur",
                    "Shimoga", "Tumkur", "Udupi", "Uttara Kannada", "Ramanagara", "Yadgir"
                ],
                "Kerala - 32": [
                    "Select City",
                    "Alappuzha", "Ernakulam", "Idukki", "Kannur", "Kasaragod", "Kollam", "Kottayam",
                    "Kozhikode", "Malappuram", "Palakkad", "Pathanamthitta", "Thrissur",
                    "Thiruvananthapuram", "Wayanad"
                ],
                "Madhya Pradesh - 23": [
                    "Select City",
                    "Alirajpur", "Anuppur", "Ashok Nagar", "Balaghat", "Barwani", "Betul", "Bhind",
                    "Bhopal", "Burhanpur", "Chhatarpur", "Chhindwara", "Damoh", "Datia", "Dewas",
                    "Dhar", "Dindori", "Guna", "Gwalior", "Harda", "Hoshangabad", "Indore",
                    "Jabalpur", "Jhabua", "Katni", "Khandwa (East Nimar)", "Khargone (West Nimar)",
                    "Mandla", "Mandsaur", "Morena", "Narsinghpur", "Neemuch", "Panna", "Rewa",
                    "Rajgarh", "Ratlam", "Raisen", "Sagar", "Satna", "Sehore", "Seoni", "Shahdol",
                    "Shajapur", "Sheopur", "Shivpuri", "Sidhi", "Singrauli", "Tikamgarh", "Ujjain",
                    "Umaria", "Vidisha"
                ],
                "Maharashtra - 27": [
                    "Select City",
                    "Ahmednagar", "Akola", "Amravati", "Aurangabad", "Bhandara", "Beed", "Buldhana",
                    "Chandrapur", "Dhule", "Gadchiroli", "Gondia", "Hingoli", "Jalgaon", "Jalna",
                    "Kolhapur", "Latur", "Mumbai City", "Mumbai suburban", "Nandurbar", "Nanded",
                    "Nagpur", "Nashik", "Osmanabad", "Parbhani", "Pune", "Raigad", "Ratnagiri",
                    "Sindhudurg", "Sangli", "Solapur", "Satara", "Thane", "Wardha", "Washim", "Yavatmal"
                ],
                "Manipur - 14": [
                    "Select City",
                    "Bishnupur", "Churachandpur", "Chandel", "Imphal East", "Senapati", "Tamenglong",
                    "Thoubal", "Ukhrul", "Imphal West"
                ],
                "Meghalaya - 17": [
                    "Select City",
                    "East Garo Hills", "East Khasi Hills", "Jaintia Hills", "Ri Bhoi", "South Garo Hills",
                    "West Garo Hills", "West Khasi Hills"
                ],
                "Mizoram - 15": [
                    "Select City",
                    "Aizawl", "Champhai", "Kolasib", "Lawngtlai", "Lunglei", "Mamit", "Saiha", "Serchhip"
                ],
                "Lakshadweep - 31": [
                    "Select City",
                    "Andrott",
                    "Amini",
                    "Agatti",
                    "Kadmat",
                    "Kavaratti",
                    "Kalpeni",
                    "Chetlat",
                    "Bitra",
                    "Kiltan",
                    "Minicoy"
                ],
                "Nagaland - 13": [
                    "Select City",
                    "Dimapur", "Kohima", "Mokokchung", "Mon", "Phek", "Tuensang", "Wokha", "Zunheboto"
                ],
                "Orissa - 21": [
                    "Select City",
                    "Angul", "Boudh (Bauda)", "Bhadrak", "Balangir", "Bargarh (Baragarh)", "Balasore",
                    "Cuttack", "Debagarh (Deogarh)", "Dhenkanal", "Ganjam", "Gajapati", "Jharsuguda",
                    "Jajpur", "Jagatsinghpur", "Khordha", "Kendujhar (Keonjhar)", "Kalahandi", "Kandhamal",
                    "Koraput", "Kendrapara", "Malkangiri", "Mayurbhanj", "Nabarangpur", "Nuapada", "Nayagarh",
                    "Puri", "Rayagada", "Sambalpur", "Subarnapur (Sonepur)", "Sundergarh"
                ],
                "Pondicherry - 34": [
                    "Select City",
                    "Karaikal", "Mahe", "Pondicherry", "Yanam"
                ],
                "Punjab - 3": [
                    "Select City",
                    "Amritsar", "Barnala", "Bathinda", "Firozpur", "Faridkot", "Fatehgarh Sahib", "Fazilka",
                    "Gurdaspur", "Hoshiarpur", "Jalandhar", "Kapurthala", "Ludhiana", "Mansa", "Moga",
                    "Sri Muktsar Sahib", "Pathankot", "Patiala", "Rupnagar", "Ajitgarh (Mohali)", "Sangrur",
                    "Nawanshahr", "Tarn Taran"
                ],
                "Rajasthan - 8": [
                    "Select City",
                    "Ajmer", "Alwar", "Bikaner", "Barmer", "Banswara", "Bharatpur", "Baran", "Bundi",
                    "Bhilwara", "Churu", "Chittorgarh", "Dausa", "Dholpur", "Dungapur", "Ganganagar",
                    "Hanumangarh", "Jhunjhunu", "Jalore", "Jodhpur", "Jaipur", "Jaisalmer", "Jhalawar",
                    "Karauli", "Kota", "Nagaur", "Pali", "Pratapgarh", "Rajsamand", "Sikar", "Sawai Madhopur",
                    "Sirohi", "Tonk", "Udaipur"
                ], "Sikkim - 11": [
                    "Select City",
                    "East Sikkim", "North Sikkim", "South Sikkim", "West Sikkim"
                ],
                "Tamil Nadu - 33": [
                    "Select City",
                    "Ariyalur", "Chennai", "Coimbatore", "Cuddalore", "Dharmapuri", "Dindigul", "Erode",
                    "Kanchipuram", "Kanyakumari", "Karur", "Madurai", "Nagapattinam", "Nilgiris", "Namakkal",
                    "Perambalur", "Pudukkottai", "Ramanathapuram", "Salem", "Sivaganga", "Tirupur",
                    "Tiruchirappalli", "Theni", "Tirunelveli", "Thanjavur", "Thoothukudi", "Tiruvallur",
                    "Tiruvarur", "Tiruvannamalai", "Vellore", "Viluppuram", "Virudhunagar"
                ],
                "Tripura - 16": [
                    "Select City",
                    "Dhalai", "North Tripura", "South Tripura", "Khowai", "West Tripura"
                ],
                "Uttar Pradesh - 9": [
                    "Select City",
                    "Agra", "Allahabad", "Aligarh", "Ambedkar Nagar", "Auraiya", "Azamgarh", "Barabanki",
                    "Budaun", "Bagpat", "Bahraich", "Bijnor", "Ballia", "Banda", "Balrampur", "Bareilly",
                    "Basti", "Bulandshahr", "Chandauli", "Chhatrapati Shahuji Maharaj Nagar", "Chitrakoot",
                    "Deoria", "Etah", "Kanshi Ram Nagar", "Etawah", "Firozabad", "Farrukhabad", "Fatehpur",
                    "Faizabad", "Gautam Buddh Nagar", "Gonda", "Ghazipur", "Gorakhpur", "Ghaziabad", "Hamirpur",
                    "Hardoi", "Mahamaya Nagar", "Jhansi", "Jalaun", "Jyotiba Phule Nagar", "Jaunpur district",
                    "Ramabai Nagar (Kanpur Dehat)", "Kannauj", "Kanpur", "Kaushambi", "Kushinagar", "Lalitpur",
                    "Lakhimpur Kheri", "Lucknow", "Mau", "Meerut", "Maharajganj", "Mahoba", "Mirzapur",
                    "Moradabad", "Mainpuri", "Mathura", "Muzaffarnagar", "Panchsheel Nagar district (Hapur)",
                    "Pilibhit", "Shamli", "Pratapgarh", "Rampur", "Raebareli", "Saharanpur", "Sitapur",
                    "Shahjahanpur", "Sant Kabir Nagar", "Siddharthnagar", "Sonbhadra", "Sant Ravidas Nagar",
                    "Sultanpur", "Shravasti", "Unnao", "Varanasi"
                ],
                "Uttaranchal - 5": [
                    "Select City",
                    "Almora", "Bageshwar", "Chamoli", "Champawat", "Dehradun", "Haridwar", "Nainital",
                    "Pauri Garhwal", "Pithoragarh", "Rudraprayag", "Tehri Garhwal", "Udham Singh Nagar", "Uttarkashi"
                ],
                "West Bengal - 19": [
                    "Select City",
                    "Birbhum", "Bankura", "Bardhaman", "Darjeeling", "Dakshin Dinajpur", "Hooghly", "Howrah",
                    "Jalpaiguri", "Cooch Behar", "Kolkata", "Maldah", "Paschim Medinipur", "Purba Medinipur",
                    "Murshidabad", "Nadia", "North 24 Parganas", "South 24 Parganas", "Purulia", "Uttar Dinajpur"
                ]




            };
            // Function to populate cities dropdown based on selected state
            function populateCities() {
                var stateSelect = document.getElementById("state");
                var citySelect = document.getElementById("city1");
                var selectedState = stateSelect.value;
                // Clear existing options
                citySelect.innerHTML = "";
                // Populate cities based on selected state
                citiesByState[selectedState].forEach(function (city) {
                    var option = document.createElement("option");
                    option.text = city;
                    option.value = city;
                    citySelect.add(option);
                });
            }

            // Attach an event listener to the state dropdown
            document.getElementById("state").addEventListener("change", populateCities);
            // Populate cities dropdown when the page loads
            populateCities();</script>





        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
        <!-- Javascript -->
        <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
        <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
        <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
        <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
        <script src="StorageYard/JS/login/scripts.js"></script>
        <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
        <script src="StorageYard/JS/countries.js" type="text/javascript"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>