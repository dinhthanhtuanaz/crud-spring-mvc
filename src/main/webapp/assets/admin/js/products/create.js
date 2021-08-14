$(document).ready(function() {
	$('#userform').submit(function (e) { 
        e.preventDefault();
        console.log(1);
        $("form#userform :input").each(function(){
            var input = $(this); // This is the jquery object of the input, do what you will
            console.log('input: ', input.val());
        });

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/hello-world/admin/products/submituser",
            data: {},
            dataType: "jsonp",
            success: function (response) {
                console.log('r:', response);
            }
        })
            .done(msg => {
                console.log('done:', msg);
            })
            .fail(msg => {
                console.log('done:', msg);
            })
        ;
    });
	
    function changeAmountTableStructure(_this, action = 'ADD') {
        const parentTr = _this.parents('tr');
        const parentTbody = _this.parents('tbody');
        const firstTd = parentTbody.find('td[rowspan]');
        const rowSpan = parseInt(firstTd.attr('rowspan'));

        const selectTag = $('.size-list-wrapper').html();
        let newRow = `<tr>
                        <td class="size-list-wrapper">${selectTag}</td>
                        <td class="amount-wrapper">
                            <div class="last-column">
                                <input type="number" class="form-control">
                                <button class="btn btn-primary btn-add-size" type="button">+</button>
                            </div>
                        </td></tr>`;
        if (action === 'ADD') {
            firstTd.attr('rowspan', rowSpan+1);
            parentTbody.append(newRow);
            console.log("ADD___");
            if (parentTr.is(':first-child')) {
                _this.attr('class', 'btn btn-success btn-copy-price');
                _this.html('<i class="fas fa-sort-amount-down"></i>');
                return;
            }
            _this.attr('class', 'btn btn-danger btn-remove-size');
            _this.html('<i class="fas fa-minus"></i>');
        } else {
            console.log("REMOVE___");
            firstTd.attr('rowspan', rowSpan-1);
            parentTr.remove();
        }
    }

    $(document).on('click', ".btn-add-size", function () {
        changeAmountTableStructure($(this));
    });
    
    $(document).on('click', ".btn-remove-size", function () {
        changeAmountTableStructure($(this), 'REMOVE');
    });
});
