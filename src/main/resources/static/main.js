/* THIS DOCUMENT CANT BE FOUND FOR SOME REASON?? Static.js missing ? had to make my own static directory
<script type="text/javascript">
    $( document ).ready(function() {
        console.log( "document loaded" );
    });
    $(document).ready(function () {
        checkJQuery();
        $("#search-form").submit(function (event) {

            //stop submit the form, we will post it manually.
            event.preventDefault();
            console.log("search button clicked")
            fire_ajax_submit();
        });

        $("#add-form").submit(function (event){

            //stop submit the form, we will post it manually.
            event.preventDefault();
            console.log("ADD button clicked")
            add_user();
        })
    });

    function fire_ajax_submit() {

        var search = {}
        search["name"] = $("#name").val();
        //search["email"] = $("#email").val();

        $("#btn-search").prop("disabled", true);

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/search",
            data: JSON.stringify(search),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);

                console.log("SUCCESS : ", data);
                $("#btn-search").prop("disabled", false);

            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);

                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });

    }
    function add_user() {

        var input = {}
        input["name"] = $("#stud-name").val();
        input["email"] = $("#stud-email").val();
        input["supervisor"] = $("#supervisor-id").val();

        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/api/addStudent",
            data: JSON.stringify(input),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#allStudentsAjax').html(json);
                all_students();

                console.log("SUCCESS : ", data);

            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#allStudentsAjax').html(json);
                console.log("ERROR : ", e);
                $("#btn-search").prop("disabled", false);

            }
        });
    }

    function checkJQuery(){
        if (typeof jQuery != undefined){
            console.log("jQuery loaded")
        }
        else(console.log("jQuery NOT loaded"))
    }

    function all_students(){
        console.log("all Students called");
        $.ajax({
            url:"api/allStudents",
            type:"POST",
            contentType:"application/JSON",
            success: function (data) {
                $.each(data.student, function (index, value) {
                    $("#allStudents").append("<div>" + value.name + value.email + "</div>")
                })
            },
            error: function (e) {

                var json = "<h4>Ajax Response</h4><pre>"
                    + e.responseText + "</pre>";
                $('#allStudentsAjax').html(json);
                console.log("ERROR : ", e);

            }
        })
    }
</script>
*/
