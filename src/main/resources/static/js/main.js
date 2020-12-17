$(function(){
    $('#button-click').click(function() {
        $.ajax({
            method: "GET",
            url: '/click',
            success: function(response) {
                $('#count-click').text(response)
            }
        });
        return false;
    });
});