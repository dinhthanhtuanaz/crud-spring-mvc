$(document).ready(function() {
    $('.btn-delete-question').click(function (e) { 
        e.preventDefault();
        let id = $(this).attr('data-id');
        let url = $(this).attr('data-url');
        $('.btn-delete-agree').attr('data-id', id);
        $('.btn-delete-agree').attr('data-url', url);
    });

    $('.btn-delete-agree').click(function (e) {
        let _this = $(this);
        $.ajax({
            type: "DELETE",
            url: _this.attr('data-url'),
            contentType: "application/json",
            dataType: 'json',
            success: function(response){
                location.reload();
            },
            error: function (e) {
                console.log('error: ', e);
            }
          });
    });
});